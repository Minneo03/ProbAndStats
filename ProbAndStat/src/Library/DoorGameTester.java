package Library;

/**
 * This class simply tests the DoorGame methods. If tester.playGame(10000, false) == A number around 6666 and tester.playGame(10000, true) == A number around 3333 then the DoorGame methods are in working order.
 * 
 * @author Ryan Minneo
 * @version 1.0 - The Tester class works in its current state.
 */
public class DoorGameTester 
{
	
	public static void main(String[] args)
	{
		DoorGame tester = new DoorGame();
		
		System.out.println("The amount of times won is " + tester.playGame(10000, false));
	}
}
