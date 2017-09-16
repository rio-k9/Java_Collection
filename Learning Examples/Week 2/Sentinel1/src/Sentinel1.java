public class Sentinel1
{
   public static void main( String[] args )
   {
      KeyboardReader keyboard = 
                        new KeyboardReader( System.in );
      int sum = 0;
      int count = 0;
      // compute sum of marks
      System.out.println( 
            "Enter marks (negative number to finish)" );
      boolean done = false;
      while ( ! done )
      {
         String inputLine = keyboard.readLine();
         int mark = Integer.parseInt( inputLine );
         if ( mark < 0 )
	        done = true;
         else
         {
	        sum = sum + mark;
	        count++;
	     }
      }
      // compute average
      if ( count == 0 )
         System.out.println( "No marks entered" );
      else
         System.out.println( "Average mark is " 
                                        + sum / count );
   }
}
