public class Operadores {

    public static void main(String[] args) {

        /*
        ============================================================
                        1. OPERADORES ARITMÉTICOS
        ============================================================

        Permiten realizar operaciones matemáticas con valores
        numéricos: suma, resta, multiplicación, división y módulo.
        */

        var a = 3;
        var b = 5;

        System.out.println("Suma: " + (a + b)); // 8
        System.out.println("Resta: " + (a - b)); // -2
        System.out.println("Multiplicación: " + (a * b)); // 15

        // La división entre enteros descarta la parte decimal.
        System.out.println("División entera: " + (a / b)); // 0

        // Devuelve el residuo de la división.
        System.out.println("Módulo: " + (a % b)); // 3

        // Convertimos a double para obtener un resultado decimal.
        System.out.println("División decimal: " + ((double) a / b)); // 0.6


        /*
        ============================================================
                        2. OPERADORES DE ASIGNACIÓN
        ============================================================

        Permiten asignar valores y actualizar el contenido de
        una variable mediante operadores como =, +=, -=, *=,
        /= y %=.
        */

        a = 3;
        b = 5;

        // Asignación simple: reemplaza el valor de a.
        a = 5;
        System.out.println("a = 5: " + a); // 5

        // Asigna a a el valor de b.
        a = b;
        System.out.println("a = b: " + a); // 5

        // Asigna a a el resultado de b multiplicado por 2.
        a = b * 2;
        System.out.println("a = b * 2: " + a); // 10

        // Equivale a: a = a + 1
        a += 1;
        System.out.println("a += 1: " + a); // 11

        // Equivale a: a = a - 1
        a -= 1;
        System.out.println("a -= 1: " + a); // 10

        // Equivale a: a = a * 9
        a *= 9;
        System.out.println("a *= 9: " + a); // 90

        // Equivale a: a = a / 3
        a /= 3;
        System.out.println("a /= 3: " + a); // 30

        // Equivale a: a = a % 1
        a %= 1;
        System.out.println("a %= 1: " + a); // 0


        /*
        ============================================================
                    3. OPERADORES DE COMPARACIÓN
        ============================================================

        Comparan dos valores y devuelven un resultado booleano:
        true si se cumple la condición y false si no se cumple.

        ==  Igual a
        !=  Diferente de
        >   Mayor que
        >=  Mayor o igual que
        <   Menor que
        <=  Menor o igual que
        */

        a = 4;
        b = 3;

        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a == 6: " + (a == 6)); // false
        System.out.println("a != b: " + (a != b)); // true
        System.out.println("a > b: " + (a > b));   // true
        System.out.println("a >= b: " + (a >= b)); // true
        System.out.println("a < b: " + (a < b));   // false
        System.out.println("a <= b: " + (a <= b)); // false

        /*
        ============================================================
                        4. OPERADORES LÓGICOS
        ============================================================

        Permiten combinar o invertir expresiones booleanas.

        &&  AND  -> Verdadero si ambas condiciones son verdaderas.
        ||  OR   -> Verdadero si al menos una condición es verdadera.
        !   NOT  -> Invierte el valor booleano.

        Los operadores lógicos trabajan con valores booleanos:
        true (verdadero) y false (falso).
        */


        // AND (&&): ambas condiciones deben ser verdaderas.

        System.out.println(true && true);   // true
        System.out.println(true && false);  // false
        System.out.println(false && true);  // false
        System.out.println(false && false); // false

        // También podemos combinar expresiones de comparación.
        System.out.println(3 > 2 && 5 == 3); // false


        // OR (||): al menos una condición debe ser verdadera.

        System.out.println(true || true);   // true
        System.out.println(true || false);  // true
        System.out.println(false || true);  // true
        System.out.println(false || false); // false

        // Basta con que una de las condiciones sea verdadera.
        System.out.println(3 > 2 || 5 == 3); // true


        // NOT (!): invierte el valor booleano.

        System.out.println(!true);  // false
        System.out.println(!false); // true

        System.out.println(!(3 > 2) && (5 == 3)); // false


        /*
        ============================================================
                    AGRUPACIÓN DE EXPRESIONES
        ============================================================

        Los paréntesis permiten agrupar expresiones y hacer más
        clara la evaluación de las condiciones.

        Ejemplo:
        (3 > 2) && (5 == 3)

        Primero evaluamos cada comparación:
        3 > 2  -> true
        5 == 3 -> false

        Finalmente:
        true && false -> false
        */


        // Referencia:
        // https://es.wikipedia.org/wiki/Tabla_de_verdad

        /*
        ============================================================
                        5. OPERADORES UNARIOS
        ============================================================

        Los operadores unarios trabajan con un solo operando.

        +   -> Indica un valor positivo.
        -   -> Cambia el signo del valor.
        ++  -> Incrementa el valor en 1.
        --  -> Decrementa el valor en 1.

        PREFIJO:  ++b  -> Incrementa primero y después devuelve el valor.
        POSTFIJO: b++  -> Devuelve el valor actual y después incrementa.
        */


        // OPERADORES DE SIGNO

        System.out.println(+b); // Muestra b con su signo positivo.
        System.out.println(-b); // Muestra el valor negativo de b.


        // INCREMENTO (++)

        System.out.println(++b); // Incrementa b primero y muestra el nuevo valor.
        System.out.println(b++); // Muestra b y después lo incrementa.
        System.out.println(b);   // Muestra el valor actualizado de b.


        // DECREMENTO (--)

        System.out.println(--b); // Decrementa b primero y muestra el nuevo valor.
        System.out.println(b);   // Muestra el valor actual de b.


        // También podemos incrementar una variable por separado.

        b++;
        System.out.println(b); // Muestra b después del incremento.
        
    }
}