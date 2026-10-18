import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        double edad = ingresarRealD("Por favor, ingrese su edad: ");
        double estatura = ingresarRealD("Ahora, ingrese su estatura: ");
        String entrada = calcularEntrada(edad, estatura);
        generarMensaje(entrada);
    }

    public static double ingresarRealD(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        double valor = sc.nextDouble();
        return valor;
    }

    public static String calcularEntrada(double edad, double estatura) {
        String entrada = "";
        if (edad >= 12 && estatura > 1.40) {
            entrada = "si puede pasar";
        } else {
            entrada = "no puede pasar";
        }

        if (edad >= 60) {
            entrada = "si puede pasar";
        }
        return entrada;
    }

    public static void generarMensaje(String entrada) {
        String mensaje = "Querido usuario usted " + entrada;
        System.out.println(mensaje);
    }
}