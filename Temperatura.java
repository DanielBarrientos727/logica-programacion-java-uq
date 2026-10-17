
import java.util.Scanner;

public class Temperatura {

    public static double convertirKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double convertirFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Temperatura en Celsius: ");
        double celsius = entrada.nextDouble();

        double kelvin = convertirKelvin(celsius);
        double fahrenheit = convertirFahrenheit(celsius);

        System.out.println("Temperatura en Kelvin: " + kelvin);
        System.out.println("Temperatura en Fahrenheit: " + fahrenheit);

        entrada.close();
    }
}
