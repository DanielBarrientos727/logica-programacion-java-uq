
import java.util.Scanner;

public class MejorDistroLinux {

    static final Scanner scanner = new Scanner(System.in);

    static final String RESET = "\u001B[0m";
    static final String VERDE = "\u001B[32m";
    static final String AZUL = "\u001B[34m";
    static final String AMARILLO = "\u001B[33m";
    static final String ROJO = "\u001B[31m";

    static final int CANTIDAD_DISTROS = 5;
    static final int CANTIDAD_CRITERIOS = 5;

    static final String[] DISTROS = {
            "Ubuntu LTS",
            "Linux Mint",
            "Debian",
            "Xubuntu",
            "Fedora Workstation"
    };

    static final String[] CRITERIOS = {
            "Facilidad de uso",
            "Hardware limitado",
            "Administracion",
            "Estabilidad",
            "Software reciente"
    };

    /*
     * Valoraciones iniciales orientativas, de 1 a 5.
     * No son benchmarks ni resultados de pruebas reales.
     */
    static final int[][] VALORACIONES_BASE = {
            {4, 3, 5, 4, 4}, // Ubuntu LTS
            {5, 4, 2, 4, 3}, // Linux Mint
            {3, 4, 4, 5, 2}, // Debian
            {4, 5, 2, 4, 3}, // Xubuntu
            {3, 3, 3, 4, 5}  // Fedora Workstation
    };

    public static int ingresarEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println(ROJO
                    + "Error: ingrese un numero entero."
                    + RESET);

