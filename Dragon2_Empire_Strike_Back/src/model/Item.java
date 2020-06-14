package model;

/**
 * This class create a Item object for the user. Inside a house there are
 * smaller rooms.
 * 
 * @author Nick the Great, Hung Thai, Vannesa Hung
 *
 */
public class Item {

	/**
	 * Name of this particular item.
	 */
	private String myItemName;

	/**
	 * ID of this particular item
	 */
	private int myID;

	/**
	 * Constructor that create an Item with a given name
	 * 
	 * @param name of the item
	 */
	public Item(String name) {
		myItemName = name;

	}

	/**
	 * Overload constructor that create an Item with name and ID
	 * 
	 * @param name name of this item
	 * @param id   the serial number of this item
	 */
	public Item(String name, int id) {
		myItemName = name;
		myID = id;

	}

	/**
	 * This method allow us to change the name of this item
	 * 
	 * @param rasengan
	 */
	public void setName(String rasengan) {
		myItemName = rasengan;

	}

	/**
	 * This method allow us to get the name of this item
	 * 
	 */
	public String getName() {
		return myItemName.toString();
	}

	/**
	 * This method allow us to set the ID of this particular item
	 * 
	 * @param itemId
	 */
	public void setId(int itemId) {
		myID = itemId;

	}

	/**
	 * This method allow us to get the ID of this particular item
	 * 
	 */
	public int getID() {
		return myID;
	}
}
