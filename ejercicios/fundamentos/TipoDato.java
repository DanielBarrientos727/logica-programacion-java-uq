
public class TipoDato {

    /*
     * TIPOS DE DATOS EN JAVA
     *
     * Por Daniel Barrientos.
     *
     * Java tiene 8 tipos de datos primitivos:
     * byte, short, int, long, float, double, char y boolean.
     *
     * String no es un tipo primitivo, sino una clase.
     */

    public static void main(String[] args) {

        // TIPOS DE DATOS PRIMITIVOS

        /*
         * INT:
         * Almacena números enteros, positivos, negativos o cero.
         * Su tamaño es de 32 bits.
         * Su rango va desde -2^31 hasta 2^31 - 1.
         */

        // Declaración e inicialización de una variable de tipo int.
        int myInt = 12;

        // Concatenamos un texto con el valor de la variable.
        // println muestra el resultado y termina la línea.
        System.out.println("El usuario tiene una edad de " + myInt);


        /*
         * DOUBLE:
         * Almacena números de punto flotante con doble precisión.
         * Ocupa 64 bits y permite representar valores decimales.
         */

        double myDouble = 12.33;

        System.out.println("El usuario tiene en banca " + myDouble);


        /*
         * CHAR:
         * Almacena un único carácter Unicode.
         * Se escribe entre comillas simples.
         */

        char myChar = 'A';

        System.out.println("El usuario tiene una calificacion de " + myChar);


        /*
         * BOOLEAN:
         * Representa un valor lógico.
         * Solo puede ser true (verdadero) o false (falso).
         */

        // Inicializamos la variable con el valor true.
        boolean myBoolean = true;

        // Reasignamos su valor a false.
        // Las variables pueden cambiar de valor si no son constantes.
        myBoolean = false;

        System.out.println("El usuario es Chileno " + myBoolean);


        /*
         * OTROS TIPOS PRIMITIVOS:
         *
         * byte: enteros de 8 bits.
         * short: enteros de 16 bits.
         * long: enteros de 64 bits.
         * float: números de punto flotante de 32 bits.
         *
         * Para declarar un long, se puede usar el sufijo L.
         * Para declarar un float, se utiliza el sufijo F.
         *
         * Ejemplos:
         * long poblacion = 8000000000L;
         * float precio = 12.5F;
         */


        /*
         * STRING:
         * No es un tipo primitivo, sino una clase de Java.
         * Permite representar cadenas de caracteres.
         * Los textos se escriben entre comillas dobles.
         */

        String myString = "Hola, java";

        // getClass() obtiene la clase del objeto en tiempo de ejecución.
        // getSimpleName() devuelve el nombre simple de esa clase.
        // En este caso, el resultado será "String".
        System.out.println(
                "El tipo de dato del usuario es "
                        + myString.getClass().getSimpleName()
        );

    }
}
