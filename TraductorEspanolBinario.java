import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TraductorEspanolBinario {

    // Colores ANSI para la terminal
    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String AZUL = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String ROJO = "\u001B[31m";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();

            System.out.print(CYAN + "Selecciona una opcion: " + RESET);
            String entrada = scanner.nextLine().trim();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(ROJO + "\nError: introduce un numero valido.\n" + RESET);
                opcion = -1;
                continue;
            }

            switch (opcion) {

                case 1:
                    convertirTextoABinario();
                    break;

                case 2:
                    convertirBinarioATexto();
                    break;

                case 0:
                    System.out.println(
                            VERDE + "\nGracias por utilizar el traductor. ¡Hasta pronto!\n"
                                    + RESET
                    );
                    break;

                default:
                    System.out.println(
                            ROJO + "\nOpcion no valida. Intenta nuevamente.\n" + RESET
                    );
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Muestra el menu principal
    private static void mostrarMenu() {

        System.out.println(CYAN);
        System.out.println("========================================");
        System.out.println("       TRADUCTOR ESPANOL - BINARIO");
        System.out.println("========================================");
        System.out.println(RESET);

        System.out.println("  1. Texto a binario");
        System.out.println("  2. Binario a texto");
        System.out.println("  0. Salir");

        System.out.println("\n----------------------------------------");
    }

    // Convierte un texto a su representacion binaria UTF-8
    private static void convertirTextoABinario() {

        System.out.println("\n--- TEXTO A BINARIO ---");
        System.out.print("Escribe el texto: ");

        String texto = scanner.nextLine();

        byte[] bytes = texto.getBytes(StandardCharsets.UTF_8);
        StringBuilder binario = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {

            // Convierte cada byte en un numero binario de 8 bits
            String bits = String.format(
                    "%8s",
                    Integer.toBinaryString(bytes[i] & 0xFF)
            ).replace(' ', '0');

            binario.append(bits);

            // Separa los bytes para facilitar la lectura
            if (i < bytes.length - 1) {
                binario.append(' ');
            }
        }

        System.out.println("\nTexto original:");
        System.out.println(texto);

        System.out.println("\nRepresentacion binaria UTF-8:");
        System.out.println(VERDE + binario + RESET);

        System.out.println("\nCantidad de bytes: " + bytes.length);
        System.out.println("----------------------------------------\n");
    }

    // Reconstruye el texto desde una secuencia binaria UTF-8
    private static void convertirBinarioATexto() {

        System.out.println("\n--- BINARIO A TEXTO ---");
        System.out.println("Introduce los bits separados por espacios");
        System.out.println("o escribe una secuencia continua de bits.");
        System.out.print("\nBinario: ");

        String binario = scanner.nextLine();

        // Elimina espacios, tabulaciones y saltos de linea
        binario = binario.replaceAll("\\s+", "");

        if (binario.isEmpty()) {
            System.out.println(ROJO + "\nNo has introducido ningun bit.\n" + RESET);
            return;
        }

        if (!binario.matches("[01]+")) {
            System.out.println(
                    ROJO + "\nError: solo se permiten los digitos 0 y 1.\n" + RESET
            );
            return;
        }

        if (binario.length() % 8 != 0) {
            System.out.println(
                    ROJO + "\nError: la cantidad de bits debe ser multiplo de 8.\n"
                            + RESET
            );
            return;
        }

        byte[] bytes = new byte[binario.length() / 8];

        for (int i = 0; i < binario.length(); i += 8) {

            String grupo = binario.substring(i, i + 8);
            int valor = Integer.parseInt(grupo, 2);

            bytes[i / 8] = (byte) valor;
        }

        String texto = new String(bytes, StandardCharsets.UTF_8);

        System.out.println("\nTexto recuperado:");
        System.out.println(VERDE + texto + RESET);

        System.out.println("----------------------------------------\n");
    }
}