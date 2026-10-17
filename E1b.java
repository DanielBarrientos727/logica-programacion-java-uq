//Ejercicio 1b

// Inicio del programa

import java.util.Scanner;

// Aquí usamos Scanner para poder ingresar datos desde la terminal, ya sea la que trae el vscode o la que trae el compilador de Java o la que trae el sistema operativo. Yo uso Konsole, que es una terminal que trae KDE plasma

public class E1b {

    public static void main(String[] args) {

        // En la sección del main se coloca como primera para que lo ejecute Java, bueno, creo que la JDM.

        double valorCompra = ingresarRealD("¿Cuál el valor de la compra? ");

        // double porque el valor de la compra, puede ser con decimales: X o Y producto vale 20.000 pesos

        boolean clienteFrecuente = ingresarBoolean("¿Es un cliente frecuente? ");

        // boolean sirve es para poder guardar esto, dos opciones, verdadero o falso. 
        // En este caso, nos dice si el cliente es frecuente o no lo es.

        int edad = ingresarEntero("¿Cuál es la edad del cliente? ");

        // int porque la edad es un número entero, nadie puede tener 12.4 años ejemplo

        String valorFinal = calculoDescuento(valorCompra, clienteFrecuente, edad);

        // Acá se manda la información a calculoDescuento(), que decide si el cliente aplica o no al descuento, y el resultado se guarda en valorFinal.

        generarMensaje(valorFinal);

        // Finalmente, se manda el resultado a generarMensaje() para mostrarlo en pantalla del usuario. 

    }

    public static double ingresarRealD(String mensaje) {

        // Esta función recibe un mensaje y permite ingresar un número decimal, el mismo lo ingresa el usuario. 

        Scanner sc = new Scanner(System.in);

        System.out.print(mensaje);

        double valor = sc.nextDouble();

        // nextDouble() lee el número decimal que ingresa el usuario, nextDouble se parece a este nextInt

        return valor;

        // Retorna el valor ingresado por el usuario

    }

    public static int ingresarEntero(String mensaje) {

        // Esta función recibe va a recibir el mensaje y permite ingresar un número entero.  

        Scanner sc = new Scanner(System.in);

        System.out.print(mensaje);

        int valor = sc.nextInt();

        // nextInt() lee el número entero que ingresa el usuario en el Scaneer. 

        return valor;

    }

    public static boolean ingresarBoolean(String mensaje) {

        // Esta función nos sirve para ingresar un valor booleano, o sea verdadero o falso. 

        Scanner sc = new Scanner(System.in);

        System.out.print(mensaje);

        boolean valor = sc.nextBoolean();

        // nextBoolean() lee si el usuario ingresa true o false.

        return valor;

        // Retorna ese valor booleano en cuestión.

    }

    public static String calculoDescuento(double valorCompra, boolean clienteFrecuente, int edad) {

        // Esta función recibe tres datos: el valor de la compra, si es cliente frecuente y su edad.
        // Luego devuelve un String con el resultado final. 

        String mensaje = " ";

        // Alli colocamos un espacio en blanco

        if (valorCompra > 200000 && clienteFrecuente == true) {

            // Si la compra es mayor a 200000 y el cliente es frecuente, aplica al descuento.

            mensaje = "usted aplica para el descuento";

        } else {

            // Si no cumple con las dos condiciones, no aplica al descuento.

            mensaje = "usted NO aplica para el descuento";

        }

        if (edad > 65) {

            // Si tiene más de 65 años, también aplica al lo que es el descuento. 

            mensaje = "usted aplica para el descuento";

        }

        return mensaje;

        // Retorna el mensaje con el resultado final. 

    }

    public static void generarMensaje(String valorFinal) {

        // Recibe el resultado y lo muestra en pantalla para el usuario

        String mensaje = "Para la promoción " + valorFinal;

        // Acá usamos + para unir textos.
        // Se junta "Para la promoción " con el contenido de valorFinal.

        System.out.println(mensaje);

        // Muestra el mensaje final en la terminal.

    }

}

// Fin del programa