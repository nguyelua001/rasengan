/**
 * TCSS 305 Autumn 2019 
 * Assignment 2 - Bookstore
 * 
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import model.Item;
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
public class ItemTest {
    /** A BD can be created from a String using the constructor. */
    private static final BigDecimal DEFAULT_PRICE = new BigDecimal("10.00");

    /** A default name for testing Item units. */
    private static final String DEFAULT_NAME = "Test Item";

    /** A negative BigDecimal. */
    private static final BigDecimal NEGATIVE_BIGDECIMAL = BigDecimal.valueOf(-9.99);

    /**
     * A NumberFormat used in toString() to display prices.
     */
    private static final NumberFormat CURRENCY_FORMAT =
                    NumberFormat.getCurrencyInstance(Locale.US);

    /** Test fixture. */
    private Item myTestItem;
    /**
     * Test fixture with bulk it_ems.
     */
    private Item myBulkTestItem;
    /**
     * A positive bulk quantity.
     */
    private final int myBulkQuantity = 5;

    /**
     * This method runs before ALL THE TEST. Use this to re-initialize test
     * fixtures.
     */
    @Before
    public void setUp() {
        myTestItem = new Item(DEFAULT_NAME, DEFAULT_PRICE);
        myBulkTestItem = new Item(DEFAULT_NAME, DEFAULT_PRICE, myBulkQuantity,
                                  new BigDecimal("35"));

    }

    // The following test case are for the constructors.
    /**
     * Test the Item constructor for a NullPointerException when sending a null
     * name.
     */
    @Test(expected = NullPointerException.class)
    public void testItemNameNPE() {
        new Item(null, BigDecimal.TEN);
    }

    /**
     * Test the Item constructor for a NullPointerException when sending a null
     * price.
     */
    @Test(expected = NullPointerException.class)
    public void testItemPriceNPE() {
        new Item(DEFAULT_NAME, null);
    }

    /**
     * Test the Item constructor for a IllegalArgumentException when sending a
     * negative price.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemPriceIAE() {
        new Item(DEFAULT_NAME, NEGATIVE_BIGDECIMAL);
    }

    /**
     * Test the Item constructor for a IllegalArgumentException when sending an
     * empty String.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemNameIAE() {
        new Item("", BigDecimal.ONE);
    }

    /**
     * Test constructor for bulk items. Constructor takes Name, Price, Bulk
     * Price and Bulk quantity.
     */
    @Test
    public void testItemBulkConstructor() {
        assertEquals(DEFAULT_PRICE, myBulkTestItem.getPrice());
        assertEquals(myBulkQuantity, myBulkTestItem.getBulkQuantity());
        assertEquals(new BigDecimal("35"), myBulkTestItem.getBulkPrice());
        assertTrue(myBulkTestItem.isBulk());

    }

    /**
     * Test constructor for bulk items with null name.
     * 
     */
    @Test(expected = NullPointerException.class)
    public void testItemBulkNameNPE() {
        new Item(null, DEFAULT_PRICE, myBulkQuantity, new BigDecimal("35"));
    }

    /**
     * Test constructor for bulk items with null price.
     */
    @Test(expected = NullPointerException.class)
    public void testItemBulkPriceNPE() {
        new Item(DEFAULT_NAME, null, myBulkQuantity, new BigDecimal("35"));
    }

    /**
     * Test constructor for bulk items with negative price.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemBulkPriceIAE() {
        new Item(DEFAULT_NAME, NEGATIVE_BIGDECIMAL, myBulkQuantity, new BigDecimal("35"));

    }

    /**
     * Test constructor for bulk items with an empty name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemBulkNameIPE() {
        new Item("", DEFAULT_PRICE, myBulkQuantity, new BigDecimal("35"));
    }

    /**
     * Test for hash code. Test for same object and test for different objects
     * with the same values.
     */
    @Test
    public void testHashCode() {
        // Test the SAME object looking for consistency over time.
        assertEquals(myTestItem.hashCode(), myTestItem.hashCode());

        // Test different objects with the SAME state.
        final Item differentButTheSame = new Item(DEFAULT_NAME, DEFAULT_PRICE);
        assertEquals(myTestItem.hashCode(), differentButTheSame.hashCode());

    }

    /**
     * Test the accessory for Price. Yes, this test is a repeating parts of the
     * Item constructor test. But we repeat it her to discreetly test the
     * getPrice unit.
     */
    @Test
    public void testGetPrice() {
        assertEquals("Test the price", DEFAULT_PRICE, myTestItem.getPrice());
    }
    /**
     * Test Bulk Quantity for items that have bulk options.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(myBulkQuantity, myBulkTestItem.getBulkQuantity());
    }
    /**
     * Test Bulk Price for items that have bulk price options.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(DEFAULT_NAME, new BigDecimal("35"), myBulkTestItem.getBulkPrice());
    }

    /**
     * Test to see if Item return false for non-bulk items.
     */
    @Test
    public void testIsNotBulk() {
        assertFalse(myTestItem.isBulk());
    }

    /**
     * Test to see if Item is return true value for isBulk() boolean.
     */
    @Test
    public void testIsBulk() {
        assertTrue(myBulkTestItem.isBulk());
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString() {
        final String expected = DEFAULT_NAME + ", " + CURRENCY_FORMAT.format(DEFAULT_PRICE);
        assertEquals(expected, myTestItem.toString());
    }

    /** 
     * Test case for .equals looking only at the cases where a Non-Item object is passed. 
     */
    @Test
    public void testEqualsFalseNonItemCases() {
        //Test for false in .equals(null)
        final Item test = null;
        assertNotEquals(myTestItem, test);
        
        //Test for false in .equals(Other Class type)
        assertNotEquals(myTestItem, DEFAULT_NAME);
        assertNotEquals(myTestItem, DEFAULT_PRICE);
    }
    
    /** 
     * Test case for .equals looking only at the false cases. 
     */
    @Test
    public void testEqualsFalseCases() {
        final Item differentNameSamePrice = new Item("Different", DEFAULT_PRICE);
        final Item differentPriceSameName = new Item(DEFAULT_NAME, new BigDecimal("99.99"));
        final Item differentNameAndPrice = new Item("Different", new BigDecimal("99.99"));
        
        assertNotEquals(myTestItem, differentNameSamePrice);
        assertNotEquals(myTestItem, differentPriceSameName);
        
        //This case is equivalent to testing differentNameSamePrice
        assertNotEquals(myTestItem, differentNameAndPrice);
        
    }

    /** 
     * Test case for .equals looking only at the true cases. 
     */
    @Test
    public void testEqualsTrueCases() {
        //Test the SAME object
        assertEquals(myTestItem, myTestItem);
        
        //Test different objects with the SAME state.
        final Item differentButTheSame = new Item(DEFAULT_NAME, DEFAULT_PRICE);
        assertEquals(myTestItem, differentButTheSame);
    }
}
