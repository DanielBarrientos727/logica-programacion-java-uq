
public class EjercicioNovato {

    /*
     * EJERCICIOS BÁSICOS DE JAVA
     *
     * Por Daniel Barrientos.
     *
     * Objetivo:
     * Practicar variables, constantes, tipos de datos,
     * reasignación de valores, operaciones aritméticas
     * y consulta de tipos de objetos.
     */

    public static void main(String[] args) {

        /*
         * 1. VARIABLE DE TIPO STRING
         *
         * String permite almacenar cadenas de texto.
         * La variable name almacena el nombre del usuario.
         */

        String name = "Alejandro";

        System.out.println("¡Hola agente, mi nombre es " + name);


        /*
         * 2. VARIABLE DE TIPO INT
         *
         * int almacena números enteros.
         * En este caso, representa la edad del usuario.
         */

        int edad = 19;

        System.out.println("¡Hola agente, mi edad es " + edad);


        /*
         * 3. VARIABLE DE TIPO DOUBLE
         *
         * double almacena números de punto flotante
         * con doble precisión. Aquí representa la altura en metros.
         */

        double altura = 1.74;

        System.out.println("¡Hola agente, mi altura es " + altura);


        /*
         * 4. VARIABLE DE TIPO BOOLEAN
         *
         * boolean representa un valor lógico:
         * true significa verdadero y false significa falso.
         *
         * En este ejercicio, indica si al usuario le gusta Java.
         */

        boolean java = true;

        System.out.println(
                "¡Hola, mi respuesta de que sí me gusta Java es " + java
        );


        /*
         * 5. CONSTANTE DE TIPO STRING
         *
         * La palabra reservada final impide reasignar
         * otro valor a la variable después de inicializarla.
         *
         * Por convención, las constantes suelen escribirse
         * con letras mayúsculas y guiones bajos si es necesario.
         */

        final String MAIL = "danielsoto@gmail.com";

        System.out.println("¡Hola, mi email es " + MAIL);


        /*
         * 6. VARIABLE DE TIPO CHAR
         *
         * char almacena un único carácter.
         * Los caracteres se escriben entre comillas simples.
         *
         * Como inicial no cambia, también podría declararse final.
         */

        final char inicial = 'a';

        System.out.println("¡Hola, mi inicial es " + inicial);


        /*
         * 7. REASIGNACIÓN DE UNA VARIABLE
         *
         * Una variable puede recibir un nuevo valor
         * siempre que su declaración no utilice final.
         *
         * Primero se asigna Armenia y después se cambia a Cali.
         */

        String municipio = "Armenia";

        // Reasignamos la variable con un nuevo valor.
        municipio = "Cali";

        System.out.println("¡Hola, vivo en " + municipio);


        /*
         * 8. OPERACIONES ARITMÉTICAS
         *
         * Declaramos dos variables enteras y sumamos sus valores.
         * El operador + realiza la suma cuando se utiliza
         * con operandos numéricos.
         */

        int a = 15;
        int b = 20;

        // Guardamos el resultado de sumar a y b.
        int suma = a + b;

        System.out.println("La suma de a y b es " + suma);


        /*
         * 9. DECLARACIÓN Y REASIGNACIÓN
         *
         * Declaramos nota con un valor inicial de 0.
         * Después le asignamos el valor 5.
         *
         * Nota: en este ejemplo, la variable sí se inicializa
         * desde su declaración. No queda sin inicializar.
         */

        int nota = 0;

        // Actualizamos el valor de la variable.
        nota = 5;

        System.out.println("La nota es " + nota);


        /*
         * 10. CONSULTA DEL TIPO DE DATO
         *
         * Creamos tres variables de tipos diferentes.
         *
         * getClass() devuelve la clase del objeto en ejecución.
         * getSimpleName() devuelve el nombre simple de esa clase.
         *
         * Los tipos primitivos, como int y double, no tienen
         * métodos propios porque no son objetos.
         *
         * Por eso utilizamos Object para convertir sus valores
         * en objetos mediante autoboxing.
         */

        int myInteger = 10;
        String myString = "Hola";
        double myDouble = 3.14;

        // Integer es la clase envolvente de int.
        System.out.println(
                "El tipo es: "
                        + ((Object) myInteger).getClass().getSimpleName()
        );

        // String ya es un objeto, por lo que no necesita conversión.
        System.out.println(
                "El tipo es: " + myString.getClass().getSimpleName()
        );

        // Double es la clase envolvente de double.
        System.out.println(
                "El tipo es: "
                        + ((Object) myDouble).getClass().getSimpleName()
        );

    }
}
