
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;

/**
 * Serves as a reader to parse input.
 * 
 * Reads in a single file (FILENAME - defaults to questions_and_passages.txt)
 * and prepares a cas for each question in the file
 *
 * Each line of the input file is assumed to contain either one question or one passage 
 * 
 * Questions are assumed to be of the form
 *  factoid_id QUESTION question_text
 *  
 * And passages are assumed to be of the form
 *  factoid_id document_id correct/incorrect answer_text
 */
public class QuestionPassageReader extends CollectionReader_ImplBase {
	/**
	 * Name of configuration parameter that must be set to the path of a directory containing input
	 * files.
	 */
	public static final String PARAM_INPUTDIR = "InputDir";
	
	/**
	 * Name of configuration parameter that contains the character encoding used by the input files.
	 * If not specified, the default system encoding will be used.
	 */
	public static final String PARAM_ENCODING = "Encoding";

	/**
	 * Name of optional configuration parameter that contains the language of the documents in the
	 * input directory. If specified this information will be added to the CAS.
	 */
	public static final String PARAM_LANGUAGE = "Language";

	private static final String FILENAME = "questions_and_passages.txt";

	private static final String WHITESPACE = "\\s";
	
	private static final String QUESTION_MARKER = "QUESTION";
	
	private Map<String,Entry> questions;
	private Iterator<String> questionIterator;
	private String mEncoding;
	private String mLanguage;
	private String URI;
	
	/**
	 * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void initialize() throws ResourceInitializationException {
		File directory = new File(((String) getConfigParameterValue(PARAM_INPUTDIR)).trim());
		this.mEncoding  = (String) getConfigParameterValue(PARAM_ENCODING);
		this.mLanguage  = (String) getConfigParameterValue(PARAM_LANGUAGE);
		
		// if input directory does not exist or is not a directory, throw exception
		if (!directory.exists() || !directory.isDirectory()) {
			throw new ResourceInitializationException(ResourceConfigurationException.DIRECTORY_NOT_FOUND,
					new Object[] { PARAM_INPUTDIR, this.getMetaData().getName(), directory.getPath() });
		}

		// open input stream to file
		File file = new File(directory, FILENAME);
		String text = "";
		try {
			text = FileUtils.file2String(file, mEncoding);
		} catch (IOException e) {
			Object[] args = new Object[1];
			args[0] = FILENAME;
			throw new ResourceInitializationException(ResourceInitializationException.COULD_NOT_ACCESS_DATA, args);
		}

		//Save some metadata about the file
		try {
			this.URI = file.getAbsoluteFile().toURL().toString();
		} catch (MalformedURLException e) {
			this.URI = file.getAbsolutePath();
		}

		//Get the questions and passages and index based on question number
		this.questions = new TreeMap<String,Entry>();

		for(String line : text.split("\n"))
		{
			String qnum = getQnum(line);
			if(!questions.containsKey(qnum))
				questions.put(qnum, new Entry());
			//if question
			if(isQuestion(line))
			{
				questions.get(qnum).setQuestion(line);
			}
			else
			{
				questions.get(qnum).addPassage(line);
			}
		}
		
		this.questionIterator = questions.keySet().iterator();
	}	
	
	private boolean isQuestion(String line) {
		return line.split(WHITESPACE)[1].equals(QUESTION_MARKER);
	}

	private static String getQnum(String line) {
		return line.split(WHITESPACE)[0];
	}
	
	public void getNext(CAS aCAS) throws IOException, CollectionException {
		//Can we even get another question?
		if(!this.hasNext())
			throw new CollectionException(); //No further questions, Your Honor!

		//Get the next question
		String qnum = this.questionIterator.next();
		
		//Identify relevant texts
		String question = this.questions.get(qnum).getQuestion();
		List<String> passages = this.questions.get(qnum).getPassages();

		//Populate the CAS
		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new CollectionException(e);
		}

		// put document in CAS
		String text = question + "\n" + String.join("\n",passages);
		jcas.setDocumentText(text);
		
		// set language if it was explicitly specified as a configuration parameter
		if (this.mLanguage != null) {
			jcas.setDocumentLanguage(this.mLanguage);
		}
		
		// Also store location of source document in CAS. This information is critical
		// if CAS Consumers will need to know where the original document contents are located.
		// For example, the Semantic Search CAS Indexer writes this information into the
		// search index that it creates, which allows applications that use the search index to
		// locate the documents that satisfy their semantic queries.
		SourceDocumentInformation srcDocInfo = new SourceDocumentInformation(jcas);
		srcDocInfo.setUri(this.URI);
		srcDocInfo.setOffsetInSource(0);
		srcDocInfo.setDocumentSize(text.length());
		srcDocInfo.setLastSegment(!this.hasNext());
		srcDocInfo.addToIndexes();
	}

	public void close() throws IOException {
	}

	public Progress[] getProgress() {
		return null;
	}

	public boolean hasNext() throws IOException, CollectionException {
		return this.questionIterator.hasNext();
	}

}

/**
 * Auxiliary class to package strings associated with a given question entry 
 * 
 * @author maki
 */
class Entry
{
	private String question;
	private List<String> passages;
	Entry()
	{ 
		passages = new ArrayList<String>(); 
	}
	
	void setQuestion(String q)
	{
		this.question = q;
	}
	
	void addPassage(String p)
	{
		this.passages.add(p);
	}
	
	String getQuestion()
	{
		return this.question;
	}
	
	List<String> getPassages()
	{
		return this.passages;
	}
}
