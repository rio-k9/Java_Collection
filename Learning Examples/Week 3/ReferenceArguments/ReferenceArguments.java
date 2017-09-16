// ReferenceArguments.java
// Demonstrates call-by-reference-value

public class ReferenceArguments {
   public static void main( String[] args ) {
      java.awt.Point p = new java.awt.Point( 20, 20 );
      System.out.println( "Before someMethod p = " + p );
      someMethod( p );
      System.out.println( "After someMethod p = " + p );
      someOtherMethod( p );
      System.out.println( "After someOtherMethod p = " + p );
   }

   static void someMethod( java.awt.Point q ) {
      System.out.println( "   On entering someMethod q = " + q );
      q.translate( 10, 10 );
      System.out.println( "   On leaving someMethod q = " + q );
   }

   static void someOtherMethod( java.awt.Point q ) {
      System.out.println( "   On entering someOtherMethod q = " + q );
      q = new java.awt.Point( 50, 50 );
      System.out.println( "   In someOtherMethod q = " + q );
      q.translate( 10, 10 );
      System.out.println( "   On leaving someOtherMethod q = " + q );
   }
}