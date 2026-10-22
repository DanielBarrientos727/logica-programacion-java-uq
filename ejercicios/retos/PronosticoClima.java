public class PronosticoClima {
    public static void main(String[] args) {
        double temperatura = notas.Reutilizacion.ingresarRealD("Ingrese la temperatura actual en grados Celsius: ");
        String cielo = notas.Reutilizacion.ingresarTexto("Ingrese el estado del cielo (soleado, nublado, lluvioso): ");
        
        String descripcion = "Clima variable";
        
        if (temperatura > 30 && cielo.equalsIgnoreCase("soleado")) {
            descripcion = "Caluroso y soleado.";
        } else if (temperatura < 10 && (cielo.equalsIgnoreCase("nublado") || cielo.equalsIgnoreCase("lluvioso"))) {
            descripcion = "Frío y nublado/lluvioso.";
        } else if (temperatura >= 10 && temperatura <= 30 && cielo.equalsIgnoreCase("soleado")) {
            descripcion = "Agradable y soleado.";
        }
        
        System.out.println("Descripción del clima: " + descripcion);
    }
}