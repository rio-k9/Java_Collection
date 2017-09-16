public class SwitchString
{
   // Use of switch statement for Strings
   // Java SE 7 or later
   public static void main( String[] args )
   {
	String digitName = "seven"; 
	int digit;
      switch ( digitName )
      {
         case "zero":  digit = 0; break;
         case "one":   digit = 1; break;
         case "two":   digit = 2; break;
         case "three": digit = 3; break;
         case "four":  digit = 4; break;
         case "five":  digit = 5; break;
         case "six":   digit = 6; break;
         case "seven": digit = 7; break;
         case "eight": digit = 8; break;
         case "nine":  digit = 9; break;
         default: digit = -1; break;
      }
      System.out.println( digit );
   }
}
