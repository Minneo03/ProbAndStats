package Library;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Ryan Minneo
 *
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
}
