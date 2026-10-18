import java.util.Scanner;

public class E1a {
    
    public static void main(String[] args) {
        // Pedimos la edad y la altura utilizando las funciones auxiliares
        int edad = ingresarEntero("¿Cuál es su edad? ");
        double altura = ingresarRealD("¿Cuál es su altura? ");

        // Calculamos si cumple con las restricciones de acceso
        String restriccion = calculoRestriccion(edad, altura);

        // Mostramos el resultado final en pantalla
        generarMensaje(restriccion);
    }

    // Función para ingresar un número entero por consola
    public static int ingresarEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextInt();
    }

    // Función para ingresar un número decimal por consola
    public static double ingresarRealD(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    // Función que evalúa si la persona puede ingresar a la atracción
    public static String calculoRestriccion(int edad, double altura) {
        String mensaje = "No puede ingresar a la atracción :(";

        // Condición estándar: 12 años o más y medir más de 1.40m, o ser mayor de 60 años
        if ((edad >= 12 && altura > 1.40) || edad > 60) {
            mensaje = "Bienvenido, puede ingresar a la atracción";
        }

        return mensaje;
    }

    // Función para imprimir el mensaje en pantalla
    public static void generarMensaje(String restriccion) {
        System.out.println(restriccion);
    }
}
