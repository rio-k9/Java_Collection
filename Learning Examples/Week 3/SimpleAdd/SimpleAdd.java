// SimpleAdd.java
// Adds two specified integers.
import java.util.Scanner;

public class SimpleAdd {
   public static void main( String args[] ) {
	  int x = getInt("Enter first integer");
	  int y = getInt("Enter second integer");
	  int sum = x + y;
      System.out.println( "Their sum is " + sum);
   }
   
   public static int getInt( String prompt ) {
      Scanner in = new Scanner(System.in);
	  System.out.print( prompt + " : " );
	  int result = in.nextInt();
	  return result;
   }
}