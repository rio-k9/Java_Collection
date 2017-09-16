public class Sentinel2
{
   public static void main( String[] args )
   {
      KeyboardReader keyboard = 
                        new KeyboardReader( System.in );
      int sum = 0;
      int count = 0;
      // compute sum of marks
      System.out.println( "Enter marks (Q to finish)" );
      boolean done = false;
      while ( ! done )
      {
         String inputLine = keyboard.readLine();
         if ( inputLine.equalsIgnoreCase( "Q" ) )
	        done = true;
         else
         {
            int mark = Integer.parseInt(inputLine);
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
