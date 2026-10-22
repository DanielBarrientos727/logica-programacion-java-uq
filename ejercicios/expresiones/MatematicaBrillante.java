public class MatematicaBrillante {
    public static void main(String[] args) {
        int grado = notas.Reutilizacion.ingresarEntero("Ingrese el grado escolar (1 a 6): ");
        int puntaje = notas.Reutilizacion.ingresarEntero("Ingrese el puntaje de habilidad en matemáticas (1 a 5): ");
        
        String grupoAsignado = "No clasificado";
        
        if (grado == 1 || grado == 2) {
            if (puntaje >= 3) grupoAsignado = "Grupo de Primaria - Grupo A";
            else grupoAsignado = "Grupo de Primaria - Grupo B";
        } else if (grado == 3 || grado == 4) {
            if (puntaje >= 4) grupoAsignado = "Grupo de Grado Intermedio - Grupo A";
            else grupoAsignado = "Grupo de Grado Intermedio - Grupo B";
        } else if (grado == 5 || grado == 6) {
            if (puntaje == 5) grupoAsignado = "Grupo de Secundaria - Grupo A";
            else grupoAsignado = "Grupo de Secundaria - Grupo B";
        }
        
        System.out.println("Clasificación del estudiante: " + grupoAsignado);
    }
}