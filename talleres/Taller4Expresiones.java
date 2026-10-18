/**
 * Taller 4, parte 1: expresiones algebraicas.
 */
public class Taller4Expresiones {
    public static void main(String[] args) {
        double a = 2.0;
        double b = 3.0;
        double c = 4.0;
        double h = 5.0;
        double m = 2.0;
        double x = 3.0;
        double y = 1.0;
        double u = 4.0;

        double expresion1 = (a + b) / c;
        double expresion2 = (3.0 + (h + 5.0) / m + (h - 1.0) / (46.0 - x)) / (h + y);
        double expresion3 = Math.pow(x, 5.0 / 6.0) + (y - u) / (u - 5.0);
        double expresion4 = Math.pow(
                Math.pow(x, 3.0) / (2.0 * a) - (8.0 * b) / (3.0 - h),
                1.0 / 5.0);
        double expresion5 = (Math.pow(x, 2.0) - 2.0 * x - 3.0)
                / ((x - 1.0) * (Math.pow(x, 2.0) + 2.0 * x + 2.0));

        imprimirResultado(1, expresion1);
        imprimirResultado(2, expresion2);
        imprimirResultado(3, expresion3);
        imprimirResultado(4, expresion4);
        imprimirResultado(5, expresion5);
    }

    private static void imprimirResultado(int numero, double resultado) {
        System.out.printf("Expresión %d: %.6f%n", numero, resultado);
    }
}
