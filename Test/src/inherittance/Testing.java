package inherittance;

public class Testing {
	
	public static void main(String args[]){
		

	Beef beefConstructor = new Beef();
	beefConstructor.eat();
	super(Dishes);
	Tuna tunaConstructor = new Tuna();
	tunaConstructor.eat();
	
	//Extends also Daisy Chain, if Beef extended Tuna and Tuna extended Food
	//Unless there is an Override in Tuna, both will inherit the Eat Method.
	}

}
