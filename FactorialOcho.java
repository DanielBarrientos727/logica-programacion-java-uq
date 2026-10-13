public class FactorialOcho {
    public static void main(String[] args) {
        long factorial = 1;
        for (int i = 1; i <= 8; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de 8 es: " + factorial);
    }
}