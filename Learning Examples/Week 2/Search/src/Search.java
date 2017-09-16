//
// Search for a character
//
public class Search
{
   public static void main( String[] args )
   {
      int numChars, element, position = -1;
      String number = "203.49";
      String whole, decPlaces;
      char ch;
      numChars = number.length();
      for ( element = 0; element < numChars; element++ )
      {
         ch = number.charAt( element );
         if ( ch == '.' )
            position = element;
      }
      whole = number.substring( 0, position );
      decPlaces = number.substring( position + 1 );
      System.out.println( whole );
      System.out.println( decPlaces );
   }
}
