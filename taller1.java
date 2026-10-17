
public class taller1 {

    public static void main(String[] args) {

        System.out.println("TALLER 1 - LOGICA DE PROGRAMACION");
        System.out.println("EXPRESIONES ARITMETICAS\n");

        System.out.println("1.  5 + 3 * 2 = " + (5 + 3 * 2));

        System.out.println("2.  (5 + 3) * 2 = " + ((5 + 3) * 2));

        System.out.println("3.  20 / 4 + 3 = " + (20 / 4 + 3));

        System.out.println("4.  20 / (4 + 1) = " + (20 / (4 + 1)));

        System.out.println("5.  10 - 2 * 3 = " + (10 - 2 * 3));

        System.out.println("6.  (10 - 2) * 3 = " + ((10 - 2) * 3));

        System.out.println("7.  2 + 3 * 4 - 5 = " + (2 + 3 * 4 - 5));

        System.out.println("8.  18 / 3 * 2 = " + (18 / 3 * 2));

        System.out.println("9.  2 * (3 + 4) - 6 / 2 = " + (2 * (3 + 4) - 6 / 2));

        System.out.println("10. (8 + 4) / 2 + 3 * 2 = " + ((8 + 4) / 2 + 3 * 2));


        System.out.println("\n=== RESOLUCION PASO A PASO ===");

        // Ejercicio 1: 5 + 3 * 2
        int paso1 = 3 * 2;
        int resultado1 = 5 + paso1;

        System.out.println("\nEjercicio 1: 5 + 3 * 2");
        System.out.println("Paso 1: 3 * 2 = " + paso1);
        System.out.println("Paso 2: 5 + " + paso1 + " = " + resultado1);

        // Ejercicio 2: (5 + 3) * 2
        int paso2 = 5 + 3;
        int resultado2 = paso2 * 2;

        System.out.println("\nEjercicio 2: (5 + 3) * 2");
        System.out.println("Paso 1: 5 + 3 = " + paso2);
        System.out.println("Paso 2: " + paso2 + " * 2 = " + resultado2);

        // Ejercicio 3: 20 / 4 + 3
        int paso3 = 20 / 4;
        int resultado3 = paso3 + 3;

        System.out.println("\nEjercicio 3: 20 / 4 + 3");
        System.out.println("Paso 1: 20 / 4 = " + paso3);
        System.out.println("Paso 2: " + paso3 + " + 3 = " + resultado3);

        // Ejercicio 4: 20 / (4 + 1)
        int paso4 = 4 + 1;
        int resultado4 = 20 / paso4;

        System.out.println("\nEjercicio 4: 20 / (4 + 1)");
        System.out.println("Paso 1: 4 + 1 = " + paso4);
        System.out.println("Paso 2: 20 / " + paso4 + " = " + resultado4);

        // Ejercicio 5: 10 - 2 * 3
        int paso5 = 2 * 3;
        int resultado5 = 10 - paso5;

        System.out.println("\nEjercicio 5: 10 - 2 * 3");
        System.out.println("Paso 1: 2 * 3 = " + paso5);
        System.out.println("Paso 2: 10 - " + paso5 + " = " + resultado5);

        // Ejercicio 6: (10 - 2) * 3
        int paso6 = 10 - 2;
        int resultado6 = paso6 * 3;

        System.out.println("\nEjercicio 6: (10 - 2) * 3");
        System.out.println("Paso 1: 10 - 2 = " + paso6);
        System.out.println("Paso 2: " + paso6 + " * 3 = " + resultado6);

        // Ejercicio 7: 2 + 3 * 4 - 5
        int paso7 = 3 * 4;
        int paso7b = 2 + paso7;
        int resultado7 = paso7b - 5;

        System.out.println("\nEjercicio 7: 2 + 3 * 4 - 5");
        System.out.println("Paso 1: 3 * 4 = " + paso7);
        System.out.println("Paso 2: 2 + " + paso7 + " = " + paso7b);
        System.out.println("Paso 3: " + paso7b + " - 5 = " + resultado7);

        // Ejercicio 8: 18 / 3 * 2
        int paso8 = 18 / 3;
        int resultado8 = paso8 * 2;

        System.out.println("\nEjercicio 8: 18 / 3 * 2");
        System.out.println("Paso 1: 18 / 3 = " + paso8);
        System.out.println("Paso 2: " + paso8 + " * 2 = " + resultado8);

        // Ejercicio 9: 2 * (3 + 4) - 6 / 2
        int paso9 = 3 + 4;
        int paso9b = 2 * paso9;
        int paso9c = 6 / 2;
        int resultado9 = paso9b - paso9c;

        System.out.println("\nEjercicio 9: 2 * (3 + 4) - 6 / 2");
        System.out.println("Paso 1: 3 + 4 = " + paso9);
        System.out.println("Paso 2: 2 * " + paso9 + " = " + paso9b);
        System.out.println("Paso 3: 6 / 2 = " + paso9c);
        System.out.println("Paso 4: " + paso9b + " - " + paso9c + " = " + resultado9);

        // Ejercicio 10: (8 + 4) / 2 + 3 * 2
        int paso10 = 8 + 4;
        int paso10b = paso10 / 2;
        int paso10c = 3 * 2;
        int resultado10 = paso10b + paso10c;

        System.out.println("\nEjercicio 10: (8 + 4) / 2 + 3 * 2");
        System.out.println("Paso 1: 8 + 4 = " + paso10);
        System.out.println("Paso 2: " + paso10 + " / 2 = " + paso10b);
        System.out.println("Paso 3: 3 * 2 = " + paso10c);
        System.out.println("Paso 4: " + paso10b + " + " + paso10c + " = " + resultado10);

    }
}
