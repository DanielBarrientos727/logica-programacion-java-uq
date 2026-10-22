/**
 * Talleres 5 y 6: selección de un servicio de transporte mediante switch.
 */
public class Taller5y6EmpresaTransporte {
    public static void main(String[] args) {
        System.out.println("=== MENÚ DE SERVICIOS DE TRANSPORTE ===");
        System.out.println("1. Bus urbano");
        System.out.println("2. Bus intermunicipal");
        System.out.println("3. Servicio especial");
        System.out.println("4. Taxi compartido");

        int opcion = notas.Reutilizacion.ingresarEntero("Seleccione una opción (1-4): ");
        if (opcion < 1 || opcion > 4) {
            System.out.println("La opción ingresada no es válida.");
            return;
        }

        double kilometros = notas.Reutilizacion.ingresarRealD("Ingrese los kilómetros recorridos: ");
        if (kilometros < 0) {
            System.out.println("Los kilómetros recorridos no pueden ser negativos.");
            return;
        }

        String tipoServicio;
        double valorPorKm;

        switch (opcion) {
            case 1:
                tipoServicio = "Bus urbano";
                valorPorKm = 1_200.0;
                break;
            case 2:
                tipoServicio = "Bus intermunicipal";
                valorPorKm = 1_800.0;
                break;
            case 3:
                tipoServicio = "Servicio especial";
                valorPorKm = 2_500.0;
                break;
            case 4:
                tipoServicio = "Taxi compartido";
                valorPorKm = 3_000.0;
                break;
            default:
                // La opción ya se validó antes del switch.
                return;
        }

        double valorTotal = kilometros * valorPorKm;

        System.out.println("\n--- FACTURA DEL SERVICIO ---");
        System.out.println("Tipo de servicio: " + tipoServicio);
        System.out.printf("Kilómetros recorridos: %.2f%n", kilometros);
        System.out.printf("Valor por kilómetro: $%.2f%n", valorPorKm);
        System.out.printf("Valor total a pagar: $%.2f%n", valorTotal);
    }
}
