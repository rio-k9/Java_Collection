package draftpackage;
public abstract class Q_1D_Account {

	
		private static Q_1D_FlatRateAccount FlatRateCon = new Q_1D_FlatRateAccount();
		private static Q_1D_MeteredAccount MeteredCon = new Q_1D_MeteredAccount();
		
    	public static String Person() {
    		
    		return "John";
    	}
    	public static void CalcBill(){
    		
    		double metered = MeteredCon.getMetered();
    		double flatrate = FlatRateCon.getFlatRate();
    		System.out.println("In total " + Person() + "'s bill comes to : " + (metered +  flatrate));
    	}
 
}