package paperRockScissors;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ShapesEnumTest {

    private ShapesEnum shapesEnum;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void getRandom() {
        List<ShapesEnum> list = new ArrayList<>(3);
        list.add(ShapesEnum.PAPER);
        list.add(ShapesEnum.ROCK);
        list.add(ShapesEnum.SCISSORS);
        for(int i=0; i<10; i++) {
            Assert.assertTrue(list.contains(shapesEnum.getRandom()));
        }
    }

    @Test
    void get() {
        Assert.assertEquals("get() method must return PAPER for input 'p'", shapesEnum.get("p").get(), ShapesEnum.PAPER);
        Assert.assertEquals("get() method must return ROCK for input 'r'", shapesEnum.get("r").get(), ShapesEnum.ROCK);
        Assert.assertEquals("get() method must return SCISSORS for input 's'", shapesEnum.get("s").get(), ShapesEnum.SCISSORS);

        Assert.assertEquals("get() method must return null for anything other than 'p', 'r' and 's' ", shapesEnum.get("a"), Optional.empty());
        Assert.assertEquals("get() method must return null for anything other than 'p', 'r' and 's' ", shapesEnum.get("1"), Optional.empty());
        Assert.assertEquals("get() method must return null for anything other than 'p', 'r' and 's' ", shapesEnum.get(""), Optional.empty());
        Assert.assertEquals("get() method must return null for anything other than 'p', 'r' and 's' ", shapesEnum.get(" "), Optional.empty());
    }
}