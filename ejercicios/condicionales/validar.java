import java.util.Scanner;

public class validar {

    public static void main(String[] args) {

        // 1. Solicitar el valor de la reserva al usuario.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Necesito saber el valor de la reserva: ");
        double valorReserva = scanner.nextDouble();

        // 2. Validar el valor de la reserva.
        String validacionReserva = validarReserva(valorReserva);

        // 3. Mostrar el mensaje correspondiente.
        generarMensaje(validacionReserva);

        scanner.close();
    }

    // Clasifica la reserva según su valor.
    public static String validarReserva(double valorReserva) {

        String validacion;

        if (valorReserva < 0) {
            validacion = "El valor de la reserva no puede ser negativo";
        } else if (valorReserva < 50000) {
            validacion = "La reserva es de valor básico";
        } else if (valorReserva <= 200000) {
            validacion = "La reserva es de valor medio";
        } else {
            validacion = "La reserva es de alto valor";
        }

        return validacion;
    }

    // Imprime el resultado de la validación.
    public static void generarMensaje(String validacionReserva) {

        System.out.println(validacionReserva);
    }
}
