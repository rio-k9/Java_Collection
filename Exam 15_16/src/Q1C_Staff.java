
public class Q1C_Staff extends Q1C_User {
	
	public void getEntitlement(int booksHeld, String StaffStudent){
		
		System.out.println("Asking the librarian...");
		booksHeld++;
		if (booksHeld <= 20 && StaffStudent == "staff") {
			
			System.out.println("Book Given! Thou shall teach thy students");
		}
		
		else {
			
			System.out.println("No book for you, get outta here");
		}
		
	}
	

}
