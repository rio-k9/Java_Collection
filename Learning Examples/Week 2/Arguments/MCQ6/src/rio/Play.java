package rio;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Insets;


/*
 *  @author Rio Karim
 * 
 */


@SuppressWarnings("serial")
public class Play extends JFrame {

	private JPanel contentPane;
	JRadioButton radio_1;
	JRadioButton radio_2;
	JRadioButton radio_3;
	JRadioButton radio_4;

	/**
	 * Launch the application window.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Main MainConstructor = new Main();  
	public Play() {
		style();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //DISABLES 'X' BUTTON ON WINDOW
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		    	MainConstructor.chimeSound();
		        String exitButtons[] = {"Exit","Return"}; //DIALOG BOX TO CONFIRM QUIZ EXIT
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?\nData from your current session may be lost or incomplete.","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
		        if(exitAttempt == JOptionPane.YES_OPTION)
		        {
		        	MainConstructor.clickSound(); //IF YES SYSTEM EXIT
		            System.exit(0);
		        }
		        else {
		        	MainConstructor.clickSound(); //ELSE DO NOTHING
		        }
		    }
		});
		
		
		
		
		//NEXT BUTTON AND RADIO BUTTON LISTENERS
		JButton buttonNext = new JButton("Next Question");
		buttonNext.setMargin(new Insets(2, 5, 2, 5));
		buttonNext.setHorizontalTextPosition(SwingConstants.LEADING);
		buttonNext.setIconTextGap(10);
		buttonNext.setIcon(new ImageIcon("src/img/next.png")); //STYLING FOR NEXT BUTTON
		
		buttonNext.setFont(new Font("MV Boli", Font.PLAIN, 16));
		buttonNext.setBounds(406, 410, 168, 41);
		contentPane.add(buttonNext);
		
		buttonNext.addActionListener(new ActionListener() { //NEXT LISTENER
			
			
			private String radioText;
			public void actionPerformed(ActionEvent arg0) {
				MainConstructor.clickSound();
				/*
				 * WHEN NEXT IS CLICKED, CHECKING WHICH RADIO BUTTON IS SELECTED
				 */
				radioText = "";
				if (radio_1.isSelected()){
					radioText = radio_1.getText();
					//GETTING STRING FOR WHICHEVER RADIO BUTTON IS CLICKED
					/*
					 * This can be changed to integer IE int RadioText = 1;
					 */
				}
				else if (radio_2.isSelected()){
					radioText = radio_2.getText();
					/*
					 * This can be changed to integer IE int RadioText = 2;
					 */
				}
				else if (radio_3.isSelected()){
					radioText = radio_3.getText();
					/*
					 * This can be changed to integer IE int RadioText = 3;
					 */
				}
				else if (radio_4.isSelected()){
					radioText = radio_4.getText();
					/*
					 * This can be changed to integer IE int RadioText = 4;
					 */
				}
				
				
				//IF RADIO TEXT IS EMPTY STRING, RETURN AS NO ANSWER SELECTED
				if (radioText == "") {
					int skipQuestion = JOptionPane.showConfirmDialog(null, "You have not selected an answer, if you skip to the next question you will lose a mark.", "Next Question", JOptionPane.OK_CANCEL_OPTION);
					if (skipQuestion == JOptionPane.OK_OPTION){
						MainConstructor.wooshSound();
					}
					/*
					 * Dialog choices for pressing NEXT with no answer selected
					 */
					else {
						MainConstructor.clickSound();
					}
				}
				
