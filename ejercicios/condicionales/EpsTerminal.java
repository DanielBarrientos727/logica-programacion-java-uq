import java.util.Scanner;
import java.util.Arrays;

public class EpsTerminal {
    static final String RESET = "\033[0m";
    static final String BOLD = "\033[1m";
    static final String CYAN = "\033[36m";
    static final String GREEN = "\033[32m";
    static final String YELLOW = "\033[33m";
    static final String RED = "\033[31m";
    static final String DIM = "\033[2m";

    static String[] nombres = {
            "Laura Martínez", "Andrés Gómez", "Camila Rodríguez", "Mateo Hernández", "Valentina López",
            "Samuel Ramírez", "Isabella Torres", "Santiago Flores", "Mariana Castro", "Nicolás Vargas",
            "Sofía Rojas", "Daniela Silva", "Sebastián Ortiz", "Gabriela Reyes", "Tomás Mendoza",
            "Lucía Herrera", "Emiliano Cruz", "Antonella Morales", "Julián Jiménez", "Renata Álvarez",
            "Thiago Romero", "Emma Navarro", "Benjamín Medina", "Victoria Aguilar", "Lucas Delgado",
            "Paula Vega", "David Paredes", "Julieta Campos", "Alejandro Fuentes", "Mía Cabrera",
            "Gabriel León", "Sara Peña", "Felipe Ríos", "Manuela Acosta", "Martín Molina",
            "Antonella Suárez", "Juan Esteban Gil", "Salomé Arias", "Diego Ospina", "Elena Restrepo",
            "Miguel Ángel Soto", "Ana María Quintero", "Cristian Mejía", "Paulina Cárdenas",
            "Esteban Valencia", "Ariana Benítez", "Kevin Salazar", "Danna Márquez", "Óscar Bustamante",
            "Lina Marcela Cardona"
    };

    static String[] servicios = {
            "Medicina general", "Odontología", "Pediatría", "Medicina general", "Enfermería",
            "Laboratorio", "Medicina general", "Odontología", "Psicología", "Medicina general",
            "Pediatría", "Laboratorio", "Medicina general", "Enfermería", "Odontología",
            "Medicina general", "Pediatría", "Laboratorio", "Medicina general", "Psicología",
            "Medicina general", "Odontología", "Enfermería", "Medicina general", "Laboratorio",
            "Pediatría", "Medicina general", "Odontología", "Medicina general", "Psicología",
            "Laboratorio", "Medicina general", "Pediatría", "Enfermería", "Medicina general",
            "Odontología", "Laboratorio", "Medicina general", "Pediatría", "Psicología",
            "Medicina general", "Odontología", "Laboratorio", "Medicina general", "Enfermería",
            "Pediatría", "Medicina general", "Odontología", "Laboratorio", "Medicina general"
    };

    static String[] horas = {
            "08:00","08:05","08:10","08:15","08:20","08:25","08:30","08:35","08:40","08:45",
            "08:50","08:55","09:00","09:05","09:10","09:15","09:20","09:25","09:30","09:35",
            "09:40","09:45","09:50","09:55","10:00","10:05","10:10","10:15","10:20","10:25",
            "10:30","10:35","10:40","10:45","10:50","10:55","11:00","11:05","11:10","11:15",
            "11:20","11:25","11:30","11:35","11:40","11:45","11:50","11:55","12:00","12:05"
    };

    static String[] estados = new String[50];

    static void limpiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa(Scanner sc) {
        System.out.print("\n" + DIM + "Presiona ENTER para continuar..." + RESET);
        sc.nextLine();
    }

