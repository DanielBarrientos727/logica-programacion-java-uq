
public class ExpresionesTaller4 {

    public static void main(String[] args) {

        boolean a =
                (Math.pow((3 + 5 * 2), 2) /
                        ((18 % 4) + Math.pow(2, 3)) * 2
                        + Math.pow((50 - 8 * 5), 2) /
                        Math.pow(4, 2)
                        > ((100 / 10) + Math.pow(2, 2)) * 3)
                        && !((25 % 3 + 12 / 4 * 2) <= (30 - 4 * 3))
                        || (40 / Math.pow(2, 3) + 15 % 4 == 5 * 3 / 2 + 8);

        boolean b =
                ((Math.pow((7 + 3 * 4), 2) - 100 / 5) * 3
                        + (200 % 11 + Math.pow(2, 4)) / (15 / 4 + 3)
                        > Math.pow((50 - Math.pow(6, 2)), 2) / 25)
                        && (30 * 2 + 10 <= 100 / 4 * 8 * Math.pow(3, 2));

        boolean c =
                (((Math.pow((6 + 4 * 3), 2) /
                        ((20 % 5 + Math.pow(2, 3)) * 2))
                        + Math.pow((40 - 5 * 6), 2) / Math.pow(3, 2))
                        > ((30 + Math.pow(2, 3)) * 2))
                        && !((18 % 5 + 9 / 3 * 2) <= (40 - 5 * 4)
                        || ((50 / Math.pow(2, 3) + 18) % 5 == 4 * 2 + 6));

        boolean d =
                (Math.pow((7 - 2 * 4), 2) / ((5 + 3) * 3)
                        > ((8 / 2) + Math.pow(6, 2)))
                        && !(((9 + 3 * 2) / (6 - 2) * 4) < (25 % 4));

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
    }
}
