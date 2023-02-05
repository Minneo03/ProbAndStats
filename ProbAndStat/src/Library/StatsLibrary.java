package Library;

import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
//Could've also used java.util.Comparator to sort

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
		
		//adds all of the values from one arrayList to another.
		sortedArray.addAll(inputArr);
		
		//sorts the arrayList into ascending order.
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
	 * Finds the mode of an inputed arrayList. If there are "multiple modes" then it should return null. If there is no mode, it will also return null.
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
			
			//if the count is higher than the highestCount, highestCount will be redefined as the value of count. Then the mode is set to the value in the arrayList. If there are "multiple modes" then the mode will become null.
			if (count > highestCount) 
			{
				highestCount = count;
				mode = inputArr.get(i);
			}
			else if (count == highestCount && inputArr.get(i) != mode)
				mode = null;
		}
		return mode;
	}
	
	/**
	 * Finds the standard deviation of an ArrayList of Integers
	 * 
	 * @param inputArr
	 * @return deviation (AKA Standard Deviation)
	 */
	public double standardDeviation(ArrayList<Integer> inputArr)
	{
		double deviation = 0.0;
		//mean comes in handy
		double mean = findMean(inputArr);
		
		//Sum of (Xi - X-)^2
		for (int element : inputArr)
			deviation += Math.pow((element-mean), 2);
		
		//Divides by n-1
		deviation /= (inputArr.size()-1);
		
		//Takes the Square Root to finally determine the Standard Deviation
		deviation = Math.sqrt(deviation);
		
		return deviation;
	}
	
	/**
	 * Finds the factorial of the input provided. This is also a recursive method.
	 * 
	 * @param num
	 * @return
	 */
	public int findFactorial(int num)
	{
		int factorial = 1;
		
		if (num != 0)
		{
			factorial *= num;
			factorial *= findFactorial(num-1);
		}
		
		return factorial;
	}
	
	/**
	 * First time I ever used BigInteger. I used it so that I can calculate factorials to a much higher value.
	 * 
	 * @param num - It is a String, but it could technically be an integer or BigInteger, String is just the easiest.
	 * @return strFactorial - returns the factorial of num as a String, since the values are too big for an int
	 */
	public String findFactorial(String num)
	{
		BigInteger factorial = new BigInteger("1");
		BigInteger numb = new BigInteger(num);
		String strFactorial = "";
		
		for (int i = numb.intValue(); i > 1; i--)
		{
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		
		strFactorial = factorial.toString();
		return strFactorial;
	}
	
	/**
	 * Find the number of permutations
	 * 
	 * @param n
	 * @param r
	 * @return
	 */
	public int findPermutations(int n, int r)
	{
		return findFactorial(n)/findFactorial(n-r);
	}
	
	public String findPermutations(String nInput, String rInput)
	{
		BigInteger nFactorial = new BigInteger(findFactorial(nInput));
		BigInteger rFactorial = new BigInteger(findFactorial(rInput));
		return nInput; //Just so no errors
	}
	
	/**
	 * Finds the number of combinations
	 * 
	 * @param n
	 * @param r
	 * @return
	 */
	public int findCombinations(int n, int r)
	{
		return findFactorial(n)/(findFactorial(r) * findFactorial(n-r));
	}
}
