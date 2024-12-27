import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of grades
        System.out.println("Welcome to the Student Grade Calculator!");
        System.out.print("Enter the number of grades to be entered: ");
        int numberOfGrades = scanner.nextInt();

        // Validate the input for the number of grades
        if (numberOfGrades <= 0) {
            System.out.println("Invalid number of grades. Please enter a positive number.");
            return;
        }

        // Array to store grades and variable to calculate the total
        double[] grades = new double[numberOfGrades];
        double total = 0;

        // Input grades from the user
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            double grade = scanner.nextDouble();

            // Validate the grade (e.g., between 0 and 100)
            while (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                System.out.print("Enter grade " + (i + 1) + ": ");
                grade = scanner.nextDouble();
            }

            grades[i] = grade; // Store the grade
            total += grade;    // Add to total
        }

        // Calculate the average grade
        double average = total / numberOfGrades;

        // Display the average grade
        System.out.println("\nGrade Summary:");
        System.out.println("-------------------");
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.println("Grade " + (i + 1) + ": " + grades[i]);
        }
        System.out.printf("Average Grade: %.2f%n", average);

        scanner.close();
    }
}

