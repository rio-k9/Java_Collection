package rio;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


/*
 *  @author Rio Karim
 * 
 */

@SuppressWarnings("serial")
public class Setup extends JFrame {

	JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setup contentPane = new Setup();
					contentPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the contentPane.
	 */
	
	Main MainConstructor = new Main();  //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
	public Setup() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String exitButtons[] = {"Exit","Return"};
		        MainConstructor.chimeSound();
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
		        if(exitAttempt == JOptionPane.YES_OPTION)
		        {	
			        MainConstructor.clickSound();
		            System.exit(0);
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
		MainConstructor.Logo(); //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
		getContentPane().add(Main.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS
		contentPane.setLayout(null);
		
		JLabel logoMainMenu = new JLabel("QUIZ SETUP");   //EASIER TO 
		logoMainMenu.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		logoMainMenu.setBounds(200, 30, 200, 50);
		getContentPane().add(logoMainMenu);
		
		JButton buttonSelect = new JButton("Placeholder");
		buttonSelect.setToolTipText("Click here to start the quiz!");
		buttonSelect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonSelect.setBackground(Color.WHITE);
		buttonSelect.setBounds(200, 138, 200, 71);
		getContentPane().add(buttonSelect);
		buttonSelect.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        MainConstructor.clickSound();
		    }
		});
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainConstructor.wooshSound();
			}
		});
		
		JButton buttonBrowse = new JButton("Browse Topics");
		buttonBrowse.setToolTipText("Click here to start the quiz!");
		buttonBrowse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBrowse.setBackground(Color.WHITE);
		buttonBrowse.setBounds(200, 220, 200, 71);
		contentPane.add(buttonBrowse);
		buttonBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
		    	
		        MainConstructor.clickSound();
				
		    }
		});
		
		
		
		
		
		
		buttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Topics topicsConstructor = new Topics();
					topicsConstructor = new Topics();
			        topicsConstructor.setVisible(true);
			        MainConstructor.wooshSound();
			        dispose();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton buttonEdit = new JButton("Placeholder");
		buttonEdit.setToolTipText("Click here to start the quiz!");
		buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonEdit.setBackground(Color.WHITE);
		buttonEdit.setBounds(200, 302, 200, 71);
		contentPane.add(buttonEdit);
		buttonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        MainConstructor.clickSound();
		    }
		});
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainConstructor.wooshSound();
			}
		});
		
		JButton buttonMenu = new JButton("Log Out");
		buttonMenu.setBounds(10, 427, 101, 23);
		contentPane.add(buttonMenu);
		buttonMenu.setBackground(UIManager.getColor("activeCaption"));
		buttonMenu.setForeground(Color.BLACK);
		buttonMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainConstructor.chimeSound();
				int returnToMenu = JOptionPane.showConfirmDialog(null, "You are about to log out and return to the main menu. \nYour settings will be saved.\n\nContinue?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
				if (returnToMenu == JOptionPane.OK_OPTION) {
					MainConstructor.wooshSound();
					dispose();
					Main mainConstructor = new Main();
					mainConstructor.frame.setVisible(true);
				}
				else {
					MainConstructor.clickSound();
				}
			}
		});
		
	}
}
