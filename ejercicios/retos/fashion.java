public class fashion {
    static void main(String[] args) {
        String genero = notas.Reutilizacion.ingresarTexto("Cliente, ingrese su genero: ");
        double presupuesto = notas.Reutilizacion.ingresarRealD("Clinete, ingrese su presupuesto: ");
        String estacionFav = notas.Reutilizacion.ingresarTexto("Cliente, cual es su estacion favorita? verano o invierno? ");
        String decision = recomendacion(genero, presupuesto, estacionFav);
        generarMensaje(decision);
    }

    public static String recomendacion(String genero, double presupuesto, String desicion) {
        String mensaje = "";
        if (genero.equalsIgnoreCase("mujer") || genero.equalsIgnoreCase("hombre")) {
            if (presupuesto > 150000 && desicion.equalsIgnoreCase("verano")) {
                mensaje = "Vestidos y ropa ligera, adecuada para primavera o el verano";
            } else if (presupuesto > 200000 && desicion.equalsIgnoreCase("invierno")) {
                mensaje = "Chaqueta y prendas de abrigo adecuadas para el otoÃ±o y el invierno";
            } else {
                mensaje = "saldo insuficiente";
            }
        } else {
            mensaje = "genero inexistente.";
        }
        return mensaje;
    }

    public static void generarMensaje(String decision) {
        String mensaje = "Querido cliente, las mejores prendas de ropa para usted son: " + decision;
        System.out.println(mensaje);
    }
}