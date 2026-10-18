
public class Cargando {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 12; i++) {

            System.out.print("\rCargando" + ".".repeat(i % 4));
            Thread.sleep(500);

        }

        System.out.println("\r¡Carga completada!     ");
    }
}
