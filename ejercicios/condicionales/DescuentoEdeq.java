
import java.util.Scanner;

public class DescuentoEdeq {

    public static double calcularDescuento(double factura) {
        return factura * 0.10;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Valor de la factura: ");
        double factura = entrada.nextDouble();

        if (factura < 0) {
            System.out.println("Valor no valido.");
        } else if (factura > 100000) {

            double descuento = calcularDescuento(factura);
            double total = factura - descuento;

            System.out.println("Descuento: $" + descuento);
            System.out.println("Total a pagar: $" + total);

        } else {
            System.out.println("No aplica descuento.");
            System.out.println("Total a pagar: $" + factura);
        }

        entrada.close();
    }
}
