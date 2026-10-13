public class ComparacionPlatos {
    public static void main(String[] args) {
        double plato1 = Reutilizacion.ingresarRealD("Ingrese la calificación del plato A: ");
        double plato2 = Reutilizacion.ingresarRealD("Ingrese la calificación del plato B: ");
        generarMensajeRelacion(plato1, plato2);
    }

    public static void generarMensajeRelacion(double platoA, double platoB) {
        String mensaje;
        if (platoA > platoB) {
            mensaje = "El plato A tiene mejor calificación que el plato B.";
        } else if (platoB > platoA) {
            mensaje = "El plato B tiene mejor calificación que el plato A.";
        } else {
            mensaje = "El plato A tiene la misma calificación que el plato B.";
        }
        System.out.println(mensaje);
    }
}