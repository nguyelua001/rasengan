
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Participants myRacerList class.
 * 
 * @author Nick Nguyen
 * @version 2019
 *
 */
public class ParticipantList {
    /** List of participants. */
    private final List<Participant> myRacerList;
    /** List of participants name. */
    private final List<String> myNameList;
    /** List of participants race id. */
    private final List<Integer> myRaceIDList;
    /** List of participants distance. */
    private final List<Double> myDistanceList;


    /**
     * Default constructor.
     */
    public ParticipantList() {
        
        myRacerList = new ArrayList<>();
        
        myNameList = new ArrayList<>();
        
        myRaceIDList = new ArrayList<>();
        
        myDistanceList = new ArrayList<>();

    }
    
    /**
     * Add new Racers.
     * @param theRacer .
     */
    public void add(final Participant theRacer) {
        myRacerList.add(theRacer);
        myNameList.add(theRacer.getMyRacerName());
        myRaceIDList.add(theRacer.getMyRacerID());
        myDistanceList.add(theRacer.getMyRacerDistance());
    }
    /**
     * Get the name list.
     * @return name list.
     */
    public List<String> getNameList() {
        return myNameList;
    }
    /**
     * Get the race id list.
     * @return race id.
     */
    public List<Integer> getRaceIDList() {
        return myRaceIDList;
    }
    /**
     * Get the distance list.
     * @return distance list.
     */
    public List<Double> getDistanceList() {
        return myDistanceList;
    }
    
    
    
}



