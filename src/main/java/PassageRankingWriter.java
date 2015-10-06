import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import type.OutputAnnotation;

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
  
  @SuppressWarnings("rawtypes")
public void processCas(CAS arg0) throws ResourceProcessException {
  //Import the CAS as a JCAS
    JCas jcas = null;
    try {
      jcas = arg0.getJCas();

      // Retrieve all the questions for printout
      //TODO: Sort the question in ascending order according to their ID (???)
      FSIterator it = jcas.getAnnotationIndex(OutputAnnotation.type).iterator();
      
      while (it.hasNext()) {
        OutputAnnotation output = (OutputAnnotation)it.next();
        
        writer.println(output.getOutput());
        
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
