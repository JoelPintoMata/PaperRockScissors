package strategy.template.paperRockScissors;

/**
 * Enumerator class specifying
 * 1) available plays for the paper, rock, scissors methods.
 * 2) auxiliary methods supporting the usage of this enumeartor
 */
public enum PaperRockScissorsEnum {
    PAPER,
    ROCK,
    SCISSORS;

    /**
     * Generates a random PaperRockScissorsEnum
     * @return a random PaperRockScissorsEnum
     */
    public static PaperRockScissorsEnum getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    /**
     * Auxiliary method getter to convert a string into an PaperRockScissorsEnum
     * @param value the string value
     * @return a random PaperRockScissorsEnum
     */
    public static PaperRockScissorsEnum get(String value) {
        if(value.equalsIgnoreCase("p"))
            return PAPER;
        if(value.equalsIgnoreCase("r"))
            return ROCK;
        if(value.equalsIgnoreCase("s"))
            return SCISSORS;
        else
//            raise an exception would be another option, but exception handling in expensive
            return null;
    }
}