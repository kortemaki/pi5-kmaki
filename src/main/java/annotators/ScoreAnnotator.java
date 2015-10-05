/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package annotators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import type.Ngram;
import type.NgramAnnotation;
import type.NgramSet;
import type.ScoredSpan;
import type.Scoring;
import type.Span;
import type.TokenizedSpan;

/**
 * A simple scoring annotator for PI3.
 * 
 * Expects each CAS to contain at least one NgramAnnotation.
 * Processes each NgramAnnotation by adding a corresponding AnswerScoringAnnotation to the CAS.
 * 
 * This annotator has no parameters and requires no initialization method.
 */

public class ScoreAnnotator extends CasAnnotator_ImplBase {	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
		
		// Get the Ngram Annotations for each Test Element in the document
		FSIndex<NgramAnnotation> ngramIndex = (FSIndex) jcas.getAnnotationIndex(NgramAnnotation.type);

		// Iterate over them in sequence
		for(NgramAnnotation ngramAnnot : ngramIndex)
		{			
			//////////////////////
			// Handle the question
			// Get the ngrams for this Test Element's question
			NgramSet questionNgrams = ngramAnnot.getQuestionNgrams();

			//////////////////////
			// Handle the answers
			// Create a list to hold our scoring for each answer choice
			Scoring output = new Scoring(jcas);
			output.setComponentId(this.getClass().getName());
			output.setBegin(Math.min(questionNgrams.getBegin(), getMinBegin(ngramAnnot.getPassageNgrams())));
			output.setEnd(Math.max(questionNgrams.getEnd(), getMaxEnd(ngramAnnot.getPassageNgrams())));
			
			/////////////////////
			// Score each passage
			FSList passages = ngramAnnot.getPassageNgrams();
			FSList scores = new EmptyFSList(jcas);
			while(!(passages instanceof EmptyFSList))
			{
				NgramSet passageNgrams = (NgramSet) ((NonEmptyFSList) passages).getHead();
				NonEmptyFSList next = new NonEmptyFSList(jcas);
				ScoredSpan score = new ScoredSpan(jcas);
				score.setBegin(passageNgrams.getBegin());
				score.setEnd(passageNgrams.getEnd());
				score.setText(passageNgrams.getText());
				score.setSpan(passageNgrams.getSpan());
				score.setPassage(passageNgrams.getPassage());
				score.setComponentId(this.getClass().getName());
				
				score.setScore(this.score(questionNgrams,passageNgrams));
				score.addToIndexes();
				next.setHead(score);
				next.setTail(scores);
				scores = next;
				passages = ((NonEmptyFSList) passages).getTail();
			}
			output.setScores(scores);
			output.setBegin(ngramAnnot.getBegin());
			output.setEnd(ngramAnnot.getEnd());
			output.setQuestion(ngramAnnot.getQuestion());
			output.setComponentId(this.getClass().getName());	
			output.addToIndexes();
		}
	}

	/**
	 * Auxiliary method to compute the smallest begin index of the Annotations in arr 
	 * @param arr the array of Annotations to look at
	 * @return the minimum begin index
	 */
	private int getMinBegin(FSList arr) {
		int min =  Integer.MAX_VALUE;
		while(!(arr instanceof EmptyFSList))
		{
			int begin = ((Annotation) ((NonEmptyFSList) arr).getHead()).getBegin();
			if(begin < min)
				min = begin;
			arr = ((NonEmptyFSList) arr).getTail();
		}
		return min;
	}

	/**
	 * Auxiliary method to compute the largest end index of the Annotations in arr 
	 * @param arr the array of Annotations to look at
	 * @return the maximum end index
	 */
	private int getMaxEnd(FSList arr) {
		int max = Integer.MIN_VALUE;
		while(!(arr instanceof EmptyFSList))
		{
			int end = ((Annotation) ((NonEmptyFSList) arr).getHead()).getBegin();
			if(end > max)
				max = end;
			arr = ((NonEmptyFSList) arr).getTail();
		}
		return max;
	}
	
	/**
	 * Scores the agreement between the two NgramSet params based on ngram overlap 
	 * 
	 * @return
	 */
	private Double score(NgramSet tokens1, NgramSet tokens2)
	{	
		return (double) tokenOverlap(tokens1.getNgrams(), tokens2.getNgrams());
	}
	
	private float tokenOverlap(FSArray tokens1, FSArray tokens2)
	{
		if(tokens1 == null || tokens2 == null)
			return 0;
		
		float count = 0;
		for(int i = 0; i < tokens1.size(); i++)
		{
			for(int j = 0; j < tokens2.size(); j++)
			{
				if(tokens1.get(i) != null && tokens2.get(j) != null
						&& sameNgram((Ngram) tokens1.get(i), (Ngram) tokens2.get(j)))
					count++;
			}
		}
		return count/(tokens1.size()*tokens2.size());
	}
	
	private boolean sameNgram(Ngram ngram1, Ngram ngram2)
	{
		if(ngram1.getN() != ngram2.getN())
			return false;
		for(int i = 0; i < ngram1.getN(); i++)
		{
			if(!((Span) ngram1.getTokens().get(i)).getText().equals(
			    ((Span) ngram2.getTokens().get(i)).getText()))
				return false;
		}
		return true;
	}
}
