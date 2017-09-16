public class Absolute
{
   // Use of selection operator
   public static void main( String[] args )
   {
      int x = 5;
      int y = -10;
      int z;
      System.out.println( "Value of x is " + x );
      System.out.println( "Value of y is " + y );
      z = x >= 0 ? x : -x;
      System.out.println( "Value of z is " + z );
      z = y >= 0 ? y : -y;
      System.out.println( "Value of z is " + z );
   }
}
