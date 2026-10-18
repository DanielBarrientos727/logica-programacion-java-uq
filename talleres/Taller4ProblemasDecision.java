/**
 * Taller 4, parte 2: problemas prácticos con decisiones simples y compuestas.
 */
public class Taller4ProblemasDecision {
    public static void main(String[] args) {
        ejercicioA();
        ejercicioB();
        ejercicioC();
        ejercicioD();
        ejercicioE();
        ejercicioF();
        ejercicioG();
    }

    private static void ejercicioA() {
        System.out.println("\n--- Ejercicio A: comparación de dos números ---");
        double numero1 = Reutilizacion.ingresarRealD("Número 1: ");
        double numero2 = Reutilizacion.ingresarRealD("Número 2: ");

        if (numero1 > numero2) {
            System.out.printf("Suma: %.2f%n", numero1 + numero2);
            System.out.printf("Diferencia (número 1 - número 2): %.2f%n", numero1 - numero2);
        } else {
            System.out.printf("Producto: %.2f%n", numero1 * numero2);
            if (numero2 == 0) {
                System.out.println("División n1 / n2: indefinida porque el segundo número es cero.");
            } else {
                System.out.printf("División (número 1 / número 2): %.2f%n", numero1 / numero2);
            }
        }
    }

    private static void ejercicioB() {
        System.out.println("\n--- Ejercicio B: bonificación salarial ---");
        double sueldo = Reutilizacion.ingresarRealD("Ingrese el sueldo del empleado: ");

        if (sueldo < 0) {
            System.out.println("El sueldo no puede ser negativo.");
            return;
        }

        if (sueldo < 1_500_000) {
            sueldo *= 1.15;
            System.out.printf("Aplica bonificación del 15%%. Nuevo sueldo: %.2f%n", sueldo);
        } else {
            System.out.printf("No aplica bonificación. Sueldo: %.2f%n", sueldo);
        }
    }

    private static void ejercicioC() {
        System.out.println("\n--- Ejercicio C: descuento en diciembre ---");
        String mes = Reutilizacion.ingresarTexto("Ingrese el mes: ");
        double compra = Reutilizacion.ingresarRealD("Ingrese el valor de la compra: ");

        if (compra < 0) {
            System.out.println("El valor de la compra no puede ser negativo.");
            return;
        }

        if (mes.equalsIgnoreCase("diciembre")) {
            compra *= 0.80;
            System.out.printf("Descuento del 20%% aplicado. Total a pagar: %.2f%n", compra);
        } else {
            System.out.printf("Total a pagar sin descuento: %.2f%n", compra);
        }
    }

    private static void ejercicioD() {
        System.out.println("\n--- Ejercicio D: descuento en factura de EDEQ ---");
        double factura = Reutilizacion.ingresarRealD("Ingrese el monto de la factura: ");

        if (factura < 0) {
            System.out.println("El valor de la factura no puede ser negativo.");
            return;
        }

        if (factura > 100_000) {
            factura *= 0.90;
            System.out.printf("Descuento del 10%% aplicado. Total final: %.2f%n", factura);
        } else {
            System.out.printf("No aplica descuento. Total final: %.2f%n", factura);
        }
    }

    private static void ejercicioE() {
        System.out.println("\n--- Ejercicio E: venta de terreno ---");
        double metrosCuadrados = Reutilizacion.ingresarRealD("Metros cuadrados del terreno: ");
        double valorMetroCuadrado = Reutilizacion.ingresarRealD("Valor por metro cuadrado: ");

        if (metrosCuadrados < 0 || valorMetroCuadrado < 0) {
            System.out.println("El área y el valor por metro cuadrado no pueden ser negativos.");
            return;
        }

        double valorTerreno = metrosCuadrados * valorMetroCuadrado;
        double comision = valorTerreno * 0.02;
        double precioVenta = valorTerreno + comision;

        System.out.printf("Valor del terreno: %.2f%n", valorTerreno);
        System.out.printf("Comisión del 2%%: %.2f%n", comision);
        System.out.printf("Precio de venta recomendado: %.2f%n", precioVenta);
    }

    private static void ejercicioF() {
        System.out.println("\n--- Ejercicio F: costo de hospitalización ---");
        int dias = Reutilizacion.ingresarEntero("Días de hospitalización: ");
        double valorDia = Reutilizacion.ingresarRealD("Valor por día: ");

        if (dias < 0 || valorDia < 0) {
            System.out.println("Los días y el valor por día no pueden ser negativos.");
            return;
        }

        double totalHospitalizacion = dias * valorDia;
        double descuento = totalHospitalizacion * 0.05;
        double totalConDescuento = totalHospitalizacion - descuento;

        System.out.printf("Total sin descuento: %.2f%n", totalHospitalizacion);
        System.out.printf("Descuento del 5%%: %.2f%n", descuento);
        System.out.printf("Total con descuento: %.2f%n", totalConDescuento);
    }

    private static void ejercicioG() {
        System.out.println("\n--- Ejercicio G: pasaje de ida y vuelta ---");
        double distanciaKm = Reutilizacion.ingresarRealD("Distancia del viaje en kilómetros: ");
        int diasEstancia = Reutilizacion.ingresarEntero("Número de días de estancia: ");

        if (distanciaKm < 0 || diasEstancia < 0) {
            System.out.println("La distancia y los días de estancia no pueden ser negativos.");
            return;
        }

        // Tarifa por kilómetro indicada en el enunciado original del ejercicio.
        double costoPasaje = distanciaKm * 89_500.0;

        if (distanciaKm > 1_000 && diasEstancia > 7) {
            costoPasaje *= 0.70;
            System.out.printf("Descuento del 30%% aplicado. Total del pasaje: %.2f%n", costoPasaje);
        } else {
            System.out.printf("Total del pasaje sin descuento: %.2f%n", costoPasaje);
        }
    }
}
