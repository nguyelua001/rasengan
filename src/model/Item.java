/**
 * TCSS 305 Autumn 2019 Assignment 2 - Bookstore
 * 
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * 
 * This Item.java class store basic information of the items as the Bookstore.
 * 
 * @author Nick Nguyen
 * @version 10 Oct 2019
 *
 */

public final class Item {
    /**
     * This is name of the item.
     */
    private final String myName;
    /**
     * This is an informative string for warning, null price.
     */
    private final String myNullPrice = "Item price cannot be null.";
    /**
     * This is an informative string for warning, null name.
     */
    private final String myNullName = "Item name  cannot be null.";
    /**
     * This is price of the item.
     */
    private final BigDecimal myPrice;
    /**
     * This is the amount of bulk items.
     */
    private int myBulkQuantity;
    /**
     * This is the price for bulk items.
     */
    private BigDecimal myBulkPrice;
    /**
     * This check if the customer has bulk option or not.
     */
    private boolean myGotBulk;

    /**
     * 
     * @param theName Name that was given to this item.
     * @param thePrice Price that was given to this item.
     * @throws NullPointerException if theName or thePrice is null.
     * @throws IllegalArgumentException if items price is negative.
     */
    public Item(final String theName, final BigDecimal thePrice) {

        // Check if theName and thePrice are null. They cannot be null.
        Objects.requireNonNull(theName, myNullName);
        Objects.requireNonNull(thePrice, myNullPrice);
        if (theName.length() == 0) {
            throw new IllegalArgumentException();
        }
        myName = theName;

        // Check for the case of negative price.
        if (thePrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();

        }
        myPrice = thePrice;
        // Customer doesn't have a bulk in this case.
        myGotBulk = false;

    }

    /**
     * https://stackoverflow.com/questions/34677644/
     * how-to-use-comparison-operators-like-on-bigdecimal.
     * 
     * Used this for the if statement below.
     * 
     * @param theName Name given to this item.
     * @param thePrice Price given to this item.
     * @param theBulkQuant Amount required to get bulk discount.
     * @param theBulkPrice Discount price when you have bulk.
     * @throws NullPointerException if theName, thePrice or theBulkPrice is
     *             null.
     * @throws IllegalArgumentException for negative price, bulk quantity and
     *             the bulk price.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuant,
                final BigDecimal theBulkPrice) {

        // Check if theName and thePrice are null. They cannot be null.

        Objects.requireNonNull(thePrice, "Price cannot be null.");
        Objects.requireNonNull(theBulkPrice, "Bulk price cannot be null.");

        // Check if theName is an empty string.
        if (theName.length() == 0) {
            throw new IllegalArgumentException();
        }
        // Check for the case of negative item price, bulk quantity and bulk
        // price.
        myName = Objects.requireNonNull(theName);
        if ((thePrice.compareTo(BigDecimal.ZERO) == -1)
            || (theBulkPrice.compareTo(BigDecimal.ZERO) == -1) || (theBulkQuant < 0)) {

            throw new IllegalArgumentException();
        }

        myPrice = thePrice;
        myBulkQuantity = theBulkQuant;
        myBulkPrice = theBulkPrice;
        myGotBulk = true;

    }

    /**
     * This method return the item's price.
     * 
     * @return myPrice which is the price of this item.
     */
    public BigDecimal getPrice() {
        return myPrice;
    }

    /**
     * This method return the bulk amount.
     * 
     * @return the bulk quantity of this item.
     */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    /**
     * This method return the bulk price.
     * 
     * @return the bulk price of this item.
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /**
     * This method check if the customer has bulk option or not.
     * 
     * @return boolean to indicate if the customer has a bulk discount or not.
     */
    public boolean isBulk() {
        return myGotBulk;
    }

    /**
     * {@inheritDoc} This method override toString() and create a new string
     * with the following format. <br>
     * X, $19,99 <br>
     * X, $19.99 (5 for $89.99)
     */
    @Override
    public String toString() {
        // Currency format for US currency.
        final NumberFormat phomat = NumberFormat.getCurrencyInstance(Locale.US);

        // Create a string with format "X, $19.99"
        final StringBuilder build = new StringBuilder();
        build.append(myName);
        build.append(", ");
        build.append(phomat.format(myPrice));

        // If customer have bulk. Add the following “ (5 for $89.99)” to "X,
        // $19.99".
        if (myGotBulk) {
            build.append(" (" + myBulkQuantity + " for " + phomat.format(myBulkPrice) + ")");
        }

        return build.toString();
    }

    @Override
    public boolean equals(final Object theOther) {
        // Boolean helps checking the equals condition.
        boolean goBack = false;

        if (theOther != null && getClass().equals(theOther.getClass())) {
            final Item aiTem = (Item) theOther;
            if (myName.equals(aiTem.myName) && Objects.equals(myPrice, aiTem.myPrice)) {
                goBack = true;
            }
        }
        return goBack;
    }

    @Override
    public int hashCode() {

        return Objects.hash(myName, myPrice);
    }
}
