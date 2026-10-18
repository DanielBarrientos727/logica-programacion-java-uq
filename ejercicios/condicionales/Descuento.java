
import java.util.Scanner;

public class Descuento {

    public static double calcularDescuento(double precio, double porcentaje) {
        return precio * porcentaje;
    }

    public static double calcularPrecioFinal(double precio, double descuento) {
        return precio - descuento;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Precio del producto: ");
        double precio = entrada.nextDouble();

        System.out.print("Descuento (entre 0.0 y 1.0): ");
        double porcentaje = entrada.nextDouble();

        double descuento = calcularDescuento(precio, porcentaje);
        double precioFinal = calcularPrecioFinal(precio, descuento);

        System.out.println("Valor del descuento: $" + descuento);
        System.out.println("Precio final: $" + precioFinal);

        entrada.close();
    }
}
