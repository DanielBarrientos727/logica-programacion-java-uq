public class AumentoAguaEPA {
    public static void main(String[] args) {
        double consumo = Reutilizacion.ingresarRealD("Ingrese el consumo mensual en metros cúbicos (m^3): ");
        double valorBase = Reutilizacion.ingresarRealD("Ingrese el valor base del servicio: ");
        
        double porcentajeAumento = 0.0;
        if ((consumo >= 1 && consumo <= 9) || (consumo >= 13 && consumo <= 15)) {
            porcentajeAumento = 0.15;
        } else if (consumo >= 20 && consumo <= 28) {
            porcentajeAumento = 0.25;
        }
        
        double nuevoValor = valorBase + (valorBase * porcentajeAumento);
        System.out.println("Porcentaje de aumento aplicado: " + (porcentajeAumento * 100) + "%");
        System.out.println("El nuevo valor a pagar es: " + nuevoValor);
    }
}