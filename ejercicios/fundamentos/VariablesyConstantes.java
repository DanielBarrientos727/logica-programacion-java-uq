
public class VariablesyConstantes {

    public static void main(String[] args) {

        /*
         * VARIABLES Y CONSTANTES EN JAVA
         *
         * Las variables almacenan datos que pueden cambiar durante
         * la ejecución del programa.
         *
         * Las constantes almacenan datos que no se pueden reasignar
         * después de su inicialización cuando se utiliza final.
         */

        System.out.print("Hola, bienvenido al Portal de Jorge, acá está su infomación");

        // String es un tipo de dato utilizado para representar cadenas de texto.
        // final impide reasignar un nuevo valor a la variable después de inicializarla.
        // NAME es una constante de tipo String y almacena el nombre del usuario.
        final String NAME = "Jorge";

        System.out.println("El user es " + NAME);

        // Constante que almacena la dirección de correo electrónico del usuario.
        // La concatenación con + permite combinar texto con el valor de una variable.
        final String EMAIL = "JorgeAlejandro462@outlook.com";

        System.out.println("El user tiene correo " + EMAIL);

        /*
         * INFERENCIA DE TIPOS CON VAR
         *
         * La palabra reservada var permite que Java infiera el tipo de dato
         * a partir del valor asignado durante la inicialización.
         *
         * No significa que Java deje de utilizar tipos de datos.
         * El tipo se determina al compilar y no cambia posteriormente.
         */

        // Java infiere que apellido es de tipo String porque se asigna texto.
        var apellido = "Alejandro";

        System.out.println("El user tiene como apellido " + apellido);

        // Java infiere que edad es de tipo int porque se asigna un número entero.
        var edad = 23;

        // La inferencia de tipos se realiza durante la compilación.
        System.out.println("El user tiene una edad de " + edad);

        /*
         * IMPORTANTE:
         *
         * No se puede escribir var int edad.
         * var ya permite inferir el tipo, por lo que no se combina
         * con la declaración explícita de otro tipo.
         *
         * Además, var debe inicializarse al declararse y solo puede
         * utilizarse en declaraciones de variables locales.
         */

    }
}
