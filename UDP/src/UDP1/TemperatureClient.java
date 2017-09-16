package UDP1;
import java.rmi.*;
public class TemperatureClient 
{
    public static void main( String [] args )
    {
        try
        {
            // get object reference to server methods
            Temperature objRef = (Temperature)Naming.lookup("rmi://localhost/temperature");
            double cent1 = 10, cent2;
            double fah1, fah2 = 32;
            fah1 = objRef.fahrenheit(cent1);
            cent2 = objRef.centigrade(fah2);
            
            System.out.println(cent1 + " C => " + fah1 + " F");
            System.out.println(fah2 + " F => " + cent2 + " C");
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
