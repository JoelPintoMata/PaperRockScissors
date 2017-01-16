package strategy.template;


/**
 * Step 1 implementation of the "Strategy" design pattern:
 *  "Define the interface of the algorithm" of a strategy, that is, an interface specifying the set of mandatory methods all games must implement
 */
public interface Strategy {

    /**
     * Solves this game
     */
    void solve();
}