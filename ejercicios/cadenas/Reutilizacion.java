import java.util.Scanner;

public class Reutilizacion {
    private static final Scanner scanner = new Scanner(System.in);


    //String

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

    //Double

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

    //IngresarTextos

    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    //IngresarEnteroMayorQue

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

    //IngresarRealMayorQue

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