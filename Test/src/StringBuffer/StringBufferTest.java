package StringBuffer;

public class StringBufferTest {
	
	public static void main(String args[]) {
		
		StringBuffer buffer = new StringBuffer("HelloAll");
		System.out.println(buffer); // >> HelloAll
		
        String subString = buffer.substring(1,5);
        System.out.println(subString); //  >> ello
        
        buffer.setCharAt(2,'X');
        System.out.println(buffer.toString()); // >> HeXloAll
        
        char[] arr = new char[4];
        buffer.getChars(0,4,arr,0);
        System.out.println(arr[0]); // >> H	
        
        String bufferToString = buffer.toString();
        String goodBye = bufferToString.replace("Hello", "Goodbye");
        System.out.println(goodBye); // >> GoodbyeAll
	}
}
