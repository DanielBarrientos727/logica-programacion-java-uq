
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendario {

    private static final Locale ES = Locale.forLanguageTag("es-ES");

    private static final Color FONDO = new Color(15, 17, 23);
    private static final Color PANEL = new Color(25, 29, 38);
    private static final Color AZUL = new Color(105, 165, 255);
    private static final Color TEXTO = new Color(238, 241, 248);
    private static final Color SUAVE = new Color(151, 161, 180);
    private static final Color VERDE = new Color(115, 220, 170);

    private static final DateTimeFormatter RELOJ =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private static JLabel reloj;
    private static JLabel diaSemana;
    private static JLabel numeroDia;
    private static JLabel fechaCompleta;
    private static JLabel saludo;
    private static JLabel progresoTexto;
    private static JProgressBar progreso;
    private static JLabel pie;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calendario::crearVentana);
    }

    private static void crearVentana() {

        JFrame ventana = new JFrame("Orisono Time");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setMinimumSize(new Dimension(460, 570));
        ventana.setSize(500, 620);
        ventana.setLocationRelativeTo(null);

        JPanel raiz = new JPanel(new BorderLayout(0, 18));
        raiz.setBackground(FONDO);
        raiz.setBorder(new EmptyBorder(25, 28, 20, 28));

        // Encabezado
        JLabel marca = etiqueta(
                "ORISONO", 14, Font.BOLD, AZUL);

        JLabel subtitulo = etiqueta(
                "TIME SYSTEM  /  DESKTOP", 10, Font.PLAIN, SUAVE);

        JPanel identidad = new JPanel();
        identidad.setOpaque(false);
        identidad.setLayout(new BoxLayout(
                identidad, BoxLayout.Y_AXIS));

        marca.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        identidad.add(marca);
        identidad.add(Box.createVerticalStrut(5));
        identidad.add(subtitulo);

        // Tarjeta principal
        JPanel tarjeta = new JPanel();
        tarjeta.setBackground(PANEL);
        tarjeta.setLayout(new BoxLayout(
                tarjeta, BoxLayout.Y_AXIS));

        tarjeta.setBorder(new EmptyBorder(25, 15, 25, 15));

        diaSemana = etiqueta("", 20, Font.BOLD, TEXTO);
        numeroDia = etiqueta("", 105, Font.BOLD, AZUL);
        fechaCompleta = etiqueta("", 16, Font.PLAIN, SUAVE);
        reloj = etiqueta("", 34, Font.BOLD, TEXTO);
        saludo = etiqueta("", 13, Font.PLAIN, VERDE);

        tarjeta.add(diaSemana);
        tarjeta.add(Box.createVerticalStrut(2));
        tarjeta.add(numeroDia);
        tarjeta.add(Box.createVerticalStrut(2));
        tarjeta.add(fechaCompleta);
        tarjeta.add(Box.createVerticalStrut(25));
        tarjeta.add(reloj);
        tarjeta.add(Box.createVerticalStrut(12));
        tarjeta.add(saludo);

        // Progreso del año
        JPanel panelProgreso = new JPanel();
        panelProgreso.setOpaque(false);
        panelProgreso.setLayout(new BoxLayout(
                panelProgreso, BoxLayout.Y_AXIS));

        progresoTexto = etiqueta("", 12, Font.PLAIN, SUAVE);

        progreso = new JProgressBar(0, 100);
        progreso.setStringPainted(true);
        progreso.setForeground(AZUL);
        progreso.setBackground(PANEL);
        progreso.setBorderPainted(false);
        progreso.setString("0%");
        progreso.setPreferredSize(new Dimension(400, 12));
        progreso.setMaximumSize(new Dimension(
                Integer.MAX_VALUE, 15));

        panelProgreso.add(progresoTexto);
        panelProgreso.add(Box.createVerticalStrut(10));
        panelProgreso.add(progreso);

        // Pie
        pie = etiqueta(
                "CADA DÍA ES UNA NUEVA OPORTUNIDAD.",
                10, Font.PLAIN, SUAVE);

        JPanel centro = new JPanel(new BorderLayout(0, 20));
        centro.setOpaque(false);
        centro.add(tarjeta, BorderLayout.CENTER);
        centro.add(panelProgreso, BorderLayout.SOUTH);

        raiz.add(identidad, BorderLayout.NORTH);
        raiz.add(centro, BorderLayout.CENTER);
        raiz.add(pie, BorderLayout.SOUTH);

        actualizar();

        Timer temporizador = new Timer(
                1000, e -> actualizar());

        temporizador.start();

        ventana.setContentPane(raiz);
        ventana.setVisible(true);
    }

    private static JLabel etiqueta(
            String texto, int tamano,
            int estilo, Color color) {

        JLabel label = new JLabel(texto);
        label.setFont(new Font(
                "SansSerif", estilo, tamano));
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        return label;
    }

    private static void actualizar() {

        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();

        diaSemana.setText(
                hoy.getDayOfWeek()
                        .getDisplayName(
                                TextStyle.FULL, ES)
                        .toUpperCase(ES));

        numeroDia.setText(
                String.valueOf(hoy.getDayOfMonth()));

        String mes = hoy.getMonth()
                .getDisplayName(TextStyle.FULL, ES);

        fechaCompleta.setText(
                mes.substring(0, 1).toUpperCase(ES)
                        + mes.substring(1)
                        + " de " + hoy.getYear());

        reloj.setText(ahora.format(RELOJ));

        int diaDelAnio = hoy.getDayOfYear();
        int totalDias = Year.of(hoy.getYear()).length();
        int porcentaje = diaDelAnio * 100 / totalDias;

        progreso.setValue(porcentaje);
        progreso.setString(porcentaje + "%");

        progresoTexto.setText(
                "DÍA " + diaDelAnio + " DE " + totalDias
                        + "  ·  PROGRESO DEL AÑO");

        int hora = ahora.getHour();

        if (hora >= 5 && hora < 12) {
            saludo.setText("Buenos días. Construye algo extraordinario.");
            pie.setText("EL FUTURO SE CONSTRUYE PASO A PASO.");
        } else if (hora >= 12 && hora < 19) {
            saludo.setText("Buenas tardes. Sigue avanzando.");
            pie.setText("LA CONSTANCIA SUPERA AL TALENTO SIN DISCIPLINA.");
        } else {
            saludo.setText("Buenas noches. También descansar es avanzar.");
            pie.setText("MAÑANA HABRÁ NUEVAS IDEAS POR EXPLORAR.");
        }
    }
}
