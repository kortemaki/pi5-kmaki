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

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import type.OutputAnnotation;
import type.Performance;
import type.Question;

/**
 * A simple scoring annotator for PI3.
 * 
 * Expects each CAS to contain at least one NgramAnnotation.
 * Processes each NgramAnnotation by adding a corresponding AnswerScoringAnnotation to the CAS.
 * 
 * This annotator has no parameters and requires no initialization method.
 */

public class OutputAnnotator extends CasAnnotator_ImplBase {	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {
		
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
		
		// Get the Scoring Annotations for each Test Element in the document
		FSIndex<Performance> performanceIndex = (FSIndex) (jcas.getAnnotationIndex(Performance.type));

		// Iterate over them in sequence
		for(Performance performance : performanceIndex)
		{				
	        Question question = performance.getTestElement().getQuestion();
	        
	        String text = String.format("%s,%.3f,%.3f,%.3f,%.3f",
	                question.getId(), 
	                performance.getPAt1(),
	                performance.getPAt5(),
	                performance.getRr(),
	                performance.getAp());	        
			
			OutputAnnotation output = new OutputAnnotation(jcas);
			output.setComponentId(this.getClass().getName());
			output.setBegin(performance.getBegin());
			output.setEnd(performance.getEnd());
			output.setOrig(performance.getTestElement());
			output.setText((performance.getTestElement()).getQuestion().getId());
			output.setOutput(text);
			output.addToIndexes();
		}
	}
}
