import paperRockScissors.PaperRockScissors;
import paperRockScissors.PaperRockScissorsImpl;

import java.util.Scanner;


/**
 * Paper Rock Scissors main class
 */
public class Main {

    public static void main(String[] args) {
        try {
//            create a scanner so we can read the command-line inputs
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the number of hands to play: ");
            int numberOfHands = Integer.parseInt(scanner.next());

            PaperRockScissors paperRockScissors = new PaperRockScissorsImpl(numberOfHands, scanner);
            paperRockScissors.start();

        } catch (NumberFormatException e) {
            System.out.println("The number of hands should be of type number, bye.\n");
        }
    }
}