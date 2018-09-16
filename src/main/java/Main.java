import paperRockScissors.PaperRockScissors;
import paperRockScissors.PaperRockScissorsImpl;

import java.util.Scanner;


/**
 * Paper Rock Scissors main class
 */
public class Main {

    public static void main(String[] args) {
        try {
//            create a scanner so we can read the command-line input
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the maximum number of plays of -1 to play until a winner is found: ");
            int numberOfPlays = Integer.parseInt(scanner.next());

            PaperRockScissors paperRockScissors = new PaperRockScissorsImpl(numberOfPlays, scanner);
            paperRockScissors.start();

        } catch (NumberFormatException e) {
            System.out.println("The maximum number of plays should be of type number, bye.\n");
        }
    }
}