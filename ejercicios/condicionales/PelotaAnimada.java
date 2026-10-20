
import javax.swing.*;
import java.awt.*;
import java.util.Random;

//EJEMPLO HECHO CON CLAUDE SONNET 5.5.

public class PelotaAnimada extends JPanel {

    private static final int TOTAL_PELOTAS = 10;
    private static final int TAMANO = 30;

    private final Pelota[] pelotas = new Pelota[TOTAL_PELOTAS];
    private final Random random = new Random();

    private boolean inicializadas = false;

    private int colisiones = 0;
    private int fps = 0;
    private int frames = 0;

    private long ultimoFPS = System.currentTimeMillis();
    private long ultimoTiempo = System.nanoTime();

    public PelotaAnimada() {
        setBackground(new Color(12, 16, 28));

        Timer timer = new Timer(10, evento -> {
            long ahora = System.nanoTime();

            double deltaTiempo =
                    Math.min((ahora - ultimoTiempo) / 1_000_000_000.0, 0.03);

            ultimoTiempo = ahora;

            if (!inicializadas &&
                    getWidth() > TAMANO &&
                    getHeight() > TAMANO) {

                crearPelotas();
                inicializadas = true;
            }

            if (inicializadas) {
                actualizarPelotas(deltaTiempo);
                resolverColisiones();
                limitarPelotas();
                calcularFPS();
            }

            repaint();
        });

        timer.start();
    }

    // Crear las diez pelotas sin superponerlas inicialmente.
    private void crearPelotas() {
        for (int i = 0; i < TOTAL_PELOTAS; i++) {
            boolean posicionValida = false;
            int intentos = 0;

            while (!posicionValida && intentos < 2000) {
                double x = random.nextDouble() *
                        Math.max(1, getWidth() - TAMANO);

                double y = random.nextDouble() *
                        Math.max(1, getHeight() - TAMANO);

                posicionValida = true;

                for (int j = 0; j < i; j++) {
                    double dx = x - pelotas[j].x;
                    double dy = y - pelotas[j].y;

                    if (dx * dx + dy * dy < TAMANO * TAMANO * 1.15) {
                        posicionValida = false;
                        break;
                    }
                }

                if (posicionValida) {
                    double vx = random.nextDouble() * 240 - 120;
                    double vy = random.nextDouble() * 240 - 120;

                    // Evitar pelotas prácticamente inmóviles.
                    if (Math.abs(vx) < 40) vx = vx < 0 ? -40 : 40;
                    if (Math.abs(vy) < 40) vy = vy < 0 ? -40 : 40;

                    Color color = new Color(
                            random.nextInt(156) + 100,
                            random.nextInt(156) + 100,
                            random.nextInt(156) + 100
                    );

                    pelotas[i] = new Pelota(x, y, vx, vy, color);
                }

                intentos++;
            }

            // Distribución alternativa si no se encuentra espacio.
            if (pelotas[i] == null) {
                double x = (i * 65.0) % Math.max(1, getWidth() - TAMANO);
                double y = (i * 43.0) % Math.max(1, getHeight() - TAMANO);

                pelotas[i] = new Pelota(
                        x, y, 100, 80,
                        new Color(
                                random.nextInt(156) + 100,
                                random.nextInt(156) + 100,
                                random.nextInt(156) + 100
                        )
                );
            }
        }
    }

    // Mover cada pelota según su velocidad.
    private void actualizarPelotas(double dt) {
        for (Pelota p : pelotas) {
            p.x += p.velocidadX * dt;
            p.y += p.velocidadY * dt;
        }
    }

