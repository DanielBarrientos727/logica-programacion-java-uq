
import java.util.HashSet;
import java.util.Scanner;

public class RegistroUsuarios {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> correos = new HashSet<>();

        while (true) {
            System.out.print("Correo (o salir): ");
            String correo = sc.nextLine().trim();

            if (correo.equalsIgnoreCase("salir")) {
                break;
            }

            if (correo.isEmpty()) {
                System.out.println("El correo no puede estar vacío.");
                continue;
            }

            // Normalizar para evitar diferencias por mayúsculas
            correo = correo.toLowerCase();

            // add() devuelve false si el elemento ya existe
            if (correos.add(correo)) {
                System.out.println("Usuario registrado.");
            } else {
                System.out.println("Ese correo ya está registrado.");
            }

            System.out.println("Total de usuarios: " + correos.size());
        }

        System.out.println("Correos registrados: " + correos);
        sc.close();
    }
}
