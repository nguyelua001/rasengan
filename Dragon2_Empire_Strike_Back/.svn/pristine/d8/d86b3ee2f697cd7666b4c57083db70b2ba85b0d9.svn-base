package model;

import java.util.ArrayList;

public class Room {

	/**
	 * List of the item in this room
	 */
	private ArrayList<Item> myItemArr;

	/**
	 * The name of this room
	 */
	private String myRoomName;

	/**
	 * Constructor create a new room with a string assigned.
	 * @param roomName
	 */
	public Room(String roomName) {
		myRoomName = roomName;

	}
	
	/**
	 * Getter for item list.
	 * @return
	 */
	public ArrayList<Item> getItemList(){
		
		return myItemArr;
	}
	
	/**
	 * This method help us to rename this room
	 * @param inputName new name that the customers want to assign
	 */
	public void setName(String inputName) {
		myRoomName = inputName;
		
	}
	
	/**
	 * This method provide the name of this room.
	 * @return the name of this room
	 */
	public String getName() {
		return myRoomName.toString();
	}
	   
	/**
	 * This method add a new item to our room
	 * @param newItem
	 */
	public void addItem(Item newItem) {
		myItemArr.add(newItem);
	}
	
	/**
	 * Remove the most recent item that added to this room.
	 * End of array.
	 */
	public void removeItem() {
		myItemArr.remove(myItemArr.size()-1);
		
	}
}
