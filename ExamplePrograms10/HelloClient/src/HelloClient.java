import java.rmi.Naming;
public class HelloClient 
{
   // main method
   public static void main( String[ ] args ) 
   {
      try 
      {
         // get object reference server method
         Hello objRef = 
          (Hello) Naming.lookup(
                "rmi://localhost/hello" );
         // display output from method executed
         // on server
         System.out.println( 
                 "Output from server method is '" 
               + objRef.displayMessage() + "'" );
      } 
      catch( Exception e ) 
      { 
         System.err.println( e ); 
      }
   } 
}
