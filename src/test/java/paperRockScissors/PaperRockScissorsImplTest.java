package paperRockScissors;

import junit.framework.Assert;
import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PaperRockScissorsImpl tests class
 */
class PaperRockScissorsImplTest {

    private PaperRockScissorsImpl paperRockScissors;
    private Scanner scanner = new Scanner(System.in);
    
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        paperRockScissors = new PaperRockScissorsImpl(1, scanner);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void start() {
        ByteArrayInputStream in = new ByteArrayInputStream("p\np\np".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(3, scanner);
        paperRockScissors.playNextHand();
        paperRockScissors.playNextHand();
        paperRockScissors.playNextHand();
//        the forth time we try to play fails
        assertThrows(NoSuchElementException.class,
                () -> paperRockScissors.playNextHand());
    }

    @org.junit.jupiter.api.Test
    void stop() {
    }

    /**
     * Tests the generation/process of a new hand
     */
    @org.junit.jupiter.api.Test
    void playNextHand() {
//        Tests that we can read the parameters correctly from a input stream
        ByteArrayInputStream in = new ByteArrayInputStream("p".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(1, scanner);
        var play = paperRockScissors.playNextHand();
        Assert.assertNotNull(play);
        Assert.assertEquals(play.get(0).getPlayerId(), 0);
        Assert.assertEquals(play.get(1).getPlayerId(), 1);
        Assert.assertEquals(play.get(1).getShape(), ShapesEnum.PAPER);

        in = new ByteArrayInputStream("r".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(1, scanner);
        play = paperRockScissors.playNextHand();
        Assert.assertNotNull(play);
        Assert.assertEquals(play.get(0).getPlayerId(), 0);
        Assert.assertEquals(play.get(1).getPlayerId(), 1);
        Assert.assertEquals(play.get(1).getShape(), ShapesEnum.ROCK);

        in = new ByteArrayInputStream("s".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(1, scanner);

        play = paperRockScissors.playNextHand();
        Assert.assertNotNull(play);
        Assert.assertEquals(play.get(0).getPlayerId(), 0);
        Assert.assertEquals(play.get(1).getPlayerId(), 1);
        Assert.assertEquals(play.get(1).getShape(), ShapesEnum.SCISSORS);

        in = new ByteArrayInputStream("x".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl( 1, scanner);

//        Tests that only the correct parameters are accepted
        assertThrows(NoSuchElementException.class,
                () -> paperRockScissors.playNextHand());
    }

    @org.junit.jupiter.api.Test
    void getComputerPlay() {
        for(int i=5; i<5; i++)
            Assert.assertNotNull(paperRockScissors.getComputerPlay());
    }

    /**
     * Tests the results of a hand play
     */
    @org.junit.jupiter.api.Test
    void getHandResult() {
//        test a tied hand
        List<Play> play = new ArrayList<>(2);

        play.add(new Play(0, ShapesEnum.PAPER));
        play.add(new Play(1, ShapesEnum.PAPER));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.empty());

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.ROCK));
        play.add(new Play(1, ShapesEnum.ROCK));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.empty());

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.SCISSORS));
        play.add(new Play(1, ShapesEnum.SCISSORS));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.empty());
//        end

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.PAPER));
        play.add(new Play(1, ShapesEnum.ROCK));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(0));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.ROCK));
        play.add(new Play(1, ShapesEnum.PAPER));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(1));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.SCISSORS));
        play.add(new Play(1, ShapesEnum.PAPER));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(0));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.PAPER));
        play.add(new Play(1, ShapesEnum.SCISSORS));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(1));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.ROCK));
        play.add(new Play(1, ShapesEnum.SCISSORS));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(0));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapesEnum.SCISSORS));
        play.add(new Play(1, ShapesEnum.ROCK));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(1));
    }
}