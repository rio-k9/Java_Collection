package rio;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/*
 *   @author rio
 * 
 */

@SuppressWarnings("serial")
public class Setup extends JFrame {

	JPanel contentPane;
	/**
	 * Create the contentPane.
	 */
	Start StartConstructor = new Start();  //CODE TO CALL METHOD FROM Start (Start.JAVA) CLASS
	public Setup() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		//AS THE LOGO AND POSITION STAYS THE SAME WE CALL IT FROM THE Start CLASS
		StartConstructor.Logo(contentPane); //CODE TO CALL METHOD FROM Start (Start.JAVA) CLASS
		contentPane.add(Start.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS
		contentPane.setLayout(null);
		
		JLabel logoStartStart = new JLabel("QUIZ SETUP");   //EASIER TO 
		logoStartStart.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoStartStart.setHorizontalAlignment(SwingConstants.CENTER);
		logoStartStart.setBounds(200, 30, 200, 50);
		contentPane.add(logoStartStart);
		
		JButton buttonSelect = new JButton("Select Topic");
		buttonSelect.setToolTipText("Click here to start the quiz!");
		buttonSelect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonSelect.setBackground(Color.WHITE);
		buttonSelect.setBounds(200, 138, 200, 71);
		contentPane.add(buttonSelect);
		buttonSelect.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        StartConstructor.clickSound();
		    }
		});
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartConstructor.wooshSound();
			}
		});
		
		JButton buttonBrowse = new JButton("Browse Questions");
		buttonBrowse.setToolTipText("Click here to start the quiz!");
		buttonBrowse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBrowse.setBackground(Color.WHITE);
		buttonBrowse.setBounds(200, 220, 200, 71);
		contentPane.add(buttonBrowse);
		buttonBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        StartConstructor.clickSound();
		    }
		});
		buttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartConstructor.wooshSound();
			}
		});
		
		JButton buttonEdit = new JButton("Edit Questions");
		buttonEdit.setToolTipText("Click here to start the quiz!");
		buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonEdit.setBackground(Color.WHITE);
		buttonEdit.setBounds(200, 302, 200, 71);
		contentPane.add(buttonEdit);
		buttonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        StartConstructor.clickSound();
		    }
		});
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartConstructor.wooshSound();
			}
		});
		
		JButton buttonStart = new JButton("Log Out");
		buttonStart.setBounds(10, 427, 101, 23);
		contentPane.add(buttonStart);
		buttonStart.setBackground(UIManager.getColor("activeCaption"));
		buttonStart.setForeground(Color.BLACK);
		buttonStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartConstructor.chimeSound();
				int returnToStart = JOptionPane.showConfirmDialog(null, "You are about to log out and return to the Start Start. \nYour settings will be saved.\n\nContinue?", "Return To Start", JOptionPane.OK_CANCEL_OPTION);
				if (returnToStart == JOptionPane.OK_OPTION) {
					StartConstructor.wooshSound();
					
				}
				else {
					StartConstructor.clickSound();
				}
			}
		});
		
	}
}
