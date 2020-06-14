package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * LoginView provides a user interface for login and registration.
 * 
 * @author Nick the Great, Hung Thai, Vannesa Hung
 * @version 6/4/2020
 *
 */
public class LoginView extends JFrame {
	/**
	 * The Serialization ID.
	 */
	private static final long serialVersionUID = 1728929170437545812L;

	/** A ToolKit. */
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();

	/** The Dimension of the screen. */
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	/** The button used to trigger login sequence. */
	private final JButton myLoginButton;
	/**
	 * Main frame for our log in panel
	 */
	private JFrame myMainFrame;

	/**
	 * Text field for user input
	 */
	private final JTextField myUserField;

	/**
	 * Text field for password input
	 */
	private final JTextField myPassField;

	/**
	 * Constructor for initialization
	 */
	public LoginView() {

		super();
		myUserField = new JTextField();
		myPassField = new JTextField();
		myLoginButton = new JButton();
		myMainFrame = new JFrame();

		setupGUI();

	}

	/**
	 * Set up the various parts of the GUI
	 */
	private void setupGUI() {
		layoutComponents();
		assignActions();

	}

	/**
	 * Layout swing components
	 */
	private void layoutComponents() {

		final JPanel pane = new JPanel(new BorderLayout());

		// Create a blank log in page with dragon icon
		myMainFrame = new JFrame("Login Page");
		myMainFrame.getContentPane().setBackground(Color.DARK_GRAY);
		myMainFrame.setBounds(100, 100, 800, 600);
		myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myMainFrame.getContentPane().setLayout(null);
		myMainFrame
				.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/image/dragon.jpg")));

		// Add the user text field and pass text field to main frame.
		myMainFrame.add(myUserField);
		myMainFrame.add(myPassField);
	}

	/**
	 * Add Listeners to any GUI components that we need
	 */
	private void assignActions() {
		myUserField.addActionListener(this::userFieldAction);
		myPassField.addActionListener(this::passFieldAction);

	}

	public void userFieldAction(final ActionEvent theEvent) {

	}

	public void passFieldAction(final ActionEvent theEvent) {

	}

}