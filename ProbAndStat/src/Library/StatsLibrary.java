package Library;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * This class uses plenty of methods to find various measurements used in Statistics. Such as mean, median, and mode.
 * 
 * @author RyanMinneo
 *
 */
public class StatsLibrary {
	
	/**
	 * Finds the mean of an arrayList
	 * 
	 * @param inputArr
	 * @return mean
	 */
	public double findMean(ArrayList<Integer> inputArr) {
		double mean = 0.0;
		
		for (int singleElement : inputArr) {
			mean += singleElement;
		}
		
		mean /= inputArr.size();
		
		return mean;
	}
	
	/**
	 * Sorts the arraylist to be in increasing order, then determines whether the size of the array is even or odd using modulo. Then finds the median of the arrayList
	 * 
	 * @param inputArr
	 * @return median
	 */
	public double findMedian(ArrayList<Integer> inputArr) {
		double median = 0.0;
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		
		//Creates an arraylist so I can sort the inputed array later
		for (int singleElement : inputArr) {
			sortedArray.add(singleElement);
		}
		
		Collections.sort(sortedArray);
		
		if (sortedArray.size()%2 == 1) {
			median = sortedArray.get(sortedArray.size()/2);
		}
		else {
			median = (sortedArray.get(sortedArray.size()/2) + sortedArray.get(sortedArray.size()/2 + 1))/2;
		}
		
		return median;
		
	}
	
	/**
	 * Finds the mode of an inputed arrayList. If there are "multiple modes" then it should return null.
	 * 
	 * @param inputArr
	 * @return mode
	 */
	public Integer findMode(ArrayList<Integer> inputArr) 
	{
		Integer mode = null;
		int highestCount = 0;
		
		for (int i = 0; i < inputArr.size(); i++) 
		{
			int count = 0;
			
			for (int j = 0; j < inputArr.size(); j++) 
			{
				if (inputArr.get(i) == inputArr.get(j))
					count++;	
			}
			
			if (count > highestCount) 
			{
				highestCount = count;
				mode = inputArr.get(i);
			}
		}
		return mode;
	}
}
