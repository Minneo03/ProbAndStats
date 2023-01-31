package Library;

import java.util.ArrayList;
import java.util.Arrays;

public class SetOperationsTester 
{
	public static void main(String[] args)
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
