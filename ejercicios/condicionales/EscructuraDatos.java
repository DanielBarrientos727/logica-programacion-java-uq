public class EscructuraDatos {
    public static void main(String[] args) {

        // Los arreglos (arrays) permiten almacenar varios valores del mismo tipo.
        // Cada elemento ocupa una posición dentro del arreglo.

        // Declaración y creación de un arreglo de enteros con 3 posiciones.
        int[] numbers = new int[3]; // new crea el arreglo con 3 posiciones inicializadas en 0.
        System.out.println(numbers); // Imprime la referencia del arreglo, no sus elementos.

        // Declaración e inicialización de un arreglo de nombres.
        String[] names = {
                "Daniel", "Alejandro", "Olaya", "Carlos", "David", "Gaby", "Correa"
        };

        // Acceso a los arreglos.
        System.out.println(names); // Imprime la referencia del arreglo.
        System.out.println(names[2]); // Imprime "Olaya", el elemento de la posición 2.
        System.out.println(numbers[1]); // Imprime 0, el valor predeterminado de un int.

        // Creación de un arreglo de String y acceso a su primera posición.
        System.out.println((new String[3])[0]); // Imprime null, valor predeterminado de String.

        // Modificación de los elementos de un arreglo.
        numbers[0] = 2; // Asigna el valor 2 a la posición 0.
        numbers[1] = 4; // Asigna el valor 4 a la posición 1.

        System.out.println(numbers[0]); // Imprime 2.
        System.out.println(numbers[1]); // Imprime 4.
        System.out.println(numbers[2]); // Imprime 0, porque todavía no se ha modificado.

        numbers[2] = 6; // Asigna el valor 6 a la posición 2.
        System.out.println(numbers[2]); // Imprime 6.

        // numbers[3] -> Error: la posición 3 está fuera de los límites del arreglo.
        // Un arreglo de 3 elementos tiene las posiciones 0, 1 y 2.
        // Acceder a una posición inexistente provoca ArrayIndexOutOfBoundsException.

        // Modificación de un elemento del arreglo de nombres.
        System.out.println(names[2]); // Imprime el valor original: "Olaya".
        names[2] = "danielbarrientos@67gmail.com"; // Reemplaza el valor de la posición 2.
        System.out.println(names[2]); // Imprime el nuevo valor.

        System.out.println(names.length); // Imprime 7, la cantidad de elementos del arreglo.

        // Asignación de null a una posición de un arreglo de String.
        names[2] = null; // La posición sigue existiendo, pero ya no contiene una referencia a un objeto.
        System.out.println(names[2]); // Imprime null.
        System.out.println(names.length); // Imprime 7: la longitud del arreglo no cambia.

        // numbers[2] = null;
        // Error de compilación: int es un tipo primitivo y no admite el valor null.

        // Creación de un arreglo de booleanos con 2 posiciones.
        boolean[] booleans = new boolean[2];

        System.out.println(booleans[0]); // Imprime false, valor predeterminado de boolean.
        System.out.println(booleans[1]); // Imprime false.

        // System.out.println(booleans[4]);
        // Error en tiempo de ejecución: el arreglo solo tiene las posiciones 0 y 1.
    }
}