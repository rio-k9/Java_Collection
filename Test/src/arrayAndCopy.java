
public class arrayAndCopy {
	
	public static void main (String args[]){
		
		String[] stringArray = new String[3];
		stringArray[0] = "Hello";
		stringArray[1] = "World";
		stringArray[2] = "My";
		
		String[] newArray = new String[3];
		
		System.arraycopy(stringArray, 0, newArray, 0, stringArray.length);
	}

}
