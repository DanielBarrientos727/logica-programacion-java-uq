import java.util.Scanner;

public class E2a {

    public static void main(String[] args) {
        // Solicitamos el consumo del hogar y la cantidad de personas
        double consumoHogar = ingresarRealD("¿Cuántos litros de agua consumen al día en el hogar? ");
        int personas = ingresarEntero("¿Cuántas personas viven en el hogar? ");

        // Calculamos el promedio por persona
        double promedio = calcularPromedio(consumoHogar, personas);

        // Clasificamos si el consumo es adecuado o excesivo
        String clasificacion = clasificarConsumo(promedio);

        // Mostramos el mensaje final
        generarMensaje(consumoHogar, promedio, clasificacion);
    }

    public static double ingresarRealD(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    public static int ingresarEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextInt();
    }

    // Calcula el consumo promedio diario por habitante
    public static double calcularPromedio(double consumoHogar, int personas) {
        return consumoHogar / personas;
    }

    // Clasifica el consumo según el promedio por persona
    public static String clasificarConsumo(double promedio) {
        String mensaje = " Su hogar se está excediendo con el consumo de agua";
        if (promedio <= 100) {
            mensaje = " Su hogar tiene el consumo de agua adecuado";
        }
        return mensaje;
    }

    public static void generarMensaje(double consumoHogar, double promedio, String clasificacion) {
        String mensajeF = "Los litros gastados al día fueron: " + consumoHogar
                + " | El promedio por persona es de: " + promedio + " L." + clasificacion;
        System.out.println(mensajeF);
    }
}
