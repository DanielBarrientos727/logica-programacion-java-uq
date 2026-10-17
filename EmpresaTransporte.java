import java.util.Scanner;

public class EmpresaTransporte {

    public static void main(String[] args) {

        int opcion = ingresarEntero("Seleccione el servicio:\n"
                + "1. Bus urbano\n"
                + "2. Bus intermunicipal\n"
                + "3. Servicio especial\n"
                + "4. Taxi compartido\n"
                + "Opción: ");

        if (opcion < 1 || opcion > 4) {
            System.out.println("La opción ingresada no es válida");
        } else {
            double kilometros = ingresarReal("Ingrese los kilómetros recorridos: ");

            double valorKm = 0;
            String servicio = "";

            switch (opcion) {
                case 1:
                    servicio = "Bus urbano";
                    valorKm = 1200;
                    break;
                case 2:
                    servicio = "Bus intermunicipal";
                    valorKm = 1800;
                    break;
                case 3:
                    servicio = "Servicio especial";
                    valorKm = 2500;
                    break;
                case 4:
                    servicio = "Taxi compartido";
                    valorKm = 3000;
                    break;
            }

            double total = calcularTotal(kilometros, valorKm);

            mostrarResultados(servicio, kilometros, valorKm, total);
        }
    }

    public static int ingresarEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public static double ingresarReal(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public static double calcularTotal(double kilometros, double valorKm) {
        return kilometros * valorKm;
    }

    public static void mostrarResultados(String servicio, double kilometros,
                                         double valorKm, double total) {
        System.out.println("\nTipo de servicio: " + servicio);
        System.out.println("Kilómetros recorridos: " + kilometros);
        System.out.println("Valor por kilómetro: $" + valorKm);
        System.out.println("Valor total a pagar: $" + total);
    }
}