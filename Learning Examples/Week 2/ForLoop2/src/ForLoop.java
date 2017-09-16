//
// Program to produce a formatted output
//
public class ForLoop
{
   public static void main( String[] args )
   {
      int centTemp, fahTemp;
      String outputString;
      int itemLength;
      int count;
      for ( centTemp = 0; centTemp <= 20; centTemp++ )
      {
         fahTemp = ( centTemp * 9 ) / 5 + 32;
         // Output the Centigrade temperature to the screen
         // using a field width of 2 characters
         outputString = Integer.toString( centTemp );
         itemLength = outputString.length();
         if ( itemLength < 2 )
         {
            for( count = 1; count <= 2 - itemLength; count++ )
               System.out.print(" ");
         }
         System.out.print( outputString );
         System.out.print(" degrees C = ");
         // Output the Fahrenheit temperature to the screen
         // using a field width of 2 characters
         outputString = Integer.toString( fahTemp );
         itemLength = outputString.length();
         if ( itemLength < 2 )
         {
            for( count = 1; count <= 2 - itemLength; count++ )
               System.out.print(" ");
         }
         System.out.print( outputString );
         System.out.println(" degrees F");
      }
   }
}
