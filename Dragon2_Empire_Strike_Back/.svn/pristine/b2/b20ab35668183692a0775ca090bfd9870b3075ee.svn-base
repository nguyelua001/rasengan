package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * IMPORTANT: 
 * 
 * This is the heart of this project. Where the magic happens. This was the BIGGEST OBSTICLE through out this project and the solution
 * is just a 70 lines of codes. Java is such amazing.
 * 
 * 
 * 
 * 
 * If you're reading this Mr. J, you are a cool guy. We love you and your class. Gave us a change to create this piece.
 * 
 * 
 * 
 * 
 * 
 * This class is to implement the property change listener to our current GUi components. Especially the interaction between
 * room controller and item controller
 * @author Nick the Great
 *
 */
public class  PropertyChangeSupportBeans {
	
	/**
	 * Property Change Support item
	 */
	private final PropertyChangeSupport support = new PropertyChangeSupport(this);
	private String value;
	
	  
    /**
     * Add a PropertyChangeListener to the listener list. The listener is registered for 
     * all properties. The same listener object may be added more than once, and will be 
     * called as many times as it is added. If listener is null, no exception is thrown and 
     * no action is taken.
     * 
     * @param theListener The PropertyChangeListener to be added
     */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	

    /**
     * Remove a PropertyChangeListener from the listener list. This removes a 
     * PropertyChangeListener that was registered for all properties. If listener was added 
     * more than once to the same event source, it will be notified one less time after being 
     * removed. If listener is null, or was never added, no exception is thrown and no action 
     * is taken.
     * 
     * @param theListener The PropertyChangeListener to be removed
     */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
	

	
	
	public String getValue() {
		return value;
	}




	public void setValue(String string) {
		String oldValue = value;
		value = string;
		support.firePropertyChange("value", oldValue, string);
		
	}
}
