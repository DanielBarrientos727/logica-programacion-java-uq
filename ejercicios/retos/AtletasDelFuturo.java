public class AtletasDelFuturo {
    public static void main(String[] args) {
        String nombre = notas.Reutilizacion.ingresarTexto("Ingrese el nombre del estudiante: ");
        int edad = notas.Reutilizacion.ingresarEntero("Ingrese la edad: ");
        double tiempo100m = notas.Reutilizacion.ingresarRealD("Ingrese el tiempo en 100m (segundos): ");
        int abdominales = notas.Reutilizacion.ingresarEntero("Ingrese el número de abdominales en un minuto: ");
        int flexiones = notas.Reutilizacion.ingresarEntero("Ingrese la cantidad de flexiones de pecho: ");
        
        int puntosCarrera = (tiempo100m <= 12) ? 50 : (tiempo100m <= 15 ? 30 : 10);
        int puntosAbdominales = (abdominales >= 40) ? 30 : (abdominales >= 20 ? 20 : 10);
        int puntosFlexiones = (flexiones >= 30) ? 20 : (flexiones >= 15 ? 10 : 5);
        
        int puntajeTotal = puntosCarrera + puntosAbdominales + puntosFlexiones;
        
        String nivel;
        if (puntajeTotal >= 80 && edad >= 15) {
            nivel = "Nivel Alto";
        } else if (puntajeTotal >= 50 && puntajeTotal <= 79) {
            nivel = "Nivel Medio";
        } else {
            nivel = "Nivel Bajo";
        }
        
        System.out.println("\n--- INFORME DE RENDIMIENTO FÍSICO ---");
        System.out.println("Estudiante: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Puntaje Total: " + puntajeTotal);
        System.out.println("Clasificación: " + nivel);
    }
}