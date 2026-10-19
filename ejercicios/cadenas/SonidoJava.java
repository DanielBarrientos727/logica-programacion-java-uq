//Importamos las librerias
import javax.sound.sampled.*;
import java.io.File;

public class SonidoJava {

    public static void main(String[] args) throws Exception {
        File archivo = new File("ejercicios/kdesounds/KDE_Startup.wav");

        Clip sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(archivo));
        sonido.start();

        Thread.sleep(sonido.getMicrosecondLength() / 1000);
        sonido.close();

        // 2. Sonidos de inicio OGG
        String[] sonidos = {
                "KDE_Startup_1.ogg", //SOnido rico
                "KDE_Startup_2.ogg", //Sonido divino
                "KDE_Startup_3.ogg" //Sonido ÑOM
        };

        for (String nombre : sonidos) {
            Process proceso = new ProcessBuilder(
                    "ffplay",
                    "-nodisp",
                    "-autoexit",
                    "-loglevel", "quiet",
                    "ejercicios/kdesounds/" + nombre
            ).inheritIO().start();

            proceso.waitFor();
        }

        System.out.println("¡YAPO!");
    }
}
