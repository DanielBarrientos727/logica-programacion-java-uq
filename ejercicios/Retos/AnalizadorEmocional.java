
import java.util.Scanner;

public class AnalizadorEmocional {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // =========================================
        // SISTEMA DE ANALISIS EMOCIONAL
        // Version 1.0
        // =========================================

        System.out.println("========================================");
        System.out.println("       ANALIZADOR EMOCIONAL");
        System.out.println("========================================");
        System.out.println("Puedo analizar cuatro emociones:");
        System.out.println("Felicidad, enojo, tristeza y tranquilidad.");
        System.out.println("----------------------------------------");

        System.out.print("Escribe un mensaje: ");
        String mensaje = entrada.nextLine();

        // Convertimos el mensaje a minusculas
        String texto = mensaje.toLowerCase();

        // Contadores para las emociones
        int felicidad = 0;
        int enojo = 0;
        int tristeza = 0;
        int tranquilidad = 0;

        // =========================================
        // DETECCION DE FELICIDAD
        // =========================================

        if (texto.contains("feliz")) {
            felicidad = felicidad + 1;
        }

        if (texto.contains("alegre")) {
            felicidad = felicidad + 1;
        }

        if (texto.contains("genial")) {
            felicidad = felicidad + 1;
        }

        if (texto.contains("increible")) {
            felicidad = felicidad + 1;
        }

        if (texto.contains("encanta")) {
            felicidad = felicidad + 1;
        }

        if (texto.contains("emocionado")) {
            felicidad = felicidad + 1;
        }

        if (texto.contains("gracias")) {
            felicidad = felicidad + 1;
        }

        // =========================================
        // DETECCION DE ENOJO
        // =========================================

        if (texto.contains("enojado")) {
            enojo = enojo + 1;
        }

        if (texto.contains("odio")) {
            enojo = enojo + 1;
        }

        if (texto.contains("harto")) {
            enojo = enojo + 1;
        }

        if (texto.contains("molesto")) {
            enojo = enojo + 1;
        }

        if (texto.contains("rabia")) {
            enojo = enojo + 1;
        }

        if (texto.contains("furioso")) {
            enojo = enojo + 1;
        }

        if (texto.contains("estupido")) {
            enojo = enojo + 1;
        }

        // =========================================
        // DETECCION DE TRISTEZA
        // =========================================

        if (texto.contains("triste")) {
            tristeza = tristeza + 1;
        }

        if (texto.contains("llorar")) {
            tristeza = tristeza + 1;
        }

        if (texto.contains("solo")) {
            tristeza = tristeza + 1;
        }

        if (texto.contains("decepcionado")) {
            tristeza = tristeza + 1;
        }

        if (texto.contains("desanimado")) {
            tristeza = tristeza + 1;
        }

        if (texto.contains("extraño")) {
            tristeza = tristeza + 1;
        }

        if (texto.contains("mal")) {
            tristeza = tristeza + 1;
        }

        // =========================================
        // DETECCION DE TRANQUILIDAD
        // =========================================

        if (texto.contains("tranquilo")) {
            tranquilidad = tranquilidad + 1;
        }

        if (texto.contains("relajado")) {
            tranquilidad = tranquilidad + 1;
        }

        if (texto.contains("en paz")) {
            tranquilidad = tranquilidad + 1;
        }

        if (texto.contains("sin problema")) {
            tranquilidad = tranquilidad + 1;
        }

        if (texto.contains("todo bien")) {
            tranquilidad = tranquilidad + 1;
        }

        // =========================================
        // INFORME DE RESULTADOS
        // =========================================

        System.out.println("");
        System.out.println("========================================");
        System.out.println("          INFORME EMOCIONAL");
        System.out.println("========================================");

        System.out.println("Mensaje analizado: " + mensaje);

        System.out.println("");
        System.out.println("Puntos de felicidad: " + felicidad);
        System.out.println("Puntos de enojo: " + enojo);
        System.out.println("Puntos de tristeza: " + tristeza);
        System.out.println("Puntos de tranquilidad: " + tranquilidad);

        System.out.println("");
        System.out.println("--------- DIAGNOSTICO DEL TEXTO --------");

        // Identificamos la emocion dominante

        if (felicidad == 0 && enojo == 0
                && tristeza == 0 && tranquilidad == 0) {

            System.out.println("No pude identificar una emocion.");
            System.out.println("El mensaje puede ser neutral o ambiguo.");

        } else if (felicidad > enojo
                && felicidad > tristeza
                && felicidad > tranquilidad) {

            System.out.println("EMOCION DETECTADA: FELICIDAD");
            System.out.println("El mensaje contiene expresiones positivas.");

        } else if (enojo > felicidad
                && enojo > tristeza
                && enojo > tranquilidad) {

            System.out.println("EMOCION DETECTADA: ENOJO");
            System.out.println("El mensaje contiene expresiones de frustracion.");

        } else if (tristeza > felicidad
                && tristeza > enojo
                && tristeza > tranquilidad) {

            System.out.println("EMOCION DETECTADA: TRISTEZA");
            System.out.println("El mensaje contiene expresiones negativas.");

        } else if (tranquilidad > felicidad
                && tranquilidad > enojo
                && tranquilidad > tristeza) {

            System.out.println("EMOCION DETECTADA: TRANQUILIDAD");
            System.out.println("El mensaje parece transmitir calma.");

        } else {

            System.out.println("EMOCION DETECTADA: INDETERMINADA");
            System.out.println("Hay emociones mezcladas o un empate.");
        }

        System.out.println("");
        System.out.println("========================================");
        System.out.println("       FIN DEL ANALISIS");
        System.out.println("========================================");

        entrada.close();
    }
}
