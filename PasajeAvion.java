
import java.util.Scanner;

public class PasajeAvion {

    public static double calcularPrecio(double distancia) {
        return distancia * 2 * 89500;
    }

    public static double calcularDescuento(double precio) {
        return precio * 0.30;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Distancia de ida en kilometros: ");
        double distancia = entrada.nextDouble();

        System.out.print("Dias de estancia: ");
        int dias = entrada.nextInt();

        if (distancia <= 0 || dias < 0) {
            System.out.println("Los datos ingresados no son validos.");
        } else {

            double precio = calcularPrecio(distancia);

            if (distancia > 1000 && dias > 7) {

                double descuento = calcularDescuento(precio);
                double total = precio - descuento;

                System.out.println("Precio sin descuento: $" + precio);
                System.out.println("Descuento: $" + descuento);
                System.out.println("Precio final: $" + total);

            } else {
                System.out.println("No aplica descuento.");
                System.out.println("Precio final: $" + precio);
            }
        }

        entrada.close();
    }
}
