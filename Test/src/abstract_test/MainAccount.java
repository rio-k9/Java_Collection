package abstract_test;

public class MainAccount {
    public static void main(String args[]){

        FlatRateAccount flatPayment = new FlatRateAccount(20,1,"john");
        MeterdAccount meterPayment = new MeterdAccount(6,"John",1);

        System.out.println(totalCost(flatPayment,meterPayment));
        System.out.println("Flat Payment ==  " + totalCost(flatPayment));

    }
    public static String totalCost (Account flatRate, Account meteredAccount){
        return "The total cost for "  + flatRate.getname() + "  is " + (
        		flatRate.calcBill() + meteredAccount.calcBill());
    }

    public static String totalCost (Account account){
        return "The cost is " + account.calcBill();
    }
}
