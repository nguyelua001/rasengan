
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class implements PCER interface to interact with the GUI controller class.
 * 
 * @author Nick Nguyen nml123
 * @version 11/15/2019
 *
 */
public class RacingModel implements PropertyChangeEnabledRaceControls {

    /**
     * Current time in this race.
     */
    private int myTime;
    /**
     * String represent :.
     */
    private String myColon = ":";

    /**
     * A PropertyChangeSupport obj.
     */
    private PropertyChangeSupport myPcs = new PropertyChangeSupport(this);

    /**
     * TelementryMessage object.
     */
    private TelementryMessage myTele;
    /**
     * RaceParticipants object.
     */
    private Participant myRacer;
    /**
     * Leaderboard object.
     */
    private LeaderboardMessage myLeader;

    /**
     * List of Information.
     */
    private List<RaceInfo> myInformation;
    /**
     * List of myMessage.
     */
    private List<Message> myMessage;


    /**
     * Scanner variable.
     */
    private  Scanner myScanner;
    /**
     * Map list.
     */
    private Map<Integer, List<Message>> myMapList;
    /**
     * List of myRacer.
     */

    /**
     * List of racers.
     */
    private ParticipantList myRacerList;

    /**
     * Construct the following object when an object of this class is declared.
     * 
     * @param theInitialStartime input for start time of timer.
     */
    public RacingModel(final int theInitialStartime) {
        super();

        if (theInitialStartime < 0) {
            throw new IllegalArgumentException("Time can't be negative.");

        }
        myPcs = new PropertyChangeSupport(this);

        myTime = theInitialStartime;

        myInformation = new ArrayList<RaceInfo>();
        myRacerList = new ParticipantList();

        myMapList = new HashMap<Integer, List<Message>>();
    }

    /**
     * Overload constructor for empty signature. Set default time at 0.
     */
    public RacingModel() {
        this(0);
    }

    /**
     * Advances the race's internal "clock" by 1 millisecond. All registered listeners will be
     * notified of both the "time" change and any messages that occur during this advance. If
     * the race is advanced beyond its total amount of time, it will not throw an exception but
     * will notify all registered listeners no time remains.
     */

    @Override
    public void advance() {
        advance(1);

    }

    /**
     * Advances the race's internal "clock" by theMilliseconds milliseconds. All registered
     * listeners will be notified of both the "time" change and any messages that occur during
     * this advance. If the race is advanced beyond its total amount of time, it will not throw
     * an exception but will notify all registered listeners no time remains.
     * 
     * @param theMillisecond the amount of milliseconds to advance the race
     */
    @Override
    public void advance(final int theMillisecond) {

        changeTime(myTime + theMillisecond);

    }

    /**
     * Helper method to change the value of time and notify observers. Functional
     * decomposition.
     * 
     * @param theMilliTime the time to change to.
     */
    private void changeTime(final int theMilliTime) {
        // Mark for original time.
        final int ogTime = myTime;

        // Assign myTime to the "new" time from signature
        myTime = theMilliTime;

        // Fire property change. Old time and up date my time - new time.
        myPcs.firePropertyChange(PROPERTY_TIME, ogTime, myTime);

        // TODO Insert time run , move slider later

    }

    /**
     * Move the Race's internal "clock" to theMilliseconds milliseconds after the start of the
     * race. All registered listeners will be notified of the "time" change. Starting at
     * theMilliseconds and working backward in "time," all registered listeners will be
     * notified of the new most recent leaderboard and telemetry message (for all racers).
     * 
     * @param theMillisecond the time to move the race's internal "clock" to
     * @throws IllegalArgumentException when theMillisecond is negative or greater than the
     *             length of the race.
     */

    @Override
    public void moveTo(final int theMillisecond) {
        if (theMillisecond < 0) {
            throw new IllegalArgumentException();
        }
        changeTime(theMillisecond);

    }

    /**
     * Toggles participant information ON/OFF. When the race advances, it notifies registered
     * listeners of messages that occur during the advance. Race participants may be toggled
     * such that, when on, telemetry messages relating to that participant ID will be included
     * in the notification(s). When off, telemetry messages relating to that participant ID
     * will NOT be included in the notification(s). The View should no longer display a
     * participant who is toggled off.
     * 
     * @param theParticpantID the participant to toggle on/off.
     * @param theToggle toggle a participant on (true) or off (false)
     */
    @Override
    public void toggleParticipant(final int theParticpantID, final boolean theToggle) {
        // TODO Auto-generated method stub

    }

