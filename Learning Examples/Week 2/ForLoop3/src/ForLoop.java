public class ForLoop
{
//
// Method to output an integer to the screen using a given 
// field width
//
   public static void displayInt( int number, int width )
   {
      String outputString;
      int itemLength, count;
      outputString = Integer.toString( number );
      itemLength = outputString.length();
      if ( itemLength < width )
         for ( count = 1; count <= width - itemLength; count++ )
            System.out.print( " " ); 
      System.out.print( outputString ); 
   }
        
   public static void main( String[] args )
   {
      int centTemp, fahTemp;
      for ( centTemp = 0; centTemp <= 20; centTemp++ )
      {
         fahTemp = ( centTemp * 9 ) / 5 + 32;
	     displayInt( centTemp, 2 ); 
         System.out.print( " degrees C = " );
	     displayInt( fahTemp, 2 ); 
         System.out.println( " degrees F" );
      }
   }
}





