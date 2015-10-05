package annotators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;

import type.Span;

/**
 * A simple segment annotator for PI4.
 * 
 * Expects a CAS for a document in the below format as input 
 * Creates annotations for the question and its answers as output
 * 
 * This annotator has no configuration parameters
 * 
 * Document Text Format:
 *  QUESTION\nPASSAGE1\nPASSAGE2\nPASSAGE3\n...
 *  
 *  Where QUESTION is of the form
 *  factoid_id QUESTION question_text
 *  
 *  And PASSAGEx is of the form
 *  factoid_id document_id correct/incorrect answer_text
 */


public class TestElementAnnotator extends CasAnnotator_ImplBase 
{
	private static final String WHITESPACE = "\\s";
	
	private static final String QUESTION_MARKER = "QUESTION";
	

	/**
	 * Annotate the test element
	 *  for a single question and its related passages
	 *  
	 *  Assumes the document text is of the form
	 *  QUESTION\nPASSAGE1\nPASSAGE2\nPASSAGE3\n...
	 *  
	 *  Where QUESTION is of the form
	 *  factoid_id QUESTION question_text
	 *  
	 *  And PASSAGEx is of the form
	 *  factoid_id document_id correct/incorrect answer_text
	 */
	public void process(CAS aCas) throws AnalysisEngineProcessException 
	{
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}

		//Extract the relevant spans
		String text = jcas.getDocumentText();
		String[] lines = text.split("\n");
		String question = lines[0];
		
		String[] passages = Arrays.copyOfRange(lines, 1, lines.length);

		////////////////////////////////
		//Annotate test element metadata		
		String qnum = question.split(WHITESPACE)[0];
		type.Question te = new type.Question(jcas); // the test element
		te.setBegin(0);
		te.setEnd(text.length());
		te.setId(qnum);
		te.setText("QUESTION " + qnum + " + PASSAGES");
		te.setComponentId(this.getClass().getName());

		////////////////////////////
		//Annotate the question span
		int index = question.length();
		Span q = new Span(jcas);
		q.setBegin(qnum.length() + QUESTION_MARKER.length() + 2);
		q.setEnd(index);
		q.setText(question.substring(q.getBegin()));
		q.setComponentId(this.getClass().getName());
		q.addToIndexes();
		te.setQuestion(q);
		
		///////////////////////
		//Annotate the passages
		FSList tePassages = new EmptyFSList(jcas);
		for(String passage : passages)
		{
			//Annotate the raw passage string
			type.Passage tePassage = new type.Passage(jcas); 
			tePassage.setBegin(index + 1);
			index = index + 1 + passage.length();
			tePassage.setEnd(index);
			tePassage.setText(passage);
			
			//Identify and annotate the passage span
			String sourceDocID = passage.split(WHITESPACE)[1];
			String label = passage.split(WHITESPACE)[2];
			int textStart = qnum.length() + sourceDocID.length() + label.length() + 3; 
			Span passageSpan = new Span(jcas);
			passageSpan.setText(passage.substring(textStart));
			passageSpan.setBegin(tePassage.getBegin() + textStart);
			passageSpan.setEnd(passageSpan.getBegin() + passageSpan.getText().length());
			passageSpan.setComponentId(this.getClass().getName());
			passageSpan.addToIndexes();
			tePassage.setPassage(passageSpan);
			tePassage.setSourceDocId(sourceDocID);
			try
			{
				tePassage.setLabel(Integer.parseInt(label) > 0);
			}
			catch(NumberFormatException e)
			{
				tePassage.setLabel(false);
			}
			tePassage.setQuestion(te);
			tePassage.setComponentId(this.getClass().getName());
			tePassage.addToIndexes();
			NonEmptyFSList tepass = new NonEmptyFSList(jcas);
			tepass.setHead(tePassage);
			tepass.setTail(tePassages);
			tePassages = tepass;
		}
		te.setPassages(tePassages);
		
		te.addToIndexes();
	}
}