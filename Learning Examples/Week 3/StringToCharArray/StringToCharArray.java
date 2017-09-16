public class StringToCharArray
{
   public static void main( String[] args )
   {
      String name = "Matt Morgan";
      char[] charArray = name.toCharArray();
      System.out.println( String.valueOf( charArray, 5, 6 ) );
   }
}

