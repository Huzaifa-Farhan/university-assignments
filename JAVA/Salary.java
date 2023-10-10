import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        double currentSalary; // current annual salary
        double rating;
        double raise = 0; // Initialize raise to 0

        Scanner scan = new Scanner(System.in);

        // Get the current salary and performance rating
        System.out.print("Enter the current salary: ");
        currentSalary = scan.nextDouble();

        System.out.print("Enter the performance rating: ");
        rating = scan.nextDouble();

        // Compute the raise using if...else statements
        if (rating == 1) {
            raise = currentSalary * 0.06; // 6% raise for excellent rating
        } else if (rating == 2) {
            raise = currentSalary * 0.04; // 4% raise for good rating
        } else if (rating == 3) {
            raise = currentSalary * 0.015; // 1.5% raise for poor rating
        } else {
            System.out.println("Invalid rating! Please enter a valid rating of 1, 2, or 3.");
            System.exit(1); // Exit the program if an invalid rating is entered
        }

        // Print the results
        System.out.println("Amount of your raise: $" + raise);
        System.out.println("Your new salary: $" + (currentSalary + raise));
    }
}
