import java.util.Scanner;

public class Input {
   Scanner in;
   
   // Constructor
   public Input() {
      in = new Scanner(System.in);
   }
   
   // Prompted input of an int
   public int getInt( String prompt ) {
      System.out.print( prompt + " : " );
      int result = in.nextInt();
      return result;
   }

   // Prompted input of a float
   public float getFloat( String prompt ) {
      System.out.print( prompt + " : " );
      float result = in.nextFloat();
      return result;
   }

   // Prompted input of a word/token
   public String getToken( String prompt ) {
      System.out.print( prompt + " : " );
      String result = in.next();
      return result;
   }
}
