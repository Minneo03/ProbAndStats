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
			
			if (doorList.get(decision) == 1)
				if (keepAnswer)
					winCount++;
			else
			{
				doorList.remove(doorList.indexOf(0));
				decision = doorList.indexOf(0);
				if (doorList.get(decision) == 0)
					if (!keepAnswer)
						winCount++;
			}
			
			doorList.removeAll(doorList);
		}
		
		return winCount;
	}
}
