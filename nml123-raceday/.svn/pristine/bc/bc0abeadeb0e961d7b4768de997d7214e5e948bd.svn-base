
package model;

import java.util.List;
import view.Utilities;




/**
 * Store Racer Information class.
 * 
 * @author Nick Nguyen nml123
 * @version 11/28/19
 *
 */
public class RaceInfo {
    /**
     * Track Name.
     */
    private String myTrackName;

    /**
     * Track Geometry.
     */
    private String myTrackGeometry;
    /**
     * String represent a line seperator.
     */
    private final String LINE_SEPERATOR = "line.separator";

    /**
     * Total time of the track.
     */
    private int myTotalTime;

    /**
     * Distance for one lap.
     */
    private int myOneDistance;

    private List<Participant> myParticipantList;

    /**
     * Default Constructor.
     */
    public RaceInfo() {
    }

    /**
     * Constructor with parameters.
     * 
     * @param theTrackName Track name.
     * @param theTrackGeometry Track Geometry.
     * @param theTotalTime Total time.
     * @param theOneDistance Distance one lap.
     * @param theParticipantList list of participant in this race.
     */
    public RaceInfo(final String theTrackName, final String theTrackGeometry,
                    final int theTotalTime, final int theOneDistance,
                    final List<Participant> theParticipantList) {

        myTrackName = theTrackName;
        myTrackGeometry = theTrackGeometry;
        myTotalTime = theTotalTime;
        myOneDistance = theOneDistance;
        myParticipantList = theParticipantList;

    }

    /**
     * Get Track name.
     * 
     * @return Track name.
     */
    public String getTrackName() {
        return myTrackName;
    }

    /**
     * Get Track name.
     * 
     * @return Track name.
     */
    public String getTrackGeometry() {
        return myTrackGeometry;
    }

    /**
     * Return a List of <Participant>.
     * 
     * @return List of participants.
     */
    public List<Participant> getParticipantList() {
        return myParticipantList;
    }

    /**
     * Get Track name.
     * 
     * @return Track name.
     */
    public int getTotalTime() {
        return myTotalTime;
    }

    /**
     * Get Track name.
     * 
     * @return Track name.
     */
    public int getOneDistance() {
        return myOneDistance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getTrackName());
        sb.append(System.getProperty(LINE_SEPERATOR));
        sb.append("Track Type:" + this.getTrackGeometry());
        sb.append(System.getProperty(LINE_SEPERATOR));
        sb.append("Total Time:" + this.getTimeString());
        sb.append(System.getProperty(LINE_SEPERATOR));
        sb.append("Lap Distance: " + this.getOneDistance());

        return sb.toString();
    }

    /**
     * Get Time as a String.
     * 
     * @return Time value as a String.
     */
    public String getTimeString() {
        final long time = myTotalTime;

        return Utilities.formatTime(time);
    }
}
