package kostas;

import java.rmi.Naming;

public class DistClient {
	//main method
	public static void main(String[] args){
		try{
			DistCalc objRef = (DistCalc) Naming.lookup("rmi://localhost/distcalc");
			System.out.println("Distance between the two cities is " + objRef.CityDist("Katerini", "Cardiff"));
		}
		catch (Exception e){
			System.err.println(e);
		}
	}
}
