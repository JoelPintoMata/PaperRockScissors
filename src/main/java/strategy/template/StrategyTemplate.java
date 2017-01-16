package strategy.template;


/**
 * Step 2 implementation of the "Strategy" design pattern:
 *  "Generic implementation" of a strategy, that is, an abstract class offering naive implementation of method shared by all games
 */
public abstract class StrategyTemplate implements Strategy {

    /**
     * Solves this game
     */
    public void solve() {
        start();
        while (! isOver() && nextTry() && ! isSolution())
            ;
        stop();
    }

    /**
     * Initializes the game
     */
    protected abstract void     start();

    /**
     * Creates the game players
     */
    protected abstract void     createPlayers();

    /**
     * Performs a next game play
     * @return true if the next game play was performed, false otherwise
     */
    protected abstract boolean  nextTry();

    /**
     * Checks if a given play is the solution to the game (more generally, checks if game is finished)
     * @return
     */
    protected abstract boolean  isSolution();

    /**
     * Checks the game is over
     * @return true if the game is over, false, if not
     */
    protected abstract boolean   isOver();

    /**
     * Stops the game and returns the name of the winner
     * @return the name of the winner, or null, if no winners are found or the games ends in a draw
     */
    protected abstract void     stop();
}