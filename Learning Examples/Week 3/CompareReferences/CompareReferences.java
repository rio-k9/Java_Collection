// Comparison of array references
public class CompareReferences
{
   public static void main( String[] args )
   {
      int[] marks = { 56, 23, 45, 75, 61 };
      int[] assessmentMarks = marks;

      int[] examMarks = new int[marks.length];

      if ( marks == assessmentMarks ) {
         System.out.println("Same array");
      }
      else {
         System.out.println("Different arrays");
      }
      
      if ( marks == examMarks ) {
         System.out.println("Same array");
      }
      else {
         System.out.println("Different arrays");
      }
   }
}
