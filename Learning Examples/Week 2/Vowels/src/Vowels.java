public class Vowels
{
   public static int vowelCount( String phrase )
   {
      int numberOfVowels = 0;
      int length = phrase.length();
      char ch;
      for ( int i = 0; i < length; i++ )
      {
         ch =
             Character.toUpperCase( phrase.charAt( i ) );
         if ( ch == 'A' || ch == 'E' || ch == 'I' 
                        || ch == 'O' || ch == 'U' )
            numberOfVowels++; 
      }
      return numberOfVowels;
   }

   public static void main( String[] args )
   {
      String word = "Elephant";
      System.out.print( "Number of vowels in '"
                                      + word + "' is " );
      System.out.println( vowelCount( word ) );
   }
}
