public class SerieFraccionaria {
    public static void main(String[] args) {
        double sumaSerie = 0.0;
        for (int i = 1; i <= 10; i++) {
            sumaSerie += (1.0 / i);
            System.out.println("Término " + i + ": 1/" + i);
        }
        System.out.println("El valor total de la serie es: " + sumaSerie);
    }
}