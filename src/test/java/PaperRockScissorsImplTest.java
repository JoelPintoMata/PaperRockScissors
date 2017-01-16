import strategy.template.paperRockScissors.PaperRockScissorsImpl;
import strategy.template.paperRockScissors.PaperRockScissorsSolutionImpl;

/**
 * PaperRockScissorsSolutionImplTest test class
 */
public class PaperRockScissorsImplTest {

    private PaperRockScissorsImpl paperRockScissors;
    private PaperRockScissorsSolutionImpl paperRockScissorsSolution;

    @org.junit.Before
    public void setUp() throws Exception {
        paperRockScissorsSolution = new PaperRockScissorsSolutionImpl();
        paperRockScissors = new PaperRockScissorsImpl("player 1", "player 2", 3, paperRockScissorsSolution);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void paperRockScissorsImplTest() throws Exception {
//        there is not much to test here as methods under PaperRockScissorsImpl are protected and decided not to make them public just by the sake of testing
//        that said, its open to discussion...
    }
}