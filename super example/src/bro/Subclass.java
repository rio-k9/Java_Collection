package bro;

public class Subclass extends Superclass {
	
	 // overrides printMethod in Superclass
    public void printMethod() {
        
    	super.printMethod();

        System.out.println("Printed in Subclass.");
    }
    public static void main(String[] args) {
        Subclass subclassConstructor = new Subclass();
        subclassConstructor.printMethod();    
    }

}
