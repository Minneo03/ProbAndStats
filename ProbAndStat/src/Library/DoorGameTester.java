package Library;

public class DoorGameTester 
{
	
	public static void main(String[] args)
	{
		DoorGame tester = new DoorGame();
		
		System.out.println("The amount of times won is " + tester.playGame(10000, false));
	}
}
