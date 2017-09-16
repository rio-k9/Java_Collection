//
// Example using two for loops
//
public class Tables
{
   public static void main(String[] args)
   {
      int number1, number2, result;
      for ( number1 = 2; number1 <= 4; number1++ )
      {
         for ( number2 = 1; number2 <= 10; number2++ )
         {
            result = number1 * number2;
            System.out.println( number1 + " X " 
                         + number2 + " = " + result );
         }
         System.out.println( "" );
      }
   }
}
