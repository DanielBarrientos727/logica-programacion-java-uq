import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número que sea mayor que 0: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("El número debe ser mayor que 0.");
        } else {
            double factorial = 1;

            for (
                    int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
            System.out.println("El factorial pues es :3 : " + factorial);

            sc.close();
        }
    }
}