import java.util.Locale;

public class EjerciciosStrings {

    public static void main(String[] args) {

        // ===================================================
        //             ★ PRÁCTICA DE STRINGS EN JAVA ★
        // ===================================================

        System.out.println();
        System.out.println("===================================================");
        System.out.println("              EJERCICIOS DE STRINGS");
        System.out.println("===================================================");
        System.out.println();

        // Estrella decorativa construida con caracteres ASCII.

        System.out.println("                         *");
        System.out.println("                        / \\");
        System.out.println("                       /   \\");
        System.out.println("                      /     \\");
        System.out.println("                 *---/-------\\---*");
        System.out.println("                  \\ /         \\ /");
        System.out.println("                   X           X");
        System.out.println("                  / \\         / \\");
        System.out.println("                 /   \\       /   \\");
        System.out.println("                *-----\\-----/-----*");
        System.out.println("                       \\   /");
        System.out.println("                        \\ /");
        System.out.println("                         *");

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  01. CONCATENAR DOS CADENAS DE TEXTO");
        System.out.println("---------------------------------------------------");

        // Concatenar significa unir dos o más cadenas.
        // El operador + permite combinar textos y variables.

        var a = new String("umamusume");
        var b = new String("god");

        System.out.println(a + " es " + b);

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  02. LONGITUD DE UNA CADENA");
        System.out.println("---------------------------------------------------");

        // length() devuelve la cantidad de unidades UTF-16
        // que contiene una cadena. En textos sencillos,
        // coincide con el número habitual de caracteres.

        System.out.println("Hola".length());

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  03. PRIMER Y ÚLTIMO CARÁCTER");
        System.out.println("---------------------------------------------------");

        // charAt(indice) devuelve el carácter situado
        // en una posición determinada.
        // Los índices comienzan en 0, no en 1.

        System.out.println("Oso".charAt(0));
        System.out.println("Oso".charAt(2));

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  04. CONVERTIR A MAYÚSCULAS Y MINÚSCULAS");
        System.out.println("---------------------------------------------------");

        // toUpperCase() convierte el texto a mayúsculas.
        // toLowerCase() convierte el texto a minúsculas.
        // Locale.ROOT evita depender del idioma del sistema.

        var unix = "linux";

        System.out.println(unix.toUpperCase(Locale.ROOT));

        System.out.println();
        System.out.println("----------------| MAYÚSCULAS |----------------");

        System.out.println(unix.toLowerCase(Locale.ROOT));

        System.out.println();
        System.out.println("----------------| MINÚSCULAS |----------------");

        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  05. COMPROBAR SI UNA CADENA CONTIENE UNA PALABRA");
        System.out.println("---------------------------------------------------");

        // contains() comprueba si una cadena contiene
        // una secuencia determinada de caracteres.
        // Devuelve true si la encuentra o false si no.
        // toLowerCase() permite ignorar diferencias
        // entre mayúsculas y minúsculas en esta comparación.

        System.out.println(
                "Hola sergio".toLowerCase(Locale.ROOT).contains("sergio")
        ); // true

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  06. FORMATEAR UN STRING CON UN ENTERO");
        System.out.println("---------------------------------------------------");

        // Objetivo:
        // Practicar el formato de cadenas de texto
        // utilizando un número entero.
        //
        // Pista: puedes investigar String.format()
        // y el marcador %d.

        var salario = 1.20000; //se ufo la %f ya que es float
        var name = "Angel";

        System.out.println(
                String.format("El usuario se llama %s y gana %f.", name, salario)
        );

        System.out.println("---------------------------------------------------");
        System.out.println("  07. ELIMINAR ESPACIOS AL PRINCIPIO Y AL FINAL");
        System.out.println("---------------------------------------------------");

        // Objetivo:
        // Eliminar los espacios en blanco que aparecen
        // al principio y al final de una cadena.
        //
        // Pista: investiga los métodos trim() y strip().
        // Comprueba si eliminan los espacios interiores.


        var letra = "                           Música del POSIX                            ";

        System.out.println(
                letra.trim().toLowerCase(Locale.ROOT)
        );

        //ACA NADA QUE VER SOLO OTRO EJEMPLO
        var sopa = "Sopa de pollo";
        var arroz = "chino";

        System.out.println(
                sopa.trim().equalsIgnoreCase(arroz)
        );

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  08. SUSTITUIR LOS ESPACIOS DE UNA CADENA");
        System.out.println("---------------------------------------------------");

        // Objetivo:
        // Practicar la sustitución de caracteres
        // o secuencias dentro de una cadena.
        //
        // Pista: replace() permite reemplazar un texto
        // por otro. Si el segundo texto está vacío,
        // se elimina la secuencia encontrada.

        System.out.println(
                "Hola,    la      enciclopedia      libre"
                        .replace(" ", "")
        );

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  09. COMPROBAR SI DOS STRINGS SON IGUALES");
        System.out.println("---------------------------------------------------");

        // Objetivo:
        // Comparar el contenido de dos cadenas de texto.
        //
        // Pista: investiga equals().
        // Recuerda que == y equals() no hacen
        // la misma comparación cuando trabajas con objetos.

        System.out.println(
                "peluche".equalsIgnoreCase("java") //da que no son iguales
        );

        System.out.println();

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("  10. COMPROBAR SI DOS STRINGS TIENEN IGUAL LONGITUD");
        System.out.println("---------------------------------------------------");

        // Objetivo:
        // Comprobar si dos cadenas tienen la misma cantidad
        // de caracteres o unidades UTF-16.
        //
        // Pista: utiliza length() en ambas cadenas
        // y compara los resultados.

        System.out.println(
                "Longitud de Python " + "Python".length()
        );

        System.out.println(
                "Longitud de Java " + "Java".length()
        );

        System.out.println(
                "¿Son iguales? " +
                        ("Python".length() == "Java".length()) //->>>> no tienen la misma longitud, se vuelve a usar length
        );


        // ===================================================
        //                    FIN DE LA PRÁCTICA
        // ===================================================

        System.out.println();
        System.out.println("===================================================");
        System.out.println("                FIN DE LOS EJERCICIOS");
        System.out.println("===================================================");
    }
}
