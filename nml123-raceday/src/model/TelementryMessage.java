package model;

/**
 * 
 * @author Nick Nguyen nml123
 * @version 11/24/2019
 */
public class TelementryMessage extends AbstractMessage {
    /**
     * 
     */
    private static String TELEMETRY = "$T";
    /**
     * 
     */
    private final int myRacerID;
    /**
     * 
     */
    private final double myDistance;
    /**
     * 
     */
    private final int myLap;

    /**
     * 
     * @param theTimeStamp n
     * @param theRacerId n
     * @param theDistance n
     * @param theLap n
     */

    public TelementryMessage(final int theTimeStamp,
                            final int theRacerId, final double theDistance, final int theLap) {
        super(TELEMETRY, theTimeStamp);
        myRacerID = theRacerId;
        myDistance = theDistance;
        myLap = theLap;
    }


    /**
     * @return the myRacerID
     */
    public int getMyRacerID() {
        return myRacerID;
    }


    /**
     * @return the myDistance
     */
    public double getMyDistance() {
        return myDistance;
    }


    /**
     * @return the myLap
     */
    public int getMyLap() {
        return myLap;
    }



    // $T:0:46:-499.84:0
    @Override
    public String toString() {
        final String c = ":";
        return TELEMETRY + c + getTimeStamp() + c + myRacerID + c + myDistance + c + myLap;

    }

}