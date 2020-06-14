package controller;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.Item;
import model.PropertyChangeSupportBeans;
import model.Room;

/**
 * This class is the main controller for our GUI and data structure presenting
 * the house.
 * 
 * @author Nick the Great, Hung Thai
 * @version 6/1/2020
 *
 */
public class RoomController extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1422343244321042534L;

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
	private static String backAddress = "/image/room.png";

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
	 * About us button
	 */
	private static JButton myAboutButt;

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
	 * JList that display the current room that we have
	 */
	private static DefaultListModel<String> myJList;

	/**
	 * My JList to control elements in this list.
	 */
	private static JList<String> myList;

	/**
	 * Array list that hold all the room name
	 */

	private static ArrayList<String> myItemList = new ArrayList<String>();


	/**
	 * PCS for this class
	 */
	private static PropertyChangeSupportBeans pcs = new PropertyChangeSupportBeans();
	
	private static JButton testButton;
	public RoomController() {

		createAndShowGUI();
	}

	/**
	 * Create and show all the GUI components in this controller.
	 */
	public static void createAndShowGUI() {

		// Create main frame
		myMainFrame = new JFrame("Room Page");
		myMainFrame.setBounds(100, 100, 1295, 740);
		myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myMainFrame.getContentPane().setLayout(null);
		myMainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(RoomController.class.getResource(logoAddress)));

		// Create a JLabel and put a picture on top of that label to creat welcome
		// picture
		myBackLabel.setIcon(new ImageIcon(RoomController.class.getResource(backAddress)));
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

		// Create about us button
		myAboutButt = new JButton();
		myAboutButt.setBackground(Color.RED);
		myAboutButt.setOpaque(true);
		myAboutButt.setBounds(20, 70, 40, 40);
		myAboutButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				// Overriding method below.
			}
		});

		// Create add Text button
		myAddText = new JButton();
		myAddText.setBackground(Color.BLACK);
		myAddText.setOpaque(true);
		myAddText.setBounds(700, 150, 100, 40);
		myAddText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				// Overriding method below.
			}
		});

		// Create add Text button
		myRemoveText = new JButton();
		myRemoveText.setBackground(Color.GRAY);
		myRemoveText.setOpaque(true);
		myRemoveText.setBounds(1003, 150, 100, 40);
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
		myTextField.setBounds(600, 80, 600, 40);
		myTextField.setHorizontalAlignment(JTextField.CENTER);
		

		 
	
		/**
		 * MY LIST AREA
		 * 
		 * 
		 * 
		 */

		myJList = new DefaultListModel<>();
		myList = new JList<>(myJList);
		myList.setBounds(600, 200, 600, 300);

		/**
		 * 
		 * TESTING AREA
		 */

		/**
		 * PLACE FOR FRAME. ADD CONTENT PANE
		 */
		// Add back button
		myMainFrame.getContentPane().add(myBackButt);

		// Add about us button
		myMainFrame.getContentPane().add(myAboutButt);

		// Add text button
		myMainFrame.getContentPane().add(myAddText);

		// Remove text button
		myMainFrame.getContentPane().add(myRemoveText);

		// Add text field
		myMainFrame.getContentPane().add(myTextField);

		
		//Add my Jlist
		myMainFrame.getContentPane().add(myList);

		/**
		 * WARNING: IMPLEMENTS JCOMPONETS ABOVE THESE LINES
		 * 
		 * 
		 * 
		 * 
		 */
		// Background pixel size 1276x731

		// Add elements to the main frame. Add ITACHI PICTURE
		myMainFrame.getContentPane().add(myBackLabel);

		// Stop using from resizing panels
		myMainFrame.setResizable(false);
		// VISIBILITY
		myMainFrame.setVisible(true);

		addListener();
	}

	/**
	 * Add listener to our GUI components
	 */
	public static void addListener() {

		// BACK BUTTON
		myBackButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				new HomeController();
				// Close the window
				myMainFrame.dispose();
			}
		});

		// ABOUT BUTTON

		myAboutButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UIManager.put("OptionPane.background", Color.BLACK);
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.BLACK);
				JOptionPane.showMessageDialog(null,
						"Dragon Group About Box\nHome Application Ver " + "\nCopyright @ 2020, UW Tacoma "
								+ "\nHung Thai\nNick Feels Great\nVanessa Hung",
						"About Us", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		// ADD ROOM button

		myAddText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				if (!myJList.contains(myTextField.getText())) {

					// UNDO THIS WHEN DONE
					myJList.addElement(myTextField.getText());
					// myTextField.setText("");

				}
			}
		});

		// Remove ROOM button
		myRemoveText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				// If the list is not empty then remove the recent added item.
				if (myJList.getSize() != 0) {

					myItemList.remove((Object) myTextField.getText());
					myJList.remove(myJList.getSize() - 1);

				} else {
					myJList.removeAllElements();
				}
			}
		});

		// Add listener for the top panel of JList to display and add a new room

		;
		myList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// If user click 1 time event is capture
				if (e.getClickCount() == 1) {

					@SuppressWarnings("unchecked")

					// We create a List of rooms objects assigned with
					// source
					JList<Room> tabSource = (JList<Room>) e.getSource();

					// Convert click location on panel to index location
					// of the list [0 - n]
					int index = tabSource.locationToIndex(e.getPoint());

					// If index is not a negative position
					if (index >= 0) {

						// Object containing the information source of the click
						Object item = tabSource.getModel().getElementAt(index);

						// Call helper method. this method will show the Gui in a prioritized order
						showItemPriority(item);

					}
				}
			}

			/**
			 * Helper method that separate a mouse click event into 3 different parts. Case
			 * 1: We don't have item. Create one. Add to list Case 2: We have one and we are
			 * reclicking Case 3: We have one Item already and we are creating a new one.
			 * 
			 * This method execute case 1 and 3
			 * 
			 * @param item containg the information source of this mouse click
			 */
			private void showItemPriority(Object item) {

				// If this list is empty. Create a first item and add it to our list.
				if (myItemList.isEmpty()) {
					ItemController case1Window = new ItemController(item.toString());
					myItemList.add(case1Window.getName());
		

				} else {
					// Else if the list is not empty. Check if list already have this item OR not.
					// Check if we have a duplicate of this item
					if (checkDuplicate(item)) {


						// Property Change Listener. Call the panel associate with this name
						// to show itself because it was hiding for the whole time. Sneaky bastard.

						pcs.setValue(item.toString());
						JOptionPane.showMessageDialog(null, "PCS sent!:  " + item.toString() );

					} else {

						// if we dont have this item yet. Create this new item and add it to our list.
						ItemController case2Window = new ItemController(item.toString());
						myItemList.add(case2Window.getName());

					}

				}

			}

			/**
			 * Helper method to help indicate mouse click at case 2.
			 * 
			 * @param item containing information source of this mouse click
			 * @return boolean indicate if this is a duplicate or not
			 */
			private boolean checkDuplicate(Object item) {

				for (int itemslot = 0; itemslot <= myItemList.size() - 1; itemslot++) {

					if (myItemList.get(itemslot).equals(item.toString())) {
						return true;
					}

				}

				return false;
			}

		});

	}

}
