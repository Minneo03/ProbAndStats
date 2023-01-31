package Library;

import java.util.ArrayList;
/**
 * @author Ryan Minneo
 *
 */
public class SetOperations {
	
	/**
	 * 
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public ArrayList<Integer> findUnion(ArrayList<Integer> set1, ArrayList<Integer> set2)
	{
		ArrayList<Integer> union = new ArrayList<Integer>();
		
		union.addAll(set1);
		
		return union;
	}
	
	/**
	 * 
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public ArrayList<Integer> findIntersection(ArrayList<Integer> set1, ArrayList<Integer> set2)
	{
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		
		for (int element1 : set1)
		{
			for (int element2 : set2)
			{
				if (element1 == element2)
					intersection.add(element1);
			}
		}
		
		return intersection;
	}
}
