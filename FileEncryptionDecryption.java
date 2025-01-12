import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

    private static final int SHIFT_KEY = 5; // Key for Caesar Cipher

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the output file path: ");
        String outputPath = scanner.nextLine();

        try {
            if (choice == 1) {
                processFile(filePath, outputPath, true);
                System.out.println("File encrypted successfully and saved to " + outputPath);
            } else if (choice == 2) {
                processFile(filePath, outputPath, false);
                System.out.println("File decrypted successfully and saved to " + outputPath);
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }

    private static void processFile(String inputPath, String outputPath, boolean encrypt) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = encrypt ? encryptText(line) : decryptText(line);
                writer.write(processedLine);
                writer.newLine();
            }
        }
    }

    private static String encryptText(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + SHIFT_KEY) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private static String decryptText(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - SHIFT_KEY + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
