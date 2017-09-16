// Program to calculate the mean mark
public class Mean
{
   public static void main( String[] args )
   {
      int sum = 0;
      int mean = 0;

      int mark1 = 56;
      int mark2 = 23;
      int mark3 = 45;
      int mark4 = 75;
      int mark5 = 61;

      sum = mark1 + mark2 + mark3 + mark4 + mark5;
      mean = sum / 5;
      System.out.println( "Average mark of students is " + mean );
   }
}
