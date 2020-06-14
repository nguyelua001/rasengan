
package controller;

import application.Main;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_FINISH_LOADING;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_LOADING;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_MESSAGE;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_LAP_TOTAL;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import model.PropertyChangeEnabledRaceControls;
import model.RacingModel;
import view.TabbedView;
import view.TimePanelView;
import view.TimeSlideView;


/**
 * Comment me.
 * 
 * @author Charles Bryan
 * @author Nick Nguyen nml123
 * @version Autumn 2019
 */
public class ControllerPanel extends JPanel {

    /** The serialization ID. */
    private static final long serialVersionUID = -6759410572845422202L;
    /** the play icon link. */
    public static final String BUTTON_ICON_PLAY = "/ic_play.png";

    /** the play text. */
    public static final String BUTTON_TEXT_PLAY = "Play";
    /** The pause icon. */
    public static final String BUTTON_ICON_PAUSE = "/ic_pause.png";

    /** the pause text. */
    public static final String BUTTON_TEXT_PAUSE = "Pause";

    /** A reference to the backing Race Model. */
    private final PropertyChangeEnabledRaceControls myPropertyRace;

    /** Display of messages coming from the Race Model. */
    private final JTextArea myOutputArea;

    /** Panel to display CheckBoxs for each race Participant. */
    private final JPanel myParticipantPanel;

    /** A view on the race model that displays the current race time. */
    private final TimePanelView myTimeLabel;

    /** A controller and view of the Race Model. */
    private final TimeSlideView myTimeSlider;

    /** The list of javax.swing.Actions that make up the ToolBar (Controls) buttons. */
    private final List<Action> myControlActions;

    /** The timer that advances the Race Model. */
    private final Timer myTimer;

    /** Container to hold the different output areas. */
    private final TabbedView myTabbedPane;

    /**
     * Racing model object to interact with Controller panel.
     */
    private final RacingModel myRacingModel;

    /**
     * String represent downline.
     */
    private final String myLn = "\n";
    /** Padding for the border around the label. */
    private final int PADDING = 5;
    
    /**
     * Frequency of my timer. How many milliseconds before it ticks.
     */
    private final int myTIMER_FREQUENCY = 30;
    /**
     * String represent a line seperator.
     */
    private final String LINE_SEPERATOR = "line.separator";

    /** info menu. **/
    private final JMenuItem myInformationItem;

    /**
     * The time multiplier.
     */
    private static int myTimeMultiply = 1;

    /**
     * String represent this race information.
     */
    // private String myRaceInfo = "Track type: "+ myRace.;

    /**
     * Magic number 10.
     */
    private int myTEN = 10;

    /**
     * Construct a ControllerPanel.
     * 
     * @param theRace the backing race model
     */
    public ControllerPanel(final PropertyChangeEnabledRaceControls theRace) {

        super();
        // myRace get PropertyCHangeEnableRaceControls.
        myPropertyRace = theRace;
        myOutputArea = new JTextArea(10, 50);

        // Create new object associate with TimeSlide in View.
        myTimeLabel = new TimePanelView();

        // Create new object associate with TimeSlide
        myTimeSlider = new TimeSlideView(theRace);

        // Create new object associate with my TabbedView
        myTabbedPane = new TabbedView(theRace);

        myControlActions = new ArrayList<>();

        myParticipantPanel = new JPanel();

        // TODO From myself
        myRacingModel = new RacingModel();

        // Create new JMenuItem for THIS race information.
        myInformationItem = new JMenuItem("Race Info...");

        // TODO This component require Event Handlers
        myTimer = new Timer(myTIMER_FREQUENCY, this::handleTimer);

        saveSpace();

    }
    
    /**
     * This is a helper method to help save space in constructor.
     */
    private void saveSpace() {
        buildActions();
        setUpComponents();
        setEnableControl(false);
        addListeners();
    }

    /**
     * Displays a simple JFrame.
     */
    private void setUpComponents() {
        setLayout(new BorderLayout());

        // JPanel is a useful container for organizing components inside a JFrame
        final JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(myTEN, myTEN, myTEN, myTEN));

        mainPanel.add(buildSliderPanel(), BorderLayout.NORTH);

        myOutputArea.setEditable(false);
        final JScrollPane scrollPane = new JScrollPane(myOutputArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        addRacePropertyChangeListenerTabbed();

        final JScrollPane participantScrollPane = new JScrollPane(myParticipantPanel);
        participantScrollPane.setPreferredSize(scrollPane.getSize());

        mainPanel.add(myTabbedPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        add(buildToolBar(), BorderLayout.SOUTH);

    }

    /**
     * Sub method use to add property change listener for my tabbed.
     */
    private void addRacePropertyChangeListenerTabbed() {
        myPropertyRace.addPropertyChangeListener(PROPERTY_LAP_TOTAL, myTabbedPane);
        myPropertyRace.addPropertyChangeListener(PROPERTY_MESSAGE, myTabbedPane);
        myPropertyRace.addPropertyChangeListener(PROPERTY_LOADING, myTabbedPane);
        myPropertyRace.addPropertyChangeListener(PROPERTY_FINISH_LOADING, myTabbedPane);
    }

    /**
     * Helper method to call the advanced method in RacingModel.
     * 
     * @param theEvent A semantic event which indicates that a component-defined action
     *            occurred.
     */
    private void handleTimer(final ActionEvent theEvent) {
        myRacingModel.advance(myTIMER_FREQUENCY * myTimeMultiply);
    }

    /**
     * Builds the panel with the time slider and time label.
     * 
     * @return the panel
     */
    private JPanel buildSliderPanel() {

        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING * PADDING,
                                                        PADDING));

