package annotators;
import java.util.regex.Matcher;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import type.Performance;
import type.Question;
import type.Scoring;
import type.TestElementAnnotation;
import type.TokenAnnotation;

public class PerformanceAnnotator extends JCasAnnotator_ImplBase  {
	@Override
	  public void process(JCas jcas) throws AnalysisEngineProcessException {
		System.out.println(">> Performance Annotator Processing");
		
		//Produce one performance for each test element
		FSIndex<Scoring> teIndex = (FSIndex) jcas.getAnnotationIndex(Scoring.type);

		for(Scoring score : teIndex)
		{
			Question question = (Question) score.getOrig();
			Performance performance = new Performance(jcas);
			performance.setTestElement((TestElementAnnotation) score.getOrig());
			performance.setBegin(question.getBegin());
			performance.setEnd(question.getEnd());
			performance.setPAt1(0);
			performance.setPAt5(0);
			performance.setMr(0);
			performance.setAp(0);
			performance.setComponentId(this.getClass().getName());
			performance.addToIndexes();
		}		
	  }
}
