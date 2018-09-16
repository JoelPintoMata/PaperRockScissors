package paperRockScissors;

import junit.framework.Assert;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaperRockScissorsImplTest {

    private PaperRockScissorsImpl paperRockScissors;
    private Scanner scanner = new Scanner(System.in);
    
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        paperRockScissors = new PaperRockScissorsImpl(-1, scanner);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void start() {
    }

    @org.junit.jupiter.api.Test
    void stop() {
    }

    @org.junit.jupiter.api.Test
    void isOver() {
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
        paperRockScissors = new PaperRockScissorsImpl(-1, scanner);
        var play = paperRockScissors.playNextHand();
        Assert.assertNotNull(play);
        Assert.assertEquals(play.get(0).getPlayerId(), 0);
        Assert.assertEquals(play.get(1).getPlayerId(), 1);
        Assert.assertEquals(play.get(1).getShape(), ShapresEnum.PAPER);

        in = new ByteArrayInputStream("r".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(-1, scanner);
        play = paperRockScissors.playNextHand();
        Assert.assertNotNull(play);
        Assert.assertEquals(play.get(0).getPlayerId(), 0);
        Assert.assertEquals(play.get(1).getPlayerId(), 1);
        Assert.assertEquals(play.get(1).getShape(), ShapresEnum.ROCK);

        in = new ByteArrayInputStream("s".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(-1, scanner);

        play = paperRockScissors.playNextHand();
        Assert.assertNotNull(play);
        Assert.assertEquals(play.get(0).getPlayerId(), 0);
        Assert.assertEquals(play.get(1).getPlayerId(), 1);
        Assert.assertEquals(play.get(1).getShape(), ShapresEnum.SCISSORS);

        in = new ByteArrayInputStream("x".getBytes());
        System.setIn(in);
        this.scanner = new Scanner(System.in);
        paperRockScissors = new PaperRockScissorsImpl(-1, scanner);

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

        play.add(new Play(0, ShapresEnum.PAPER));
        play.add(new Play(1, ShapresEnum.PAPER));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.empty());

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.ROCK));
        play.add(new Play(1, ShapresEnum.ROCK));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.empty());

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.SCISSORS));
        play.add(new Play(1, ShapresEnum.SCISSORS));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.empty());
//        end

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.PAPER));
        play.add(new Play(1, ShapresEnum.ROCK));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(0));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.ROCK));
        play.add(new Play(1, ShapresEnum.PAPER));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(1));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.SCISSORS));
        play.add(new Play(1, ShapresEnum.PAPER));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(0));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.PAPER));
        play.add(new Play(1, ShapresEnum.SCISSORS));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(1));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.ROCK));
        play.add(new Play(1, ShapresEnum.SCISSORS));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(0));

        play = new ArrayList<>(2);
        play.add(new Play(0, ShapresEnum.SCISSORS));
        play.add(new Play(1, ShapresEnum.ROCK));
        Assert.assertEquals(paperRockScissors.getHandResult(play), Optional.of(1));
    }
}