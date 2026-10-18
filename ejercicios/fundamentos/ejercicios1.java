public class ejercicios1 {
    //1. Escribe un programa que use un ciclo while para imprimir los números desde 10 hasta 100, incrementando de 10 en 10.

    public static void sumaDiez() {
        int i =10;
        while (i<=100){
            System.out.println(i);
            i = i+10;
        }
    }


//2. Escribe un ciclo while que calcule la suma de los números enteros del 1 al 20.

    public static void sumatoriaVeinte() {
        int i = 1;
        int suma = 0;

        while (i <= 20) {
            suma = suma + i;
            i = i + 1;
        }

        System.out.println(suma);
    }

// 3. Escribe un ciclo while que multiplique los números impares del 1 al 15.

    public static void completarImpares() {
        int i = 1;
        int impar = 1;

        while (i <= 15) {
            impar = impar * i;
            i = i + 2;
        }

        System.out.println(impar);
    }


//4. Crea un ciclo while que reste múltiplos de 3 desde 90 hasta 3.

    public static void restaMultiplos() {
        int i = 90;
        int resta = 0;

        while (i >= 3) {
            resta = resta - i;
            i = i - 3;
        }

        System.out.println(resta);
    }



//5. Escribe un ciclo while que imprima el cubo de cada número desde el 1 hasta el 10.

    public static void cicloCubos() {
        int i = 1;
        int cubo;

        while (i <= 10) {
            cubo = i * i * i;
            System.out.println(cubo);
            i++;
        }
    }
}
