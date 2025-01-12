import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();

        int strengthScore = calculateStrength(password);

        System.out.println("Password Strength: " + evaluateStrength(strengthScore));
        scanner.close();
    }

    private static int calculateStrength(String password) {
        int score = 0;

        // Criteria for password strength
        if (password.length() >= 8) {
            score++;
        }

        if (password.matches(".*[A-Z].*")) { // Contains an uppercase letter
            score++;
        }

        if (password.matches(".*[a-z].*")) { // Contains a lowercase letter
            score++;
        }

        if (password.matches(".*\\d.*")) { // Contains a digit
            score++;
        }

        if (password.matches(".*[!@#$%^&*()_+\"':;?<>.,\\-].*")) { // Contains a special character
            score++;
        }

        return score;
    }

    private static String evaluateStrength(int score) {
        switch (score) {
            case 5:
                return "Very Strong";
            case 4:
                return "Strong";
            case 3:
                return "Moderate";
            case 2:
                return "Weak";
            default:
                return "Very Weak";
        }
    }
}
