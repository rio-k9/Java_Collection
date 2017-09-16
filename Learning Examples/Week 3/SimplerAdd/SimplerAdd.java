public class SimplerAdd {
	public static void main( String args[] ) { 
		Input in = new Input();
		int x = in.getInt("Enter first integer"); 
        int y = in.getInt("Enter second integer");
        int sum = x + y;
        System.out.println( "Their sum is " + sum); 
     }
}
