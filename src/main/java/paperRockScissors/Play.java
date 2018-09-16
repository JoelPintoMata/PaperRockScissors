package paperRockScissors;

public class Play {

    private final int playerId;
    private final ShapresEnum shape;

    public Play(int playerId, ShapresEnum shape) {
        this.playerId = playerId;
        this.shape = shape;
    }

    public ShapresEnum getShape() {
        return shape;
    }

    public int getPlayerId() {
        return playerId;
    }
}
