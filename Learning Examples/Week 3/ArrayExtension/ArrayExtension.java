import java.util.Scanner;

public class ArrayExtension
{
   public static void main( String[] args )
   {
	  Scanner in = new Scanner(System.in);
      final int ARRAY_SIZE = 5;
      int[] marks = new int[ ARRAY_SIZE ];
      int dataSize = 0;
      int studentMark;
      int sum=0;
      int mean =0;
      boolean done = false;
      // read marks until negative mark entered
      while ( ! done )
      {
         System.out.print( "Enter mark: " );
         studentMark = in.nextInt();
         if ( studentMark < 0 )
            done = true;
         // if more room in array, insert mark in array
         else if ( dataSize < marks.length )
	     {
	        marks[ dataSize ] = studentMark;
	        sum += studentMark;
	        dataSize++;
	     }			
 	     else
         // create new array of double the size, copy
         // all elements from the old array to the new
         // array and insert mark into the new array
         {
	        int[] newMarks = new int[ 2 
                                        * marks.length ];
  	        System.arraycopy( marks, 0, newMarks, 0,
                                          marks.length );
	        marks = newMarks;
	        marks[ dataSize ] = studentMark;
	        sum += studentMark;
	        dataSize++;
         }	
      }

      // output mean if at least one mark entered
      if ( dataSize != 0 )
      {
         mean = sum / dataSize;
         System.out.println( "Average mark is " + mean );
         System.out.println( "Array size is " + marks.length );
      }
      else
         System.out.println( "No marks entered" );
   }
}
