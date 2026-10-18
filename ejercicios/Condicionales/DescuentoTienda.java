
import java.util.Scanner;

public class DescuentoTienda {

    public static double calcularDescuento(double compra) {
        return compra * 0.20;
    }

    public static double calcularTotal(double compra, double descuento) {
        return compra - descuento;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el mes: ");
        String mes = entrada.nextLine();

        System.out.print("Valor de la compra: ");
        double compra = entrada.nextDouble();

        if (compra < 0) {
            System.out.println("La compra no puede ser negativa.");
        } else if (mes.equalsIgnoreCase("diciembre")) {

            double descuento = calcularDescuento(compra);
            double total = calcularTotal(compra, descuento);

            System.out.println("Descuento: $" + descuento);
            System.out.println("Total a pagar: $" + total);

        } else {
            System.out.println("No aplica descuento.");
            System.out.println("Total a pagar: $" + compra);
        }

        entrada.close();
    }
}
