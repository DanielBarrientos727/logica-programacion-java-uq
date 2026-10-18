public class ejercicioNum2 {
    public static void main(String[] args) {
        int totalEstudiantes = Reutilizacion.ingresarEntero("profesor, por favor escriba la cantidad total de los estudiantes: ");
        int sumaEdades = sumatoriaEdades(totalEstudiantes);
        double promedio = calcularPromedio(totalEstudiantes, sumaEdades);
        generarMensaje(totalEstudiantes, promedio);
    }

    public static int sumatoriaEdades(int totalEstudiantes) {
        int sumaTotal = 0;
        for (int numDelEstudiante = 1; numDelEstudiante <= totalEstudiantes; numDelEstudiante++) {
            int edad = Reutilizacion.ingresarEntero("Profesor, ingrese la edad del estudiante " + numDelEstudiante + ": ");
            sumaTotal = sumaTotal + edad;
        }
        return sumaTotal;
    }

    public static double calcularPromedio(int totalEstudiantes, int sumaEdades) {
        double promedio = 0;
        if (sumaEdades > 0 && totalEstudiantes > 0) {
            promedio = (double) sumaEdades / totalEstudiantes; // Casteo a double para evitar perder decimales
        } else {
            System.out.println("valor invalido");
        }
        return promedio;
    }

    public static void generarMensaje(int totalEstudiantes, double promedio) {
        String mensaje = "la cantidad total de estudiantes es: " + totalEstudiantes +
                "\ny el promedio en las edades es: " + promedio;
        System.out.println(mensaje);
    }
}

