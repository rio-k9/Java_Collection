public class MethodScope {
    public static void main(String[] args) {
        int i = 0;
        System.out.println("i in main : " + i );
        method1(i);
        // Following will not compile - a is only "in scope"
        // within the method method1
        //a++;
        
        // Note the variable i is unchanged in main despite
        // the argument a being modified
        System.out.println("i in main : " + i );
        method2(i);

        // Same is true for method2 even though the argument 
        // has the same name. 
        System.out.println("i in main : " + i );
        
    }
    
    public static void method1(int a) {
        System.out.println("a in method1 : " + a);
        a = 50;
        System.out.println("a in method1 : " + a);
    }
    
    public static void method2(int i) {
        // The variable i from main is not in scope here - only
        // the argument i.
        System.out.println("i in method1 : " + i);
        i = 99;
        System.out.println("i in method1 : " + i);
    }
}         
