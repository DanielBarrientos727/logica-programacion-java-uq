
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Automatizacion {

    public static void main(String[] args) throws Exception {

        // Consultar la versión del kernel.
        ejecutar("uname", "-r");

        // Consultar el espacio disponible.
        ejecutar("df", "-h", "/");
    }

    public static void ejecutar(String... comando)
            throws Exception {

        ProcessBuilder proceso = new ProcessBuilder(comando);
        proceso.redirectErrorStream(true);

        Process resultado = proceso.start();

        try (BufferedReader lector = new BufferedReader(
                new InputStreamReader(
                        resultado.getInputStream()))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        }

        int codigo = resultado.waitFor();

        if (codigo != 0) {
            System.out.println(
                    "El comando terminó con código: " + codigo);
        }
    }
}
