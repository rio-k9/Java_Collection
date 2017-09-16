// Program to calculate the mean mark
public class MeanArray
{
   public static void main( String[] args )
   {
      int[] marks = new int[5];
      int sum = 0;
      int mean = 0;

      marks[0] = 56;
      marks[1] = 23;
      marks[2] = 45;
      marks[3] = 75;
      marks[4] = 61;
      
      sum = marks[0] + marks[1] + marks[2] + marks[3] + marks[4];
      mean = sum / 5;
      System.out.println( "Average mark of students is " + mean );
   }
}
