import java.util.Scanner;

public class EjercicioCondicionales {

    public static void main(String[] args) throws Exception {

        // ============================================================
        // SONIDO DE INICIO: KDE
        // ============================================================

        // Reproduce el sonido de inicio de KDE mediante ffplay.
        // Tema para estudiar: reproducción de audio en Java mediante
        // procesos externos usando ProcessBuilder.
        new ProcessBuilder(
                "ffplay", "-nodisp", "-autoexit", "-loglevel", "quiet",
                "ejercicios/kdesounds/KDE_Startup_2.ogg"
        ).inheritIO().start().waitFor();

        // Scanner para leer los datos ingresados por el usuario.
        Scanner scanner = new Scanner(System.in);


        // ============================================================
        // BIENVENIDA
        // ============================================================

        System.out.println("==============================================================================");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                  Welcome                                   =");
        System.out.println("=                                  A ejercicios                              =");
        System.out.println("=                                  de Condicionales                          =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("=                                                                            =");
        System.out.println("==============================================================================");


        // ============================================================
        // 1. DETERMINAR SI UN CIUDADANO PUEDE VOTAR
        // ============================================================

        // Declara la edad del ciudadano y comprueba si tiene 18 años
        // o más para determinar si puede votar.
        var edad = 12;

        if (edad >= 18) {
            System.out.println("El ciudadano puede votar");
        } else {
            System.out.println("El ciudadano no puede votar");
        }


        // ============================================================
        // 2. COMPARAR DOS NÚMEROS
        // ============================================================

        // Declara dos variables y utiliza el operador == para comprobar
        // si sus valores son iguales.
        int a = 12;
        var b = 23;

        System.out.println("¿A es igual B? " + (a == b));


        // ============================================================
        // 3. DETERMINAR SI UN NÚMERO ES POSITIVO, NEGATIVO O CERO
        // ============================================================

        // Comprueba el valor del número mediante if, else if y else.
        var numero = 12;

        if (numero > 0) {
            System.out.println("El número es positivo");
        } else if (numero < 0) {
            System.out.println("El número es negativo");
        } else {
            System.out.println("Es 0");
        }


        // ============================================================
        // 4. DETERMINAR SI UN NÚMERO ES PAR O IMPAR
        // ============================================================

        // Solicita al usuario un número entero.
        System.out.print(
                "Por favor, señor usuario, ingrese un valor entero: "
        );

        var cantidad = scanner.nextInt();

        // El operador % obtiene el residuo de una división.
        // Si el residuo de dividir entre 2 es 0, el número es par.
        // De lo contrario, el número es impar.
        if (cantidad % 2 == 0) {
            System.out.println(
                    "El número " + cantidad + " es par, señor."
            );
        } else {
            System.out.println(
                    "El número " + cantidad + " es impar, señor."
            );
        }

        // Consume el salto de línea pendiente después de nextInt().
        // Así, la siguiente llamada a nextLine() puede leer
        // correctamente la entrada del usuario.
        scanner.nextLine();


        // ============================================================
        // 5. SIMULAR UNA RESPUESTA SOBRE SI ELLA TE AMA
        // ============================================================

        // Solicita una respuesta: 1 significa que sí y 0 significa que no.
        System.out.println(
                "Digite 1 o 0 para ver si ella te ama:"
        );

        // nextLine() devuelve un String, por eso se compara usando equals().
        var amar = scanner.nextLine();

        if (amar.equals("0")) {
            System.out.println("Ella no te ama.");
        } else if (amar.equals("1")) {
            System.out.println("Ella te ama.");
        } else {
            System.out.println("Opción no válida.");
        }


        // ============================================================
        // 6. MOSTRAR EL DÍA DE LA SEMANA MEDIANTE SWITCH
        // ============================================================

        // Asigna un número al día de la semana:
        // 1 = lunes, 2 = martes, ..., 7 = domingo.
        var dias = 6;

        // switch selecciona el bloque que coincide con el valor.
        // break evita que se ejecuten los siguientes casos.
        var mensajeDias = switch (dias) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Hermano, ni sabes cuántos días tiene la semana: son 7";
        };

        System.out.println(mensajeDias);


        // ============================================================
        // EJERCICIO EXTRA: SELECCIONAR UN PROGRAMA ACADÉMICO
        // ============================================================

        // Solicita al usuario el nombre exacto de un programa académico.
        System.out.println(
                "¿Qué programa de nuestra facultad te gusta?:"
        );

        // En caso de que la opción no coincida, se muestra este enlace.
        var error = "https://support.google.com/chrome/answer/95669?hl=es-419";

        var programa = scanner.nextLine();

        // Los case de tipo String deben coincidir exactamente
        // con el texto ingresado por el usuario.
        switch (programa) {
            case "1. Ingeniería de Sistemas":
                System.out.println("Ingeniería de Sistemas");
                break;

            case "2. Ingeniería en Electronica":
                System.out.println("Ingeniería en Electronica");
                break;

            case "3. Ingeniería Audiovisual":
                System.out.println("Ingeniería Audiovisual");
                break;

            case "4. Ingeniería Forestal":
                System.out.println("Ingeniería Forestal");
                break;

            case "5. Ingeniería en Gas":
                System.out.println("Ingeniería en Gas");
                break;

            case "6. Ingeniería Física":
                System.out.println("Ingeniería Física");
                break;

            case "7. Ingeniería Eléctrica":
                System.out.println("Ingeniería Eléctrica");
                break;

            case "8. Tecnología en Sistemas":
                System.out.println("Tecnología en Sistemas");
                break;

            case "9. Tecnología en Análisis y Desarrollo de Software":
                System.out.println("Tecnología en Análisis y Desarrollo de Software");
                break;

            case "10. técnico en Computadoras":
                System.out.println("Técnico en Computadoras");
                break;

            default:
                System.out.println(
                        "Estimado usuario, el programa en cuestión no se encuentra "
                                + "en nuestro sitio, por favor visite: " + error
                );
                break;
        }


        // ============================================================
        // 7. CLASIFICAR UNA NOTA ACADÉMICA
        // ============================================================

        // Sistema rudimentario de calificaciones enteras:
        // 5 y 4 = sobresaliente
        // 3     = aceptable
        // 2 y 1 = mediocre
        // 0     = no presentó
        //
        // Los valores 4 y 3 pueden generar ambigüedad si se definen
        // rangos que se solapan. Aquí cada nota pertenece a una sola categoría.
        var nota = 4;

        // Se agrupan los case que comparten el mismo resultado.
        switch (nota) {
            case 5:
            case 4:
                System.out.println("Sobresaliente");
                break;

            case 3:
                System.out.println("Aceptable");
                break;

            case 2:
            case 1:
                System.out.println("Mediocre");
                break;

            case 0:
                System.out.println("No presentó");
                break;

            default:
                // default se ejecuta cuando ningún case coincide.
                // Es útil para manejar valores fuera del rango esperado.
                System.out.println("La calificación debe estar entre 0 y 5.");
                break;
        }


        // ============================================================
        // 8. DETERMINAR SI UN MUCHACHO PUEDE ENTRAR SOLO AL CINE
        // ============================================================

        // Si tiene 15 años o más, puede entrar solo.
        // Si es menor de 15 años, debe ir acompañado.
        var muchacho = 14;

        if (muchacho >= 15) {
            System.out.println("El muchacho puede entrar solo al cine");
        } else {
            System.out.println("El muchacho debe de ir acompañado");
        }


        // ============================================================
        // 9. DETERMINAR SI UN CARÁCTER ES VOCAL O CONSONANTE
        // ============================================================

        // char almacena un solo carácter y utiliza comillas simples.
        char letra = 'a';

        // toLowerCase() convierte la letra a minúscula para que
        // el switch pueda reconocer tanto 'a' como 'A'.
        switch (Character.toLowerCase(letra)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("La letra es una vocal");
                break;

            default:
                // isLetter() comprueba si el carácter es una letra.
                // Si no es una vocal ni una letra, se informa que
                // el carácter no corresponde a una letra.
                if (Character.isLetter(letra)) {
                    System.out.println("La letra es una consonante");
                } else {
                    System.out.println("El carácter no es una letra");
                }
                break;
        }


        // ============================================================
        // 10. DETERMINAR CUÁL DE TRES NÚMEROS ES EL MAYOR
        // ============================================================

        // Reutiliza las variables a y b del ejercicio 2.
        // Se asignan nuevos valores para comparar tres números.
        a = 15;
        b = 28;
        int c = 20;

        // && significa AND lógico: ambas comparaciones deben ser verdaderas.
        // Se comprueba cuál variable tiene un valor mayor que las otras dos.
        if (a > b && a > c) {
            System.out.println("El número a es el mayor: " + a);

        } else if (b > a && b > c) {
            System.out.println("El número b es el mayor: " + b);

        } else if (c > a && c > b) {
            System.out.println("El número c es el mayor: " + c);

        } else {
            // Si ninguna variable es estrictamente mayor que las otras,
            // dos o más números comparten el valor máximo.
            System.out.println(
                    "Hay dos o más números que comparten el valor mayor"
            );
        }


        // ============================================================
        // CIERRE DEL PROGRAMA
        // ============================================================

        // Cierra el Scanner al terminar todos los ejercicios.
        scanner.close();

        /*
         * ============================================================
         * TEMAS PARA ESTUDIAR EN YOUTUBE
         * ============================================================
         *
         * 1. Condicionales en Java:
         *    if, else if y else.
         *
         * 2. Operadores en Java:
         *    Relacionales (==, !=, >, <, >=, <=),
         *    lógicos (&&, ||, !) y aritméticos (%).
         *
         * 3. Estructura switch:
         *    case, break y default.
         *
         * 4. Entrada de datos con Scanner:
         *    nextInt(), nextLine() y manejo del salto de línea.
         *
         * 5. Tipos de datos y caracteres:
         *    char, String, Character, equals(),
         *    toLowerCase() e isLetter().
         *
         * 6. Ejecución de programas externos desde Java:
         *    ProcessBuilder, start() y waitFor().
         *
         * 7. Reproducción de audio en Java:
         *    ffplay, archivos OGG y javax.sound.sampled.Clip.
         *
         * ORDEN RECOMENDADO:
         *    1. if / else
         *    2. Operadores
         *    3. switch
         *    4. Scanner
         *    5. char, String y Character
         *    6. ProcessBuilder y reproducción de audio
         *
         * Objetivo: comprender los conceptos y aplicarlos en los
         * ejercicios sin limitarse a copiar código.
         * ============================================================
         */
    }
}