            scanner.next();
        }
    }

    public static int ingresarEnteroRango(
            String mensaje, int minimo, int maximo) {

        int valor;

        do {
            valor = ingresarEntero(mensaje);

            if (valor < minimo || valor > maximo) {
                System.out.println(AMARILLO
                        + "El valor debe estar entre "
                        + minimo + " y " + maximo + "."
                        + RESET);
            }
        } while (valor < minimo || valor > maximo);

        return valor;
    }

    public static boolean ingresarBoolean(String mensaje) {
        return ingresarEnteroRango(
                mensaje + " (1 = Si, 0 = No): ", 0, 1) == 1;
    }

    public static void mostrarTitulo() {
        System.out.println(AZUL);
        System.out.println("==========================================");
        System.out.println("        LINUX DEPLOYMENT ADVISOR");
        System.out.println("     Evaluacion de distribuciones");
        System.out.println("==========================================");
        System.out.println(RESET);
    }

    public static String obtenerNombreDistro(int distro) {
        return DISTROS[distro];
    }

    public static int limitarValor(int valor, int minimo, int maximo) {
        if (valor < minimo) {
            return minimo;
        }

        if (valor > maximo) {
            return maximo;
        }

        return valor;
    }

    /*
     * Ajusta las valoraciones iniciales segun el escenario.
     * Las modificaciones son heuristicas didacticas.
     */
    public static int[][] evaluarCriterios(
            int ram,
            boolean hardwareAntiguo,
            boolean principiantes,
            boolean administracionCentralizada,
            int uso) {

        int[][] valoraciones = new int[CANTIDAD_DISTROS]
                [CANTIDAD_CRITERIOS];

        for (int i = 0; i < CANTIDAD_DISTROS; i++) {
            for (int j = 0; j < CANTIDAD_CRITERIOS; j++) {
                valoraciones[i][j] = VALORACIONES_BASE[i][j];
            }
        }

        if (principiantes) {
            valoraciones[1][0]++; // Linux Mint
            valoraciones[0][0]++; // Ubuntu
        }

        if (ram <= 4 || hardwareAntiguo) {
            valoraciones[3][1]++; // Xubuntu
            valoraciones[0][1]--;
            valoraciones[4][1]--;
        }

        if (administracionCentralizada) {
            valoraciones[0][2]++; // Ubuntu
            valoraciones[2][2]++; // Debian
        }

        if (uso == 2 || uso == 3) {
            valoraciones[4][4]++; // Fedora
            valoraciones[0][4]++; // Ubuntu
        }

        for (int i = 0; i < CANTIDAD_DISTROS; i++) {
            for (int j = 0; j < CANTIDAD_CRITERIOS; j++) {
                valoraciones[i][j] = limitarValor(
                        valoraciones[i][j], 1, 5);
            }
        }

        return valoraciones;
    }

    /*
     * Los pesos suman 100.
     * La prioridad principal modifica su distribucion.
     */
    public static int[] calcularPesos(int uso, int prioridad) {
        int[] pesos = {20, 20, 25, 20, 15};

        switch (prioridad) {
            case 1: // Estabilidad y soporte
                pesos = new int[]{15, 15, 25, 35, 10};
                break;

            case 2: // Facilidad de uso
                pesos = new int[]{35, 20, 20, 15, 10};
                break;

            case 3: // Software reciente
                pesos = new int[]{15, 15, 20, 15, 35};
                break;
        }

        if (uso == 1) {
            pesos[0] += 5;
            pesos[4] -= 5;
        } else if (uso == 2 || uso == 3) {
            pesos[2] += 5;
            pesos[4] += 5;
            pesos[0] -= 5;
            pesos[3] -= 5;
        }

        return pesos;
    }

    public static double calcularPuntuacion(
            int[] valoraciones, int[] pesos) {

        double puntuacion = 0;

        for (int i = 0; i < valoraciones.length; i++) {
            puntuacion += valoraciones[i] * pesos[i];
        }

        // Cada criterio se valora de 1 a 5.
        // Se normaliza el resultado a una escala de 0 a 100.
        return puntuacion / 5.0;
    }

    public static void ordenarRanking(
            int[] ranking, double[] puntuaciones) {

        for (int i = 0; i < ranking.length - 1; i++) {
            for (int j = 0; j < ranking.length - 1 - i; j++) {

                if (puntuaciones[ranking[j]]
                        < puntuaciones[ranking[j + 1]]) {

                    int temporal = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = temporal;
                }
            }
        }
    }

    public static void mostrarRanking(
            int[] ranking, double[] puntuaciones) {

        System.out.println("\n" + VERDE
                + "========== RANKING =========="
                + RESET);

        for (int i = 0; i < ranking.length; i++) {
            int indice = ranking[i];

            System.out.printf("%d. %-22s %.1f/100%n",
                    i + 1,
                    DISTROS[indice],
                    puntuaciones[indice]);
        }

        if (puntuaciones[ranking[0]]
                == puntuaciones[ranking[1]]) {

            System.out.println(AMARILLO
                    + "Hay un empate en la primera posicion."
                    + RESET);
        } else {
            System.out.println("\nRecomendacion principal: "
                    + DISTROS[ranking[0]]);
        }
    }

    public static void mostrarDetalle(
            int distro, int[][] valoraciones, int[] pesos) {

        System.out.println("\nCriterios de "
                + DISTROS[distro] + ":");

        for (int i = 0; i < CANTIDAD_CRITERIOS; i++) {
            System.out.printf("- %-22s %d/5 (peso %d%%)%n",
                    CRITERIOS[i],
                    valoraciones[distro][i],
                    pesos[i]);
        }
    }

    public static void mostrarPlan(
            int usuarios, int equiposPorFase) {

        int fases = (usuarios + equiposPorFase - 1)
                / equiposPorFase;

        System.out.println("\n========== PLAN DE DESPLIEGUE ==========");
        System.out.println("Usuarios: " + usuarios);
        System.out.println("Equipos por fase: " + equiposPorFase);
        System.out.println("Fases necesarias: " + fases);

        for (int i = 1; i <= fases; i++) {
            int equiposFase = Math.min(
                    equiposPorFase,
                    usuarios - (i - 1) * equiposPorFase);

            System.out.println("Fase " + i + ": "
                    + equiposFase + " equipos.");
        }
    }

    public static void mostrarRecomendaciones(
            int ram,
            boolean hardwareAntiguo,
            boolean principiantes,
            boolean administracionCentralizada,
            int presupuesto,
            int prioridad) {

        System.out.println("\n========== RECOMENDACIONES ==========");

        if (ram <= 4 || hardwareAntiguo) {
            System.out.println(
                    "- Ejecutar pruebas de rendimiento "
                            + "en los equipos mas limitados.");
        }

        if (principiantes) {
            System.out.println(
                    "- Preparar capacitacion y documentacion "
                            + "para los usuarios.");
        }

        if (administracionCentralizada) {
            System.out.println(
                    "- Probar gestion de actualizaciones, "
                            + "inventario, identidades y politicas.");
        }

        if (presupuesto == 0) {
            System.out.println(
                    "- Estimar el costo de mantenimiento "
                            + "y del personal de soporte.");
        }

        if (prioridad == 1) {
            System.out.println(
                    "- Verificar los ciclos de soporte "
                            + "y las actualizaciones de seguridad.");
        }

        System.out.println(
                "- Validar impresoras, aplicaciones y perifericos.");
        System.out.println(
                "- Probar copias de seguridad y recuperacion.");
        System.out.println(
                "- Ejecutar un piloto antes del despliegue completo.");
    }

    public static void main(String[] args) {

        mostrarTitulo();

        int usuarios = ingresarEnteroRango(
                "Numero de usuarios (1-10000): ", 1, 10000);

        int ram = ingresarEnteroRango(
                "RAM habitual por equipo en GB (1-128): ", 1, 128);

        boolean hardwareAntiguo = ingresarBoolean(
                "Hay equipos antiguos o lentos");

        boolean principiantes = ingresarBoolean(
                "La mayoria tiene poca experiencia con Linux");

        boolean administracionCentralizada = ingresarBoolean(
                "Se necesita administracion centralizada");

        int presupuesto = ingresarEnteroRango(
                "Presupuesto para soporte (0 = bajo, "
                        + "1 = medio, 2 = alto): ", 0, 2);

        System.out.println("\nTIPO DE TRABAJO");
        System.out.println("1. Ofimatica y navegacion");
        System.out.println("2. Programacion y desarrollo");
        System.out.println("3. Ciencia e ingenieria");

        int uso = ingresarEnteroRango(
                "Seleccione el uso principal: ", 1, 3);

        System.out.println("\nPRIORIDAD PRINCIPAL");
        System.out.println("1. Estabilidad y soporte");
        System.out.println("2. Facilidad de uso");
        System.out.println("3. Software reciente");

        int prioridad = ingresarEnteroRango(
                "Seleccione la prioridad: ", 1, 3);

        int equiposPorFase = ingresarEnteroRango(
                "Equipos por fase de despliegue: ", 1, usuarios);

        int[][] valoraciones = evaluarCriterios(
                ram,
                hardwareAntiguo,
                principiantes,
                administracionCentralizada,
                uso);

        int[] pesos = calcularPesos(uso, prioridad);

        double[] puntuaciones = new double[CANTIDAD_DISTROS];
        int[] ranking = new int[CANTIDAD_DISTROS];

        System.out.println("\nEvaluando alternativas...");

        for (int i = 0; i < CANTIDAD_DISTROS; i++) {
            puntuaciones[i] = calcularPuntuacion(
                    valoraciones[i], pesos);

            ranking[i] = i;
        }

        ordenarRanking(ranking, puntuaciones);
        mostrarRanking(ranking, puntuaciones);

        mostrarDetalle(ranking[0], valoraciones, pesos);

        mostrarPlan(usuarios, equiposPorFase);

        mostrarRecomendaciones(
                ram,
                hardwareAntiguo,
                principiantes,
                administracionCentralizada,
                presupuesto,
                prioridad);

        System.out.println("\n" + AMARILLO
                + "AVISO: puntuaciones heuristicas, no "
                + "resultados de pruebas reales. Verifique "
                + "hardware, soporte y requisitos antes "
                + "de elegir una distribucion."
                + RESET);

        scanner.close();
    }
}
