package application;

public class Model {
	
	
	/*
	 * 
	 *  Switch loop for calculator
	 * 
	 */
	public float calculate(long number1, float number2, String operator) {
		

		switch (operator) {
		case "+":
			System.out.println("+ called" + (number1 + number2));
			return number1 + number2;
			
		case "-":
			System.out.println("- called" + (number1 - number2));
			return number1 - number2;
			
		case "*":
			System.out.println("* called" + (number1 * number2));
			return number1 * number2;
		case "/":
			if (number2 == 0){
				return 0;
			}
			System.out.println("/ called" + (number1 / number2));
			return number1 / number2;
			
		default:
			return 0;
		}
	}
	

}
