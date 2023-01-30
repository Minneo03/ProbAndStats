package Library;

import java.util.ArrayList;
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
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		//randomizing the arrayList cause I didn't want to create multiple arrayLists, and I wanted to test out how using ThreadLocalRandom worked. "i < ThreadLocal..." randomizes the length of the arrayList between 5 and 10.
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(5, 11); i++)
		{
			arr.add(ThreadLocalRandom.current().nextInt(-15, 16));
		}
		
		System.out.println(arr.toString());
		System.out.println("The mean of this arrayList is: " + tester.findMean(arr));
		System.out.println("The median of this arrayList is: " + tester.findMedian(arr));
		System.out.println("The mode of this arrayList is: " + tester.findMode(arr));
	}
}
