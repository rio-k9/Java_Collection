import java.rmi.Naming;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class MatrixClient 
{
   // main method
   public static void main( String[ ] args ) 
   {
      if ( args.length < 1 ) 
      {
         System.err.println( "MatrixClient <file>" );
         return;  
      }
      try 
      {
         Matrix mm = (Matrix) Naming.lookup(
                   "rmi://localhost/matrix" );
         MatrixClient c = new MatrixClient();
         if ( c.readInput( args[ 0 ] ) )
            c.compute( mm );              
      } 
      catch( Exception e ) 
      { 
         System.err.println( e ); 
      }
   } 
   // method to read input from a text file
   private boolean readInput( String filename ) 
   {
      try
      {
         FileReader infile = new FileReader( filename );
         BufferedReader in = new BufferedReader(infile );
         String inputLine = in.readLine();
         StringTokenizer t = new StringTokenizer(inputLine );
         int n = Integer.parseInt( t.nextToken() );
         m1 = new int[ n ][ n ]; 
         m2 = new int[ n ][ n ]; 
         fillMatrix( in, m1, n );
         fillMatrix( in, m2, n );
         if ( in != null )
            in.close();
      }
      catch ( Exception e )
      {
         System.err.println( e );
         return false;
      }
      return true;
   }
   // initialise matrix using input from text file
   private void fillMatrix( 
                BufferedReader in, int[ ][ ] m, int n )
   {
      try
      {
         for ( int i = 0; i < n; i++ )
         {
            String inputLine = in.readLine();
            StringTokenizer t = new StringTokenizer(
                                          inputLine );
            for ( int j = 0; j < n; j++ )
            {
               m[ i ][ j ] = Integer.parseInt(
                                      t.nextToken() );
            }
         }
      }
      catch ( Exception e )
      {
         System.err.println( e );
         System.exit( 1 );
      }
   }
   // method that performs matrix arithmetic on 
   // a remote server
   private void compute( Matrix mm ) 
   {
      try 
      {
         int[ ][ ] result1 = mm.add( m1, m2 );
         displayOutput( result1 );
         int[ ][ ] result2 = mm.subtract( m1, m2 );
         displayOutput( result2 );
      }
      catch( Exception e ) 
      {
         System.err.println( e );
         return;
      }
   }
   // method to display a matrix
   private void displayOutput( int[ ][ ] output )
   {
      for ( int i = 0; i < output.length; i++ )
      {
         System.out.println();
         for ( int j = 0; j < output[ 0 ].length; j++ )
         {
            System.out.print( output[ i ][ j ] + " " );
         }
      }
      System.out.println( "\n" );
   }
   // instance variables
   private int[ ][ ] m1;
   private int[ ][ ] m2;
}
