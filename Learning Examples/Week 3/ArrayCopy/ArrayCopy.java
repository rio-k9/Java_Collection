// Copying all elements from one array to another array
public class ArrayCopy
{
   public static void main( String[] args )
   {
      int element;
      int[] marks = { 56, 23, 45, 75, 61 };
      int[] examMarks = new int[marks.length];
      
      for ( element = 0; element < marks.length ; element++ ) {
        examMarks[ element ] = marks[ element ];
      }
      
      System.out.println("Mark of first student was " + marks[0] );
      System.out.println("Mark of fifth student was " + examMarks[4] );
   }
}
