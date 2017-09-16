import java.util.ArrayList;
import java.util.HashMap;

public class Q_1Biii {
	
	static double minimum;

    @SuppressWarnings("rawtypes")
	public static void main (String[] args)  {

    	
    	ArrayList<Double> number = new ArrayList<>();
    	
    	number.add(23.55);
    	number.add(11.55);
    	number.add(9.25);
    	number.add(73.82);
    	minimum = 0.00;
    	
    	for (int i = 0; i<number.size();i++){
    		if (number.get(i) < number.get(0)) {
    			minimum = number.get(i);
    		}
    					
    	}
    	System.out.println(minimum);    	
    }

}