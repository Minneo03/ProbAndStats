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
	
	/**
	 * getBirthday will get the birthday of the person specified 
	 * @return birthday - the person's birthday
	 */
	public int getBirthday()
	{
		return birthday;
	}
	
	/**
	 * hasSameBirthday will go through a list of people, and if any 2 people have the same birthday, it will return true. If no one has the same person in the entire list, it will return false.
	 * @param personListInput - the list which will be checked whether or not 2 people have the same birthday.
	 * @return true/false
	 */
	public boolean hasSameBirthday(ArrayList<Person> personListInput)
	{
		for (int k = 0; k < personListInput.size(); k++)
		{
			for (int l = 0; l < personListInput.size(); l++)
			{
				if (personListInput.get(k).getBirthday() == personListInput.get(l).getBirthday() & k != l)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * This method runs a loop of the previous method, hasSameBirthday, numTimes, and it does this with an arrayList that is numPeople long.
	 * @param numPeople - number of people, say, in a class
	 * @param numTimes - The number of people in the people list.
	 * @return - A string stating a lot of information based on numPeople, numTimes, and sameBirthNum.
	 */
	public String sameBirthday(int numPeople, int numTimes)
	{
		String sameBirth = "";
		int sameBirthNum = 0;
		double sameBirthPercent = 0.0;
		ArrayList<Person> personList = new ArrayList<Person>();
		
		for (int i = numTimes; i > 0; i--)
		{
			for (int j = numPeople; j > 0; j--)
			{
				personList.add(new Person());
			}
			
			if (hasSameBirthday(personList))
			{
				sameBirthNum++;
			}
			
			personList.removeAll(personList);
			
		}
		sameBirthPercent = (double)sameBirthNum/(double)numTimes * 100;
		
		sameBirth = "Out of " + numTimes + " times, there were at least two people out of " + numPeople + " had the same birthday " + sameBirthNum + " times. The percentage comes out to be " + sameBirthPercent + "%.";
		return sameBirth;
	}
}
