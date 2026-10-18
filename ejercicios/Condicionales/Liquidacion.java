
import java.util.Scanner;

public class Liquidacion {

    public static double calcularPrima(double salario, int dias) {
        return (salario * dias) / 360;
    }

    public static double calcularCesantias(double salario, int dias) {
        return (salario * dias) / 360;
    }

    public static double calcularIntereses(double cesantias, int dias) {
        return cesantias * (0.12 / dias);
    }

    public static double calcularVacaciones(double salario, int dias) {
        return (salario * dias) / 720;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el salario mensual: ");
        double salario = entrada.nextDouble();

        System.out.print("Ingrese los dias laborados: ");
        int dias = entrada.nextInt();

        if (salario <= 0 || dias <= 0) {
            System.out.println("El salario y los dias deben ser mayores que cero.");
        } else {

            double prima = calcularPrima(salario, dias);
            double cesantias = calcularCesantias(salario, dias);
            double intereses = calcularIntereses(cesantias, dias);
            double vacaciones = calcularVacaciones(salario, dias);

            double total = prima + cesantias + intereses + vacaciones;

            System.out.println("\n=== LIQUIDACION ===");
            System.out.println("Prima: $" + prima);
            System.out.println("Cesantias: $" + cesantias);
            System.out.println("Intereses: $" + intereses);
            System.out.println("Vacaciones: $" + vacaciones);
            System.out.println("Total: $" + total);
        }

        entrada.close();
    }
}