    static void encabezado() {
        System.out.println(CYAN + BOLD);
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║             S A L U D   V I T A L  |  EPS TERMINAL                  ║");
        System.out.println("║                    Gestión diaria de pacientes                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(DIM + "  JORNADA SIMULADA · 20/10/2026 · DATOS FICTICIOS · SOLO DEMOSTRACIÓN" + RESET);
        System.out.println();
    }

    static void mostrarPacientes() {
        System.out.println(BOLD + String.format("%-4s %-25s %-20s %-8s %-12s", "N.º", "PACIENTE", "SERVICIO", "HORA", "ESTADO") + RESET);
        System.out.println(DIM + "─".repeat(74) + RESET);
        for (int i = 0; i < nombres.length; i++) {
            String color = estados[i].equals("Atendido") ? GREEN :
                    estados[i].equals("En espera") ? YELLOW : RED;
            System.out.printf("%-4d %-25s %-20s %-8s %s%-12s%s%n",
                    i + 1, nombres[i], servicios[i], horas[i], color, estados[i], RESET);
        }
    }

    static void resumen() {
        int atendidos = 0, espera = 0, cancelados = 0;
        int[] porServicio = new int[6];
        String[] tipos = {"Medicina general", "Odontología", "Pediatría", "Enfermería", "Laboratorio", "Psicología"};
        for (int i = 0; i < estados.length; i++) {
            if (estados[i].equals("Atendido")) atendidos++;
            else if (estados[i].equals("En espera")) espera++;
            else cancelados++;
            for (int j = 0; j < tipos.length; j++) {
                if (servicios[i].equals(tipos[j])) porServicio[j]++;
            }
        }
        System.out.println(CYAN + BOLD + "\n┌────────────── RESUMEN DE LA JORNADA ──────────────┐" + RESET);
        System.out.printf("  Pacientes registrados : %d%n", nombres.length);
        System.out.printf("  Atendidos             : %s%d%s%n", GREEN, atendidos, RESET);
        System.out.printf("  En espera             : %s%d%s%n", YELLOW, espera, RESET);
        System.out.printf("  Cancelados            : %s%d%s%n", RED, cancelados, RESET);
        System.out.println("\n  " + BOLD + "Demanda por servicio" + RESET);
        for (int i = 0; i < tipos.length; i++) {
            System.out.printf("  %-20s %2d%n", tipos[i], porServicio[i]);
        }
        System.out.println(CYAN + BOLD + "└───────────────────────────────────────────────────┘" + RESET);
    }

    static void buscar(Scanner sc) {
        System.out.print("Nombre o parte del nombre: ");
        String consulta = sc.nextLine().trim().toLowerCase();
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].toLowerCase().contains(consulta)) {
                System.out.printf("%nN.º %d | %s | %s | %s | %s%n",
                        i + 1, nombres[i], servicios[i], horas[i], estados[i]);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println(YELLOW + "No se encontraron coincidencias." + RESET);
    }

    static void cambiarEstado(Scanner sc) {
        mostrarPacientes();
        System.out.print("\nNúmero de paciente (1-50): ");
        int numero;
        try {
            numero = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(RED + "Ingresa un número válido." + RESET);
            return;
        }
        if (numero < 1 || numero > nombres.length) {
            System.out.println(RED + "El número debe estar entre 1 y 50." + RESET);
            return;
        }
        System.out.println("Nuevo estado: 1) Atendido  2) En espera  3) Cancelado");
        System.out.print("Opción: ");
        String opcion = sc.nextLine().trim();
        switch (opcion) {
            case "1" -> estados[numero - 1] = "Atendido";
            case "2" -> estados[numero - 1] = "En espera";
            case "3" -> estados[numero - 1] = "Cancelado";
            default -> {
                System.out.println(RED + "Opción no válida; no se realizaron cambios." + RESET);
                return;
            }
        }
        System.out.println(GREEN + "Estado actualizado correctamente." + RESET);
    }

    public static void main(String[] args) {
        Arrays.fill(estados, "Atendido");
        for (int i = 3; i < estados.length; i += 4) estados[i] = "En espera";

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                limpiar();
                encabezado();
                System.out.println("  " + GREEN + "01" + RESET + "  Ver los 50 pacientes");
                System.out.println("  " + GREEN + "02" + RESET + "  Buscar paciente");
                System.out.println("  " + GREEN + "03" + RESET + "  Actualizar estado de atención");
                System.out.println("  " + GREEN + "04" + RESET + "  Resumen de la jornada");
                System.out.println("  " + RED + "00" + RESET + "  Salir");
                System.out.print("\n  Selecciona una opción > ");
                String opcion = sc.nextLine().trim();

                limpiar();
                encabezado();
                switch (opcion) {
                    case "1", "01" -> mostrarPacientes();
                    case "2", "02" -> buscar(sc);
                    case "3", "03" -> cambiarEstado(sc);
                    case "4", "04" -> resumen();
                    case "0", "00" -> {
                        System.out.println(GREEN + "\n  Jornada cerrada. Gracias por usar Salud Vital." + RESET);
                        return;
                    }
                    default -> System.out.println(RED + "Opción no válida. Intenta de nuevo." + RESET);
                }
                pausa(sc);
            }
        }
    }
}

