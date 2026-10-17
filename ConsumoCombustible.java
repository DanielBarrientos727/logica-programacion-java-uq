
import java.util.Scanner;

public class ConsumoCombustible {

    public static double calcularRendimiento(double kilometros, double litros) {
        return kilometros / litros;
    }

    public static double calcularCosto(double litros, double precio) {
        return litros * precio;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Kilometros recorridos: ");
        double kilometros = entrada.nextDouble();

        System.out.print("Litros consumidos: ");
        double litros = entrada.nextDouble();

        System.out.print("Precio por litro: ");
        double precio = entrada.nextDouble();

        if (kilometros >= 0 && litros > 0 && precio >= 0) {

            double rendimiento = calcularRendimiento(kilometros, litros);
            double costo = calcularCosto(litros, precio);

            System.out.println("Rendimiento: " + rendimiento + " km/l");
            System.out.println("Costo total del viaje: $" + costo);

        } else {
            System.out.println("Los datos ingresados no son validos.");
        }

        entrada.close();
    }
}
