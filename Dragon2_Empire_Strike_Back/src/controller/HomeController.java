package controller;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Room;

/**
 * This class is the main controller for our GUI and data structure presenting
 * the house.
 * 
 * @author  Hung Thai
 * @version 6/1/2020
 *
 */
public class HomeController extends JPanel {
	// Share display elements
	
	
	/**
	 * Series for GUI
	 */
	private static final long serialVersionUID = 1422343894321042534L;
	/**
	 * Address of our logo
	 */
	private static String logoAddress = "/image/dragon.jpg";

	/**
	 * Background address
	 */
	private static String konohaAddress = "/image/konoha.png";

	// Log in page display elements

	/**
	 * Main frame for log in page
	 */
	private static JFrame myLoginFrame;

	/**
	 * Panel to display log in picture.
	 */
	private static JLabel myLoginPicture = new JLabel();

	/**
	 * Label to dipsplay login konha image
	 */
	private static JLabel myLoginIcon = new JLabel();

	/**
	 * TextField for User name
	 */
	private static JTextField myUserText;

	/**
	 * TextField for Password field
	 */
	private static JPasswordField myPassText;

	/**
	 * String to store user input
	 */
	private static String userInput;

	/**
	 * String to store user password.
	 */
	private static String userPass;

	/**
	 * Log in button
	 */
	private static JButton myLoginButton;
	
	/**
	 * our JList to display the room in this panel.
	 */
	private static JList myJList;
	

	// Welcome page - My house display elements

	// Room page display elements

	// Item page display elements

	public HomeController() {
		
	
		createAndShowGUI();
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 * 
	 * NOTE: This is the place where all of the parts and pieces of this project are
	 * in the same place. This is where we should instantiate our MOdel and add it
	 * to the controller and view.
	 */
	public static void createAndShowGUI() {
		
		
		/**
		 * WE are going to start initialize our J Components in here to make the code easier to read.
		 */
		
		
		//Initialization. When ever this class is called. Create a JList
		
		
		myJList = new JList();
		loginPage();

	}

	public static void loginPage() {
		// Login page stuffs
		myLoginFrame = new JFrame("Login Page");
		myLoginFrame.setBounds(350, 100, 1295, 750); //740
		myLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myLoginFrame.getContentPane().setLayout(null);
		myLoginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(HomeController.class.getResource(logoAddress)));

		// Create a JLabel and put a picture on top of that label to creat welcome
		// picture
		myLoginPicture.setIcon(new ImageIcon(HomeController.class.getResource("/image/nar2.jpg")));
		myLoginPicture.setBounds(400, 0, 1295, 720);

		// Create JLabel for Konoha logo
		myLoginIcon.setIcon(new ImageIcon(HomeController.class.getResource(konohaAddress)));
		myLoginIcon.setBounds(130, 100, 135, 135);

		// Creat Textfield for Username
		myUserText = new JTextField("");
		myUserText.setBounds(75, 300, 250, 50);

		// Create text field for password
		myPassText = new JPasswordField();
		myPassText.setBounds(75, 400, 250, 50);

		// Create a log in button
		myLoginButton = new JButton("Log in");
		myLoginButton.setBounds(110, 500, 175, 30);
		myLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				// Overriding method below.
			}
		});

		// Put these two Jtext field on the panel

		myLoginFrame.getContentPane().add(myLoginPicture);
		myLoginFrame.getContentPane().add(myUserText);
		myLoginFrame.getContentPane().add(myPassText);
		myLoginFrame.getContentPane().add(myLoginButton);
		myLoginFrame.getContentPane().add(myLoginIcon);

		// Important. Set the frame to visible
		myLoginFrame.setVisible(true);
		
		//Stop user resizing frames
		myLoginFrame.setResizable(false);

		addListener();

	}

	/**
	 * Helper method to add the action listener to our Button and text field in log
	 * in page. We cant add action in static method so we have to create a helper
	 * method and do it here instead.
	 */
	public static void addListener() {

		myLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				userInput = myUserText.getText();
				userPass = new String(myPassText.getPassword());
				if (checkLogin(userInput, userPass)) {
				
				
					new RoomController();
					myLoginFrame.dispose();
				
				} else
					JOptionPane.showMessageDialog(null, "Wrong Pass bro");


			}
		
		});

	}

	/**
	 * Helper method to check if this is the correct user and password
	 */
	public static boolean checkLogin(String userInput, String userPass2) {
		String user = "Jeffrey";
		String pass = "isacoolguy";

		if (userInput.equals(user) && userPass2.equals(pass)) {
			return true;
		}
		return false;
	}

}