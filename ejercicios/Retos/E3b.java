import java.util.Scanner;

public class E3b {

    public static void main(String[] args) {
        // Solicitamos el consumo de combustible o rendimiento
        double consumo = ingresarRealD("¿Cuál es el consumo de combustible? ");

        // Determinamos la clasificación de eficiencia
        String clasificacion = calcularClasificacion(consumo);

        // Mostramos el resultado en pantalla
        generarMensaje(clasificacion);
    }

    public static double ingresarRealD(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    public static String calcularClasificacion(double consumo) {
        String mensaje = "";

        if (consumo >= 15) {
            mensaje = "Consumo eficiente";
        } else if (consumo >= 10) {
            mensaje = "Consumo moderado";
        } else {
            mensaje = "Consumo alto";
        }

        return mensaje;
    }

    public static void generarMensaje(String clasificacion) {
        System.out.println("Clasificación: " + clasificacion);
    }
}
