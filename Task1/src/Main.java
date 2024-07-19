import java.util.Scanner;
//@Author @Mokal2002
public class Main  extends Thread{
    public static void main(String[] args) {
        try {
            System.out.println("Program Starting..........");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("################################");
        System.out.println("Temperature Conversion Program");
        System.out.println("################################");


        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            System.out.println("===================================================");
            System.out.print("Enter the temperature value You Want to Convert: ");
            double temperature = scanner.nextDouble();
            System.out.println("===================================================");


            System.out.println("Enter the unit of measurement");
            System.out.println("C For Celsius");
            System.out.println("F for Fahrenheit");
            System.out.println("K for Kelvin");
            System.out.print("Select : ");
            char unit = scanner.next().toUpperCase().charAt(0);
            System.out.println("================================================================");


            switch (unit) {
                case 'C' -> convertFromCelsius(temperature);
                case 'F' -> convertFromFahrenheit(temperature);
                case 'K' -> convertFromKelvin(temperature);
                default -> System.out.println("Invalid unit of measurement.");
            }
            System.out.println("================================================================");
            System.out.println("Do you want to perform another conversion? (y/n): ");
            System.out.println("================================================================");

            String response = scanner.next().toLowerCase();
            if (response.equals("y")) {
                continueConversion = true;
            }
            else {
                System.out.println("#################################");
                System.out.println("Thanks for checking our Product.");
                System.out.println("#################################");

                continueConversion = false;

            }
        }

        scanner.close();
    }

    public static void convertFromCelsius(double celsius) {
        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;
        System.out.println("Result");
        System.out.printf("Celsius is: %.2f \n", celsius);
        System.out.printf("Celsius To Fahrenheit: %.2f \n", fahrenheit);
        System.out.printf("Celsius To Kelvin: %.2f \n", kelvin);
    }

    public static void convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = (fahrenheit + 459.67) * 5/9;
        System.out.println("Result");
        System.out.printf("Fahrenheit is: %.2f \n", fahrenheit);
        System.out.printf("Fahrenheit To Celsius: %.2f \n", celsius);
        System.out.printf("Fahrenheit To Kelvin: %.2f \n", kelvin);
    }

    public static void convertFromKelvin(double kelvin) {
        double celsius = kelvin - 273.15;
        double fahrenheit = (kelvin * 9/5) - 459.67;
        System.out.println("Result");
        System.out.printf("Kelvin is: %.2f \n", kelvin);
        System.out.printf("Kelvin To Celsius: %.2f \n", celsius);
        System.out.printf("Kelvin To Fahrenheit: %.2f \n", fahrenheit);
    }
}
//Made with @Mokal2002