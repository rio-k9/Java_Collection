// Program using the PrintStream class to produce
// formatted output
//
import java.io.PrintStream;
public class FormatOutput
{
   public static void main(String[] args)
   {
      PrintStream output = 
                  new PrintStream( System.out );
      
      String $helloWorld = "Hello World";
      int $intNum=27;
      double $doubleNum = 13.75;
      
      output.format("Right justified:\n"
      		+ "%7s%7d%7.2f", 
    		  $helloWorld, $intNum, $doubleNum );
      
      output.format("\n\nLeft justified:\n "
      		+ "%-7s%-7d%-7.2f",
    		  $helloWorld, $intNum, $doubleNum);
      
      output.format("\n\nNo leading spaces:\n" + "%s", $helloWorld );
      
      output.printf("\n\nPrintf format method:\n" + "%d", $intNum );
      output.printf("%.2f",
                     $doubleNum );
      
      // check no error has occurred with printstream
      output.println( output.checkError() );
      
      boolean IfElse = true;
      String Result = IfElse == false ? "Hello": "World";
      System.out.println("\nBoolean ifelse:\n" + Result);
   }
}
