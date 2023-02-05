package Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
//Didn't know this way of getting a random integer so I wanted to try it

/**
 * @author Ryan Minneo
 *
 */
public class StatsLibraryTester {
	
	public static void main(String[] args)
	{
		StatsLibrary tester = new StatsLibrary();
		
		//For Mean, median, mode, standard deviation
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> sortedArr = new ArrayList<Integer>();
		
		//For Factorial Test (big number)
		String number = "21965";
		
		//randomizing the arrayList cause I didn't want to create multiple arrayLists, and I wanted to test out how using ThreadLocalRandom worked. "i < ThreadLocal..." randomizes the length of the arrayList. ...nextInt(min, max + 1) 
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(10, 21); i++)
		{
			arr.add(ThreadLocalRandom.current().nextInt(0, 21));
		}
		
		sortedArr.addAll(arr);
		Collections.sort(sortedArr);
		
		//ArrayListMethods
		System.out.println("The unsorted arrayList is: " + arr.toString()+ "\n");
		System.out.println("The unsorted arrayList is: " + sortedArr.toString() + "\n");
		System.out.println("The mean of this arrayList is: " + tester.findMean(arr)+ "\n");
		System.out.println("The median of this arrayList is: " + tester.findMedian(arr)+ "\n");
		System.out.println("The mode of this arrayList is: " + tester.findMode(arr)+ "\n");
		System.out.println("The Standard Deviation of this arrayList is: " + tester.standardDeviation(arr)+ "\n");
		
		//Permutations/Combinations Methods (These use BigInteger, and Strings are inputs to allows insanely big number)
		System.out.println("The factorial of " + number + " is: " + tester.findFactorial(number) + "\n");
		System.out.println("The number of Permutations is: " + tester.findPermutations("10", "5"));
		System.out.println("The number of Combinations is: " + tester.findCombinations("10", "5"));
	}
}
