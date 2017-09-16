package draftpackage;
public class Q_1D_MeteredAccount extends Q_1D_Account {

		
	
    	public double getMetered() {
    		
    		String customerName = Q_1D_MeteredAccount.Person();
    		
    		double meteredRate = 60.50;
    		System.out.println(customerName + " owes the Water Company a metered rate of: " + meteredRate);
    		
    		
    		
    		return meteredRate;
    	}

    

}