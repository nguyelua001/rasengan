/**
 * TCSS 305 Autumn 2019 Assignment 2 - Bookstore
 * 
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * import org.junit.Before; import org.junit.Test;
 * 
 * Test cases for Item class.
 * 
 * @author Nick Nguyen
 * @author Charles Bryan
 * @version 11 Oct 2019
 *
 */

public class CartTest {
    /** A BD can be created from a String using the constructor. */
    private static final BigDecimal DEFAULT_PRICE = new BigDecimal("10.00");

    /** A default name for testing Item units. */
    private static final String DEFAULT_NAME = "Test Item";

    /**
     * Test fixtures.
     */
    private final Cart myTestCart = new Cart();

    /**
     * List contains customers orders.
     */
    private List<ItemOrder> myItemTestOrder;

    /**
     * This method runs before every test case. Create an empty shopping cart.
     */
    @Before
    public void setUp() {
        myItemTestOrder = new ArrayList<ItemOrder>();

    }

    /**
     * Test for empty ItemOrder object input. Expect NullPointerException.
     *
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullNPE() {
        myTestCart.add(null);
    }

    /**
     * Test if the ArrayList<> in cart is actually adding. If add sucessfully,
     * size must increase by 1.
     * http://www.java2s.com/Code/Java/Development-Class/SimpleuseofJUnittotestArrayList.htm
     * Kind of borrow his idea about size changing.
     */

    @Test
    public void testAdd() {
        final Item itemTest = new Item(DEFAULT_NAME, DEFAULT_PRICE);
        final ItemOrder daOrder = new ItemOrder(itemTest, 5);
        myItemTestOrder.add(daOrder);
        assertEquals(myItemTestOrder.size(), 1);

    }

    /**
     * This method check if SetMembership is return the right boolean for
     * customer membership.
     */
    @Test
    public void testSetMembership() {
        fail("Not yet implemented");
    }

    /**
     * This method test for calculation of the calculateTotal method.
     * 
     * @Test public void testCalculateTotal() { fail("Not yet implemented"); }
     * 
     *       /** Test if there is any item remaining in the cart. Add an
     *       ItemOrder object to cart and check if size increased. Remove all
     *       objects and check if size is equal to 0.
     */
    @Test
    public void testClear() {
        final Item itemTest = new Item(DEFAULT_NAME, DEFAULT_PRICE);
        final ItemOrder daOrder = new ItemOrder(itemTest, 5);
        myItemTestOrder.add(daOrder);
        assertEquals(myItemTestOrder.size(), 1);
        myItemTestOrder.clear();
        assertEquals(true, myItemTestOrder.isEmpty());
    }

    /**
     * This method test for cart size.
     */
    @Test
    public void testGetCartSize() {
        final int testCartSize = myTestCart.getCartSize();
        final int testItemOrder = myItemTestOrder.size();

        assertEquals(testCartSize, testItemOrder);

    }

    /**
     * This is an empty unwritten method.
     */
    @Test
    public void calculateTotalTest() {
        fail("I don't know how to do this");

    }

}
