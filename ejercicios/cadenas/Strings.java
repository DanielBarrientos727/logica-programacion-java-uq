import java.util.Locale;

public class Strings {

    public static void main(String[] args) {

        /*
         * STRINGS: CADENAS DE TEXTO
         *
         * String es una clase de Java que permite representar y manipular
         * secuencias de caracteres, como nombres, palabras, frases y mensajes.
         *
         * Para declarar una variable, indicamos el tipo de dato, el nombre
         * de la variable y el valor que queremos almacenar.
         */

        String name = "carlos"; // Declara una variable de tipo String.

        /*
         * INFERENCIA DE TIPOS CON VAR
         *
         * La palabra reservada var permite que el compilador infiera el tipo
         * de una variable a partir del valor que se le asigna al declararla.
         *
         * No significa que Java deje de ser un lenguaje tipado: una vez
         * inferido el tipo, la variable mantiene ese tipo durante su uso.
         */

        var fruta = "Piña"; // Java infiere que fruta es de tipo String.


        /*
         * CONSTRUCTOR DE STRING
         *
         * Un constructor permite crear e inicializar un objeto de una clase.
         * En este caso, new String("david") crea explícitamente un objeto String.
         *
         * Sin embargo, utilizar el constructor es innecesario para este caso.
         * Lo habitual es escribir directamente el texto entre comillas dobles.
         */

        var surname = new String("david");

        // Forma recomendada para declarar una cadena con un valor literal:
        // String surname = "david";


        /*
         * CONCATENACIÓN
         *
         * La concatenación consiste en unir dos o más cadenas de texto.
         * En Java podemos utilizar el operador + para combinar cadenas,
         * variables y otros valores que puedan convertirse en texto.
         *
         * Cuando concatenamos una cadena con un número, Java convierte
         * el valor numérico en su representación textual.
         */

        System.out.println(name + " " + surname);

        // Concatena un saludo con el contenido de la variable name.
        System.out.println("Hola, " + name);

        // El número 18 se convierte en texto durante la concatenación.
        System.out.println("Mi edad es " + 18);


        /*
         * LENGTH()
         *
         * El método length() devuelve un entero (int) que representa
         * la cantidad de unidades UTF-16 de la cadena.
         *
         * Para los caracteres básicos, como las letras del alfabeto inglés,
         * el resultado coincide con la cantidad de caracteres visibles.
         * Los espacios también cuentan y una cadena vacía tiene longitud 0.
         */

        System.out.println(name.length()); // Imprime 6.

        // Ejemplos de longitud de diferentes cadenas.
        System.out.println("Java".length()); // Imprime 4.
        System.out.println("Hola mundo".length()); // Imprime 10, incluido el espacio.
        System.out.println("".length()); // Imprime 0.


        /*
         * CHARAT()
         *
         * El método charAt(indice) devuelve el valor char situado
         * en la posición indicada dentro de la cadena.
         *
         * Los índices comienzan en 0, no en 1.
         * Si indicamos un índice negativo o igual o superior a la longitud,
         * Java lanza una excepción IndexOutOfBoundsException.
         *
         * Índices de la cadena "carlos":
         * c = 0, a = 1, r = 2, l = 3, o = 4, s = 5.
         */

        System.out.println(name.charAt(1)); // Imprime 'a'.

        /*
         * Para obtener el último carácter, restamos 1 a la longitud.
         * Esto funciona porque los índices comienzan en 0.
         * Por ejemplo, si la longitud es 6, el último índice es 5.
         */

        System.out.println(name.charAt(name.length() - 1)); // Imprime 's'.

        // Otros ejemplos de acceso a caracteres mediante índices.
        System.out.println("Java".charAt(0)); // Imprime 'J'.
        System.out.println("Java".charAt(2)); // Imprime 'v'.
        System.out.println("Programacion".charAt(3)); // Imprime 'g'.


        /*
         * SUBSTRING()
         *
         * El método substring() permite extraer una parte de una cadena
         * y devuelve un nuevo String con el contenido seleccionado.
         *
         * substring(inicio, fin) incluye el índice inicial, pero excluye
         * el índice final. Por eso, el rango seleccionado es [inicio, fin).
         *
         * substring(inicio) extrae el texto desde el índice indicado
         * hasta el final de la cadena.
         */

        System.out.println(name.substring(2, 4)); // Imprime "rl".

        /*
         * En "carlos", los índices son:
         * c = 0, a = 1, r = 2, l = 3, o = 4, s = 5.
         *
         * substring(2, 4) incluye los índices 2 y 3,
         * pero no incluye el índice 4.
         */

        System.out.println(name.substring(2)); // Imprime "rlos".

        // Más ejemplos de extracción de subcadenas.
        System.out.println("Universidad".substring(0, 5)); // Imprime "Unive".
        System.out.println("Computadora".substring(4, 8)); // Imprime "utad".
        System.out.println("Java".substring(1)); // Imprime "ava".


        /*
         * TOUPPERCASE() Y TOLOWERCASE()
         *
         * toUpperCase() devuelve una cadena con las letras convertidas
         * a mayúsculas, mientras que toLowerCase() las convierte a minúsculas.
         *
         * Los dos métodos devuelven un String nuevo y no modifican
         * el contenido del objeto original, porque los String son inmutables.
         *
         * La inmutabilidad significa que el contenido de una cadena existente
         * no puede cambiarse después de crearla.
         */

        System.out.println(name.toUpperCase()); // Imprime "CARLOS".
        System.out.println(name.toLowerCase()); // Imprime "carlos".
        System.out.println(name); // Imprime "carlos".

        /*
         * Si queremos conservar el resultado de una transformación,
         * podemos asignarlo nuevamente a la misma variable.
         *
         * La variable name pasa a referenciar la cadena devuelta
         * por toLowerCase(); el objeto original no se modifica.
         */

        name = name.toLowerCase();

        System.out.println(name); // Imprime "carlos".

        // Más ejemplos de conversión entre mayúsculas y minúsculas.
        System.out.println("java".toUpperCase()); // Imprime "JAVA".
        System.out.println("PROGRAMACION".toLowerCase()); // Imprime "programacion".
        System.out.println("Hola Mundo".toUpperCase()); // Imprime "HOLA MUNDO".

        /*
         * LOCALE.ROOT
         *
         * Locale representa una configuración regional y lingüística.
         * Algunas conversiones de mayúsculas y minúsculas dependen del idioma.
         *
         * Locale.ROOT utiliza una configuración regional neutral, adecuada
         * para transformaciones técnicas que no deben depender del idioma
         * configurado en el sistema.
         */

        System.out.println("Hola Cami".toUpperCase(Locale.ROOT));
        System.out.println("JAVA".toLowerCase(Locale.ROOT));


        /*
         * CONTAINS()
         *
         * El método contains() comprueba si una cadena contiene
         * una secuencia de caracteres determinada.
         *
         * Devuelve un boolean: true si encuentra la secuencia y false
         * si no la encuentra. La búsqueda distingue entre mayúsculas
         * y minúsculas, por lo que "Java" y "java" no son iguales.
         */

        System.out.println(
                "Hola Cami".toUpperCase(Locale.ROOT).contains("PAPU")
        ); // Imprime false porque "PAPU" no aparece en la cadena.

        System.out.println("Hola Cami".contains("Cami")); // Imprime true.
        System.out.println("Hola Cami".contains("cami")); // Imprime false.

        /*
         * Para buscar texto sin distinguir entre mayúsculas y minúsculas,
         * podemos convertir ambas cadenas a una misma forma antes de comparar.
         * Locale.ROOT evita depender de las reglas regionales del sistema.
         */

        System.out.println(
                "JAVA".toLowerCase(Locale.ROOT).contains("java")
        ); // Imprime true.

        // Otros ejemplos de búsqueda de secuencias de caracteres.
        System.out.println("Me gusta Linux".contains("Linux")); // Imprime true.
        System.out.println("Me gusta Linux".contains("Windows")); // Imprime false.
        System.out.println("Programacion Java".contains("Java")); // Imprime true.


        /*
         * EQUALS() Y EQUALSIGNORECASE()
         *
         * equals() compara el contenido de dos objetos String.
         * Devuelve true cuando las cadenas contienen exactamente
         * la misma secuencia de caracteres y false en caso contrario.
         *
         * equalsIgnoreCase() realiza una comparación sin distinguir
         * entre mayúsculas y minúsculas.
         */

        var dani = "Alejandro";
        var username = "orisono";

        System.out.println(dani == "Alejandro");

        // equals() compara el contenido de las cadenas.
        System.out.println(dani.equals("Alejandro")); // Imprime true.
        System.out.println(dani.equals("alejandro")); // Imprime false.
        System.out.println(dani.equalsIgnoreCase("alejandro")); // Imprime true.


        /*
         * OPERADOR == FRENTE A EQUALS()
         *
         * En los objetos, el operador == compara referencias: comprueba
         * si ambas expresiones apuntan al mismo objeto.
         *
         * En cambio, equals() compara el contenido según la implementación
         * del método. En String, comprueba la secuencia de caracteres.
         *
         * Por tanto, dos cadenas pueden tener el mismo contenido y ser
         * objetos diferentes. Para comparar texto, normalmente debemos usar
         * equals() o equalsIgnoreCase(), según lo que necesitemos.
         */

        var a = "Brains";
        var b = "Brains";
        var c = new String("Brains");

        System.out.println(a == b); // Imprime true en este ejemplo.
        System.out.println(a == c); // Imprime false: referencias diferentes.
        System.out.println(a.equals(c)); // Imprime true: contenido idéntico.

        /*
         * STRING POOL
         *
         * Java mantiene un conjunto de cadenas internadas conocido como
         * String Pool. Los literales iguales pueden compartir el mismo objeto.
         *
         * Por eso, en este ejemplo, a == b devuelve true: ambos literales
         * hacen referencia a la misma cadena internada.
         *
         * Sin embargo, no debemos utilizar == para comprobar si dos cadenas
         * contienen el mismo texto, porque el resultado depende de sus referencias.
         */

        // Ejemplos de comparación correcta del contenido.
        System.out.println("Java".equals("Java")); // Imprime true.
        System.out.println("Java".equals("JAVA")); // Imprime false.
        System.out.println("Java".equalsIgnoreCase("JAVA")); // Imprime true.


        /*
         * TRIM()
         *
         * El método trim() devuelve una cadena sin los caracteres
         * con valor igual o inferior a U+0020 que aparezcan al principio
         * o al final del texto.
         *
         * No elimina los espacios que se encuentran entre palabras.
         * Tampoco modifica la cadena original, porque String es inmutable.
         */

        System.out.println("   Hola, soy Linux   ".trim());
        // Imprime "Hola, soy Linux".

        System.out.println("   Hola, soy Linux   ");
        // Imprime la cadena original, incluidos sus espacios externos.

        /*
         * trim() resulta útil para limpiar datos de entrada cuando un usuario
         * introduce espacios accidentales antes o después de un texto.
         *
         * Nota: strip() es otra alternativa disponible desde Java 11.
         * A diferencia de trim(), strip() reconoce los espacios en blanco
         * según el criterio de Character.isWhitespace().
         */

        // Más ejemplos de eliminación de espacios externos.
        System.out.println("   Java   ".trim()); // Imprime "Java".
        System.out.println("   Daniel".trim()); // Imprime "Daniel".
        System.out.println("Linux   ".trim()); // Imprime "Linux".
        System.out.println("Hola   mundo".trim()); // Conserva los espacios internos.


        /*
         * REPLACE()
         *
         * El método replace() permite sustituir todas las apariciones
         * de un carácter o de una secuencia de caracteres por otra.
         *
         * Recibe dos argumentos: el contenido que queremos reemplazar
         * y el contenido nuevo que ocupará su lugar.
         *
         * Devuelve un nuevo String; la cadena original permanece intacta
         * a menos que asignemos el resultado a una variable.
         */

        System.out.println("   Hola, soy Linux   ".replace(" ", ""));
        // Imprime "Hola,soyLinux": elimina todos los espacios.

        // Sustituye una palabra completa por otra.
        System.out.println("Hola Windows".replace("Windows", "Linux"));

        // Sustituye todas las apariciones del carácter indicado.
        System.out.println("banana".replace("a", "o")); // Imprime "bonono".

        // Otros ejemplos de sustitución de caracteres y palabras.
        System.out.println("Hola mundo".replace(" ", "_")); // Imprime "Hola_mundo".
        System.out.println("111-222-333".replace("-", "/")); // Imprime "111/222/333".
        System.out.println("Java Java".replace("Java", "Rust")); // Imprime "Rust Rust".

        /*
         * Si queremos conservar el resultado de replace(), debemos asignarlo
         * a una variable. De lo contrario, el resultado devuelto se utiliza
         * únicamente en esa expresión y no se almacena.
         */

        var lenguaje = "Me gusta Java";

        lenguaje = lenguaje.replace("Java", "Rust");

        System.out.println(lenguaje); // Imprime "Me gusta Rust".


        /*
         * STRING.FORMAT()
         *
         * String.format() construye una cadena a partir de una plantilla
         * y de los valores que queremos insertar en ella.
         *
         * Los especificadores de formato indican qué tipo de valor se inserta:
         * %s representa una cadena, %d un número entero y %f un número decimal.
         *
         * Los valores se proporcionan después de la plantilla, en el mismo
         * orden en el que aparecen sus especificadores.
         */

        var age = 19;

        System.out.println(
                String.format("Hola, me llamo %s y tengo %d años.", name, age)
        ); // Imprime "Hola, me llamo carlos y tengo 19 años".

        /*
         * EJEMPLOS DE ESPECIFICADORES DE FORMATO
         *
         * %s: representa texto.
         * %d: representa un número entero.
         * %f: representa un número decimal.
         * %.2f: representa un número decimal con dos cifras decimales.
         * %n: inserta un salto de línea independiente del sistema operativo.
         */

        var nombre = "Daniel";
        var edad = 19;
        var promedio = 4.18;

        System.out.println(String.format("Nombre: %s", nombre));
        System.out.println(String.format("Edad: %d años", edad));
        System.out.println(String.format("Promedio: %.2f", promedio));

        System.out.println(
                String.format("Nombre: %s%nEdad: %d%nPromedio: %.2f",
                        nombre, edad, promedio)
        );


        /*
         * CONCATENACIÓN FRENTE A STRING.FORMAT()
         *
         * Ambos enfoques permiten construir mensajes con variables.
         * La concatenación con + suele ser sencilla para expresiones cortas.
         * String.format() resulta útil cuando queremos organizar una plantilla
         * con varios valores y controlar cómo se representan.
         */

        System.out.println("Me llamo " + nombre + " y tengo " + edad + " años.");

        System.out.println(
                String.format("Me llamo %s y tengo %d años.", nombre, edad)
        );


        /*
         * EJERCICIO EXTRA: COMBINAR LOS MÉTODOS APRENDIDOS
         *
         * Los métodos de String pueden encadenarse: el resultado de una
         * operación se utiliza como entrada de la siguiente.
         *
         * En este ejemplo, primero eliminamos los espacios externos y después
         * convertimos la cadena a mayúsculas o minúsculas, buscamos palabras,
         * reemplazamos texto y calculamos la longitud del resultado.
         */

        var frase = "   Aprendiendo Java   ";

        System.out.println(frase.trim().toUpperCase(Locale.ROOT));
        // Elimina los espacios externos y convierte el texto a mayúsculas.

        System.out.println(frase.trim().toLowerCase(Locale.ROOT));
        // Elimina los espacios externos y convierte el texto a minúsculas.

        System.out.println(frase.trim().contains("Java"));
        // Imprime true porque la cadena contiene la secuencia "Java".

        System.out.println(frase.trim().replace("Java", "Rust"));
        // Imprime "Aprendiendo Rust".

        System.out.println(frase.trim().length());
        // Imprime 16: cuenta los caracteres después de eliminar los extremos.

        /*
         * COMPARACIÓN DE NOMBRES
         *
         * Cuando recibimos datos de un usuario, puede haber diferencias
         * en los espacios externos o en el uso de mayúsculas y minúsculas.
         *
         * Podemos combinar trim() con equalsIgnoreCase() para comparar
         * dos nombres sin que esas diferencias afecten el resultado.
         */

        var nombreUsuario = "   Daniel   ";
        var nombreIngresado = "daniel";

        System.out.println(
                nombreUsuario.trim().equalsIgnoreCase(nombreIngresado)
        ); // Imprime true.

        //dato es mejor asi:

        System.out.println("Me llamo %s y tengo %d años.".formatted(nombre, edad));

        // es pa cuando tenemos muchas variables

        var carrera = "Ingeniería de Sistemas";
        var semestre = 1;
        var prom= 4.18;

        String informacion = String.format(
                "Estudiante: %s | Edad: %d | Carrera: %s | Semestre: %d | Promedio: %.2f",
                nombre, edad, carrera, semestre, promedio
        );

        System.out.println(informacion);

    }
}