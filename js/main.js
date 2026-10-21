/**
 * Java UQ — lógica de la interfaz
 * ---------------------------------------------------------------------
 * Responsabilidades:
 * 1. Mantener el catálogo de categorías y ejercicios.
 * 2. Construir la navegación y el listado desde esos datos.
 * 3. Renderizar la portada, las guías temáticas y las fichas de ejercicios.
 * 4. Gestionar búsqueda, tema visual, navegación móvil y copia de rutas.
 *
 * Para editar contenido, modifica CATEGORY_DATA o EXERCISES.
 * Para cambiar la apariencia, modifica CSS/style.css.
 * Para cambiar la estructura de la página, modifica index.html.
 */
(() => {
  "use strict";

  /* ================================================================
     1. CATÁLOGO DE CATEGORÍAS Y CONTENIDO DIDÁCTICO
     Para editar la teoría, los objetivos, los ejemplos o los recursos,
     modifica este objeto. No necesitas tocar las funciones de renderizado.
     ================================================================ */
  const CATEGORY_DATA = {
    todos: {
      label: "Todos",
      listTitle: "Todos los ejercicios",
      icon: "▦",
      description: "Portada general de la biblioteca de Java."
    },
    fundamentos: {
      label: "Fundamentos",
      listTitle: "Fundamentos",
      icon: "◈",
      guide: {
        eyebrow: "Ruta de aprendizaje · 01",
        title: "Fundamentos de Java",
        intro: "Antes de resolver problemas, hay que conocer el vocabulario del lenguaje: qué es una clase, cómo empieza un programa, dónde se guarda un dato y cómo se muestra un resultado.",
        objectives: [
          "Reconocer la estructura mínima de una clase Java.",
          "Diferenciar tipos primitivos, variables y constantes.",
          "Comprender para qué sirven main, System.out.println y los comentarios.",
          "Distinguir el JDK, la JVM y el código fuente."
        ],
        concepts: [
          {
            title: "Clase y método main",
            text: "La clase organiza el código. En los programas de consola iniciales, public static void main(String[] args) es el punto de entrada desde el que comienza la ejecución. Las llaves delimitan bloques y el punto y coma cierra muchas instrucciones."
          },
          {
            title: "Tipos de datos primitivos",
            text: "Java incluye tipos como int para enteros, double para decimales, char para un carácter y boolean para verdadero o falso. Elegir el tipo correcto hace explícito qué clase de valor se espera."
          },
          {
            title: "Variables y constantes",
            text: "Una variable guarda un valor que puede cambiar. Una variable declarada con final solo puede recibir una asignación; por convención, las constantes nombradas suelen escribirse en MAYÚSCULAS_CON_GUION_BAJO."
          },
          {
            title: "Compilar y ejecutar",
            text: "El archivo .java contiene código fuente. El compilador javac lo transforma en bytecode .class y la máquina virtual de Java (JVM) ejecuta ese bytecode. El JDK incluye herramientas para desarrollar y ejecutar programas."
          }
        ],
        exampleTitle: "Ejemplo: variables, tipos y salida",
        example: "public class TipoDato {\n    public static void main(String[] args) {\n        int edad = 18;\n        double promedio = 4.2;\n        char inicial = 'D';\n        boolean inscrito = true;\n        final double PI = 3.14159;\n\n        System.out.println(edad);\n        System.out.println(promedio);\n        System.out.println(inicial);\n        System.out.println(inscrito);\n        System.out.println(PI);\n    }\n}",
        mistakes: [
          "Usar comillas dobles para char: un char utiliza comillas simples; un String utiliza comillas dobles.",
          "Confundir = con ==: el primero asigna un valor y el segundo compara valores primitivos.",
          "Cambiar una constante declarada con final después de inicializarla."
        ],
        docs: [
          { title: "Primeros pasos oficiales con Java", url: "https://dev.java/learn/first-steps/", description: "Preparar el entorno, escribir el primer programa y ejecutarlo." },
          { title: "Fundamentos del lenguaje", url: "https://dev.java/learn/language/constructs/basics/", description: "Variables, tipos, operadores, expresiones y control de flujo." },
          { title: "Java desde cero — DevSchool", url: "https://devschool.es/java/", description: "Lecciones en español organizadas por tema." }
        ],
        video: { start: 4250, title: "Primeros pasos con Java", note: "Curso de MoureDev en español. El vídeo comienza cerca de la sección de primeros pasos; puedes consultar el índice del vídeo para saltar entre lecciones." }
      }
    },
    operadores: {
      label: "Operadores",
      listTitle: "Operadores",
      icon: "±",
      guide: {
        eyebrow: "Ruta de aprendizaje · 02",
        title: "Operadores en Java",
        intro: "Los operadores permiten calcular, asignar, comparar y combinar condiciones. Para entender un resultado, no basta con reconocer los símbolos: también hay que conocer el tipo de dato y la precedencia de cada operación.",
        objectives: [
          "Usar operadores aritméticos y de asignación.",
          "Comparar valores con operadores relacionales.",
          "Combinar condiciones mediante &&, || y !.",
          "Entender el efecto de ++ y -- y la precedencia de las operaciones."
        ],
        concepts: [
          { title: "Aritméticos", text: "+, -, *, / y % permiten sumar, restar, multiplicar, dividir y obtener el residuo de una división. Si se divide un entero entre otro entero, la parte decimal se descarta." },
          { title: "Relacionales", text: "==, !=, <, >, <= y >= producen un boolean. Para objetos como String, == compara referencias; para comparar el contenido textual se utiliza normalmente equals()." },
          { title: "Lógicos", text: "&& significa Y, || significa O y ! niega una condición. En && y || hay cortocircuito: el segundo operando puede no evaluarse si el primero ya determina el resultado." },
          { title: "Asignación e incremento", text: "= asigna; += y -= combinan operación y asignación. ++ y -- incrementan o disminuyen en uno. La diferencia entre forma prefija y sufija importa cuando la expresión usa el valor resultante."
          }
        ],
        exampleTitle: "Ejemplo: combinar operaciones y condiciones",
        example: "int a = 7;\nint b = 2;\nint divisionEntera = a / b; // 3\nint residuo = a % b;       // 1\nboolean mayor = a > b;\nboolean valido = a > 0 && b != 0;\n\nSystem.out.println(divisionEntera);\nSystem.out.println(residuo);\nSystem.out.println(valido);",
        mistakes: [
          "Esperar que 7 / 2 produzca 3.5 cuando ambos operandos son int.",
          "Utilizar == para comparar el contenido de dos cadenas String.",
          "Omitir paréntesis cuando una expresión resulta difícil de leer."
        ],
        docs: [
          { title: "Resumen oficial de operadores", url: "https://dev.java/learn/language/constructs/basics/", description: "Referencia de operadores y expresiones del lenguaje Java." },
          { title: "Java desde cero — Operadores", url: "https://devschool.es/java/", description: "Lección en español dentro del curso de Java." }
        ],
        video: { start: 6803, title: "Operadores en Java", note: "El reproductor se sitúa cerca del bloque de operadores aritméticos; el curso también aborda asignación, comparación y lógica." }
      }
    },
    expresiones: {
      label: "Expresiones",
      listTitle: "Expresiones",
      icon: "ƒ",
      guide: {
        eyebrow: "Ruta de aprendizaje · 03",
        title: "Expresiones y cálculos",
        intro: "Una expresión combina valores, variables, operadores y llamadas a métodos para producir un resultado. Su lectura correcta depende de la precedencia, los tipos numéricos y las conversiones que Java permite.",
        objectives: [
          "Traducir una fórmula matemática a expresiones Java.",
          "Aplicar la precedencia de operadores y utilizar paréntesis.",
          "Identificar divisiones enteras y conversiones de tipos.",
          "Verificar los resultados con datos de prueba sencillos."
        ],
        concepts: [
          { title: "Precedencia", text: "Multiplicación, división y módulo se evalúan antes que suma y resta. Los paréntesis permiten hacer explícita la intención y mejoran la legibilidad." },
          { title: "Tipos y conversiones", text: "El tipo de los operandos afecta al resultado. Una conversión explícita puede cambiar el tipo usado en un cálculo, pero no recupera decimales que ya se hayan perdido en una división entera." },
          { title: "Funciones matemáticas", text: "La clase Math ofrece operaciones como Math.pow(base, exponente), Math.sqrt(valor) y Math.round(valor). Revisa el tipo de retorno y la documentación antes de utilizarlas." }
        ],
        exampleTitle: "Ejemplo: calcular el promedio",
        example: "double nota1 = 4.0;\ndouble nota2 = 3.5;\ndouble nota3 = 4.5;\ndouble promedio = (nota1 + nota2 + nota3) / 3.0;\n\nSystem.out.println(\"Promedio: \" + promedio);",
        mistakes: [
          "Traducir una fórmula sin respetar sus paréntesis.",
          "Dividir dos int y guardar después el resultado en double esperando recuperar los decimales.",
          "No probar los extremos: cero, valores negativos y valores muy grandes."
        ],
        docs: [
          { title: "Fundamentos: expresiones y operadores", url: "https://dev.java/learn/language/constructs/basics/", description: "Conceptos oficiales de expresiones, sentencias y bloques." },
          { title: "Clase Math de Java", url: "https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Math.html", description: "Referencia de operaciones matemáticas disponibles en la biblioteca estándar." }
        ],
        video: { start: 6803, title: "Operadores y expresiones", note: "Revisa el bloque de operadores del curso y practica después traduciendo fórmulas a Java." }
      }
    },
    condicionales: {
      label: "Condicionales",
      listTitle: "Condicionales",
      icon: "⑂",
      guide: {
        eyebrow: "Ruta de aprendizaje · 04",
        title: "Condicionales y decisiones",
        intro: "Un programa puede elegir qué instrucciones ejecutar según una condición. La condición debe producir un boolean y cada rama debe representar una decisión comprensible del problema.",
        objectives: [
          "Construir decisiones con if, else if y else.",
          "Combinar condiciones con operadores relacionales y lógicos.",
          "Utilizar switch cuando hay varias alternativas discretas.",
          "Probar los límites de cada intervalo y los casos no previstos."
        ],
        concepts: [
          { title: "if / else", text: "if ejecuta un bloque si la condición es verdadera. else if permite evaluar alternativas en orden y else cubre los casos restantes." },
          { title: "Condiciones compuestas", text: "Paréntesis y operadores lógicos permiten expresar reglas como edad >= 18 && tieneDocumento. Conviene dividir condiciones largas en variables boolean con nombres claros." },
          { title: "switch", text: "switch organiza varias opciones según el valor de una expresión. En la forma tradicional, break evita continuar accidentalmente al siguiente caso; default cubre valores no contemplados." }
        ],
        exampleTitle: "Ejemplo: clasificar una nota",
        example: "double nota = 3.8;\n\nif (nota >= 3.0) {\n    System.out.println(\"Aprobado\");\n} else {\n    System.out.println(\"No aprobado\");\n}",
        mistakes: [
          "Escribir = en lugar de == cuando se desea comparar.",
          "Ordenar mal los intervalos y dejar valores sin clasificar.",
          "Construir un if demasiado largo cuando varias ramas independientes serían más claras."
        ],
        docs: [
          { title: "Control de flujo en Java", url: "https://dev.java/learn/language/constructs/basics/", description: "Documentación oficial sobre decisiones y sentencias de control." },
          { title: "Curso de Java — Condicionales", url: "https://devschool.es/java/", description: "Material en español sobre if, else y switch." }
        ],
        video: { start: 9908, title: "Condicionales en Java", note: "En el curso, el bloque de condicionales comienza aproximadamente en este minuto." }
      }
    },
    ciclos: {
      label: "Ciclos",
      listTitle: "Ciclos",
      icon: "↻",
      guide: {
        eyebrow: "Ruta de aprendizaje · 05",
        title: "Ciclos y repetición",
        intro: "Los ciclos ejecutan un bloque varias veces. Para razonar sobre ellos, identifica siempre el estado inicial, la condición de continuación, la actualización y la condición de salida.",
        objectives: [
          "Elegir entre for, while y do-while según el problema.",
          "Controlar contadores y acumuladores.",
          "Diseñar ciclos que terminen y evitar bucles infinitos.",
          "Resolver series numéricas mediante seguimiento paso a paso."
        ],
        concepts: [
          { title: "for", text: "Es adecuado cuando la repetición se controla con un contador conocido o una actualización claramente definida. La inicialización, condición y actualización aparecen juntas." },
          { title: "while", text: "Comprueba la condición antes de cada iteración. Si la condición es falsa desde el comienzo, el cuerpo puede no ejecutarse ninguna vez." },
          { title: "do-while", text: "Evalúa la condición al final; por eso el cuerpo se ejecuta al menos una vez. Es útil cuando primero hay que realizar una acción y después decidir si se repite." },
          { title: "Contadores y acumuladores", text: "Un contador suele aumentar para registrar iteraciones. Un acumulador actualiza un resultado parcial, por ejemplo suma += numero. Deben inicializarse de forma correcta." }
        ],
        exampleTitle: "Ejemplo: sumar los números del 1 al 5",
        example: "int suma = 0;\n\nfor (int i = 1; i <= 5; i++) {\n    suma += i;\n}\n\nSystem.out.println(\"Suma: \" + suma); // 15",
        mistakes: [
          "Usar una condición que nunca llega a ser falsa.",
          "Actualizar el contador equivocado o no actualizarlo.",
          "Confundir el número de iteraciones con el último valor del contador."
        ],
        docs: [
          { title: "Sentencias de control de flujo", url: "https://dev.java/learn/language/constructs/basics/", description: "Referencia oficial sobre las estructuras repetitivas." },
          { title: "Curso Java en español", url: "https://devschool.es/java/", description: "Lecciones de bucles y ejercicios de lógica." }
        ],
        video: { start: 15862, title: "Bucles en Java", note: "El enlace comienza en el bloque de bucles y recorre for, while y do-while." }
      }
    },
    metodos: {
      label: "Métodos",
      listTitle: "Métodos",
      icon: "λ",
      guide: {
        eyebrow: "Ruta de aprendizaje · 06",
        title: "Métodos y reutilización",
        intro: "Un método encapsula una tarea con un nombre. Dividir un problema en métodos pequeños evita duplicación, facilita las pruebas y permite explicar el programa por responsabilidades.",
        objectives: [
          "Declarar métodos con tipo de retorno, nombre y parámetros.",
          "Diferenciar parámetros, argumentos y valores de retorno.",
          "Comprender void frente a métodos que devuelven un dato.",
          "Descomponer un problema en operaciones reutilizables."
        ],
        concepts: [
          { title: "Parámetros y argumentos", text: "Los parámetros se declaran en la definición del método; los argumentos son los valores enviados cuando se realiza la llamada." },
          { title: "Retorno", text: "El tipo antes del nombre indica qué valor devuelve el método. void indica que no devuelve un valor. En un método no void, cada ruta de ejecución debe satisfacer las reglas de retorno." },
          { title: "Responsabilidad única", text: "Un método debería realizar una tarea coherente. Nombres descriptivos y parámetros concretos ayudan a comprender el código sin tener que leer todo el programa." }
        ],
        exampleTitle: "Ejemplo: método con parámetros y retorno",
        example: "public static int sumar(int a, int b) {\n    return a + b;\n}\n\npublic static void main(String[] args) {\n    int resultado = sumar(4, 6);\n    System.out.println(resultado); // 10\n}",
        mistakes: [
          "Confundir imprimir un valor con devolverlo mediante return.",
          "Llamar un método sin proporcionar los argumentos requeridos.",
          "Hacer que un método resuelva demasiadas tareas sin relación."
        ],
        docs: [
          { title: "Aprender Java — documentación oficial", url: "https://dev.java/learn/", description: "Guías oficiales para profundizar en la sintaxis y el diseño de programas." },
          { title: "Curso de Java en español", url: "https://devschool.es/java/", description: "Lecciones sobre métodos, parámetros y retorno." }
        ],
        video: { start: 18100, title: "Funciones y métodos", note: "El curso llega al bloque de funciones y métodos cerca de este punto." }
      }
    },
    cadenas: {
      label: "Cadenas",
      listTitle: "Cadenas",
      icon: "Aa",
      guide: {
        eyebrow: "Ruta de aprendizaje · 07",
        title: "Cadenas de texto en Java",
        intro: "String representa texto. Además de concatenar cadenas, conviene aprender a consultar su longitud, obtener caracteres y comparar contenido sin confundirlo con la identidad de los objetos.",
        objectives: [
          "Declarar cadenas y concatenar texto con valores.",
          "Consultar la longitud con length() y caracteres con charAt().",
          "Comparar contenido usando equals().",
          "Comprender que String es inmutable y que la codificación de texto importa."
        ],
        concepts: [
          { title: "String e inmutabilidad", text: "Un objeto String no cambia su contenido después de crearse. Los métodos que transforman texto devuelven otra cadena; para guardar el resultado, asígnalo a una variable." },
          { title: "Longitud e índices", text: "length() devuelve la longitud de la cadena y charAt(indice) obtiene un carácter. Los índices empiezan en cero; para acceder al último carácter se usa length() - 1 si la cadena no está vacía." },
          { title: "Comparación", text: "equals() compara el contenido de dos cadenas. == no debe utilizarse como sustituto general de equals() para comprobar si dos textos son iguales." },
          { title: "Texto y bytes", text: "Una cadena contiene caracteres; una secuencia de bytes representa datos codificados. Para transformar texto a bytes, elige una codificación explícita como UTF-8 cuando el ejercicio lo requiera." }
        ],
        exampleTitle: "Ejemplo: recorrer una cadena",
        example: "String lenguaje = \"Java\";\n\nSystem.out.println(lenguaje.length()); // 4\nSystem.out.println(lenguaje.charAt(0)); // J\nSystem.out.println(lenguaje.equals(\"Java\")); // true\nSystem.out.println(lenguaje.toUpperCase()); // JAVA",
        mistakes: [
          "Intentar acceder a charAt(length()) en vez de al último índice válido.",
          "Comparar cadenas con == cuando se busca igualdad de contenido.",
          "Olvidar guardar el resultado de un método que devuelve una cadena nueva."
        ],
        docs: [
          { title: "Clase String — API oficial de Java", url: "https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html", description: "Referencia de métodos, longitud, búsqueda, comparación y transformación." },
          { title: "Curso de Java — cadenas", url: "https://devschool.es/java/", description: "Lecciones en español sobre String y sus métodos." }
        ],
        video: { start: 8140, title: "Strings en Java", note: "El curso comienza el bloque de cadenas y muestra operaciones frecuentes sobre texto." }
      }
    },
    retos: {
      label: "Retos",
      listTitle: "Retos",
      icon: "✳",
      guide: {
        eyebrow: "Ruta de aprendizaje · 08",
        title: "Retos de lógica y resolución de problemas",
        intro: "Un reto no empieza escribiendo código: comienza por comprender el enunciado, identificar las entradas y salidas, diseñar una estrategia y comprobarla con casos representativos.",
        objectives: [
          "Separar un problema grande en pasos manejables.",
          "Identificar entradas, salidas, restricciones y casos límite.",
          "Usar patrones, expresiones, condicionales y ciclos para modelar la solución.",
          "Validar resultados con pruebas manuales antes de dar por terminado el programa."
        ],
        concepts: [
          { title: "Descomposición", text: "Divide la tarea en subtareas con objetivos concretos. Si una operación puede expresarse como un método independiente, será más fácil probarla y reutilizarla." },
          { title: "Abstracción y patrones", text: "Quédate con los datos que realmente afectan la solución. Busca regularidades: incrementos, límites, clasificaciones, acumulaciones y relaciones entre valores." },
          { title: "Casos de prueba", text: "Prueba un caso normal, un caso límite y un caso inválido cuando aplique. Comprueba tanto el resultado como el comportamiento esperado ante datos inesperados." },
          { title: "Código legible", text: "Los nombres claros, la indentación consistente y los comentarios que explican el porqué reducen el coste de mantenimiento. Un programa correcto también debe poder entenderse." }
        ],
        exampleTitle: "Plantilla para analizar cualquier reto",
        example: "// 1. Entradas: ¿qué datos recibo?\n// 2. Salidas: ¿qué debo producir?\n// 3. Restricciones: ¿qué límites debo respetar?\n// 4. Estrategia: ¿qué pasos resuelven el problema?\n// 5. Pruebas: ¿qué casos confirman que funciona?",
        mistakes: [
          "Empezar a programar sin aclarar qué pide el enunciado.",
          "Probar únicamente un caso favorable.",
          "Mezclar todo en main cuando el problema ya necesita varias responsabilidades."
        ],
        docs: [
          { title: "Primeros pasos y fundamentos oficiales", url: "https://dev.java/learn/first-steps/", description: "Practica con programas pequeños y ejecútalos de forma repetible." },
          { title: "Java desde cero — DevSchool", url: "https://devschool.es/java/", description: "Temario en español con ejercicios por cada concepto." }
        ],
        video: { start: 17993, title: "Ejercicios y bucles", note: "Punto de partida aproximado para practicar ejercicios después de estudiar los conceptos básicos." }
      }
    }
  };

  /* ================================================================
     2. CATÁLOGO DE EJERCICIOS
     Para agregar un archivo, añade un objeto con title, category, desc
     y path. El contador de cada categoría se actualiza automáticamente.
     ================================================================ */
  const EXERCISES = [
    { title: "TipoDato.java", category: "fundamentos", desc: "Uso y declaración de los diferentes tipos de datos primitivos en Java.", path: "ejercicios/fundamentos/TipoDato.java" },
    { title: "VariablesyConstantes.java", category: "fundamentos", desc: "Diferencia entre variables modificables y constantes con final.", path: "ejercicios/fundamentos/VariablesyConstantes.java" },
    { title: "EjercicioNovato.java", category: "fundamentos", desc: "Prácticas iniciales de sintaxis e impresión en consola.", path: "ejercicios/fundamentos/EjercicioNovato.java" },

    { title: "Operadores.java", category: "operadores", desc: "Operaciones aritméticas, lógicas y relacionales básicas.", path: "ejercicios/operadores/Operadores.java" },
    { title: "PracticaOperadores.java", category: "operadores", desc: "Ejercicios de asignación e incremento y decremento.", path: "ejercicios/operadores/PracticaOperadores.java" },
    { title: "AnalizadorAbecedario.java", category: "operadores", desc: "Análisis y operaciones con caracteres del abecedario.", path: "ejercicios/operadores/AnalizadorAbecedario.java" },

    { title: "CuboNumeros.java", category: "expresiones", desc: "Cálculo de potencias y cubos mediante expresiones matemáticas.", path: "ejercicios/expresiones/CuboNumeros.java" },
    { title: "MatematicaBrillante.java", category: "expresiones", desc: "Evaluación de fórmulas y operaciones aritméticas.", path: "ejercicios/expresiones/MatematicaBrillante.java" },

    { title: "NotaDefinitiva.java", category: "condicionales", desc: "Cálculo de notas y estado de aprobación del estudiante.", path: "ejercicios/condicionales/NotaDefinitiva.java" },
    { title: "DescuentoTienda.java", category: "condicionales", desc: "Cálculo de descuentos según el monto de compra.", path: "ejercicios/condicionales/DescuentoTienda.java" },
    { title: "ClasificacionNumero.java", category: "condicionales", desc: "Determina si un número es positivo, negativo, par o impar.", path: "ejercicios/condicionales/ClasificacionNumero.java" },
    { title: "PasajeAvion.java", category: "condicionales", desc: "Cobro de boletos según distancia y edad del pasajero.", path: "ejercicios/condicionales/PasajeAvion.java" },

    { title: "FactorialOcho.java", category: "ciclos", desc: "Cálculo iterativo del factorial usando bucles.", path: "ejercicios/ciclos/FactorialOcho.java" },
    { title: "SumaCuadrados.java", category: "ciclos", desc: "Suma de los cuadrados de una serie de números.", path: "ejercicios/ciclos/SumaCuadrados.java" },
    { title: "SerieFraccionaria.java", category: "ciclos", desc: "Generación y cálculo de una serie fraccionaria.", path: "ejercicios/ciclos/SerieFraccionaria.java" },
    { title: "MultiplicacionImpares.java", category: "ciclos", desc: "Multiplicación acumulada de números impares en un rango.", path: "ejercicios/ciclos/MultiplicacionImpares.java" },

    { title: "OperacionesNumeros.java", category: "metodos", desc: "Operaciones matemáticas organizadas en métodos reutilizables.", path: "ejercicios/metodos/OperacionesNumeros.java" },
    { title: "Reutilizacion.java", category: "metodos", desc: "Llamadas a métodos con parámetros y valores de retorno.", path: "ejercicios/metodos/Reutilizacion.java" },

    { title: "EjerciciosStrings.java", category: "cadenas", desc: "Operaciones con String: manipulación, longitud y caracteres.", path: "ejercicios/cadenas/EjerciciosStrings.java" },
    { title: "TraductorEspanolBinario.java", category: "cadenas", desc: "Conversión de texto a su representación binaria.", path: "ejercicios/cadenas/TraductorEspanolBinario.java" },
    { title: "DisenoAscii.java", category: "cadenas", desc: "Generación de figuras y arte ASCII desde Java.", path: "ejercicios/cadenas/DisenoAscii.java" },

    { title: "AnalizadorEmocional.java", category: "retos", desc: "Ejercicio de análisis de patrones y clasificación lógica.", path: "ejercicios/retos/AnalizadorEmocional.java" },
    { title: "AtletasDelFuturo.java", category: "retos", desc: "Cálculo de estadísticas de rendimiento deportivo.", path: "ejercicios/retos/AtletasDelFuturo.java" },
    { title: "EDEQFinanzas.java", category: "retos", desc: "Simulación de estados financieros y cálculos tarifarios.", path: "ejercicios/retos/EDEQFinanzas.java" }
  ];

  /* ================================================================
     3. REFERENCIAS AL DOM Y ESTADO DE LA INTERFAZ
     El estado separa la categoría activa, la búsqueda y la vista abierta.
     ================================================================ */
  /** Busca un elemento requerido y falla con un mensaje útil si falta. */
  function getRequiredElement(id) {
    const element = document.getElementById(id);

    if (!element) {
      throw new Error(`No se encontró el elemento requerido #${id} en index.html.`);
    }

    return element;
  }

  const app = getRequiredElement("app");
  const categoryNav = getRequiredElement("categories");
  const list = getRequiredElement("exerciseList");
  const listTitle = getRequiredElement("listTitle");
  const resultCount = getRequiredElement("resultCount");
  const searchInput = getRequiredElement("search");
  const detailContent = getRequiredElement("detailContent");
  const themeToggle = getRequiredElement("themeToggle");
  const backButton = getRequiredElement("backButton");

  let activeCategory = "todos";
  let searchQuery = "";
  let selectedPath = "";
  let currentView = { type: "home", category: "todos" };

  /* ================================================================
     4. FUNCIONES AUXILIARES DE CONTENIDO
     Los textos de datos se insertan como textContent para evitar que
     nombres o descripciones se interpreten como HTML.
     ================================================================ */
  function createElement(tagName, className, text) {
    const element = document.createElement(tagName);
    if (className) element.className = className;
    if (text !== undefined) element.textContent = text;
    return element;
  }

  function createExternalLink(title, url, description) {
    const card = createElement("article", "resource-card");
    const link = createElement("a", "", title);
    link.href = url;
    link.target = "_blank";
    link.rel = "noopener noreferrer";
    card.append(link);

    if (description) {
      card.append(createElement("p", "", description));
    }

    return card;
  }

  function createList(items, ordered = false) {
    const listElement = document.createElement(ordered ? "ol" : "ul");
    items.forEach((item) => listElement.append(createElement("li", "", item)));
    return listElement;
  }

  function createSection(title, content, className = "content-section") {
    const section = createElement("section", className);
    section.append(createElement("h2", "", title));
    if (typeof content === "string") {
      section.append(createElement("p", "", content));
    } else if (content) {
      section.append(content);
    }
    return section;
  }

  function createCodeBlock(codeText) {
    const pre = createElement("pre", "code-block");
    const code = createElement("code", "", codeText);
    pre.append(code);
    return pre;
  }

  function createVideoSection(video) {
    const section = createSection("Vídeo recomendado en español", null);
    const wrapper = createElement("div", "video-wrap");
    const player = document.createElement("iframe");
    player.src = `https://www.youtube-nocookie.com/embed/JOAqpdM36wI?start=${video.start}`;
    player.title = `${video.title} — curso de Java en español`;
    player.loading = "lazy";
    player.referrerPolicy = "strict-origin-when-cross-origin";
    player.allow = "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share";
    player.allowFullscreen = true;
    wrapper.append(player);
    section.append(wrapper, createElement("p", "video-caption", video.note));

    const watchLink = createElement("a", "", "Abrir el vídeo en YouTube");
    watchLink.href = `https://www.youtube.com/watch?v=JOAqpdM36wI&t=${video.start}s`;
    watchLink.target = "_blank";
    watchLink.rel = "noopener noreferrer";
    section.append(watchLink);
    return section;
  }

  /* ================================================================
     5. RENDERIZADO DE NAVEGACIÓN Y LISTA
     El número de ejercicios se calcula a partir de EXERCISES, de modo
     que no hay contadores escritos a mano en el HTML.
     ================================================================ */
  function getExerciseCount(categoryKey) {
    if (categoryKey === "todos") return EXERCISES.length;
    return EXERCISES.filter((exercise) => exercise.category === categoryKey).length;
  }

  function renderCategories() {
    categoryNav.replaceChildren();

    Object.entries(CATEGORY_DATA).forEach(([key, category]) => {
      const button = createElement("button", "category");
      button.type = "button";
      button.dataset.category = key;
      button.setAttribute("aria-pressed", String(activeCategory === key));
      button.classList.toggle("active", activeCategory === key);

      button.append(createElement("span", "category-icon", category.icon));
      button.append(document.createTextNode(category.label));
      button.append(createElement("span", "count", String(getExerciseCount(key))));
      categoryNav.append(button);
    });
  }

  function getFilteredExercises() {
    return EXERCISES.filter((exercise) => {
      const matchesCategory = activeCategory === "todos" || exercise.category === activeCategory;
      const categoryName = CATEGORY_DATA[exercise.category].label;
      const searchableText = `${exercise.title} ${exercise.desc} ${exercise.path} ${categoryName}`;
      const matchesQuery = searchableText.toLocaleLowerCase("es").includes(searchQuery);
      return matchesCategory && matchesQuery;
    });
  }

  function renderExerciseList() {
    const results = getFilteredExercises();
    listTitle.textContent = CATEGORY_DATA[activeCategory].listTitle;
    resultCount.textContent = String(results.length);
    list.replaceChildren();

    if (results.length === 0) {
      list.append(createElement("div", "empty", "No se encontraron ejercicios con esa búsqueda."));
      return;
    }

    results.forEach((exercise) => {
      const button = createElement("button", "exercise");
      button.type = "button";
      button.classList.toggle("active", selectedPath === exercise.path);
      button.setAttribute("aria-pressed", String(selectedPath === exercise.path));

      button.append(createElement("strong", "", exercise.title));
      button.append(createElement("span", "desc", exercise.desc));
      button.addEventListener("click", () => showExercise(exercise));
      list.append(button);
    });
  }

  /* ================================================================
     6. PORTADA "TODOS": HISTORIA, CONCEPTOS GENERALES Y MANTENEDOR
     Este contenido solo aparece al seleccionar Todos, antes de abrir
     un ejercicio específico.
     ================================================================ */
  function renderHome() {
    detailContent.className = "content guide-page";
    detailContent.replaceChildren();
    detailContent.append(
      createElement("div", "eyebrow", "Biblioteca académica · Java UQ"),
      createElement("h1", "Java: del primer programa a la lógica"),
      createElement(
        "p",
        "lead",
        "Una guía personal de estudio para acompañar Lógica de Programación. Explora el contexto de Java, repasa conceptos clave y entra a cada categoría para encontrar explicaciones, ejemplos, documentación y vídeos en español."
      )
    );

    const history = createElement("div", "timeline");
    [
      {
        year: "1991",
        title: "Proyecto Green y lenguaje Oak",
        text: "Un equipo de Sun Microsystems comenzó a investigar software para dispositivos electrónicos. El lenguaje creado durante ese trabajo recibió inicialmente el nombre Oak."
      },
      {
        year: "1995",
        title: "Java se presenta públicamente",
        text: "Sun presentó Java durante la expansión de la web. La portabilidad del bytecode y la máquina virtual se volvieron elementos centrales de su propuesta."
      },
      {
        year: "Después",
        title: "Una plataforma que evoluciona",
        text: "Java fue ampliando sus bibliotecas, herramientas y usos. El lenguaje y su plataforma continúan evolucionando; por eso conviene consultar documentación actualizada, no depender solo de apuntes antiguos."
      }
    ].forEach((item) => {
      const card = createElement("article", "timeline-card");
      card.append(
        createElement("div", "timeline-year", item.year),
        createElement("h3", "", item.title),
        createElement("p", "", item.text)
      );
      history.append(card);
    });
    detailContent.append(createSection("Un poco de historia", history));

    const foundations = createElement("div", "info-grid");
    [
      {
        title: "Java",
        text: "Lenguaje de programación y plataforma de desarrollo. Es importante separar el lenguaje de las herramientas que permiten compilar y ejecutar sus programas."
      },
      {
        title: "JDK",
        text: "Java Development Kit: conjunto de herramientas para desarrollar, compilar y depurar aplicaciones Java."
      },
      {
        title: "JVM",
        text: "Java Virtual Machine: ejecuta bytecode Java. Ayuda a que un programa compilado pueda correr en entornos compatibles con una JVM."
      },
      {
        title: "Código fuente y bytecode",
        text: "Normalmente escribimos archivos .java; javac compila el código fuente y produce archivos .class que contienen bytecode."
      }
    ].forEach((item) => {
      const card = createElement("article", "info-card");
      card.append(createElement("h3", "", item.title), createElement("p", "", item.text));
      foundations.append(card);
    });
    detailContent.append(createSection("Generalidades: las piezas básicas", foundations));

    const workflow = createList([
      "Comprender el problema y precisar las entradas y salidas.",
      "Diseñar los pasos de la solución antes de escribir el código.",
      "Traducir el algoritmo a Java usando nombres claros e indentación consistente.",
      "Compilar, ejecutar y probar también casos límite.",
      "Refactorizar y documentar lo necesario para que el código sea fácil de mantener."
    ], true);
    detailContent.append(createSection("Una forma sensata de estudiar programación", workflow));

    const compileBox = createElement("div", "callout");
    compileBox.append(
      createElement("strong", "", "Ejemplo desde una terminal"),
      createElement("p", "", "Desde la carpeta que contiene el archivo, puedes compilar y luego ejecutar una clase sencilla:")
    );
    compileBox.append(createCodeBlock("javac HolaMundo.java\njava HolaMundo"));
    compileBox.append(createElement("p", "small muted", "Este ejemplo supone que la clase pública se llama HolaMundo y que el JDK está instalado y disponible en el PATH."));
    detailContent.append(createSection("Del archivo al programa en ejecución", compileBox));

    const referenceGrid = createElement("div", "resource-grid");
    [
      { title: "Documentación oficial: aprende Java", url: "https://dev.java/learn/", description: "Rutas de aprendizaje mantenidas para desarrolladores Java." },
      { title: "Primeros pasos oficiales", url: "https://dev.java/learn/first-steps/", description: "Configuración del entorno, primer código y ejecución." },
      { title: "Fundamentos del lenguaje", url: "https://dev.java/learn/language/constructs/basics/", description: "Tipos, variables, expresiones, operadores y control de flujo." },
      { title: "Curso en español: Java desde cero", url: "https://www.youtube.com/watch?v=JOAqpdM36wI&t=823s", description: "Curso largo de MoureDev con capítulos desde la introducción hasta métodos, cadenas y POO." }
    ].forEach((item) => referenceGrid.append(createExternalLink(item.title, item.url, item.description)));
    detailContent.append(createSection("Recursos para continuar", referenceGrid));

    const video = createVideoSection({
      start: 823,
      title: "Historia e introducción a Java",
      note: "Curso en español de MoureDev. Este punto se sitúa cerca del bloque dedicado a la historia de Java; el índice del vídeo permite saltar a otros temas."
    });
    detailContent.append(video);
    const maintainer = createElement("section", "content-section");
    maintainer.append(createElement("h2", "", "Sobre el sitio y su mantenedor"));

    // Tux es el avatar decorativo de la sección del mantenedor.
    const profile = createElement("div", "profile-row");
    const avatar = document.createElement("img");
    avatar.className = "profile-avatar";
    avatar.src = "https://upload.wikimedia.org/wikipedia/commons/a/af/Tux.png";
    avatar.alt = "Tux, la mascota de Linux";
    avatar.loading = "lazy";
    avatar.referrerPolicy = "no-referrer";
    profile.append(avatar);

    const profileInfo = document.createElement("div");
    profileInfo.append(
      createElement("h3", "", "Daniel Barrientos"),
      createElement(
        "p",
        "",
        "Estudiante de Ingeniería de Sistemas y Computación en la Universidad del Quindío y de Análisis y Desarrollo de Software en el SENA."
      ),
      createElement(
        "p",
        "muted small",
        "Este sitio es un proyecto académico personal creado para organizar ejercicios, apuntes y recursos de Lógica de Programación. No es una página oficial de la Universidad del Quindío ni sustituye las orientaciones del curso."
      )
    );

    const github = createElement("a", "", "Ver perfil de GitHub: DanielBarrientos727");
    github.href = "https://github.com/DanielBarrientos727";
    github.target = "_blank";
    github.rel = "noopener noreferrer";
    profileInfo.append(github);

    profile.append(profileInfo);
    maintainer.append(profile);
    detailContent.append(maintainer);

    const footer = createElement("footer", "site-footer", "Contenido educativo elaborado para estudio personal. Verifica las versiones, licencias y recomendaciones directamente en las fuentes enlazadas.");
    detailContent.append(footer);
  }

  /* ================================================================
     7. VISTA WIKI DE UNA CATEGORÍA
     Cada botón del panel izquierdo abre esta explicación. El listado de
     ejercicios permanece filtrado por esa categoría en el panel central.
     ================================================================ */
  function renderCategoryGuide(categoryKey) {
    const category = CATEGORY_DATA[categoryKey];
    const guide = category.guide;

    detailContent.className = "content guide-page";
    detailContent.replaceChildren();
    detailContent.append(
      createElement("div", "eyebrow", guide.eyebrow),
      createElement("h1", "", guide.title),
      createElement("p", "lead", guide.intro)
    );

    detailContent.append(createSection("Qué deberías aprender", createList(guide.objectives)));

    const concepts = createElement("div", "concept-grid");
    guide.concepts.forEach((concept) => {
      const card = createElement("article", "concept-card");
      card.append(createElement("h3", "", concept.title), createElement("p", "", concept.text));
      concepts.append(card);
    });
    detailContent.append(createSection("Conceptos explicados", concepts));

    detailContent.append(createSection(guide.exampleTitle, createCodeBlock(guide.example)));
    detailContent.append(createSection("Errores frecuentes", createList(guide.mistakes)));

    const resources = createElement("div", "resource-grid");
    guide.docs.forEach((resource) => {
      resources.append(createExternalLink(resource.title, resource.url, resource.description));
    });
    detailContent.append(createSection("Documentación y lecturas recomendadas", resources));
    detailContent.append(createVideoSection(guide.video));

    const relatedExercises = EXERCISES.filter((exercise) => exercise.category === categoryKey).length;
    const note = createElement("div", "callout");
    note.append(
      createElement("strong", "", `Práctica disponible: ${relatedExercises} ejercicio(s)`),
      createElement("p", "", "Elige un archivo en la lista central para abrir su ficha y consultar la ruta correspondiente.")
    );
    detailContent.append(note);
  }

  /* ================================================================
     8. VISTA DE UN EJERCICIO
     Se conserva la ficha de archivo del diseño original: categoría,
     nombre, descripción y ruta para copiar. La teoría se consulta desde
     el botón de la categoría correspondiente.
     ================================================================ */
  function renderExerciseDetails(exercise) {
    detailContent.className = "content exercise-details";
    detailContent.replaceChildren();

    const categoryName = CATEGORY_DATA[exercise.category].label;
    detailContent.append(
      createElement("div", "eyebrow", categoryName),
      createElement("h1", "", exercise.title),
      createElement("p", "description", exercise.desc)
    );

    const label = createElement("div", "path-label", "Ruta del archivo");
    const pathBox = createElement("div", "path-box");
    const path = createElement("code", "", exercise.path);
    const copyButton = createElement("button", "plain-button", "Copiar ruta");
    copyButton.type = "button";
    copyButton.addEventListener("click", () => copyPath(exercise.path, copyButton));
    pathBox.append(path, copyButton);
    detailContent.append(label, pathBox);

    const guideLink = createElement(
      "button",
      "plain-button guide-link-button",
      `Consultar teoría: ${categoryName}`
    );
    guideLink.type = "button";
    guideLink.addEventListener("click", () => showCategory(exercise.category));
    detailContent.append(guideLink);

    const note = createElement("div", "callout");
    note.append(
      createElement("strong", "", "Nota de mantenimiento"),
      createElement("p", "", "Esta ficha muestra los metadatos y la ruta declarada en el catálogo. No lee automáticamente el contenido del archivo .java; para explicar línea por línea un ejercicio, esa explicación debe añadirse cuando se revise su código real.")
    );
    detailContent.append(note);
  }

  /** Copia la ruta del archivo y comunica el resultado al usuario. */
  async function copyPath(path, button) {
    const originalLabel = button.textContent;

    try {
      await copyTextToClipboard(path);
      button.textContent = "Copiado ✓";
    } catch {
      button.textContent = "Copia no disponible";
    } finally {
      window.setTimeout(() => {
        button.textContent = originalLabel;
      }, 1400);
    }
  }

  /**
   * Prefiere la API moderna del portapapeles y usa un respaldo cuando
   * el navegador o el contexto local no permiten navigator.clipboard.
   */
  async function copyTextToClipboard(text) {
    if (navigator.clipboard?.writeText && window.isSecureContext) {
      await navigator.clipboard.writeText(text);
      return;
    }

    const temporaryField = document.createElement("textarea");
    temporaryField.value = text;
    temporaryField.setAttribute("readonly", "");
    temporaryField.style.position = "fixed";
    temporaryField.style.opacity = "0";
    temporaryField.style.pointerEvents = "none";
    document.body.append(temporaryField);
    temporaryField.select();

    let copied = false;

    try {
      copied = document.execCommand("copy");
    } finally {
      temporaryField.remove();
    }

    if (!copied) {
      throw new Error("El navegador no permitió copiar la ruta.");
    }
  }

  /* ================================================================
     9. NAVEGACIÓN ENTRE PORTADA, CATEGORÍAS Y EJERCICIOS
     ================================================================ */
  function renderCurrentView() {
    if (currentView.type === "home") {
      renderHome();
      return;
    }

    if (currentView.type === "category") {
      renderCategoryGuide(currentView.category);
      return;
    }

    const exercise = EXERCISES.find((item) => item.path === currentView.path);
    if (exercise) renderExerciseDetails(exercise);
  }

  function renderAll() {
    renderCategories();
    renderExerciseList();
    renderCurrentView();
  }

  function showCategory(categoryKey) {
    // La navegación solo debe aceptar categorías definidas en el catálogo.
    if (!Object.hasOwn(CATEGORY_DATA, categoryKey)) return;

    activeCategory = categoryKey;
    selectedPath = "";
    currentView = categoryKey === "todos"
      ? { type: "home", category: "todos" }
      : { type: "category", category: categoryKey };

    renderAll();
    showDetailsOnSmallScreen();
  }

  function showExercise(exercise) {
    selectedPath = exercise.path;
    currentView = { type: "exercise", path: exercise.path };
    renderCategories();
    renderExerciseList();
    renderCurrentView();
    showDetailsOnSmallScreen();
  }

  function showDetailsOnSmallScreen() {
    if (window.matchMedia("(max-width: 650px)").matches) {
      app.classList.add("show-details");
    }
  }

  /* ================================================================
     10. EVENTOS
     ================================================================ */
  categoryNav.addEventListener("click", (event) => {
    const button = event.target.closest("[data-category]");
    if (!button) return;
    showCategory(button.dataset.category);
  });

  searchInput.addEventListener("input", () => {
    searchQuery = searchInput.value.trim().toLocaleLowerCase("es");
    renderCategories();
    renderExerciseList();
  });

  themeToggle.addEventListener("click", () => {
    const root = document.documentElement;
    root.dataset.theme = root.dataset.theme === "mocha" ? "latte" : "mocha";
    themeToggle.textContent = root.dataset.theme === "mocha" ? "☼ Cambiar tema" : "☾ Cambiar tema";
  });

  backButton.addEventListener("click", () => {
    app.classList.remove("show-details");
  });

  /* Primera carga: muestra la portada general en la categoría Todos. */
  renderAll();
})();

