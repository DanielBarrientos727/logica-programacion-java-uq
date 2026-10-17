
import java.util.Scanner;

public class DevueltaCompra {

    public static double calcularDevuelta(double pago, double factura) {
        return pago - factura;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Valor de la factura: ");
        double factura = entrada.nextDouble();

        System.out.print("Dinero entregado: ");
        double pago = entrada.nextDouble();

        double devuelta = calcularDevuelta(pago, factura);

        System.out.println("La devuelta es: $" + devuelta);

        entrada.close();
    }
}
