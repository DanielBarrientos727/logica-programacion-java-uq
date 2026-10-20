import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EjercicioEstructura {

    public static void main(String[] args) {

        // 1. Crear un array con varios valores e imprimir su longitud.
        String[] names = {
                "Olaya", "Alejandro", "Andres", "Carlos",
                "Alexander", "Gaby", "Nicolas"
        };

        System.out.println(Arrays.toString(names));
        System.out.println(names.length);


        // 2. Mostrar un elemento del array antes y después de modificarlo.
        System.out.println(names[1]);

        names[1] = "OlayaDIOS";

        System.out.println(names[1]);


        // 3. Crear un ArrayList vacío para almacenar cadenas de texto.
        ArrayList<String> estados = new ArrayList<>();


        // 4. Añadir cuatro elementos al ArrayList y eliminar uno por su índice.
        estados.add("Utah");
        estados.add("New Mexico");
        estados.add("Florida");
        estados.add("New York");

        estados.remove(1);

        System.out.println(estados);


        // 5. Crear un HashSet e insertar dos elementos diferentes.
        HashSet<String> students = new HashSet<>();

        students.add("Richard");
        students.add("Jorge");


        // 6. Intentar añadir un elemento duplicado y otro diferente.
        // El HashSet no admite duplicados.
        students.add("Jorge");
        students.add("David");

        System.out.println(students);


        // 7. Eliminar un elemento del HashSet utilizando su valor.
        students.remove("Richard");

        System.out.println(students);


        // 8. Crear un HashMap que relacione nombres con números telefónicos.
        HashMap<String, Integer> phones = new HashMap<>();

        phones.put("Carlos", 321456960);
        phones.put("Falopa", 321453690);
        phones.put("Maria", 321456590);

        System.out.println(phones);


        // 9. Actualizar el teléfono de un contacto y eliminar otro contacto.
        // Si la clave ya existe, put() reemplaza su valor.
        phones.put("Falopa", 300123456);

        // Eliminar el contacto utilizando su nombre como clave.
        phones.remove("Carlos");

        // Mostrar los contactos restantes.
        System.out.println(phones);


        // 10. Convertir un array en ArrayList, después en HashSet
        // y finalmente en HashMap.

        // Crear el array original, que admite elementos duplicados.
        String[] nombres = {
                "Daniel", "Ana", "Carlos", "Ana", "Luis"
        };

        System.out.println("\n1. ARRAY");
        System.out.println(Arrays.toString(nombres));


        // Convertir el array en un ArrayList.
        // La lista conserva el orden y los elementos duplicados.
        ArrayList<String> lista =
                new ArrayList<>(Arrays.asList(nombres));

        System.out.println("\n2. ARRAYLIST");
        System.out.println(lista);


        // Convertir el ArrayList en un HashSet.
        // Los nombres repetidos se almacenan una sola vez.
        HashSet<String> conjunto = new HashSet<>(lista);

        System.out.println("\n3. HASHSET");
        System.out.println(conjunto);


        // Crear un HashMap para relacionar cada identificador
        // numérico con un nombre del HashSet.
        HashMap<Integer, String> mapa = new HashMap<>();

        int id = 1;

        // Recorrer el conjunto y asignar un identificador a cada nombre.
        for (String nombre : conjunto) {
            mapa.put(id, nombre);
            id++;
        }

        System.out.println("\n4. HASHMAP");

        // Recorrer el mapa e imprimir cada clave junto con su valor.
        for (Integer clave : mapa.keySet()) {
            System.out.println(clave + " -> " + mapa.get(clave));
        }
    }
}
