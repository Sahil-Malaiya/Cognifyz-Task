import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    // Method to generate a random password
    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                          boolean includeUppercase, boolean includeSpecialChars) {
        // Define character pools based on user preferences
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        // Build the character pool
        String characterPool = "";
        if (includeNumbers) {
            characterPool += numbers;
        }
        if (includeLowercase) {
            characterPool += lowercaseLetters;
        }
        if (includeUppercase) {
            characterPool += uppercaseLetters;
        }
        if (includeSpecialChars) {
            characterPool += specialCharacters;
        }

        // Handle case where no character types are selected
        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException("At least one character type must be selected!");
        }

        // Generate random password
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Password Generator!");

        // Prompt user for password length
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Validate password length
        if (length <= 0) {
            System.out.println("Invalid password length. Please enter a positive number.");
            return;
        }

        // Prompt user for character types
        System.out.println("Should the password include the following?");
        System.out.print("Numbers (0-9)? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Lowercase letters (a-z)? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.print("Uppercase letters (A-Z)? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.print("Special characters (!@#$%^&*)? (true/false): ");
        boolean includeSpecialChars = scanner.nextBoolean();

        try {
            // Generate and display the password
            String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
            System.out.println("\nGenerated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
