package kostas;

import java.rmi.*;

public interface DistCalc extends Remote{
    public double CityDist(String city1, String city2) throws RemoteException;
}