/**
 * Taller 2: práctica de funciones y reutilización de métodos.
 */
public class Taller2ProgramasFunciones {
    public static void main(String[] args) {
        sumarDosEnteros();
        calcularNotaQuimica();
        calcularLiquidacionContrato();
    }

    private static void sumarDosEnteros() {
        System.out.println("\n--- Suma de dos enteros ---");
        int numero1 = Reutilizacion.ingresarEntero("Ingrese el primer número entero: ");
        int numero2 = Reutilizacion.ingresarEntero("Ingrese el segundo número entero: ");

        System.out.println("La suma es: " + (numero1 + numero2));
    }

    private static void calcularNotaQuimica() {
        System.out.println("\n--- Nota definitiva de Química ---");
        double nota1 = Reutilizacion.ingresarRealD("Ingrese la nota del parcial 1: ");
        double nota2 = Reutilizacion.ingresarRealD("Ingrese la nota del parcial 2: ");
        double nota3 = Reutilizacion.ingresarRealD("Ingrese la nota del parcial 3: ");
        double nota4 = Reutilizacion.ingresarRealD("Ingrese la nota del parcial 4: ");
        double nota5 = Reutilizacion.ingresarRealD("Ingrese la nota del parcial 5: ");

        // Se supone que los cinco parciales tienen el mismo porcentaje.
        double definitiva = (nota1 + nota2 + nota3 + nota4 + nota5) / 5.0;
        System.out.printf("La nota definitiva es: %.2f%n", definitiva);
    }

    private static void calcularLiquidacionContrato() {
        System.out.println("\n--- Estimación de liquidación ---");
        double salarioMensual = Reutilizacion.ingresarRealD("Ingrese el salario mensual: ");
        int diasLaborados = Reutilizacion.ingresarEntero("Ingrese los días laborados: ");

        if (salarioMensual < 0 || diasLaborados < 0) {
            System.out.println("El salario y los días laborados no pueden ser negativos.");
            return;
        }

        // Fórmulas simplificadas del ejercicio; pueden existir otros factores laborales.
        double prima = salarioMensual * diasLaborados / 360.0;
        double cesantias = salarioMensual * diasLaborados / 360.0;
        double interesesCesantias = cesantias * 0.12 * diasLaborados / 360.0;
        double vacaciones = salarioMensual * diasLaborados / 720.0;

        System.out.println("\n--- Resultados ---");
        System.out.printf("Prima: %.2f%n", prima);
        System.out.printf("Cesantías: %.2f%n", cesantias);
        System.out.printf("Intereses de cesantías: %.2f%n", interesesCesantias);
        System.out.printf("Vacaciones: %.2f%n", vacaciones);
        System.out.println("Nota: estimación académica con fórmulas simplificadas.");
    }
}
