public class JavaClass {

	
	// INSTANCE VARIABLES
	private final String name;
	private String description;
	private static int staticInstanceVariable = 0;
	private int instanceVariable = 1;

	// CONSTRUCTOR
	public JavaClass( String id, String description ){
		name = id;
		this.description = description; 
	}

	// STATIC METHOD
	public static void staticMethod() {
		System.out.println("JavaClass static method.");
	}

	// STATIC METHOD WITH RETURN
	public static int staticMethodWithReturn() {
		return staticInstanceVariable; // NOTE STATIC DECLARATION FOR VARIABLE IN STATIC METHOD
	}

	// INSTANCE METHOD
	public void instanceMethod() {
		System.out.println("JavaClass instance method.");	
	}

	// INSTANCE METHOD WITH RETURN
	public int instanceMethodWithReturn() {
		return instanceVariable;
	}

	// OVERRIDE toSting() METHOD
	public String toString() {
		return name + " -> " + description;
	}

	public static void main( String[] args ) {

		// Using static methods

		JavaClass.staticMethod();
		staticMethod();
		System.out.println( JavaClass.staticMethodWithReturn() );
		System.out.println( staticMethodWithReturn() );

		// Using instance methods - need to call from instantiated object

		JavaClass jc = new JavaClass("matts_class", "Anatomy of a Java Class");
		jc.instanceMethod();
		System.out.println( jc.instanceMethodWithReturn() );
		System.out.println( jc );

	}

}
