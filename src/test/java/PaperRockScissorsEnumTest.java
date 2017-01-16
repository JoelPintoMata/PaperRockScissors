import junit.framework.Assert;
import strategy.template.paperRockScissors.PaperRockScissorsEnum;

/**
 * PaperRockScissorsSolutionImplTest test class
 */
public class PaperRockScissorsEnumTest {

    private PaperRockScissorsEnum paperRockScissorsEnum;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void paperRockScissorsEnumTest() throws Exception {
        Assert.assertEquals("get() method must return PAPER for input 'p'", paperRockScissorsEnum.get("p"), PaperRockScissorsEnum.PAPER);
        Assert.assertEquals("get() method must return ROCK for input 'r'", paperRockScissorsEnum.get("r"), PaperRockScissorsEnum.ROCK);
        Assert.assertEquals("get() method must return SCISSORS for input 's'", paperRockScissorsEnum.get("s"), PaperRockScissorsEnum.SCISSORS);

        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get("a"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get("aa"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get("aaa"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get("1"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get("12"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get("123"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get(""));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", paperRockScissorsEnum.get(" "));
    }
}