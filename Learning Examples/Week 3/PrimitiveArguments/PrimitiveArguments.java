// PrimitiveArguments.java
// Demonstrates call-by-value

public class PrimitiveArguments {
   public static void main( String[] args ) {
      int i = 0;
      System.out.println( "Before someMethod i = " + i );
      someMethod( i );
      System.out.println( "After someMethod i = " + i );
   }

   static void someMethod( int a ) {
      System.out.println( "   In someMethod a = " + a );
      a++;
      System.out.println( "   In someMethod a = " + a );
   }
}