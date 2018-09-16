package paperRockScissors;


/**
 * Paper Rock Scissors game interface
 */
public interface PaperRockScissors {

    /**
     * Initializes the game
     */
    void start();

    /**
     * Checks the game is over
     *
     * @return true if the game is over, false, if not
     */
    boolean isOver();

    /**
     * Stops the game and returns the name of the winner
     *
     * @return the name of the winner, or null, if no winners are found or the games ends in a draw
     */
    void stop();
}