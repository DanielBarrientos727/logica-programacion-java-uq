import java.util.Scanner;

public class Reutilizacion {
    private static final Scanner scanner = new Scanner(System.in);

    // Método para ingresar enteros con validación de tipo de dato
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

    // Método para ingresar números reales (double) con validación de tipo
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

    // Método para ingresar texto
    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Método para validar que un entero sea mayor que un valor mínimo
    public static int ingresarEnteroMayorQue(String mensaje, int valorMinimo) {
        boolean repetir = true;
        int valor = 0;
        while (repetir) {
            valor = Reutilizacion.ingresarEntero(mensaje);
            if (valor <= valorMinimo) {
                System.out.println("El valor no es mayor que " + valorMinimo);
            } else {
                repetir = false;
            }
        }
        return valor;
    }

    // Método para validar que un real sea mayor que un valor mínimo
    public static double ingresarRealMayorQue(String mensaje, double valorMinimo) {
        boolean repetir = true;
        double valor = 0.0;
        while (repetir) {
            valor = Reutilizacion.ingresarRealD(mensaje);
            if (valor <= valorMinimo) {
                System.out.println("El valor no es mayor que " + valorMinimo);
            } else {
                repetir = false;
            }
        }
        return valor;
    }
}