
public class Q1C_Student extends Q1C_User{
	
	public void getEntitlement(int booksHeld, String StaffStudent){
		
		System.out.println("Asking the librarian...");
		booksHeld++;
		if (booksHeld <= 12 && StaffStudent == "student") {
			
			System.out.println("Book Given! Now thou shallt study");
		}
		
		else {
			
			System.out.println("No book for you, get outta here");
		}
		
	}
	

}
