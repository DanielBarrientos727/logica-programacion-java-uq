
import java.util.Scanner;

public class Bonificacion {

    public static double calcularAumento(double sueldo) {
        return sueldo * 0.15;
    }

    public static double calcularSueldoFinal(double sueldo, double aumento) {
        return sueldo + aumento;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el sueldo actual: ");
        double sueldo = entrada.nextDouble();

        if (sueldo < 0) {
            System.out.println("El sueldo no puede ser negativo.");
        } else if (sueldo < 1500000) {

            double aumento = calcularAumento(sueldo);
            double sueldoFinal = calcularSueldoFinal(sueldo, aumento);

            System.out.println("Bonificacion: $" + aumento);
            System.out.println("Sueldo a recibir: $" + sueldoFinal);

        } else {
            System.out.println("No recibio bonificacion.");
            System.out.println("Sueldo a recibir: $" + sueldo);
        }

        entrada.close();
    }
}
