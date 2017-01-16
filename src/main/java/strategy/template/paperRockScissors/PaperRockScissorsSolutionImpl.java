package strategy.template.paperRockScissors;

/**
 * PaperRockScissorsSolutionImpl concrete implementation
 *
 * Having the solution injected in the game implementation allow better decoupling and thus better testing
 */
public class PaperRockScissorsSolutionImpl implements PaperRockScissorsSolution{

    public String isSolution(String player1, PaperRockScissorsEnum player1Play, String player2, PaperRockScissorsEnum player2Play) {
//        paper wraps rock
        if (player1Play.equals(PaperRockScissorsEnum.PAPER)
                && player2Play.equals(PaperRockScissorsEnum.ROCK)){
            System.out.println("Paper beats (wraps) rock");
            return player1;
        }
        if (player2Play.equals(PaperRockScissorsEnum.PAPER)
                && player1Play.equals(PaperRockScissorsEnum.ROCK)){
            System.out.println("Paper beats (wraps) rock");
            return player2;
        }
//        rock blunts scissors
        if (player1Play.equals(PaperRockScissorsEnum.ROCK)
                && player2Play.equals(PaperRockScissorsEnum.SCISSORS)){
            System.out.println("Rock beats (blunts) scissors");
            return player1;
        }
        if(player2Play.equals(PaperRockScissorsEnum.ROCK)
                && player1Play.equals(PaperRockScissorsEnum.SCISSORS)){
            System.out.println("Rock beats (blunts) scissors");
            return player2;
        }
//        scissors cuts paper
        if(player1Play.equals(PaperRockScissorsEnum.SCISSORS)
                && player2Play.equals(PaperRockScissorsEnum.PAPER)){
            System.out.println("Scissors beats (cuts) paper");
            return player1;
        }
        if(player2Play.equals(PaperRockScissorsEnum.SCISSORS)
                && player1Play.equals(PaperRockScissorsEnum.PAPER)){
            System.out.println("Scissors beats (cuts) paper");
            return player2;
        }
        return null;
    }
}