
import java.util.Scanner;

public class OperacionesNumeros {

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Primer numero: ");
        double a = entrada.nextDouble();

        System.out.print("Segundo numero: ");
        double b = entrada.nextDouble();

        if (a > b) {
            System.out.println("Suma: " + sumar(a, b));
            System.out.println("Diferencia: " + restar(a, b));
        } else {
            System.out.println("Producto: " + multiplicar(a, b));

            if (b != 0) {
                System.out.println("Division: " + dividir(a, b));
            } else {
                System.out.println("No se puede dividir entre cero.");
            }
        }

        entrada.close();
    }
}
