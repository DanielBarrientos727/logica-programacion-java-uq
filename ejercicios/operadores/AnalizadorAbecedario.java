
public class AnalizadorAbecedario {
    public static void main(String[] args) {

        // 1. Declaración de las vocales del abecedario.

        char a = 'A';
        char e = 'E';
        char i = 'I';
        char o = 'O';
        char u = 'U';

        System.out.println("=== ANALIZADOR DEL ABECEDARIO ===");
        System.out.println("Vocales: " + a + ", " + e + ", " + i + ", " + o + ", " + u);


        // 2. Comparación de caracteres mediante operadores relacionales.

        System.out.println("\n=== COMPARACIÓN DE VOCALES ===");

        System.out.println("¿A es igual a E? " + (a == e));
        System.out.println("¿A es diferente de E? " + (a != e));
        System.out.println("¿I es igual a I? " + (i == i));


        // 3. Declaración de las posiciones alfabéticas de las vocales.

        int posA = 1;
        int posE = 5;
        int posI = 9;
        int posO = 15;
        int posU = 21;


        // 4. Suma de las posiciones alfabéticas.

        int suma = posA + posE + posI + posO + posU;

        System.out.println("\n=== OPERACIONES ARITMÉTICAS ===");
        System.out.println("Suma de las posiciones: " + suma);


        // 5. Uso de los operadores de asignación compuesta.

        int acumulador = suma;

        acumulador += posA;  // Suma la posición de A.
        System.out.println("Después de += : " + acumulador);

        acumulador -= posE;  // Resta la posición de E.
        System.out.println("Después de -= : " + acumulador);

        acumulador *= 2;  // Multiplica el acumulador por 2.
        System.out.println("Después de *= : " + acumulador);

        acumulador /= 2;  // Divide el acumulador entre 2.
        System.out.println("Después de /= : " + acumulador);

        acumulador %= 7;  // Guarda el resto de dividir entre 7.
        System.out.println("Después de %= : " + acumulador);


        // 6. Comparación de la suma con un rango numérico.

        System.out.println("\n=== COMPROBACIÓN DE RANGO ===");

        boolean mayorQue50 = suma > 50;
        boolean menorQue100 = suma < 100;

        System.out.println("¿La suma es mayor que 50? " + mayorQue50);
        System.out.println("¿La suma es menor que 100? " + menorQue100);

        System.out.println(
                "¿La suma está entre 50 y 100? "
                        + (mayorQue50 && menorQue100)
        );


        // 7. Combinación de operadores lógicos AND, OR y NOT.

        System.out.println("\n=== OPERADORES LÓGICOS ===");

        boolean primeraCondicion = posA < posE;
        boolean segundaCondicion = posI < posO;
        boolean terceraCondicion = posU == 21;

        System.out.println(
                "A está antes de E e I está antes de O: "
                        + (primeraCondicion && segundaCondicion)
        );

        System.out.println(
                "A está después de E o U ocupa la posición 21: "
                        + (posA > posE || terceraCondicion)
        );

        System.out.println(
                "¿A no ocupa la posición 1? "
                        + !(posA == 1)
        );


        // 8. Incremento y decremento de una posición alfabética.

        System.out.println("\n=== OPERADORES UNARIOS ===");

        int posicion = posA;

        System.out.println("Posición inicial: " + posicion);
        System.out.println("Preincremento: " + (++posicion));
        System.out.println("Postincremento: " + (posicion++));
        System.out.println("Valor después del postincremento: " + posicion);
        System.out.println("Predecremento: " + (--posicion));
        System.out.println("Postdecremento: " + (posicion--));
        System.out.println("Valor final: " + posicion);


        // 9. Expresión final con operadores aritméticos,
        // relacionales y lógicos.

        System.out.println("\n=== EVALUACIÓN FINAL ===");

        boolean resultadoFinal =
                ((posA + posE + posI) > 10)
                        && ((posO - posA) == 14)
                        || !((posU / posE) < 4);

        System.out.println("Resultado de la expresión: " + resultadoFinal);


        // 10. Resumen final del análisis.

        System.out.println("\n=== RESUMEN ===");
        System.out.println("Total de vocales analizadas: 5");
        System.out.println("Suma de sus posiciones: " + suma);
        System.out.println("Acumulador final: " + acumulador);
        System.out.println("Análisis completado.");
    }
}
