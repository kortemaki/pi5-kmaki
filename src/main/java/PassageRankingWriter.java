import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import type.Performance;
import type.Question;

/**
 * This CAS Consumer generates the report file with the method metrics
 */
public class PassageRankingWriter extends CasConsumer_ImplBase {
  final String PARAM_OUTPUTDIR = "OutputDir";
  final String OUTPUT_FILENAME = "RankingMetrics.csv";
  File mOutputDir;
  File outputFile;
  PrintWriter writer;
  
  
  @Override
  public void initialize() throws ResourceInitializationException {
    String mOutputDirStr = (String) getConfigParameterValue(PARAM_OUTPUTDIR);
    if(mOutputDirStr != null) {
      mOutputDir = new File(mOutputDirStr);
      if (!mOutputDir.exists()) {
        mOutputDir.mkdirs();
      }
      
      try {
          outputFile = new File(Paths.get(mOutputDir.getAbsolutePath(), 
                                    OUTPUT_FILENAME).toString());
          outputFile.getParentFile().mkdirs();
          writer = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
          System.out.printf("Output file could not be written: %s\n", 
                  Paths.get(mOutputDir.getAbsolutePath(), 
                            OUTPUT_FILENAME).toString());
          return;
        }
        
        writer.println("question_id,p_at_1,p_at_5,rr,ap");
      
    }
  }
  
  public void processCas(CAS arg0) throws ResourceProcessException {
  //Import the CAS as a JCAS
    JCas jcas = null;
    try {
      jcas = arg0.getJCas();

      // Retrieve all the questions for printout
      //TODO: Sort the question in ascending order according to their ID (???)
      FSIterator it = jcas.getAnnotationIndex(Performance.type).iterator();
      
      while (it.hasNext()) {
        Performance performance = (Performance)it.next();
        
        Question question = performance.getTestElement().getQuestion();
        
        System.out.println("Processing performance output for question "+ question.getId());
        
        writer.printf("%s,%.3f,%.3f,%.3f,%.3f\n",
                question.getId(), 
                performance.getPAt1(),
                performance.getPAt5(),
                performance.getRr(),
                performance.getAp());
      
      }
      
    } catch (CASException e) {
      try {
        throw new CollectionException(e);
      } catch (CollectionException e1) {
        e1.printStackTrace();
      }
    }
  }
  
  public void destroy()
  {
	  if(this.writer != null)
	      writer.close();
  }
  
}
