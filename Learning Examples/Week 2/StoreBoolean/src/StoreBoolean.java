public class StoreBoolean
{
   // Use of boolean variables
   public static void main( String[] args )
   {
      int number = 2;
      boolean state;
      if ( number < 2 )
         state = true;
      else
         state = false;
      System.out.println( state );
      if ( ! ( number < 2 ) )
         state = true;
      else
         state = false;
      System.out.println( state );
   }
}
