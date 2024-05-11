package KalpeshSir;

import java.util.Scanner;

// Class representing a person
class Passenger {
    String name;
    char gender;
    String destination;
    float ticketPrice;

    // Constructor to initialize a passenger
    Passenger(String name, char gender, String destination, float ticketPrice) {
        this.name = name;
        this.gender = gender;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

    // Method to display passenger information
    void displayInfo() {
        String info = String.format("[Name: %s, Gender: %c, Destination: %s, Ticket Price: $%.2f]", name, gender, destination, ticketPrice);
        System.out.println(info);
    }
}

class PassengerDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of passengers
        System.out.print("Enter the number of passengers: ");
        int numOfPassengers = scanner.nextInt();

        // Check if passengers are allowed to enter the vehicle
        System.out.print("Allow the passengers to enter the vehicle? (Y / N): ");
        char choice = scanner.next().trim().charAt(0);
        if (choice == 'N' || choice == 'n') {
            System.out.println("The program has been terminated.");
            return;
        }

        // Create an array to store passenger objects
        Passenger[] passengers = new Passenger[numOfPassengers];

        // Input passenger details
        for (int i = 0; i < numOfPassengers; i++) {
            System.out.println("Enter the details of passenger " + (i + 1) + ": ");
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter gender (M/F): ");
            char gender = scanner.next().trim().charAt(0);
            System.out.print("Enter destination: ");
            String destination = scanner.next();
            System.out.print("Enter ticket price: $");
            float ticketPrice = scanner.nextFloat();
            passengers[i] = new Passenger(name, gender, destination, ticketPrice);
            System.out.println();
        }

        // Display passenger information
        System.out.println("Passenger Details:");
        for (int i = 0; i < numOfPassengers; i++) {
            System.out.print("Passenger " + (i + 1) + ": ");
            passengers[i].displayInfo();
        }
    }
}
