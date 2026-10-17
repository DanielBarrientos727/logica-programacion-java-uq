
import java.util.Scanner;

public class Hospitalizacion {

    public static double calcularTotal(int dias, double valorDia) {
        return dias * valorDia;
    }

    public static double calcularDescuento(double total) {
        return total * 0.05;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Dias de hospitalizacion: ");
        int dias = entrada.nextInt();

        System.out.print("Valor por dia: ");
        double valorDia = entrada.nextDouble();

        if (dias <= 0 || valorDia < 0) {
            System.out.println("Los datos ingresados no son validos.");
        } else {

            double total = calcularTotal(dias, valorDia);
            double descuento = calcularDescuento(total);
            double totalFinal = total - descuento;

            System.out.println("Hospitalizacion sin descuento: $" + total);
            System.out.println("Descuento realizado: $" + descuento);
            System.out.println("Hospitalizacion con descuento: $" + totalFinal);
        }

        entrada.close();
    }
}
