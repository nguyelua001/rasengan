package model;

import java.util.ArrayList;

/**
 * This class create a House for the user. Inside a house there are smaller
 * rooms.
 * 
 * @author Nick the Great, Hung Thai, Vannesa Hung
 *
 */
public class House {
	/**
	 * Name of the item in this house
	 */
	private String myRoomName;

	/**
	 * List of the room in this house
	 */
	private ArrayList<Room> myRoomArr;

	/**
	 * The ID of the item in my house
	 */
	private int myItemID;

	/**
	 * Constructor to create a house when this class is initialized.
	 * 
	 * @author Nick Nguyen
	 * @param roomName
	 * @param itemID
	 */
	public House(String roomName, ArrayList<Room> roomArr, int itemID) {

		// Pass the information from constructor to local variables.
		myRoomName = roomName;
		myRoomArr = roomArr;
		myItemID = itemID;

	}

	/**
	 * Add a new room to our house.
	 * 
	 * @param moreRoom
	 */
	public void addRoom(Room moreRoom) {
		myRoomArr.add(moreRoom);
	}

	/**
	 * Remove a room from my list.
	 * 
	 * @param lessRoom
	 */
	public void removeRoom(Room lessRoom) {
		if (myRoomArr.size() > 0) {
			myRoomArr.remove(lessRoom);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	
	/**
	 * This method help to get the Room object
	 * @return the room in this house
	 */
	public Room getRoom() {
		return myRoomArr.get(0);
	}

	
	public void setRoomName() {
		
	}
	

}
