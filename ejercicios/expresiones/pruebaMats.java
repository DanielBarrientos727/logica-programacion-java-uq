public class pruebaMats {
    static void main(String[] args) {
        String grado = notas.Reutilizacion.ingresarTexto("ingrese el grado escolar del estudiante (primaria, intermedio, secundaria): ");
        double notaHabilidad = notas.Reutilizacion.ingresarRealD("ingrese la habilidad matematica del estudiante de 1 a 5: ");
        String desicion = decidirClasificacion(grado, notaHabilidad);
        generarMensaje(desicion);
    }
    public static String decidirClasificacion(String grado, double notaHabilidad) {
        String mensaje ="";
        if (grado.equalsIgnoreCase("primaria") && notaHabilidad>=3){
            mensaje = " pertenece al Grupo A";
        } else if (grado.equalsIgnoreCase("primaria") && notaHabilidad < 3 ) {
            mensaje = " pertenece al Grupo B";
        } else if (grado.equalsIgnoreCase("intermedio") && notaHabilidad >= 3) {
            mensaje = " pertenece al Grupo A";
        } else if (grado.equalsIgnoreCase("intermedio") && notaHabilidad < 3 ) {
            mensaje = " pertenece al Grupo B";
        } else if(grado.equalsIgnoreCase("secundaria") && notaHabilidad >= 3) {
            mensaje = " pertenece al Grupo A";
        } else if (grado.equalsIgnoreCase("secundaria") && notaHabilidad < 3 ) {
            mensaje = " pertenece al Grupo B";
        } else {
            mensaje = " no es clasificado para esta competencia";
        }
        return mensaje;
    }
    public static void generarMensaje (String desicion) {
        String mensaje = "Profesor, su estudiante" + desicion;
        System.out.println(mensaje);
    }
}