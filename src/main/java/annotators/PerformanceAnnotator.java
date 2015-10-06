package annotators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;

import type.Passage;
import type.Performance;
import type.Question;
import type.ScoredSpan;
import type.Scoring;
import type.TestElementAnnotation;

public class PerformanceAnnotator extends CasAnnotator_ImplBase  
{
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void process(CAS aCas) throws AnalysisEngineProcessException 
	{
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
		
		//Produce one performance for each test element
		FSIndex<Scoring> teIndex = (FSIndex) jcas.getAnnotationIndex(Scoring.type);

		for(Scoring score : teIndex)
		{
			Question question = ((TestElementAnnotation) score.getOrig()).getQuestion();
			Performance performance = new Performance(jcas);
			performance.setTestElement((TestElementAnnotation) score.getOrig());
			performance.setBegin(question.getBegin());
			performance.setEnd(question.getEnd());
			
			List<Boolean> correct = getCorrection(score);
			
			performance.setPAt1(precisionAtN(correct, 1));
			performance.setPAt5(precisionAtN(correct, 5));
			performance.setRr(reciprocalRank(correct));
			performance.setAp(averagePrecision(correct));
			performance.setComponentId(this.getClass().getName());
			performance.addToIndexes();
		}		
	}
	
	/**
	 * Returns the reciprocal of the smallest rank which gives a correct score
	 * If no scores are correct, returns the reciprocal of one plus the number of ranks.
	 * 
	 * @param scores - list of values true or false indicating whether the ranking was correct or not 
	 * @return the reciprocal of the smallest correct rank, or one plus the number of ranks
	 */
	private static float reciprocalRank(List<Boolean> scores)
	{
		int index = 1;
		boolean sawCorrect = false;
		for(Boolean score : scores)
		{
			sawCorrect |= score;
			if(score)
				break;
			index++;
		}
		return sawCorrect ? ((float)1.0)/(index) : 0;
	
	}
	
	private static float averagePrecision(List<Boolean> scores)
	{
		float total = 0;
		for(int n=1; n <= scores.size(); n++)
		{
			total += precisionAtN(scores,n);
		}
		return ((float) total)/((float) scores.size());
	}
	
	private static float precisionAtN(List<Boolean> scores, int n)
	{		
		return countFirstN(scores, n)/n;
	}
	
	private static List<Boolean> getCorrection(Scoring scoring)
	{
		FSList nextScore = scoring.getScores();
		List<Boolean> labels = new ArrayList<Boolean>();
		List<Double> scores = new ArrayList<Double>();
		while(nextScore instanceof NonEmptyFSList)
		{
			ScoredSpan passage = (ScoredSpan) ((NonEmptyFSList) nextScore).getHead();
			boolean label = ((Passage) passage.getOrig()).getLabel();
			double score = passage.getScore();
			labels.add(label);
			scores.add(score);
			nextScore = ((NonEmptyFSList) nextScore).getTail();
		}
		concurrentSort(scores,labels);
		return labels;
	}
	
	/**
	 * Auxiliary method to sum the values in a list of doubles which are coindexed to a boolean value True in a list of booleans
	 * 
	 * @param values - The values to sum
	 * @param labels - The boolean filter condition
	 * @param n - The maximum number of values to consider
	 * @return The sum of the first n values, filtered by True labels
	 */
	private static float countFirstN(List<Boolean> values, int n)
	{
		float sum = 0;
		for(int i=0; i<values.size() && i<n; i++)
		{
			if(values.get(i))
				sum++;
		}
		return sum;
	}
	
	/**
	 * Concurrent sort code from https://ideone.com/u2OICl
	 * Published to stackoverflow.com by user bcorso
	 * 
	 * Performs an in-place (destructive) sort on a list of array lists.  
	 * The keylist is unchanged (unless it is passed as one of the lists)
	 * 
	 * @param key: the list of comparable keys on which to sort
	 * @param lists: the coindexed set of lists to sort
	 */
	public static <T extends Comparable<T>> void concurrentSort( final List<T> key, List<?>... lists)
	{
        // Do validation
        if(key == null || lists == null)
        	throw new NullPointerException("key cannot be null.");
 
        for(List<?> list : lists)
        	if(list.size() != key.size())
        		throw new IllegalArgumentException("all lists must be the same size");
 
        // Lists are size 0 or 1, nothing to sort
        if(key.size() < 2)
        	return;
 
        // Create a List of indices
		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < key.size(); i++)
			indices.add(i);
 
        // Sort the indices list based on the key
		Collections.sort(indices, new Comparator<Integer>()
		{
			public int compare(Integer i, Integer j) 
			{
				return key.get(i).compareTo(key.get(j));
			}
		});
 
		Map<Integer, Integer> swapMap = new HashMap<Integer, Integer>(indices.size());
 
        // create a mapping that allows sorting of the List by N swaps.
		for(int i = 0; i < indices.size(); i++)
		{
			int k = indices.get(i);
			while(swapMap.containsKey(k))
				k = swapMap.get(k);
 
			swapMap.put(i, k);
		}
 
        // for each list, swap elements to sort according to key list
        for(Map.Entry<Integer, Integer> e : swapMap.entrySet())
			for(List<?> list : lists)
				Collections.swap(list, e.getKey(), e.getValue());
	}
}
