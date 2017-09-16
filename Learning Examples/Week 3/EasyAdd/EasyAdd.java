// EasyAdd.java
// Adds two specified integers.
import java.util.Scanner;

public class EasyAdd {
   public static void main( String args[] ) {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter first number: ");
	int x = in.nextInt();
	System.out.print("Enter second number: ");
	int y = in.nextInt();
	int sum = x + y;
	System.out.println( "Their sum is " + sum);
   }
}
