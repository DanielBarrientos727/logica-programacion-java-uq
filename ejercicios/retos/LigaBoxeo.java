public class LigaBoxeo {
    public static void main(String[] args) {
        double peso = notas.Reutilizacion.ingresarRealD("Ingrese el peso del luchador en kg: ");
        String categoria = determinarCategoriaBoxeo(peso);
        System.out.println("La categoría a la que pertenece el luchador es: " + categoria);
    }

    public static String determinarCategoriaBoxeo(double peso) {
        String categoria;
        if (peso <= 47) {
            categoria = "Mínimo";
        } else if (peso <= 52) {
            categoria = "Mosca";
        } else if (peso <= 55) {
            categoria = "Gallo";
        } else if (peso <= 64) {
            categoria = "Pluma";
        } else if (peso <= 77) {
            categoria = "Mediano";
        } else if (peso <= 90) {
            categoria = "Crucero";
        } else {
            categoria = "Pesado";
        }
        return categoria;
    }
}