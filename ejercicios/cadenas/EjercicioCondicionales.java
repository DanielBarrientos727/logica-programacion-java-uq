
import java.util.Locale;
import java.util.Scanner;

public class EjercicioCondicionales {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Establece la edad de un usuario y mostrar si puede votar o no

        var edad = 12;

        //Redudancias PA FUERA
        if (edad >= 18) {
            System.out.println("El ciudadano puede votar");
        } else {
            System.out.println("El ciudadano no puede votar");
        }

        // 2. Declara dos números y muestra si son iguales

        int a = 12;
        var b = 23;

        System.out.println("¿A es igual B? " + (a == b));

        // 3. Dado un número, verificar si es positivo, negativo o cero

        var numero = 12;

        if (numero > 0) {
            System.out.println("El número es positivo");
        } else if (numero < 0) {
            System.out.println("El número es negativo");
        } else {
            System.out.println("Es 0");
        }

        // 4. Crea un programa que diga si un número es par o impar

        System.out.print(
                "Por favor, señor usuario, ingrese un valor entero: "
        );

        var cantidad = scanner.nextInt();

        /*
         * Bueno, se va a evaluar si ese número es par o impar.
         */

        if (cantidad % 2 == 0) {
            System.out.println(
                    "El número " + cantidad + " es par, señor."
            );
        } else {
            System.out.println(
                    "El número " + cantidad + " es impar, señor."
            );
        }

        // Consumir el salto de línea pendiente de nextInt()
        scanner.nextLine();

        // 5. Simular una respuesta sobre si ella te ama

        System.out.println(
                "Digite 1 o 0 para ver si ella te ama:"
        );

        var amar = scanner.nextLine();

        if (amar.equals("0")) {
            System.out.println("Ella no te ama.");
        } else if (amar.equals("1")) {
            System.out.println("Ella te ama.");
        } else {
            System.out.println("Opción no válida.");
        }


        // 6. declara los dias de la semana y mostrarlo en Switch

        var dias = 6;

        switch (dias) {

            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println(
                        "Hermano, ni sabes cuantos días la semana tiene, oh dios, son 7"
                );

        }

        //Otro ejercicio para afinar

        System.out.println(
                "¿Que programa de nuestra facultad te gusta?:"
        );

        var error = "https://support.google.com/chrome/answer/95669?hl=es-419";

        var programa = scanner.nextLine();

        switch (programa) {
            case "1. Ingeniería de Sistemas":
                System.out.println("Ingeniería de Sistemas");
                break;

            case "2. Ingeniería en Electronica":
                System.out.println("Ingeniería en Electronica");
                break;

            case "3. Ingeniería Audiovisual":
                System.out.println("Ingeniería Audiovisual");
                break;

            case "4. Ingeniería Forestal":
                System.out.println("Ingeniería Forestal");
                break;

            case "5. Ingeniería en Gas":
                System.out.println("Ingeniería en Gas ");
                break;

            case "6. Ingeniería Física":
                System.out.println("Ingeniería Física");
                break;

            case "7. Ingeniería Eléctrica":
                System.out.println("Ingeniería Eléctrica");
                break;

            case "8. Tecnología en Sistemas":
                System.out.println("Tecnología en Sistemas");
                break;
            case "9. Tecnología en Análisis y Desarrollo de Software":
                System.out.println("Tecnología en Análisis y Desarrollo de Software");
                break;
            case "10. técnico en Computadoras":
                System.out.println("Técnico en Computadoras");
                break;
            default:
                System.out.println(
                        "Estimado usuario, el programa en cuestión no se encuentra en nuestro sitio, por favor visite: " + error
                );

                scanner.close(); // Cierra el Scanner
        }





        // 7.
        // 8.
        // 9.
        // 10.
    }
}
