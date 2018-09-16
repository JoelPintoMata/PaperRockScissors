package paperRockScissors;


/**
 * Represents a player play
 */
public class Play {

    private final int playerId;
    private final ShapesEnum shape;

    public Play(int playerId, ShapesEnum shape) {
        this.playerId = playerId;
        this.shape = shape;
    }

    public ShapesEnum getShape() {
        return shape;
    }

    public int getPlayerId() {
        return playerId;
    }
}
