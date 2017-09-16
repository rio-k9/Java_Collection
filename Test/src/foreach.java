import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class foreach {
	public static void main(String args[]){
		
		//LIST ITERATOR AND FOR EACH LOOP
	
	List<String> zooList = new ArrayList<String>();
	zooList.add("Monkey");
	zooList.add("Giraffe");
	zooList.add("Tiger");
	
		for (Iterator<String> i = zooList.iterator(); i.hasNext();) {
		    String Animal = i.next();
		    System.out.println(Animal);
		}
	}
}
