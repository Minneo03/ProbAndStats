package Library;

import java.util.ArrayList;
/**
 * @author Ryan Minneo
 *
 */
public class SetOperations {
	
	public ArrayList<Integer> findUnion(ArrayList<Integer> set1, ArrayList<Integer> set2)
	{
		ArrayList<Integer> union = new ArrayList<Integer>();
		
		union.addAll(set1);
		
		return union;
	}
}
