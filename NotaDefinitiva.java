
import java.util.Scanner;

public class NotaDefinitiva {

    public static double calcularNota(
            double n1, double n2, double n3,
            double n4, double n5) {

        return (n1 + n2 + n3 + n4 + n5) / 5;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Nota del parcial 1: ");
        double n1 = entrada.nextDouble();

        System.out.print("Nota del parcial 2: ");
        double n2 = entrada.nextDouble();

        System.out.print("Nota del parcial 3: ");
        double n3 = entrada.nextDouble();

        System.out.print("Nota del parcial 4: ");
        double n4 = entrada.nextDouble();

        System.out.print("Nota del parcial 5: ");
        double n5 = entrada.nextDouble();

        double definitiva = calcularNota(n1, n2, n3, n4, n5);

        System.out.println("La nota definitiva es: " + definitiva);

        entrada.close();
    }
}
