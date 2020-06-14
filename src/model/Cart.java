/**
 * TCSS 305 Autumn 2019 
 * Assignment 2 - Bookstore
 * 
 */


package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represent a shopping cart. It can add, remove , toString and
 * calculate the cost of items in the cart.
 * 
 * @author Nick Nguyen
 * @version 11 Oct 2019
 *
 */
public class Cart {
    // Constant fields

    /**
     * Check if the customer is eligible for bulk discount.
     */
    private boolean myMember;

    /**
     * List contains customers orders.
     */
    private final List<ItemOrder> myItemOrder;
    /**
     * String use to provide warning lines for null Objects.
     */
    private final String myNullObj = "Object from this class cannot be null";

    /**
     * Constructor creates empty cart. I was able to initialize my List thanks
     * to this thread.
     *
     * //
     * https://stackoverflow.com/questions/10075733/how-to-create-an-object-of-listinteger-type
     */
    public Cart() {
        myItemOrder = new ArrayList<ItemOrder>();
    }

    /**
     *
     * //
     * https://howtodoinjava.com/java/collections/arraylist/add-replace-element-at-index/
     * This link contains information bout how to add/replace element index.
     *
     * @param theOrder ItemOrder that will be add to the cart.
     * @throws NullPointerException when customer try to add an empty ItemOrder
     *             object to cart.
     */
    public void add(final ItemOrder theOrder) {
        // Check if the ItemOrder is null.
        Objects.requireNonNull(theOrder, myNullObj);

        // Add new orders to cart. Replace previous item object while iterating
        // with a new one(identical objects).
        for (int nar = 0; nar < myItemOrder.size(); nar++) {
            if (theOrder.getItem().equals(myItemOrder.get(nar).getItem())) {

                myItemOrder.set(nar, theOrder);

                return;
            }
        }
        myItemOrder.add(theOrder);
    }

    /**
     * Determine if the customer has a membership option.
     *
     * @param theMembership is boolean that determines if the customer has a
     *            membership or not.
     */
    public void setMembership(final boolean theMembership) {
        myMember = theMembership;
        return;

    }

    /**
     * This method return the total cost of the shopping cart as a BigDecimal
     * value. It applies the HALF_EVEN rounding rule.
     * https://stackoverflow.com/questions/42413020/bigdecimal-math-operations
     * 
     * @return Total cost in shopping cart.
     */
    public BigDecimal calculateTotal() {
        // BigDecimal to be returned.
        BigDecimal calVal = BigDecimal.ZERO;

        // BigDecimal used for calculations.
        BigDecimal returnVal = BigDecimal.ZERO;

        for (int i = 0; i < myItemOrder.size(); i++) {

            // Getting all needed values as BigDecimals.
            final BigDecimal quantity = new BigDecimal(myItemOrder.get(i).getQuantity());
            final BigDecimal bulkQuantity =
                            new BigDecimal(myItemOrder.get(i).getItem().getBulkQuantity());

            final BigDecimal price = myItemOrder.get(i).getItem().getPrice();
            final BigDecimal bulkPrice = myItemOrder.get(i).getItem().getBulkPrice();

            // Check for membership and if the item has the bulk option.
            if (myMember && (myItemOrder.get(i).getItem().isBulk())) {
                /*
                 * Dividing the (quantity / bulkquantity). Nearest integer
                 * rounding. Mod like.
                 */
                returnVal = quantity.divideToIntegralValue(bulkQuantity);

                /*
                 * Multiply the result to bulk price.
                 */
                returnVal = returnVal.multiply(bulkPrice);

                /*
                 * Take the remainder and multiply it to the regular price. Ex:
                 * 10 items to get bulk. 11%10 = 1 bulk + 1 regular price.
                 */
                returnVal = returnVal.add((quantity.remainder(bulkQuantity)).multiply(price));
                calVal = calVal.add(returnVal);

            } else {

                // Multiply price and quantity.
                calVal = calVal.add(price.multiply(quantity));
            }
        }
        return calVal.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Remove all items from cart.
     */
    public void clear() {
        myItemOrder.clear();
        return;
    }

    /**
     * Number of items in cart.
     *
     * @return Amount of Item Order in cart.
     */
    public int getCartSize() {
        return myItemOrder.size();
    }

    @Override
    public String toString() {
        final StringBuilder build = new StringBuilder();
        build.append(myItemOrder.toString());
        return build.toString();
    }

}
