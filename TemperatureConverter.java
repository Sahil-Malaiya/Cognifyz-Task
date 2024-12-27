import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for temperature input
        System.out.println("Welcome to the Temperature Converter!");
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        // Prompt user for the unit of measurement
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0); // Convert to uppercase for consistency

        double convertedTemperature;
        if (unit == 'C') {
            // Convert Celsius to Fahrenheit
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemperature);
        } else if (unit == 'F') {
            // Convert Fahrenheit to Celsius
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemperature);
        } else {
            // Handle invalid input
            System.out.println("Invalid unit of measurement. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }

        scanner.close();
    }
}
