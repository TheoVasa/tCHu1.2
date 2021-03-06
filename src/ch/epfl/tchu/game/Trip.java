package ch.epfl.tchu.game;

import ch.epfl.tchu.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Trip between two station and its corresponding points. From town to town,
 * town to country and country to country.
 */
public final class Trip {

    /**
     * Arguments of the Trip
     */
    final private Station from;
    final private Station to;
    final private int points;

    /**
     * Constructor
     * @param from the starting station of the trip
     * @param to the final station of the trip
     * @param points the amount of points the trip provides
     */
    public Trip(Station from, Station to, int points) {
        //Check the correctness of the arguments
        Preconditions.checkArgument(points > 0);

        //Init the attributes
        this.from   = Objects.requireNonNull(from);
        this.to     = Objects.requireNonNull(to);
        this.points = points;
    }

    /**
     * Gives all possible trips between all the stations
     * @param from the list of the starting station of the trips
     * @param to the list of the final station of the trips
     * @param points the list of the amount of points each trip provides
     * @return the list of each possible trip
     */
    public static List<Trip> all(List<Station> from, List<Station> to, int points) {
        //Check the correctness of the arguments
        Preconditions.checkArgument(points > 0 && !from.isEmpty() && !to.isEmpty());

        //Fill the list of trips
        List<Trip> allTrips = new ArrayList<>();
        for (Station a : from){
            for (Station b : to){
                allTrips.add(new Trip(a, b, points));
            }
        }

        return allTrips;
    }

    /**
     * Getter for the starting Station of the trip
     * @return the starting position of the trip
     */
    public Station from() {
        return from;
    }

    /**
     * Getter for the final station of the trip
     * @return the final station of the trip
     */
    public Station to() {
        return to;
    }

    /**
     * Getter for the amount of points the trips provides
     * @return the amount of points the trip provides
     */
    public int points() {
        return points;
    }

    /**
     * Gives the amounts of points according of the given connectivity
     * @param connectivity the connection between two station
     * @return the amount of points for the given connection
     */
    public int points(StationConnectivity connectivity){
        if (connectivity.connected(from, to)) {
            return points;
        } else {
            return points * -1;
        }
    }
}