
import java.util.Scanner;
import java.util.Random;

public class NexusTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int opcionPrincipal = -1;
        int modulosVisitados = 0;
        int operacionesCalculadora = 0;
        int partidasJugadas = 0;
        int gastosRegistrados = 0;

        double totalGastos = 0.0;

        boolean sistemaActivo = true;

        System.out.println("======================================");
        System.out.println("          NEXUS TERMINAL v1.0         ");
        System.out.println("       CENTRO DE OPERACIONES          ");
        System.out.println("======================================");

        do {
            System.out.println();
            System.out.println("--------------- MENU ----------------");
            System.out.println("1. Calculadora basica");
            System.out.println("2. Juego: adivina el numero");
            System.out.println("3. Gestor de gastos");
            System.out.println("4. Diagnostico de computadores");
            System.out.println("5. Estadisticas del sistema");
            System.out.println("0. Apagar sistema");
            System.out.println("-------------------------------------");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcionPrincipal = scanner.nextInt();
                scanner.nextLine();

                switch (opcionPrincipal) {

                    case 1:
                        modulosVisitados++;

                        boolean calculadoraActiva = true;

                        do {
                            System.out.println();
                            System.out.println("===== CALCULADORA =====");
                            System.out.println("1. Sumar");
                            System.out.println("2. Restar");
                            System.out.println("3. Multiplicar");
                            System.out.println("4. Dividir");
                            System.out.println("5. Tabla de multiplicar");
                            System.out.println("0. Volver al menu principal");
                            System.out.print("Opcion: ");

                            if (scanner.hasNextInt()) {
                                int opcionCalculadora = scanner.nextInt();
                                scanner.nextLine();

                                if (opcionCalculadora >= 1
                                        && opcionCalculadora <= 4) {

                                    System.out.print(
                                            "Ingrese el primer numero: ");

                                    if (scanner.hasNextDouble()) {
                                        double numero1 = scanner.nextDouble();
                                        scanner.nextLine();

                                        System.out.print(
                                                "Ingrese el segundo numero: ");

                                        if (scanner.hasNextDouble()) {
                                            double numero2 =
                                                    scanner.nextDouble();
                                            scanner.nextLine();

                                            switch (opcionCalculadora) {

                                                case 1:
                                                    System.out.println(
                                                            "Resultado: "
                                                                    + (numero1 + numero2));

                                                    operacionesCalculadora++;
                                                    break;

                                                case 2:
                                                    System.out.println(
                                                            "Resultado: "
                                                                    + (numero1 - numero2));

                                                    operacionesCalculadora++;
                                                    break;

                                                case 3:
                                                    System.out.println(
                                                            "Resultado: "
                                                                    + (numero1 * numero2));

                                                    operacionesCalculadora++;
                                                    break;

                                                case 4:
                                                    if (numero2 != 0) {
                                                        System.out.println(
                                                                "Resultado: "
                                                                        + (numero1 / numero2));

                                                        operacionesCalculadora++;
                                                    } else {
                                                        System.out.println(
                                                                "Error: no se puede "
                                                                        + "dividir entre cero.");
                                                    }
                                                    break;
                                            }

                                        } else {
                                            System.out.println(
                                                    "Entrada invalida. "
                                                            + "Debe ingresar un numero.");
                                            scanner.nextLine();
                                        }

                                    } else {
                                        System.out.println(
                                                "Entrada invalida. "
                                                        + "Debe ingresar un numero.");
                                        scanner.nextLine();
                                    }

                                } else if (opcionCalculadora == 5) {

                                    System.out.print(
                                            "Ingrese un numero entero: ");

                                    if (scanner.hasNextInt()) {
                                        int numeroTabla = scanner.nextInt();
                                        scanner.nextLine();

                                        for (int i = 1; i <= 10; i++) {
                                            System.out.println(
                                                    numeroTabla + " x " + i
                                                            + " = " + (numeroTabla * i));
                                        }

                                        operacionesCalculadora++;

                                    } else {
                                        System.out.println(
                                                "Entrada invalida. "
                                                        + "Debe ingresar un entero.");
                                        scanner.nextLine();
                                    }

                                } else if (opcionCalculadora == 0) {
                                    calculadoraActiva = false;

                                    System.out.println(
                                            "Volviendo al menu principal...");

                                } else {
                                    System.out.println(
                                            "Opcion fuera de rango.");
                                }

                            } else {
                                System.out.println(
                                        "Entrada invalida. Escriba un numero.");
                                scanner.nextLine();
                            }

                        } while (calculadoraActiva);

                        break;

                    case 2:
                        modulosVisitados++;
                        partidasJugadas++;

                        int numeroSecreto = random.nextInt(100) + 1;
                        int intento;
                        int intentos = 0;
                        boolean adivinado = false;

                        System.out.println();
                        System.out.println("===== ADIVINA EL NUMERO =====");
                        System.out.println(
                                "Estoy pensando en un numero entre 1 y 100.");

                        while (!adivinado && intentos < 7) {
                            System.out.print(
                                    "Intento " + (intentos + 1) + " de 7: ");

                            if (scanner.hasNextInt()) {
                                intento = scanner.nextInt();
                                scanner.nextLine();

                                intentos++;

                                if (intento < 1 || intento > 100) {
                                    System.out.println(
                                            "El numero debe estar entre 1 y 100.");

                                } else if (intento < numeroSecreto) {
                                    System.out.println(
                                            "Demasiado bajo. Prueba con uno mayor.");

                                } else if (intento > numeroSecreto) {
                                    System.out.println(
                                            "Demasiado alto. Prueba con uno menor.");

                                } else {
                                    adivinado = true;

                                    System.out.println(
                                            "Correcto. Encontraste el numero en "
                                                    + intentos + " intento(s).");
                                }

                            } else {
                                System.out.println(
                                        "Entrada invalida. "
                                                + "Escribe un numero entero.");
                                scanner.nextLine();
                            }
                        }

                        if (!adivinado) {
                            System.out.println(
                                    "Se acabaron los intentos. El numero era "
                                            + numeroSecreto + ".");
                        }

                        break;

                    case 3:
                        modulosVisitados++;

                        boolean gestorActivo = true;

                        do {
                            System.out.println();
                            System.out.println("===== GESTOR DE GASTOS =====");
                            System.out.println("1. Registrar un gasto");
                            System.out.println("2. Consultar resumen");
                            System.out.println("0. Volver al menu principal");
                            System.out.print("Opcion: ");

                            if (scanner.hasNextInt()) {
                                int opcionGastos = scanner.nextInt();
                                scanner.nextLine();

                                switch (opcionGastos) {

                                    case 1:
                                        System.out.print(
                                                "Concepto del gasto: ");

                                        String concepto = scanner.nextLine();

                                        System.out.print(
                                                "Valor del gasto: ");

                                        if (scanner.hasNextDouble()) {
                                            double valorGasto =
                                                    scanner.nextDouble();
                                            scanner.nextLine();

                                            if (valorGasto > 0) {
                                                totalGastos += valorGasto;
                                                gastosRegistrados++;

                                                System.out.println(
                                                        "Gasto registrado: "
                                                                + concepto + " - $"
                                                                + valorGasto);

                                            } else {
                                                System.out.println(
                                                        "El gasto debe ser "
                                                                + "mayor que cero.");
                                            }

                                        } else {
                                            System.out.println(
                                                    "Entrada invalida. "
                                                            + "Escriba un valor numerico.");
                                            scanner.nextLine();
                                        }

                                        break;

                                    case 2:
                                        System.out.println(
                                                "Gastos registrados: "
                                                        + gastosRegistrados);

                                        System.out.println(
                                                "Total acumulado: $"
                                                        + totalGastos);
                                        break;

                                    case 0:
                                        gestorActivo = false;

                                        System.out.println(
                                                "Volviendo al menu principal...");
                                        break;

                                    default:
                                        System.out.println(
                                                "Opcion fuera de rango.");
                                        break;
                                }

                            } else {
                                System.out.println(
                                        "Entrada invalida. Escriba un numero.");
                                scanner.nextLine();
                            }

                        } while (gestorActivo);

                        break;

                    case 4:
                        modulosVisitados++;

                        boolean diagnosticoActivo = true;

                        do {
                            System.out.println();
                            System.out.println(
                                    "===== DIAGNOSTICO DE COMPUTADORES =====");

                            System.out.println(
                                    "1. El computador no enciende");

                            System.out.println(
                                    "2. Enciende, pero no da imagen");

                            System.out.println(
                                    "3. Se calienta demasiado");

                            System.out.println(
                                    "4. No tiene conexion a internet");

                            System.out.println(
                                    "0. Volver al menu principal");

                            System.out.print("Seleccione el sintoma: ");

                            if (scanner.hasNextInt()) {
                                int sintoma = scanner.nextInt();
                                scanner.nextLine();

                                switch (sintoma) {

                                    case 1:
                                        System.out.println(
                                                "Revise el cable de alimentacion, "
                                                        + "el tomacorriente y la fuente "
                                                        + "de poder.");

                                        System.out.println(
                                                "Desconecte el equipo antes de "
                                                        + "revisar conexiones internas.");
                                        break;

                                    case 2:
                                        System.out.println(
                                                "Verifique el monitor, el cable "
                                                        + "de video y la entrada seleccionada.");

                                        System.out.println(
                                                "Compruebe que el cable este "
                                                        + "conectado al puerto correcto.");
                                        break;

                                    case 3:
                                        System.out.println(
                                                "Compruebe que las rejillas de "
                                                        + "ventilacion no esten obstruidas.");

                                        System.out.println(
                                                "Apague el equipo si la temperatura "
                                                        + "es excesiva y solicite una "
                                                        + "revision tecnica.");
                                        break;

                                    case 4:
                                        System.out.println(
                                                "Compruebe si otros dispositivos "
                                                        + "tienen internet.");

                                        System.out.println(
                                                "Revise la conexion Wi-Fi o "
                                                        + "Ethernet y reinicie el router "
                                                        + "si es necesario.");
                                        break;

                                    case 0:
                                        diagnosticoActivo = false;

                                        System.out.println(
                                                "Volviendo al menu principal...");
                                        break;

                                    default:
                                        System.out.println(
                                                "Opcion fuera de rango.");
                                        break;
                                }

                            } else {
                                System.out.println(
                                        "Entrada invalida. Escriba un numero.");
                                scanner.nextLine();
                            }

                        } while (diagnosticoActivo);

                        break;

                    case 5:
                        modulosVisitados++;

                        System.out.println();
                        System.out.println(
                                "===== ESTADISTICAS DEL SISTEMA =====");

                        System.out.println(
                                "Visitas a modulos: " + modulosVisitados);

                        System.out.println(
                                "Operaciones de calculadora completadas: "
                                        + operacionesCalculadora);

                        System.out.println(
                                "Partidas iniciadas: " + partidasJugadas);

                        System.out.println(
                                "Gastos registrados: " + gastosRegistrados);

                        System.out.println(
                                "Total de gastos: $" + totalGastos);

                        break;

                    case 0:
                        sistemaActivo = false;

                        System.out.println(
                                "Cerrando NEXUS Terminal...");
                        break;

                    default:
                        System.out.println(
                                "Opcion fuera de rango. "
                                        + "Seleccione una opcion del menu.");
                        break;
                }

            } else {
                System.out.println(
                        "Entrada invalida. Escriba un numero.");
                scanner.nextLine();
            }

        } while (sistemaActivo);

        System.out.println();
        System.out.println("======================================");
        System.out.println("       NEXUS TERMINAL FINALIZADO     ");
        System.out.println("======================================");

        scanner.close();
    }
}
