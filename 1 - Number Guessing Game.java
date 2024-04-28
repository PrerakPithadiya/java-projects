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