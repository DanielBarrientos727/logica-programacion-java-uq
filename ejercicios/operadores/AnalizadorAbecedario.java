public class AnalizadorAbecedario {

    public static void main(String[] args) {

        // 1. Declaración de las vocales.
        char a = 'A';
        char e = 'E';
        char i = 'I';
        char o = 'O';
        char u = 'U';

        System.out.println("==================================");
        System.out.println("      ANALIZADOR DEL ABECEDARIO");
        System.out.println("==================================");

        System.out.println("\n1. VOCALES ANALIZADAS");
        System.out.println("Vocales: " + a + ", " + e + ", " + i + ", " + o + ", " + u);


        // 2. Comparación de caracteres mediante operadores relacionales.
        System.out.println("\n2. COMPARACION DE CARACTERES");

        System.out.println("¿A es igual a E? " + (a == e));
        System.out.println("¿A es diferente de E? " + (a != e));
        System.out.println("¿I es igual a I? " + (i == i));


        // 3. Posiciones de las vocales en el abecedario español.
        int posA = 1;
        int posE = 5;
        int posI = 9;
        int posO = 16;
        int posU = 22;

        System.out.println("\n3. POSICIONES ALFABETICAS");

        System.out.println("A: " + posA);
        System.out.println("E: " + posE);
        System.out.println("I: " + posI);
        System.out.println("O: " + posO);
        System.out.println("U: " + posU);


        // 4. Operaciones aritméticas con las posiciones.
        int suma = posA + posE + posI + posO + posU;
        int promedio = suma / 5;

        System.out.println("\n4. OPERACIONES ARITMETICAS");

        System.out.println("Suma de las posiciones: " + suma);
        System.out.println("Promedio entero: " + promedio);


        // 5. Operadores de asignación compuesta.
        int acumulador = suma;

        System.out.println("\n5. ASIGNACION COMPUESTA");
        System.out.println("Valor inicial: " + acumulador);

        acumulador += posA;
        System.out.println("Suma de la posición de A: " + acumulador);

        acumulador -= posE;
        System.out.println("Resta de la posición de E: " + acumulador);

        acumulador *= 2;
        System.out.println("Multiplicación por 2: " + acumulador);

        acumulador /= 2;
        System.out.println("División entre 2: " + acumulador);

        acumulador %= 7;
        System.out.println("Resto de la división entre 7: " + acumulador);


        // 6. Evaluación de condiciones mediante operadores relacionales.
        System.out.println("\n6. COMPROBACION DE RANGO");

        boolean mayorQue50 = suma > 50;
        boolean menorQue100 = suma < 100;
        boolean dentroDelRango = mayorQue50 && menorQue100;

        System.out.println("¿La suma es mayor que 50? " + mayorQue50);
        System.out.println("¿La suma es menor que 100? " + menorQue100);
        System.out.println("¿La suma está entre 50 y 100? " + dentroDelRango);


        // 7. Operadores lógicos AND, OR y NOT.
        System.out.println("\n7. OPERADORES LOGICOS");

        boolean aAntesDeE = posA < posE;
        boolean iAntesDeO = posI < posO;
        boolean uEnPosicionCorrecta = posU == 22;

        System.out.println(
                "¿A está antes de E e I está antes de O? "
                        + (aAntesDeE && iAntesDeO)
        );

        System.out.println(
                "¿A está después de E o U está en la posición 22? "
                        + (posA > posE || uEnPosicionCorrecta)
        );

        System.out.println(
                "¿A no ocupa la posición 1? "
                        + !(posA == 1)
        );


        // 8. Incremento y decremento de una variable.
        System.out.println("\n8. OPERADORES UNARIOS");

        int posicion = posA;

        System.out.println("Posición inicial: " + posicion);
        System.out.println("Preincremento (++posicion): " + (++posicion));
        System.out.println("Postincremento (posicion++): " + (posicion++));
        System.out.println("Valor después del postincremento: " + posicion);
        System.out.println("Predecremento (--posicion): " + (--posicion));
        System.out.println("Postdecremento (posicion--): " + (posicion--));
        System.out.println("Valor final: " + posicion);


        // 9. Evaluación de una expresión combinada.
        System.out.println("\n9. EVALUACION FINAL");

        boolean resultadoFinal =
                ((posA + posE + posI) > 10)
                        && ((posO - posA) == 15)
                        || !((posU / posE) < 4);

        System.out.println("Resultado de la expresión: " + resultadoFinal);


        // 10. Resumen de los resultados.
        System.out.println("\n10. RESUMEN");

        System.out.println("Total de vocales analizadas: 5");
        System.out.println("Suma de las posiciones: " + suma);
        System.out.println("Promedio entero: " + promedio);
        System.out.println("Acumulador final: " + acumulador);
        System.out.println("\nAnálisis completado correctamente.");
    }
}