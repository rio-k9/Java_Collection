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
import javax.swing.JTabbedPane;
import java.awt.SystemColor;

/*
 *   @author rio
 * 
 */

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	CustomTabbedPaneUI customertabConstructor = new CustomTabbedPaneUI();
	JTabbedPane tabbedPane;
	JPanel contentPane;

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
	        	StartConstructor.wooshSound();
	        	 Setup setupConstructor = new Setup();
			     tabbedPane.add("Setup", setupConstructor.contentPane);
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
		        StartConstructor.wooshSound();
		        
		        //CHANGE ALL ABOVE TO JPANEL TEXT
				//GET CODE FROM BACKUP THIS IS TO SAY IN OUR JPANEL YOUR LOGIN FAILED IN RED 3 TIMES
				failed_login_limit = 3;
			}
		}
	}
	
	Start StartConstructor = new Start();
	private JPasswordField passwordField;
	private JTextField textField;
	public Login() {
		
		ImageIcon imgSettings = new ImageIcon("C:/Users/Rio/Desktop/ComSci/Java/SEStart/src/img/Settings.png");
		Image image = imgSettings.getImage();
		Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
		imgSettings = new ImageIcon(newimg);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JLabel logoMainStart = new JLabel("ADMIN LOGIN"); 
		logoMainStart.setBounds(197, 11, 200, 50);
		contentPane.add(logoMainStart);
		logoMainStart.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoMainStart.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel iconSettings = new JLabel();
		iconSettings.setBounds(32, 125, 180, 180);
		iconSettings.setIcon(imgSettings);
		contentPane.add(iconSettings);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(274, 217, 265, 40);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(274, 136, 265, 40);
		contentPane.add(textField);
		
		JLabel enterUser = new JLabel("Username:");
		enterUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		enterUser.setBounds(274, 97, 265, 33);
		contentPane.add(enterUser);
		
		JLabel enterPassword = new JLabel("Password:");
		enterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		enterPassword.setBounds(274, 187, 265, 33);
		contentPane.add(enterPassword);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartConstructor.clickSound();
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
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(308, 291, 200, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Close Tab");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(10, 399, 89, 23);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//FILL IN CODE FROM BACKUP
				
				
			}
		});
		
		
		
	}
}

