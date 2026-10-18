
import java.util.Scanner;

public class CostoEnvio {

    public static double calcularCostoPeso(double peso, double costoKg) {
        return peso * costoKg;
    }

    public static double calcularTotal(double costoPeso, double costoFijo) {
        return costoPeso + costoFijo;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Peso del paquete en kg: ");
        double peso = entrada.nextDouble();

        System.out.print("Costo por kilogramo: ");
        double costoKg = entrada.nextDouble();

        System.out.print("Costo fijo del servicio: ");
        double costoFijo = entrada.nextDouble();

        if (peso >= 0 && costoKg >= 0 && costoFijo >= 0) {

            double costoPeso = calcularCostoPeso(peso, costoKg);
            double total = calcularTotal(costoPeso, costoFijo);

            System.out.println("Costo por peso: $" + costoPeso);
            System.out.println("Valor total del envio: $" + total);

        } else {
            System.out.println("Los valores no pueden ser negativos.");
        }

        entrada.close();
    }
}
