
import java.util.HashMap;

public class Maps {

    public static void main(String[] args) {

        // =========================================================
        // 1. DECLARACIÓN Y CREACIÓN
        // =========================================================

        // HashMap almacena pares de clave y valor.
        // Las claves son únicas, pero los valores pueden repetirse.
        // No garantiza el orden de las entradas.
        HashMap<String, String> names = new HashMap<>();

        // var permite que Java infiera el tipo de la variable.
        // En este caso, las claves son Integer y los valores String.
        var numbers = new HashMap<Integer, String>();


        // =========================================================
        // 2. CONSULTAR EL TAMAÑO
        // =========================================================

        // size(): devuelve la cantidad de entradas.
        System.out.println(names.size()); // 0


        // =========================================================
        // 3. AGREGAR ELEMENTOS: put()
        // =========================================================

        // put(clave, valor): agrega una entrada.
        names.put("Daniel", "Danielbarrientos888@gmail.com");
        names.put("Jorge", "Jorge888@gmail.com");
        names.put("Carlos", "Papui888@gmail.com");
        names.put("Correa", "Correa@gmail.com");

        // Ahora existen cuatro entradas.
        System.out.println(names.size()); // 4
        System.out.println(names);

        // Si repetimos una clave, se actualiza su valor.
        names.put("Correa", "CorreaDanini@gmail.com");
        System.out.println(names);


        // =========================================================
        // 4. ACCEDER A LOS ELEMENTOS
        // =========================================================

        // get(clave): devuelve el valor asociado a esa clave.
        System.out.println(names.get("Carlos"));

        // Si la clave no existe, get() devuelve null.
        System.out.println(names.get("Salsa"));

        // getOrDefault(clave, valorPorDefecto):
        // devuelve el valor asociado o un valor predeterminado.
        System.out.println(
                names.getOrDefault("Salsa", "Usuario no encontrado")
        );


        // =========================================================
        // 5. VERIFICAR ELEMENTOS
        // =========================================================

        // containsKey(): comprueba si existe una clave.
        System.out.println(names.containsKey("Jorge")); // true
        System.out.println(names.containsKey("papa"));  // false

        // containsValue(): comprueba si existe un valor.
        System.out.println(
                names.containsValue("Papui888@gmail.com")
        ); // true


        // =========================================================
        // 6. ELIMINAR ELEMENTOS
        // =========================================================

        // remove(clave): elimina la entrada por su clave.
        // Devuelve el valor eliminado, o null si no existía.
        System.out.println(names.remove("Carlos"));

        // ¡Importante! remove() busca por clave, no por valor.
        // Esta instrucción no elimina nada porque el correo
        // no es una clave del mapa.
        System.out.println(names.remove("Papui888@gmail.com"));

        // remove(clave, valor): elimina la entrada solamente
        // cuando coinciden la clave y el valor.
        System.out.println(
                names.remove("Jorge", "correo_incorrecto@gmail.com")
        ); // false

        System.out.println(names);


        // =========================================================
        // 7. LIMPIAR EL HASHMAP
        // =========================================================

        // clear(): elimina todas las entradas del mapa.
        names.clear();

        System.out.println(names);       // {}
        System.out.println(names.size()); // 0
        System.out.println(names.isEmpty()); // true


        // =========================================================
        // 8. MODIFICAR ELEMENTOS
        // =========================================================

        names.put("Correa", "Correa@gmail.com");
        System.out.println(names);

        // put() actualiza el valor si la clave ya existe.
        names.put("Correa", "CorreaDanini@gmail.com");
        System.out.println(names);

        // replace(clave, valor): reemplaza el valor únicamente
        // si la clave ya existe. No crea una entrada nueva.
        System.out.println(
                names.replace("Carlos", "Carlos@gmail.com")
        ); // null: Carlos no existe.

        System.out.println(names);

        // putIfAbsent(): agrega un valor solamente si la clave
        // no tiene un valor asociado.
        names.putIfAbsent("Correa", "OtroCorreo@gmail.com");
        System.out.println(names); // Correa conserva su correo actual.

        // Pero si la clave no existe, la agrega.
        names.putIfAbsent("Ana", "Ana@gmail.com");
        System.out.println(names);

        // replace(clave, valorAnterior, valorNuevo):
        // reemplaza solo si el valor anterior coincide.
        System.out.println(
                names.replace(
                        "Correa",
                        "CorreaDanini@gmail.com",
                        "CorreaActualizado@gmail.com"
                )
        );

        System.out.println(names);


        // =========================================================
        // 9. AGREGAR ENTRADAS DE OTRO MAPA
        // =========================================================

        var otrosNombres = new HashMap<String, String>();

        otrosNombres.put("Luis", "Luis@gmail.com");
        otrosNombres.put("Maria", "Maria@gmail.com");

        // putAll(): agrega todas las entradas de otro mapa.
        names.putAll(otrosNombres);
        System.out.println(names);


        // =========================================================
        // 10. OBTENER CLAVES, VALORES Y ENTRADAS
        // =========================================================

        // keySet(): devuelve un conjunto con las claves.
        var keys = names.keySet();
        System.out.println("Claves: " + keys);

        // values(): devuelve una colección con los valores.
        var values = names.values();
        System.out.println("Valores: " + values);

        // entrySet(): devuelve las entradas completas.
        var entries = names.entrySet();
        System.out.println("Entradas: " + entries);


        // =========================================================
        // 11. RECORRER EL HASHMAP
        // =========================================================

        // forEach(): ejecuta una acción para cada entrada.
        names.forEach(
                (clave, valor) ->
                        System.out.println(clave + " -> " + valor)
        );

        // También podemos recorrer las entradas con un ciclo.
        for (var entrada : names.entrySet()) {
            System.out.println(
                    "Clave: " + entrada.getKey()
                            + " | Valor: " + entrada.getValue()
            );
        }

        // getKey(): obtiene la clave de una entrada.
        // getValue(): obtiene el valor de una entrada.
        // Estos métodos pertenecen a Map.Entry.


        // =========================================================
        // 12. MÉTODOS COMPUTACIONALES
        // =========================================================

        // computeIfAbsent(): calcula un valor si la clave
        // no tiene uno asociado.
        names.computeIfAbsent(
                "Pedro",
                clave -> clave.toLowerCase() + "@gmail.com"
        );

        // computeIfPresent(): actualiza el valor si la clave
        // ya tiene un valor asociado.
        names.computeIfPresent(
                "Luis",
                (clave, valor) -> valor.toUpperCase()
        );

        // compute(): calcula el nuevo valor independientemente
        // de que la clave exista. Si devuelve null, elimina la entrada.
        names.compute(
                "Carlos",
                (clave, valor) ->
                        valor == null ? "Carlos@gmail.com" : valor
        );

        // merge(): agrega un valor si no existe uno asociado.
        // Si ya existe, combina ambos valores mediante la función.
        names.merge(
                "Correa",
                "CorreoAlternativo@gmail.com",
                (anterior, nuevo) -> anterior + " | " + nuevo
        );

        System.out.println(names);


        // =========================================================
        // 13. MODIFICAR TODOS LOS VALORES
        // =========================================================

        // replaceAll(): aplica una función a cada valor.
        names.replaceAll(
                (clave, valor) -> valor.trim()
        );

        System.out.println(names);


        // =========================================================
        // 14. CONSULTAR EL ESTADO DEL MAPA
        // =========================================================

        // isEmpty(): devuelve true si el mapa está vacío.
        System.out.println(names.isEmpty());

        // size(): devuelve la cantidad de entradas.
        System.out.println(names.size());

        // containsKey(): verifica si una clave está presente.
        System.out.println(names.containsKey("Daniel"));

        // containsValue(): verifica si un valor está presente.
        System.out.println(names.containsValue("Ana@gmail.com"));


        // =========================================================
        // 15. CONVERTIR COLECCIONES EN ARREGLOS
        // =========================================================

        // toArray() no pertenece directamente a HashMap.
        // Se utiliza sobre las colecciones obtenidas del mapa.

        Object[] arregloClaves = names.keySet().toArray();
        System.out.println(arregloClaves.length);

        String[] arregloValores =
                names.values().toArray(new String[0]);

        System.out.println(arregloValores.length);


        // =========================================================
        // 16. STREAMS
        // =========================================================

        // stream(): permite procesar las entradas mediante streams.
        long cantidad = names.entrySet().stream().count();
        System.out.println("Cantidad de entradas: " + cantidad);

        // Filtrar las entradas según una condición.
        names.entrySet().stream()
                .filter(entrada -> entrada.getKey().startsWith("A"))
                .forEach(System.out::println);

        // parallelStream(): permite procesar entradas en paralelo.
        // No garantiza el orden de ejecución.
        names.entrySet().parallelStream()
                .forEach(System.out::println);


        // =========================================================
        // 17. COMPARAR MAPAS Y CONSULTAR SUS CARACTERÍSTICAS
        // =========================================================

        // Crear una copia a partir de otro mapa.
        var copia = new HashMap<String, String>(names);

        // equals(): compara las entradas de ambos mapas.
        System.out.println(names.equals(copia)); // true

        // hashCode(): devuelve el código hash del mapa.
        System.out.println(names.hashCode());

        // toString(): representa el mapa como texto.
        System.out.println(names.toString());

        // getClass(): devuelve la clase real del objeto.
        System.out.println(names.getClass());

        // clone(): genera una copia superficial del mapa.
        // La conversión de tipo permite recuperar el HashMap.
        @SuppressWarnings("unchecked")
        HashMap<String, String> copiaClone =
                (HashMap<String, String>) names.clone();

        System.out.println(copiaClone);


        // =========================================================
        // 18. HASHMAP CON CLAVES NUMÉRICAS
        // =========================================================

        // Registrar usuarios mediante identificadores numéricos.
        numbers.put(1, "Daniel");
        numbers.put(2, "Jorge");
        numbers.put(3, "Carlos");

        System.out.println(numbers);

        // Consultar un usuario por su identificador.
        System.out.println(numbers.get(1));

        // Comprobar si existe una clave.
        System.out.println(numbers.containsKey(2));

        // Comprobar si existe un valor.
        System.out.println(numbers.containsValue("Carlos"));

        // Consultar con un valor predeterminado.
        System.out.println(
                numbers.getOrDefault(10, "Usuario no encontrado")
        );

        // Eliminar un usuario mediante su clave.
        numbers.remove(3);

        System.out.println(numbers);


        // =========================================================
        // 19. DOCUMENTACIÓN OFICIAL
        // =========================================================

        /*
         * HASHMAP:
         * https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/HashMap.html
         *
         * INTERFAZ MAP:
         * https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Map.html
         *
         * MAP.ENTRY:
         * https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Map.Entry.html
         *
         * HASHMAP almacena pares de clave y valor.
         * Cada clave es única y los valores pueden repetirse.
         * No garantiza el orden de iteración.
         *
         * MAP documenta operaciones generales como put(),
         * getOrDefault(), putIfAbsent(), compute(), merge()
         * y replaceAll().
         *
         * MAP.ENTRY representa una entrada individual y ofrece
         * métodos como getKey() y getValue().
         *
         * También puedes explorar los métodos disponibles
         * escribiendo names. o numbers. en el autocompletado.
         */
    }
}
