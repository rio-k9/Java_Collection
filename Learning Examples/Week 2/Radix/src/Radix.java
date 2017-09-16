public class Radix
{
   public static void main( String[] args )
   {
      int digit = 11;
      System.out.println( 
                     Character.forDigit( digit, 16 ) );
      char ch = 'f';
      System.out.println( Character.digit( ch, 16 ) );
   }
}
