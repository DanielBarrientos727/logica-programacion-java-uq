public class CuboNumeros {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            double cubo = Math.pow(i, 3);
            System.out.println("Cubo de " + i + " = " + cubo);
        }
    }
}