/*
 * TCSS 305 – Autumn 2019 - Assignment 4 – Race Day
 */

package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_LAP_TOTAL;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_LOADING;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_MESSAGE;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import model.Participant;
import model.PropertyChangeEnabledRaceControls;
import model.RaceInfo;
import model.RacingModel;


/**
 * A Tabbed View extend JTabbel. Display the Tabbed in check box for user.
 * 
 * @author Nick Nguyen.
 * @version Autumn 2019
 */
public class TabbedView extends JTabbedPane implements PropertyChangeListener, ItemListener {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = -6011860724880403023L;

    /** The number of rows. */
    private static final int ROWS = 10;

    /** The number of width. */
    private static final int WIDTH = 50;



    /** The first tab containing race output. */
    private final JTextArea myTextArea;

    /** The second tab containing choices for racers. */
    private final JPanel myRacerPanel;

    /** Functions that manipulate the race. */
    private final RacingModel myRace;

    /** Check box that selects/deselects all other check boxes. */
    private JCheckBox mySelectAll;

    /** Check to see if the 'Select All' check box was actually clicked. */
    private boolean myIsClicked;

    /** The scrollpane for data output stream. */
    private JScrollPane myDataScroll;

    /** Collection of check box with its corresponding racer ID. */
    private final Map<JCheckBox, Integer> myCheckBox;

    /**
     * Constructs the TabbedPane.
     * 
     * @param theRace the race model
     */
    public TabbedView(final PropertyChangeEnabledRaceControls theRace) {
        super();
        myTextArea = new JTextArea(ROWS, WIDTH);
        myRacerPanel = new JPanel(new GridLayout(0, 1));
        myCheckBox = new HashMap<>();
        myRace = (RacingModel) theRace;
        myIsClicked = true;
        setUpComponents();
    }

    /**
     * Sets up the look and functionality of the tabs.
     */
    private void setUpComponents() {
        myDataScroll = new JScrollPane(myTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myTextArea.setEditable(false);

        final JScrollPane racerScroll =
                        new JScrollPane(myRacerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        racerScroll.setPreferredSize(getSize());
        addTab("Data Output Stream", myDataScroll);
        addTab("Race Participants", racerScroll);

        setEnabledAt(1, false);
    }

    /**
     * Clears all outputs in the text area.
     */
    public void clearOutput() {
        myTextArea.setText("");
    }

    /**
     * Returns data output stream scroll pane.
     * 
     * @return data output stream scroll pane
     */
    public JScrollPane getScrollValue() {
        return myDataScroll;
    }

    /**
     * Creates check boxes.
     * 
     * @param theRacers list of racers
     */
    private void createCheckBoxes(final List<Participant> theRacers) {
        myRacerPanel.removeAll();
        mySelectAll = new JCheckBox("Select All");
        mySelectAll.setSelected(true);
        mySelectAll.addItemListener(this);
        myRacerPanel.add(mySelectAll);
        for (final Participant r : theRacers) {
            final JCheckBox checkBox = new JCheckBox(r.getMyRacerName());
            checkBox.setSelected(true);
            checkBox.addItemListener(this);
            myCheckBox.put(checkBox, r.getMyRacerID());
            myRacerPanel.add(checkBox);
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_LAP_TOTAL.equals(theEvent.getPropertyName())) {
            clearOutput();
            final RaceInfo info = (RaceInfo) theEvent.getNewValue();
            createCheckBoxes(info.getParticipantList());
            setEnabledAt(1, true);
        } else if (PROPERTY_MESSAGE.equals(theEvent.getPropertyName())) {

            myTextArea.setCaretPosition(myTextArea.getDocument().getLength());
            myTextArea.append(theEvent.getNewValue().toString());
            myTextArea.append(System.lineSeparator());

        } else if (PROPERTY_LOADING.equals(theEvent.getPropertyName())) {
            myTextArea.append((String) theEvent.getNewValue());
        }
    }

    @Override
    public void itemStateChanged(final ItemEvent theEvent) {
        final Object obj = theEvent.getItemSelectable();
        if (obj.equals(mySelectAll) && myIsClicked) {
            for (final JCheckBox box : myCheckBox.keySet()) {
                if (theEvent.getStateChange() == ItemEvent.DESELECTED) {
                    box.setSelected(false);
                } else {
                    box.setSelected(true);
                }
            }
        } else {
            for (final JCheckBox box : myCheckBox.keySet()) {
                if (obj.equals(box)) {
                    if (theEvent.getStateChange() == ItemEvent.DESELECTED) {
                        myIsClicked = false;
                        mySelectAll.setSelected(false);
                        myIsClicked = true;
                        myRace.toggleParticipant(myCheckBox.get(box), false);
                    } else {
                        myRace.toggleParticipant(myCheckBox.get(box), true);
                        mySelectAll.setSelected(true);
                    }
                }
            }
        }
    }

}
