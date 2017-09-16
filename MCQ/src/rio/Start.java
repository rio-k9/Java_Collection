package rio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import rio.CustomTabbedPaneUI.MyMouseHandler;

@SuppressWarnings("serial")
public class Start extends JFrame implements ActionListener {

	CustomTabbedPaneUI customertabConstructor = new CustomTabbedPaneUI();
	static JLabel logoImageAbc = new JLabel();
	JTabbedPane tabbedPane;
	JPanel contentPane;
	Main mainConstructor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		    	chimeSound();
		        String exitButtons[] = {"Exit","Return"};
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?\nData from your current session may be lost or incomplete.","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
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
		setBounds(100, 100, 600, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		Logo(contentPane);
		JButton button = new JButton("Play Quiz");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					wooshSound();
					tabbedPane = new JTabbedPane();
					getContentPane().add(BorderLayout.CENTER, tabbedPane);
				
				  	
			}
		});
		button.setBounds(208, 152, 200, 71);
		contentPane.add(button);
		button.setToolTipText("Click here to start the quiz!");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		
		//QUIZ SETUP BUTTON
		JButton buttonQuizSetup = new JButton("Quiz Setup");
		buttonQuizSetup.setBounds(208, 259, 200, 71);
		contentPane.add(buttonQuizSetup);
		buttonQuizSetup.setToolTipText("Click here to enter question setup and administrator settings.");
		buttonQuizSetup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonQuizSetup.setBackground(Color.WHITE);
		
		JLabel logoMainMenu = new JLabel("MAIN MENU");
		logoMainMenu.setBounds(208, 26, 200, 50);
		contentPane.add(logoMainMenu);
		logoMainMenu.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		buttonQuizSetup.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        clickSound();

		        
		    }
		});
		buttonQuizSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TAB AND CLOSE BUTTON METHOD
			
				
				
		        
				
			}
		});
		//addLogo();
		
	}

/*
	public void addLogo(){
	frame.getContentPane().add(logoImageAbc);
	}
	*/
	/*
	public void newTab() {

		wooshSound();
        Login loginConstructor = new Login();
        String title = "Setup";
        tabbedPane.add(title, loginConstructor.getContentPane());
        int index = tabbedPane.indexOfTab(title);
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        JButton btnClose = new JButton("x");
        btnClose.setMargin(new Insets(0, 0, 0, 0));
        btnClose.setForeground(Color.BLACK);
        btnClose.setBackground(Color.WHITE);
        btnClose.setBounds(37, 307, 23, 23);
        tabbedPane.setSelectedIndex(1);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        pnlTab.add(lblTitle, gbc);
        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(btnClose, gbc);
        tabbedPane.setTabComponentAt(index, pnlTab);
        btnClose.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {

                Component selected = tabbedPane.getSelectedComponent();
                if (selected != null) {

                    tabbedPane.remove(selected);
                }
        	}
        });
        }
        */


	
	
	public void Logo(JPanel xz){

		//CODE TO CALL IMAGE LOGO
		//ImageIcon logoImg = new ImageIcon("/img/Logo.png");
		ImageIcon imageIcon = new ImageIcon("C:/Users/Rio/Desktop/ComSci/Java/SEMenu/src/img/Logo.png");
		//CODE FOR RESIZE
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		System.out.println("Logo Called");
		logoImageAbc.setBounds(31, 26, 50, 50);
		xz.add(logoImageAbc);
		//CODE TO SET IMAGE
		logoImageAbc.setToolTipText("You can do it!");
		logoImageAbc.setIcon(imageIcon);
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	

