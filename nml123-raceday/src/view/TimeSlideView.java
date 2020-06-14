
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_LAP_TOTAL;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_FINISH_LOADING;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.PropertyChangeEnabledRaceControls;
import model.RaceInfo;
import model.RacingModel;

/**
 * Time slider class in View associate with the Controller. This is what the User see.
 * 
 * @author Nick Nguyen
 * @version Autumn 2019.
 */
public class TimeSlideView extends JSlider implements PropertyChangeListener, ChangeListener {

    private static final long serialVersionUID = 65765765765766575L;

    /** number of milliseconds in a second. */
    private static final int MILLIES_PER_SEC = 1000;

    /** Tick of slider. */
    private static final int MINOR_TICK = 10;

    /** number of seconds in a minute. */
    private static final int SEC_PER_MIN = 60;

    /** Race model object. */
    private final RacingModel myRace;

    /**
     * Construct Time slider.
     * 
     * @param theRace the race model.
     */
    public TimeSlideView(final PropertyChangeEnabledRaceControls theRace) {
        super();
        myRace = (RacingModel) theRace;
        setValue(0);
        setEnabled(false);
        addChangeListener(this);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        
        if (PROPERTY_TIME.equals(theEvent.getPropertyName())) {
            setValue((Integer) theEvent.getNewValue() / MILLIES_PER_SEC);
        } else if (PROPERTY_LAP_TOTAL.equals(theEvent.getPropertyName())) {
            final int maxValue = ((RaceInfo) theEvent.getNewValue()).getTotalTime();
            setMinorTickSpacing(MINOR_TICK);
            setMajorTickSpacing(SEC_PER_MIN);
            setPaintTicks(true);
            setMaximum(maxValue / MILLIES_PER_SEC);
            
        } else if (PROPERTY_FINISH_LOADING.equals(theEvent.getPropertyName())) {
            setEnabled(true);
        }
    }

    @Override
    public void stateChanged(final ChangeEvent theEvent) {
        final JSlider slider = (JSlider) theEvent.getSource();
        if (slider.getValueIsAdjusting()) {
            myRace.moveTo(slider.getValue() * MILLIES_PER_SEC);
        }
    }

}