				//PROCEED HERE IF STRING IS NOT EMPTY
				else {
					/*
					 * return dialog to confirm your answer
					 */
					int nextQuestion = JOptionPane.showConfirmDialog(null, "You are about to select \"" + radioText + "\" as your answer.\nContinue to the next question?", "Next Question", JOptionPane.OK_CANCEL_OPTION);
					if (nextQuestion == JOptionPane.OK_OPTION){
						MainConstructor.wooshSound();
						/*
						 * CALL METHOD HERE TO GENERATE NEXT QUESTION
						 */
					}
					else {
						MainConstructor.clickSound();
					}
				}
				
			}
		});
		

	}
	
	public void style(){
	setBounds(100, 100, 600, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setBackground(Color.WHITE);
	setContentPane(contentPane);
	contentPane.setLayout(null);



	MainConstructor.Logo(); //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
	getContentPane().add(Main.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS
	contentPane.setLayout(null);

	
	JLabel iconSettings = new JLabel();
	iconSettings.setBounds(34, 110, 180, 180);
	ImageIcon imgSettings = new ImageIcon("src/img/Pasta.JPG");
	Image image = imgSettings.getImage();
	Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
	imgSettings = new ImageIcon(newimg);
	contentPane.add(iconSettings);
	iconSettings.setIcon(imgSettings);
	
	JLabel logoPlay = new JLabel("QUESTION 1/10");   //EASIER TO 
	logoPlay.setFont(new Font("MV Boli", Font.BOLD, 26));
	logoPlay.setHorizontalAlignment(SwingConstants.CENTER);
	logoPlay.setBounds(162, 30, 296, 50);
	getContentPane().add(logoPlay);
	
	JLabel labelQuestion = new JLabel("What is Pasta made out of?", JLabel.CENTER);
	labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);
	labelQuestion.setFont(new Font("Tahoma", Font.PLAIN, 22));
	labelQuestion.setBounds(238, 110, 315, 180);
	contentPane.add(labelQuestion);
	
	/* THIS COULD ALL BE OPTIMISED BY RUNNING A RADIO BUTTON LOOP WITH AN ARRAY OF STRING LABELS 
	 * 
	 * */
	radio_2 = new JRadioButton("Wheat");
	radio_2.setHorizontalAlignment(SwingConstants.CENTER);
	radio_2.setBackground(Color.WHITE);
	radio_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	radio_2.setBounds(196, 329, 109, 23);
	contentPane.add(radio_2);
	
	radio_3 = new JRadioButton("Corn");
	radio_3.setHorizontalAlignment(SwingConstants.CENTER);
	radio_3.setBackground(Color.WHITE);
	radio_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	radio_3.setBounds(307, 329, 109, 23);
	contentPane.add(radio_3);
	
	radio_4 = new JRadioButton("Glitter");
	radio_4.setHorizontalAlignment(SwingConstants.CENTER);
	radio_4.setBackground(Color.WHITE);
	radio_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
	radio_4.setBounds(418, 329, 109, 23);
	contentPane.add(radio_4);
	
	radio_1 = new JRadioButton("Barley");
	radio_1.setHorizontalAlignment(SwingConstants.CENTER);
	radio_1.setBackground(Color.WHITE);
	radio_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	radio_1.setBounds(85, 329, 109, 23);
	contentPane.add(radio_1);
	
	ButtonGroup radioAnswer = new ButtonGroup();
	radioAnswer.add(radio_1);
	radioAnswer.add(radio_2);
	radioAnswer.add(radio_3);
	radioAnswer.add(radio_4);

	/* STILL NEED TO ADD SOUNDS TO NEXT QUESTION BUTTON
	 * AND TO ADD WARNING DIALOG INCASE NO ANSWER HAS BEEN SELECTED "SKIP QUESTION"
	 */
	
	
	JButton buttonMenu = new JButton("Main Menu");
	buttonMenu.setBounds(10, 427, 101, 23);
	contentPane.add(buttonMenu);
	buttonMenu.setBackground(UIManager.getColor("activeCaption"));
	buttonMenu.setForeground(Color.BLACK);
	buttonMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
	buttonMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MainConstructor.chimeSound();
			int returnToMenu = JOptionPane.showConfirmDialog(null, "You are about to return to the main menu. \nThis will reset progress on your quiz.\n\nContinue?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
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


/*
//INACTIVITY TIMER
Action logout = new AbstractAction()
{
	public void actionPerformed(ActionEvent e)
	{
		JPanel contentPane = (JPanel)e.getSource();
		int returnToMenu = JOptionPane.showConfirmDialog(null, "The system has detected prolonged inactivity. \nWould you like to return to the main menu?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
		if (returnToMenu == JOptionPane.OK_OPTION) {
			dispose();
			Main mainConstructor = new Main();
			mainConstructor.frame.setVisible(true);
		}
	}
	
};


InactivityListener listener = new InactivityListener(frame, logout, 5);
listener.start();
		*/
