package UDP1;
import java.rmi.*;

public interface Temperature extends Remote {
	    public double fahrenheit (double centtemp) throws RemoteException;
	    public double centigrade (double fahtemp) throws RemoteException;
	}



