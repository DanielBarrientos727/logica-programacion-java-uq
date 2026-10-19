
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Instalador {

    public static void main(String[] args) {

        // Obtener la ruta del escritorio del usuario.
        String escritorio = System.getenv("HOME") + "/Escritorio";
        Path accesoDirecto = Path.of(escritorio, "Warp.desktop");

        // Contenido del lanzador de KDE Plasma.
        String contenido = """
                [Desktop Entry]
                Version=1.0
                Type=Application
                Name=Warp Terminal
                Comment=Terminal para desarrollo
                Exec=warp-terminal
                Icon=dev.warp.Warp
                Terminal=false
                Categories=System;TerminalEmulator;Development;
                """;

        try {
            Files.createDirectories(Path.of(escritorio));
            Files.writeString(accesoDirecto, contenido);

            // Dar permiso de ejecución al archivo.
            accesoDirecto.toFile().setExecutable(true);

            System.out.println("Acceso directo creado correctamente.");
            System.out.println(accesoDirecto);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
