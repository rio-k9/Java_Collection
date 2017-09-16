// Multiple references to an array
public class ArrayReference
{
   public static void main( String[] args )
   {
      int[] marks = { 56, 23, 45, 75, 61 };
      int[] examMarks;
      
      examMarks = marks;
      
      System.out.println("Mark of first student was " + marks[0] );
      marks[4] = 99;
      System.out.println("Mark of fifth student was " + examMarks[4] );
   }
}
