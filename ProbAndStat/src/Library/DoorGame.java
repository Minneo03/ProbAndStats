package Library;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DoorGame 
{
	
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
