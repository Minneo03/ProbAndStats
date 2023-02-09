package Library;

/**
 * This class is basically a tester class for the Person Class.
 * @author Ryan Minneo
 * @version 1.0 - Class works as expected.
 */
public class Birthday {
	
	public static void main(String[] args)
	{
		Person tester = new Person();
		
		System.out.println(tester.sameBirthday(23, 1000));
	}
}
