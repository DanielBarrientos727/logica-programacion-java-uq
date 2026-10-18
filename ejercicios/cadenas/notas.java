
import java.util.Locale;

public class notas {

    public static void main(String[] args) {

        /*
         * ==========================================================
         * PROYECTO: FICHA ACADÉMICA DE ESTUDIANTES
         * ==========================================================
         *
         * OBJETIVO:
         * Crear fichas académicas usando los métodos de String
         * estudiados en esta lección.
         *
         * CONCEPTOS APLICADOS:
         * String, var, constructores, concatenación, length(),
         * charAt(), substring(), toUpperCase(), toLowerCase(),
         * Locale.ROOT, contains(), equals(), equalsIgnoreCase(),
         * trim(), replace(), String.format() y formatted().
         *
         * Los datos académicos que no conocemos no se inventan.
         */

        // ==========================================================
        // 1. DATOS DEL ESTUDIANTE
        // ==========================================================

        String nombreCompleto = "   Daniel Alejandro Barrientos Soto   ";

        var edad = 19;
        var carrera = "Ingeniería de Sistemas y Computación";
        var universidad = "Universidad del Quindío";
        var asignatura = "Introducción a la Ingeniería de Sistemas y Computación";
        var grupo = "02N";
        var semestre = 1;

        /*
         * trim() elimina los espacios de los extremos.
         * Guardamos el resultado porque String es inmutable.
         */

        nombreCompleto = nombreCompleto.trim();

        /*
         * ==========================================================
         * 2. CONSTRUCTOR DE STRING
         * ==========================================================
         *
         * new String() crea explícitamente otro objeto String.
         * Aquí lo usamos únicamente para practicar el constructor.
         * En código real, normalmente basta con utilizar un literal.
         */

        var institucion = new String("Universidad del Quindío");

        // ==========================================================
        // 3. TRANSFORMACIÓN DEL NOMBRE
        // ==========================================================

        var nombreMayusculas = nombreCompleto.toUpperCase(Locale.ROOT);
        var nombreMinusculas = nombreCompleto.toLowerCase(Locale.ROOT);

        /*
         * Locale.ROOT hace que las conversiones no dependan
         * de la configuración regional del sistema.
         */

        // ==========================================================
        // 4. LONGITUD Y ACCESO A CARACTERES
        // ==========================================================

        var longitudNombre = nombreCompleto.length();

        /*
         * charAt(0) obtiene el primer carácter.
         * charAt(length() - 1) obtiene el último carácter.
         */

        var primeraLetra = nombreCompleto.charAt(0);
        var ultimaLetra = nombreCompleto.charAt(longitudNombre - 1);

        // ==========================================================
        // 5. EXTRACCIÓN DE SUBCADENAS
        // ==========================================================

        /*
         * substring(0, 6) obtiene los primeros seis caracteres.
         * El índice final no se incluye.
         */

        var fragmentoNombre = nombreCompleto.substring(0, 6);

        /*
         * Buscamos el primer espacio para separar el primer nombre.
         * indexOf() es un método adicional de String.
         * Devuelve -1 cuando no encuentra el carácter buscado.
         */

        var posicionEspacio = nombreCompleto.indexOf(' ');

        var primerNombre = nombreCompleto.substring(0, posicionEspacio);

        // ==========================================================
        // 6. BÚSQUEDAS Y COMPARACIONES
        // ==========================================================

        /*
         * contains() busca una secuencia de caracteres.
         * equals() compara el contenido exacto.
         * equalsIgnoreCase() ignora diferencias entre mayúsculas
         * y minúsculas.
         */

        var estudiaSistemas = carrera.contains("Sistemas");

        var nombreCoincide = nombreCompleto.equals(
                "Daniel Alejandro Barrientos Soto"
        );

        var nombreCoincideSinMayusculas = nombreCompleto
                .equalsIgnoreCase("DANIEL ALEJANDRO BARRIENTOS SOTO");

        // ==========================================================
        // 7. REEMPLAZO DE TEXTO
        // ==========================================================

        /*
         * replace() devuelve una nueva cadena con las sustituciones.
         * En este caso, reemplazamos los espacios por guiones.
         */

        var nombreParaCodigo = nombreCompleto.replace(" ", "-");

        // ==========================================================
        // 8. COMPARACIÓN DE REFERENCIAS Y CONTENIDO
        // ==========================================================

        var nombreA = "Daniel";
        var nombreB = "Daniel";
        var nombreC = new String("Daniel");

        /*
         * == compara referencias de objetos.
         * equals() compara el contenido de los Strings.
         *
         * No utilizamos == para validar nombres de estudiantes.
         */

        var mismaReferencia = nombreA == nombreB;
        var otraReferencia = nombreA == nombreC;
        var mismoContenido = nombreA.equals(nombreC);

        // ==========================================================
        // 9. FICHA ACADÉMICA CON CONCATENACIÓN
        // ==========================================================

        System.out.println("==============================================");
        System.out.println("           FICHA ACADÉMICA");
        System.out.println("==============================================");

        System.out.println("Estudiante: " + nombreCompleto);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Carrera: " + carrera);
        System.out.println("Universidad: " + universidad);
        System.out.println("Asignatura: " + asignatura);
        System.out.println("Grupo: " + grupo);
        System.out.println("Semestre: " + semestre);

        // ==========================================================
        // 10. FICHA FORMATEADA CON STRING.FORMAT()
        // ==========================================================

        /*
         * String.format() permite organizar muchos datos en una
         * plantilla, sin concatenar manualmente cada variable.
         *
         * %s representa texto y %d representa números enteros.
         */

        String ficha = String.format(
                Locale.ROOT,
                """
                ----------------------------------------------
                FICHA DEL ESTUDIANTE
                ----------------------------------------------
                Nombre:       %s
                Edad:         %d años
                Carrera:      %s
                Universidad:  %s
                Asignatura:   %s
                Grupo:        %s
                Semestre:     %d
                ----------------------------------------------
                """,
                nombreCompleto,
                edad,
                carrera,
                institucion,
                asignatura,
                grupo,
                semestre
        );

        System.out.println(ficha);

        // ==========================================================
        // 11. FICHA CON FORMATTED()
        // ==========================================================

        /*
         * formatted() permite aplicar una plantilla directamente
         * sobre un String. Está disponible desde Java 15.
         */

        var resumen = "El estudiante %s cursa %s en el grupo %s."
                .formatted(nombreCompleto, asignatura, grupo);

        System.out.println(resumen);

        // ==========================================================
        // 12. INFORME DE ANÁLISIS DEL NOMBRE
        // ==========================================================

        /*
         * Combinamos los métodos anteriores para analizar
         * el nombre registrado en la ficha.
         */

        System.out.println("\n==============================================");
        System.out.println("           ANÁLISIS DEL NOMBRE");
        System.out.println("==============================================");

        System.out.println("Nombre original: " + nombreCompleto);
        System.out.println("En mayúsculas: " + nombreMayusculas);
        System.out.println("En minúsculas: " + nombreMinusculas);
        System.out.println("Longitud: " + longitudNombre);
        System.out.println("Primera letra: " + primeraLetra);
        System.out.println("Última letra: " + ultimaLetra);
        System.out.println("Primer nombre: " + primerNombre);
        System.out.println("Primeros seis caracteres: " + fragmentoNombre);
        System.out.println("Nombre para código: " + nombreParaCodigo);

        // ==========================================================
        // 13. VALIDACIONES DE LA FICHA
        // ==========================================================

        System.out.println("\n==============================================");
        System.out.println("           VALIDACIONES");
        System.out.println("==============================================");

        System.out.println("¿Estudia Sistemas?: " + estudiaSistemas);
        System.out.println("¿Nombre exacto?: " + nombreCoincide);

        System.out.println(
                "¿Coincide ignorando mayúsculas?: "
                        + nombreCoincideSinMayusculas
        );

        // ==========================================================
        // 14. EJEMPLO DE REFERENCIAS Y CONTENIDO
        // ==========================================================

        System.out.println("\n==============================================");
        System.out.println("           COMPARACIÓN DE STRINGS");
        System.out.println("==============================================");

        System.out.println("¿A y B comparten referencia?: " + mismaReferencia);
        System.out.println("¿A y C comparten referencia?: " + otraReferencia);
        System.out.println("¿A y C tienen el mismo contenido?: " + mismoContenido);

        // ==========================================================
        // 15. FORMATO FINAL DEL INFORME
        // ==========================================================

        /*
         * Podemos combinar varios resultados en una única plantilla.
         * %.2f sería útil para un promedio, pero no lo incluimos porque
         * no tenemos una nota académica real de este estudiante.
         */

        var informe = """
                RESUMEN DEL REGISTRO
                Estudiante: %s
                Identificador textual: %s
                Longitud del nombre: %d caracteres
                Primera letra: %c
                Última letra: %c
                Carrera relacionada con Sistemas: %s
                """.formatted(
                nombreCompleto,
                nombreParaCodigo,
                longitudNombre,
                primeraLetra,
                ultimaLetra,
                estudiaSistemas
        );

        System.out.println("\n" + informe);

    }
}
