package Library;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class only has two methods. One to generate the list of Doors, and one to play through the Monty Hall scenario. 
 * 
 * @author Ryan Minneo
 * @version 0.9 - Doesn't currently obtain the right answer.
 */
public class DoorGame 
{
	/**
	 * This method will generate an ArrayList with 3 values in it, where two are 0's and one is 1. The position of the 1 is randomized.
	 * 
	 * @return doorList - The ArrayList of doors, 1 is where the car is, while the 0's are where the goats are.
	 */
	public ArrayList<Integer> generateDoors()
	{
		ArrayList<Integer> doorList = new ArrayList<Integer>();
		
		int placement = ThreadLocalRandom.current().nextInt(0, 3);
		
		for (int i = 0; i < 3; i++)
		{
			if (i == placement)
			{
				doorList.add(1);
			}
			else
			{
				doorList.add(0);
			}
		}
		
		return doorList;
	}
	
	/**
	 * This method plays the game. It will play/iterate through the game "times" amount. Since there is a choice of changing or not changing the door the player picks, there is also a boolean "keepAnswer" to determine if this method will change doors or not.
	 * 
	 * @param times - Number of times the game will be played
	 * @param keepAnswer - Whether or not the game will stick to its original answer or change its answer after a door has been revealed.
	 * @return winCount - the number of times this program "wins" the game/picks the door with the car behind it.
	 */
	public int playGame(int times, boolean keepAnswer)
	{
		int winCount = 0;
		int decision; //= ThreadLocalRandom.current().nextInt(0, 3);
		ArrayList<Integer> doorList = new ArrayList<Integer>();
		
		for (int i = 0; i < times; i++)
		{
			decision = ThreadLocalRandom.current().nextInt(0, 3);
			doorList.addAll(generateDoors());
			
			if (doorList.get(decision) == 1) //if you choose the right door,       (This happens 1/3 of the time)
				if (keepAnswer) //if you want to keep your answer, not change it, 
					winCount++; //you get a win
			
			else //if you don't choose the right door immediately       (This happens 2/3 of the time)
			{
				//At this point a door would be revealed, thus changing doors will always be the best option here.
				if (!keepAnswer) //if you want to change doors     
					winCount++; //you get a win
			}
			
			doorList.removeAll(doorList);
		}
		
		return winCount;
	}
}
