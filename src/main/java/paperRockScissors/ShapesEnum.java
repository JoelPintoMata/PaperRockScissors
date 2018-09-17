package paperRockScissors;

import java.util.Optional;


/**
 * Enumerator class specifying
 * 1) available plays for the paper, rock, scissors methods.
 * 2) auxiliary methods supporting the usage of this enumerator
 */
public enum ShapesEnum {
    PAPER,
    ROCK,
    SCISSORS;

    /**
     * Generates a random ShapesEnum
     * @return a random ShapesEnum
     */
    public static ShapesEnum getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    /**
     * Auxiliary method getter to convert a string into an ShapesEnum
     * @param value the string value
     * @return a random ShapesEnum
     */
    public static Optional<ShapesEnum> get(String value) {
        if(value.equalsIgnoreCase("p"))
            return Optional.of(PAPER);
        if(value.equalsIgnoreCase("r"))
            return Optional.of(ROCK);
        if(value.equalsIgnoreCase("s"))
            return Optional.of(SCISSORS);
        return Optional.empty();
    }
}