package PolyMorphism;

/**
 * Created by grjka on 06/05/2017.
 */
public class Account {

    private String name;
    private int id;


    public  Account(int id, String name){
        this.id=id;
        this.name = name;
        //create account
    }

    public String getname() {
        return name;
        //return name of account
    }

    public double calcBill() {
    	//default for calc bill
        return 0.0;
    }
}
