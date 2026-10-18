//Ejercicio 2b

// Inicio del programa 

import java.util.Scanner;

// Usamos Scanner para poder ingresar datos desde la terminal.

public class E2b {

    static void main(String[] args) {

        // En el main se pide el dato que necesita el programa

        double peso = ingresarRealD("Por favor ingrese el peso de su mascotica: ");

        // double porque el peso puede tener decimales.

        String descuento = calculoDescuento(peso);

        // Se manda el peso a calculoDescuento(), que realiza las operaciones.
        // El resultado se guarda en descuento.

        generarMensaje(descuento);

        // Finalmente, se muestra el resultado en pantalla del usuario, en nuestro individual. 

    }

    public static double ingresarRealD(String mensaje) {

        // Esta función permite ingresar un número decimal, ejemplo 2.24

        Scanner sc = new Scanner(System.in);

        System.out.print(mensaje);

        double valor = sc.nextDouble();

        // nextDouble() lee el número decimal que ingresa el usuario.

        return valor;

        // Retorna el valor ingresado.

    }

    public static String calculoDescuento(double peso) {

        // Esta función recibe el peso de la mascota y calcula cuánto debe pagar.

        String mensaje = " ";

        double descuento = 0.0;

        // Esta variable guarda el valor del descuento que se va a aplicar.

        double mascotapeso10 = peso * 35000;

        // Se calcula el precio multiplicando el peso por 35000.

        double mascotapesomayor = peso * 50000;

        // Acá se calcula el precio para las mascotas que pesan más de 10 kg.

        if (peso <= 10) {

            // Si la mascota pesa 10 kg o menos, se aplica un descuento del 10%.

            descuento = mascotapeso10 * 0.10;

            // Se calcula cuánto dinero corresponde al 10% de descuento.

            mascotapeso10 = mascotapeso10 - descuento;

            // Se resta el descuento al precio original para obtener el precio final.

            mensaje = "El valor total a pagar con descuento aplicado es: "
                    + mascotapeso10
                    + " y el descuento fue de: "
                    + descuento;

            // Se unen los textos y valores para formar el mensaje final.

        } else {

            // Si la mascota pesa más de 10 kg, no se aplica el descuento.

            mensaje = "Usted no aplica para el descuento, el valor a pagar es "
                    + mascotapesomayor;

        }

        return mensaje;

        // Retorna el mensaje con el resultado del cálculo.

    }

    public static void generarMensaje(String descuento) {

        // Recibe el resultado y lo muestra en pantalla.

        System.out.println(descuento);

    }

}

//Fin del programa 