
import java.util.Scanner;

public class MisionSoyuz {

    public static void
    main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // ================================================
        // SOYUZ-01: MISION ORBITAL
        // Simulador de exploracion espacial por terminal
        // ================================================

        String nombreMision = "SOYUZ-01";
        String destino = "ESTACION ESPACIAL INTERNACIONAL";
        String estado = "PREPARACION";
        String comandante = "COMANDANTE";

        int opcion;
        int combustible = 100;
        int bateria = 100;
        int altitud = 0;
        int tripulacion = 3;

        double velocidad = 0.0;
        double distancia = 400.0;

        boolean sistemasCorrectos = false;
        boolean enOrbita = false;
        boolean acoplamiento = false;
        boolean misionAbortada = false;
        boolean regresoSeguro = false;

        System.out.println("");
        System.out.println("======================================================");
        System.out.println("              PROGRAMA ESPACIAL SOYUZ");
        System.out.println("                  MISION SOYUZ-01");
        System.out.println("======================================================");
        System.out.println("");
        System.out.println("                 .       *       .");
        System.out.println("                     /\\");
        System.out.println("                    /  \\");
        System.out.println("                   /    \\");
        System.out.println("                  | SOYUZ |");
        System.out.println("                  |      |");
        System.out.println("                 /|______|\\");
        System.out.println("                /__________\\");
        System.out.println("");
        System.out.println("CENTRO DE CONTROL: ACTIVO");
        System.out.println("DESTINO: " + destino);
        System.out.println("TRIPULACION: " + tripulacion + " COSMONAUTAS");
        System.out.println("COMBUSTIBLE: " + combustible + "%");
        System.out.println("BATERIA: " + bateria + "%");
        System.out.println("");
        System.out.println("Comandante, esperamos sus instrucciones.");
        System.out.println("Todas las decisiones pertenecen a una simulacion.");
        System.out.println("");
        System.out.println("Pulsa ENTER para comenzar...");
        entrada.nextLine();

        // ================================================
        // FASE 1: PREPARACION
        // ================================================

        System.out.println("");
        System.out.println("======================================================");
        System.out.println("FASE 1: REVISION PREVIA AL LANZAMIENTO");
        System.out.println("======================================================");
        System.out.println("CONTROL: Verificacion de sistemas iniciada.");
        System.out.println("");
        System.out.println("1. Ejecutar revision completa.");
        System.out.println("2. Omitir algunas verificaciones.");
        System.out.println("3. Cancelar el lanzamiento.");
        System.out.print("Seleccion: ");

        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                sistemasCorrectos = true;
                bateria = bateria - 5;
                System.out.println("");
                System.out.println("CONTROL: Todos los sistemas verificados.");
                System.out.println("CONTROL: Comunicaciones operativas.");
                System.out.println("CONTROL: Soporte vital operativo.");
                System.out.println("CONTROL: Nave autorizada para lanzamiento.");
                break;

            case 2:
                bateria = bateria - 15;
                combustible = combustible - 5;
                System.out.println("");
                System.out.println("ADVERTENCIA: Revision incompleta.");
                System.out.println("La mision continuara con riesgos adicionales.");
                break;

            case 3:
                misionAbortada = true;
                System.out.println("LANZAMIENTO CANCELADO.");
                break;

