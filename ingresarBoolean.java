import java.util.Scanner;

public class ingresarBoolean {

    public static boolean ingresarBoolean(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        boolean respuesta = scanner.nextBoolean();
        return respuesta;
    }

    public static double ingresarRealD(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public static int ingresarEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public static double ingresarRealRango(String mensaje, double valorMinimo, double valorMaximo) {
        double valor;

        while (true) {
            valor = ingresarRealD(mensaje);

            if (valor < valorMinimo || valor > valorMaximo) {
                System.out.println("El valor no está entre " + valorMinimo + " y " + valorMaximo);
            } else {
                return valor;
            }
        }
    }

    public static int ingresarEnteroRango(String mensaje, int valorMinimo, int valorMaximo) {
        int valor;

        while (true) {
            valor = ingresarEntero(mensaje);

            if (valor < valorMinimo || valor > valorMaximo) {
                System.out.println("El valor no está entre " + valorMinimo + " y " + valorMaximo);
            } else {
                return valor;
            }
        }
    }

    public static int ingresarEnteroMayorQue(String mensaje, int valorMinimo) {
        int valor;

        while (true) {
            valor = ingresarEntero(mensaje);

            if (valor <= valorMinimo) {
                System.out.println("El valor no es mayor que " + valorMinimo);
            } else {
                return valor;
            }
        }
    }

    public static void main(String[] args) {
        boolean respuesta = ingresarBoolean("Ingrese true o false: ");
        System.out.println("Respuesta: " + respuesta);

        double real = ingresarRealRango("Ingrese un real entre 1 y 10: ", 1.0, 10.0);
        System.out.println("Real válido: " + real);

        int entero = ingresarEnteroRango("Ingrese un entero entre 1 y 100: ", 1, 100);
        System.out.println("Entero válido: " + entero);

        int mayor = ingresarEnteroMayorQue("Ingrese un entero mayor que 10: ", 10);
        System.out.println("Entero válido: " + mayor);
    }
}