
public class TypeCasting {
	   public static void main( String[] args )
	   {
		   int a = 10;// 10
		   
		   double b = a; //upcasting  10 -> 10.0
		   
		   int c = (int) b; //downcasting 10.0 -> 10 
		   //without (int) error will be thrown
		   System.out.println(a +" " + " " + b + " " + " " + c);
	   }
}