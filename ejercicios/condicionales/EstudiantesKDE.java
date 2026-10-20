import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

//EJEMPLO HECHO CON CLAUDE SONNET 5.5.
public class EstudiantesKDE extends JFrame {

    private final ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"Código", "Nombre", "Carrera", "Promedio"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable tabla = new JTable(modelo);
    private final TableRowSorter<DefaultTableModel> ordenador =
            new TableRowSorter<>(modelo);

    private final JTextField codigo = new JTextField();
    private final JTextField nombre = new JTextField();
    private final JTextField carrera = new JTextField();
    private final JTextField promedio = new JTextField();
    private final JTextField buscar = new JTextField();
    private final JLabel contador = new JLabel();
    private final JLabel estado = new JLabel("Listo. Selecciona un registro o crea uno nuevo.");

    public EstudiantesKDE() {
        super("Estudiantes | Plasma Classic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(850, 570));
        setSize(1050, 680);
        setLocationRelativeTo(null);

        crearDatosDemo();
        configurarTabla();
        construirInterfaz();
        actualizarContador();
    }

    private void crearDatosDemo() {
        agregarDatoInicial(new Estudiante("1001", "Ana Torres", "Ingeniería de Sistemas", 4.6));
        agregarDatoInicial(new Estudiante("1002", "Mateo Ríos", "Ingeniería Electrónica", 4.2));
        agregarDatoInicial(new Estudiante("1003", "Camila Gómez", "Diseño Visual", 4.8));
    }

    private void agregarDatoInicial(Estudiante e) {
        estudiantes.add(e);
        modelo.addRow(fila(e));
    }

    private void configurarTabla() {
        tabla.setRowSorter(ordenador);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(29);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tabla.setForeground(new Color(35, 55, 70));
        tabla.setBackground(new Color(248, 252, 255));
        tabla.setSelectionBackground(new Color(49, 143, 201));
        tabla.setSelectionForeground(Color.WHITE);
        tabla.setShowVerticalLines(false);
        tabla.setGridColor(new Color(220, 236, 245));
        tabla.setFillsViewportHeight(true);
        tabla.setIntercellSpacing(new Dimension(0, 1));
        tabla.setAutoCreateRowSorter(false);

        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setReorderingAllowed(false);
        encabezado.setPreferredSize(new Dimension(0, 34));
        encabezado.setFont(new Font("SansSerif", Font.BOLD, 12));
        encabezado.setBackground(new Color(35, 103, 145));
        encabezado.setForeground(Color.WHITE);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(190);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(75);

        tabla.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) cargarSeleccion();
        });
    }

    private void construirInterfaz() {
        GradientPanel fondo = new GradientPanel(
                new Color(12, 39, 62), new Color(20, 91, 126));
        fondo.setLayout(new BorderLayout(0, 15));
        fondo.setBorder(new EmptyBorder(16, 16, 12, 16));
        setContentPane(fondo);

        fondo.add(crearCabecera(), BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout(14, 0));
        centro.setOpaque(false);
        centro.add(crearFormulario(), BorderLayout.WEST);
        centro.add(crearTabla(), BorderLayout.CENTER);
        fondo.add(centro, BorderLayout.CENTER);
        fondo.add(crearBarraEstado(), BorderLayout.SOUTH);

        buscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { filtrar(); }
            @Override public void removeUpdate(DocumentEvent e) { filtrar(); }
            @Override public void changedUpdate(DocumentEvent e) { filtrar(); }
        });
    }

    private JComponent crearCabecera() {
        JPanel cabecera = new JPanel(new BorderLayout(12, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new GradientPaint(0, 0, new Color(42, 167, 220),
                        0, getHeight(), new Color(25, 93, 153)));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
                g2.setColor(new Color(255, 255, 255, 80));
                g2.drawLine(14, 2, getWidth() - 14, 2);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        cabecera.setOpaque(false);
        cabecera.setBorder(new EmptyBorder(15, 20, 15, 20));

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Gestor de estudiantes");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 25));
        titulo.setForeground(Color.WHITE);

        JLabel subtitulo = new JLabel("Un CRUD pequeño, con espíritu Plasma y brillo de los 2000");
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitulo.setForeground(new Color(220, 246, 255));

        textos.add(titulo);
        textos.add(Box.createVerticalStrut(4));
        textos.add(subtitulo);
        cabecera.add(textos, BorderLayout.CENTER);

        JLabel marca = new JLabel("KDE 4  ◈", SwingConstants.CENTER);
        marca.setFont(new Font("SansSerif", Font.BOLD, 16));
        marca.setForeground(Color.WHITE);
        marca.setBorder(new LineBorder(new Color(210, 246, 255, 150), 1, true));
        marca.setPreferredSize(new Dimension(105, 38));
        cabecera.add(marca, BorderLayout.EAST);
        return cabecera;
    }

    private JComponent crearFormulario() {
        GlassPanel panel = new GlassPanel();
        panel.setPreferredSize(new Dimension(285, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(18, 17, 17, 17));

        JLabel titulo = new JLabel("Registro");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setForeground(new Color(26, 87, 119));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(5));

        JLabel ayuda = new JLabel("Completa los datos del estudiante.");
        ayuda.setFont(new Font("SansSerif", Font.PLAIN, 11));
        ayuda.setForeground(new Color(92, 119, 133));
        ayuda.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(ayuda);
        panel.add(Box.createVerticalStrut(19));

        agregarCampo(panel, "Código", codigo);
        agregarCampo(panel, "Nombre completo", nombre);
        agregarCampo(panel, "Carrera", carrera);
        agregarCampo(panel, "Promedio (0.0 a 5.0)", promedio);

        panel.add(Box.createVerticalStrut(12));

        KdeButton guardar = new KdeButton("Guardar nuevo", new Color(31, 156, 195));
        KdeButton actualizar = new KdeButton("Actualizar seleccionado", new Color(48, 130, 178));
        KdeButton eliminar = new KdeButton("Eliminar seleccionado", new Color(190, 83, 91));
        KdeButton limpiar = new KdeButton("Limpiar formulario", new Color(100, 128, 145));

        guardar.addActionListener(e -> guardarEstudiante());
        actualizar.addActionListener(e -> actualizarEstudiante());
        eliminar.addActionListener(e -> eliminarEstudiante());
        limpiar.addActionListener(e -> limpiarFormulario());

        agregarBoton(panel, guardar);
        agregarBoton(panel, actualizar);
        agregarBoton(panel, eliminar);
        agregarBoton(panel, limpiar);

        panel.add(Box.createVerticalGlue());

        JLabel pista = new JLabel("Tip: selecciona una fila para editarla.");
        pista.setFont(new Font("SansSerif", Font.ITALIC, 11));
        pista.setForeground(new Color(88, 119, 135));
        pista.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(pista);
        return panel;
    }

    private void agregarCampo(JPanel panel, String etiqueta, JTextField campo) {
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(new Color(42, 76, 94));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 33));
        campo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        campo.setForeground(new Color(31, 54, 68));
        campo.setBackground(new Color(250, 254, 255));
        campo.setCaretColor(new Color(0, 135, 190));
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(153, 207, 228), 1, true),
                new EmptyBorder(6, 9, 6, 9)));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalStrut(5));
        panel.add(campo);
        panel.add(Box.createVerticalStrut(12));
    }

    private void agregarBoton(JPanel panel, JButton boton) {
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 37));
        boton.setPreferredSize(new Dimension(250, 37));
        panel.add(boton);
        panel.add(Box.createVerticalStrut(8));
    }

    private JComponent crearTabla() {
        GlassPanel panel = new GlassPanel();
        panel.setLayout(new BorderLayout(0, 12));
        panel.setBorder(new EmptyBorder(17, 17, 14, 17));

        JPanel superior = new JPanel(new BorderLayout(10, 0));
        superior.setOpaque(false);
        JLabel titulo = new JLabel("Estudiantes registrados");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 19));
        titulo.setForeground(new Color(26, 87, 119));
        superior.add(titulo, BorderLayout.WEST);

        buscar.setToolTipText("Buscar por código, nombre, carrera o promedio");
        buscar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        buscar.setPreferredSize(new Dimension(200, 32));
        buscar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(153, 207, 228), 1, true),
                new EmptyBorder(5, 9, 5, 9)));
        buscar.setBackground(new Color(250, 254, 255));
        buscar.setForeground(new Color(31, 54, 68));
        superior.add(buscar, BorderLayout.EAST);
        panel.add(superior, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(new LineBorder(new Color(180, 218, 235), 1, true));
        scroll.getViewport().setBackground(new Color(248, 252, 255));
        panel.add(scroll, BorderLayout.CENTER);

        JPanel pie = new JPanel(new BorderLayout());
        pie.setOpaque(false);
        contador.setFont(new Font("SansSerif", Font.BOLD, 12));
        contador.setForeground(new Color(31, 105, 143));
        pie.add(contador, BorderLayout.WEST);

        JLabel memoria = new JLabel("Solo en memoria");
        memoria.setFont(new Font("SansSerif", Font.ITALIC, 11));
        memoria.setForeground(new Color(103, 128, 139));
        pie.add(memoria, BorderLayout.EAST);
        panel.add(pie, BorderLayout.SOUTH);
        return panel;
    }

    private JComponent crearBarraEstado() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setOpaque(false);
        estado.setFont(new Font("SansSerif", Font.PLAIN, 11));
        estado.setForeground(new Color(221, 241, 250));
        barra.add(estado, BorderLayout.WEST);

        JLabel pie = new JLabel("Java Swing  •  ArrayList  •  JTable");
        pie.setFont(new Font("SansSerif", Font.PLAIN, 11));
        pie.setForeground(new Color(183, 222, 239));
        barra.add(pie, BorderLayout.EAST);
        return barra;
    }

    private void guardarEstudiante() {
        Estudiante nuevo = leerFormulario();
        if (nuevo == null) return;

        for (Estudiante e : estudiantes) {
            if (e.codigo.equalsIgnoreCase(nuevo.codigo)) {
                mensaje("Ya existe un estudiante con ese código.", JOptionPane.WARNING_MESSAGE);
                codigo.requestFocusInWindow();
                return;
            }
        }

        estudiantes.add(nuevo);
        modelo.addRow(fila(nuevo));
        actualizarContador();
        limpiarFormulario();
        estado.setText("Estudiante guardado correctamente.");
    }

    private void actualizarEstudiante() {
        int filaVista = tabla.getSelectedRow();
        if (filaVista < 0) {
            mensaje("Selecciona una fila de la tabla para actualizarla.", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int filaModelo = tabla.convertRowIndexToModel(filaVista);
        Estudiante editado = leerFormulario();
        if (editado == null) return;

        for (int i = 0; i < estudiantes.size(); i++) {
            if (i != filaModelo && estudiantes.get(i).codigo.equalsIgnoreCase(editado.codigo)) {
                mensaje("Ese código ya pertenece a otro estudiante.", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        estudiantes.set(filaModelo, editado);
        for (int columna = 0; columna < 4; columna++) {
            modelo.setValueAt(fila(editado)[columna], filaModelo, columna);
        }
        actualizarContador();
        limpiarFormulario();
        estado.setText("Registro actualizado correctamente.");
    }

    private void eliminarEstudiante() {
        int filaVista = tabla.getSelectedRow();
        if (filaVista < 0) {
            mensaje("Selecciona una fila de la tabla para eliminarla.", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Eliminar el estudiante seleccionado?", "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirmacion != JOptionPane.YES_OPTION) return;

        int filaModelo = tabla.convertRowIndexToModel(filaVista);
        estudiantes.remove(filaModelo);
        modelo.removeRow(filaModelo);
        actualizarContador();
        limpiarFormulario();
        estado.setText("Registro eliminado.");
    }

    private Estudiante leerFormulario() {
        String id = codigo.getText().trim();
        String nom = nombre.getText().trim();
        String car = carrera.getText().trim();
        String textoPromedio = promedio.getText().trim().replace(',', '.');

        if (id.isEmpty() || nom.isEmpty() || car.isEmpty() || textoPromedio.isEmpty()) {
            mensaje("Completa todos los campos antes de guardar.", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        try {
            double nota = Double.parseDouble(textoPromedio);
            if (nota < 0 || nota > 5) {
                mensaje("El promedio debe estar entre 0.0 y 5.0.", JOptionPane.WARNING_MESSAGE);
                return null;
            }
            return new Estudiante(id, nom, car, nota);
        } catch (NumberFormatException ex) {
            mensaje("El promedio debe ser un número, por ejemplo 4.5.", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    private Object[] fila(Estudiante e) {
        return new Object[]{e.codigo, e.nombre, e.carrera, String.format(java.util.Locale.US, "%.1f", e.promedio)};
    }

    private void cargarSeleccion() {
        int filaVista = tabla.getSelectedRow();
        if (filaVista < 0) return;
        int filaModelo = tabla.convertRowIndexToModel(filaVista);
        if (filaModelo < 0 || filaModelo >= estudiantes.size()) return;

        Estudiante e = estudiantes.get(filaModelo);
        codigo.setText(e.codigo);
        nombre.setText(e.nombre);
        carrera.setText(e.carrera);
        promedio.setText(String.format(java.util.Locale.US, "%.1f", e.promedio));
        estado.setText("Editando: " + e.nombre);
    }

    private void limpiarFormulario() {
        codigo.setText("");
        nombre.setText("");
        carrera.setText("");
        promedio.setText("");
        tabla.clearSelection();
        codigo.requestFocusInWindow();
    }

    private void filtrar() {
        String texto = buscar.getText().trim();
        if (texto.isEmpty()) {
            ordenador.setRowFilter(null);
        } else {
            ordenador.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(texto)));
        }
    }

    private void actualizarContador() {
        contador.setText("" + estudiantes.size() + " estudiante(s)");
    }

    private void mensaje(String texto, int tipo) {
        JOptionPane.showMessageDialog(this, texto, "Gestor de estudiantes", tipo);
    }

    private static class Estudiante {
        String codigo;
        String nombre;
        String carrera;
        double promedio;

        Estudiante(String codigo, String nombre, String carrera, double promedio) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.carrera = carrera;
            this.promedio = promedio;
        }
    }

    private static class GradientPanel extends JPanel {
        private final Color arriba;
        private final Color abajo;

        GradientPanel(Color arriba, Color abajo) {
            this.arriba = arriba;
            this.abajo = abajo;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(0, 0, arriba, 0, getHeight(), abajo));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
            super.paintComponent(g);
        }
    }

    private static class GlassPanel extends JPanel {
        GlassPanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(new GradientPaint(0, 0, new Color(255, 255, 255, 247),
                    0, getHeight(), new Color(226, 245, 253, 238)));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
            g2.setColor(new Color(255, 255, 255, 180));
            g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 17, 17);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    private static class KdeButton extends JButton {
        private final Color base;

        KdeButton(String texto, Color base) {
            super(texto);
            this.base = base;
            setFont(new Font("SansSerif", Font.BOLD, 12));
            setForeground(Color.WHITE);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setOpaque(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setBorder(new EmptyBorder(8, 12, 8, 12));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Color arriba = base.brighter();
            Color abajo = base.darker();
            if (getModel().isPressed()) {
                arriba = base.darker();
                abajo = base.darker().darker();
            } else if (getModel().isRollover()) {
                arriba = base.brighter().brighter();
                abajo = base;
            }

            g2.setPaint(new GradientPaint(0, 0, arriba, 0, getHeight(), abajo));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
            g2.setColor(new Color(255, 255, 255, 115));
            g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 11, 11);
            g2.drawLine(9, 3, getWidth() - 10, 3);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                // Swing usa el tema predeterminado si el tema del sistema no está disponible.
            }
            new EstudiantesKDE().setVisible(true);
        });
    }
}
