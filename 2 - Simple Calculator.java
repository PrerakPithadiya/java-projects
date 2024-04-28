package Projects;

import java.util.InputMismatchException;
import java.util.Scanner;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n---------------------------------");
            System.out.println("Welcome to Simple Calculator\n");

            displayMenus();

            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter your choice as an integer.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            if (choice == 7) {
                System.out.println("\nExiting the calculator. Thank you for using Simple Calculator!");
                break;
            } else if (choice < 1 || choice > 7) {
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                continue;
            }

            float firstNumber, secondNumber;

            try {
                System.out.print("Enter the first number: ");
                firstNumber = scanner.nextFloat();
                System.out.print("Enter the second number: ");
                secondNumber = scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the numbers as real.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            double result = calculateResult(choice, firstNumber, secondNumber);
            System.out.printf("Result: %.2f\n", result);

        } while (true);

        scanner.close(); // Closing the scanner
    }

    public static void displayMenus() {
        System.out.println("Choose one of the following options:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Modulus");
        System.out.println("6. Power");
        System.out.println("7. Exit");
    }

    public static double calculateResult(int choice, float firstNumber, float secondNumber) {
        return switch (choice) {
            case 1 -> firstNumber + secondNumber;
            case 2 -> firstNumber - secondNumber;
            case 3 -> firstNumber * secondNumber;
            case 4 -> {
                if (secondNumber == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    yield Double.POSITIVE_INFINITY;
                }
                yield firstNumber / secondNumber;
            }
            case 5 -> firstNumber % secondNumber;
            case 6 -> Math.pow(firstNumber, secondNumber);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }
}