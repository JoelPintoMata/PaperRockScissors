import junit.framework.Assert;
import strategy.template.paperRockScissors.PaperRockScissorsEnum;
import strategy.template.paperRockScissors.PaperRockScissorsSolutionImpl;

/**
 * PaperRockScissorsSolutionImplTest test class
 */
public class PaperRockScissorsSolutionImplTest {

    private PaperRockScissorsSolutionImpl paperRockScissorsSolution;

    @org.junit.Before
    public void setUp() throws Exception {
        paperRockScissorsSolution = new PaperRockScissorsSolutionImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void paperRockScissorsSolutionImplTest() throws Exception {
        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.PAPER, "player 2", PaperRockScissorsEnum.PAPER), null);
        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.ROCK, "player 2", PaperRockScissorsEnum.ROCK), null);
        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.SCISSORS, "player 2", PaperRockScissorsEnum.SCISSORS), null);

        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.PAPER, "player 2", PaperRockScissorsEnum.ROCK), "player 1");
        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.ROCK, "player 2", PaperRockScissorsEnum.PAPER), "player 2");

        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.ROCK, "player 2", PaperRockScissorsEnum.SCISSORS), "player 1");
        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.SCISSORS, "player 2", PaperRockScissorsEnum.ROCK), "player 2");

        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.SCISSORS, "player 2", PaperRockScissorsEnum.PAPER), "player 1");
        Assert.assertEquals(paperRockScissorsSolution.isSolution("player 1", PaperRockScissorsEnum.PAPER, "player 2", PaperRockScissorsEnum.SCISSORS), "player 2");
    }
}