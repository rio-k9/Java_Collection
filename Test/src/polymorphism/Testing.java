package polymorphism;

public class Testing {
	
	public static void main(String args[]){
		
	Food polyArray[] = new Food[2];
	//Here we are using the super class to create an object array
	polyArray[0] = new Tuna();
	polyArray[1] = new Beef();
	//we are then placing each subclass object into the array
	
	for (int x = 0; x <= 1; x++){
		polyArray[x].eat();
		//We are calling each object that contains an 'eat()' override	
	}
		//This is polymorphism, here we have changed the behaviour of the standard inherritence
		//By using the Food object it knows to reference the subclasses associated with it
	
	}

}
