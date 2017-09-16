//
// Matrix Interface
//
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Matrix extends Remote 
{
   // method to add matrices
   public int[ ][ ] add( int[ ][ ] a, int[ ][ ] b ) 
      throws RemoteException;
   // method to subtract matrices
   public int[ ][ ] subtract( int[ ][ ] a, int[ ][ ] b ) 
      throws RemoteException;
}
