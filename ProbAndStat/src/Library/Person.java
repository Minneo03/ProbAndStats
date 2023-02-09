package Library;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class allows for creation of a Person with a birthday. This class will also have methods to compare if multiple people have the same birthday.
 * 
 * @author Ryan Minneo
 * @version 1.0
 */
public class Person {
	
	private int birthday;
	
	/**
	 * Default constructor for a person. Assigns the person a random birthday between 1 and 365
	 */
	Person()
	{
		//Random Birthday between 1 and 365 representing the day of the year.
		birthday = ThreadLocalRandom.current().nextInt(1, 366);
	}
	
	/**
	 * Constructor for a person with input. The input will determine the person's date of birth, unless it is less than 1 or greater than 365. In those cases birthday will be set to 1 or 365 respectively.
	 * @param birthdayInput - input from the user to assign the persons birthday.
	 */
	Person(int birthdayInput)
	{
		if (birthdayInput >= 1 & birthdayInput <= 365)
		{
			birthday = birthdayInput;
		}
		else
		{
			if (birthdayInput <= 0)
				birthday = 1;
			else
				birthday = 365;
		}
	}
	
	public int getBirthday()
	{
		return birthday;
	}
	
	public String sameBirthday(int numPeople, int numTimes)
	{
		String sameBirth = "";
		int sameBirthNum = 0;
		ArrayList<Person> personList = new ArrayList<Person>();
		
		for (int i = numTimes; i > 0; i--)
		{
			for (int j = numPeople; j > 0; j--)
			{
				personList.add(new Person());
			}
			
			for (int k = 0; k < personList.size(); k++)
			{
				for (int l = 0; l < personList.size(); l++)
				{
					if (personList.get(k).getBirthday() == personList.get(l).getBirthday() & k != l)
					{
						sameBirthNum++;
					}
				}
			}
		}
		
		return sameBirth;
	}
}
