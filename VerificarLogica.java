
public class VerificarLogica {

    public static void main(String[] args) {

        System.out.println("TALLER 2 - OPERADORES LOGICOS\n");

        System.out.println("a) " +
                ((10 % 3 == 1 && 7 * 2 > 12) ||
                        (15 / 3 == 4 || 20 - 5 < 10)));

        System.out.println("b) " +
                ((8 + 2 * 3 <= 15 && Math.pow(2, 3) == 8) ||
                        (18 % 4 != 2 && 25 / 5 >= 5)));

        System.out.println("c) " +
                (((12 - 2) / 2 == 5 && 30 % 7 < 5) ||
                        (9 * 3 > 20 && 100 / 25 == 4)));

        System.out.println("d) " +
                ((50 / 5 == 10 && Math.pow(4, 2) <= 20) ||
                        (6 * 3 == 18 && 7 + 8 != 14)));

        System.out.println("e) " +
                (((15 - 5) * 2 > 25 && 9 % 2 == 1) ||
                        (40 / 8 <= 5 && Math.pow(5, 2) > 20)));

        System.out.println("f) " +
                (((5 + 3) * 2 < 4 * 3) &&
                        !(10 % 3 == 1)));

        System.out.println("g) " +
                (((15 / 4 + 3) > 5 * 2) ||
                        ((8 % 2 == 0) && (9 - 4 <= 6))));

        System.out.println("h) " +
                (((7 * 2 >= 14) && (12 % 5 != 2)) ||
                        !(6 + 3 < 10)));

        System.out.println("i) " +
                (((10 - 3) * 2 == 14) ||
                        ((9 / 2 < 5) && (8 % 4 != 0))));

        System.out.println("j) " +
                (((8 + 2 * 3 <= 15) && (16 % 3 == 1)) ||
                        !(7 - 5 > 1)));

        System.out.println("k) " +
                (((18 / 3 + 2 * 4) >= 14 && 25 % 4 != 1) ||
                        !(7 * 2 - 5 < 10)));

        System.out.println("l) " +
                (((12 + 8 / 2) == 16 && 30 % 7 <= 3) ||
                        ((5 * 3 > 10) && !(9 - 6 == 4))));

        System.out.println("m) " +
                (!((20 - 5 * 2) < 15) &&
                        ((14 % 5 == 4) || (6 * 3 / 2 >= 9))));
    }
}
