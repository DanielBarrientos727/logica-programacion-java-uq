
import java.util.HashMap;

public class IndiceUsuarios {

    static class Usuario {
        int id;
        String nombre;
        String correo;

        Usuario(int id, String nombre, String correo) {
            this.id = id;
            this.nombre = nombre;
            this.correo = correo;
        }

        @Override
        public String toString() {
            return id + " | " + nombre + " | " + correo;
        }
    }

    public static void main(String[] args) {

        // Índice principal: ID -> Usuario
        HashMap<Integer, Usuario> porId = new HashMap<>();

        // Índice secundario: correo -> Usuario
        HashMap<String, Usuario> porCorreo = new HashMap<>();

        // Crear usuarios
        Usuario u1 = new Usuario(
                1001, "Daniel", "daniel@gmail.com"
        );

        Usuario u2 = new Usuario(
                1002, "Jorge", "jorge@gmail.com"
        );

        Usuario u3 = new Usuario(
                1003, "Carlos", "carlos@gmail.com"
        );

        // Registrar los usuarios en ambos índices
        porId.put(u1.id, u1);
        porId.put(u2.id, u2);
        porId.put(u3.id, u3);

        porCorreo.put(u1.correo, u1);
        porCorreo.put(u2.correo, u2);
        porCorreo.put(u3.correo, u3);

        // Buscar por identificador
        System.out.println("Búsqueda por ID:");
        System.out.println(porId.get(1002));

        // Buscar por correo
        System.out.println("\nBúsqueda por correo:");
        System.out.println(porCorreo.get("carlos@gmail.com"));

        // Comprobar si un usuario existe
        System.out.println("\n¿Existe el ID 1001?");
        System.out.println(porId.containsKey(1001));

        // Mostrar todos los usuarios
        System.out.println("\nTodos los usuarios:");

        for (Usuario usuario : porId.values()) {
            System.out.println(usuario);
        }
    }
}
