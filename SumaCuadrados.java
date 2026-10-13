public class SumaCuadrados {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i <= 15; i++) {
            suma += (i * i);
        }
        System.out.println("Suma de cuadrados del 1 al 15: " + suma);
    }
}