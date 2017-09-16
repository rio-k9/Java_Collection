package hashiterate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class iterateHash {
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		HashMap<String, String> zooAnimals = new HashMap<String, String>();
		zooAnimals.put("Desert", "Camel");
		zooAnimals.put("Forest", "Tiger");
		zooAnimals.put("Savannah", "Lion");
		zooAnimals.put("Mountain", "Eagle");
		
	    Iterator<Entry<String, String>> it = zooAnimals.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}

}
