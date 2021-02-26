package ch.epfl.tchu.game;

import ch.epfl.tchu.Preconditions;

/**
 * The station of the game
 */
public final class Station {

    /**
     * Attributs
     */
    private String name;
    private int id;

    /**
     * Constructor
     * @param name the name of the station
     * @param id the id of the station
     */
    public Station(String name, int id) {
        //Check the correctness of the arguments
        Preconditions.checkArgument( id>0 && id<=50);

        //Init the attributes
        this.name = name;
        this.id = id;
    }

    /**
     * Getter for the name of the station
     * @return
     */
    public String name() {
        return name;
    }

    /**
     * Getter for the id of the station
     * @return
     */
    public int id() {
        return id;
    }

    @Override
    public String toString(){
        return name;
    }
}
