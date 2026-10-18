
import java.util.Scanner;

public class Buscador {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        //Esto es un mini buscador en Java

        String documento1 = "Java es un lenguaje de programacion";
        String documento2 = "Python se utiliza para inteligencia artificial";
        String documento3 = "La fisica estudia el universo";
        String documento4 = "Los drones utilizan sensores y motores";



        System.out.println("=== BUSCADOR BASICO ===");
        System.out.println("Documentos disponibles: Java, Python, Fisica y Drones");
        System.out.print("Que quieres buscar: ");

        String busqueda = entrada.nextLine().toLowerCase();


        //Resultados
        System.out.println("\n=== RESULTADOS ===");

        if (documento1.toLowerCase().contains(busqueda)) {
            System.out.println("Resultado: " + documento1);
        }

        if (documento2.toLowerCase().contains(busqueda)) {
            System.out.println("Resultado: " + documento2);
        }

        if (documento3.toLowerCase().contains(busqueda)) {
            System.out.println("Resultado: " + documento3);
        }

        if (documento4.toLowerCase().contains(busqueda)) {
            System.out.println("Resultado: " + documento4);
        }

        if (!documento1.toLowerCase().contains(busqueda)
                && !documento2.toLowerCase().contains(busqueda)
                && !documento3.toLowerCase().contains(busqueda)
                && !documento4.toLowerCase().contains(busqueda)) {

            System.out.println("No se encontraron resultados.");
        }

        entrada.close();
    }
}
