
package contoller;

import static model.PropertyChangeEnabledMutableColor.PROPERTY_BLUE;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ColorModel;
import model.PropertyChangeEnabledMutableColor;

/**
 * Represents a Panel with components used to change and display the Blue value
 * for the backing Color model.
 *
 * @author Charles Bryan
 * @author Nick Nguyen nml123
 * @version Autumn 2019
 */
public class BlueRowPanel extends JPanel implements PropertyChangeListener {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 2284116355218892348L;

    /** The size of the increase/decrease buttons. */
    private static final Dimension BUTTON_SIZE = new Dimension(26, 26);

    /** The size of the text label. */
    private static final Dimension LABEL_SIZE = new Dimension(45, 26);

    /** The number of columns in width of the TextField. */
    private static final int TEXT_FIELD_COLUMNS = 3;

    /** The amount of padding for the change panel. */
    private static final int HORIZONTAL_PADDING = 30;

    /** The backing model for the system. */
    private final PropertyChangeEnabledMutableColor myColor;

    /** The CheckBox that enables/disables editing of the TextField. */
    private final JCheckBox myEnableEditButton;

    /** The TextField that allows the user to type input for the color value. */
    private final JTextField myValueField;

    /** The Button that when clicked increases the color value. */
    private final JButton myIncreaseButton;

    /** The Button that when clicked decreases the color value. */
    private final JButton myDecreaseButton;

    /** The Slider that when adjusted, changes the color value. */
    private final JSlider myValueSlider;

    /** The panel that visually displays ONLY the BLUE value for the color. */
    private final JPanel myColorDisplayPanel;

    /**
     * Creates a Panel with components used to change and display the Blue value
     * for the backing Color model.
     * 
     * @param theColor the backing model for the system
     */
    public BlueRowPanel(final PropertyChangeEnabledMutableColor theColor) {
        super();
        myColor = theColor;
        myEnableEditButton = new JCheckBox("Enable edit");
        myValueField = new JTextField();
        myIncreaseButton = new JButton();
        myDecreaseButton = new JButton();
        myValueSlider = new JSlider();
        myColorDisplayPanel = new JPanel();
        layoutComponents();
        addListeners();
    }

    /**
     * Setup and add the GUI components for this panel.
     */
    private void layoutComponents() {
        myColorDisplayPanel.setPreferredSize(BUTTON_SIZE);
        myColorDisplayPanel.setBackground(new Color(0, 0, myColor.getBlue()));
        final JLabel rowLabel = new JLabel("Blue: ");
        rowLabel.setPreferredSize(LABEL_SIZE);
        myValueField.setText(String.valueOf(myColor.getBlue()));
        myValueField.setEditable(false);
        myValueField.setColumns(TEXT_FIELD_COLUMNS);
        myValueField.setHorizontalAlignment(JTextField.RIGHT);

        final JPanel rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, HORIZONTAL_PADDING, 0,
                                                             HORIZONTAL_PADDING));
        rightPanel.setBackground(rightPanel.getBackground().darker());
        myIncreaseButton.setIcon(new ImageIcon("./images/ic_increase_value.png"));
        myIncreaseButton.setPreferredSize(BUTTON_SIZE);
        myValueSlider.setMaximum(ColorModel.MAX_VALUE);
        myValueSlider.setMinimum(ColorModel.MIN_VALUE);
        myValueSlider.setValue(myColor.getBlue());
        myValueSlider.setBackground(rightPanel.getBackground());
        myDecreaseButton.setIcon(new ImageIcon("./images/ic_decrease_value.png"));
        myDecreaseButton.setPreferredSize(BUTTON_SIZE);
        rightPanel.add(myDecreaseButton);
        rightPanel.add(myValueSlider);
        rightPanel.add(myIncreaseButton);

        add(myColorDisplayPanel);
        add(rowLabel);
        add(myValueField);
        add(myEnableEditButton);
        add(rightPanel);
    }

    /**
     * Add listeners (event handlers) to any GUI components that require
     * handling.
     */
    private void addListeners() {
        // DO not remove the following statement.
        myColor.addPropertyChangeListener(this);

        // In case of an event, set TextField available to JButton isSelected
        // boolean.
        myEnableEditButton.addActionListener(theEvent -> {
            myValueField.setEditable(myEnableEditButton.isSelected());

        });

        myValueField.addActionListener(theEvent -> {
            // Get original Blue value.
            final int currentBlueInt = myColor.getBlue();

            // User input. Supposed to be an Int.
            final String blueText = myValueField.getText();
            int blueInt = 0;

            try {
                // Assign input to this BlueInt. If assign successfully. Means
                // it is an Int.
                blueInt = Integer.parseInt(blueText);
                // Then check for the Range. If input value is within this
                // range. [0-255]
                if (blueInt > ColorModel.MIN_VALUE && blueInt <= ColorModel.MAX_VALUE) {
                    // Assign input to new Blue Value.
                    myColor.setBlue(blueInt);

                    // Else, if input is not an Int in this range.
                    // Return original Blue value to text box.

                }
                else {
                    myValueField.setText(Integer.toString(currentBlueInt));

                } // In case if ParseInt get an exeption.
                  // Return orginal gren value to text box and myColor(Blue).
            }
            catch (final NumberFormatException ex) {
                myColor.setBlue(currentBlueInt);
                myValueField.setText(Integer.toString(currentBlueInt));

            }

        });

        // IN case of an event, assign perform the following if else case.
        myIncreaseButton.addActionListener(theEvent -> {

            // Increase button is enable if myColorBlue is LESS than or Equal
            // to MAX_VALUE.
            myIncreaseButton.setEnabled(!(myColor.getBlue() > ColorModel.MAX_VALUE));

            if (myColor.getBlue() <= ColorModel.MAX_VALUE - 1) {
                myIncreaseButton.setEnabled(true);
                myColor.adjustBlue(1);
                myDecreaseButton.setEnabled(true);
            }

        });

        // IN case of an event, assign perform the following if else case.
        myDecreaseButton.addActionListener(theEvent -> {

            myDecreaseButton.setEnabled(!(myColor.getBlue() < ColorModel.MIN_VALUE));
            // If the current value is 0. Temporary disable the button.
            if (myColor.getBlue() > ColorModel.MIN_VALUE) {
                myDecreaseButton.setEnabled(true);
                myColor.adjustBlue(-1);
            }

        });

        // Adjusting my slide.
        myValueSlider.addChangeListener(new ValueSliderActionListener());

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_BLUE.equals(theEvent.getPropertyName())) {
            myValueField.setText(theEvent.getNewValue().toString());
            myValueSlider.setValue((Integer) theEvent.getNewValue());
            myColorDisplayPanel
                            .setBackground(new Color(0, 0, (Integer) theEvent.getNewValue()));
        }
    }

    /**
     * This is a helper class for ValueSlider JSlider. Take current value on the
     * slider and setBlue to that value.
     * 
     * @author nml123
     *
     */
    class ValueSliderActionListener implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent theEvent) {
            myColor.setBlue(myValueSlider.getValue());

            myDecreaseButton.setEnabled(myValueSlider.getValue() != ColorModel.MIN_VALUE);

            myIncreaseButton.setEnabled(myValueSlider.getValue() != ColorModel.MAX_VALUE);

        }
    }
}
