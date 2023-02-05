package Library;

import java.util.ArrayList;

public class DoorGameTester 
{
	
	public static void main(String[] args)
	{
		DoorGame tester = new DoorGame();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.addAll(tester.generateDoors());
		System.out.println(arr.toString());
		
		System.out.println("The amount of times won is " + tester.playGame(10000, false));
	}
}
