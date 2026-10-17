import javax.swing.JOptionPane;
public class reutilizacionJOptionPane {
    public static void main(String[] args) {
        String mensaje = " ";
    }
    public static String ingresarTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        return texto;
    }
    public static double ingresarRealD(String mensaje) {
        double valorD = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
        return valorD;
    }
    public static double ingresarRealF(String mensaje) {
        double valorF = Float.parseFloat(JOptionPane.showInputDialog(mensaje));
        return valorF;
    }
    public static int ingresarEntero(String mensaje) {
        int valorEntero = Integer.parseInt (JOptionPane.showInputDialog(mensaje));
        return valorEntero;
    }
    public static boolean ingresarBoolean(String mensaje) {
        boolean respuesta = Boolean.parseBoolean (JOptionPane.showInputDialog(mensaje));
        return respuesta;
    }
}