    /**
     * Load a file containing race information. All registered listeners will be notified of
     * progress updates during the load. All registered listeners will be notified of
     * information in the header message when the loading process completes.
     * 
     * @param theRaceFile the file to load.
     * @throws IOException when the file is not in the appropriate format
     */
    @Override
    public void loadRace(final File theRaceFile) throws IOException {


        // Create Scanner obj to read the File.
        final Scanner input = new Scanner(theRaceFile);
        // Seperate by the Colon :
        input.useDelimiter(myColon);
        // Create a String Array to store first 7 components; racename, track geo, width,
        // height, distance, time. Take second token [1] in first 7 strings.
        String[] componentArr;
        componentArr = input.nextLine().split(myColon);
        final String raceName = componentArr[1];

        componentArr = input.nextLine().split(myColon);
        final String trackGeometry = componentArr[1];

        componentArr = input.nextLine().split(myColon);
        final int w = Integer.valueOf(componentArr[1]);

        componentArr = input.nextLine().split(myColon);
        final int h = Integer.valueOf(componentArr[1]);

        componentArr = input.nextLine().split(myColon);
        final int distanceOneLap = Integer.valueOf(componentArr[1]);

        componentArr = input.nextLine().split(myColon);
        final int timeTotal = Integer.valueOf(componentArr[1]);

        componentArr = input.nextLine().split(myColon);
        final int participant = Integer.valueOf(componentArr[1]);

        final List<Participant> raceList = new ArrayList<>();
        // Create new RaceInformation object for List<RaceInformation>
        myInformation.add(new RaceInfo(raceName, trackGeometry, timeTotal, distanceOneLap,
                                       raceList));

        // Read participant names
        for (int lineCount = 0; lineCount < participant; lineCount++) {
            // Next line
            final String temp = input.nextLine();

            // Racer Id
            final int raceId = Integer.valueOf
                            (temp.split(myColon)[0].replaceAll("[^0-9]", ""));
            // Participant name
            final String name = temp.split(myColon)[1];

            // Participant start time (Time)
            final double starts = Double.valueOf(temp.split(myColon)[2]);

            // Create new Race Participant from the information obtained above
            myRacer = new Participant(raceId, name, starts);

            // Add this new racer to the racer list.
            myRacerList.add(myRacer);
        }

        // While there is string exists
        while (input.hasNextLine()) {

            // Create ArrayList<Message>. Empty List ?
            myMessage = new ArrayList<Message>();

            // Next String input
            final String line = input.nextLine();

            // Extract this line from the
            myScanner = extracted(line);
            final Scanner split = myScanner.useDelimiter(myColon);

            final String messageType = split.next();
            final int timeStamp = split.nextInt();

            if (messageType.charAt(1) == 'T') {
                final int raceId = split.nextInt();
                final double distance = split.nextDouble();
                final int lap = split.nextInt();
                myTele = new TelementryMessage(timeStamp, raceId, distance, lap);
                myMessage.add(myTele);
                myMapList.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(myTele);

            } else if (messageType.charAt(1) == 'C') {
                final int raceId = split.nextInt();
                final int newLap = split.nextInt();
                final boolean isFinish = split.nextBoolean();
                final LineCrossingMessage lineMess =
                                new LineCrossingMessage(timeStamp, raceId, newLap, isFinish);
                myMessage.add(lineMess);
                myMapList.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(lineMess);
            } else if (messageType.charAt(1) == 'L') {
                final List<Integer> lbList = new ArrayList<Integer>();
                for (int i = 2; i < participant + 2; i++) {
                    lbList.add(Integer.valueOf(line.split(myColon)[i]));
                }
                myLeader = new LeaderboardMessage(timeStamp, lbList);
                myMessage.add(myLeader);
                myMapList.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(myLeader);

            }

        }
        // Close input to avoid data leak.
        input.close();
    }



    /**
     * Get the RacerID.
     * 
     * @return myRacer ID.
     */
    public List<Integer> getRacerID() {
        return myRacerList.getRaceIDList();
    }

    /**
     * Get the RacerDistance.
     * 
     * @return myRacer distance.
     */
    public List<Double> getDistance() {
        return myRacerList.getDistanceList();
    }

    /**
     * Get the participant list.
     * 
     * @return list of participants.
     */
    public ParticipantList getRacerList() {
        return myRacerList;
    }

    /**
     * ToString method return this race information as a string.
     * 
     * @return String represent information for this race.
     */

    public String getRaceInformation() {

        return myInformation.toString();

    }

    /**
     * Extracted scanner method.
     * 
     * @param theLine line.
     * @return new line.
     */
    private static Scanner extracted(final String theLine) {
        return new Scanner(theLine);
    }

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(theListener);

    }

    @Override
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(thePropertyName, theListener);

    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(theListener);

    }

    @Override
    public void removePropertyChangeListener(final String thePropertyName,
                                             final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(thePropertyName, theListener);
    }

}
