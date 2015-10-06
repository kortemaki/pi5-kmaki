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
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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

import type.Passage;
import type.Question;
import type.Span;
import type.TestElementAnnotation;
import type.TokenAnnotation;
import type.TokenizedSpan;

/**
 * A simple tokenization annotator for PI3
 * 
 * Expects each CAS to contain at least one TestElementAnnotation
 * Processes each TestElementAnnotation by adding a corresponding TokenAnnotation
 * 
 * This annotator has no configuration parameters, and requires no initialization method
 */

public class TokenizationAnnotator extends CasAnnotator_ImplBase {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}

		// Get the Test Element Annotations for the document
		FSIndex<TestElementAnnotation> teIndex = (FSIndex) (jcas).getAnnotationIndex(TestElementAnnotation.type);

		// Iterate over them in sequence
		for(TestElementAnnotation te : teIndex)
		{
			// Create the TokenAnnotation for this test element
			TokenAnnotation annot = new TokenAnnotation(jcas); 
			Question question = te.getQuestion();
			annot.setQuestionTokens(this.tokenize(question,jcas));
			FSList passages = question.getPassages();
			FSList passtoks = new EmptyFSList(jcas);
			while(!(passages instanceof EmptyFSList))
			{
				Passage passage = (Passage) ((NonEmptyFSList) passages).getHead();
				NonEmptyFSList next = new NonEmptyFSList(jcas);
				TokenizedSpan tokenization = this.tokenize(passage,jcas);
				next.setHead(tokenization);
				next.setTail(passtoks);
				passtoks = next;
				passages = ((NonEmptyFSList) passages).getTail();
			}
			annot.setPassageTokens(passtoks);
			annot.setBegin(te.getBegin());
			annot.setEnd(te.getEnd());
			annot.setOrig(te);
			annot.setComponentId(this.getClass().getName());
			annot.addToIndexes();
		}
	}

	/**
	 * Tokenizes a given Span and returns the tokenization as a TokenizedSpan
	 * 
	 * @param span the span to tokenize
	 * @return
	 */
	private TokenizedSpan tokenize(Span span, JCas jcas)
	{
		// Extract relevant fields from span
		String text = span.getText();
		int begin = span.getBegin();
		int end = span.getEnd();
		
		// Tokenize the text
		int tokstart = 0;
		int tokend = 0;
		List<Span> toks = new LinkedList<Span>();
		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {
			String thisTok = st.nextToken();
			tokstart = text.indexOf(thisTok, tokend);
			tokend = tokstart + thisTok.length();
			Span tok = new Span(jcas);
			tok.setBegin(tokstart+begin);
			tok.setText(thisTok);
			tok.setEnd(tokend+begin);
			tok.setComponentId(this.getClass().getName());
			tok.addToIndexes();
			toks.add(tok);
		}
		
		// Finalize tokenized span output
		FSArray tokens = new FSArray(jcas,toks.size());
		for(int i=0;i<toks.size();i++)
		{
			tokens.set(i, toks.get(i));
		}
		
		TokenizedSpan output = new TokenizedSpan(jcas);
		output.setTokens(tokens);
		output.setBegin(begin);
		output.setText(text);
		output.setEnd(end);
		output.setOrig(span);
		output.setComponentId(this.getClass().getName());
		output.addToIndexes();
		return output;
	}
	
}
