import java.util.Scanner;

public class Ejercicio_1 {

    //  Hace un programa que califique a tres estudiantes

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float nota1,nota2,nota3, suma;

        System.out.println("Digite bro las 3 notas");
        //Guardamos las 3 notas

        nota1 = entrada.nextFloat();
        nota2 = entrada.nextFloat();
        nota3 = entrada.nextFloat();

        suma = nota1+nota2+nota3; // suma 3 notas

        System.out.println("\nLa suma es: "+suma);


    }


}
