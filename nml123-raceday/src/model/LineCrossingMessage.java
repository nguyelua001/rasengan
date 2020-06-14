
package model;

/**
 * 
 * @author Nick Nguyen nml123
 * @version 11/28/2019
 */
public class LineCrossingMessage extends AbstractMessage {
    /**
     * 
     */
    private static String CROSS = "$C";
    /**
     * 
     */
    private final int myRacerID;
    /**
     * 
     */
    private final int myLap;
    /**
     * 
     */
    private final boolean myIsFinished;

    /**
     * @param theTimeStamp Type
     * @param theRacerID Type
     * @param theLap Type
     * @param theFinished Type
     */
    public LineCrossingMessage(final int theTimeStamp,
                               final int theRacerID, final int theLap,
                               final boolean theFinished) {
        super(CROSS, theTimeStamp);
        this.myRacerID = theRacerID;
        this.myLap = theLap;
        this.myIsFinished = theFinished;
    }


    /**
     * @return the myRacerID
     */
    public int getMyRacerID() {
        return myRacerID;
    }

    /**
     * @return the myLap
     */
    public int getMyLap() {
        return myLap;
    }

    /**
     * @return the isFinished
     */
    public boolean isFinished() {
        return myIsFinished;
    }

    // $C:617331:30:10:true

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String colon = ":";
        return CROSS + colon + this.getTimeStamp() + colon + myRacerID + colon + myLap + colon
               + myIsFinished;
    }

}
