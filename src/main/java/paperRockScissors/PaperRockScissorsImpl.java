package paperRockScissors;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Paper Rock Scissors game concrete class implementation
 */
public class PaperRockScissorsImpl implements PaperRockScissors {

    private final Scanner scanner;

    private int numberOfHands;

    private String[] players = {"Computer", "Player"};
    private int[] score = {0, 0};

    /**
     * Paper Rock Scissors constructor
     * @param numberOfHands number of game plays, or -1 to play until a winner is found
     * @param scanner the human player inputs scanner
     */
    public PaperRockScissorsImpl(int numberOfHands, Scanner scanner){
        this.numberOfHands = numberOfHands;
        this.scanner = scanner;
    }

    @Override
    public void start() {
        while (numberOfHands > 0) {
            Optional<Integer> handWinner;
            if((handWinner = getHandResult(playNextHand())).isPresent())
                score[handWinner.get()]++;
        }
        stop();
    }

    @Override
    public void stop() {
        if(score[0] == score[1]) {
            System.out.println("It's a tie, no winners found");
        } else if(score[0] > score[1]) {
            System.out.println("The winner is: " + players[0]);
        } else
            System.out.println("The winner is: " + players[1]);
    }

    /**
     * Plays the next hand
     * @return a list with each players play
     */
    public List<Play> playNextHand() {
        List<Play> hand = new ArrayList<>(2);

//        player 1 plays are generated by the computer
        ShapesEnum player1Play = getComputerPlay();
//        player 2 plays are read from the command-line
        ShapesEnum player2Play = getCommandLinePlay();

        hand.add(new Play(0, player1Play));
        hand.add(new Play(1, player2Play));

        System.out.println(players[0] + " " + player1Play + " vs. " + players[1] + " " + player2Play);

//        decrease the number of plays left to play
        numberOfHands--;

        return hand;
    }

    /**
     * Randomly generates a computer play
     * @return a computer play
     */
    protected ShapesEnum getComputerPlay() {
        return ShapesEnum.getRandom();
    }

    /**
     * Reads a player play from the command-line
     */
    private ShapesEnum getCommandLinePlay() {
        Optional<ShapesEnum> shapesEnumAux;
        while(true){
            System.out.println("\n" + players[1] + ", enter your next play: (p)aper, (r)ock or (s)cissors");
            shapesEnumAux = ShapesEnum.get(scanner.next());
            if(shapesEnumAux.isPresent())
                return shapesEnumAux.get();
            else
                System.out.println("Invalid choice. Play: (p)aper, (r)ock or (s)cissors\n");
        }
    }

    /**
     * Determines a given hand result
     * @param hand a list containing plays each player play
     * @return an Optional containing the winner id, none if the hand is a tie
     */
    protected Optional<Integer> getHandResult(List<Play> hand) {
        List<Play> playPaper = hand.stream().filter(x -> x.getShape().equals(ShapesEnum.PAPER)).collect(Collectors.toList());
        List<Play> playRock = hand.stream().filter(x -> x.getShape().equals(ShapesEnum.ROCK)).collect(Collectors.toList());
        List<Play> playScissors = hand.stream().filter(x -> x.getShape().equals(ShapesEnum.SCISSORS)).collect(Collectors.toList());

        Optional<Integer> winner = Optional.empty();

        if(!playPaper.isEmpty() && !playRock.isEmpty()) {
            System.out.print("Paper beats (wraps) rock ");
            winner = Optional.ofNullable(playPaper.get(0).getPlayerId());
        } else if(!playRock.isEmpty() && !playScissors.isEmpty()) {
            System.out.print("Rock beats (blunts) scissors ");
            winner = Optional.ofNullable(playRock.get(0).getPlayerId());
        } else if(!playPaper.isEmpty() && !playScissors.isEmpty()) {
            System.out.print("Scissors beats (cuts) paper ");
            winner = Optional.ofNullable(playScissors.get(0).getPlayerId());
        }

        if(winner.isPresent())
            System.out.println(players[winner.get()] + " wins this hand");
        else
            System.out.println("This hand is a tie");

        return winner;
    }
}