
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BadApple extends JFrame {

    private static final int TOTAL_FOTOGRAMAS = 6569;
    private static final int INTERVALO = 32;

    private Clip musica;
    private final Timer temporizador;
    private final PanelAnimacion panel;

    public BadApple() {
        panel = new PanelAnimacion();

        setTitle("Bad Apple!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 510);
        setLocationRelativeTo(null);

        add(panel);

        temporizador = new Timer(INTERVALO, evento -> {
            panel.siguienteFotograma();
        });

        setVisible(true);
    }

    // Reproduce la música desde un archivo WAV.
    private void reproducirMusica() {
        File archivoMusica = new File("BadApple.wav");

        try (AudioInputStream audio =
                     AudioSystem.getAudioInputStream(archivoMusica)) {

            musica = AudioSystem.getClip();
            musica.open(audio);
            musica.start();

        } catch (Exception error) {
            System.out.println(
                    "No se pudo reproducir la música: "
                            + error.getMessage()
            );
        }
    }

    // Inicia la música y la animación.
    public void iniciar() {
        reproducirMusica();
        temporizador.start();
    }

    // Detiene la animación y libera los recursos de audio.
    private void finalizar() {
        temporizador.stop();

        if (musica != null) {
            musica.stop();
            musica.close();
        }

        dispose();
    }

    // Panel encargado de cargar y dibujar los fotogramas.
    private class PanelAnimacion extends JPanel {

        private int numeroFotograma = 1;
        private final List<int[]> lineas = new ArrayList<>();

        // Lee el archivo del siguiente fotograma.
        public void siguienteFotograma() {
            if (numeroFotograma > TOTAL_FOTOGRAMAS) {
                finalizar();
                return;
            }

            File archivo = new File(
                    "data/out (" + numeroFotograma + ").txt"
            );

            lineas.clear();

            try (BufferedReader lector =
                         new BufferedReader(new FileReader(archivo))) {

                String texto;
                int posicionY = 0;

                while ((texto = lector.readLine()) != null) {
                    texto = texto.trim();

                    if (texto.isEmpty()) {
                        posicionY++;
                        continue;
                    }

                    String[] numeros = texto.split("\\s+");

                    // Cada pareja de números define una línea horizontal.
                    for (int i = 0; i + 1 < numeros.length; i += 2) {
                        int inicio = Integer.parseInt(numeros[i]);
                        int fin = Integer.parseInt(numeros[i + 1]);

                        lineas.add(new int[] {
                                inicio, posicionY, fin, posicionY
                        });
                    }

                    posicionY++;
                }

                numeroFotograma++;
                repaint();

            } catch (IOException | NumberFormatException error) {
                System.out.println(
                        "Error al leer el fotograma "
                                + numeroFotograma + ": "
                                + error.getMessage()
                );

                finalizar();
            }
        }

        // Dibuja las líneas del fotograma actual.
        @Override
        protected void paintComponent(Graphics grafico) {
            super.paintComponent(grafico);

            grafico.setColor(Color.BLACK);

            for (int[] linea : lineas) {
                grafico.drawLine(
                        linea[0], linea[1],
                        linea[2], linea[3]
                );
            }
        }
    }

    public static void main(String[] argumentos) {
        SwingUtilities.invokeLater(() -> {
            BadApple programa = new BadApple();
            programa.iniciar();
        });
    }
}

//Solo ando probando algo de un repositorio