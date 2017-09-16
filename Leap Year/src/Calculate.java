import java.util.Scanner; //REQUIRED IMPORT TO ASK FOR INPUT FROM USER IN JAVA INTERFACE

public class Calculate {
	

	
	public static void main (String[] args)
	{
		//REQUIRED SYNTAX TO ASK FOR INLINE INPUT FROM USER
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int currentYear = reader.nextInt(); // Scans the user input and assigns as an Int variable
		
		
		System.out.println(currentYear);
		
		if (currentYear % 100 == 0 && currentYear % 400 == 0 || currentYear % 100 != 0 && currentYear % 4 == 0) {
			
			System.out.println("The year " + currentYear + " is a leap year!");
		
		}
		else {
			System.out.println("The year " + currentYear + " is not a leap year.");
		}
		
	}
	

}
