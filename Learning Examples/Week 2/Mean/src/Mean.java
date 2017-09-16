public class Mean
{
   public static void main( String[] args )
   {
      KeyboardReader keyboard = 
                        new KeyboardReader( System.in );
      int sum = 0;
      int count = 0;
      // compute sum of marks
      System.out.println("Enter marks");
      boolean done = false;
      while ( ! done )
      {
         String inputLine = keyboard.readLine();
         if ( inputLine == null )
	        done = true;
         else
         {
	        try
	        {
	          int mark = Integer.parseInt( inputLine );
	          sum = sum + mark;
	          count++;
	        }
            catch ( NumberFormatException ne )
         	{
              System.out.println( "Not a number!" );
              System.exit( 2 );
            }
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
