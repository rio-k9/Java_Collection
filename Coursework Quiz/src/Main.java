import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Main {

	static JLabel logoImageAbc = new JLabel();

	public static Component logoImageAbc1;  //ALLOWS ME TO USE THE LOGO IMAGE VARIABLE ACROSS ALL CLASSES

	JFrame frame;

	//LAUNCH A JAVA WINDOW
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CREATES AN EXECUTABLE APPLICATION
	public Main() {
		initialize();
		Logo();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		    	chimeSound();
		        String exitButtons[] = {"Exit","Return"};
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
		        if(exitAttempt == JOptionPane.YES_OPTION)
		        {
		        	clickSound();
		            System.exit(0);
		        }

		        else {
		        	clickSound();
		        }
		       
		    }
		});
		
	}
/*
	public void addLogo(){
	frame.getContentPane().add(logoImageAbc);
	}
	*/
	
	public void Logo(){

		//CODE TO CALL IMAGE LOGO
		//ImageIcon logoImg = new ImageIcon("/img/Logo.png");
		ImageIcon imageIcon = new ImageIcon("C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/Logo.png");
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
		//addLogo();
	}
	
	public void clickSound(){
		try {
			System.out.println("Click!");
			String soundName = "C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/click.wav";    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void chimeSound(){
		try {
			System.out.println("Chime!");
			String soundName = "C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/chime.wav";    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void wooshSound(){
		try {
			System.out.println("Woosh!");
			String soundName = "C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/woosh.wav";    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


	
	//MAIN MENU BANNER


	//CODE TO INITIALISE FRAME
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel logoMainMenu = new JLabel("MAIN MENU");
		logoMainMenu.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		logoMainMenu.setBounds(200, 30, 200, 50);
		frame.getContentPane().add(logoMainMenu);
		
		//QUIZ SETUP BUTTON
		JButton buttonQuizSetup = new JButton("Quiz Setup");
		buttonQuizSetup.setToolTipText("Click here to enter question setup and administrator settings.");
		buttonQuizSetup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonQuizSetup.setBackground(Color.WHITE);
		buttonQuizSetup.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        clickSound();
		    }
		});
		buttonQuizSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wooshSound();
				frame.dispose();
				Login loginConstructor = new Login();
				loginConstructor.setVisible(true);
			}
		});
		buttonQuizSetup.setBounds(200, 290, 200, 71);
		frame.getContentPane().add(buttonQuizSetup);
		
		//QUIZ PLAY BUTTON
		JButton buttonPlayQuiz = new JButton("Play Quiz");
		buttonPlayQuiz.setToolTipText("Click here to start the quiz!");
		buttonPlayQuiz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonPlayQuiz.setBackground(Color.WHITE);
		buttonPlayQuiz.setBounds(200, 175, 200, 71);
		frame.getContentPane().add(buttonPlayQuiz);
		buttonPlayQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        clickSound();
		    }
		});
		buttonPlayQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wooshSound();
				frame.dispose();
				Play playConstructor = new Play();
				playConstructor.setVisible(true);
			}
		});
		

	}
}
