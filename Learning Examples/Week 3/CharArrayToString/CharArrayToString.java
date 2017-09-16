public class CharArrayToString
{
   public static void main( String[] args )
   {
      char[] charArray =
         { 'J', 'i', 'm', ' ', 'E', 'v', 'a', 'n', 's' };
      String fullName = String.valueOf( charArray );
      System.out.println( fullName );
      String surName = String.valueOf( charArray, 4, 5 );
      System.out.println( surName );
   }
}
