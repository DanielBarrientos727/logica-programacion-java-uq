
import java.util.Scanner;

public class NexusNeural {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Parametros iniciales de la neurona
        double peso1 = 0.0;
        double peso2 = 0.0;
        double sesgo = 0.0;
        double tasaAprendizaje = 0.2;

        // Variables de entrenamiento
        int entrada1 = 0;
        int entrada2 = 0;
        int objetivo = 0;
        int salida = 0;
        int error = 0;

        int epocasUsadas = 0;
        int ajustesTotales = 0;
        int erroresEpoca;

        boolean entrenada = false;
        boolean sistemaActivo = true;

        System.out.println("====================================");
        System.out.println("          NEXUS NEURAL              ");
        System.out.println("    PERCEPTRON DE DOS ENTRADAS      ");
        System.out.println("====================================");

        System.out.println();
        System.out.println("Entrenando neurona para aprender AND...");

        // ENTRENAMIENTO
        for (int epoca = 1; epoca <= 100; epoca++) {

            erroresEpoca = 0;

            // Cuatro ejemplos de entrenamiento
            for (int muestra = 0; muestra < 4; muestra++) {

                // Seleccionar un ejemplo
                switch (muestra) {

                    case 0:
                        entrada1 = 0;
                        entrada2 = 0;
                        objetivo = 0;
                        break;

                    case 1:
                        entrada1 = 0;
                        entrada2 = 1;
                        objetivo = 0;
                        break;

                    case 2:
                        entrada1 = 1;
                        entrada2 = 0;
                        objetivo = 0;
                        break;

                    case 3:
                        entrada1 = 1;
                        entrada2 = 1;
                        objetivo = 1;
                        break;
                }

                // Calcular la respuesta de la neurona
                double suma = entrada1 * peso1
                        + entrada2 * peso2 + sesgo;

                if (suma >= 0) {
                    salida = 1;
                } else {
                    salida = 0;
                }

                // Comparar prediccion con respuesta esperada
                error = objetivo - salida;

                // Ajustar los parametros si hubo un error
                if (error != 0) {

                    peso1 = peso1
                            + tasaAprendizaje * error * entrada1;

                    peso2 = peso2
                            + tasaAprendizaje * error * entrada2;

                    sesgo = sesgo
                            + tasaAprendizaje * error;

                    erroresEpoca++;
                    ajustesTotales++;
                }
            }

            epocasUsadas = epoca;

            // Si no hubo errores, el entrenamiento termino
            if (erroresEpoca == 0) {
                entrenada = true;
                break;
            }
        }

        if (entrenada) {
            System.out.println("Entrenamiento completado.");
        } else {
            System.out.println(
                    "Se alcanzo el limite de entrenamiento.");
        }

        System.out.println("Epocas ejecutadas: " + epocasUsadas);
        System.out.println("Ajustes realizados: " + ajustesTotales);

        // MENU PRINCIPAL
        do {

            System.out.println();
            System.out.println("============= MENU =============");
            System.out.println("1. Probar la neurona");
            System.out.println("2. Mostrar tabla AND");
            System.out.println("3. Mostrar pesos aprendidos");
            System.out.println("0. Apagar sistema");
            System.out.println("================================");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.println();
                        System.out.println("===== PROBAR NEURONA =====");

                        System.out.print("Entrada 1 (0 o 1): ");

                        if (scanner.hasNextInt()) {
                            entrada1 = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println(
                                    "Error: debe ingresar un entero.");
                            scanner.nextLine();
                            break;
                        }

                        System.out.print("Entrada 2 (0 o 1): ");

                        if (scanner.hasNextInt()) {
                            entrada2 = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            System.out.println(
                                    "Error: debe ingresar un entero.");
                            scanner.nextLine();
                            break;
                        }

                        if ((entrada1 == 0 || entrada1 == 1)
                                && (entrada2 == 0 || entrada2 == 1)) {

                            double suma = entrada1 * peso1
                                    + entrada2 * peso2 + sesgo;

                            if (suma >= 0) {
                                salida = 1;
                            } else {
                                salida = 0;
                            }

                            System.out.println(
                                    "Entrada: " + entrada1 + ", " + entrada2);

                            System.out.println(
                                    "Suma ponderada: " + suma);

                            System.out.println(
                                    "Prediccion de la neurona: " + salida);

                        } else {
                            System.out.println(
                                    "Solo se permiten entradas 0 o 1.");
                        }

                        break;

                    case 2:
                        System.out.println();
                        System.out.println("===== TABLA APRENDIDA =====");
                        System.out.println("X1 | X2 | Salida");

                        for (int x1 = 0; x1 <= 1; x1++) {

                            for (int x2 = 0; x2 <= 1; x2++) {

                                double suma = x1 * peso1
                                        + x2 * peso2 + sesgo;

                                int prediccion;

                                if (suma >= 0) {
                                    prediccion = 1;
                                } else {
                                    prediccion = 0;
                                }

                                System.out.println(
                                        x1 + "  | " + x2 + "  | "
                                                + prediccion);
                            }
                        }

                        break;

                    case 3:
                        System.out.println();
                        System.out.println("===== PARAMETROS =====");
                        System.out.println("Peso 1: " + peso1);
                        System.out.println("Peso 2: " + peso2);
                        System.out.println("Sesgo: " + sesgo);
                        System.out.println(
                                "Tasa de aprendizaje: "
                                        + tasaAprendizaje);
                        System.out.println(
                                "Entrenada correctamente: " + entrenada);
                        break;

                    case 0:
                        sistemaActivo = false;
                        System.out.println("Apagando NEXUS NEURAL...");
                        break;

                    default:
                        System.out.println(
                                "Opcion no valida. Intente de nuevo.");
                        break;
                }

            } else {
                System.out.println(
                        "Entrada invalida. Escriba un numero.");
                scanner.nextLine();
            }

        } while (sistemaActivo);

        scanner.close();

        System.out.println("Sistema finalizado.");
    }
}
