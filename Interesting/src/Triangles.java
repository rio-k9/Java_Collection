
public class Triangles {
	

	public static void main(String args[]){
	
	int a = 5;
	int b = 3;
	int c = 4;
	int longest;
	if ( a > b && a > c)
	{
		longest = a;
	}
	
	else if ( b > a && b > c)
	{
		longest = b;

	}
	else {
		longest = c;
	}
	
	System.out.println( "Longest side is " + longest );
	
	}

}
