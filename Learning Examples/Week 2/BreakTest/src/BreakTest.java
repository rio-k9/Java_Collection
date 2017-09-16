public class BreakTest
{
	public static void main ( String[] args )
	{
		for(int a = 1; a < 10; a++)
		{
	  		System.out.print(a + " ");
	  	  	if (a == 5) 
				break;
		}
		System.out.println("You have exited the loop");
	}
}
