import java.util.Scanner;
public class IntegerInput
{
   public static void main( String[] args ) {
	   
	   System.out.println("Write a number: ");
	   Scanner in = new Scanner( System.in );
	   
	   while ( in.hasNextLine() ) {
	       String $nextLine = in.nextLine();
	       if ($nextLine.equals("")) {
	    	   //leave loop on line end.
	    	   break;
	       }	       
	       Scanner $userInput = new Scanner( $nextLine );
	       
	       if ($userInput.hasNextInt()==true){
	    	   //Check if input has integers only
	           int number = $userInput.nextInt();
	           System.out.println("Here is your number: " + number);
	           $userInput.close();
	       }
	       else {
	           System.out.println("You didn't enter a number.");
	       }
	       System.out.println("\nWrite another number: ");
	   }
	   in.close();
   }
}








