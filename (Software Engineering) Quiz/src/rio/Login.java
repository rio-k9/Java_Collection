package rio;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tim.Verify;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	private JPanel contentPane;
	private JPasswordField enterPassword;
	private JTextField enterUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * @return 
	 */
	int failed_login_limit = 3;
	public void authToken(Boolean tokenState) {
		System.out.println(tokenState);
		if (tokenState == true) {
			
			String loginButton[] = {"Ok"};
	        int loginConfirm = JOptionPane.showOptionDialog(null,"Login successful!","Login",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,loginButton, null);
	        if(loginConfirm == JOptionPane.OK_OPTION)
	        {
	        	
	        	
	        	dispose();  //FRAME NOT DISPOSING
	        	
	        	
	        	contentPane.setVisible(false);
				Setup setupConstructor = new Setup();
				setupConstructor.setVisible(true);
				MainConstructor.wooshSound();
	        }
		}
		else {
			failed_login_limit--;
			String attemptButton[] = {"Ok"};
	        JOptionPane.showOptionDialog(null,"Login failed. " + failed_login_limit + " attempts remaining.\nLogin credentials are case-sensitive.","Login",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,attemptButton, null);
			System.out.println("login failed.");
			if (failed_login_limit <= 0){
				String failedButton[] = {"Ok"};
		        JOptionPane.showOptionDialog(null,"Please contact an event administrator for help setting up the quiz.","Exit",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,failedButton, null);
		        MainConstructor.wooshSound();
		        
		        
				dispose(); //FRAME NOT DISPOSING
				
				
				contentPane.setVisible(false);
				Main mainConstructor = new Main();
				mainConstructor.frame.setVisible(true);
				failed_login_limit = 3;
			}
		}
	}
	
	Main MainConstructor = new Main();
	public Login() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		    	MainConstructor.chimeSound();
		        String exitButtons[] = {"Exit","Return"};
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
		        if(exitAttempt == JOptionPane.YES_OPTION)
		        {
		        	MainConstructor.clickSound();
		            System.exit(0);
		        }
		        else {
		        	MainConstructor.clickSound();
		        }
		    }
		});
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//AS THE LOGO AND POSITION STAYS THE SAME WE CALL IT FROM THE MAIN CLASS
  //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
		MainConstructor.Logo(); //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
		getContentPane().add(Main.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS
		contentPane.setLayout(null);
		
		//RATHER THAN CALL THE PREVIOUS LABEL, EASIER TO REWRITE THE CODE TO AMMEND THE HEADER TEXT
		JLabel logoMainMenu = new JLabel("ADMIN LOGIN");   //EASIER TO 
		logoMainMenu.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		logoMainMenu.setBounds(200, 30, 200, 50);
		getContentPane().add(logoMainMenu);
		
		enterPassword = new JPasswordField();
		enterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		enterPassword.setBackground(UIManager.getColor("controlHighlight"));
		enterPassword.setBounds(277, 246, 265, 40);
		contentPane.add(enterPassword);
		
		enterUser = new JTextField();
		enterUser.setHorizontalAlignment(SwingConstants.CENTER);
		enterUser.setBackground(UIManager.getColor("controlHighlight"));
		enterUser.setBounds(277, 162, 265, 40);
		contentPane.add(enterUser);
		enterUser.setColumns(10);
		
		
		JLabel labelUser = new JLabel("Username:");
		labelUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUser.setBounds(277, 127, 265, 33);
		contentPane.add(labelUser);
		
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPassword.setBounds(277, 213, 265, 33);
		contentPane.add(labelPassword);
		
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setBackground(UIManager.getColor("activeCaption"));
		buttonLogin.setForeground(Color.BLACK);
		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				MainConstructor.clickSound();
				String u_User = enterUser.getText();
				String u_Pass = enterPassword.getText();
				System.out.println(u_User);
				System.out.println(u_Pass);
				tim.Verify verifyMe = new Verify();
				try {
					verifyMe.Sync(u_User, u_Pass);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		buttonLogin.setBounds(313, 313, 200, 40);
		contentPane.add(buttonLogin);
		
		JLabel iconSettings = new JLabel();
		iconSettings.setBounds(34, 150, 180, 180);
		ImageIcon imgSettings = new ImageIcon("C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/Settings.png");
		Image image = imgSettings.getImage();
		Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
		imgSettings = new ImageIcon(newimg);
		contentPane.add(iconSettings);
		iconSettings.setIcon(imgSettings);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.setBounds(10, 427, 89, 23);
		contentPane.add(buttonBack);
		buttonBack.setBackground(UIManager.getColor("activeCaption"));
		buttonBack.setForeground(Color.BLACK);
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					
				
					MainConstructor.wooshSound();
					dispose();
					Main mainConstructor = new Main();
					mainConstructor.frame.setVisible(true);

				
				
			}
		});
		
		
	}
	
}

/*
public static void Input(){
String uInput = "admin";
System.out.println(uInput);
String pInput = "admin";
System.out.println(pInput);
}

*/
	/*
	String u_User = ""; //adminJango
	String u_Pass = "";//adminFett

	
	public void setUser(String x){
		this.u_User = x;
	}
	
	public String getUser() {
		return u_User;
	}
	
	public void setPass(String j){
		this.u_Pass = j;
	}
	
	public String getPass() {
		return u_Pass;
	}
	*/
//MainConstructor.chimeSound();
//int returnToMenu = JOptionPane.showConfirmDialog(null, "You are about to return to the main menu. Any user information entered will be lost.\nContinue?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
//if (returnToMenu == JOptionPane.OK_OPTION) {
//}

		
		
		/*	public void Logo(){

			//CODE TO CALL IMAGE LOGO
			//ImageIcon logoImg = new ImageIcon("/img/Logo.png");
			ImageIcon iconSettings = new ImageIcon("C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/Settings.png");
			//CODE FOR RESIZE
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			//CODE TO SET IMAGE
			logoImageAbc.setToolTipText("You can do it!");
			logoImageAbc.setIcon(imageIcon);
			logoImageAbc.setBounds(40, 30, 50, 50);
			System.out.println("Logo Called");
			frame.getContentPane().add(logoImageAbc); 
	}  */

//StringBuilder stringBuilder = new StringBuilder();
//stringBuilder.append(enterUser.getText());
//stringBuilder.append(enterPassword.getText());


//private String u_User = ""; //adminJango
//private String u_Pass = "";//adminFett

/* RIGHT HERE IS WHERE WE NEED AN IF ELSE STATEMENT TO VERIFY CORRECT LOGIN DETAILS WITH ADMIN AND USERNAME MODULE
 * 
 * else {
 * confirm dialog "Incorrect details, please try again or return to main menu"
 * 
 */
//dispose();
//Setup setupConstructor = new Setup();
//setupConstructor.setVisible(true);
//MainConstructor.wooshSound();

