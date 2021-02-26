package ch.epfl.tchu;

/**
 * Help to handle the errors that may occur in the game
 */
public final class Preconditions {

    /**
     * Constructor (private to avoid to create an instance of this class)
     */
    private Preconditions() {
        //put if more preconditions
    }

    /**
     * Throws a IllegalArgumentException
     * @param shouldBeTrue the boolean value of argument we want to check
     */
    public static void checkArgument(boolean shouldBeTrue){
        if(!shouldBeTrue){
            throw new IllegalArgumentException();
        }
    }
}
