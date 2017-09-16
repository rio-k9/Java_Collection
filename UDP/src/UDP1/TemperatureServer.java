package UDP1;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureServer extends UnicastRemoteObject implements Temperature
{
    /**
     * Constructor
     */
    public TemperatureServer() throws RemoteException
    {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Create a security manager
        System.setSecurityManager(new SecurityManager());
        try
        {
           Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("temperature", new TemperatureServer());
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public double fahrenheit(double centtemp) throws RemoteException 
    {
        return 9 * centtemp / 5 + 32;
    }

    public double centigrade(double fahtemp) throws RemoteException 
    {
        return (fahtemp - 32) * 5 / 9;
    }
}
