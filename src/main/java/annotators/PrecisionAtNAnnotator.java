package annotators;
import java.util.regex.Matcher;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import type.Performance;
import type.Question;

public class PrecisionAtNAnnotator extends JCasAnnotator_ImplBase  {
	@Override
	  public void process(JCas aJCas) throws AnalysisEngineProcessException {
		System.out.println(">> Question Annotator Processing");
	    // get document text from the CAS
	    String docText = aJCas.getDocumentText();
	    
	    // search for all the questions in the text
	    Matcher matcher = null;
	    int pos = 0;    
	    while (matcher.find(pos)) {
	      // found one - create annotation
	      Question annotation = new Question(aJCas);
	      annotation.setBegin(matcher.start());
	      annotation.setEnd(matcher.end());
	      annotation.setId(matcher.group(1));
	      annotation.setSentence(matcher.group(2));
	      //Add empty performance
	      annotation.setPerformance(new Performance(aJCas));
	      annotation.addToIndexes();
	      pos = matcher.end();
	      System.out.printf("Added Q: %s - %s\n", matcher.group(1), matcher.group(2));
	    }
	  }

}
