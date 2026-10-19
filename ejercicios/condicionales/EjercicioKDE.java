
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class EjercicioKDE {

    // Ruta de los sonidos de KDE.
    private static final String RUTA_SONIDOS =
            "ejercicios/kdesounds/";

    // ============================================================
    // ANIMACIÓN: PELOTA REBOTANDO
    // ============================================================

    static class Pelota extends JPanel {

        private int x = 40;
        private int y = 40;

        private int velocidadX = 4;
        private int velocidadY = 3;

        private final int TAMANO = 45;

        private final Timer temporizador;

        public Pelota() {

            setBackground(new Color(30, 30, 46));

            temporizador = new Timer(16, e -> {

                x += velocidadX;
                y += velocidadY;

                // Rebote contra los bordes horizontales.
                if (x <= 0 || x + TAMANO >= getWidth()) {
                    velocidadX *= -1;
                    reproducirOgg("KDE_Click_1.ogg");
                }

                // Rebote contra los bordes verticales.
                if (y <= 0 || y + TAMANO >= getHeight()) {
                    velocidadY *= -1;
                    reproducirOgg("KDE_Click_2.ogg");
                }

                repaint();
            });

            temporizador.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Dibujar la pelota.
            g2.setColor(new Color(250, 179, 135));
            g2.fillOval(x, y, TAMANO, TAMANO);

            // Dibujar un borde.
            g2.setColor(new Color(245, 194, 231));
            g2.drawOval(x, y, TAMANO, TAMANO);

            g2.dispose();
        }
    }

    // ============================================================
    // REPRODUCCIÓN DE SONIDOS OGG MEDIANTE FFPLAY
    // ============================================================

    public static void reproducirOgg(String nombre) {

        try {
            new ProcessBuilder(
                    "ffplay",
                    "-nodisp",
                    "-autoexit",
                    "-loglevel", "quiet",
                    RUTA_SONIDOS + nombre
            ).start();

        } catch (Exception e) {
            System.out.println(
                    "No se pudo reproducir el sonido: " + nombre
            );
        }
    }

    // ============================================================
    // REPRODUCCIÓN DE ARCHIVOS WAV MEDIANTE CLIP
    // ============================================================

    public static void reproducirWav(String nombre) {

        try {
            File archivo = new File(RUTA_SONIDOS + nombre);

            Clip sonido = AudioSystem.getClip();

            sonido.open(
                    AudioSystem.getAudioInputStream(archivo)
            );

            sonido.addLineListener(evento -> {

                if (evento.getType() == LineEvent.Type.STOP) {
                    sonido.close();
                }
            });

            sonido.start();

        } catch (Exception e) {
            System.out.println(
                    "No se pudo reproducir el archivo WAV."
            );
        }
    }

    // ============================================================
    // VENTANA PRINCIPAL
    // ============================================================

    public static void mostrarVentana() {

        JFrame ventana = new JFrame("KDE Java Lab");

        ventana.setSize(800, 550);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(
                "KDE JAVA LAB",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(new Color(205, 214, 244));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(24, 24, 37));
        titulo.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10)
        );

        Pelota pelota = new Pelota();

        JButton botonSonido = new JButton("Reproducir sonido");
        JButton botonEjercicios = new JButton("Abrir ejercicios");
        JButton botonCerrar = new JButton("Salir");

        botonSonido.addActionListener(e -> {
            reproducirOgg("KDE_Dialog_Appear.ogg");
        });

        botonEjercicios.addActionListener(e -> {
            reproducirWav("KDE_Beep_ClassicBeep.wav");
            mostrarMenu();
        });

        botonCerrar.addActionListener(e -> {
            reproducirOgg("KDE_Logout_1.ogg");
            ventana.dispose();
        });

        JPanel botones = new JPanel(new FlowLayout());
        botones.setBackground(new Color(24, 24, 37));

        botones.add(botonSonido);
        botones.add(botonEjercicios);
        botones.add(botonCerrar);

        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(pelota, BorderLayout.CENTER);
        ventana.add(botones, BorderLayout.SOUTH);

        ventana.setVisible(true);

        reproducirOgg("KDE_Startup_2.ogg");
    }

    // ============================================================
    // MENÚ DE EJERCICIOS CON SWITCH
    // ============================================================

    public static void mostrarMenu() {

        String[] opciones = {
                "Comparar dos números",
                "Número positivo, negativo o cero",
                "Número par o impar",
                "Comprobar si puede votar",
                "Mostrar día de la semana",
                "Clasificar nota académica",
                "Determinar la vocal o consonante",
                "Salir"
        };

        while (true) {

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona un ejercicio:",
                    "Ejercicios de condicionales",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opcion == -1 || opcion == 7) {
                reproducirOgg("KDE_Dialog_Disappear.ogg");
                break;
            }

            reproducirOgg("KDE_Click_1.ogg");

            switch (opcion) {

                case 0:
                    compararNumeros();
                    break;

                case 1:
                    clasificarNumero();
                    break;

                case 2:
                    comprobarParidad();
                    break;

                case 3:
                    comprobarVotacion();
                    break;

                case 4:
                    mostrarDia();
                    break;

                case 5:
                    clasificarNota();
                    break;

                case 6:
                    comprobarLetra();
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null, "Opción no válida."
                    );
                    break;
            }
        }
    }

    // ============================================================
    // 1. COMPARAR DOS NÚMEROS
    // ============================================================

    public static void compararNumeros() {

        int a = leerEntero("Ingresa el primer número:");
        int b = leerEntero("Ingresa el segundo número:");

        if (a > b) {
            mostrarResultado(a + " es mayor que " + b);

        } else if (a < b) {
            mostrarResultado(a + " es menor que " + b);

        } else {
            mostrarResultado("Los dos números son iguales.");
        }
    }

    // ============================================================
    // 2. CLASIFICAR UN NÚMERO
    // ============================================================

    public static void clasificarNumero() {

        int numero = leerEntero("Ingresa un número entero:");

        if (numero > 0) {
            mostrarResultado("El número es positivo.");

        } else if (numero < 0) {
            mostrarResultado("El número es negativo.");

        } else {
            mostrarResultado("El número es cero.");
        }
    }

    // ============================================================
    // 3. COMPROBAR SI ES PAR O IMPAR
    // ============================================================

    public static void comprobarParidad() {

        int numero = leerEntero("Ingresa un número entero:");

        if (numero % 2 == 0) {
            mostrarResultado("El número es par.");

        } else {
            mostrarResultado("El número es impar.");
        }
    }

    // ============================================================
    // 4. COMPROBAR SI PUEDE VOTAR
    // ============================================================

    public static void comprobarVotacion() {

        int edad = leerEntero("¿Cuántos años tienes?");

        if (edad < 0) {
            mostrarResultado("La edad no puede ser negativa.");

        } else if (edad >= 18) {
            mostrarResultado("Puedes votar según el criterio de edad.");

        } else {
            mostrarResultado("Todavía no tienes 18 años.");
        }
    }

    // ============================================================
    // 5. DÍA DE LA SEMANA CON SWITCH
    // ============================================================

    public static void mostrarDia() {

        int dia = leerEntero(
                "Ingresa un número del 1 al 7:"
        );

        String nombre = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Día no válido";
        };

        mostrarResultado(nombre);
    }

    // ============================================================
    // 6. CLASIFICAR UNA NOTA
    // ============================================================

    public static void clasificarNota() {

        int nota = leerEntero(
                "Ingresa una nota entera entre 0 y 5:"
        );

        switch (nota) {

            case 5, 4:
                mostrarResultado("Sobresaliente.");
                break;

            case 3:
                mostrarResultado("Aceptable.");
                break;

            case 2, 1:
                mostrarResultado("Nota insuficiente.");
                break;

            case 0:
                mostrarResultado("Calificación cero.");
                break;

            default:
                mostrarResultado("La nota debe estar entre 0 y 5.");
                break;
        }
    }

    // ============================================================
    // 7. DETERMINAR SI ES VOCAL O CONSONANTE
    // ============================================================

    public static void comprobarLetra() {

        String entrada = JOptionPane.showInputDialog(
                "Ingresa una letra:"
        );

        if (entrada == null || entrada.length() != 1) {
            mostrarResultado("Debes ingresar un solo carácter.");
            return;
        }

        char letra = Character.toLowerCase(
                entrada.charAt(0)
        );

        if (!Character.isLetter(letra)) {
            mostrarResultado("El carácter no es una letra.");
            return;
        }

        switch (letra) {

            case 'a', 'e', 'i', 'o', 'u':
                mostrarResultado("Es una vocal.");
                break;

            default:
                mostrarResultado("Es una consonante.");
                break;
        }
    }

    // ============================================================
    // MÉTODOS AUXILIARES
    // ============================================================

    public static int leerEntero(String mensaje) {

        while (true) {

            String entrada = JOptionPane.showInputDialog(mensaje);

            if (entrada == null) {
                return 0;
            }

            try {
                return Integer.parseInt(entrada.trim());

            } catch (NumberFormatException e) {

                reproducirOgg("KDE_Error_1.ogg");

                JOptionPane.showMessageDialog(
                        null,
                        "Error: debes ingresar un número entero.",
                        "Entrada no válida",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void mostrarResultado(String mensaje) {

        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );

        reproducirOgg("KDE_Dialog_Appear.ogg");
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                EjercicioKDE::mostrarVentana
        );
    }
}
