package controller;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Item;
import model.PropertyChangeSupportBeans;

/**
 * This class is the main controller for our GUI and data structure presenting
 * the house.
 * 
 * @author  Hung Thai
 * @version 6/1/2020
 *
 */
public class ItemController extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 142453244321042534L;

	/**
	 * Address of logo
	 */
	private static String logoAddress = "/image/dragon.jpg";

	/**
	 * Address of back ground
	 */
	private static String konohaAddress = "/image/konoha.png";

	/**
	 * Address of room page background
	 */
	private static String backAddress = "/image/items.jpg";

	/**
	 * Main frame for room page
	 */
	private static JFrame myMainFrame;

	/**
	 * Panel to display background picture
	 */
	private static JLabel myBackLabel = new JLabel();

	/**
	 * Back to log in button
	 */
	private static JButton myBackButt;

	/**
	 * Textfield where user can put in Room name
	 */
	private static JTextField myTextField;

	/**
	 * A button that allow customer to add string
	 */
	private static JButton myAddText;

	/**
	 * Remove input button
	 */
	private static JButton myRemoveText;

	/**
	 * Drop box that display the rooms we have
	 * 
	 */
	private static JComboBox<String> myComboBox;



	/**
	 * Control the amount of room drop from the Combo box First room start from 1.
	 */
	private static int myComboCount = 1;
	
	//String to get the name property change send in
	private static int changeLight;
	/**
	 * My item object in a room
	 */
	private static Item myItem;

	public ItemController(String itemName) {

		// Create a new Item with this name.

		/**
		 * We should be able to add this as a name OR a string + int ID
		 */
		myItem = new Item(itemName);

		showAndCreateGUI();
		addPropertyChangeListener();
	}

	public static void showAndCreateGUI() {

		// Set the name of this page to what the customer is putting in
		myMainFrame = new JFrame(myItem.getName());

		myMainFrame.setBounds(100, 100, 1295, 740);
		// This code does not have close on default.

		myMainFrame.getContentPane().setLayout(null);
		myMainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(RoomController.class.getResource(logoAddress)));

		// Create a JLabel and put a picture on top of that label to creat welcome
		// picture
		myBackLabel.setIcon(new ImageIcon(ItemController.class.getResource(backAddress)));
		myBackLabel.setBounds(0, 0, 1295, 720);
		/**
		 * BUTTON AREA
		 */
		// Create a back button to the Home page
		myBackButt = new JButton();
		myBackButt.setBounds(20, 20, 40, 40);
		myBackButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				// Overriding method below.
			}
		});
		// Create add Text button
		myAddText = new JButton();
		myAddText.setBackground(Color.BLACK);
		myAddText.setOpaque(true);
		myAddText.setBounds(350, 150, 100, 40);
		myAddText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				// Overriding method below.
			}
		});

		// Create add Text button
		myRemoveText = new JButton();
		myRemoveText.setBackground(Color.GRAY);
		myRemoveText.setOpaque(true);
		myRemoveText.setBounds(603, 150, 100, 40);
		myRemoveText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				// Overriding method below.
			}
		});

		/**
		 * TEXT FIELD AREA
		 */
		// Create a text field
		myTextField = new JTextField();
		myTextField.setBounds(200, 80, 600, 40);
		myTextField.setHorizontalAlignment(JTextField.CENTER);

		/**
		 * COMBO BOX AREA
		 */
		// Create a drop box

		/**
		 * 
		 * 
		 * Control the amount of new room with a static int. This int can be taken as an
		 * input by the customer from the Jtextfield
		 */

		myComboBox = new JComboBox<>(new String[myComboCount]);
		myComboBox.setBounds(200, 240, 600, 60);

		myComboBox.setEditable(true);

		/**
		 * THIS PLACE FOR COMBO COMPONENTS ONLY
		 */

		/**
		 * PLACE FOR FRAME. ADD CONTENT PANE
		 */
		// Add back button
		myMainFrame.getContentPane().add(myBackButt);

		// Add text button
		myMainFrame.getContentPane().add(myAddText);

		// Remove text button
		myMainFrame.getContentPane().add(myRemoveText);

		// Add text field
		myMainFrame.getContentPane().add(myTextField);

		// Add Drop box
		myMainFrame.getContentPane().add(myComboBox);

		/**
		 * WARNING: IMPLEMENTS JCOMPONETS ABOVE THESE LINES
		 */
		// Background pixel size 1276x731

		// Add elements to the main frame. Add ITACHI PICTURE
		myMainFrame.getContentPane().add(myBackLabel);

		// VISIBILITY
		myMainFrame.setVisible(true);

		addListener();
		addPropertyChangeListener();
	}

	private static void addPropertyChangeListener() {
		// Create Instance of PCS class
		PropertyChangeSupportBeans pcs = new PropertyChangeSupportBeans();
		
		pcs.addPropertyChangeListener(e->
		JOptionPane.showMessageDialog(null, e.getNewValue()));
				

		// Add property listener to associate with Room Controller
		pcs.addPropertyChangeListener(e ->

		// Create helper class to avoid syntax error
		//We will create our logic to control Jframe light in here
		controlFrameVisiblity(e)
		
		);

	}

	private static void controlFrameVisiblity(PropertyChangeEvent e) {
	
		changeLight++;
		if(e.getNewValue().equals(myItem.getName())) {
			myMainFrame.setVisible(true);
		} else {
			myMainFrame.setVisible(false);
		}
		
	JOptionPane.showMessageDialog(null, "Selection PCS: " + e.getNewValue().toString());
	}



	public String getName() {
		return myItem.getName();
	}

	private static void addListener() {
		// TODO Auto-generated method stub

		// BACK BUTTON
		myBackButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				// Temporary hide this window in the back ground
				// Can turn back on with other side interaction

				myMainFrame.setVisible(false);
			}
		});

	}
}
