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

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.resource.ResourceInitializationException;

import type.Ngram;
import type.NgramAnnotation;
import type.NgramSet;
import type.Span;
import type.TokenAnnotation;
import type.TokenizedSpan;

/**
 * A simple ngram annotator for PI3.
 * 
 * Expects each CAS to contain at least one TokenAnnotation.
 * Processes each TokenAnnotation by adding a corresponding TokenAnnotation to the CAS.
 * 
 * This annotator has a single configuration parameters, NgramSize,
 *    that configures the length of ngrams to be annotated.
 */

public class NgramAnnotator extends CasAnnotator_ImplBase {
	
	private int n = 3;
	
	private final String NAME = this.getClass().getName();
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException
	{
		super.initialize(aContext);
		this.n = (Integer) aContext.getConfigParameterValue("NgramSize");
		if(this.n <= 0)
		{
			Object[] args = new Object[1];
			args[0] = this.n;
			throw new ResourceInitializationException("Cannot instantiate Ngram Annotator with given n",args);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
		
		// Get the Token Annotations for each Test Element in the document
		FSIndex<TokenAnnotation> teIndex = (FSIndex) jcas.getAnnotationIndex(TokenAnnotation.type);

		// Iterate over them in sequence
		for(TokenAnnotation te : teIndex)
		{
			// Create the TokenAnnotation for this test element
			NgramAnnotation annot = new NgramAnnotation(jcas); 
			TokenizedSpan question = te.getQuestionTokens();
			annot.setQuestionNgrams(this.ngramize(question,jcas));
			FSList passages = te.getPassageTokens();
			FSList passagesNgrams = new EmptyFSList(jcas);
			while(!(passages instanceof EmptyFSList))
			{
				TokenizedSpan passage = (TokenizedSpan) ((NonEmptyFSList) passages).getHead();
				NonEmptyFSList next = new NonEmptyFSList(jcas);
				NgramSet ngrams = this.ngramize(passage,jcas);
				ngrams.setOrig(passage.getOrig());
				next.setHead(ngrams);
				next.setTail(passagesNgrams);				
				passagesNgrams = next;
				passages = ((NonEmptyFSList) passages).getTail();
			}
			annot.setPassageNgrams(passagesNgrams);
			annot.setBegin(te.getBegin());
			annot.setEnd(te.getEnd());
			annot.setOrig(te.getOrig());
			annot.setComponentId(NAME);
			annot.addToIndexes();
		}
	}

	/**
	 * Ngramizes the tokens of a given TokenizedSpan and returns the ngrams as an NgramSet
	 * 
	 * @param span the span to tokenize
	 * @return
	 */
	private NgramSet ngramize(TokenizedSpan tokens, JCas jcas)
	{
		
		// Extract relevant fields from span
		int begin = tokens.getBegin();
		int end = tokens.getEnd();
		
		NgramSet ngrams = new NgramSet(jcas);
		ngrams.setBegin(begin);
		ngrams.setEnd(end);
		ngrams.setText(tokens.getText());
		ngrams.setOrig(tokens.getOrig());
		ngrams.setComponentId(NAME);
		
		//Populate the ngram annotations
		FSArray toks = tokens.getTokens();
		int numNgrams = toks.size()+1-this.n;
		
		if(numNgrams > 0)
		{
			ngrams.setNgrams(new FSArray(jcas, numNgrams));
			for(int i=0; i<numNgrams; i++)
			{
				//copy the relevant tokens into ngram
				FSArray fstokens = new FSArray(jcas,this.n);
				String[] strings = new String[this.n];
				for(int j=0; j<this.n; j++)
				{
					fstokens.set(j, toks.get(i+j));
					strings[j] = ((Span)toks.get(i+j)).getText();
				}

				Ngram ngram = new Ngram(jcas);
				ngram.setN(this.n);
				ngram.setBegin(((Span) toks.get(i)).getBegin());
				ngram.setEnd(((Span) toks.get(i+this.n-1)).getEnd());
				ngram.setText(String.join(" ",strings));
				ngram.setTokens(fstokens);
				ngram.setComponentId(NAME);
				ngram.addToIndexes();
				ngrams.setNgrams(i,ngram);
			}
		}
		else
		{
			ngrams.setNgrams(null);
		}
		ngrams.addToIndexes();
		return ngrams;
		
	}
	
}
