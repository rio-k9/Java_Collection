/*  CLASS #4
 * 
 * MAIN METHOD FOR CONTROLLING JAVAFX WINDOW VIA SCENEBUILDER
 * 
 */

package application;
public class Model {
	
	/*
	 * 
	 *  Switch loop for calculator numbers and operators
	 * 
	 */
	public float calculate(long number1, float number2, String operator) {
		switch (operator) {
		//could also use the case for switch as an argument passed through by .getText of operator button
		case "+":
			System.out.println("+ called" + (number1 + number2));
			//return result to class that called it
			return number1 + number2;
			//could also use the case for switch as an argument passed through by .getText of operator button
		case "-":
			System.out.println("- called" + (number1 - number2));
			//return result to class that called it
			return number1 - number2;	
			//could also use the case for switch as an argument passed through by .getText of operator button
		case "*":
			System.out.println("* called" + (number1 * number2));
			//return result to class that called it
			return number1 * number2;
			//could also use the case for switch as an argument passed through by .getText of operator button
		case "/":
			if (number2 == 0){
				return 0;
			}
			System.out.println("/ called" + (number1 / number2));
			//return result to class that called it
			return number1 / number2;		
		default:
			return 0;
		}
	}
	

}
