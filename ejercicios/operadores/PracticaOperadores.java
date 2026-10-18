
public class PracticaOperadores {
    public static void main(String[] args) {

        // Práctica de operadores en Java

        // 1. Declara variables enteras, suma sus valores y muestra el resultado.

        int a = 23;
        int b = 24;
        int c = 234;
        int d = 345;
        int e = 2334;

        // Se especifica el tipo de dato al declarar una variable.
        int resultado = a + b + c + d + e;

        System.out.println(resultado);
        System.out.println("La suma de todas las variables es: " + resultado);


        // 2. Utiliza los operadores de asignación compuesta y muestra los resultados.

        a += b;  // Suma b a a.
        System.out.println(a);

        a -= b;  // Resta b a a.
        System.out.println(a);

        a *= b;  // Multiplica a por b.
        System.out.println(a);

        a /= b;  // Divide a entre b.
        System.out.println(a);

        a %= b;  // Asigna a a el resto de dividir a entre b.
        System.out.println(a);


        // 3. Imprime tres comparaciones verdaderas utilizando distintos operadores relacionales.

        a = 2;
        b = 2;

        System.out.println(a == b); // Comprueba si a y b son iguales.

        c = 8;
        d = 12;

        System.out.println(a <= d); // Comprueba si a es menor o igual que d.

        int x = 2343;
        int z = 2345;

        System.out.println(x <= z); // Comprueba si x es menor o igual que z.


        // 4. Imprime tres comparaciones falsas utilizando distintos operadores relacionales.

        a = 100;
        int v = 200;

        System.out.println(a == b); // Comprueba si a y b son iguales.

        float k = 23.4f;
        float y = 234.45f;

        System.out.println(k >= y); // Comprueba si k es mayor o igual que y.

        byte j = 4;
        byte p = 3;

        System.out.println(j == p); // Comprueba si j y p son iguales.


        // 5. Utiliza el operador lógico AND (&&) para evaluar dos condiciones.

        System.out.println(45 > 23 && 3 == 3);


        // 6. Utiliza el operador lógico OR (||) para evaluar dos condiciones.

        System.out.println(1235 > 77 || 123 <= 2);


        // 7. Utiliza el operador lógico NOT (!) para invertir el resultado de una condición.

        System.out.println(!true);


        // 8. Combina los operadores lógicos AND (&&) y OR (||) en una expresión.
        // Recuerda que && tiene mayor precedencia que ||.

        System.out.println((10 > 45) || ((2 == 2) && (34 == 34)));


        // 9. Utiliza operadores unarios de incremento y decremento.

        System.out.println(a);   // Muestra el valor actual de a.
        System.out.println(++a); // Incrementa a antes de mostrar su valor.
        System.out.println(a--); // Muestra a y después lo decrementa.
        System.out.println(--a); // Decrementa a antes de mostrar su valor.


        // 10. Combina operadores aritméticos, relacionales y lógicos en una expresión.

        a = 2;
        b = 20;

        System.out.println(
                (19 <= 20 && 23 == 23) || (99 == 99 && a + b == 22)
        );

        int h = 2;
        int u = 4;

        System.out.println(
                (302 <= 309 && 13 == 13) || (99 == 99 && h + u == 22)
        );
    }
}
