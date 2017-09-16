package draftpackage;
public class Q_1D_FlatRateAccount extends Q_1D_Account {
	
	
	
	public double getFlatRate() {
		
		String customerName = Person();
		
		double flatRate = 20.30;
		
		System.out.println(customerName + " owes the Water Company a flat rate of: " + flatRate);
		return flatRate;
	}
  

}