        addRacePropertyChangeListenerSlider();
        panel.add(myTimeSlider, BorderLayout.CENTER);

        // Create a TimePanelView class to associate with my View.
        final TimePanelView timePanelView = new TimePanelView();

        // Add property change listener for my timepanelview object so it can detect the
        // changes I fire.
        myPropertyRace.addPropertyChangeListener(PROPERTY_TIME, timePanelView);

        // Draw the little timer box. Tsukuyomi is a technique to control time by Shisui
        // Uchiha. Just
        // a silly way for me to remember the code.

        final JPanel tsukuyomi = new JPanel();

        tsukuyomi.add(timePanelView);
        panel.add(tsukuyomi, BorderLayout.EAST);

        return panel;
    }

    /**
     * Sub method to add Property Change Listener for TimeSlider.
     */
    private void addRacePropertyChangeListenerSlider() {
        myPropertyRace.addPropertyChangeListener(PROPERTY_LAP_TOTAL, myTimeSlider);
        myPropertyRace.addPropertyChangeListener(PROPERTY_FINISH_LOADING, myTimeSlider);
        myPropertyRace.addPropertyChangeListener(PROPERTY_TIME, myTimeSlider);

    }

    /**
     * Constructs a JMenuBar for the Frame.
     * 
     * @return the Menu Bar
     */
    private JMenuBar buildMenuBar() {
        final JMenuBar bar = new JMenuBar();
        bar.add(buildFileMenu());
        bar.add(buildControlsMenu(myControlActions));
        bar.add(buildHelpMenu());
        return bar;
    }

    /**
     * Builds the file menu for the menu bar.
     * 
     * @return the File menu
     */
    private JMenu buildFileMenu() {
        // TODO These components require Event Handlers

        final JMenu fileMenu = new JMenu("File");

        final JMenuItem load = new JMenuItem("Load Race...");

        // Add ActionListener for the load JMenuItem object.
        load.addActionListener(theEvent -> {
            final FileLoader fileInput = new FileLoader();
            fileInput.execute();
        });

        fileMenu.add(load);

        fileMenu.addSeparator();

        final JMenuItem exitItem = new JMenuItem("Exit");

        // Add ActionListener for the exitItem JMenuItem object.
        exitItem.addActionListener(theEvent -> {
            System.exit(JFrame.EXIT_ON_CLOSE);
        });

        fileMenu.add(exitItem);
        return fileMenu;
    }

    /**
     * Build the Controls JMenu.
     * 
     * @param theActions the Actions needed to add/create the items in this menu
     * @return the Controls JMenu
     */
    private JMenu buildControlsMenu(final List<Action> theActions) {
        final JMenu controlsMenu = new JMenu("Controls");

        for (final Action a : theActions) {
            controlsMenu.add(a);
        }

        return controlsMenu;
    }

    /**
     * Build the Help JMenu.
     * 
     * @return the Help JMenu
     */
    private JMenu buildHelpMenu() {
        // TODO These components require Event Handlers
        final JMenu helpMenu = new JMenu("Help");

        // final JMenuItem infoItem = new JMenuItem("Race Info...");
        myInformationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {

                JOptionPane.showMessageDialog(new JPanel(), myRacingModel.getRaceInformation(),
                                              "Race Information",
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        });
        helpMenu.add(myInformationItem);

        final JMenuItem aboutItem = new JMenuItem("About...");

        // Create a new JPanel and print out about information.
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {

                JOptionPane.showMessageDialog(new JPanel(), myAboutInfo(), "About",
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        });

        helpMenu.add(aboutItem);
        return helpMenu;
    }

    /**
     * Helper method to display my personal information.
     * 
     * @return String contains information.
     */
    public String myAboutInfo() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nick Nguyen");
        sb.append(System.getProperty(LINE_SEPERATOR));
        sb.append("Winter 2019");
        sb.append(System.getProperty(LINE_SEPERATOR));
        sb.append("TCSS 305");
        sb.append(System.getProperty(LINE_SEPERATOR));
        sb.append("I love this class eventhough I failed this assignment.");

        return sb.toString();
    }

    /**
     * Helper method to display Race Information.
     * 
     * @return a string represent this race information.
     */
    public String myRaceInfo() {

        return myRacingModel.toString();
    }

    /**
     * Build the toolbar from the Actions list.
     * 
     * @return the toolbar with buttons for all of the Actions in the list
     */
    private JToolBar buildToolBar() {
        final JToolBar toolBar = new JToolBar();
        for (final Action a : myControlActions) {
            final JButton b = new JButton(a);
            b.setHideActionText(true);
            toolBar.add(b);
        }
        return toolBar;
    }

    /**
     * Add actionListeners to the buttons.
     */
    private void addListeners() {

        buildActions();

    }

    /**
     * Instantiate and add the Actions.
     */
    private void buildActions() {
        // TODO These components require Event Handlers
        myControlActions.add(new SimpleAction("Restart", "/ic_restart.png"));
        myControlActions.add(new SimpleAction(BUTTON_TEXT_PLAY, BUTTON_ICON_PLAY));
        myControlActions.add(new SimpleAction("Times One", "/ic_one_times.png"));
        myControlActions.add(new SimpleAction("Single Race", "/ic_repeat.png"));
        myControlActions.add(new SimpleAction("Clear", "/ic_clear.png"));

    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        // Create and set up the window.
        final JFrame frame = new JFrame("Race Day!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO instantiate your model here.
        final RacingModel race = new RacingModel();

        // Create and set up the content pane.
        final ControllerPanel pane = new ControllerPanel(race);

        // Add the JMenuBar to the frame:
        frame.setJMenuBar(pane.buildMenuBar());

        pane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(pane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This is a helper method. It control the enable "switch" on/off.
     * 
     * @param theValue Current boolean status of GUI enable.
     */
    private void setEnableControl(final boolean theValue) {
        // Iterator through list of action events. Using boolean signature to control set the
        // Enable for that particular Action.
        for (final Action action : myControlActions) {
            action.setEnabled(theValue);
        }
        // Set myTimeSlider (Java JMenu Item) enable.
        myInformationItem.setEnabled(theValue);
        // Set myTimeSlider object (My TimeSliderView) in View to be enable.
        myTimeSlider.setEnabled(theValue);
    }

    /**
     * This is a simple implementation of an Action. You will most likely not use this
     * implementation in your final solution. Either create your own Actions or alter this to
     * suit the requirements for this assignment.
     * 
     * @author Charles Bryan
     * @version Autumn 2019
     */
    private class SimpleAction extends AbstractAction {

        /** The serialization ID. */
        private static final long serialVersionUID = -3160383376683650991L;

        /**
         * Constructs a SimpleAction.
         * 
         * @param theText the text to display on this Action
         * @param theIcon the icon to display on this Action
         */
        SimpleAction(final String theText, final String theIcon) {
            super(theText);

            // small icons are usually assigned to the menu
            setIcon(new ImageIcon(theIcon));
        }

        /**
         * Wrapper method to get a system resource.
         * 
         * @param theResource the name of the resource to retrieve
         * @return the resource
         */
        private URL getRes(final String theResource) {
            return Main.class.getResource(theResource);
        }

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
        }

        /**
         * set Icon method.
         * 
         * @param theIcon icon.
         */
        private void setIcon(final ImageIcon theIcon) {
            ImageIcon icon = (ImageIcon) new ImageIcon(getRes(theIcon.toString()));
            final Image smallImage = icon.getImage()
                            .getScaledInstance(16, -1, java.awt.Image.SCALE_SMOOTH);
            final ImageIcon smallIcon = new ImageIcon(smallImage);
            putValue(Action.SMALL_ICON, smallIcon);

            // Here is how to assign a larger icon to the tool bar.
            icon = (ImageIcon) new ImageIcon(getRes(theIcon.toString()));
            final Image largeImage = icon.getImage()
                            .getScaledInstance(24, -1, java.awt.Image.SCALE_SMOOTH);
            final ImageIcon largeIcon = new ImageIcon(largeImage);
            putValue(Action.LARGE_ICON_KEY, largeIcon);
        }
    }

    /**
     * A worker thread to load the files.
     * 
     * @author Charles Bryan
     * @version Autumn 2019
     */
    private class FileLoader extends SwingWorker<Boolean, Void> {


        @Override
        public Boolean doInBackground() {
            boolean result = true;

            // New JFileChooser obj. Allow interactive of chosen file.
            final JFileChooser chooseThisFile = new JFileChooser(".");

            ControllerPanel.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final int choice = chooseThisFile.showOpenDialog(ControllerPanel.this);

            if (choice == JFileChooser.APPROVE_OPTION) {

                try {

                    // Parsting the chosen file to my loadRace(final File theRaceFile).
                    myRacingModel.loadRace(chooseThisFile.getSelectedFile());

                } catch (final IOException exception) {
                    System.out.println("Error");
                    JOptionPane.showMessageDialog(ControllerPanel.this, "Error loading file.",
                                                  "Error!", JOptionPane.ERROR_MESSAGE);
                    result = false;
                }
            }
            return result;
        }

        @Override
        public void done() {
            ControllerPanel.this.setCursor(Cursor.getDefaultCursor());
            try {
                final boolean resultOfFileLoad = get();

                // Casting boolean result from Java Swing worker to my Helper method. Define
                // above.
                setEnableControl(resultOfFileLoad);

            } catch (final InterruptedException ex1) {
                ex1.printStackTrace();
            } catch (final ExecutionException ex2) {
                ex2.printStackTrace();
            }

        }

    }

}
