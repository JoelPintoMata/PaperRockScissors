package strategy.template.paperRockScissors;

/**
 * PaperRockScissorsSolutionImpl interface
 *
 * Having the solution injected in the game implementation allow better decoupling and thus better testing
 */
public interface PaperRockScissorsSolution {
    String isSolution(String player1, PaperRockScissorsEnum player1Play, String player2, PaperRockScissorsEnum player2Play);
}