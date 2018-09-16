import junit.framework.Assert;
import paperRockScissors.ShapresEnum;

/**
 * PaperRockScissorsSolutionImplTest test class
 */
public class ShapresEnumTest {

    private ShapresEnum shapresEnum;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void paperRockScissorsEnumTest() throws Exception {
        Assert.assertEquals("get() method must return PAPER for input 'p'", shapresEnum.get("p"), ShapresEnum.PAPER);
        Assert.assertEquals("get() method must return ROCK for input 'r'", shapresEnum.get("r"), ShapresEnum.ROCK);
        Assert.assertEquals("get() method must return SCISSORS for input 's'", shapresEnum.get("s"), ShapresEnum.SCISSORS);

        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get("a"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get("aa"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get("aaa"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get("1"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get("12"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get("123"));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get(""));
        Assert.assertNull("get() method must return null for anything other than 'p', 'r' and 's' ", shapresEnum.get(" "));
    }
}