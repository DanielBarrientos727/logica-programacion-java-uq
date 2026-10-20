
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ListaArray {

    public static void main(String[] args) {

        // ==================================================
        // 1. DECLARACIÓN Y CREACIÓN
        // ==================================================

        // ArrayList almacena elementos en una lista de tamaño dinámico.
        // No es necesario definir una cantidad fija de posiciones.
        ArrayList<String> names = new ArrayList<>();

        // var permite que Java infiera el tipo automáticamente.
        var numbers = new ArrayList<Integer>();

        // int es un tipo primitivo e Integer es su clase envolvente.
        // ArrayList almacena objetos, por eso utilizamos Integer.

        // ==================================================
        // 2. CONSULTAR INFORMACIÓN
        // ==================================================

        System.out.println(names.size());       // Cantidad de elementos: 0.
        System.out.println(names.isEmpty());    // true: está vacía.
        System.out.println(names.getClass());   // Clase del objeto.
        System.out.println(names.toString());   // Representación textual: [].
        System.out.println(names.hashCode());   // Código hash de la lista.

        // ==================================================
        // 3. AÑADIR ELEMENTOS
        // ==================================================

        // add() añade elementos al final de la lista.
        names.add("Daniel");
        names.add("Jorge");
        names.add("Carlos");

        System.out.println(names);              // [Daniel, Jorge, Carlos].
        System.out.println(names.size());       // 3 elementos.

        names.add("Ana");                       // Añade al final.
        names.add(1, "Pedro");                  // Inserta en el índice 1.
        names.addFirst("Inicio");               // Añade al principio.
        names.addLast("Final");                 // Añade al final.

        // Añadir todos los elementos de otra colección.
        ArrayList<String> otros = new ArrayList<>();

        otros.add("Luisa");
        otros.add("Andrés");

        names.addAll(otros);                    // Añade todos al final.
        names.addAll(0, otros);                 // Los inserta desde el índice 0.

        // ==================================================
        // 4. ACCEDER A LOS ELEMENTOS
        // ==================================================

        System.out.println(names.get(0));       // Obtiene el índice 0.
        System.out.println(names.getFirst());   // Primer elemento.
        System.out.println(names.getLast());    // Último elemento.
        System.out.println(names.get(1));       // Elemento del índice 1.

        // Los índices empiezan en 0.
        // Si el índice no existe, se produce IndexOutOfBoundsException.

        // ==================================================
        // 5. MODIFICAR ELEMENTOS
        // ==================================================

        names.set(0, "Jorge");                  // Reemplaza el índice 0.

        // replaceAll() transforma los elementos mediante una lambda.
        // Si encuentra "Daniel", lo reemplaza por "Jorge".
        names.replaceAll(
                name -> name.equals("Daniel") ? "Jorge" : name
        );

        System.out.println(names);

        // ==================================================
        // 6. BUSCAR ELEMENTOS
        // ==================================================

        System.out.println(names.contains("Daniel"));
        // true si contiene Daniel; false en caso contrario.

        System.out.println(names.indexOf("Daniel"));
        // Índice de la primera coincidencia; -1 si no existe.

        System.out.println(names.lastIndexOf("Jorge"));
        // Índice de la última coincidencia; -1 si no existe.

        // ==================================================
        // 7. ELIMINAR ELEMENTOS
        // ==================================================

        names.remove(0);                        // Elimina por índice.
        names.remove("Daniel");                 // Elimina la primera coincidencia.

        names.removeFirst();                    // Elimina el primero.
        names.removeLast();                     // Elimina el último.

        names.removeAll(otros);                 // Elimina los elementos de otros.
        names.removeIf(name -> name.startsWith("A"));
        // Elimina los elementos cuyos nombres empiezan por A.

        // ==================================================
        // 8. RECORRER LA LISTA
        // ==================================================

        // forEach() ejecuta una acción por cada elemento.
        names.forEach(name -> System.out.println(name));

        // Recorrido mediante un for tradicional.
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // Recorrido mediante for-each.
        for (String name : names) {
            System.out.println(name);
        }

        // Iterator permite recorrer la lista elemento por elemento.
        var iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // ==================================================
        // 9. ORDENAR Y REORGANIZAR
        // ==================================================

        names.sort(null);                       // Orden natural alfabético.
        Collections.reverse(names);             // Invierte el orden actual.
        Collections.shuffle(names);              // Mezcla aleatoriamente.

        // ==================================================
        // 10. OBTENER PARTES Y CONVERTIR
        // ==================================================

        // subList() devuelve una vista de una parte de la lista.
        // El índice inicial se incluye y el final se excluye.
        if (names.size() >= 2) {
            System.out.println(names.subList(0, 2));
        }

        // Convierte la lista en un array de String.
        String[] arrayNames = names.toArray(new String[0]);

        // Iterador bidireccional: permite avanzar y retroceder.
        ListIterator<String> listIterator = names.listIterator();

        // Permite recorrer y dividir elementos para procesarlos.
        var spliterator = names.spliterator();

        // Streams permiten procesar colecciones.
        long cantidad = names.stream().count();
        System.out.println(cantidad);

        // Puede procesar elementos en paralelo.
        long cantidadParalela = names.parallelStream().count();
        System.out.println(cantidadParalela);

        // ==================================================
        // 11. CAPACIDAD INTERNA
        // ==================================================

        names.ensureCapacity(100);
        // Solicita capacidad interna para al menos 100 elementos.
        // No añade elementos a la lista.

        names.trimToSize();
        // Ajusta la capacidad interna al tamaño actual.

        // ==================================================
        // 12. COMPARAR, LIMPIAR Y REINICIAR
        // ==================================================

        System.out.println(names.equals(otros));
        // Compara si ambas listas tienen los mismos elementos en el mismo orden.

        names.clear();                          // Elimina todos los elementos.

        System.out.println(names.size());       // 0.
        System.out.println(names.isEmpty());    // true.

        names.addFirst("pan");                  // Añade al principio.
        System.out.println(names.get(0));       // Imprime pan.
        System.out.println(names);              // Imprime [pan].

        // ==================================================
        // 13. MÉTODOS HEREDADOS Y OTROS
        // ==================================================

        System.out.println(names.getClass());   // Identifica la clase.
        System.out.println(names.toString());   // Representación textual.

        // equals() compara objetos.
        // hashCode() devuelve un código hash.
        // clone() no es accesible directamente mediante names.clone()
        // porque ArrayList expone una implementación protegida de ese método.

        // notify(), notifyAll() y wait() son métodos de Object.
        // Se utilizan para sincronización entre hilos.
        // No los ejecutamos aquí porque requieren conocer los monitores.

        // ==================================================
        // 14. EJEMPLOS DE ERRORES COMUNES
        // ==================================================

        // names.getClass(1);
        // Error de compilación: getClass() no recibe argumentos.

        // System.out.println(names.get(1));
        // En este punto sí existe el índice 1, porque la lista contiene "pan"
        // únicamente en el índice 0. Por tanto, esta línea produciría
        // IndexOutOfBoundsException.

        // names.get(0) es la forma correcta de obtener "pan".
    }
}
