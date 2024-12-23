import java.util.Random;
import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        // Create an instance of Scanner for user input
        Scanner scanner = new Scanner(System.in);

        int days = 0;
        boolean validInput = false;

        // Prompting user for input until a valid input is received
        while (!validInput) {
            System.out.println("Welcome to the Weather Forecasting Program!");
            System.out.println("Please enter the number of days for the forecast (1-7): ");
            if (scanner.hasNextInt()) {
                days = scanner.nextInt();
                if (days >= 1 && days <= 7) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        // Generate a weather forecast for the given number of days
        generateWeatherForecast(days);

        // Close the scanner
        scanner.close();
    }

    public static void generateWeatherForecast(int days) {
        // Random object for generating random data
        Random random = new Random();

        // Weather conditions array
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Stormy", "Windy"};

        // Temperature range settings
        int minTemp = -10; // Minimum temperature in Celsius
        int maxTemp = 40;  // Maximum temperature in Celsius

        // Humidity range settings
        int minHumidity = 20;  // Minimum humidity in percentage
        int maxHumidity = 100; // Maximum humidity in percentage

        System.out.println("\nWeather Forecast for the next " + days + " days:");

        for (int i = 1; i <= days; i++) {
            // Randomly select a weather condition
            String condition = conditions[random.nextInt(conditions.length)];

            // Generate random temperature and humidity values
            int temperature = random.nextInt(maxTemp - minTemp + 1) + minTemp;
            int humidity = random.nextInt(maxHumidity - minHumidity + 1) + minHumidity;

            // Print forecast details
            System.out.println("Day " + i + ":");
            System.out.println("Condition: " + condition);
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("----------------------------");
        }
    }
}
