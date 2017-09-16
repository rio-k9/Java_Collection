// SimpleAddWithMethod.java
// Adds two specified integers using a getInt() method.
import java.util.Scanner;

public class SimpleAddWithMethod {
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


   // Method OVERLOADING
   /*
   public static int getInt() {
      Scanner in = new Scanner(System.in);
	  System.out.print( "INPUT : " );
	  int result = in.nextInt();
	  return result;
   }
   */


}