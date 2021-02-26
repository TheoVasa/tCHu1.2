package ch.epfl.tchu.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String[] args){

        //######## Si tu change le nb de point de trip3 (different que trip2) alors le text du ticket sera faux...
        Trip trip1 = new Trip(new Station("Lausanne", 10), new Station("France", 11), 10);
        Trip trip2 = new Trip(new Station("Lausanne", 10), new Station("Allemagne", 5), 5);
        Trip trip3 = new Trip(new Station("Lausanne", 10), new Station("Allemagne", 5), 5);

        List<Trip> trips = new ArrayList<>();
        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);

        Ticket ticket = new Ticket(trips);

        System.out.println(ticket.text());
    }
}
