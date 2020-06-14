package model;

/**
 * 
 * @author Nick Nguyen
 * @version 11/24/2019
 */
public class Participant {
    /**
     * 
     */
    
    private static String Colon = ":";
    /**
     * 
     */
    private int myRacerID;
    /**
     * 
     */
    private String myRacerName;
    /**
     * 
     */
    private double myRacerDistance;
    
    /**
     * 
     * @param theRacerID racer
     * @param theRacerName racer
     * @param theRacerDistance racer
     */

    public Participant(final int theRacerID, final String theRacerName,
                       final double theRacerDistance) {
        myRacerID = theRacerID;
        myRacerName = theRacerName;
        myRacerDistance = theRacerDistance;
    }

    /**
     * Return participant as a string in the format below.
     * @return Message
     */
    public String toString() {
        final String s = myRacerID + Colon + myRacerName + Colon + myRacerDistance;
        return s;
    }

    /**
     * Return this current racer ID.
     * @return the myRacerID
     */
    public int getMyRacerID() {
        return myRacerID;
    }


    /**
     * Getter method for Participant.
     * @return the myRacerName
     */
    public String getMyRacerName() {
        return myRacerName;
    }

    /**
     * Getter method for the distance of this racer.
     * @return the myRacerDistance
     */
    public double getMyRacerDistance() {
        return myRacerDistance;
    }

}