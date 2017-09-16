
public class MathTest {
	
	public static void main(String args[]){
		
	int i = 23;
	double d = 3.2;
	double res1 = Math.round((double)i / 5) + d;
	double res2 = (double)(d * (.33333333333333) + i);
	StringBuffer buffer = new StringBuffer("Hello" + i);
	buffer.replace(2,  4,  "abc");
	String res3 = buffer.toString();
	buffer.append("#");
	buffer.reverse();
	String res4 = buffer.toString();
	
	System.out.println("Answer 1 is: " + res1);
	System.out.println("Answer 2 is: " + res2);
	System.out.println("Answer 3 is: " + res3);
	System.out.println("Answer 4 is: " + res4);
	

	}
}
