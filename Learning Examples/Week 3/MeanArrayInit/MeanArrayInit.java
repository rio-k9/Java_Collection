// Program to calculate the mean mark
public class MeanArrayInit
{
   public static void main( String[] args )
   {
      int[] marks = { 56, 23, 45, 75, 61 };
      int sum = 0;
      int mean = 0;

      for ( int i = 0; i < marks.length; i++ )
      {
        sum += marks[i];
      }
      
      mean = sum / marks.length;
      System.out.println( "Average mark of students is " + mean );
   }
}
