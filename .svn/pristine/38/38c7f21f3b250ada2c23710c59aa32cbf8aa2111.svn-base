/**
 * TCSS 305 Autumn 2019 
 * Assignment 2 - Bookstore
 * 
 */


package model;

import java.util.Objects;

/**
 * 
 * @author Nick Nguyen
 * @version 11 Oct 2019
 */
public final class ItemOrder {


    /**
     * Product's item object.
     */
    private final Item myItem;
    /**
     * Product's quantity.
     */
    private final int myQuantity;

    /**
     * This constructor helps creating an ItemOrder object for any given item
     * and quantity.
     * 
     * @param theItem The item assigned to this order.
     * @param theQuantity Amount of item assigned to this order.
     * @throws NullPointerException for null item or null price.
     * @throws IllegalArgumentException for negative items quantity.
     */

    public ItemOrder(final Item theItem, final int theQuantity) {

        // Check if theItem is null
        Objects.requireNonNull(theItem, "Item cannot be null.");
        // Check if the quantity is larger than 0.
        if (theQuantity < 0) {
            throw new IllegalArgumentException();

        }
        myItem = theItem;
        myQuantity = theQuantity;
    }

    /**
     * This method return Item object when called.
     * 
     * @return myItem object that has all the information about this item.
     */
    public Item getItem() {
        return myItem;
    }

    /**
     * This method return the amount of items that are being purchased in this
     * order.
     * 
     * @return myQuantity is the amount of item that this particular item has.
     */
    public int getQuantity() {
        return myQuantity;
    }

    @Override
    public String toString() {

        final StringBuilder build = new StringBuilder();

        build.append("Item :");
        build.append(myItem);
        build.append(". The quantity is: ");
        build.append(myQuantity);

        return build.toString();
    }

}
