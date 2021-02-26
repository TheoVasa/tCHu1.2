package ch.epfl.tchu.game;

import ch.epfl.tchu.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Ticket of a trip
 */
public final class Ticket implements Comparable<Ticket> {

    /**
     * Attributes
     */
    private static List<Trip> trips;



    /**
     * Constructor (principale)
     * @param trips list of all the trips that requires a ticket
     */
    public Ticket(List<Trip> trips){
        //Check the correctness of the arguments
        Preconditions.checkArgument(trips.size() > 0);
        for (int i = 1; i < trips.size(); ++i){
            Preconditions.checkArgument(trips.get(i).from().toString() == trips.get(i-1).from().toString());
        }

        //Init the attributes
        this.trips = trips;
        text = computeText();
    }
    private static  String text;// = computeText();


    /**
     * Constructor (secondaire)
     * @param from the starting station of the trip
     * @param to the final station of the trip
     * @param points the amount of points the trip provides
     */
    public Ticket(Station from, Station to, int points){
        this(Arrays.asList(new Trip(from, to, points)));
    }

    /**
     * Built the text of the ticket
     * @return the text of the ticket
     */
    private static String computeText(){
        TreeSet<String> destinations = new TreeSet<>();

        //Get all the possible destination (useful for neighbor countries)
        for (int i = 0; i < trips.size(); ++i) {
            destinations.add(trips.get(i).to().name() + " (" + trips.get(i).points() + ")");
        }

        //Assemble the text considering if its a town-town ticket or town-country/country-country ticket
        String finalText = new String();
        if (destinations.size() > 1){
            finalText = String.format("%s - {%s}", trips.get(0).from().name(), String.join(", ", destinations));
        } else if (destinations.size() == 1){
            finalText = String.format("%s - %s", trips.get(0).from().name(), destinations.first());
        }

        return finalText;
    }

    /**
     * Getter for the trip name of the ticket
     * @return the trip information
     */
    public static String text(){
        return text;
    }

    /**
     * Gives the amount of point that the player achieved with this ticket
     * @param connectivity the connectivity of the trip
     * @return the amount of point of the trip of the ticket that the player managed to connect
     */
    public static int points(StationConnectivity connectivity){
        for (int i = 0; i < trips.size(); ++i){
            if (connectivity.connected(trips.get(i).from(), trips.get(i).to())){
                return trips.get(i).points();
            }
        }
        return 0;
    }

    @Override
    public int compareTo(Ticket ticket) {
        return this.text.compareTo(ticket.toString()) ;
    }

    @Override
    public String toString(){
        return text;
    }
}
