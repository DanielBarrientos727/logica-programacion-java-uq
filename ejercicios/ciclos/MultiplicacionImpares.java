public class MultiplicacionImpares {
    public static void main(String[] args) {
        int i = 1;
        long producto = 1; // Usar long por crecimiento rápido
        while (i <= 15) {
            producto *= i;
            i += 2;
        }
        System.out.println("El producto de los impares del 1 al 15 es: " + producto);
    }
}