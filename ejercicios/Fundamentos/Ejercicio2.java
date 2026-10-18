import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        double litrosAgua = ingresarRealD("¿Cuántos litros de agua se gastaron en 24h?: ");
        int cantPersonas = ingresarEntero("¿Cuántas personas viven en el domicilio?: ");
        double promedio = calcularPromedio(litrosAgua, cantPersonas);
        String consumo = calcularConsumo(promedio);
        generarMensaje(promedio, consumo);
    }

    public static double ingresarRealD(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        double valor = sc.nextDouble();
        return valor;
    }

    public static int ingresarEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        int valor = sc.nextInt();
        return valor;
    }

    public static double calcularPromedio(double litrosAgua, int cantPersonas) {
        double promedio = litrosAgua / cantPersonas;
        return promedio;
    }

    public static String calcularConsumo(double consumo) {
        String entrada = "";
        if (consumo <= 100) {
            entrada = "presenta un consumo adecuado";
        }
        if (consumo > 100) {
            entrada = "presenta un consumo elevado";
        }
        return entrada;
    }

    public static void generarMensaje(double promedio, String consumo) {
        String mensaje = "Querida empresa, el promedio por persona al día de esta vivienda es de: " 
                + promedio + " litros y la vivienda: " + consumo;
        System.out.println(mensaje);
    }
}