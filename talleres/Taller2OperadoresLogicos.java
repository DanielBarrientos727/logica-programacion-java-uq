/**
 * Taller 2: evaluación de expresiones con operadores lógicos y relacionales.
 */
public class Taller2OperadoresLogicos {

    public static void main(String[] args) {

        boolean a = (10 % 3 == 1 && 7 * 2 > 12)
                || (15 / 3 == 4 || 20 - 5 < 10);

        boolean b = (8 + 2 * 3 <= 15 && Math.pow(2, 3) == 8)
                || (18 % 4 != 2 && 25 / 5 >= 5);

        boolean c = ((12 - 2) / 2 == 5 && 30 % 7 < 5)
                || (9 * 3 > 20 && 100 / 25 == 4);

        boolean d = (50 / 5 == 10 && Math.pow(4, 2) <= 20)
                || (6 * 3 == 18 && 7 + 8 == 14);

        boolean e = ((15 - 5) * 2 > 25 && 9 % 2 == 1)
                || (40 / 8 <= 5 && Math.pow(5, 2) > 20);

        boolean f = ((5 + 3) * 2 < 4 * 3)
                && !(10 % 3 == 1);

        boolean g = ((15 / 4.0 + 3) > 5 * 2)
                || ((8 % 2 == 0) && (9 - 4 <= 6));

        boolean h = ((7 * 2 >= 14) && (12 % 5 != 2))
                || !(6 + 3 < 10);

        boolean i = ((10 - 3) * 2 == 14)
                || ((9 / 25.0 > 0) && (8 % 4 != 0));

        boolean j = ((8 + 2 * 3 <= 15) && (16 % 3 == 1))
                || !(7 - 5 > 1);

        boolean k = ((18 / 3 + 2 * 4) >= 14 && (25 % 4 != 1))
                || !(7 * 2 - 5 < 10);

        boolean l = ((12 + 8 / 2) == 16 && (30 % 7 <= 3))
                || ((5 * 3 > 10) && !(9 - 6 == 4));

        boolean m = !((20 - 5 * 2) < 15)
                && ((14 % 5 == 4) || (6 * 3 / 2.0 >= 9));

        imprimirResultado("a", a);
        imprimirResultado("b", b);
        imprimirResultado("c", c);
        imprimirResultado("d", d);
        imprimirResultado("e", e);
        imprimirResultado("f", f);
        imprimirResultado("g", g);
        imprimirResultado("h", h);
        imprimirResultado("i", i);
        imprimirResultado("j", j);
        imprimirResultado("k", k);
        imprimirResultado("l", l);
        imprimirResultado("m", m);
    }

    /**
     * Imprime el nombre de la expresión y su resultado lógico.
     *
     * @param expresion nombre o identificador de la expresión
     * @param resultado resultado verdadero o falso
     */
    private static void imprimirResultado(String expresion, boolean resultado) {
        System.out.printf("Resultado %s: %b%n", expresion, resultado);
    }
}