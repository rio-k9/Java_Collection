public class Search
{
   // method to calculate the number of passes
   public static int passes( int[] data )
   {
      if ( data.length == 0 ) return 0;
      int count = 0;
      for ( int i = 0; i < data.length; i++ )
      {
         if ( data[i] >= 50 )
            count++;
      }
      return count;
   }
   // main method
   public static void main( String[] args )
   {
      int[] marks = { 56, 23, 45, 75, 61 };
      int number = passes( marks );
      System.out.println("Number of students passing is " 
                                              + number );
   }
}
