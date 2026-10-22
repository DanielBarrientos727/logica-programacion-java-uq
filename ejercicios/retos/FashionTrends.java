public class FashionTrends {
    public static void main(String[] args) {
        String genero = notas.Reutilizacion.ingresarTexto("Ingrese el género (Femenino/Masculino): ");
        double presupuesto = notas.Reutilizacion.ingresarRealD("Ingrese el presupuesto en pesos: ");
        String estacion = notas.Reutilizacion.ingresarTexto("Ingrese la estación favorita (verano/invierno/...): ");
        
        if (genero.equalsIgnoreCase("Femenino") && presupuesto > 150000 && estacion.equalsIgnoreCase("verano")) {
            System.out.println("Sugerencia de Ropa: Vestidos y ropa ligera adecuada para la primavera o el verano.");
        } else if (genero.equalsIgnoreCase("Masculino") && presupuesto > 200000 && estacion.equalsIgnoreCase("invierno")) {
            System.out.println("Sugerencia de Ropa: Chaquetas y prendas de abrigo adecuadas para el otoño o el invierno.");
        } else {
            System.out.println("No hay recomendaciones específicas bajo los criterios ingresados.");
        }
    }
}