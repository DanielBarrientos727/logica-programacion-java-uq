
import java.util.Scanner;

public class VentaTerreno {

    public static double calcularValorTerreno(double metros, double valorMetro) {
        return metros * valorMetro;
    }

    public static double calcularComision(double valorTerreno) {
        return valorTerreno * 0.02;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Metros cuadrados del terreno: ");
        double metros = entrada.nextDouble();

        System.out.print("Valor por metro cuadrado: ");
        double valorMetro = entrada.nextDouble();

        if (metros <= 0 || valorMetro < 0) {
            System.out.println("Los datos ingresados no son validos.");
        } else {

            double valorTerreno = calcularValorTerreno(metros, valorMetro);
            double comision = calcularComision(valorTerreno);
            double precioVenta = valorTerreno + comision;

            System.out.println("Valor del terreno: $" + valorTerreno);
            System.out.println("Comision: $" + comision);
            System.out.println("Precio de venta: $" + precioVenta);
        }

        entrada.close();
    }
}
