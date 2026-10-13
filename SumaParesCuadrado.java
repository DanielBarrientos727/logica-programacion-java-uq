public class SumaParesCuadrado {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 2; i <= 20; i += 2) {
            suma += (i * i);
        }
        System.out.println("Suma de los pares al cuadrado (2 al 20): " + suma);
    }
}