            default:
                misionAbortada = true;
                System.out.println("ERROR: Orden desconocida.");
                System.out.println("La mision ha sido cancelada por seguridad.");
                break;
        }

        // ================================================
        // FASE 2: LANZAMIENTO
        // ================================================

        if (!misionAbortada) {

            System.out.println("");
            System.out.println("======================================================");
            System.out.println("FASE 2: LANZAMIENTO");
            System.out.println("======================================================");
            System.out.println("CONTROL: Tripulacion asegurada.");
            System.out.println("CONTROL: Motores preparados.");
            System.out.println("");
            System.out.println("1. Lanzamiento nominal.");
            System.out.println("2. Ascenso de alto consumo.");
            System.out.println("3. Abortar lanzamiento.");
            System.out.print("Seleccion: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    combustible = combustible - 30;
                    bateria = bateria - 10;
                    altitud = 200;
                    velocidad = 7.8;
                    enOrbita = true;

                    System.out.println("");
                    System.out.println("IGNICION CONFIRMADA.");
                    System.out.println("Separacion de etapas completada.");
                    System.out.println("Velocidad orbital alcanzada.");
                    System.out.println("CONTROL: Insercion orbital nominal.");
                    break;

                case 2:
                    combustible = combustible - 48;
                    bateria = bateria - 15;
                    altitud = 250;
                    velocidad = 8.0;
                    enOrbita = true;

                    System.out.println("");
                    System.out.println("ASCENSO DE ALTO CONSUMO.");
                    System.out.println("La nave alcanza una orbita de trabajo.");
                    System.out.println("ADVERTENCIA: Combustible reducido.");
                    break;

                case 3:
                    misionAbortada = true;
                    System.out.println("MOTORES DESACTIVADOS.");
                    System.out.println("LANZAMIENTO ABORTADO.");
                    break;

                default:
                    misionAbortada = true;
                    System.out.println("ERROR DE COMANDO.");
                    System.out.println("Mision abortada.");
                    break;
            }
        }

        // ================================================
        // FASE 3: NAVEGACION ORBITAL
        // ================================================

        if (!misionAbortada) {

            System.out.println("");
            System.out.println("======================================================");
            System.out.println("FASE 3: NAVEGACION ORBITAL");
            System.out.println("======================================================");
            System.out.println("ALTITUD: " + altitud + " km");
            System.out.println("VELOCIDAD: " + velocidad + " km/s");
            System.out.println("COMBUSTIBLE: " + combustible + "%");
            System.out.println("BATERIA: " + bateria + "%");
            System.out.println("");
            System.out.println("La estacion se encuentra a " + distancia + " km.");
            System.out.println("");
            System.out.println("1. Ajustar la orbita.");
            System.out.println("2. Ahorrar combustible.");
            System.out.println("3. Ejecutar una maniobra incorrecta.");
            System.out.print("Seleccion: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    combustible = combustible - 8;
                    bateria = bateria - 5;
                    distancia = 150.0;
                    altitud = 220;

                    System.out.println("");
                    System.out.println("Maniobra orbital completada.");
                    System.out.println("Trayectoria corregida.");
                    System.out.println("Distancia al destino: " + distancia + " km.");
                    break;

                case 2:
                    combustible = combustible - 3;
                    bateria = bateria - 10;
                    distancia = 280.0;

                    System.out.println("");
                    System.out.println("Consumo de combustible reducido.");
                    System.out.println("La nave conserva energia.");
                    System.out.println("ADVERTENCIA: Aproximacion incompleta.");
                    break;

                case 3:
                    combustible = combustible - 20;
                    bateria = bateria - 20;
                    altitud = 100;
                    velocidad = 6.0;
                    enOrbita = false;

                    System.out.println("");
                    System.out.println("ALERTA: Trayectoria inestable.");
                    System.out.println("La nave ha perdido su orbita de trabajo.");
                    break;

                default:
                    misionAbortada = true;
                    System.out.println("Orden no reconocida.");
                    break;
            }
        }

        // ================================================
        // FASE 4: APROXIMACION Y ACOPLAMIENTO
        // ================================================

        if (!misionAbortada) {

            System.out.println("");
            System.out.println("======================================================");
            System.out.println("FASE 4: APROXIMACION A LA ESTACION");
            System.out.println("======================================================");
            System.out.println("CONTROL: Iniciando protocolo de aproximacion.");
            System.out.println("DISTANCIA: " + distancia + " km");
            System.out.println("VELOCIDAD: " + velocidad + " km/s");
            System.out.println("COMBUSTIBLE: " + combustible + "%");
            System.out.println("BATERIA: " + bateria + "%");
            System.out.println("");
            System.out.println("1. Aproximacion controlada.");
            System.out.println("2. Aproximacion demasiado rapida.");
            System.out.println("3. Cancelar el acoplamiento.");
            System.out.print("Seleccion: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    if (enOrbita && combustible >= 15 && bateria >= 20) {
                        combustible = combustible - 10;
                        bateria = bateria - 10;
                        distancia = 0.0;
                        acoplamiento = true;

                        System.out.println("");
                        System.out.println("CONTACTO MECANICO CONFIRMADO.");
                        System.out.println("ACOPLAMIENTO COMPLETADO.");
                        System.out.println("La tripulacion puede iniciar su mision.");
                    } else {
                        System.out.println("");
                        System.out.println("ACOPLAMIENTO NO AUTORIZADO.");
                        System.out.println("Los parametros de la nave son insuficientes.");
                    }
                    break;

                case 2:
                    combustible = combustible - 15;
                    distancia = 25.0;
                    acoplamiento = false;

                    System.out.println("");
                    System.out.println("ADVERTENCIA: Aproximacion insegura.");
                    System.out.println("La nave no consigue acoplarse.");
                    System.out.println("Se necesita una nueva maniobra.");
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("Acoplamiento cancelado.");
                    System.out.println("La nave permanece sin acoplarse.");
                    break;

                default:
                    misionAbortada = true;
                    System.out.println("Error de navegacion.");
                    break;
            }
        }

        // ================================================
        // FASE 5: REGRESO A LA TIERRA
        // ================================================

        if (!misionAbortada) {

            System.out.println("");
            System.out.println("======================================================");
            System.out.println("FASE 5: REGRESO A LA TIERRA");
            System.out.println("======================================================");

            if (acoplamiento) {

                System.out.println("CONTROL: Objetivo orbital completado.");
                System.out.println("La tripulacion esta preparada para regresar.");
                System.out.println("");
                System.out.println("1. Iniciar regreso.");
                System.out.println("2. Permanecer en la estacion.");
                System.out.print("Seleccion: ");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        if (combustible >= 15 && bateria >= 15) {
                            combustible = combustible - 15;
                            bateria = bateria - 10;
                            altitud = 0;
                            velocidad = 0.0;
                            regresoSeguro = true;

                            System.out.println("");
                            System.out.println("Separacion de la estacion completada.");
                            System.out.println("Secuencia de regreso iniciada.");
                            System.out.println("Descenso completado.");
                            System.out.println("Aterrizaje confirmado.");
                        } else {
                            System.out.println("");
                            System.out.println("RECURSOS INSUFICIENTES PARA EL REGRESO.");
                            System.out.println("La mision queda pendiente.");
                        }
                        break;

                    case 2:
                        System.out.println("");
                        System.out.println("La tripulacion permanece en orbita.");
                        System.out.println("Mision orbital completada parcialmente.");
                        break;

                    default:
                        System.out.println("Orden desconocida.");
                        break;
                }

            } else {

                System.out.println("La nave no esta acoplada.");
                System.out.println("1. Intentar regresar.");
                System.out.println("2. Mantener la posicion.");
                System.out.print("Seleccion: ");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        if (combustible >= 20 && bateria >= 15) {
                            combustible = combustible - 20;
                            bateria = bateria - 15;
                            altitud = 0;
                            velocidad = 0.0;
                            regresoSeguro = true;

                            System.out.println("");
                            System.out.println("Regreso de emergencia iniciado.");
                            System.out.println("Aterrizaje de emergencia completado.");
                        } else {
                            System.out.println("");
                            System.out.println("Recursos insuficientes.");
                            System.out.println("No se puede confirmar el regreso.");
                        }
                        break;

                    case 2:
                        System.out.println("");
                        System.out.println("La nave permanece en su trayectoria.");
                        break;

                    default:
                        System.out.println("Orden desconocida.");
                        break;
                }
            }
        }

        // ================================================
        // INFORME FINAL DE MISION
        // ================================================

        System.out.println("");
        System.out.println("======================================================");
        System.out.println("                INFORME FINAL");
        System.out.println("======================================================");

        System.out.println("MISION: " + nombreMision);
        System.out.println("DESTINO: " + destino);
        System.out.println("TRIPULACION: " + tripulacion);
        System.out.println("ESTADO DE LOS SISTEMAS: "
                + (sistemasCorrectos ? "VERIFICADOS" : "REVISION INCOMPLETA"));

        System.out.println("");
        System.out.println("COMBUSTIBLE RESTANTE: " + combustible + "%");
        System.out.println("BATERIA RESTANTE: " + bateria + "%");
        System.out.println("ALTITUD FINAL: " + altitud + " km");
        System.out.println("VELOCIDAD FINAL: " + velocidad + " km/s");
        System.out.println("DISTANCIA AL DESTINO: " + distancia + " km");

        System.out.println("");

        if (misionAbortada) {
            estado = "ABORTADA";
        } else if (regresoSeguro && acoplamiento) {
            estado = "EXITOSA: ACOPLAMIENTO Y REGRESO";
        } else if (regresoSeguro) {
            estado = "REGRESO DE EMERGENCIA COMPLETADO";
        } else if (acoplamiento) {
            estado = "OBJETIVO ORBITAL COMPLETADO";
        } else if (enOrbita) {
            estado = "EN ORBITA: OBJETIVO INCOMPLETO";
        } else {
            estado = "MISION INCOMPLETA";
        }

        System.out.println("RESULTADO: " + estado);

        System.out.println("");
        System.out.println("======================================================");
        System.out.println("      FIN DE LA TRANSMISION - CENTRO DE CONTROL");
        System.out.println("======================================================");

        entrada.close();
    }
}
