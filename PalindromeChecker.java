 import java.util.Scanner;
public class PalindromeChecker {

    // Method to remove spaces, punctuation, and convert to lowercase
    public static String cleanInput(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Method to check if the cleaned input is a palindrome
    public static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It's a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker!");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        String cleanedInput = cleanInput(input);

        if (isPalindrome(cleanedInput)) {
            System.out.println("The input is a palindrome!");
        } else {
            System.out.println("The input is not a palindrome.");
        }

        scanner.close();
    }
}
