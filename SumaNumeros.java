
import java.util.Scanner;

public class SumaNumeros {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int numero1 = entrada.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        int numero2 = entrada.nextInt();

        int resultado = sumar(numero1, numero2);

        System.out.println("La suma es: " + resultado);

        entrada.close();
    }
}
