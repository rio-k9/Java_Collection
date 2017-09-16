// Copying all elements from one array to another array
public class SystemArrayCopy
{
   public static void main( String[] args )
   {
      int[] marks = { 56, 23, 45, 75, 61 };
      int[] examMarks = new int[marks.length];

      System.arraycopy( marks, 0, examMarks, 0, marks.length);

      System.out.println("marks array:");
      for( int i = 0; i < marks.length; i++ ) {
          System.out.println( marks[i]);
      }

      System.out.println("examMarks array:");
      for( int i = 0; i < examMarks.length; i++ ) {
          System.out.println( marks[i]);
      }

      if ( marks == examMarks ) {
         System.out.println("Same array reference");
      }
      else {
         System.out.println("Different arrays");
      }
   }
}
