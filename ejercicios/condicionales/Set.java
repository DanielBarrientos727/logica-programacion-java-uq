
import java.util.HashSet;

public class Set {
    public static void main(String[] args) {

        // Declaración y creación de un HashSet
        HashSet<String> names = new HashSet<>();
        // Usando inferencia de tipos con var
        var numbers = new HashSet<Integer>();

        //Tamaño

        System.out.println(names.size());

        // Agregar elementos
        names.add("Daniel");
        names.add("Alejandro");
        names.add("Daniel"); // No se duplica
        names.add("DanielAlejandroBarrientos7272@gmail.com"); // el SET es desordenado
        //No se usa SET para guardar datos de forma ordenada

        //no se sabe donde se guardo, pa quew lo vas a modificar

        //Nuevo tamaño
        System.out.println(names.size());

        //Lo mismo a numeros

        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // No se duplica

        //tamaño numero
        System.out.println(numbers.size());

        // Mostrar los elementos
        System.out.println("Nombres: " + names);
        System.out.println("Números: " + numbers);

        names.remove("Daniel"); // es lo mas rapido pues y sera 3 el size
        System.out.println(names.size());

        /*
        System.out.println(names.get(0));       // Obtiene el índice 0.
        System.out.println(names.getFirst());   // Primer elemento.
        System.out.println(names.getLast());    // Último elemento.
        System.out.println(names.get(1));       // Elemento del índice 1.
        NO FUNCIONAN DIFERENTE ENTRE ArrayLisy y Set
         */

        System.out.println(names.contains("Daniel")); //falso
        System.out.println(names.contains("Alejandro")); //verdad

        //para esto es mas rapido, LOS SET son mas rapido, los arrays son mas lento porque va de forma ordenana

       names.size();

       //Pa rapidez set y pa trabajar ordenadamente arrays


        System.out.println(names);
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
        names.add("Daniel"); //No permite el set redundancias
        System.out.println(names);


    }
}
