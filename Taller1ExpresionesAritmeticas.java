/**
 * Taller 1: evaluación de expresiones aritméticas.
 */
public class Taller1ExpresionesAritmeticas {
    public static void main(String[] args) {
        double a = (4.0 * (36.0 / 6.0) + 5.0 % 3.0)
                / (2.0 * 3.0 - 15.0 / 3.0);

        double b = (7.0 * (30.0 / 5.0) + 4.0 % 3.0)
                / (5.0 * 2.0 - 18.0 / 6.0);

        double c = (8.0 * (50.0 / 10.0) + 6.0 % 4.0)
                / (4.0 * 3.0 - 20.0 / 4.0);

        double d = (3.0 * (48.0 / 8.0) + 7.0 % 4.0)
                / (6.0 * 2.0 - 16.0 / 4.0);

        double dd = (8.0 - 3.0 - 15.0 / 6.0)
                / (a + 1.0 / 8.0 - 1.0 / 6.0);

        double m = (3.0 - 5.0 - (9.0 - 48.0 + 69.0) / (1.0 + 98.0))
                / (1.0 - 89.0 + (2.0 - 11.0 - 9.0) / (28.0 - 15.0));

        imprimirResultado("a", a);
        imprimirResultado("b", b);
        imprimirResultado("c", c);
        imprimirResultado("d", d);
        imprimirResultado("dd", dd);
        imprimirResultado("m", m);
    }

    private static void imprimirResultado(String expresion, double resultado) {
        System.out.printf("Resultado %s: %.6f%n", expresion, resultado);
    }
}
