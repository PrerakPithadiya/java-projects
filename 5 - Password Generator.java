import java.util.Random;
import java.util.Scanner;

class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their name
        System.out.print("Enter your name: ");
        String name = scanner.next();

        // Generate random digits
        Random random = new Random();
        int randomDigits = random.nextInt(10000); // Generate a random number between 0 and 9999

        // Format the random number to have 4 digits
        String formattedDigits = String.format("%04d", randomDigits);

        // Generate the random password combining name and random digits
        String password = name + formattedDigits;

        // Display the generated password
        System.out.println("Generated Password: " + password);

        scanner.close();
    }
}
