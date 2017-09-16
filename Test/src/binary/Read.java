package binary;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Read {

	public static void main( String[] args ) {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat") );
			Object myString = in.readObject();
			String returnString = myString.toString();
			System.out.println(returnString);
			in.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}

