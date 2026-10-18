/**
 * Taller 3: funciones y problemas de pensamiento computacional.
 */
public class Taller3PensamientoComputacional {
    public static void main(String[] args) {
        calcularDevuelta();
        calcularDescuentoTienda();
        convertirTemperatura();
        calcularConsumoCombustible();
        calcularCostoEnvio();
    }

    private static void calcularDevuelta() {
        System.out.println("\n--- Devuelta de una compra ---");
        double totalFactura = Reutilizacion.ingresarRealD("Total de la factura: ");
        double dineroEntregado = Reutilizacion.ingresarRealD("Dinero entregado por el cliente: ");

        if (totalFactura < 0 || dineroEntregado < 0) {
            System.out.println("Los valores no pueden ser negativos.");
        } else if (dineroEntregado >= totalFactura) {
            System.out.printf("Dinero a devolver: %.2f%n", dineroEntregado - totalFactura);
        } else {
            System.out.printf("Dinero faltante: %.2f%n", totalFactura - dineroEntregado);
        }
    }

    private static void calcularDescuentoTienda() {
        System.out.println("\n--- Descuento de una tienda ---");
        double valorProducto = Reutilizacion.ingresarRealD("Ingrese el valor del producto: ");
        double porcentajeDescuento = Reutilizacion.ingresarRealD(
                "Ingrese el porcentaje de descuento (por ejemplo, 15 para 15%): ");

        if (valorProducto < 0 || porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            System.out.println("Verifique el valor del producto y el porcentaje (de 0 a 100).");
            return;
        }

        double valorDescuento = valorProducto * porcentajeDescuento / 100.0;
        double valorFinal = valorProducto - valorDescuento;

        System.out.printf("Valor del descuento: %.2f%n", valorDescuento);
        System.out.printf("Valor final a pagar: %.2f%n", valorFinal);
    }

    private static void convertirTemperatura() {
        System.out.println("\n--- Conversión de temperatura ---");
        double celsius = Reutilizacion.ingresarRealD("Ingrese la temperatura en grados Celsius: ");
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;

        System.out.printf("%.2f °C equivalen a %.2f K y %.2f °F.%n",
                celsius, kelvin, fahrenheit);
    }

    private static void calcularConsumoCombustible() {
        System.out.println("\n--- Consumo de combustible ---");
        double kilometros = Reutilizacion.ingresarRealD("Ingrese los kilómetros recorridos: ");
        double litros = Reutilizacion.ingresarRealD("Ingrese los litros de gasolina consumidos: ");
        double precioLitro = Reutilizacion.ingresarRealD("Ingrese el precio por litro: ");

        if (kilometros < 0 || litros <= 0 || precioLitro < 0) {
            System.out.println("Los kilómetros y el precio no pueden ser negativos; los litros deben ser mayores que cero.");
            return;
        }

        double rendimiento = kilometros / litros;
        double costoTotal = litros * precioLitro;

        System.out.printf("Rendimiento: %.2f km/l%n", rendimiento);
        System.out.printf("Costo total del combustible: %.2f%n", costoTotal);
    }

    private static void calcularCostoEnvio() {
        System.out.println("\n--- Costo de envío ---");
        double pesoKg = Reutilizacion.ingresarRealD("Ingrese el peso del paquete en kg: ");
        double costoKg = Reutilizacion.ingresarRealD("Ingrese el costo por kilogramo: ");
        double costoFijo = Reutilizacion.ingresarRealD("Ingrese el costo fijo del servicio: ");

        if (pesoKg < 0 || costoKg < 0 || costoFijo < 0) {
            System.out.println("El peso y los costos no pueden ser negativos.");
            return;
        }

        double costoPorPeso = pesoKg * costoKg;
        double totalPagar = costoPorPeso + costoFijo;

        System.out.printf("Costo por peso: %.2f%n", costoPorPeso);
        System.out.printf("Valor total a pagar: %.2f%n", totalPagar);
    }
}
