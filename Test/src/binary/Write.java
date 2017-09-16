package binary;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Write {

	public static void main( String[] args ) {
		
		try {
			
			Stringify myString = new Stringify("Rio", "Karim");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat") );
	        out.writeObject(myString);
	        out.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	    }
	}
}


