package Projects;

import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!\n");

        // Start the game loop
        do {
            System.out.print("Please guess a number between 1 and 100: ");
            int guessedNumber = scanner.nextInt();

            attempts++;

            // Check if the guessed number is correct
            if (guessedNumber == targetNumber) {
                break;
            } else if (guessedNumber < targetNumber) {
                System.out.println("Too low! Try a larger number.\n");
            } else {
                System.out.println("Too high! Try a smaller number.\n");
            }

        } while (true);

        // Game ended, display result
        System.out.println("\nCongratulations! You have successfully guessed the number in " + attempts + " attempts.");
        System.out.println("Thank you for playing.");
        System.out.println("Developed by: Prerak Pithadiya");
    }
}



Here is a short explanation of the code:

1. Imports: The code imports the Random and Scanner classes from java.util package. These classes are used for generating random numbers and taking user input respectively.

2. Main Class: The main class is named NumberGuessingGame.

3. Main Method: The main method is the entry point of the program. It initializes a Scanner object for user input and a Random object for generating random numbers.

4. Random Number Generation: A random number between 1 and 100 (inclusive) is generated using the nextInt(100) + 1 method of the Random class.

5. Game Loop: The game loop is implemented using a do-while loop. Inside the loop, the player is prompted to guess a number between 1 and 100. The number of attempts is incremented with each guess.

6. Guess Evaluation: After each guess, the program checks whether the guessed number matches the target number. If the guess is correct, the loop breaks. Otherwise, the program provides feedback to the player, informing them whether the guess was too high or too low.

7. Game Result: After the game loop ends (i.e., when the correct number is guessed), the program displays a congratulatory message along with the number of attempts taken to guess the number.

8. Goodbye Message: Finally, the program displays a thank you message and the name of the developer.
