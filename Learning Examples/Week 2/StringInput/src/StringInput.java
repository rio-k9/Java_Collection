import java.util.Scanner;
public class StringInput
{
   public static void main( String[] args )
   {
      Scanner in = new Scanner( System.in );       // set up keyboard input
      
      while ( in.hasNextLine() ){ // read lines until end of input
         String line = in.nextLine();
         if (line.equals("")) {
        	 break;
         }
         System.out.println( line );  // split line into individual words
         Scanner $myLine = new Scanner( line );

         while ( $myLine.hasNext() ){
            String $myString = $myLine.next();
            System.out.println( $myString );   // display each word in line
         }
         $myLine.close();
      }
      in.close();
   }
}