// =========================================
// AVISO DE LANZAMIENTO: JAVA UQ COMMUNITY
// Se muestra una vez por sesión de pestaña.
// =========================================

(() => {
    "use strict";

    const announcement = document.getElementById(
        "communityAnnouncement"
    );

    if (!announcement || typeof announcement.showModal !== "function") {
        return;
    }

    const storageKey = "javaUQCommunityAnnouncementSeen";

    // Evita volver a mostrar el aviso durante la misma sesión.
    try {
        if (sessionStorage.getItem(storageKey) === "true") {
            return;
        }
    } catch (error) {
        // Si el almacenamiento está bloqueado, el aviso sigue funcionando.
    }

    const markAsSeen = () => {
        try {
            sessionStorage.setItem(storageKey, "true");
        } catch (error) {
            // El cierre sigue funcionando aunque no haya almacenamiento.
        }
    };

    const closeAnnouncement = () => {
        markAsSeen();

        if (announcement.open) {
            announcement.close();
        }
    };

    // Botón de cerrar, continuar estudiando y enlace a la comunidad.
    announcement
        .querySelectorAll("[data-close-announcement]")
        .forEach((element) => {
            element.addEventListener("click", closeAnnouncement);
        });

    // Cerrar al hacer clic en el fondo exterior del diálogo.
    announcement.addEventListener("click", (event) => {
        if (event.target === announcement) {
            closeAnnouncement();
        }
    });

    // Registrar también el cierre mediante la tecla Escape.
    announcement.addEventListener("cancel", markAsSeen);

    // Mostrar el aviso al iniciar la página.
    announcement.showModal();
})();