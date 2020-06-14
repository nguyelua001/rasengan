package model;

import java.util.List;

/**
 * 
 * @author Nick Nguyen nml123
 * @version 11/24/2019
 */
public class LeaderboardMessage extends AbstractMessage {
    /**
     * 
     */
    private static String LEAD = "$L";
    /**
     * 
     */
    private static String C = ":";
    /**
     * 
     */
    private final List<Integer> myRacerIDList;

    /**
     * 
     * @param theTimeStamp diem
     * @param theRacerIDList diem
     */
    public LeaderboardMessage(final int theTimeStamp,
                       final List<Integer> theRacerIDList) {
        super(LEAD, theTimeStamp);
        myRacerIDList = theRacerIDList;
        // TODO Auto-generated constructor stub
    }



    /**
     * @return the myRacerIDList
     */
    public List<Integer> getMyRacerIDList() {
        return myRacerIDList;
    }

    // $L:0:32:67:35:42:09:46:41:55:75:30
    /**
     * 
     * @return racerIDs
     */
    private String getRacerIDS() {
        String s = "";
        for (Integer racerID : myRacerIDList) {
            s = s + C + racerID;
        }
        return s.substring(1);
    }

    @Override
    public String toString() {
      
        return LEAD + C + getTimeStamp() + C + getRacerIDS();

    }

}