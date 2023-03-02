package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * SetOperations class contains many method that have to relate to sets, such as union, intersection, and complement.
 * 
 * @author Ryan Minneo
 * @version 1.0
 */
public class SetOperations {
	
	/**
	 * This wasn't required for the assignment, but it makes doing the union of two sets much easier. It goes through every element in an arrayList to make sure no duplicates remain.
	 * 
	 * @param set
	 * @return cleanSet - Whatever the set was, without duplicates (As it should be)
	 */
	public ArrayList<Integer> removeDuplicates(ArrayList<Integer> set)
	{
		ArrayList<Integer> cleanSet = new ArrayList<Integer>();
		
		for (int element : set)
			if (!cleanSet.contains(element))
				cleanSet.add(element);
		
		return cleanSet;
	}
	
	/**
	 * findUnion method will find the union of two arrayLists. The way I went about it is to add both arrayLists to a new arrayList, which will be returned. However just adding the two sets to one would allows for duplicates, so I use the removeDuplicates method to remove the duplicates.
	 * 
	 * @param set1
	 * @param set2
	 * @return union - The union of the two ArrayLists
	 */
	public ArrayList<Integer> findUnion(ArrayList<Integer> set1, ArrayList<Integer> set2)
	{
		ArrayList<Integer> union = new ArrayList<Integer>();
		
		union.addAll(set1);
		union.addAll(set2);
		
		union = removeDuplicates(union);
		Collections.sort(union);
		
		return union;
	}
	
	/**
	 * findIntersection is similar to Union, as it is just finding the intersection of two arrayLists. Here I use 2 for each loops to go through each element of the first set and compare it to each element of the second set. If the two elements are equal, it will be added to the intersection set.
	 * 
	 * @param set1
	 * @param set2
	 * @return intersection - the intersection of the two inputed sets.
	 */
	public ArrayList<Integer> findIntersection(ArrayList<Integer> set1, ArrayList<Integer> set2)
	{
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		
		for (int element1 : set1)
			for (int element2 : set2)
				if (element1 == element2)
					intersection.add(element1);
		
		return intersection;
	}
	
	/**
	 * Finds the complement of an arraylist. Takes the superSet and removes all the elements that are in the subset to get the complement.
	 * 
	 * @param subSet
	 * @param superSet
	 * @return complement - the complement/reverse of the subset.
	 */
	public ArrayList<Integer> findComplement(ArrayList<Integer> subSet, ArrayList<Integer> superSet)
	{
		ArrayList<Integer> complement = new ArrayList<Integer>();
		
		complement.addAll(superSet);
		
		for (int element : subSet)
			if (complement.contains(element))
				complement.remove(complement.indexOf(element));
		
		return complement;
	}
	
	public void testEverything()
	{
		SetOperations tester = new SetOperations();
		
		ArrayList<Integer> superSetS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 6, 7, 9));
		ArrayList<Integer> subsetA = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 6, 7, 9));
		ArrayList<Integer> subsetB = new ArrayList<Integer>(Arrays.asList(2, 4, 6));
		
		System.out.println("Super Set S is equal to: " + superSetS.toString());
		System.out.println("Subset A is equal to: " + subsetA.toString());
		System.out.println("Subset B is equal to: " + subsetB.toString() + "\n");
		System.out.println("The union of A and B is equal to: " + tester.findUnion(subsetA, subsetB));
		System.out.println("The intersection of A and B is equal to: " + tester.findIntersection(subsetA, subsetB));
		System.out.println("The complement of subset A is: " + tester.findComplement(subsetA, superSetS));
		System.out.println("The complement of subset B is: " + tester.findComplement(subsetB, superSetS));
	}
}
