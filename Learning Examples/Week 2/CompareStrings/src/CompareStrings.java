//
// Comparison of strings
//
public class CompareStrings
{
   public static void main( String[] args )
   {
      String firstString = "Hello";
      String secondString = "HELLO";
      boolean equalString;
      equalString = firstString.equals( secondString );
      if ( equalString == true )
         System.out.println("Strings are identical");
      else
         System.out.println("Strings are different");
      equalString =
          firstString.equalsIgnoreCase( secondString );
      if ( ! equalString )
         System.out.println("Strings are different");
      else
         System.out.println("Strings are identical");
   }
}
