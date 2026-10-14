public class robot {
    
    public static void main(String[] args) {
        double limite = Reutilizacion.ingresarReal("Ingrese el límite de la altura: ");
        int dias = calcularDias(limite);
        generarMensajeRobot(dias);
    }
}