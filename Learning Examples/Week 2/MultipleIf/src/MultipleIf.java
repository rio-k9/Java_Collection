public class MultipleIf
{
   // Use of multiple if statements
   public static void main( String[] args )
   {
      int digit = 3;
      String digitName;
      if ( digit == 0 ) digitName = "zero";
      else if ( digit == 1 ) digitName = "one";
      else if ( digit == 2 ) digitName = "two";
      else if ( digit == 3 ) digitName = "three";
      else if ( digit == 4 ) digitName = "four";
      else if ( digit == 5 ) digitName = "five";
      else if ( digit == 6 ) digitName = "six";
      else if ( digit == 7 ) digitName = "seven";
      else if ( digit == 8 ) digitName = "eight";
      else if ( digit == 9 ) digitName = "nine";
      else digitName = "";
      System.out.println( digitName );
   }
}
