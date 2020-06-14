package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Item;
/**
 * Test datastructure
 * @author Vanessa Hung
 */
public class ItemTest {


	@Test
	public void testSetName() {
		Item test = new Item("TV");
		test.setName("Bicycle");
		assertEquals(test.getName(),"Bicycle");

	}

	@Test
	public void testGetName() {
		
		//Create object with name sasuke
		Item test = new Item("Sasuke");
		
		//See if its the right name
		assertEquals(test.getName(), "Sasuke");
	}

	@Test
	public void testSetId() {
		//Create Item object
		Item test = new Item("random");
		//Calling setID from Item clsas to do the change
		test.setId(5);
		//Comparing if the ID, 5
		assertEquals(test.getID(),5);
	}

	@Test
	public void testGetID() {
		
		Item test = new Item("naruto");
		test.setId(9);
		assertEquals(9,test.getID());
	}

}
