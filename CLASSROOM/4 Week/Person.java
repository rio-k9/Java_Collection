public class Person
{
	private String lastName;
	
	private String firstName;
	
	public Person(String last, String first)
	{
		lastName = last;
		firstName = first;
	}

	public String toString()
	{
		return(firstName + " " + lastName);
	}

}