/**
 * TCSS 305 Autumn 2019 
 * Assignment 2 - Bookstore
 * 
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for Item class.
 * 
 * @author Nick Nguyen
 * @author Charles Bryan
 * @version 11 Oct 2019
 *
 */
public class ItemOrderTest {
    /** A default name for testing Item units. */
    private static final String DEFAULT_NAME = "Test Item";
    /** A BD can be created from a String using the constructor. */
    private static final BigDecimal DEFAULT_PRICE = new BigDecimal("10.00");

    /** Test fixture. */
    private ItemOrder myTestOrder;
    /**
     * Text fixtures.
     */
    private int myDefaultQuant = 5;
    /**
     * Text fixtures.
     */
    private int myDefaultNegQuant = -5;
    /**
     * Text fixtures.
     */
    private final Item myItemTest = new Item(DEFAULT_NAME, DEFAULT_PRICE);

    /**
     * This method runs before every test.
     */
    @Before
    public void setUp() {

        myTestOrder = new ItemOrder(myItemTest, myDefaultQuant);
    }

    /**
     * This method check for null/empty item object input to the constructor.
     * Expect NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void testItemOrderNPE() {
        new ItemOrder(null, myDefaultQuant);
    }

    /**
     * This method check for negative quantity. Expect IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemOrderNegQuantIPE() {
        new ItemOrder(myItemTest, myDefaultNegQuant);
    }

    /**
     * This method check for getItem(). Looking for identical item as a return.
     */
    @Test
    public void testGetItem() {
        assertEquals("Test get Item", myItemTest, myTestOrder.getItem());
    }

    /**
     * This method check for getQuantity(). Comparing the default quantity int
     * versus return int value from Item.getQuantity().
     */
    @Test
    public void testGetQuantity() {
        assertEquals("Test item quantity", myDefaultQuant, myTestOrder.getQuantity());
    }

    // Still need modifications.
    /**
     * This method check for toString().
     */
    @Test
    public void testToString() {
        final String expected = "Item :" + myItemTest;
        assertEquals(expected, myItemTest.toString());
    }

}
