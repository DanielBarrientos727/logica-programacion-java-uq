import java.util.Scanner;
public class sumaSwitch {
    public static void main(String[] args) {
        int num1 = ingresarEntero ("Ingrese el primer numero: ");
        int num2 = ingresarEntero ("Ingrese el segundo numero: ");
        int num3 = ingresarEntero ("Igrese el tercer numero: ");
        int operacion = ingresarEntero ("\n1) Suma" +
                "\n2) Resta" +
                "\n3) Multiplicacion" +
                "\n4) Division" +
                "\nCual es la operacion que quieres hacer: ");
        int resultado = operaciones (num1, num2, num3, operacion);
        generarMensaje (resultado, num1, num2, num3);
    }
    public static int ingresarEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        int valor= sc.nextInt();
        return valor;
    }
    public static int operaciones (int num1, int num2, int num3, int operacion) {
        int resultado = 0;
        switch (operacion){
            case 1:
                resultado = num1 + num2 + num3;
                break;
            case 2:
                resultado = num1 - num2 - num3;
                break;
            case 3:
                resultado = num1 * num2 * num3;
                break;
            case 4:
                resultado = num1 / num2 / num3;
                break;
        }
        return resultado;
    }
    public static void generarMensaje (int resultado, int num1, int num2, int num3){
        String mensaje = "El resultado de la operacion es: " + resultado +
                "\nEl primer numero utilizado es: " + num1 +
                "\nEl segundo numero utilizado es: " + num2 +
                "\nEl tercer numero utilizado es: " + num3;
        System.out.println(mensaje);
    }
}