    // Detectar y resolver choques entre todos los pares de pelotas.
    private void resolverColisiones() {
        for (int i = 0; i < TOTAL_PELOTAS; i++) {
            for (int j = i + 1; j < TOTAL_PELOTAS; j++) {

                Pelota a = pelotas[i];
                Pelota b = pelotas[j];

                double dx = b.x - a.x;
                double dy = b.y - a.y;

                double distanciaCuadrada = dx * dx + dy * dy;
                double distanciaMinima = TAMANO;

                if (distanciaCuadrada >= distanciaMinima * distanciaMinima) {
                    continue;
                }

                double distancia = Math.sqrt(distanciaCuadrada);

                // Evitar divisiones por cero.
                if (distancia < 0.0001) {
                    dx = 1;
                    dy = 0;
                    distancia = 1;
                }

                // Vector normal del choque.
                double nx = dx / distancia;
                double ny = dy / distancia;

                // Separar las pelotas para eliminar la superposición.
                double superposicion = distanciaMinima - distancia;
                double separacion = superposicion / 2.0 + 0.01;

                a.x -= nx * separacion;
                a.y -= ny * separacion;

                b.x += nx * separacion;
                b.y += ny * separacion;

                // Velocidad relativa.
                double velocidadRelativaX = b.velocidadX - a.velocidadX;
                double velocidadRelativaY = b.velocidadY - a.velocidadY;

                double velocidadNormal =
                        velocidadRelativaX * nx +
                                velocidadRelativaY * ny;

                // Modificar velocidades únicamente si se están acercando.
                if (velocidadNormal < 0) {
                    a.velocidadX += velocidadNormal * nx;
                    a.velocidadY += velocidadNormal * ny;

                    b.velocidadX -= velocidadNormal * nx;
                    b.velocidadY -= velocidadNormal * ny;

                    colisiones++;
                }
            }
        }
    }

    // Rebotar contra los límites de la ventana.
    private void limitarPelotas() {
        int ancho = getWidth();
        int alto = getHeight();

        for (Pelota p : pelotas) {
            if (p.x < 0) {
                p.x = 0;
                p.velocidadX = Math.abs(p.velocidadX);
            }

            if (p.x + TAMANO > ancho) {
                p.x = Math.max(0, ancho - TAMANO);
                p.velocidadX = -Math.abs(p.velocidadX);
            }

            if (p.y < 0) {
                p.y = 0;
                p.velocidadY = Math.abs(p.velocidadY);
            }

            if (p.y + TAMANO > alto) {
                p.y = Math.max(0, alto - TAMANO);
                p.velocidadY = -Math.abs(p.velocidadY);
            }
        }
    }

    private void calcularFPS() {
        frames++;

        long ahora = System.currentTimeMillis();

        if (ahora - ultimoFPS >= 1000) {
            fps = frames;
            frames = 0;
            ultimoFPS = ahora;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Cuadrícula de fondo.
        g2.setColor(new Color(27, 34, 50));

        for (int x = 0; x < getWidth(); x += 40) {
            g2.drawLine(x, 0, x, getHeight());
        }

        for (int y = 0; y < getHeight(); y += 40) {
            g2.drawLine(0, y, getWidth(), y);
        }

        // Dibujar pelotas, sombras y reflejos.
        if (inicializadas) {
            for (Pelota p : pelotas) {
                int x = (int) p.x;
                int y = (int) p.y;

                g2.setColor(new Color(0, 0, 0, 100));
                g2.fillOval(x + 4, y + 5, TAMANO, TAMANO);

                g2.setColor(p.color);
                g2.fillOval(x, y, TAMANO, TAMANO);

                g2.setColor(new Color(255, 255, 255, 180));
                g2.fillOval(x + 6, y + 5, 8, 8);
            }
        }

        // Información de la simulación.
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, 17));
        g2.drawString("SIMULACION FISICA", 20, 30);

        g2.setFont(new Font("Monospaced", Font.PLAIN, 13));
        g2.setColor(new Color(150, 220, 255));
        g2.drawString("Pelotas: " + TOTAL_PELOTAS, 20, 52);
        g2.drawString("Colisiones: " + colisiones, 20, 71);
        g2.drawString("FPS: " + fps, 20, 90);

        g2.dispose();
    }

    private static class Pelota {
        double x;
        double y;
        double velocidadX;
        double velocidadY;
        Color color;

        Pelota(double x, double y,
               double velocidadX, double velocidadY,
               Color color) {
            this.x = x;
            this.y = y;
            this.velocidadX = velocidadX;
            this.velocidadY = velocidadY;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Java Swing | Colisiones");

            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(900, 650);
            ventana.setMinimumSize(new Dimension(450, 350));
            ventana.setLocationRelativeTo(null);
            ventana.setContentPane(new PelotaAnimada());
            ventana.setVisible(true);
        });
    }
}
