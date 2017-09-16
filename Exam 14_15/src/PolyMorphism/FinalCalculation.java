package PolyMorphism;

/**
 * Created by grjka on 06/05/2017.
 */
public class FinalCalculation {
    public static void main(String args[]){

        FlatRateAccount flatPayment = new FlatRateAccount(20,1,"john");
        MeterdAccount meterPayment = new MeterdAccount(6,"John",1);
        //recieve user id with each payment

        System.out.println(totalCost(flatPayment,meterPayment));
        System.out.println("Flat Payment ==  " + totalCost(flatPayment));

    }
    public static String totalCost (Account flatRate, Account meteredAccount){
        return "The total cost for "  + flatRate.getname() + "  is " + (flatRate.calcBill() + meteredAccount.calcBill());
    }
    //work out the total cost

    public static String totalCost (Account account){
        return "The cost is " + account.calcBill();
    //assigns total cost to the account name
    }

}
