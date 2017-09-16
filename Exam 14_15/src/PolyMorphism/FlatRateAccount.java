package PolyMorphism;

/**
 * Created by grjka on 06/05/2017.
 */
public class FlatRateAccount extends Account {

    private double flatRate;

    public FlatRateAccount(int flatRate,int id,String name){
        super(id,name);
        this.flatRate=flatRate;
        //assigns the flatrate payment to the id and name passed in argument
    }

    public double calcBill(){
        return 10*(this.flatRate);
        //calculate flatrate bill for this account
    }
}
