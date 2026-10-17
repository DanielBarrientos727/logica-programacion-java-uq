import java.util.Scanner;
import java.util.Random;
import java.util.Locale;

public class ImperioCiudad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random azar = new Random();

        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String AMARILLO = "\u001B[33m";
        final String AZUL = "\u001B[34m";
        final String CIAN = "\u001B[36m";
        final String NEGRITA = "\u001B[1m";

        // Indicadores de la ciudad: 1..15
        String[] nombreEstadistica = new String[16];
        nombreEstadistica[1] = "Felicidad";
        nombreEstadistica[2] = "Salud publica";
        nombreEstadistica[3] = "Educacion";
        nombreEstadistica[4] = "Seguridad";
        nombreEstadistica[5] = "Empleo";
        nombreEstadistica[6] = "Agua";
        nombreEstadistica[7] = "Energia";
        nombreEstadistica[8] = "Alimentos";
        nombreEstadistica[9] = "Vivienda";
        nombreEstadistica[10] = "Medio ambiente";
        nombreEstadistica[11] = "Contaminacion";
        nombreEstadistica[12] = "Congestion vial";
        nombreEstadistica[13] = "Infraestructura";
        nombreEstadistica[14] = "Cultura";
        nombreEstadistica[15] = "Turismo";

        int[] estadistica = new int[16];
        estadistica[1] = 62;
        estadistica[2] = 60;
        estadistica[3] = 55;
        estadistica[4] = 55;
        estadistica[5] = 58;
        estadistica[6] = 65;
        estadistica[7] = 62;
        estadistica[8] = 66;
        estadistica[9] = 58;
        estadistica[10] = 60;
        estadistica[11] = 35;
        estadistica[12] = 42;
        estadistica[13] = 55;
        estadistica[14] = 48;
        estadistica[15] = 35;

        String[] categoriaNombre = new String[11];
        categoriaNombre[1] = "Agua y saneamiento";
        categoriaNombre[2] = "Energia y servicios";
        categoriaNombre[3] = "Vivienda y urbanismo";
        categoriaNombre[4] = "Salud y bienestar";
        categoriaNombre[5] = "Educacion y cultura";
        categoriaNombre[6] = "Seguridad y emergencias";
        categoriaNombre[7] = "Economia y empleo";
        categoriaNombre[8] = "Transporte e infraestructura";
        categoriaNombre[9] = "Ambiente y alimentos";
        categoriaNombre[10] = "Gobierno y turismo";

        // Catalogo de 100 acciones. Los arreglos sustituyen objetos de negocio.
        String[] accionNombre = new String[101];
        String[] accionDescripcion = new String[101];
        int[] accionCategoria = new int[101];
        long[] accionCosto = new long[101];
        int[] efectoEstadistica1 = new int[101];
        int[] deltaEstadistica1 = new int[101];
        int[] efectoEstadistica2 = new int[101];
        int[] deltaEstadistica2 = new int[101];
        int[] efectoEstadistica3 = new int[101];
        int[] deltaEstadistica3 = new int[101];
        int[] efectoEstadistica4 = new int[101];
        int[] deltaEstadistica4 = new int[101];
        long[] accionCaja = new long[101];
        long[] accionIngresoMensual = new long[101];
        long[] accionGastoMensual = new long[101];
        int[] accionCapacidadVivienda = new int[101];
        int[] accionUsosMaximos = new int[101];
        int[] accionUsos = new int[101];

        long ingresoMensualExtra = 0L;
        long gastoMensualExtra = 0L;

        // Acciones 1-100: nombre, efecto y coste de cada decision.
        accionNombre[1] = "Perforar pozo comunitario";
        accionDescripcion[1] = "Aumenta la reserva local de agua, con mantenimiento moderado.";
        accionCategoria[1] = 1;
        accionCosto[1] = 220000L;
        efectoEstadistica1[1] = 6;
        deltaEstadistica1[1] = 12;
        efectoEstadistica2[1] = 13;
        deltaEstadistica2[1] = 2;
        efectoEstadistica3[1] = 10;
        deltaEstadistica3[1] = -2;
        efectoEstadistica4[1] = 0;
        deltaEstadistica4[1] = 0;
        accionCaja[1] = 0L;
        accionIngresoMensual[1] = 0L;
        accionGastoMensual[1] = 18000L;
        accionCapacidadVivienda[1] = 0;
        accionUsosMaximos[1] = 3;

        accionNombre[2] = "Planta potabilizadora";
        accionDescripcion[2] = "Mejora calidad y disponibilidad de agua potable.";
        accionCategoria[2] = 1;
        accionCosto[2] = 850000L;
        efectoEstadistica1[2] = 6;
        deltaEstadistica1[2] = 18;
        efectoEstadistica2[2] = 2;
        deltaEstadistica2[2] = 5;
        efectoEstadistica3[2] = 13;
        deltaEstadistica3[2] = 4;
        efectoEstadistica4[2] = 0;
        deltaEstadistica4[2] = 0;
        accionCaja[2] = 0L;
        accionIngresoMensual[2] = 0L;
        accionGastoMensual[2] = 65000L;
        accionCapacidadVivienda[2] = 0;
        accionUsosMaximos[2] = 2;

        accionNombre[3] = "Reparar fugas de la red";
        accionDescripcion[3] = "Reduce perdidas y mejora la continuidad del servicio.";
        accionCategoria[3] = 1;
        accionCosto[3] = 250000L;
        efectoEstadistica1[3] = 6;
        deltaEstadistica1[3] = 8;
        efectoEstadistica2[3] = 13;
        deltaEstadistica2[3] = 4;
        efectoEstadistica3[3] = 10;
        deltaEstadistica3[3] = 2;
        efectoEstadistica4[3] = 0;
        deltaEstadistica4[3] = 0;
        accionCaja[3] = 0L;
        accionIngresoMensual[3] = 0L;
        accionGastoMensual[3] = 5000L;
        accionCapacidadVivienda[3] = 0;
        accionUsosMaximos[3] = 3;

        accionNombre[4] = "Ampliar alcantarillado";
        accionDescripcion[4] = "Disminuye riesgos sanitarios y mejora el saneamiento.";
        accionCategoria[4] = 1;
        accionCosto[4] = 500000L;
        efectoEstadistica1[4] = 2;
        deltaEstadistica1[4] = 4;
        efectoEstadistica2[4] = 10;
        deltaEstadistica2[4] = 3;
        efectoEstadistica3[4] = 6;
        deltaEstadistica3[4] = 2;
        efectoEstadistica4[4] = 0;
        deltaEstadistica4[4] = 0;
        accionCaja[4] = 0L;
        accionIngresoMensual[4] = 0L;
        accionGastoMensual[4] = 22000L;
        accionCapacidadVivienda[4] = 0;
        accionUsosMaximos[4] = 3;

        accionNombre[5] = "Racionamiento de emergencia";
        accionDescripcion[5] = "Ahorra reservas temporalmente, pero afecta a los hogares.";
        accionCategoria[5] = 1;
        accionCosto[5] = 80000L;
        efectoEstadistica1[5] = 6;
        deltaEstadistica1[5] = 8;
        efectoEstadistica2[5] = 1;
        deltaEstadistica2[5] = -9;
        efectoEstadistica3[5] = 5;
        deltaEstadistica3[5] = -2;
        efectoEstadistica4[5] = 0;
        deltaEstadistica4[5] = 0;
        accionCaja[5] = 0L;
        accionIngresoMensual[5] = 0L;
        accionGastoMensual[5] = 0L;
        accionCapacidadVivienda[5] = 0;
        accionUsosMaximos[5] = 1;

        accionNombre[6] = "Concesion privada de agua";
        accionDescripcion[6] = "Aporta capital inmediato, pero reduce el bienestar ciudadano.";
        accionCategoria[6] = 1;
        accionCosto[6] = 0L;
        efectoEstadistica1[6] = 1;
        deltaEstadistica1[6] = -5;
        efectoEstadistica2[6] = 6;
        deltaEstadistica2[6] = -3;
        efectoEstadistica3[6] = 4;
        deltaEstadistica3[6] = -1;
        efectoEstadistica4[6] = 0;
        deltaEstadistica4[6] = 0;
        accionCaja[6] = 450000L;
        accionIngresoMensual[6] = 25000L;
        accionGastoMensual[6] = -8000L;
        accionCapacidadVivienda[6] = 0;
        accionUsosMaximos[6] = 1;

        accionNombre[7] = "Limpiar el rio urbano";
        accionDescripcion[7] = "Recupera ecosistemas y mejora la calidad del agua.";
        accionCategoria[7] = 1;
        accionCosto[7] = 400000L;
        efectoEstadistica1[7] = 6;
        deltaEstadistica1[7] = 4;
        efectoEstadistica2[7] = 10;
        deltaEstadistica2[7] = 7;
        efectoEstadistica3[7] = 11;
        deltaEstadistica3[7] = -8;
        efectoEstadistica4[7] = 0;
        deltaEstadistica4[7] = 0;
        accionCaja[7] = 0L;
        accionIngresoMensual[7] = 0L;
        accionGastoMensual[7] = 12000L;
        accionCapacidadVivienda[7] = 0;
        accionUsosMaximos[7] = 2;

        accionNombre[8] = "Sistema de captacion de lluvia";
        accionDescripcion[8] = "Aumenta reservas y resiliencia durante sequias.";
        accionCategoria[8] = 1;
        accionCosto[8] = 340000L;
        efectoEstadistica1[8] = 6;
        deltaEstadistica1[8] = 8;
        efectoEstadistica2[8] = 10;
        deltaEstadistica2[8] = 3;
        efectoEstadistica3[8] = 13;
        deltaEstadistica3[8] = 2;
        efectoEstadistica4[8] = 0;
        deltaEstadistica4[8] = 0;
        accionCaja[8] = 0L;
        accionIngresoMensual[8] = 0L;
        accionGastoMensual[8] = 7000L;
        accionCapacidadVivienda[8] = 0;
        accionUsosMaximos[8] = 3;

        accionNombre[9] = "Descarga ilegal de residuos";
        accionDescripcion[9] = "Ahorra dinero al inicio, pero contamina y enferma la ciudad.";
        accionCategoria[9] = 1;
        accionCosto[9] = 0L;
        efectoEstadistica1[9] = 6;
        deltaEstadistica1[9] = -8;
        efectoEstadistica2[9] = 2;
        deltaEstadistica2[9] = -4;
        efectoEstadistica3[9] = 10;
        deltaEstadistica3[9] = -10;
        efectoEstadistica4[9] = 11;
        deltaEstadistica4[9] = 15;
        accionCaja[9] = 250000L;
        accionIngresoMensual[9] = 0L;
        accionGastoMensual[9] = 0L;
        accionCapacidadVivienda[9] = 0;
        accionUsosMaximos[9] = 2;

        accionNombre[10] = "Campaña de ahorro de agua";
        accionDescripcion[10] = "Reduce el consumo y promueve buenos habitos.";
        accionCategoria[10] = 1;
        accionCosto[10] = 100000L;
        efectoEstadistica1[10] = 6;
        deltaEstadistica1[10] = 5;
        efectoEstadistica2[10] = 1;
        deltaEstadistica2[10] = 1;
        efectoEstadistica3[10] = 10;
        deltaEstadistica3[10] = 2;
        efectoEstadistica4[10] = 0;
        deltaEstadistica4[10] = 0;
        accionCaja[10] = 0L;
        accionIngresoMensual[10] = 0L;
        accionGastoMensual[10] = 0L;
        accionCapacidadVivienda[10] = 0;
        accionUsosMaximos[10] = 2;

        accionNombre[11] = "Granja solar municipal";
        accionDescripcion[11] = "Aporta energia limpia con costes de mantenimiento moderados.";
        accionCategoria[11] = 2;
        accionCosto[11] = 1200000L;
        efectoEstadistica1[11] = 7;
        deltaEstadistica1[11] = 15;
        efectoEstadistica2[11] = 11;
        deltaEstadistica2[11] = -6;
        efectoEstadistica3[11] = 10;
        deltaEstadistica3[11] = 3;
        efectoEstadistica4[11] = 0;
        deltaEstadistica4[11] = 0;
        accionCaja[11] = 0L;
        accionIngresoMensual[11] = 12000L;
        accionGastoMensual[11] = 12000L;
        accionCapacidadVivienda[11] = 0;
        accionUsosMaximos[11] = 2;

        accionNombre[12] = "Central electrica de carbon";
        accionDescripcion[12] = "Suministro potente y empleo, a cambio de contaminacion.";
        accionCategoria[12] = 2;
        accionCosto[12] = 600000L;
        efectoEstadistica1[12] = 7;
        deltaEstadistica1[12] = 24;
        efectoEstadistica2[12] = 5;
        deltaEstadistica2[12] = 4;
        efectoEstadistica3[12] = 11;
        deltaEstadistica3[12] = 14;
        efectoEstadistica4[12] = 0;
        deltaEstadistica4[12] = 0;
        accionCaja[12] = 0L;
        accionIngresoMensual[12] = 26000L;
        accionGastoMensual[12] = 48000L;
        accionCapacidadVivienda[12] = 0;
        accionUsosMaximos[12] = 2;

        accionNombre[13] = "Parque eolico";
        accionDescripcion[13] = "Generacion renovable y reduccion de emisiones.";
        accionCategoria[13] = 2;
        accionCosto[13] = 750000L;
        efectoEstadistica1[13] = 7;
        deltaEstadistica1[13] = 12;
        efectoEstadistica2[13] = 11;
        deltaEstadistica2[13] = -5;
        efectoEstadistica3[13] = 10;
        deltaEstadistica3[13] = 4;
        efectoEstadistica4[13] = 0;
        deltaEstadistica4[13] = 0;
        accionCaja[13] = 0L;
        accionIngresoMensual[13] = 0L;
        accionGastoMensual[13] = 14000L;
        accionCapacidadVivienda[13] = 0;
        accionUsosMaximos[13] = 2;

        accionNombre[14] = "Apagones programados";
        accionDescripcion[14] = "Reduce gasto a corto plazo y causa perjuicios generalizados.";
        accionCategoria[14] = 2;
        accionCosto[14] = 0L;
        efectoEstadistica1[14] = 7;
        deltaEstadistica1[14] = 5;
        efectoEstadistica2[14] = 1;
        deltaEstadistica2[14] = -12;
        efectoEstadistica3[14] = 5;
        deltaEstadistica3[14] = -4;
        efectoEstadistica4[14] = 2;
        deltaEstadistica4[14] = -3;
        accionCaja[14] = 250000L;
        accionIngresoMensual[14] = 0L;
        accionGastoMensual[14] = -30000L;
        accionCapacidadVivienda[14] = 0;
        accionUsosMaximos[14] = 1;

        accionNombre[15] = "Modernizar la red electrica";
        accionDescripcion[15] = "Mejora la estabilidad del sistema y la infraestructura.";
        accionCategoria[15] = 2;
        accionCosto[15] = 850000L;
        efectoEstadistica1[15] = 7;
        deltaEstadistica1[15] = 8;
        efectoEstadistica2[15] = 13;
        deltaEstadistica2[15] = 8;
        efectoEstadistica3[15] = 5;
        deltaEstadistica3[15] = 2;
        efectoEstadistica4[15] = 0;
        deltaEstadistica4[15] = 0;
        accionCaja[15] = 0L;
        accionIngresoMensual[15] = 0L;
        accionGastoMensual[15] = 25000L;
        accionCapacidadVivienda[15] = 0;
        accionUsosMaximos[15] = 2;

        accionNombre[16] = "Subsidio electrico a hogares";
        accionDescripcion[16] = "Alivia las facturas, pero aumenta el gasto recurrente.";
        accionCategoria[16] = 2;
        accionCosto[16] = 180000L;
        efectoEstadistica1[16] = 7;
        deltaEstadistica1[16] = 3;
        efectoEstadistica2[16] = 1;
        deltaEstadistica2[16] = 4;
        efectoEstadistica3[16] = 2;
        deltaEstadistica3[16] = 1;
        efectoEstadistica4[16] = 0;
        deltaEstadistica4[16] = 0;
        accionCaja[16] = 0L;
        accionIngresoMensual[16] = 0L;
        accionGastoMensual[16] = 50000L;
        accionCapacidadVivienda[16] = 0;
        accionUsosMaximos[16] = 2;

        accionNombre[17] = "Aumentar tarifa electrica";
        accionDescripcion[17] = "Refuerza las cuentas publicas, pero castiga a hogares y negocios.";
        accionCategoria[17] = 2;
        accionCosto[17] = 0L;
        efectoEstadistica1[17] = 1;
        deltaEstadistica1[17] = -7;
        efectoEstadistica2[17] = 5;
        deltaEstadistica2[17] = -2;
        efectoEstadistica3[17] = 7;
        deltaEstadistica3[17] = -1;
        efectoEstadistica4[17] = 0;
        deltaEstadistica4[17] = 0;
        accionCaja[17] = 300000L;
        accionIngresoMensual[17] = 30000L;
        accionGastoMensual[17] = 0L;
        accionCapacidadVivienda[17] = 0;
        accionUsosMaximos[17] = 1;

        accionNombre[18] = "Central modular avanzada";
        accionDescripcion[18] = "Gran capacidad energetica; exige inversion y personal especializado.";
        accionCategoria[18] = 2;
        accionCosto[18] = 2000000L;
        efectoEstadistica1[18] = 7;
        deltaEstadistica1[18] = 30;
        efectoEstadistica2[18] = 3;
        deltaEstadistica2[18] = 2;
        efectoEstadistica3[18] = 11;
        deltaEstadistica3[18] = -1;
        efectoEstadistica4[18] = 0;
        deltaEstadistica4[18] = 0;
        accionCaja[18] = 0L;
        accionIngresoMensual[18] = 0L;
        accionGastoMensual[18] = 70000L;
        accionCapacidadVivienda[18] = 0;
        accionUsosMaximos[18] = 1;

        accionNombre[19] = "Programa de eficiencia energetica";
        accionDescripcion[19] = "Reduce demanda mediante equipos eficientes.";
        accionCategoria[19] = 2;
        accionCosto[19] = 250000L;
        efectoEstadistica1[19] = 7;
        deltaEstadistica1[19] = 5;
        efectoEstadistica2[19] = 10;
        deltaEstadistica2[19] = 5;
        efectoEstadistica3[19] = 11;
        deltaEstadistica3[19] = -3;
        efectoEstadistica4[19] = 0;
        deltaEstadistica4[19] = 0;
        accionCaja[19] = 0L;
        accionIngresoMensual[19] = 0L;
        accionGastoMensual[19] = 3000L;
        accionCapacidadVivienda[19] = 0;
        accionUsosMaximos[19] = 3;

        accionNombre[20] = "Conexiones electricas ilegales";
        accionDescripcion[20] = "Mejora el acceso informal, con riesgos de seguridad.";
        accionCategoria[20] = 2;
        accionCosto[20] = 0L;
        efectoEstadistica1[20] = 7;
        deltaEstadistica1[20] = 4;
        efectoEstadistica2[20] = 4;
        deltaEstadistica2[20] = -7;
        efectoEstadistica3[20] = 11;
        deltaEstadistica3[20] = 3;
        efectoEstadistica4[20] = 0;
        deltaEstadistica4[20] = 0;
        accionCaja[20] = 100000L;
        accionIngresoMensual[20] = 0L;
        accionGastoMensual[20] = 0L;
        accionCapacidadVivienda[20] = 0;
        accionUsosMaximos[20] = 2;

        accionNombre[21] = "Construir vivienda publica";
        accionDescripcion[21] = "Amplia la oferta accesible y apoya a familias vulnerables.";
        accionCategoria[21] = 3;
        accionCosto[21] = 1200000L;
        efectoEstadistica1[21] = 9;
        deltaEstadistica1[21] = 12;
        efectoEstadistica2[21] = 1;
        deltaEstadistica2[21] = 6;
        efectoEstadistica3[21] = 5;
        deltaEstadistica3[21] = 2;
        efectoEstadistica4[21] = 0;
        deltaEstadistica4[21] = 0;
        accionCaja[21] = 0L;
        accionIngresoMensual[21] = 0L;
        accionGastoMensual[21] = 35000L;
        accionCapacidadVivienda[21] = 900;
        accionUsosMaximos[21] = 3;

        accionNombre[22] = "Distrito residencial premium";
        accionDescripcion[22] = "Atrae inversion y turismo, pero aumenta costes urbanos.";
        accionCategoria[22] = 3;
        accionCosto[22] = 800000L;
        efectoEstadistica1[22] = 9;
        deltaEstadistica1[22] = 5;
        efectoEstadistica2[22] = 15;
        deltaEstadistica2[22] = 6;
        efectoEstadistica3[22] = 5;
        deltaEstadistica3[22] = 4;
        efectoEstadistica4[22] = 0;
        deltaEstadistica4[22] = 0;
        accionCaja[22] = 0L;
        accionIngresoMensual[22] = 45000L;
        accionGastoMensual[22] = 12000L;
        accionCapacidadVivienda[22] = 500;
        accionUsosMaximos[22] = 3;

        accionNombre[23] = "Desalojo y demolicion acelerada";
        accionDescripcion[23] = "Libera suelo y caja a costa del bienestar y la vivienda.";
        accionCategoria[23] = 3;
        accionCosto[23] = 0L;
        efectoEstadistica1[23] = 9;
        deltaEstadistica1[23] = -4;
        efectoEstadistica2[23] = 1;
        deltaEstadistica2[23] = -8;
        efectoEstadistica3[23] = 10;
        deltaEstadistica3[23] = 2;
        efectoEstadistica4[23] = 4;
        deltaEstadistica4[23] = -2;
        accionCaja[23] = 400000L;
        accionIngresoMensual[23] = 0L;
        accionGastoMensual[23] = 0L;
        accionCapacidadVivienda[23] = -150;
        accionUsosMaximos[23] = 2;

        accionNombre[24] = "Reforma del uso del suelo";
        accionDescripcion[24] = "Ordena el crecimiento y facilita nuevos proyectos.";
        accionCategoria[24] = 3;
        accionCosto[24] = 220000L;
        efectoEstadistica1[24] = 13;
        deltaEstadistica1[24] = 5;
        efectoEstadistica2[24] = 9;
        deltaEstadistica2[24] = 3;
        efectoEstadistica3[24] = 5;
        deltaEstadistica3[24] = 2;
        efectoEstadistica4[24] = 0;
        deltaEstadistica4[24] = 0;
        accionCaja[24] = 0L;
        accionIngresoMensual[24] = 0L;
        accionGastoMensual[24] = 0L;
        accionCapacidadVivienda[24] = 0;
        accionUsosMaximos[24] = 2;

        accionNombre[25] = "Control de alquileres";
        accionDescripcion[25] = "Mejora la asequibilidad, con coste de regulacion y apoyo.";
        accionCategoria[25] = 3;
        accionCosto[25] = 120000L;
        efectoEstadistica1[25] = 1;
        deltaEstadistica1[25] = 8;
        efectoEstadistica2[25] = 9;
        deltaEstadistica2[25] = 4;
        efectoEstadistica3[25] = 5;
        deltaEstadistica3[25] = -1;
        efectoEstadistica4[25] = 0;
        deltaEstadistica4[25] = 0;
        accionCaja[25] = 0L;
        accionIngresoMensual[25] = 0L;
        accionGastoMensual[25] = 16000L;
        accionCapacidadVivienda[25] = 0;
        accionUsosMaximos[25] = 1;

        accionNombre[26] = "Impuesto a inmuebles de lujo";
        accionDescripcion[26] = "Aporta recursos, aunque algunos propietarios protestan.";
        accionCategoria[26] = 3;
        accionCosto[26] = 0L;
        efectoEstadistica1[26] = 1;
        deltaEstadistica1[26] = -4;
        efectoEstadistica2[26] = 5;
        deltaEstadistica2[26] = -1;
        efectoEstadistica3[26] = 14;
        deltaEstadistica3[26] = 1;
        efectoEstadistica4[26] = 0;
        deltaEstadistica4[26] = 0;
        accionCaja[26] = 250000L;
        accionIngresoMensual[26] = 45000L;
        accionGastoMensual[26] = 0L;
        accionCapacidadVivienda[26] = 0;
        accionUsosMaximos[26] = 1;

        accionNombre[27] = "Renovacion de barrios";
        accionDescripcion[27] = "Recupera espacios deteriorados y mejora la vida urbana.";
        accionCategoria[27] = 3;
        accionCosto[27] = 400000L;
        efectoEstadistica1[27] = 13;
        deltaEstadistica1[27] = 5;
        efectoEstadistica2[27] = 14;
        deltaEstadistica2[27] = 3;
        efectoEstadistica3[27] = 1;
        deltaEstadistica3[27] = 3;
        efectoEstadistica4[27] = 0;
        deltaEstadistica4[27] = 0;
        accionCaja[27] = 0L;
        accionIngresoMensual[27] = 0L;
        accionGastoMensual[27] = 8000L;
        accionCapacidadVivienda[27] = 0;
        accionUsosMaximos[27] = 2;

        accionNombre[28] = "Construccion informal tolerada";
        accionDescripcion[28] = "Aumenta la oferta rapidamente, sin servicios ni planeacion.";
        accionCategoria[28] = 3;
        accionCosto[28] = 0L;
        efectoEstadistica1[28] = 9;
        deltaEstadistica1[28] = 7;
        efectoEstadistica2[28] = 11;
        deltaEstadistica2[28] = 5;
        efectoEstadistica3[28] = 13;
        deltaEstadistica3[28] = -7;
        efectoEstadistica4[28] = 4;
        deltaEstadistica4[28] = -3;
        accionCaja[28] = 250000L;
        accionIngresoMensual[28] = 0L;
        accionGastoMensual[28] = 0L;
        accionCapacidadVivienda[28] = 600;
        accionUsosMaximos[28] = 2;

        accionNombre[29] = "Codigo antisismico";
        accionDescripcion[29] = "Refuerza edificios e infraestructura frente a desastres.";
        accionCategoria[29] = 3;
        accionCosto[29] = 600000L;
        efectoEstadistica1[29] = 4;
        deltaEstadistica1[29] = 4;
        efectoEstadistica2[29] = 13;
        deltaEstadistica2[29] = 4;
        efectoEstadistica3[29] = 2;
        deltaEstadistica3[29] = 2;
        efectoEstadistica4[29] = 0;
        deltaEstadistica4[29] = 0;
        accionCaja[29] = 0L;
        accionIngresoMensual[29] = 0L;
        accionGastoMensual[29] = 10000L;
        accionCapacidadVivienda[29] = 0;
        accionUsosMaximos[29] = 2;

        accionNombre[30] = "Techos y fachadas verdes";
        accionDescripcion[30] = "Mejora el microclima y hace mas agradable la ciudad.";
        accionCategoria[30] = 3;
        accionCosto[30] = 280000L;
        efectoEstadistica1[30] = 10;
        deltaEstadistica1[30] = 6;
        efectoEstadistica2[30] = 11;
        deltaEstadistica2[30] = -3;
        efectoEstadistica3[30] = 9;
        deltaEstadistica3[30] = 1;
        efectoEstadistica4[30] = 0;
        deltaEstadistica4[30] = 0;
        accionCaja[30] = 0L;
        accionIngresoMensual[30] = 0L;
        accionGastoMensual[30] = 5000L;
        accionCapacidadVivienda[30] = 0;
        accionUsosMaximos[30] = 3;

        accionNombre[31] = "Construir hospital general";
        accionDescripcion[31] = "Amplia la atencion especializada y mejora la salud publica.";
        accionCategoria[31] = 4;
        accionCosto[31] = 1500000L;
        efectoEstadistica1[31] = 2;
        deltaEstadistica1[31] = 18;
        efectoEstadistica2[31] = 1;
        deltaEstadistica2[31] = 4;
        efectoEstadistica3[31] = 13;
        deltaEstadistica3[31] = 3;
        efectoEstadistica4[31] = 0;
        deltaEstadistica4[31] = 0;
        accionCaja[31] = 0L;
        accionIngresoMensual[31] = 0L;
        accionGastoMensual[31] = 85000L;
        accionCapacidadVivienda[31] = 0;
        accionUsosMaximos[31] = 2;

        accionNombre[32] = "Abrir centros de salud barriales";
        accionDescripcion[32] = "Acerca la atencion basica a distintos sectores.";
        accionCategoria[32] = 4;
        accionCosto[32] = 450000L;
        efectoEstadistica1[32] = 2;
        deltaEstadistica1[32] = 9;
        efectoEstadistica2[32] = 1;
        deltaEstadistica2[32] = 2;
        efectoEstadistica3[32] = 0;
        deltaEstadistica3[32] = 0;
        efectoEstadistica4[32] = 0;
        deltaEstadistica4[32] = 0;
        accionCaja[32] = 0L;
        accionIngresoMensual[32] = 0L;
        accionGastoMensual[32] = 35000L;
        accionCapacidadVivienda[32] = 0;
        accionUsosMaximos[32] = 4;

        accionNombre[33] = "Jornadas de vacunacion";
        accionDescripcion[33] = "Previene brotes y protege a la poblacion.";
        accionCategoria[33] = 4;
        accionCosto[33] = 200000L;
        efectoEstadistica1[33] = 2;
        deltaEstadistica1[33] = 6;
        efectoEstadistica2[33] = 1;
        deltaEstadistica2[33] = 2;
        efectoEstadistica3[33] = 0;
        deltaEstadistica3[33] = 0;
        efectoEstadistica4[33] = 0;
        deltaEstadistica4[33] = 0;
        accionCaja[33] = 0L;
        accionIngresoMensual[33] = 0L;
        accionGastoMensual[33] = 0L;
        accionCapacidadVivienda[33] = 0;
        accionUsosMaximos[33] = 3;

        accionNombre[34] = "Recortar presupuesto sanitario";
        accionDescripcion[34] = "Libera caja y reduce gastos, pero deteriora la salud.";
        accionCategoria[34] = 4;
        accionCosto[34] = 0L;
        efectoEstadistica1[34] = 2;
        deltaEstadistica1[34] = -12;
        efectoEstadistica2[34] = 1;
        deltaEstadistica2[34] = -5;
        efectoEstadistica3[34] = 5;
        deltaEstadistica3[34] = -2;
        efectoEstadistica4[34] = 0;
        deltaEstadistica4[34] = 0;
        accionCaja[34] = 300000L;
        accionIngresoMensual[34] = 0L;
        accionGastoMensual[34] = -25000L;
        accionCapacidadVivienda[34] = 0;
        accionUsosMaximos[34] = 2;

        accionNombre[35] = "Polideportivos comunitarios";
        accionDescripcion[35] = "Promueve actividad fisica, convivencia y cultura.";
        accionCategoria[35] = 4;
        accionCosto[35] = 350000L;
        efectoEstadistica1[35] = 2;
        deltaEstadistica1[35] = 4;
        efectoEstadistica2[35] = 1;
        deltaEstadistica2[35] = 3;
        efectoEstadistica3[35] = 14;
        deltaEstadistica3[35] = 2;
        efectoEstadistica4[35] = 0;
        deltaEstadistica4[35] = 0;
        accionCaja[35] = 0L;
        accionIngresoMensual[35] = 0L;
        accionGastoMensual[35] = 15000L;
        accionCapacidadVivienda[35] = 0;
        accionUsosMaximos[35] = 3;

        accionNombre[36] = "Comedores y seguridad alimentaria";
        accionDescripcion[36] = "Reduce el hambre y mejora la nutricion infantil.";
        accionCategoria[36] = 4;
        accionCosto[36] = 280000L;
        efectoEstadistica1[36] = 8;
        deltaEstadistica1[36] = 12;
        efectoEstadistica2[36] = 2;
        deltaEstadistica2[36] = 5;
        efectoEstadistica3[36] = 1;
        deltaEstadistica3[36] = 3;
        efectoEstadistica4[36] = 0;
        deltaEstadistica4[36] = 0;
        accionCaja[36] = 0L;
        accionIngresoMensual[36] = 0L;
        accionGastoMensual[36] = 50000L;
        accionCapacidadVivienda[36] = 0;
        accionUsosMaximos[36] = 3;

        accionNombre[37] = "Trabajo forzado de emergencia";
        accionDescripcion[37] = "Genera produccion a corto plazo con un alto coste humano.";
        accionCategoria[37] = 4;
        accionCosto[37] = 150000L;
        efectoEstadistica1[37] = 5;
        deltaEstadistica1[37] = 5;
        efectoEstadistica2[37] = 1;
        deltaEstadistica2[37] = -8;
        efectoEstadistica3[37] = 2;
        deltaEstadistica3[37] = -4;
        efectoEstadistica4[37] = 0;
        deltaEstadistica4[37] = 0;
        accionCaja[37] = 0L;
        accionIngresoMensual[37] = 20000L;
        accionGastoMensual[37] = 5000L;
        accionCapacidadVivienda[37] = 0;
        accionUsosMaximos[37] = 1;

        accionNombre[38] = "Servicio de salud mental";
        accionDescripcion[38] = "Apoya el bienestar emocional y la atencion temprana.";
        accionCategoria[38] = 4;
        accionCosto[38] = 200000L;
        efectoEstadistica1[38] = 2;
        deltaEstadistica1[38] = 5;
        efectoEstadistica2[38] = 1;
        deltaEstadistica2[38] = 6;
        efectoEstadistica3[38] = 0;
        deltaEstadistica3[38] = 0;
        efectoEstadistica4[38] = 0;
        deltaEstadistica4[38] = 0;
        accionCaja[38] = 0L;
        accionIngresoMensual[38] = 0L;
        accionGastoMensual[38] = 18000L;
        accionCapacidadVivienda[38] = 0;
        accionUsosMaximos[38] = 2;

        accionNombre[39] = "Subsidio al transporte publico";
        accionDescripcion[39] = "Facilita desplazamientos a empleo, salud y estudio.";
        accionCategoria[39] = 4;
        accionCosto[39] = 100000L;
        efectoEstadistica1[39] = 1;
        deltaEstadistica1[39] = 4;
        efectoEstadistica2[39] = 12;
        deltaEstadistica2[39] = -3;
        efectoEstadistica3[39] = 5;
        deltaEstadistica3[39] = 2;
        efectoEstadistica4[39] = 0;
        deltaEstadistica4[39] = 0;
        accionCaja[39] = 0L;
        accionIngresoMensual[39] = 0L;
        accionGastoMensual[39] = 25000L;
        accionCapacidadVivienda[39] = 0;
        accionUsosMaximos[39] = 2;

        accionNombre[40] = "Expulsion de personas sin hogar";
        accionDescripcion[40] = "Reduce la visibilidad del problema, no sus causas.";
        accionCategoria[40] = 4;
        accionCosto[40] = 0L;
        efectoEstadistica1[40] = 9;
        deltaEstadistica1[40] = -4;
        efectoEstadistica2[40] = 1;
        deltaEstadistica2[40] = -6;
        efectoEstadistica3[40] = 4;
        deltaEstadistica3[40] = -2;
        efectoEstadistica4[40] = 0;
        deltaEstadistica4[40] = 0;
        accionCaja[40] = 150000L;
        accionIngresoMensual[40] = 0L;
        accionGastoMensual[40] = 0L;
        accionCapacidadVivienda[40] = 0;
        accionUsosMaximos[40] = 2;

        accionNombre[41] = "Construir escuela publica";
        accionDescripcion[41] = "Amplia cupos y fortalece la formacion basica.";
        accionCategoria[41] = 5;
        accionCosto[41] = 850000L;
        efectoEstadistica1[41] = 3;
        deltaEstadistica1[41] = 12;
        efectoEstadistica2[41] = 14;
        deltaEstadistica2[41] = 2;
        efectoEstadistica3[41] = 5;
        deltaEstadistica3[41] = 2;
        efectoEstadistica4[41] = 0;
        deltaEstadistica4[41] = 0;
        accionCaja[41] = 0L;
        accionIngresoMensual[41] = 0L;
        accionGastoMensual[41] = 50000L;
        accionCapacidadVivienda[41] = 0;
        accionUsosMaximos[41] = 3;

        accionNombre[42] = "Instituto tecnico laboral";
        accionDescripcion[42] = "Prepara perfiles demandados por empresas locales.";
        accionCategoria[42] = 5;
        accionCosto[42] = 700000L;
        efectoEstadistica1[42] = 3;
        deltaEstadistica1[42] = 8;
        efectoEstadistica2[42] = 5;
        deltaEstadistica2[42] = 7;
        efectoEstadistica3[42] = 1;
        deltaEstadistica3[42] = 2;
        efectoEstadistica4[42] = 0;
        deltaEstadistica4[42] = 0;
        accionCaja[42] = 0L;
        accionIngresoMensual[42] = 0L;
        accionGastoMensual[42] = 45000L;
        accionCapacidadVivienda[42] = 0;
        accionUsosMaximos[42] = 2;

        accionNombre[43] = "Biblioteca municipal";
        accionDescripcion[43] = "Ofrece estudio, consulta y acceso comunitario a informacion.";
        accionCategoria[43] = 5;
        accionCosto[43] = 300000L;
        efectoEstadistica1[43] = 3;
        deltaEstadistica1[43] = 5;
        efectoEstadistica2[43] = 14;
        deltaEstadistica2[43] = 5;
        efectoEstadistica3[43] = 1;
        deltaEstadistica3[43] = 2;
        efectoEstadistica4[43] = 0;
        deltaEstadistica4[43] = 0;
        accionCaja[43] = 0L;
        accionIngresoMensual[43] = 0L;
        accionGastoMensual[43] = 14000L;
        accionCapacidadVivienda[43] = 0;
        accionUsosMaximos[43] = 3;

        accionNombre[44] = "Cerrar escuelas para ahorrar";
        accionDescripcion[44] = "Reduce el gasto, pero perjudica a estudiantes y empleo.";
        accionCategoria[44] = 5;
        accionCosto[44] = 0L;
        efectoEstadistica1[44] = 3;
        deltaEstadistica1[44] = -12;
        efectoEstadistica2[44] = 5;
        deltaEstadistica2[44] = -3;
        efectoEstadistica3[44] = 1;
        deltaEstadistica3[44] = -5;
        efectoEstadistica4[44] = 0;
        deltaEstadistica4[44] = 0;
        accionCaja[44] = 250000L;
        accionIngresoMensual[44] = 0L;
        accionGastoMensual[44] = -30000L;
        accionCapacidadVivienda[44] = 0;
        accionUsosMaximos[44] = 1;

        accionNombre[45] = "Universidad publica";
        accionDescripcion[45] = "Impulsa talento, investigacion, empleo y vida cultural.";
        accionCategoria[45] = 5;
        accionCosto[45] = 2000000L;
        efectoEstadistica1[45] = 3;
        deltaEstadistica1[45] = 14;
        efectoEstadistica2[45] = 5;
        deltaEstadistica2[45] = 5;
        efectoEstadistica3[45] = 14;
        deltaEstadistica3[45] = 5;
        efectoEstadistica4[45] = 0;
        deltaEstadistica4[45] = 0;
        accionCaja[45] = 0L;
        accionIngresoMensual[45] = 0L;
        accionGastoMensual[45] = 120000L;
        accionCapacidadVivienda[45] = 0;
        accionUsosMaximos[45] = 1;

        accionNombre[46] = "Museo de historia local";
        accionDescripcion[46] = "Conserva patrimonio y atrae visitantes.";
        accionCategoria[46] = 5;
        accionCosto[46] = 650000L;
        efectoEstadistica1[46] = 14;
        deltaEstadistica1[46] = 8;
        efectoEstadistica2[46] = 15;
        deltaEstadistica2[46] = 4;
        efectoEstadistica3[46] = 3;
        deltaEstadistica3[46] = 2;
        efectoEstadistica4[46] = 0;
        deltaEstadistica4[46] = 0;
        accionCaja[46] = 0L;
        accionIngresoMensual[46] = 0L;
        accionGastoMensual[46] = 25000L;
        accionCapacidadVivienda[46] = 0;
        accionUsosMaximos[46] = 2;

        accionNombre[47] = "Festival cultural";
        accionDescripcion[47] = "Activa plazas, comercio local y expresion artistica.";
        accionCategoria[47] = 5;
        accionCosto[47] = 180000L;
        efectoEstadistica1[47] = 14;
        deltaEstadistica1[47] = 6;
        efectoEstadistica2[47] = 1;
        deltaEstadistica2[47] = 5;
        efectoEstadistica3[47] = 15;
        deltaEstadistica3[47] = 8;
        efectoEstadistica4[47] = 0;
        deltaEstadistica4[47] = 0;
        accionCaja[47] = 0L;
        accionIngresoMensual[47] = 0L;
        accionGastoMensual[47] = 0L;
        accionCapacidadVivienda[47] = 0;
        accionUsosMaximos[47] = 3;

        accionNombre[48] = "Censurar expresiones artisticas";
        accionDescripcion[48] = "Impone control social a costa de libertad y convivencia.";
        accionCategoria[48] = 5;
        accionCosto[48] = 0L;
        efectoEstadistica1[48] = 14;
        deltaEstadistica1[48] = -8;
        efectoEstadistica2[48] = 1;
        deltaEstadistica2[48] = -6;
        efectoEstadistica3[48] = 4;
        deltaEstadistica3[48] = 1;
        efectoEstadistica4[48] = 0;
        deltaEstadistica4[48] = 0;
        accionCaja[48] = 90000L;
        accionIngresoMensual[48] = 0L;
        accionGastoMensual[48] = 0L;
        accionCapacidadVivienda[48] = 0;
        accionUsosMaximos[48] = 1;

        accionNombre[49] = "Internet publico gratuito";
        accionDescripcion[49] = "Mejora acceso al conocimiento y servicios digitales.";
        accionCategoria[49] = 5;
        accionCosto[49] = 500000L;
        efectoEstadistica1[49] = 3;
        deltaEstadistica1[49] = 4;
        efectoEstadistica2[49] = 13;
        deltaEstadistica2[49] = 2;
        efectoEstadistica3[49] = 5;
        deltaEstadistica3[49] = 2;
        efectoEstadistica4[49] = 0;
        deltaEstadistica4[49] = 0;
        accionCaja[49] = 0L;
        accionIngresoMensual[49] = 0L;
        accionGastoMensual[49] = 35000L;
        accionCapacidadVivienda[49] = 0;
        accionUsosMaximos[49] = 2;

        accionNombre[50] = "Restaurar patrimonio historico";
        accionDescripcion[50] = "Preserva identidad y desarrolla turismo cultural.";
        accionCategoria[50] = 5;
        accionCosto[50] = 420000L;
        efectoEstadistica1[50] = 14;
        deltaEstadistica1[50] = 8;
        efectoEstadistica2[50] = 15;
        deltaEstadistica2[50] = 5;
        efectoEstadistica3[50] = 10;
        deltaEstadistica3[50] = 2;
        efectoEstadistica4[50] = 0;
        deltaEstadistica4[50] = 0;
        accionCaja[50] = 0L;
        accionIngresoMensual[50] = 0L;
        accionGastoMensual[50] = 10000L;
        accionCapacidadVivienda[50] = 0;
        accionUsosMaximos[50] = 2;

        accionNombre[51] = "Patrullaje de proximidad";
        accionDescripcion[51] = "Aumenta presencia preventiva y confianza vecinal.";
        accionCategoria[51] = 6;
        accionCosto[51] = 400000L;
        efectoEstadistica1[51] = 4;
        deltaEstadistica1[51] = 8;
        efectoEstadistica2[51] = 1;
        deltaEstadistica2[51] = 1;
        efectoEstadistica3[51] = 0;
        deltaEstadistica3[51] = 0;
        efectoEstadistica4[51] = 0;
        deltaEstadistica4[51] = 0;
        accionCaja[51] = 0L;
        accionIngresoMensual[51] = 0L;
        accionGastoMensual[51] = 35000L;
        accionCapacidadVivienda[51] = 0;
        accionUsosMaximos[51] = 3;

        accionNombre[52] = "Estacion de bomberos";
        accionDescripcion[52] = "Mejora respuesta ante incendios y emergencias.";
        accionCategoria[52] = 6;
        accionCosto[52] = 600000L;
        efectoEstadistica1[52] = 4;
        deltaEstadistica1[52] = 5;
        efectoEstadistica2[52] = 13;
        deltaEstadistica2[52] = 3;
        efectoEstadistica3[52] = 2;
        deltaEstadistica3[52] = 1;
        efectoEstadistica4[52] = 0;
        deltaEstadistica4[52] = 0;
        accionCaja[52] = 0L;
        accionIngresoMensual[52] = 0L;
        accionGastoMensual[52] = 25000L;
        accionCapacidadVivienda[52] = 0;
        accionUsosMaximos[52] = 2;

        accionNombre[53] = "Red de videovigilancia";
        accionDescripcion[53] = "Facilita respuestas policiales, con preocupaciones de privacidad.";
        accionCategoria[53] = 6;
        accionCosto[53] = 350000L;
        efectoEstadistica1[53] = 4;
        deltaEstadistica1[53] = 7;
        efectoEstadistica2[53] = 1;
        deltaEstadistica2[53] = -3;
        efectoEstadistica3[53] = 13;
        deltaEstadistica3[53] = 2;
        efectoEstadistica4[53] = 0;
        deltaEstadistica4[53] = 0;
        accionCaja[53] = 0L;
        accionIngresoMensual[53] = 0L;
        accionGastoMensual[53] = 15000L;
        accionCapacidadVivienda[53] = 0;
        accionUsosMaximos[53] = 2;

        accionNombre[54] = "Mediacion comunitaria";
        accionDescripcion[54] = "Previene conflictos y fortalece la convivencia.";
        accionCategoria[54] = 6;
        accionCosto[54] = 180000L;
        efectoEstadistica1[54] = 4;
        deltaEstadistica1[54] = 5;
        efectoEstadistica2[54] = 1;
        deltaEstadistica2[54] = 4;
        efectoEstadistica3[54] = 14;
        deltaEstadistica3[54] = 1;
        efectoEstadistica4[54] = 0;
        deltaEstadistica4[54] = 0;
        accionCaja[54] = 0L;
        accionIngresoMensual[54] = 0L;
        accionGastoMensual[54] = 12000L;
        accionCapacidadVivienda[54] = 0;
        accionUsosMaximos[54] = 3;

        accionNombre[55] = "Militarizar las calles";
        accionDescripcion[55] = "Aumenta el control inmediato, pero reduce confianza ciudadana.";
        accionCategoria[55] = 6;
        accionCosto[55] = 700000L;
        efectoEstadistica1[55] = 4;
        deltaEstadistica1[55] = 12;
        efectoEstadistica2[55] = 1;
        deltaEstadistica2[55] = -10;
        efectoEstadistica3[55] = 14;
        deltaEstadistica3[55] = -3;
        efectoEstadistica4[55] = 0;
        deltaEstadistica4[55] = 0;
        accionCaja[55] = 0L;
        accionIngresoMensual[55] = 0L;
        accionGastoMensual[55] = 65000L;
        accionCapacidadVivienda[55] = 0;
        accionUsosMaximos[55] = 1;

        accionNombre[56] = "Reducir la policia preventiva";
        accionDescripcion[56] = "Ahorra dinero, pero eleva la percepcion de inseguridad.";
        accionCategoria[56] = 6;
        accionCosto[56] = 0L;
        efectoEstadistica1[56] = 4;
        deltaEstadistica1[56] = -9;
        efectoEstadistica2[56] = 1;
        deltaEstadistica2[56] = -2;
        efectoEstadistica3[56] = 5;
        deltaEstadistica3[56] = 1;
        efectoEstadistica4[56] = 0;
        deltaEstadistica4[56] = 0;
        accionCaja[56] = 100000L;
        accionIngresoMensual[56] = 0L;
        accionGastoMensual[56] = -20000L;
        accionCapacidadVivienda[56] = 0;
        accionUsosMaximos[56] = 1;

        accionNombre[57] = "Simulacro de desastres";
        accionDescripcion[57] = "Prepara equipos y ciudadanos para actuar bajo presion.";
        accionCategoria[57] = 6;
        accionCosto[57] = 160000L;
        efectoEstadistica1[57] = 4;
        deltaEstadistica1[57] = 3;
        efectoEstadistica2[57] = 13;
        deltaEstadistica2[57] = 3;
        efectoEstadistica3[57] = 2;
        deltaEstadistica3[57] = 1;
        efectoEstadistica4[57] = 0;
        deltaEstadistica4[57] = 0;
        accionCaja[57] = 0L;
        accionIngresoMensual[57] = 0L;
        accionGastoMensual[57] = 0L;
        accionCapacidadVivienda[57] = 0;
        accionUsosMaximos[57] = 3;

        accionNombre[58] = "Fondo de emergencias";
        accionDescripcion[58] = "Reserva capacidad institucional para eventos extremos.";
        accionCategoria[58] = 6;
        accionCosto[58] = 500000L;
        efectoEstadistica1[58] = 4;
        deltaEstadistica1[58] = 4;
        efectoEstadistica2[58] = 2;
        deltaEstadistica2[58] = 2;
        efectoEstadistica3[58] = 13;
        deltaEstadistica3[58] = 2;
        efectoEstadistica4[58] = 0;
        deltaEstadistica4[58] = 0;
        accionCaja[58] = 0L;
        accionIngresoMensual[58] = 0L;
        accionGastoMensual[58] = 20000L;
        accionCapacidadVivienda[58] = 0;
        accionUsosMaximos[58] = 2;

        accionNombre[59] = "Seguridad privada subvencionada";
        accionDescripcion[59] = "Aumenta la vigilancia, con acceso desigual al servicio.";
        accionCategoria[59] = 6;
        accionCosto[59] = 250000L;
        efectoEstadistica1[59] = 4;
        deltaEstadistica1[59] = 6;
        efectoEstadistica2[59] = 1;
        deltaEstadistica2[59] = -4;
        efectoEstadistica3[59] = 5;
        deltaEstadistica3[59] = 1;
        efectoEstadistica4[59] = 0;
        deltaEstadistica4[59] = 0;
        accionCaja[59] = 0L;
        accionIngresoMensual[59] = 0L;
        accionGastoMensual[59] = 22000L;
        accionCapacidadVivienda[59] = 0;
        accionUsosMaximos[59] = 2;

        accionNombre[60] = "Sobornar funcionarios";
        accionDescripcion[60] = "Aporta dinero inmediato y erosiona instituciones y confianza.";
        accionCategoria[60] = 6;
        accionCosto[60] = 0L;
        efectoEstadistica1[60] = 4;
        deltaEstadistica1[60] = -8;
        efectoEstadistica2[60] = 1;
        deltaEstadistica2[60] = -5;
        efectoEstadistica3[60] = 14;
        deltaEstadistica3[60] = -7;
        efectoEstadistica4[60] = 0;
        deltaEstadistica4[60] = 0;
        accionCaja[60] = 750000L;
        accionIngresoMensual[60] = 0L;
        accionGastoMensual[60] = 0L;
        accionCapacidadVivienda[60] = 0;
        accionUsosMaximos[60] = 1;

        accionNombre[61] = "Fondo para pequenos negocios";
        accionDescripcion[61] = "Apoya comercios, emprendimientos y empleo local.";
        accionCategoria[61] = 7;
        accionCosto[61] = 450000L;
        efectoEstadistica1[61] = 5;
        deltaEstadistica1[61] = 8;
        efectoEstadistica2[61] = 1;
        deltaEstadistica2[61] = 3;
        efectoEstadistica3[61] = 14;
        deltaEstadistica3[61] = 1;
        efectoEstadistica4[61] = 0;
        deltaEstadistica4[61] = 0;
        accionCaja[61] = 0L;
        accionIngresoMensual[61] = 25000L;
        accionGastoMensual[61] = 10000L;
        accionCapacidadVivienda[61] = 0;
        accionUsosMaximos[61] = 3;

        accionNombre[62] = "Parque industrial";
        accionDescripcion[62] = "Atrae empresas y puestos, con mas presion ambiental.";
        accionCategoria[62] = 7;
        accionCosto[62] = 1200000L;
        efectoEstadistica1[62] = 5;
        deltaEstadistica1[62] = 14;
        efectoEstadistica2[62] = 11;
        deltaEstadistica2[62] = 8;
        efectoEstadistica3[62] = 13;
        deltaEstadistica3[62] = 3;
        efectoEstadistica4[62] = 0;
        deltaEstadistica4[62] = 0;
        accionCaja[62] = 0L;
        accionIngresoMensual[62] = 75000L;
        accionGastoMensual[62] = 25000L;
        accionCapacidadVivienda[62] = 0;
        accionUsosMaximos[62] = 3;

        accionNombre[63] = "Incubadora de empresas";
        accionDescripcion[63] = "Ayuda a convertir ideas en productos y empleos.";
        accionCategoria[63] = 7;
        accionCosto[63] = 380000L;
        efectoEstadistica1[63] = 5;
        deltaEstadistica1[63] = 6;
        efectoEstadistica2[63] = 3;
        deltaEstadistica2[63] = 4;
        efectoEstadistica3[63] = 14;
        deltaEstadistica3[63] = 1;
        efectoEstadistica4[63] = 0;
        deltaEstadistica4[63] = 0;
        accionCaja[63] = 0L;
        accionIngresoMensual[63] = 0L;
        accionGastoMensual[63] = 18000L;
        accionCapacidadVivienda[63] = 0;
        accionUsosMaximos[63] = 2;

        accionNombre[64] = "Reducir impuesto empresarial";
        accionDescripcion[64] = "Atrae inversion, pero reduce ingresos fiscales recurrentes.";
        accionCategoria[64] = 7;
        accionCosto[64] = 300000L;
        efectoEstadistica1[64] = 5;
        deltaEstadistica1[64] = 3;
        efectoEstadistica2[64] = 1;
        deltaEstadistica2[64] = 2;
        efectoEstadistica3[64] = 15;
        deltaEstadistica3[64] = 1;
        efectoEstadistica4[64] = 0;
        deltaEstadistica4[64] = 0;
        accionCaja[64] = 0L;
        accionIngresoMensual[64] = -55000L;
        accionGastoMensual[64] = 0L;
        accionCapacidadVivienda[64] = 0;
        accionUsosMaximos[64] = 1;

        accionNombre[65] = "Elevar impuesto empresarial";
        accionDescripcion[65] = "Genera ingresos fiscales, pero puede enfriar la contratacion.";
        accionCategoria[65] = 7;
        accionCosto[65] = 0L;
        efectoEstadistica1[65] = 5;
        deltaEstadistica1[65] = -3;
        efectoEstadistica2[65] = 1;
        deltaEstadistica2[65] = -2;
        efectoEstadistica3[65] = 13;
        deltaEstadistica3[65] = 1;
        efectoEstadistica4[65] = 0;
        deltaEstadistica4[65] = 0;
        accionCaja[65] = 400000L;
        accionIngresoMensual[65] = 60000L;
        accionGastoMensual[65] = 0L;
        accionCapacidadVivienda[65] = 0;
        accionUsosMaximos[65] = 1;

        accionNombre[66] = "Programa de exportacion local";
        accionDescripcion[66] = "Conecta productores con nuevos mercados.";
        accionCategoria[66] = 7;
        accionCosto[66] = 260000L;
        efectoEstadistica1[66] = 5;
        deltaEstadistica1[66] = 5;
        efectoEstadistica2[66] = 15;
        deltaEstadistica2[66] = 3;
        efectoEstadistica3[66] = 13;
        deltaEstadistica3[66] = 1;
        efectoEstadistica4[66] = 0;
        deltaEstadistica4[66] = 0;
        accionCaja[66] = 0L;
        accionIngresoMensual[66] = 25000L;
        accionGastoMensual[66] = 5000L;
        accionCapacidadVivienda[66] = 0;
        accionUsosMaximos[66] = 2;

        accionNombre[67] = "Obras publicas de empleo";
        accionDescripcion[67] = "Genera trabajo temporal y mejora infraestructura.";
        accionCategoria[67] = 7;
        accionCosto[67] = 750000L;
        efectoEstadistica1[67] = 5;
        deltaEstadistica1[67] = 9;
        efectoEstadistica2[67] = 13;
        deltaEstadistica2[67] = 5;
        efectoEstadistica3[67] = 1;
        deltaEstadistica3[67] = 2;
        efectoEstadistica4[67] = 0;
        deltaEstadistica4[67] = 0;
        accionCaja[67] = 0L;
        accionIngresoMensual[67] = 0L;
        accionGastoMensual[67] = 25000L;
        accionCapacidadVivienda[67] = 0;
        accionUsosMaximos[67] = 2;

        accionNombre[68] = "Automatizacion industrial";
        accionDescripcion[68] = "Mejora productividad y formacion, pero desplaza algunos empleos.";
        accionCategoria[68] = 7;
        accionCosto[68] = 800000L;
        efectoEstadistica1[68] = 5;
        deltaEstadistica1[68] = -4;
        efectoEstadistica2[68] = 3;
        deltaEstadistica2[68] = 5;
        efectoEstadistica3[68] = 13;
        deltaEstadistica3[68] = 3;
        efectoEstadistica4[68] = 0;
        deltaEstadistica4[68] = 0;
        accionCaja[68] = 0L;
        accionIngresoMensual[68] = 40000L;
        accionGastoMensual[68] = 10000L;
        accionCapacidadVivienda[68] = 0;
        accionUsosMaximos[68] = 2;

        accionNombre[69] = "Formalizar economia informal";
        accionDescripcion[69] = "Amplia recaudacion y proteccion laboral, con friccion inicial.";
        accionCategoria[69] = 7;
        accionCosto[69] = 200000L;
        efectoEstadistica1[69] = 5;
        deltaEstadistica1[69] = -2;
        efectoEstadistica2[69] = 4;
        deltaEstadistica2[69] = 2;
        efectoEstadistica3[69] = 1;
        deltaEstadistica3[69] = -1;
        efectoEstadistica4[69] = 0;
        deltaEstadistica4[69] = 0;
        accionCaja[69] = 300000L;
        accionIngresoMensual[69] = 45000L;
        accionGastoMensual[69] = 0L;
        accionCapacidadVivienda[69] = 0;
        accionUsosMaximos[69] = 1;

        accionNombre[70] = "Cooperativas de trabajadores";
        accionDescripcion[70] = "Reparte oportunidades y fortalece redes productivas.";
        accionCategoria[70] = 7;
        accionCosto[70] = 240000L;
        efectoEstadistica1[70] = 5;
        deltaEstadistica1[70] = 5;
        efectoEstadistica2[70] = 1;
        deltaEstadistica2[70] = 4;
        efectoEstadistica3[70] = 14;
        deltaEstadistica3[70] = 2;
        efectoEstadistica4[70] = 0;
        deltaEstadistica4[70] = 0;
        accionCaja[70] = 0L;
        accionIngresoMensual[70] = 10000L;
        accionGastoMensual[70] = 8000L;
        accionCapacidadVivienda[70] = 0;
        accionUsosMaximos[70] = 3;

        accionNombre[71] = "Red de autobuses urbanos";
        accionDescripcion[71] = "Reduce congestion y conecta barrios con empleo.";
        accionCategoria[71] = 8;
        accionCosto[71] = 950000L;
        efectoEstadistica1[71] = 12;
        deltaEstadistica1[71] = -10;
        efectoEstadistica2[71] = 5;
        deltaEstadistica2[71] = 3;
        efectoEstadistica3[71] = 11;
        deltaEstadistica3[71] = -3;
        efectoEstadistica4[71] = 0;
        deltaEstadistica4[71] = 0;
        accionCaja[71] = 0L;
        accionIngresoMensual[71] = 0L;
        accionGastoMensual[71] = 45000L;
        accionCapacidadVivienda[71] = 0;
        accionUsosMaximos[71] = 2;

        accionNombre[72] = "Construir linea de metro";
        accionDescripcion[72] = "Gran capacidad de transporte con inversion y mantenimiento altos.";
        accionCategoria[72] = 8;
        accionCosto[72] = 2500000L;
        efectoEstadistica1[72] = 12;
        deltaEstadistica1[72] = -18;
        efectoEstadistica2[72] = 10;
        deltaEstadistica2[72] = 4;
        efectoEstadistica3[72] = 5;
        deltaEstadistica3[72] = 8;
        efectoEstadistica4[72] = 0;
        deltaEstadistica4[72] = 0;
        accionCaja[72] = 0L;
        accionIngresoMensual[72] = 0L;
        accionGastoMensual[72] = 110000L;
        accionCapacidadVivienda[72] = 0;
        accionUsosMaximos[72] = 2;

        accionNombre[73] = "Ampliar avenidas";
        accionDescripcion[73] = "Aumenta capacidad vial, pero incentiva el trafico y emisiones.";
        accionCategoria[73] = 8;
        accionCosto[73] = 1500000L;
        efectoEstadistica1[73] = 12;
        deltaEstadistica1[73] = -12;
        efectoEstadistica2[73] = 13;
        deltaEstadistica2[73] = 6;
        efectoEstadistica3[73] = 11;
        deltaEstadistica3[73] = 6;
        efectoEstadistica4[73] = 0;
        deltaEstadistica4[73] = 0;
        accionCaja[73] = 0L;
        accionIngresoMensual[73] = 0L;
        accionGastoMensual[73] = 50000L;
        accionCapacidadVivienda[73] = 0;
        accionUsosMaximos[73] = 2;

        accionNombre[74] = "Red de ciclorutas";
        accionDescripcion[74] = "Facilita movilidad limpia, salud y conexiones cortas.";
        accionCategoria[74] = 8;
        accionCosto[74] = 280000L;
        efectoEstadistica1[74] = 12;
        deltaEstadistica1[74] = -7;
        efectoEstadistica2[74] = 10;
        deltaEstadistica2[74] = 5;
        efectoEstadistica3[74] = 2;
        deltaEstadistica3[74] = 3;
        efectoEstadistica4[74] = 0;
        deltaEstadistica4[74] = 0;
        accionCaja[74] = 0L;
        accionIngresoMensual[74] = 0L;
        accionGastoMensual[74] = 8000L;
        accionCapacidadVivienda[74] = 0;
        accionUsosMaximos[74] = 3;

        accionNombre[75] = "Reparar calles y puentes";
        accionDescripcion[75] = "Corrige fallas y reduce tiempos perdidos.";
        accionCategoria[75] = 8;
        accionCosto[75] = 450000L;
        efectoEstadistica1[75] = 13;
        deltaEstadistica1[75] = 10;
        efectoEstadistica2[75] = 12;
        deltaEstadistica2[75] = -4;
        efectoEstadistica3[75] = 1;
        deltaEstadistica3[75] = 2;
        efectoEstadistica4[75] = 0;
        deltaEstadistica4[75] = 0;
        accionCaja[75] = 0L;
        accionIngresoMensual[75] = 0L;
        accionGastoMensual[75] = 8000L;
        accionCapacidadVivienda[75] = 0;
        accionUsosMaximos[75] = 3;

        accionNombre[76] = "Peajes urbanos";
        accionDescripcion[76] = "Aporta caja y reduce algunos viajes, pero molesta a conductores.";
        accionCategoria[76] = 8;
        accionCosto[76] = 0L;
        efectoEstadistica1[76] = 12;
        deltaEstadistica1[76] = -2;
        efectoEstadistica2[76] = 1;
        deltaEstadistica2[76] = -5;
        efectoEstadistica3[76] = 5;
        deltaEstadistica3[76] = -1;
        efectoEstadistica4[76] = 0;
        deltaEstadistica4[76] = 0;
        accionCaja[76] = 250000L;
        accionIngresoMensual[76] = 20000L;
        accionGastoMensual[76] = 0L;
        accionCapacidadVivienda[76] = 0;
        accionUsosMaximos[76] = 1;

        accionNombre[77] = "Semaforos inteligentes";
        accionDescripcion[77] = "Coordina intersecciones y mejora el flujo vehicular.";
        accionCategoria[77] = 8;
        accionCosto[77] = 190000L;
        efectoEstadistica1[77] = 13;
        deltaEstadistica1[77] = 3;
        efectoEstadistica2[77] = 12;
        deltaEstadistica2[77] = -5;
        efectoEstadistica3[77] = 11;
        deltaEstadistica3[77] = -1;
        efectoEstadistica4[77] = 0;
        deltaEstadistica4[77] = 0;
        accionCaja[77] = 0L;
        accionIngresoMensual[77] = 0L;
        accionGastoMensual[77] = 5000L;
        accionCapacidadVivienda[77] = 0;
        accionUsosMaximos[77] = 3;

        accionNombre[78] = "Aeropuerto regional";
        accionDescripcion[78] = "Atrae visitantes y empleos, con ruido y contaminacion.";
        accionCategoria[78] = 8;
        accionCosto[78] = 2000000L;
        efectoEstadistica1[78] = 15;
        deltaEstadistica1[78] = 15;
        efectoEstadistica2[78] = 5;
        deltaEstadistica2[78] = 6;
        efectoEstadistica3[78] = 11;
        deltaEstadistica3[78] = 5;
        efectoEstadistica4[78] = 0;
        deltaEstadistica4[78] = 0;
        accionCaja[78] = 0L;
        accionIngresoMensual[78] = 45000L;
        accionGastoMensual[78] = 80000L;
        accionCapacidadVivienda[78] = 0;
        accionUsosMaximos[78] = 1;

        accionNombre[79] = "Terminal de carga ferroviaria";
        accionDescripcion[79] = "Facilita logistica y reduce camiones en ciertas rutas.";
        accionCategoria[79] = 8;
        accionCosto[79] = 1400000L;
        efectoEstadistica1[79] = 5;
        deltaEstadistica1[79] = 8;
        efectoEstadistica2[79] = 12;
        deltaEstadistica2[79] = -4;
        efectoEstadistica3[79] = 11;
        deltaEstadistica3[79] = -3;
        efectoEstadistica4[79] = 0;
        deltaEstadistica4[79] = 0;
        accionCaja[79] = 0L;
        accionIngresoMensual[79] = 30000L;
        accionGastoMensual[79] = 35000L;
        accionCapacidadVivienda[79] = 0;
        accionUsosMaximos[79] = 2;

        accionNombre[80] = "Descuidar baches y puentes";
        accionDescripcion[80] = "Ahorra recursos a corto plazo, deteriorando movilidad y confianza.";
        accionCategoria[80] = 8;
        accionCosto[80] = 0L;
        efectoEstadistica1[80] = 13;
        deltaEstadistica1[80] = -10;
        efectoEstadistica2[80] = 12;
        deltaEstadistica2[80] = 5;
        efectoEstadistica3[80] = 1;
        deltaEstadistica3[80] = -3;
        efectoEstadistica4[80] = 0;
        deltaEstadistica4[80] = 0;
        accionCaja[80] = 100000L;
        accionIngresoMensual[80] = 0L;
        accionGastoMensual[80] = -10000L;
        accionCapacidadVivienda[80] = 0;
        accionUsosMaximos[80] = 1;

        accionNombre[81] = "Parque urbano";
        accionDescripcion[81] = "Crea un espacio verde para recreacion y salud.";
        accionCategoria[81] = 9;
        accionCosto[81] = 500000L;
        efectoEstadistica1[81] = 10;
        deltaEstadistica1[81] = 9;
        efectoEstadistica2[81] = 2;
        deltaEstadistica2[81] = 3;
        efectoEstadistica3[81] = 1;
        deltaEstadistica3[81] = 5;
        efectoEstadistica4[81] = 0;
        deltaEstadistica4[81] = 0;
        accionCaja[81] = 0L;
        accionIngresoMensual[81] = 0L;
        accionGastoMensual[81] = 18000L;
        accionCapacidadVivienda[81] = 0;
        accionUsosMaximos[81] = 3;

        accionNombre[82] = "Jornada de arborizacion";
        accionDescripcion[82] = "Aumenta sombra, biodiversidad y captura de particulas.";
        accionCategoria[82] = 9;
        accionCosto[82] = 160000L;
        efectoEstadistica1[82] = 10;
        deltaEstadistica1[82] = 6;
        efectoEstadistica2[82] = 11;
        deltaEstadistica2[82] = -5;
        efectoEstadistica3[82] = 1;
        deltaEstadistica3[82] = 1;
        efectoEstadistica4[82] = 0;
        deltaEstadistica4[82] = 0;
        accionCaja[82] = 0L;
        accionIngresoMensual[82] = 0L;
        accionGastoMensual[82] = 5000L;
        accionCapacidadVivienda[82] = 0;
        accionUsosMaximos[82] = 3;

        accionNombre[83] = "Proteger humedales";
        accionDescripcion[83] = "Defiende ecosistemas y ayuda a regular el agua.";
        accionCategoria[83] = 9;
        accionCosto[83] = 450000L;
        efectoEstadistica1[83] = 6;
        deltaEstadistica1[83] = 5;
        efectoEstadistica2[83] = 10;
        deltaEstadistica2[83] = 9;
        efectoEstadistica3[83] = 11;
        deltaEstadistica3[83] = -3;
        efectoEstadistica4[83] = 0;
        deltaEstadistica4[83] = 0;
        accionCaja[83] = 0L;
        accionIngresoMensual[83] = 0L;
        accionGastoMensual[83] = 8000L;
        accionCapacidadVivienda[83] = 0;
        accionUsosMaximos[83] = 2;

        accionNombre[84] = "Granja periurbana";
        accionDescripcion[84] = "Mejora abasto de alimentos y empleo de proximidad.";
        accionCategoria[84] = 9;
        accionCosto[84] = 650000L;
        efectoEstadistica1[84] = 8;
        deltaEstadistica1[84] = 12;
        efectoEstadistica2[84] = 5;
        deltaEstadistica2[84] = 4;
        efectoEstadistica3[84] = 11;
        deltaEstadistica3[84] = -2;
        efectoEstadistica4[84] = 0;
        deltaEstadistica4[84] = 0;
        accionCaja[84] = 0L;
        accionIngresoMensual[84] = 0L;
        accionGastoMensual[84] = 20000L;
        accionCapacidadVivienda[84] = 0;
        accionUsosMaximos[84] = 3;

        accionNombre[85] = "Invernadero tecnologico";
        accionDescripcion[85] = "Eleva la produccion, con demanda adicional de energia.";
        accionCategoria[85] = 9;
        accionCosto[85] = 900000L;
        efectoEstadistica1[85] = 8;
        deltaEstadistica1[85] = 16;
        efectoEstadistica2[85] = 7;
        deltaEstadistica2[85] = -3;
        efectoEstadistica3[85] = 5;
        deltaEstadistica3[85] = 3;
        efectoEstadistica4[85] = 0;
        deltaEstadistica4[85] = 0;
        accionCaja[85] = 0L;
        accionIngresoMensual[85] = 0L;
        accionGastoMensual[85] = 30000L;
        accionCapacidadVivienda[85] = 0;
        accionUsosMaximos[85] = 2;

        accionNombre[86] = "Pesticidas sin control";
        accionDescripcion[86] = "Aumenta cosechas y caja a corto plazo, con impactos sanitarios.";
        accionCategoria[86] = 9;
        accionCosto[86] = 160000L;
        efectoEstadistica1[86] = 8;
        deltaEstadistica1[86] = 8;
        efectoEstadistica2[86] = 2;
        deltaEstadistica2[86] = -6;
        efectoEstadistica3[86] = 10;
        deltaEstadistica3[86] = -8;
        efectoEstadistica4[86] = 11;
        deltaEstadistica4[86] = 5;
        accionCaja[86] = 100000L;
        accionIngresoMensual[86] = 0L;
        accionGastoMensual[86] = 0L;
        accionCapacidadVivienda[86] = 0;
        accionUsosMaximos[86] = 2;

        accionNombre[87] = "Planta de reciclaje";
        accionDescripcion[87] = "Reduce residuos y crea empleos ambientales.";
        accionCategoria[87] = 9;
        accionCosto[87] = 800000L;
        efectoEstadistica1[87] = 10;
        deltaEstadistica1[87] = 6;
        efectoEstadistica2[87] = 11;
        deltaEstadistica2[87] = -8;
        efectoEstadistica3[87] = 5;
        deltaEstadistica3[87] = 4;
        efectoEstadistica4[87] = 0;
        deltaEstadistica4[87] = 0;
        accionCaja[87] = 0L;
        accionIngresoMensual[87] = 0L;
        accionGastoMensual[87] = 35000L;
        accionCapacidadVivienda[87] = 0;
        accionUsosMaximos[87] = 2;

        accionNombre[88] = "Multar grandes contaminadores";
        accionDescripcion[88] = "Disuade emisiones, aunque algunas empresas reducen actividad.";
        accionCategoria[88] = 9;
        accionCosto[88] = 0L;
        efectoEstadistica1[88] = 11;
        deltaEstadistica1[88] = -4;
        efectoEstadistica2[88] = 5;
        deltaEstadistica2[88] = -2;
        efectoEstadistica3[88] = 10;
        deltaEstadistica3[88] = 2;
        efectoEstadistica4[88] = 0;
        deltaEstadistica4[88] = 0;
        accionCaja[88] = 240000L;
        accionIngresoMensual[88] = 15000L;
        accionGastoMensual[88] = 0L;
        accionCapacidadVivienda[88] = 0;
        accionUsosMaximos[88] = 2;

        accionNombre[89] = "Quemar residuos a cielo abierto";
        accionDescripcion[89] = "Reduce acumulacion visible de basura, pero contamina gravemente.";
        accionCategoria[89] = 9;
        accionCosto[89] = 0L;
        efectoEstadistica1[89] = 11;
        deltaEstadistica1[89] = 10;
        efectoEstadistica2[89] = 10;
        deltaEstadistica2[89] = -7;
        efectoEstadistica3[89] = 2;
        deltaEstadistica3[89] = -3;
        efectoEstadistica4[89] = 0;
        deltaEstadistica4[89] = 0;
        accionCaja[89] = 120000L;
        accionIngresoMensual[89] = 0L;
        accionGastoMensual[89] = 0L;
        accionCapacidadVivienda[89] = 0;
        accionUsosMaximos[89] = 2;

        accionNombre[90] = "Educacion ambiental";
        accionDescripcion[90] = "Fomenta reciclaje, ahorro y cuidado del entorno.";
        accionCategoria[90] = 9;
        accionCosto[90] = 120000L;
        efectoEstadistica1[90] = 10;
        deltaEstadistica1[90] = 4;
        efectoEstadistica2[90] = 14;
        deltaEstadistica2[90] = 2;
        efectoEstadistica3[90] = 1;
        deltaEstadistica3[90] = 1;
        efectoEstadistica4[90] = 0;
        deltaEstadistica4[90] = 0;
        accionCaja[90] = 0L;
        accionIngresoMensual[90] = 0L;
        accionGastoMensual[90] = 0L;
        accionCapacidadVivienda[90] = 0;
        accionUsosMaximos[90] = 3;

        accionNombre[91] = "Digitalizar la alcaldia";
        accionDescripcion[91] = "Agiliza tramites y reduce costes administrativos.";
        accionCategoria[91] = 10;
        accionCosto[91] = 600000L;
        efectoEstadistica1[91] = 13;
        deltaEstadistica1[91] = 6;
        efectoEstadistica2[91] = 14;
        deltaEstadistica2[91] = 2;
        efectoEstadistica3[91] = 5;
        deltaEstadistica3[91] = 1;
        efectoEstadistica4[91] = 0;
        deltaEstadistica4[91] = 0;
        accionCaja[91] = 0L;
        accionIngresoMensual[91] = 30000L;
        accionGastoMensual[91] = -10000L;
        accionCapacidadVivienda[91] = 0;
        accionUsosMaximos[91] = 1;

        accionNombre[92] = "Presupuesto participativo";
        accionDescripcion[92] = "Permite que barrios prioricen mejoras locales.";
        accionCategoria[92] = 10;
        accionCosto[92] = 220000L;
        efectoEstadistica1[92] = 1;
        deltaEstadistica1[92] = 6;
        efectoEstadistica2[92] = 14;
        deltaEstadistica2[92] = 3;
        efectoEstadistica3[92] = 4;
        deltaEstadistica3[92] = 1;
        efectoEstadistica4[92] = 0;
        deltaEstadistica4[92] = 0;
        accionCaja[92] = 0L;
        accionIngresoMensual[92] = 0L;
        accionGastoMensual[92] = 5000L;
        accionCapacidadVivienda[92] = 0;
        accionUsosMaximos[92] = 2;

        accionNombre[93] = "Auditoria anticorrupcion";
        accionDescripcion[93] = "Mejora controles y confianza en la gestion publica.";
        accionCategoria[93] = 10;
        accionCosto[93] = 160000L;
        efectoEstadistica1[93] = 4;
        deltaEstadistica1[93] = 3;
        efectoEstadistica2[93] = 1;
        deltaEstadistica2[93] = 2;
        efectoEstadistica3[93] = 14;
        deltaEstadistica3[93] = 2;
        efectoEstadistica4[93] = 0;
        deltaEstadistica4[93] = 0;
        accionCaja[93] = 200000L;
        accionIngresoMensual[93] = 0L;
        accionGastoMensual[93] = 0L;
        accionCapacidadVivienda[93] = 0;
        accionUsosMaximos[93] = 2;

        accionNombre[94] = "Contrato amañado";
        accionDescripcion[94] = "Trae dinero inmediato a unos pocos y daña servicios e instituciones.";
        accionCategoria[94] = 10;
        accionCosto[94] = 0L;
        efectoEstadistica1[94] = 13;
        deltaEstadistica1[94] = -4;
        efectoEstadistica2[94] = 1;
        deltaEstadistica2[94] = -3;
        efectoEstadistica3[94] = 14;
        deltaEstadistica3[94] = -6;
        efectoEstadistica4[94] = 0;
        deltaEstadistica4[94] = 0;
        accionCaja[94] = 850000L;
        accionIngresoMensual[94] = 0L;
        accionGastoMensual[94] = 0L;
        accionCapacidadVivienda[94] = 0;
        accionUsosMaximos[94] = 1;

        accionNombre[95] = "Campana de turismo";
        accionDescripcion[95] = "Promociona atractivos locales y mueve la economia.";
        accionCategoria[95] = 10;
        accionCosto[95] = 450000L;
        efectoEstadistica1[95] = 15;
        deltaEstadistica1[95] = 12;
        efectoEstadistica2[95] = 5;
        deltaEstadistica2[95] = 4;
        efectoEstadistica3[95] = 14;
        deltaEstadistica3[95] = 2;
        efectoEstadistica4[95] = 0;
        deltaEstadistica4[95] = 0;
        accionCaja[95] = 0L;
        accionIngresoMensual[95] = 20000L;
        accionGastoMensual[95] = 20000L;
        accionCapacidadVivienda[95] = 0;
        accionUsosMaximos[95] = 2;

        accionNombre[96] = "Gran evento nacional";
        accionDescripcion[96] = "Atrae visitantes, pero satura vias y requiere organizacion.";
        accionCategoria[96] = 10;
        accionCosto[96] = 800000L;
        efectoEstadistica1[96] = 15;
        deltaEstadistica1[96] = 10;
        efectoEstadistica2[96] = 1;
        deltaEstadistica2[96] = 4;
        efectoEstadistica3[96] = 12;
        deltaEstadistica3[96] = 4;
        efectoEstadistica4[96] = 0;
        deltaEstadistica4[96] = 0;
        accionCaja[96] = 0L;
        accionIngresoMensual[96] = 80000L;
        accionGastoMensual[96] = 30000L;
        accionCapacidadVivienda[96] = 0;
        accionUsosMaximos[96] = 1;

        accionNombre[97] = "Tasa extra a bienes de lujo";
        accionDescripcion[97] = "Recauda dinero adicional con rechazo de parte de la ciudadania.";
        accionCategoria[97] = 10;
        accionCosto[97] = 0L;
        efectoEstadistica1[97] = 1;
        deltaEstadistica1[97] = -7;
        efectoEstadistica2[97] = 5;
        deltaEstadistica2[97] = -2;
        efectoEstadistica3[97] = 14;
        deltaEstadistica3[97] = -1;
        efectoEstadistica4[97] = 0;
        deltaEstadistica4[97] = 0;
        accionCaja[97] = 600000L;
        accionIngresoMensual[97] = 45000L;
        accionGastoMensual[97] = 0L;
        accionCapacidadVivienda[97] = 0;
        accionUsosMaximos[97] = 1;

        accionNombre[98] = "Austeridad de emergencia";
        accionDescripcion[98] = "Reduce costes publicos, pero recorta servicios esenciales.";
        accionCategoria[98] = 10;
        accionCosto[98] = 0L;
        efectoEstadistica1[98] = 1;
        deltaEstadistica1[98] = -8;
        efectoEstadistica2[98] = 2;
        deltaEstadistica2[98] = -4;
        efectoEstadistica3[98] = 3;
        deltaEstadistica3[98] = -4;
        efectoEstadistica4[98] = 0;
        deltaEstadistica4[98] = 0;
        accionCaja[98] = 400000L;
        accionIngresoMensual[98] = 0L;
        accionGastoMensual[98] = -70000L;
        accionCapacidadVivienda[98] = 0;
        accionUsosMaximos[98] = 1;

        accionNombre[99] = "Asamblea ciudadana";
        accionDescripcion[99] = "Abre dialogo sobre prioridades y resuelve conflictos locales.";
        accionCategoria[99] = 10;
        accionCosto[99] = 180000L;
        efectoEstadistica1[99] = 1;
        deltaEstadistica1[99] = 5;
        efectoEstadistica2[99] = 4;
        deltaEstadistica2[99] = 2;
        efectoEstadistica3[99] = 14;
        deltaEstadistica3[99] = 3;
        efectoEstadistica4[99] = 0;
        deltaEstadistica4[99] = 0;
        accionCaja[99] = 0L;
        accionIngresoMensual[99] = 0L;
        accionGastoMensual[99] = 12000L;
        accionCapacidadVivienda[99] = 0;
        accionUsosMaximos[99] = 2;

        accionNombre[100] = "Sensores de ciudad inteligente";
        accionDescripcion[100] = "Mejora gestion de trafico, agua y servicios urbanos.";
        accionCategoria[100] = 10;
        accionCosto[100] = 1200000L;
        efectoEstadistica1[100] = 13;
        deltaEstadistica1[100] = 8;
        efectoEstadistica2[100] = 12;
        deltaEstadistica2[100] = -5;
        efectoEstadistica3[100] = 6;
        deltaEstadistica3[100] = 3;
        efectoEstadistica4[100] = 0;
        deltaEstadistica4[100] = 0;
        accionCaja[100] = 0L;
        accionIngresoMensual[100] = 0L;
        accionGastoMensual[100] = 25000L;
        accionCapacidadVivienda[100] = 0;
        accionUsosMaximos[100] = 1;

        int poblacion = 10000;
        int capacidadVivienda = 11000;
        long tesoreria = 4000000L;
        long deuda = 0L;
        int tasaImpuestos = 12;
        int mes = 1;
        int anio = 1;
        int mesesJugados = 0;
        int accionesEsteMes = 0;
        final int MAX_ACCIONES_MES = 2;
        final int DURACION_CAMPANIA = 60;
        boolean impuestosCambiadosEsteMes = false;
        boolean sistemaActivo = true;
        boolean finCampania = false;
        boolean bancarrota = false;

        long ingresosAcumulados = 0L;
        long gastosAcumulados = 0L;
        long interesesAcumulados = 0L;
        int accionesEjecutadas = 0;
        int eventosPositivos = 0;
        int eventosNegativos = 0;
        int mesesConDeficit = 0;
        int mesesConSuperavit = 0;
        int totalMigracion = 0;
        String[] historial = new String[400];
        int historialCantidad = 0;

        System.out.println(CIAN + NEGRITA);
        System.out.println("===============================================================");
        System.out.println("               IMPERIO: CIUDAD 10.000                           ");
        System.out.println("       SIMULADOR DE GESTION URBANA EN TERMINAL                  ");
        System.out.println("===============================================================");
        System.out.println(RESET);
        System.out.println("Una ciudad, 10.000 habitantes, 100 decisiones y cinco anos.");
        System.out.println(AMARILLO + "MODO SIMULACION: todas las cifras son ficticias." + RESET);
        System.out.println("Tu objetivo: mantener la ciudad viva, solvente y habitable.");
        System.out.println("Acciones por mes: " + MAX_ACCIONES_MES + " | Duracion: "
                + DURACION_CAMPANIA + " meses | Impuestos iniciales: "
                + tasaImpuestos + "%");
        System.out.println("Presiona ENTER para inaugurar tu alcaldia...");
        scanner.nextLine();

        while (sistemaActivo && !finCampania && !bancarrota) {
            long ingresoEstimado = (long) (110000
                    + poblacion * (tasaImpuestos * 2.0
                    + estadistica[5] * 0.22 + estadistica[15] * 0.04)
                    + ingresoMensualExtra);
            long gastoEstimado = (long) (180000
                    + poblacion * (18.0
                    + (100 - estadistica[2]) * 0.04
                    + (100 - estadistica[3]) * 0.035
                    + (100 - estadistica[4]) * 0.04
                    + (100 - estadistica[6]) * 0.02
                    + estadistica[11] * 0.02)
                    + gastoMensualExtra + deuda * 0.004);

            System.out.println();
            System.out.println(CIAN + NEGRITA
                    + "+-------------------------------------------------------------+");
            System.out.printf("| IMPERIO: CIUDAD 10.000 | Ano %d, mes %02d | %2d/60 meses   |%n",
                    anio, mes, mesesJugados);
            System.out.println("+-------------------------------------------------------------+" + RESET);
            System.out.printf("| Habitantes: %-7s / %-7s | Caja: %-15s |%n",
                    String.format(Locale.US, "%,d", poblacion),
                    String.format(Locale.US, "%,d", capacidadVivienda),
                    "$" + String.format(Locale.US, "%,d", tesoreria));
            System.out.printf("| Deuda: %-16s | Impuestos: %2d%% | Acciones: %d/%d       |%n",
                    "$" + String.format(Locale.US, "%,d", deuda), tasaImpuestos,
                    accionesEsteMes, MAX_ACCIONES_MES);
            System.out.printf("| Balance mensual previsto: %-12s | Puntaje: %5.1f/100   |%n",
                    "$" + String.format(Locale.US, "%,d", ingresoEstimado - gastoEstimado),
                    ((estadistica[1] + estadistica[2] + estadistica[3] + estadistica[4]
                            + estadistica[5] + estadistica[6] + estadistica[7] + estadistica[8]
                            + estadistica[9] + estadistica[10] + (100 - estadistica[11])
                            + (100 - estadistica[12]) + estadistica[13] + estadistica[14]
                            + estadistica[15]) / 15.0));
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("1. Tablero de la ciudad");
            System.out.println("2. Ejecutar una accion (100 opciones)");
            System.out.println("3. Catalogo completo de acciones");
            System.out.println("4. Informe financiero tipo hoja de calculo");
            System.out.println("5. Informe de poblacion y servicios");
            System.out.println("6. Ajustar la tasa de impuestos");
            System.out.println("7. Banco: solicitar o pagar deuda");
            System.out.println("8. Historial de decisiones y eventos");
            System.out.println("9. Avanzar un mes y resolver la economia");
            System.out.println("10. Manual y objetivos de campana");
            System.out.println("11. Mapa urbano ASCII");
            System.out.println("0. Salir de la partida");
            System.out.print("Comando > ");

            if (!scanner.hasNextInt()) {
                System.out.println(ROJO + "Entrada invalida: escribe un numero." + RESET);
                scanner.nextLine();
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.println(CIAN + NEGRITA + "\nTABLERO GENERAL DE LA CIUDAD" + RESET);
                    System.out.println("Indicador                Valor  Estado visual");
                    System.out.println("--------------------------------------------------------------");
                    for (int i = 1; i <= 15; i++) {
                        String color = VERDE;
                        if (i == 11 || i == 12) {
                            if (estadistica[i] >= 60) color = ROJO;
                            else if (estadistica[i] >= 40) color = AMARILLO;
                        } else {
                            if (estadistica[i] < 30) color = ROJO;
                            else if (estadistica[i] < 50) color = AMARILLO;
                        }
                        System.out.printf("%-23s %3d/100 [", nombreEstadistica[i], estadistica[i]);
                        for (int barra = 0; barra < 20; barra++) {
                            if (barra < estadistica[i] / 5) System.out.print(color + "#" + RESET);
                            else System.out.print(".");
                        }
                        System.out.println("]");
                    }
                    System.out.println("\nLectura rapida:");
                    if (estadistica[6] < 35) System.out.println(ROJO + "ALERTA: el agua esta en nivel critico." + RESET);
                    if (estadistica[7] < 35) System.out.println(ROJO + "ALERTA: riesgo de insuficiencia electrica." + RESET);
                    if (estadistica[8] < 35) System.out.println(ROJO + "ALERTA: riesgo de inseguridad alimentaria." + RESET);
                    if (estadistica[2] < 35) System.out.println(ROJO + "ALERTA: el sistema de salud necesita atencion." + RESET);
                    if (estadistica[4] < 35) System.out.println(ROJO + "ALERTA: la seguridad requiere medidas." + RESET);
                    if (estadistica[11] > 65) System.out.println(ROJO + "ALERTA: contaminacion elevada." + RESET);
                    if (estadistica[12] > 70) System.out.println(ROJO + "ALERTA: congestion vial elevada." + RESET);
                    if (tesoreria < 0) System.out.println(ROJO + "ALERTA: la tesoreria esta en numeros rojos." + RESET);
                    if (deuda > 5000000L) System.out.println(AMARILLO + "Aviso: deuda elevada; los intereses aumentan cada mes." + RESET);
                    if (accionesEsteMes >= MAX_ACCIONES_MES) System.out.println(AMARILLO + "Ya utilizaste todas las acciones de este mes." + RESET);
                    break;
                }

                case 2: {
                    if (accionesEsteMes >= MAX_ACCIONES_MES) {
                        System.out.println(AMARILLO + "Limite mensual alcanzado. Avanza el mes para decidir de nuevo." + RESET);
                        break;
                    }
                    System.out.println(CIAN + "\nEJECUTAR DECISION MUNICIPAL" + RESET);
                    System.out.println("Consulta la opcion 3 para ver el catalogo de 100 acciones.");
                    System.out.print("ID de accion (1-100; 0 cancela): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println(ROJO + "Debes escribir un entero." + RESET);
                        scanner.nextLine();
                        break;
                    }
                    int idAccion = scanner.nextInt();
                    scanner.nextLine();
                    if (idAccion == 0) break;
                    if (idAccion < 1 || idAccion > 100) {
                        System.out.println(ROJO + "El ID debe estar entre 1 y 100." + RESET);
                        break;
                    }
                    System.out.println("\n" + AMARILLO + "ACCION " + idAccion + ": " + accionNombre[idAccion] + RESET);
                    System.out.println("Categoria: " + categoriaNombre[accionCategoria[idAccion]]);
                    System.out.println(accionDescripcion[idAccion]);
                    System.out.println("Costo de ejecucion: $" + String.format(Locale.US, "%,d", accionCosto[idAccion]));
                    System.out.println("Caja inmediata: " + (accionCaja[idAccion] >= 0 ? "+$" : "-$")
                            + String.format(Locale.US, "%,d", Math.abs(accionCaja[idAccion])));
                    System.out.println("Flujo mensual adicional: ingresos $"
                            + String.format(Locale.US, "%,d", accionIngresoMensual[idAccion])
                            + " | gastos $" + String.format(Locale.US, "%,d", accionGastoMensual[idAccion]));
                    System.out.println("Usos disponibles: " + accionUsos[idAccion] + "/" + accionUsosMaximos[idAccion]);
                    System.out.print("¿Confirmar la decision? (1=si, 0=no): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println(ROJO + "Confirmacion invalida." + RESET);
                        scanner.nextLine();
                        break;
                    }
                    int confirmar = scanner.nextInt();
                    scanner.nextLine();
                    if (confirmar != 1) {
                        System.out.println("Decision cancelada; no se aplicaron cambios.");
                        break;
                    }
                    if (accionUsos[idAccion] >= accionUsosMaximos[idAccion]) {
                        System.out.println(ROJO + "Ya agotaste los usos disponibles de esta accion." + RESET);
                        break;
                    }
                    if (tesoreria < accionCosto[idAccion]) {
                        System.out.println(ROJO + "Fondos insuficientes. No se ejecuto la accion." + RESET);
                        break;
                    }
                    tesoreria -= accionCosto[idAccion];
                    tesoreria += accionCaja[idAccion];
                    ingresoMensualExtra += accionIngresoMensual[idAccion];
                    gastoMensualExtra += accionGastoMensual[idAccion];
                    capacidadVivienda += accionCapacidadVivienda[idAccion];
                    if (capacidadVivienda < 5000) capacidadVivienda = 5000;
                    if (capacidadVivienda > 60000) capacidadVivienda = 60000;
                    if (efectoEstadistica1[idAccion] > 0) estadistica[efectoEstadistica1[idAccion]] += deltaEstadistica1[idAccion];
                    if (efectoEstadistica2[idAccion] > 0) estadistica[efectoEstadistica2[idAccion]] += deltaEstadistica2[idAccion];
                    if (efectoEstadistica3[idAccion] > 0) estadistica[efectoEstadistica3[idAccion]] += deltaEstadistica3[idAccion];
                    if (efectoEstadistica4[idAccion] > 0) estadistica[efectoEstadistica4[idAccion]] += deltaEstadistica4[idAccion];
                    for (int i = 1; i <= 15; i++) {
                        if (estadistica[i] < 0) estadistica[i] = 0;
                        if (estadistica[i] > 100) estadistica[i] = 100;
                    }
                    if (accionCapacidadVivienda[idAccion] < 0 && poblacion > capacidadVivienda) {
                        int desplazados = poblacion - capacidadVivienda;
                        poblacion = capacidadVivienda;
                        estadistica[1] -= Math.min(10, desplazados / 100);
                        if (estadistica[1] < 0) estadistica[1] = 0;
                        System.out.println(ROJO + "Advertencia: la capacidad baja de vivienda desplazo a "
                                + desplazados + " habitantes." + RESET);
                    }
                    accionUsos[idAccion]++;
                    accionesEsteMes++;
                    accionesEjecutadas++;
                    String registroAccion = "Ano " + anio + ", mes " + mes + ": accion " + idAccion + " - " + accionNombre[idAccion];
                    if (historialCantidad < historial.length) historial[historialCantidad++] = registroAccion;
                    System.out.println(VERDE + "Decision ejecutada. La ciudad ha cambiado." + RESET);
                    System.out.println("Caja actual: $" + String.format(Locale.US, "%,d", tesoreria));
                    break;
                }

                case 3: {
                    System.out.println(CIAN + NEGRITA + "\nCATALOGO DE 100 ACCIONES — FORMATO TIPO HOJA DE CALCULO" + RESET);
                    System.out.printf("%-4s %-28s %-26s %13s %8s%n", "ID", "ACCION", "CATEGORIA", "COSTO", "USOS");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    for (int i = 1; i <= 100; i++) {
                        System.out.printf("%3d  %-28.28s %-26.26s %13s %3d/%-3d%n",
                                i, accionNombre[i], categoriaNombre[accionCategoria[i]],
                                "$" + String.format(Locale.US, "%,d", accionCosto[i]),
                                accionUsos[i], accionUsosMaximos[i]);
                        if (i % 10 == 0) System.out.println("----------------------------------------------------------------------------------------------");
                    }
                    System.out.println("Las acciones pueden tener beneficios, costes recurrentes o consecuencias negativas.");
                    System.out.println("El efecto exacto aparece al intentar ejecutar una accion desde la opcion 2.");
                    break;
                }

                case 4: {
                    long ingresosBase = (long) (110000
                            + poblacion * (tasaImpuestos * 2.0 + estadistica[5] * 0.22 + estadistica[15] * 0.04));
                    long ingresosMes = ingresosBase + ingresoMensualExtra;
                    long interesMes = (long) (deuda * 0.004);
                    long gastosBase = (long) (180000 + poblacion * (18.0
                            + (100 - estadistica[2]) * 0.04
                            + (100 - estadistica[3]) * 0.035
                            + (100 - estadistica[4]) * 0.04
                            + (100 - estadistica[6]) * 0.02
                            + estadistica[11] * 0.02));
                    long gastosMes = gastosBase + gastoMensualExtra + interesMes;
                    long balanceMes = ingresosMes - gastosMes;
                    System.out.println(CIAN + NEGRITA + "\nLIBRO MAYOR MUNICIPAL / INFORME FINANCIERO" + RESET);
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("%-42s %22s%n", "CONCEPTO", "VALOR (CREDITO SIMULADO)");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("%-42s %22s%n", "Tesoreria disponible", "$" + String.format(Locale.US, "%,d", tesoreria));
                    System.out.printf("%-42s %22s%n", "Deuda pendiente", "$" + String.format(Locale.US, "%,d", deuda));
                    System.out.printf("%-42s %22s%n", "Tasa de impuestos", tasaImpuestos + "%");
                    System.out.printf("%-42s %22s%n", "Ingresos base del mes", "$" + String.format(Locale.US, "%,d", ingresosBase));
                    System.out.printf("%-42s %22s%n", "Ingresos recurrentes de acciones", "$" + String.format(Locale.US, "%,d", ingresoMensualExtra));
                    System.out.printf("%-42s %22s%n", "TOTAL INGRESOS MENSUALES", "$" + String.format(Locale.US, "%,d", ingresosMes));
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("%-42s %22s%n", "Coste base de servicios", "$" + String.format(Locale.US, "%,d", gastosBase));
                    System.out.printf("%-42s %22s%n", "Mantenimiento recurrente de acciones", "$" + String.format(Locale.US, "%,d", gastoMensualExtra));
                    System.out.printf("%-42s %22s%n", "Intereses estimados de la deuda", "$" + String.format(Locale.US, "%,d", interesMes));
                    System.out.printf("%-42s %22s%n", "TOTAL GASTOS MENSUALES", "$" + String.format(Locale.US, "%,d", gastosMes));
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String colorBalance = balanceMes >= 0 ? VERDE : ROJO;
                    System.out.printf("%-42s %22s%n", colorBalance + "BALANCE MENSUAL PREVISTO" + RESET,
                            colorBalance + "$" + String.format(Locale.US, "%,d", balanceMes) + RESET);
                    System.out.printf("%-42s %22s%n", "Ingresos acumulados en la campana", "$" + String.format(Locale.US, "%,d", ingresosAcumulados));
                    System.out.printf("%-42s %22s%n", "Gastos acumulados en la campana", "$" + String.format(Locale.US, "%,d", gastosAcumulados));
                    System.out.printf("%-42s %22s%n", "Intereses pagados acumulados", "$" + String.format(Locale.US, "%,d", interesesAcumulados));
                    System.out.printf("%-42s %22s%n", "Meses con superavit / deficit", mesesConSuperavit + " / " + mesesConDeficit);
                    System.out.println("Nota: el balance previsto puede cambiar con eventos aleatorios y migracion.");
                    break;
                }

                case 5: {
                    System.out.println(CIAN + NEGRITA + "\nPOBLACION, SERVICIOS Y CALIDAD DE VIDA" + RESET);
                    System.out.println("Habitantes actuales: " + String.format(Locale.US, "%,d", poblacion));
                    System.out.println("Capacidad residencial: " + String.format(Locale.US, "%,d", capacidadVivienda));
                    System.out.println("Ocupacion residencial: " + String.format(Locale.US, "%.1f", poblacion * 100.0 / capacidadVivienda) + "%");
                    System.out.println("Cambio neto de poblacion desde el inicio: " + (poblacion - 10000));
                    System.out.println("Balance migratorio acumulado aproximado: " + totalMigracion);
                    System.out.println("\nServicio / factor              Puntaje   Diagnostico");
                    System.out.println("--------------------------------------------------------------");
                    for (int i = 1; i <= 15; i++) {
                        String diagnostico;
                        int valorEfectivo = estadistica[i];
                        if (i == 11 || i == 12) valorEfectivo = 100 - estadistica[i];
                        if (valorEfectivo >= 75) diagnostico = "Excelente";
                        else if (valorEfectivo >= 60) diagnostico = "Estable";
                        else if (valorEfectivo >= 45) diagnostico = "Vulnerable";
                        else if (valorEfectivo >= 30) diagnostico = "Deficiente";
                        else diagnostico = "Critico";
                        System.out.printf("%-27s %3d/100   %s%n", nombreEstadistica[i], estadistica[i], diagnostico);
                    }
                    if (poblacion >= capacidadVivienda * 0.95) {
                        System.out.println(AMARILLO + "La ciudad esta cerca del limite de vivienda. Construye mas hogares." + RESET);
                    }
                    if (estadistica[1] < 30 || estadistica[2] < 25 || estadistica[8] < 25) {
                        System.out.println(ROJO + "Riesgo social severo: atiende bienestar, salud y abasto." + RESET);
                    }
                    break;
                }

                case 6: {
                    if (impuestosCambiadosEsteMes) {
                        System.out.println(AMARILLO + "Ya ajustaste los impuestos este mes. Avanza el calendario para volver a cambiarlos." + RESET);
                        break;
                    }
                    System.out.println("Tasa actual: " + tasaImpuestos + "% (rango permitido: 5%-25%).");
                    System.out.print("Nueva tasa (5-25; 0 cancela): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println(ROJO + "Debes escribir un entero." + RESET);
                        scanner.nextLine();
                        break;
                    }
                    int nuevaTasa = scanner.nextInt();
                    scanner.nextLine();
                    if (nuevaTasa == 0) break;
                    if (nuevaTasa < 5 || nuevaTasa > 25) {
                        System.out.println(ROJO + "La tasa debe estar entre 5 y 25." + RESET);
                        break;
                    }
                    int diferenciaTasa = nuevaTasa - tasaImpuestos;
                    tasaImpuestos = nuevaTasa;
                    if (diferenciaTasa >= 5) {
                        estadistica[1] -= 4;
                        estadistica[5] -= 2;
                        System.out.println(AMARILLO + "La subida fuerte mejora ingresos, pero perjudica consumo y animo." + RESET);
                    } else if (diferenciaTasa > 0) {
                        estadistica[1] -= 2;
                    } else if (diferenciaTasa <= -5) {
                        estadistica[1] += 4;
                        estadistica[5] += 2;
                        System.out.println(VERDE + "La reduccion alivia a hogares y empresas, pero reduce ingresos." + RESET);
                    } else if (diferenciaTasa < 0) {
                        estadistica[1] += 2;
                    }
                    for (int i = 1; i <= 15; i++) {
                        if (estadistica[i] < 0) estadistica[i] = 0;
                        if (estadistica[i] > 100) estadistica[i] = 100;
                    }
                    impuestosCambiadosEsteMes = true;
                    if (historialCantidad < historial.length) historial[historialCantidad++] = "Ano " + anio + ", mes " + mes + ": tasa fiscal ajustada a " + tasaImpuestos + "%";
                    System.out.println("Nueva tasa fiscal aplicada: " + tasaImpuestos + "%.");
                    break;
                }

                case 7: {
                    System.out.println(CIAN + "\nBANCO MUNICIPAL" + RESET);
                    System.out.println("Tesoreria: $" + String.format(Locale.US, "%,d", tesoreria));
                    System.out.println("Deuda actual: $" + String.format(Locale.US, "%,d", deuda));
                    System.out.println("Interes simulado: 0,4% mensual sobre deuda pendiente.");
                    System.out.println("1. Solicitar credito de $500.000");
                    System.out.println("2. Solicitar credito de $1.000.000");
                    System.out.println("3. Solicitar credito de $2.000.000");
                    System.out.println("4. Abonar a la deuda");
                    System.out.println("0. Volver");
                    System.out.print("Opcion bancaria: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println(ROJO + "Entrada invalida." + RESET);
                        scanner.nextLine();
                        break;
                    }
                    int opcionBanco = scanner.nextInt();
                    scanner.nextLine();
                    long nuevoCredito = 0L;
                    if (opcionBanco == 1) nuevoCredito = 500000L;
                    else if (opcionBanco == 2) nuevoCredito = 1000000L;
                    else if (opcionBanco == 3) nuevoCredito = 2000000L;
                    if (nuevoCredito > 0) {
                        if (deuda + nuevoCredito > 8000000L) {
                            System.out.println(ROJO + "Limite de credito: $8.000.000. Rechazado." + RESET);
                        } else {
                            tesoreria += nuevoCredito;
                            deuda += nuevoCredito;
                            if (historialCantidad < historial.length) historial[historialCantidad++] = "Ano " + anio + ", mes " + mes + ": credito recibido $" + nuevoCredito;
                            System.out.println(VERDE + "Credito desembolsado. Recuerda que genera intereses mensuales." + RESET);
                        }
                    } else if (opcionBanco == 4) {
                        if (deuda <= 0) {
                            System.out.println("No tienes deuda pendiente.");
                        } else {
                            System.out.print("Valor del abono (multiplo de 100.000; 0 cancela): ");
                            if (!scanner.hasNextLong()) {
                                System.out.println(ROJO + "Debes escribir una cantidad entera." + RESET);
                                scanner.nextLine();
                                break;
                            }
                            long abono = scanner.nextLong();
                            scanner.nextLine();
                            if (abono == 0) break;
                            if (abono < 0 || abono % 100000L != 0 || abono > deuda || abono > tesoreria) {
                                System.out.println(ROJO + "Abono invalido: revisa caja, deuda y multiplos de $100.000." + RESET);
                            } else {
                                tesoreria -= abono;
                                deuda -= abono;
                                if (historialCantidad < historial.length) historial[historialCantidad++] = "Ano " + anio + ", mes " + mes + ": abono a deuda $" + abono;
                                System.out.println(VERDE + "Abono aplicado." + RESET);
                            }
                        }
                    } else if (opcionBanco != 0) {
                        System.out.println(ROJO + "Opcion bancaria no valida." + RESET);
                    }
                    break;
                }

                case 8: {
                    System.out.println(CIAN + NEGRITA + "\nHISTORIAL DE ACTIVIDAD" + RESET);
                    if (historialCantidad == 0) {
                        System.out.println("Todavia no hay decisiones ni meses registrados.");
                    } else {
                        int desde = historialCantidad - 20;
                        if (desde < 0) desde = 0;
                        System.out.println("Mostrando los ultimos " + (historialCantidad - desde) + " registros:");
                        for (int i = desde; i < historialCantidad; i++) {
                            System.out.println((i + 1) + ". " + historial[i]);
                        }
                    }
                    break;
                }

                case 9: {
                    System.out.println(CIAN + NEGRITA + "\nCIERRE DEL MES: " + mes + ", ANO " + anio + RESET);
                    mesesJugados++;
                    int evento = azar.nextInt(12) + 1;
                    System.out.println("Evento del mes:");
                    switch (evento) {
                        case 1:
                            estadistica[6] -= 8; estadistica[8] -= 2; estadistica[1] -= 2;
                            tesoreria -= 90000L; eventosNegativos++;
                            System.out.println(ROJO + "SEQUIA: cae la reserva de agua y suben gastos de emergencia." + RESET);
                            break;
                        case 2:
                            estadistica[2] -= 6; estadistica[1] -= 3; tesoreria -= 120000L; eventosNegativos++;
                            System.out.println(ROJO + "ALERTA SANITARIA: hay que reforzar prevencion y atencion." + RESET);
                            break;
                        case 3:
                            estadistica[15] += 5; estadistica[1] += 4; estadistica[14] += 3; tesoreria -= 80000L; eventosPositivos++;
                            System.out.println(VERDE + "FESTIVAL ESPONTANEO: llega turismo y mejora el animo." + RESET);
                            break;
                        case 4:
                            estadistica[5] += 4; estadistica[11] += 3; tesoreria += 150000L; eventosPositivos++;
                            System.out.println(VERDE + "INVERSION PRIVADA: se abren empleos, con mayor presion ambiental." + RESET);
                            break;
                        case 5:
                            estadistica[4] -= 6; estadistica[1] -= 4; eventosNegativos++;
                            System.out.println(ROJO + "OLA DE DELITOS: cae la seguridad percibida." + RESET);
                            break;
                        case 6:
                            estadistica[3] += 2; estadistica[5] += 2; estadistica[15] += 4; tesoreria += 60000L; eventosPositivos++;
                            System.out.println(VERDE + "ENCUENTRO TECNOLOGICO: talento y visitantes dinamizan la ciudad." + RESET);
                            break;
                        case 7:
                            estadistica[13] -= 5; estadistica[6] -= 3; tesoreria -= 120000L; eventosNegativos++;
                            System.out.println(ROJO + "TORMENTA: se dañan vias y parte de la red de agua." + RESET);
                            break;
                        case 8:
                            estadistica[8] += 8; estadistica[1] += 2; eventosPositivos++;
                            System.out.println(VERDE + "COSECHA ABUNDANTE: mejora el suministro de alimentos." + RESET);
                            break;
                        case 9:
                            estadistica[15] += 6; tesoreria += 90000L; eventosPositivos++;
                            System.out.println(VERDE + "TEMPORADA TURISTICA: comercios y alojamientos reciben visitantes." + RESET);
                            break;
                        case 10:
                            tesoreria -= 180000L; estadistica[4] -= 3; estadistica[1] -= 5; eventosNegativos++;
                            System.out.println(ROJO + "ESCANDALO DE CORRUPCION: se pierde dinero y confianza." + RESET);
                            break;
                        case 11:
                            estadistica[7] += 3; estadistica[13] += 2; tesoreria -= 60000L; eventosPositivos++;
                            System.out.println(VERDE + "MEJORA TECNICA: una reparacion inesperada estabiliza la energia." + RESET);
                            break;
                        case 12:
                            estadistica[1] += 1; estadistica[2] += 1; eventosPositivos++;
                            System.out.println(VERDE + "MES TRANQUILO: los servicios operan sin sobresaltos." + RESET);
                            break;
                    }

                    // Ajuste por fallos de servicios esenciales.
                    if (estadistica[6] < 30) { estadistica[2] -= 2; estadistica[1] -= 2; }
                    if (estadistica[7] < 25) { estadistica[5] -= 3; estadistica[1] -= 2; }
                    if (estadistica[8] < 25) { estadistica[2] -= 4; estadistica[1] -= 3; }
                    if (estadistica[2] < 25) { estadistica[1] -= 2; }
                    if (estadistica[11] > 70) { estadistica[2] -= 2; estadistica[10] -= 1; }
                    if (estadistica[12] > 75) { estadistica[1] -= 1; }
                    for (int i = 1; i <= 15; i++) {
                        if (estadistica[i] < 0) estadistica[i] = 0;
                        if (estadistica[i] > 100) estadistica[i] = 100;
                    }

                    long ingresosBase = (long) (110000
                            + poblacion * (tasaImpuestos * 2.0 + estadistica[5] * 0.22 + estadistica[15] * 0.04));
                    long ingresosMes = ingresosBase + ingresoMensualExtra;
                    long interesMes = (long) (deuda * 0.004);
                    long gastosBase = (long) (180000 + poblacion * (18.0
                            + (100 - estadistica[2]) * 0.04
                            + (100 - estadistica[3]) * 0.035
                            + (100 - estadistica[4]) * 0.04
                            + (100 - estadistica[6]) * 0.02
                            + estadistica[11] * 0.02));
                    long gastosMes = gastosBase + gastoMensualExtra + interesMes;
                    long balanceMes = ingresosMes - gastosMes;
                    tesoreria += balanceMes;
                    ingresosAcumulados += ingresosMes;
                    gastosAcumulados += gastosMes;
                    interesesAcumulados += interesMes;
                    if (balanceMes >= 0) mesesConSuperavit++;
                    else mesesConDeficit++;
                    System.out.println("Ingresos del mes: $" + String.format(Locale.US, "%,d", ingresosMes));
                    System.out.println("Gastos del mes:   $" + String.format(Locale.US, "%,d", gastosMes));
                    System.out.println("Balance:          " + (balanceMes >= 0 ? VERDE : ROJO)
                            + "$" + String.format(Locale.US, "%,d", balanceMes) + RESET);

                    int migracion = (estadistica[1] - 50) / 4
                            + (estadistica[5] - 50) / 5
                            + (estadistica[9] - 50) / 6
                            + (estadistica[2] - 50) / 8
                            + azar.nextInt(41) - 20;
                    if (estadistica[8] < 25) migracion -= 20;
                    if (estadistica[1] < 25) migracion -= 15;
                    if (estadistica[5] < 25) migracion -= 15;
                    if (poblacion + migracion > capacidadVivienda) migracion = capacidadVivienda - poblacion;
                    if (poblacion + migracion < 2000) migracion = 2000 - poblacion;
                    poblacion += migracion;
                    totalMigracion += migracion;
                    if (migracion > 0) System.out.println(VERDE + "Balance migratorio: +" + migracion + " habitantes." + RESET);
                    else if (migracion < 0) System.out.println(ROJO + "Balance migratorio: " + migracion + " habitantes." + RESET);
                    else System.out.println("Balance migratorio: sin cambio neto.");

                    if (estadistica[1] > 60 && estadistica[5] > 55 && estadistica[9] > 50) {
                        if (azar.nextInt(100) < 30) {
                            poblacion += 10;
                            if (poblacion > capacidadVivienda) poblacion = capacidadVivienda;
                            System.out.println("Crecimiento natural: nacimientos superan ligeramente a las defunciones.");
                        }
                    }

                    for (int i = 1; i <= 15; i++) {
                        if (estadistica[i] < 0) estadistica[i] = 0;
                        if (estadistica[i] > 100) estadistica[i] = 100;
                    }
                    accionesEsteMes = 0;
                    impuestosCambiadosEsteMes = false;
                    if (historialCantidad < historial.length) historial[historialCantidad++] = "Cierre de ano " + anio + ", mes " + mes + ": saldo $" + balanceMes;

                    mes++;
                    if (mes > 12) { mes = 1; anio++; }
                    System.out.println("\nCierre realizado. La ciudad entra en el siguiente mes.");
                    if (tesoreria < -2500000L) {
                        bancarrota = true;
                        System.out.println(ROJO + NEGRITA + "BANCARROTA: la tesoreria cruzo el limite de supervivencia." + RESET);
                    } else if (poblacion < 2500) {
                        bancarrota = true;
                        System.out.println(ROJO + NEGRITA + "COLAPSO DEMOGRAFICO: la ciudad perdio demasiados habitantes." + RESET);
                    } else if (estadistica[1] <= 2 && estadistica[2] <= 2) {
                        bancarrota = true;
                        System.out.println(ROJO + NEGRITA + "COLAPSO SOCIAL: felicidad y salud llegaron al minimo." + RESET);
                    } else if (mesesJugados >= DURACION_CAMPANIA) {
                        finCampania = true;
                    }
                    break;
                }

                case 10: {
                    System.out.println(CIAN + NEGRITA + "\nMANUAL DE IMPERIO: CIUDAD 10.000" + RESET);
                    System.out.println("OBJETIVO: gobernar durante 60 meses sin bancarrota ni colapso demografico.");
                    System.out.println("- Empiezas con 10.000 habitantes, 4.000.000 creditos y capacidad para 11.000 residentes.");
                    System.out.println("- Puedes ejecutar como maximo dos acciones por mes; cada accion tiene usos limitados.");
                    System.out.println("- Las 100 acciones estan repartidas entre agua, energia, vivienda, salud, educacion,");
                    System.out.println("  seguridad, economia, transporte, medio ambiente, gobierno y turismo.");
                    System.out.println("- Las acciones pueden cambiar indicadores, caja, capacidad de vivienda y flujos mensuales.");
                    System.out.println("- Los eventos aleatorios pueden ayudar o perjudicar. Las necesidades criticas afectan migracion.");
                    System.out.println("- Los creditos generan un interes simulado del 0,4% cada mes. Limite de deuda: 8 millones.");
                    System.out.println("- Impuestos permitidos: 5%-25%; subirlos aumenta ingresos, pero puede bajar el bienestar.");
                    System.out.println("- Contaminacion y congestion: menor puntuacion es mejor; el tablero las muestra como valores de riesgo.");
                    System.out.println("- Una accion con caja positiva puede traer dinero inmediato, pero tambien provocar daños sociales.");
                    System.out.println("- Este es un modelo educativo: no es un simulador economico validado ni representa una ciudad real.");
                    break;
                }

                case 11: {
                    System.out.println(CIAN + NEGRITA + "\nMAPA URBANO - DISTRITOS DE IMPERIO" + RESET);
                    System.out.println("+----------------------+----------------------+----------------------+");
                    System.out.println("| NORTE: SERVICIOS     | CENTRO: CIUDADANIA   | ESTE: ECONOMIA       |");
                    System.out.printf("| [W] Agua       %3d  | [H] Felicidad  %3d  | [$] Empleo      %3d  |%n",
                            estadistica[6], estadistica[1], estadistica[5]);
                    System.out.printf("| [E] Energia    %3d  | [C] Cultura     %3d  | [T] Turismo      %3d  |%n",
                            estadistica[7], estadistica[14], estadistica[15]);
                    System.out.println("+----------------------+----------------------+----------------------+");
                    System.out.println("| OESTE: ECOLOGIA      | SUR: BARRIOS         | ESTE-SUR: MOVILIDAD  |");
                    System.out.printf("| [P] Ambiente   %3d  | [V] Vivienda    %3d  | [R] Transporte  %3d  |%n",
                            estadistica[10], estadistica[9], 100 - estadistica[12]);
                    System.out.printf("| [X] Polucion   %3d  | [F] Alimentos   %3d  | [I] Infraestructura %2d |%n",
                            estadistica[11], estadistica[8], estadistica[13]);
                    System.out.println("+----------------------+----------------------+----------------------+");
                    System.out.println("LEYENDA: W agua | E energia | H bienestar | C cultura | $ empleo");
                    System.out.println("         T turismo | P ecologia | X contaminacion | V vivienda");
                    System.out.println("         F alimentos | R movilidad (valor mayor = menos congestion) | I obras");
                    System.out.println("Poblacion: " + String.format(Locale.US, "%,d", poblacion)
                            + " habitantes; capacidad residencial: "
                            + String.format(Locale.US, "%,d", capacidadVivienda) + ".");
                    System.out.println("Este plano resume indicadores por distrito; no es un mapa geografico a escala.");
                    break;
                }

                case 0: {
                    sistemaActivo = false;
                    System.out.println("Saliendo de la alcaldia. Tus decisiones quedan en esta sesion solamente.");
                    break;
                }

                default: {
                    System.out.println(ROJO + "Comando desconocido. Elige una opcion del 0 al 11." + RESET);
                    break;
                }
            }
        }

        double puntajeFinal = (estadistica[1] + estadistica[2] + estadistica[3] + estadistica[4]
                + estadistica[5] + estadistica[6] + estadistica[7] + estadistica[8]
                + estadistica[9] + estadistica[10] + (100 - estadistica[11])
                + (100 - estadistica[12]) + estadistica[13] + estadistica[14]
                + estadistica[15]) / 15.0;

        System.out.println();
        System.out.println(CIAN + NEGRITA + "===============================================================" + RESET);
        if (finCampania) System.out.println(VERDE + NEGRITA + "CAMPANA COMPLETADA: cinco anos de gobierno" + RESET);
        else if (bancarrota) System.out.println(ROJO + NEGRITA + "FIN DE LA PARTIDA: la ciudad no pudo sostenerse" + RESET);
        else System.out.println(AMARILLO + NEGRITA + "RESUMEN DE LA SESION" + RESET);
        System.out.println("Habitantes finales: " + String.format(Locale.US, "%,d", poblacion));
        System.out.println("Tesoreria final: $" + String.format(Locale.US, "%,d", tesoreria));
        System.out.println("Deuda final: $" + String.format(Locale.US, "%,d", deuda));
        System.out.println("Meses gobernados: " + mesesJugados + "/" + DURACION_CAMPANIA);
        System.out.println("Acciones municipales ejecutadas: " + accionesEjecutadas);
        System.out.println("Eventos positivos / negativos: " + eventosPositivos + " / " + eventosNegativos);
        System.out.println("Ingresos acumulados: $" + String.format(Locale.US, "%,d", ingresosAcumulados));
        System.out.println("Gastos acumulados: $" + String.format(Locale.US, "%,d", gastosAcumulados));
        System.out.println("Intereses acumulados: $" + String.format(Locale.US, "%,d", interesesAcumulados));
        System.out.printf("Puntaje de bienestar final: %.1f/100%n", puntajeFinal);
        if (puntajeFinal >= 80 && tesoreria >= 0 && poblacion >= 10000) System.out.println(VERDE + "RANGO: CIUDAD MODELO" + RESET);
        else if (puntajeFinal >= 65 && tesoreria >= 0) System.out.println(VERDE + "RANGO: CIUDAD PROSPERA" + RESET);
        else if (puntajeFinal >= 50) System.out.println(AMARILLO + "RANGO: EQUILIBRIO DELICADO" + RESET);
        else if (puntajeFinal >= 35) System.out.println(ROJO + "RANGO: CIUDAD EN CRISIS" + RESET);
        else System.out.println(ROJO + NEGRITA + "RANGO: COLAPSO URBANO" + RESET);
        System.out.println(CIAN + "Gracias por jugar IMPERIO: CIUDAD 10.000." + RESET);
        scanner.close();
    }
}

