import java.util.Arrays;

public class ArraySortMethod
{
   // method to calculate the number of passes
   public static int[] sort( int[] data )
   {
	  Arrays.sort(data);
      return data;
   }
   // main method
   public static void main( String[] args )
   {
      int[] marks = { 56, 23, 45, 75, 61 };
      
      System.out.println("BEFORE METHOD CALL");
      for ( int i = 0; i < marks.length; i++ ) {
    	  System.out.println(marks[i]);
      }
      
      // Call sort method and pass marks array as a parameter
      sort( marks );

      System.out.println("AFTER METHOD CALL");
      for ( int i = 0; i < marks.length; i++ ) {
    	  System.out.println(marks[i]);
      }      
      
   }
}
