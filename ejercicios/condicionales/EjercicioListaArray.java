
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class EjercicioListaArray {

    public static void main(String[] args) {

        // ==================================================
        // 1. SISTEMA DE GESTIÓN DE UNA ACADEMIA
        // ==================================================

        System.out.println("==========================================");
        System.out.println("     ACADEMIA DE PROGRAMACIÓN JAVA");
        System.out.println("==========================================");

        // Lista dinámica de estudiantes.
        ArrayList<String> names = new ArrayList<>();

        // Lista dinámica de calificaciones.
        ArrayList<Integer> numbers = new ArrayList<>();

        // Reservar capacidad interna para evitar algunas ampliaciones.
        names.ensureCapacity(100);
        numbers.ensureCapacity(100);

        // ==================================================
        // 2. REGISTRAR ESTUDIANTES Y CALIFICACIONES
        // ==================================================

        names.add("Daniel");
        numbers.add(95);

        names.add("Jorge");
        numbers.add(82);

        names.add("Carlos");
        numbers.add(70);

        names.add("Ana");
        numbers.add(98);

        names.add("Luisa");
        numbers.add(88);

        names.add("Andres");
        numbers.add(65);

        // Insertar un estudiante en una posición específica.
        names.add(1, "Sofia");
        numbers.add(1, 91);

        // Añadir un estudiante al principio y otro al final.
        names.addFirst("Valentina");
        numbers.addFirst(100);

        names.addLast("Mateo");
        numbers.addLast(76);

        // ==================================================
        // 3. MOSTRAR INFORMACIÓN GENERAL
        // ==================================================

        System.out.println("\n--- INFORMACIÓN GENERAL ---");

        System.out.println("Estudiantes registrados: " + names.size());
        System.out.println("¿Lista vacía?: " + names.isEmpty());
        System.out.println("Lista de estudiantes: " + names);
        System.out.println("Primer estudiante: " + names.getFirst());
        System.out.println("Último estudiante: " + names.getLast());
        System.out.println("Estudiante en índice 2: " + names.get(2));

        System.out.println("Clase de la lista: " + names.getClass());
        System.out.println("Representación textual: " + names.toString());
        System.out.println("Código hash: " + names.hashCode());

        // ==================================================
        // 4. CONSULTAR Y MODIFICAR REGISTROS
        // ==================================================

        System.out.println("\n--- CONSULTAS Y MODIFICACIONES ---");

        // Comprobar si un estudiante está registrado.
        System.out.println("¿Está Daniel?: " + names.contains("Daniel"));

        // Encontrar la primera y última aparición de un nombre.
        System.out.println("Primer índice de Daniel: "
                + names.indexOf("Daniel"));

        names.add("Daniel");

        System.out.println("Último índice de Daniel: "
                + names.lastIndexOf("Daniel"));

        // Eliminar el Daniel duplicado que acabamos de añadir.
        names.remove(names.size() - 1);

        // Modificar un registro usando su índice.
        int posicionDaniel = names.indexOf("Daniel");

        if (posicionDaniel != -1) {
            names.set(posicionDaniel, "Daniel Barrientos");
        }

        // Reemplazar nombres mediante una expresión lambda.
        names.replaceAll(
                name -> name.equals("Jorge") ? "Jorge Ramirez" : name
        );

        System.out.println("Lista actualizada: " + names);

        // ==================================================
        // 5. RECORRER LOS ESTUDIANTES
        // ==================================================

        System.out.println("\n--- LISTADO DE ESTUDIANTES ---");

        // Recorrido tradicional mediante índices.
        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + names.get(i)
                            + " | Nota: " + numbers.get(i)
            );
        }

        // Recorrido mediante for-each.
        System.out.println("\n--- RECORRIDO SIMPLIFICADO ---");

        for (String name : names) {
            System.out.println(name);
        }

        // Recorrido mediante forEach y una lambda.
        System.out.println("\n--- RECORRIDO CON FOREACH ---");

        names.forEach(name -> System.out.println("Estudiante: " + name));

        // ==================================================
        // 6. ITERADORES
        // ==================================================

        System.out.println("\n--- ITERADOR BIDIRECCIONAL ---");

        ListIterator<String> listIterator = names.listIterator();

        // Recorrer hacia adelante.
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // Recorrer hacia atrás.
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // ==================================================
        // 7. ORDENAR Y REORGANIZAR
        // ==================================================

        System.out.println("\n--- ORDENAMIENTOS ---");

        // Orden alfabético.
        names.sort(null);
        System.out.println("Orden alfabético: " + names);

        // Invertir el orden actual.
        Collections.reverse(names);
        System.out.println("Orden inverso: " + names);

        // Mezclar aleatoriamente los estudiantes.
        Collections.shuffle(names);
        System.out.println("Orden aleatorio: " + names);

        // ==================================================
        // 8. OBTENER UNA PARTE Y CONVERTIR A ARRAY
        // ==================================================

        System.out.println("\n--- SUBLISTA Y CONVERSIÓN ---");

        // Obtener una vista de los primeros tres estudiantes.
        if (names.size() >= 3) {
            System.out.println("Muestra de estudiantes: "
                    + names.subList(0, 3));
        }

        // Convertir el ArrayList en un array tradicional.
        String[] arrayNames = names.toArray(new String[0]);

        System.out.println("Array convertido:");

        for (String name : arrayNames) {
            System.out.println(name);
        }

        // ==================================================
        // 9. SPLITERATOR Y STREAMS
        // ==================================================

        System.out.println("\n--- PROCESAMIENTO DE DATOS ---");

        // Spliterator permite recorrer los elementos.
        var spliterator = names.spliterator();

        spliterator.forEachRemaining(
                name -> System.out.println("Registro: " + name)
        );

        // Contar los estudiantes mediante un Stream.
        long cantidad = names.stream().count();

        System.out.println("Cantidad mediante Stream: " + cantidad);

        // Procesar la lista en paralelo.
        long cantidadParalela = names.parallelStream().count();

        System.out.println("Cantidad mediante ParallelStream: "
                + cantidadParalela);

        // Calcular el promedio de las calificaciones.
        double promedio = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.printf("Promedio de notas: %.2f%n", promedio);

        // Obtener la nota más alta y la más baja.
        int notaMaxima = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        int notaMinima = numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);

        System.out.println("Nota máxima: " + notaMaxima);
        System.out.println("Nota mínima: " + notaMinima);

        // Contar estudiantes aprobados con nota mínima de 70.
        long aprobados = numbers.stream()
                .filter(nota -> nota >= 70)
                .count();

        System.out.println("Estudiantes aprobados: " + aprobados);

        // ==================================================
        // 10. ELIMINAR REGISTROS
        // ==================================================

        System.out.println("\n--- PRUEBAS DE ELIMINACIÓN ---");

        // Creamos una lista independiente para probar eliminaciones.
        ArrayList<String> pruebas = new ArrayList<>();

        pruebas.add("Ana");
        pruebas.add("Carlos");
        pruebas.add("Daniel");
        pruebas.add("Luisa");
        pruebas.add("Andres");

        // Eliminar por índice.
        pruebas.remove(0);

        // Eliminar por valor.
        pruebas.remove("Carlos");

        // Eliminar el primer y último elemento.
        pruebas.removeFirst();
        pruebas.removeLast();

        System.out.println("Después de eliminar: " + pruebas);

        // Eliminar elementos que comienzan por una letra.
        pruebas.removeIf(name -> name.startsWith("A"));

        System.out.println("Después de removeIf: " + pruebas);

        // Eliminar todos los elementos compartidos con otra lista.
        ArrayList<String> eliminar = new ArrayList<>();

        eliminar.add("Daniel");
        eliminar.add("Luisa");

        pruebas.removeAll(eliminar);

        System.out.println("Después de removeAll: " + pruebas);

        // ==================================================
        // 11. COMPARAR LISTAS
        // ==================================================

        System.out.println("\n--- COMPARACIÓN ---");

        ArrayList<String> copia = new ArrayList<>(names);

        // equals() compara los elementos y su orden.
        System.out.println("¿Las listas son iguales?: "
                + names.equals(copia));

        // containsAll() comprueba si una lista contiene otra colección.
        System.out.println("¿La copia contiene todos los nombres?: "
                + copia.containsAll(names));

        // ==================================================
        // 12. CAPACIDAD INTERNA
        // ==================================================

        System.out.println("\n--- CAPACIDAD INTERNA ---");

        // Solicitar espacio interno para al menos 100 elementos.
        names.ensureCapacity(100);

        // Reducir la capacidad interna innecesaria.
        names.trimToSize();

        // ==================================================
        // 13. LIMPIAR Y REINICIAR
        // ==================================================

        System.out.println("\n--- LIMPIEZA DE PRUEBA ---");

        pruebas.clear();

        System.out.println("Lista de pruebas: " + pruebas);
        System.out.println("Cantidad: " + pruebas.size());
        System.out.println("¿Está vacía?: " + pruebas.isEmpty());

        // ==================================================
        // 14. INFORME FINAL
        // ==================================================

        System.out.println("\n==========================================");
        System.out.println("          INFORME DE LA ACADEMIA");
        System.out.println("==========================================");

        System.out.println("Estudiantes registrados: " + names.size());
        System.out.printf("Promedio general: %.2f%n", promedio);
        System.out.println("Nota más alta: " + notaMaxima);
        System.out.println("Nota más baja: " + notaMinima);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Porcentaje de aprobación: "
                + (numbers.isEmpty()
                ? 0.0
                : aprobados * 100.0 / numbers.size()) + "%");

        System.out.println("==========================================");
        System.out.println("     FIN DEL INFORME");
        System.out.println("==========================================");
    }
}
