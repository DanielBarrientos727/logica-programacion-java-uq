
import java.util.Random;
import java.util.Scanner;

public class GeneradorURLYouTube {

    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    static final String CARACTERES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvwxyz"
                    + "0123456789-_";

    public static void mostrarMenu() {
        System.out.println("\n==================================");
        System.out.println("    GENERADOR DE URL DE YOUTUBE");
        System.out.println("==================================");
        System.out.println("1. Generar una URL");
        System.out.println("2. Generar varias URL");
        System.out.println("3. Salir");
        System.out.println("==================================");
    }

    public static int ingresarEnteroRango(
            String mensaje, int minimo, int maximo) {

        int valor;

        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();

                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }

                System.out.println(
                        "Error: ingrese un valor entre "
                                + minimo + " y " + maximo + ".");
            } else {
                System.out.println(
                        "Error: debe ingresar un numero entero.");
                scanner.next();
            }
        }
    }

    public static String generarID() {
        String id = "";

        for (int i = 0; i < 11; i++) {
            int indice = random.nextInt(CARACTERES.length());
            id += CARACTERES.charAt(indice);
        }

        return id;
    }

    public static String generarURL() {
        return "https://www.youtube.com/watch?v=" + generarID();
    }

    public static void generarUnaURL() {
        System.out.println("\nURL generada:");
        System.out.println(generarURL());
    }

    public static void generarVariasURL() {
        int cantidad = ingresarEnteroRango(
                "Cuantas URL desea generar (1-100): ", 1, 100);

        System.out.println("\n========== RESULTADOS ==========");

        for (int i = 1; i <= cantidad; i++) {
            System.out.println(i + ". " + generarURL());
        }
    }

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();

            opcion = ingresarEnteroRango(
                    "Seleccione una opcion: ", 1, 3);

            switch (opcion) {
                case 1:
                    generarUnaURL();
                    break;

                case 2:
                    generarVariasURL();
                    break;

                case 3:
                    System.out.println(
                            "\nGracias por utilizar el generador.");
                    break;
            }

        } while (opcion != 3);

        scanner.close();
    }
}
