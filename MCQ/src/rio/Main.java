package rio;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
  
public class Main extends JFrame implements ActionListener {
   JTabbedPane tabbedPane;
  
   public Main() {
      getContentPane().setLayout(new BorderLayout());
      tabbedPane = new JTabbedPane();
      tabbedPane.setUI(new CustomTabbedPaneUI());
      startmenuTab();
  
      getContentPane().add(BorderLayout.CENTER, tabbedPane);
      setJMenuBar(createMenuBar());
   
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
            System.exit(0);
         }
      });
    
      setTitle("JTabbedPane Orientation Demonstration");
      setSize(new Dimension(600, 500));
   }
  
   protected JMenuBar createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
  
      JMenu menu1 = new JMenu("File");
      JMenuItem menuItem1 = new JMenuItem("Main Menu");
      JMenuItem menuItem2 = new JMenuItem("Login");
      menuItem1.addActionListener(this);
      menuItem2.addActionListener(this);
      menu1.add(menuItem1);
      menu1.add(menuItem2);
      menuBar.add(menu1);
      
      
  
      return menuBar;
   }
   
   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Main Menu")) {
         startmenuTab();
      }
      
      else if (e.getActionCommand().equals("Login")) {
    	  loginTab();
      }
   }
  
   public void startmenuTab() {
      
      Start startConstructor = new Start();
      tabbedPane.add("   Main Menu   ", startConstructor.contentPane);
   }
   
   public void loginTab() {
	      
	      Login loginConstructor = new Login();
	      
	      tabbedPane.add("   Login   ", loginConstructor.contentPane);
	   }
  
   public static void main(String []args) {
      Main main = new Main();
      main.show();
   }
}
  
class CustomTabbedPaneUI extends MetalTabbedPaneUI
{
   Rectangle xRect;
  
   public void installListeners() {
      super.installListeners();
      tabPane.addMouseListener(new MyMouseHandler());
      System.out.println("Mouse Listener Summoned");
   }
  
   public void paintTab(Graphics g, int tabPlacement,
                           Rectangle[] rects, int tabIndex,
                           Rectangle iconRect, Rectangle textRect) {
      super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
  
      Font f = g.getFont();
      g.setFont(new Font("Courier", Font.BOLD, 10));
      FontMetrics fm = g.getFontMetrics(g.getFont());
      int charWidth = fm.charWidth('x');
      int maxAscent = fm.getMaxAscent();
      g.drawString("x", textRect.x + textRect.width - 3, textRect.y + textRect.height - 3);
      g.drawRect(textRect.x+textRect.width-5,
                 textRect.y+textRect.height-maxAscent, charWidth+2, maxAscent-1);
      xRect = new Rectangle(textRect.x+textRect.width-5,
                 textRect.y+textRect.height-maxAscent, charWidth+2, maxAscent-1);
      g.setFont(f);
      System.out.println("calling custom tab 'X' implementation");
    }
  
    public class MyMouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            System.out.println(e);
            if (xRect.contains(e.getPoint())) {
               JTabbedPane tabPane = (JTabbedPane)e.getSource();
               int tabIndex = tabForCoordinate(tabPane, e.getX(), e.getY());
               tabPane.remove(tabIndex);
               System.out.println("Calling remove tab via 'x' mouse handler");
            }
        }
    }
}