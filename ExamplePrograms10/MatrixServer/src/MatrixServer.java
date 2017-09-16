//
// MatrixServer serves matrix methods
// to remote clients
//
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MatrixServer extends UnicastRemoteObject
                                      implements Matrix
{
   // constructor
   public MatrixServer() throws RemoteException 
   {
      super();
   }
   // method to add matrices
   public int[ ][ ] add( int[ ][ ] a, int[ ][ ] b ) 
        throws RemoteException 
   {
      int n = a.length;
      int[ ][ ] c = new int[ n ][ n ];
      for ( int i = 0; i < n; i++ )
         for ( int j = 0; j < n; j++ ) 
               c[ i ][ j ] = a[ i ][ j ] + b[ i ][ j ];
      return c;            
   }
   // method to subtract matrices
   public int[ ][ ] subtract( int[ ][ ] a, int[ ][ ] b ) 
        throws RemoteException 
   {
      int n = a.length;
      int[ ][ ] c = new int[ n ][ n ];
      for ( int i = 0; i < n; i++ )
         for ( int j = 0; j < n; j++ ) 
               c[ i ][ j ] = a[ i ][ j ] - b[ i ][ j ];
      return c;            
   }
   // the main method
   public static void main( String[ ] args ) 
   {
      System.setSecurityManager( new SecurityManager() );
      try 
      {
          // Creating an RMI registry and listening at 1099 (default port)
          Registry reg = LocateRegistry.createRegistry(1099);   
          // The following assumes an RMI registry is already running
          // Registry reg = LocateRegistry.getRegistry();
          reg.rebind( "matrix", new MatrixServer() );
      } 
      catch( RemoteException e ) 
      { 
         System.err.println( e ); 
      }
   }
}
