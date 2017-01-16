import strategy.template.Strategy;
import strategy.template.StrategyTemplate;
import strategy.template.paperRockScissors.PaperRockScissorsImpl;


/**
 * Step 1 implementation of the "Strategy" design pattern:
 *  "Clients couple strictly to the interface" of a strategy, that is, the game selection/execution is done against a StrategyTemplate, not the specific game.
 *
 *  We could easily add a new game type(s) in the algorithms Strategy type array without other code changes in order to run different codes
 *
 *      StrategyTemplate paperRockScissors  = new PaperRockScissorsImpl();
 *      StrategyTemplate soduku             = new SodukuImpl();
 *      Strategy[] algorithms               = {paperRockScissors, soduku};
 */
public class Main {

    public static void main(String[] args) {
        StrategyTemplate paperRockScissors = new PaperRockScissorsImpl();

        Strategy[] algorithms = {paperRockScissors};

        for (int i=0; i < algorithms.length; i++) {
            algorithms[i].solve();
        }
    }
}