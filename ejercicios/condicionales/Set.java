
import java.util.HashSet;

public class Set {
    public static void main(String[] args) {

        // Declaración y creación de un HashSet
        HashSet<String> names = new HashSet<>();

        // Uso de var para inferir el tipo de la variable
        var numbers = new HashSet<Integer>();

        // Consultar el tamaño inicial del conjunto
        System.out.println(names.size());

        // Agregar elementos al conjunto
        names.add("Daniel");
        names.add("Alejandro");
        names.add("Daniel"); // No admite elementos duplicados
        names.add("DanielAlejandroBarrientos7272@gmail.com");

        // HashSet no garantiza el orden de los elementos
        // No es la estructura adecuada si necesitamos mantener un orden específico

        // Consultar el tamaño después de agregar los elementos
        System.out.println(names.size());

        // Agregar elementos numéricos al conjunto
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // El número 10 solo se almacena una vez

        // Consultar el tamaño del conjunto numérico
        System.out.println(numbers.size());

        // Mostrar los elementos de ambos conjuntos
        System.out.println("Nombres: " + names);
        System.out.println("Números: " + numbers);

        // Eliminar un elemento del conjunto
        names.remove("Daniel");
        System.out.println(names.size());

        /*
         * HashSet no permite acceder a los elementos mediante índices.
         * Métodos como get(0), get(1), getFirst() y getLast()
         * no están disponibles en HashSet.
         * ArrayList sí permite acceder a los elementos mediante índices.
         */

        // Comprobar si un elemento existe en el conjunto
        System.out.println(names.contains("Daniel"));    // false
        System.out.println(names.contains("Alejandro")); // true

        // HashSet suele ofrecer búsquedas, inserciones y eliminaciones
        // en tiempo promedio O(1), aunque depende de las condiciones.
        // ArrayList permite acceso por índice en tiempo O(1),
        // pero buscar un elemento por su valor suele requerir O(n).

        // Consultar el tamaño actual del conjunto
        names.size();

        // Usar HashSet cuando necesitamos elementos únicos.
        // Usar ArrayList cuando necesitamos conservar el orden de inserción
        // y permitir elementos duplicados.

        System.out.println(names);

        // Intentar agregar el mismo elemento varias veces
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel");
        names.add("Daniel"); // Los elementos duplicados no se agregan.

        // HashSet utiliza hashCode() y equals() para determinar
        // si dos elementos son iguales.

        System.out.println(names);

        // Agregar elementos al conjunto numérico
        numbers.add(1);
        numbers.add(2);

        // No podemos agregar directamente numbers a names mediante addAll(),
        // porque names almacena String y numbers almacena Integer.

        // Crear un conjunto de países
        var paises = new HashSet<String>();
        paises.add("Mexico");
        paises.add("Venezuela");
        paises.add("Cuba");
        paises.add("Daniel");

        // Agregar a names todos los elementos de paises
        names.addAll(paises);

        // Mostrar el conjunto names después de combinar ambos conjuntos
        System.out.println(names);

        // removeAll(paises) eliminaría de names todos los elementos
        // que también estén presentes en paises.
        // names.removeAll(paises);

        // retainAll(paises) conserva únicamente los elementos de names
        // que también estén presentes en paises.
        names.retainAll(paises);

        // Mostrar el resultado de la intersección de ambos conjuntos
        System.out.println(names);


        // =========================================================
        // EXPLORACIÓN DE MÉTODOS DE HASHSET
        // Escribe names. o numbers. en el IDE para ver el autocompletado.
        // =========================================================

        // 1. add(element): agrega un elemento si no existe.
        names.add("Prueba");

        // 2. addAll(collection): agrega todos los elementos de otra colección.
        names.addAll(paises);

        // 3. contains(element): comprueba si existe un elemento.
        names.contains("Daniel");

        // 4. containsAll(collection): comprueba si contiene todos los elementos.
        names.containsAll(paises);

        // 5. remove(element): elimina un elemento específico.
        names.remove("Prueba");

        // 6. removeAll(collection): elimina los elementos compartidos.
        // names.removeAll(paises);

        // 7. retainAll(collection): conserva solamente los elementos compartidos.
        // names.retainAll(paises);

        // 8. removeIf(predicate): elimina elementos que cumplen una condición.
        names.removeIf(nombre -> nombre.startsWith("X"));

        // 9. size(): devuelve la cantidad de elementos.
        System.out.println(names.size());

        // 10. isEmpty(): comprueba si el conjunto está vacío.
        System.out.println(names.isEmpty());

        // 11. clear(): elimina todos los elementos.
        // names.clear();

        // 12. iterator(): permite recorrer los elementos.
        var iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 13. forEach(action): ejecuta una acción por cada elemento.
        names.forEach(System.out::println);

        // 14. toArray(): convierte el conjunto en un arreglo.
        Object[] array = names.toArray();
        System.out.println(array.length);

        // 15. toArray(generator): crea un arreglo del tipo indicado.
        String[] nameArray = names.toArray(new String[0]);
        System.out.println(nameArray.length);

        // 16. stream(): permite procesar los elementos mediante streams.
        long cantidad = names.stream().count();
        System.out.println(cantidad);

        // 17. parallelStream(): permite procesar elementos en paralelo.
        names.parallelStream().forEach(System.out::println);

        // 18. spliterator(): proporciona un iterador divisible.
        var spliterator = names.spliterator();
        System.out.println(spliterator.estimateSize());

        // 19. hashCode(): devuelve el código hash del conjunto.
        System.out.println(names.hashCode());

        // 20. equals(object): compara el contenido con otro conjunto.
        System.out.println(names.equals(paises));

        // 21. getClass(): devuelve la clase real del objeto.
        System.out.println(names.getClass());

        // 22. toString(): representa el conjunto como texto.
        System.out.println(names.toString());

        // 23. clone(): NO está disponible públicamente en HashSet.
        // Para copiarlo, puedes crear otro conjunto:
        HashSet<String> copia = new HashSet<>(names);

        // 24. removeAll y retainAll modifican el conjunto original.
        // Úsalos con cuidado si necesitas conservar los datos.

        // 25. Comparar tamaños y comprobar si la copia es equivalente.
        System.out.println("Original: " + names.size());
        System.out.println("Copia: " + copia.size());
        System.out.println("¿Son iguales? " + names.equals(copia));

    }
}
