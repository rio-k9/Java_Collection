
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapClass {
	
	private static HashMap<String, String> zooAnimals;
	
	public static void main(String args[]) {
		
		zooAnimals = new HashMap<String, String>();
		zooAnimals.put("Desert", "Camel");
		zooAnimals.put("Forest", "Tiger");
		zooAnimals.put("Savannah", "Lion");
		zooAnimals.put("Mountain", "Eagle");
		
		for (Map.Entry<String,String> entry : zooAnimals.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  System.out.println("The " + key + " has " + value + "'s");
			  // do stuff
			}
	    
	 }
	
	/*private static void checkZoo(String environment, String animal){
		
		if (!zooAnimals.containsKey(environment) || !zooAnimals.containsValue(animal))
			System.out.println("Does not exist in the Zoo!");
		else if (zooAnimals.containsValue(animal))

			System.out.println("Yes we have " + animal + "'s in our Zoo!" +
		" it's in the " + animal.getKey() + "" );
		
		
	}*/
	

}
