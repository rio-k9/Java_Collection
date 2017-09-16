package interface_test;


public interface interfacePerson {

    String mood = "sad";
    int age = 23;
    //These variables and methods 
    //must be used in all class:
    	//mainClass implements interfaceClass
    String eat();
    String walk();
    String sleep(int hours);


}
