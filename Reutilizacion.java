import java.util.Scanner;

public class Reutilizacion {
    private static final Scanner scanner = new Scanner(System.in);

    public static int ingresarEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. " + mensaje);
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    public static double ingresarRealD(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido. " + mensaje);
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}