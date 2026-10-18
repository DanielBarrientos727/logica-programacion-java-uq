import java.util.Scanner;
import java.util.Random;

public class EDEQFinanzas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(20261017L);

        final int TOTAL_CLIENTES = 1320;
        final int TOTAL_MESES = 12;
        final int FILAS_POR_PAGINA = 20;
        final double TARIFA_LOCAL = 945.0;
        final double TARIFA_TIENDA = 875.0;
        final double CARGO_FIJO = 6800.0;
        final double COSTO_ENERGIA_POR_KWH = 548.0;

        String[] nombresMeses = {
                "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
                "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
        };

        int[] idCliente = new int[TOTAL_CLIENTES];
        String[] nombreCliente = new String[TOTAL_CLIENTES];
        String[] tipoCliente = new String[TOTAL_CLIENTES];
        String[] sectorCliente = new String[TOTAL_CLIENTES];
        double[] consumoBase = new double[TOTAL_CLIENTES];
        double[] tarifaCliente = new double[TOTAL_CLIENTES];
        double[] propensionPago = new double[TOTAL_CLIENTES];

        double[] facturacionMensual = new double[TOTAL_MESES];
        double[] recaudoMensual = new double[TOTAL_MESES];
        double[] costoEnergiaMensual = new double[TOTAL_MESES];
        double[] costoOperacionMensual = new double[TOTAL_MESES];
        double[] carteraMensual = new double[TOTAL_MESES];
        double[] utilidadMensual = new double[TOTAL_MESES];
        double[] kwhMensual = new double[TOTAL_MESES];
        int[] clientesAlDiaMensual = new int[TOTAL_MESES];
        int[] clientesEnMoraMensual = new int[TOTAL_MESES];

        int totalLocales = 0;
        int totalTiendas = 0;
        double sumaConsumoBase = 0.0;
        double sumaTarifas = 0.0;
        int clientesConPagoBajo = 0;

        // ------------------------------------------------------------
        // 1. GENERACION DEL PADRON DE CLIENTES SIMULADOS
        // ------------------------------------------------------------
        for (int i = 0; i < TOTAL_CLIENTES; i++) {
            idCliente[i] = 100001 + i;

            if (i % 3 == 0) {
                tipoCliente[i] = "TIENDA";
                nombreCliente[i] = "TIENDA COMERCIAL " + (i + 1);
                sectorCliente[i] = "VENTA MINORISTA";
                consumoBase[i] = 160 + random.nextInt(641);
                tarifaCliente[i] = TARIFA_TIENDA;
                totalTiendas++;
            } else {
                tipoCliente[i] = "LOCAL";
                nombreCliente[i] = "LOCAL COMERCIAL " + (i + 1);
                sectorCliente[i] = "SERVICIOS Y COMERCIO";
                consumoBase[i] = 280 + random.nextInt(1121);
                tarifaCliente[i] = TARIFA_LOCAL;
                totalLocales++;
            }

            // Un valor fijo por cliente para simular su comportamiento de pago.
            // Los valores son aleatorios, pero reproducibles con la semilla definida.
            propensionPago[i] = 0.72 + (random.nextInt(280) / 1000.0);

            if (propensionPago[i] < 0.84) {
                clientesConPagoBajo++;
            }

            sumaConsumoBase += consumoBase[i];
            sumaTarifas += tarifaCliente[i];
        }

        // ------------------------------------------------------------
        // 2. SIMULACION FINANCIERA PARA DOCE MESES
        // ------------------------------------------------------------
        for (int mes = 0; mes < TOTAL_MESES; mes++) {
            double factorEstacional = 0.94 + (mes % 4) * 0.025;
            double ajusteEstacional = 1.0;

            if (mes == 0 || mes == 11) {
                ajusteEstacional = 1.07;
            } else if (mes == 5 || mes == 6) {
                ajusteEstacional = 0.96;
            }

            for (int i = 0; i < TOTAL_CLIENTES; i++) {
                double variacionConsumo = 0.90 + ((i * 7 + mes * 13) % 21) / 100.0;
                double consumoMes = consumoBase[i] * factorEstacional
                        * ajusteEstacional * variacionConsumo;

                // Se trabaja con kWh fraccionarios para simplificar la simulacion.
                double factura = consumoMes * tarifaCliente[i] + CARGO_FIJO;
                double costoEnergia = consumoMes * COSTO_ENERGIA_POR_KWH;

                double variacionPago = ((i * 11 + mes * 17) % 16) / 100.0;
                double proporcionRecaudada = propensionPago[i] + variacionPago;
                if (proporcionRecaudada > 1.0) {
                    proporcionRecaudada = 1.0;
                }
                if (proporcionRecaudada < 0.0) {
                    proporcionRecaudada = 0.0;
                }

                double recaudo = factura * proporcionRecaudada;
                double cartera = factura - recaudo;

                facturacionMensual[mes] += factura;
                recaudoMensual[mes] += recaudo;
                costoEnergiaMensual[mes] += costoEnergia;
                carteraMensual[mes] += cartera;
                kwhMensual[mes] += consumoMes;

                // Se simula un costo operativo fijo por cliente y un componente variable.
                costoOperacionMensual[mes] += 18500.0 + (factura * 0.035);

                if (proporcionRecaudada >= 0.95) {
                    clientesAlDiaMensual[mes]++;
                } else {
                    clientesEnMoraMensual[mes]++;
                }
            }

            // La utilidad estimada usa caja recaudada menos costos simulados.
            utilidadMensual[mes] = recaudoMensual[mes]
                    - costoEnergiaMensual[mes] - costoOperacionMensual[mes];
        }

        // ------------------------------------------------------------
        // 3. RESUMEN ANUAL SIMULADO
        // ------------------------------------------------------------
        double facturacionAnual = 0.0;
        double recaudoAnual = 0.0;
        double costosEnergiaAnual = 0.0;
        double costosOperacionAnual = 0.0;
        double carteraAnual = 0.0;
        double utilidadAnual = 0.0;
        double consumoAnual = 0.0;
        double mejorUtilidad = -Double.MAX_VALUE;
        double peorUtilidad = Double.MAX_VALUE;
        int mesMejorUtilidad = 0;
        int mesPeorUtilidad = 0;
        int mesesConUtilidadPositiva = 0;

        for (int mes = 0; mes < TOTAL_MESES; mes++) {
            facturacionAnual += facturacionMensual[mes];
            recaudoAnual += recaudoMensual[mes];
            costosEnergiaAnual += costoEnergiaMensual[mes];
            costosOperacionAnual += costoOperacionMensual[mes];
            carteraAnual += carteraMensual[mes];
            utilidadAnual += utilidadMensual[mes];
            consumoAnual += kwhMensual[mes];

            if (utilidadMensual[mes] > mejorUtilidad) {
                mejorUtilidad = utilidadMensual[mes];
                mesMejorUtilidad = mes;
            }
            if (utilidadMensual[mes] < peorUtilidad) {
                peorUtilidad = utilidadMensual[mes];
                mesPeorUtilidad = mes;
            }
            if (utilidadMensual[mes] > 0) {
                mesesConUtilidadPositiva++;
            }
        }

        double margenCajaAnual = 0.0;
        if (recaudoAnual > 0) {
            margenCajaAnual = (utilidadAnual / recaudoAnual) * 100.0;
        }

        // ------------------------------------------------------------
        // 4. INTERFAZ DE CONSOLA TIPO HOJA DE CALCULO
        // ------------------------------------------------------------
        boolean sistemaActivo = true;
        int opcion = -1;
        int paginaActual = 0;

        System.out.println("+=========================================================================+");
        System.out.println("|                     EDEQ FINANZAS - CONSOLA EJECUTIVA                  |");
        System.out.println("|                SIMULADOR EDUCATIVO CON DATOS SINTETICOS                 |");
        System.out.println("+=========================================================================+");
        System.out.println("NOTA: NO SON CIFRAS OFICIALES DE EDEQ. CLIENTES, TARIFAS, COSTOS E INGRESOS");
        System.out.println("      SON FICTICIOS Y SOLO SIRVEN PARA PRACTICAR LOGICA DE PROGRAMACION.\n");
        System.out.println("Padron generado: " + TOTAL_CLIENTES + " clientes simulados.");
        System.out.println("Locales: " + totalLocales + " | Tiendas: " + totalTiendas);
        System.out.println("Periodo simulado: enero a diciembre. Moneda: pesos colombianos (COP).\n");

        do {
            System.out.println();
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("| MENU PRINCIPAL - EDEQ FINANZAS                                          |");
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("|  1. Tablero ejecutivo / KPIs anuales                                    |");
            System.out.println("|  2. Estado financiero mensual                                          |");
            System.out.println("|  3. Libro de clientes (vista paginada tipo Excel)                       |");
            System.out.println("|  4. Buscar cliente por ID                                               |");
            System.out.println("|  5. Analisis por categoria: locales y tiendas                           |");
            System.out.println("|  6. Ranking de 10 clientes por facturacion                              |");
            System.out.println("|  7. Cartera pendiente y comportamiento de recaudo                       |");
            System.out.println("|  8. Grafico de barras de utilidad mensual                               |");
            System.out.println("|  9. Auditoria de consistencia de los datos                              |");
            System.out.println("| 10. Diccionario de indicadores y supuestos                              |");
            System.out.println("|  0. Salir                                                               |");
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1: {
                        System.out.println();
                        System.out.println("================ TABLERO EJECUTIVO ANUAL ================");
                        System.out.printf("Clientes simulados                 : %,d%n", TOTAL_CLIENTES);
                        System.out.printf("Locales comerciales                : %,d%n", totalLocales);
                        System.out.printf("Tiendas                            : %,d%n", totalTiendas);
                        System.out.printf("Consumo anual simulado             : %,.2f kWh%n", consumoAnual);
                        System.out.printf("Facturacion anual                  : $%,.0f COP%n", facturacionAnual);
                        System.out.printf("Recaudo estimado                   : $%,.0f COP%n", recaudoAnual);
                        System.out.printf("Costo estimado de energia          : $%,.0f COP%n", costosEnergiaAnual);
                        System.out.printf("Costos operativos estimados        : $%,.0f COP%n", costosOperacionAnual);
                        System.out.printf("Cartera pendiente simulada         : $%,.0f COP%n", carteraAnual);
                        System.out.printf("Utilidad operativa estimada*       : $%,.0f COP%n", utilidadAnual);
                        System.out.printf("Margen sobre recaudo               : %.2f%%%n", margenCajaAnual);
                        System.out.printf("Promedio facturado por mes         : $%,.0f COP%n", facturacionAnual / TOTAL_MESES);
                        System.out.printf("Promedio de recaudo por mes        : $%,.0f COP%n", recaudoAnual / TOTAL_MESES);
                        System.out.printf("Mejor mes por utilidad             : %s ($%,.0f)%n", nombresMeses[mesMejorUtilidad], mejorUtilidad);
                        System.out.printf("Mes de menor utilidad              : %s ($%,.0f)%n", nombresMeses[mesPeorUtilidad], peorUtilidad);
                        System.out.printf("Meses con utilidad positiva        : %d de %d%n", mesesConUtilidadPositiva, TOTAL_MESES);
                        System.out.println("---------------------------------------------------------");
                        System.out.println("*Estimacion didactica: recaudo menos costo de energia y costos operativos.");
                        System.out.println("No equivale a utilidad neta contable ni a resultados oficiales de EDEQ.");
                        break;
                    }

                    case 2: {
                        System.out.println();
                        System.out.println("================ ESTADO FINANCIERO MENSUAL ================");
                        System.out.printf("%-12s %15s %15s %15s %15s%n", "MES", "FACTURACION", "RECAUDO", "COSTOS", "UTILIDAD EST.");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        for (int mes = 0; mes < TOTAL_MESES; mes++) {
                            double costosMes = costoEnergiaMensual[mes] + costoOperacionMensual[mes];
                            System.out.printf("%-12s %,15.0f %,15.0f %,15.0f %,15.0f%n",
                                    nombresMeses[mes], facturacionMensual[mes], recaudoMensual[mes], costosMes, utilidadMensual[mes]);
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("%-12s %,15.0f %,15.0f %,15.0f %,15.0f%n",
                                "TOTAL ANUAL", facturacionAnual, recaudoAnual,
                                costosEnergiaAnual + costosOperacionAnual, utilidadAnual);
                        System.out.println("Montos en COP. Cifras generadas por el simulador; no son datos reales de EDEQ.");
                        break;
                    }

                    case 3: {
                        boolean libroActivo = true;
                        paginaActual = 0;

                        do {
                            int inicio = paginaActual * FILAS_POR_PAGINA;
                            int fin = inicio + FILAS_POR_PAGINA;
                            if (fin > TOTAL_CLIENTES) {
                                fin = TOTAL_CLIENTES;
                            }

                            System.out.println();
                            System.out.println("================ LIBRO DE CLIENTES ================");
                            System.out.printf("Pagina %d de %d | Registros %d-%d de %d%n",
                                    paginaActual + 1,
                                    (TOTAL_CLIENTES + FILAS_POR_PAGINA - 1) / FILAS_POR_PAGINA,
                                    inicio + 1, fin, TOTAL_CLIENTES);
                            System.out.printf("%-10s %-27s %-10s %12s %12s %12s%n",
                                    "ID", "CLIENTE", "TIPO", "KWH BASE", "TARIFA", "PAGO %");
                            System.out.println("--------------------------------------------------------------------------------------");

                            for (int i = inicio; i < fin; i++) {
                                System.out.printf("%-10d %-27s %-10s %,12.1f %,12.0f %11.1f%%%n",
                                        idCliente[i], nombreCliente[i], tipoCliente[i],
                                        consumoBase[i], tarifaCliente[i], propensionPago[i] * 100.0);
                            }
                            System.out.println("--------------------------------------------------------------------------------------");
                            System.out.println("N. Siguiente pagina | A. Pagina anterior | 0. Volver al menu");
                            System.out.print("Accion: ");
                            String accion = scanner.nextLine().trim().toUpperCase();

                            if (accion.equals("N")) {
                                if ((paginaActual + 1) * FILAS_POR_PAGINA < TOTAL_CLIENTES) {
                                    paginaActual++;
                                } else {
                                    System.out.println("Ya estas en la ultima pagina.");
                                }
                            } else if (accion.equals("A")) {
                                if (paginaActual > 0) {
                                    paginaActual--;
                                } else {
                                    System.out.println("Ya estas en la primera pagina.");
                                }
                            } else if (accion.equals("0")) {
                                libroActivo = false;
                            } else {
                                System.out.println("Accion no reconocida. Usa N, A o 0.");
                            }
                        } while (libroActivo);
                        break;
                    }

                    case 4: {
                        System.out.println();
                        System.out.println("================ BUSQUEDA DE CLIENTE ================");
                        System.out.print("Ingrese el ID del cliente (100001 a " + (100000 + TOTAL_CLIENTES) + "): ");

                        if (scanner.hasNextInt()) {
                            int idBuscado = scanner.nextInt();
                            scanner.nextLine();
                            boolean encontrado = false;

                            for (int i = 0; i < TOTAL_CLIENTES; i++) {
                                if (idCliente[i] == idBuscado) {
                                    encontrado = true;
                                    System.out.println("----------------------------------------------------");
                                    System.out.println("ID de cliente       : " + idCliente[i]);
                                    System.out.println("Nombre              : " + nombreCliente[i]);
                                    System.out.println("Categoria           : " + tipoCliente[i]);
                                    System.out.println("Sector              : " + sectorCliente[i]);
                                    System.out.printf("Consumo base        : %,.2f kWh/mes%n", consumoBase[i]);
                                    System.out.printf("Tarifa simulada     : $%,.0f COP/kWh%n", tarifaCliente[i]);
                                    System.out.printf("Cargo fijo simulado : $%,.0f COP/mes%n", CARGO_FIJO);
                                    System.out.printf("Pago historico base : %.1f%%%n", propensionPago[i] * 100.0);
                                    System.out.println("----------------------------------------------------");

                                    double facturaPromedio = consumoBase[i] * tarifaCliente[i] + CARGO_FIJO;
                                    double recaudoPromedio = facturaPromedio * propensionPago[i];
                                    System.out.printf("Factura mensual estimada: $%,.0f COP%n", facturaPromedio);
                                    System.out.printf("Recaudo estimado       : $%,.0f COP%n", recaudoPromedio);
                                    System.out.printf("Saldo pendiente estim. : $%,.0f COP%n", facturaPromedio - recaudoPromedio);
                                    break;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("No existe ese ID en el padron simulado.");
                            }
                        } else {
                            System.out.println("El ID debe ser un numero entero.");
                            scanner.nextLine();
                        }
                        break;
                    }

                    case 5: {
                        double facturacionLocales = 0.0;
                        double facturacionTiendas = 0.0;
                        double recaudoLocales = 0.0;
                        double recaudoTiendas = 0.0;
                        double kwhLocales = 0.0;
                        double kwhTiendas = 0.0;
                        double carteraLocales = 0.0;
                        double carteraTiendas = 0.0;
                        int contadorLocales = 0;
                        int contadorTiendas = 0;
                        int pagoBajoLocales = 0;
                        int pagoBajoTiendas = 0;

                        for (int i = 0; i < TOTAL_CLIENTES; i++) {
                            double facturaAnualCliente = 0.0;
                            double recaudoAnualCliente = 0.0;
                            double kwhAnualCliente = 0.0;

                            for (int mes = 0; mes < TOTAL_MESES; mes++) {
                                double factor = 0.94 + (mes % 4) * 0.025;
                                double ajuste = 1.0;
                                if (mes == 0 || mes == 11) {
                                    ajuste = 1.07;
                                } else if (mes == 5 || mes == 6) {
                                    ajuste = 0.96;
                                }
                                double variacion = 0.90 + ((i * 7 + mes * 13) % 21) / 100.0;
                                double kwh = consumoBase[i] * factor * ajuste * variacion;
                                double factura = kwh * tarifaCliente[i] + CARGO_FIJO;
                                double varPago = ((i * 11 + mes * 17) % 16) / 100.0;
                                double pctPago = propensionPago[i] + varPago;
                                if (pctPago > 1.0) {
                                    pctPago = 1.0;
                                }
                                facturaAnualCliente += factura;
                                recaudoAnualCliente += factura * pctPago;
                                kwhAnualCliente += kwh;
                            }

                            if (tipoCliente[i].equals("LOCAL")) {
                                contadorLocales++;
                                facturacionLocales += facturaAnualCliente;
                                recaudoLocales += recaudoAnualCliente;
                                kwhLocales += kwhAnualCliente;
                                carteraLocales += facturaAnualCliente - recaudoAnualCliente;
                                if (propensionPago[i] < 0.84) {
                                    pagoBajoLocales++;
                                }
                            } else {
                                contadorTiendas++;
                                facturacionTiendas += facturaAnualCliente;
                                recaudoTiendas += recaudoAnualCliente;
                                kwhTiendas += kwhAnualCliente;
                                carteraTiendas += facturaAnualCliente - recaudoAnualCliente;
                                if (propensionPago[i] < 0.84) {
                                    pagoBajoTiendas++;
                                }
                            }
                        }

                        System.out.println();
                        System.out.println("================ ANALISIS POR CATEGORIA ================");
                        System.out.printf("%-14s %10s %18s %18s %18s %12s%n",
                                "CATEGORIA", "CLIENTES", "FACTURACION ANUAL", "RECAUDO ANUAL", "CARTERA", "KWH ANUAL");
                        System.out.println("---------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-14s %,10d $%,17.0f $%,17.0f $%,17.0f %,12.0f%n",
                                "LOCALES", contadorLocales, facturacionLocales, recaudoLocales,
                                carteraLocales, kwhLocales);
                        System.out.printf("%-14s %,10d $%,17.0f $%,17.0f $%,17.0f %,12.0f%n",
                                "TIENDAS", contadorTiendas, facturacionTiendas, recaudoTiendas,
                                carteraTiendas, kwhTiendas);
                        System.out.println("---------------------------------------------------------------------------------------------------------------");
                        System.out.printf("Participacion locales en facturacion: %.2f%%%n",
                                facturacionLocales / facturacionAnual * 100.0);
                        System.out.printf("Participacion tiendas en facturacion: %.2f%%%n",
                                facturacionTiendas / facturacionAnual * 100.0);
                        System.out.printf("Clientes con propension de pago baja - locales: %d%n", pagoBajoLocales);
                        System.out.printf("Clientes con propension de pago baja - tiendas: %d%n", pagoBajoTiendas);
                        System.out.println("Los datos por categoria se recalculan desde el padron simulado.");
                        break;
                    }

                    case 6: {
                        int[] mejoresIndices = new int[10];
                        double[] mejoresFacturas = new double[10];

                        for (int j = 0; j < 10; j++) {
                            mejoresIndices[j] = -1;
                            mejoresFacturas[j] = -1.0;
                        }

                        for (int i = 0; i < TOTAL_CLIENTES; i++) {
                            double facturaAnualCliente = 0.0;

                            for (int mes = 0; mes < TOTAL_MESES; mes++) {
                                double factor = 0.94 + (mes % 4) * 0.025;
                                double ajuste = 1.0;
                                if (mes == 0 || mes == 11) {
                                    ajuste = 1.07;
                                } else if (mes == 5 || mes == 6) {
                                    ajuste = 0.96;
                                }
                                double variacion = 0.90 + ((i * 7 + mes * 13) % 21) / 100.0;
                                double kwh = consumoBase[i] * factor * ajuste * variacion;
                                facturaAnualCliente += kwh * tarifaCliente[i] + CARGO_FIJO;
                            }

                            for (int posicion = 0; posicion < 10; posicion++) {
                                if (facturaAnualCliente > mejoresFacturas[posicion]) {
                                    for (int mover = 9; mover > posicion; mover--) {
                                        mejoresFacturas[mover] = mejoresFacturas[mover - 1];
                                        mejoresIndices[mover] = mejoresIndices[mover - 1];
                                    }
                                    mejoresFacturas[posicion] = facturaAnualCliente;
                                    mejoresIndices[posicion] = i;
                                    break;
                                }
                            }
                        }

                        System.out.println();
                        System.out.println("================ TOP 10 POR FACTURACION ANUAL ================");
                        System.out.printf("%-6s %-10s %-27s %-10s %20s%n",
                                "PUESTO", "ID", "CLIENTE", "TIPO", "FACTURACION EST.");
                        System.out.println("--------------------------------------------------------------------------------");
                        for (int j = 0; j < 10; j++) {
                            int indice = mejoresIndices[j];
                            if (indice >= 0) {
                                System.out.printf("%-6d %-10d %-27s %-10s $%,18.0f%n",
                                        j + 1, idCliente[indice], nombreCliente[indice],
                                        tipoCliente[indice], mejoresFacturas[j]);
                            }
                        }
                        System.out.println("Ordenado por facturacion anual simulada; no representa clientes reales.");
                        break;
                    }

                    case 7: {
                        System.out.println();
                        System.out.println("================ CARTERA Y RECAUDO ================");
                        System.out.printf("Facturacion anual simulada : $%,.0f COP%n", facturacionAnual);
                        System.out.printf("Recaudo anual simulado     : $%,.0f COP%n", recaudoAnual);
                        System.out.printf("Cartera pendiente          : $%,.0f COP%n", carteraAnual);
                        System.out.printf("Indice de recaudo          : %.2f%%%n", recaudoAnual / facturacionAnual * 100.0);
                        System.out.printf("Cartera / facturacion      : %.2f%%%n", carteraAnual / facturacionAnual * 100.0);
                        System.out.printf("Clientes con pago base bajo (<84%%): %d de %d%n", clientesConPagoBajo, TOTAL_CLIENTES);
                        System.out.println();
                        System.out.printf("%-12s %18s %18s %16s %16s%n",
                                "MES", "FACTURACION", "RECAUDO", "CARTERA", "CLIENTES EN MORA");
                        System.out.println("-------------------------------------------------------------------------------------");
                        for (int mes = 0; mes < TOTAL_MESES; mes++) {
                            System.out.printf("%-12s $%,17.0f $%,17.0f $%,15.0f %,16d%n",
                                    nombresMeses[mes], facturacionMensual[mes], recaudoMensual[mes],
                                    carteraMensual[mes], clientesEnMoraMensual[mes]);
                        }
                        System.out.println("Nota: 'mora' es una regla inventada para este ejercicio, no una clasificacion oficial.");
                        break;
                    }

                    case 8: {
                        System.out.println();
                        System.out.println("================ GRAFICO DE UTILIDAD MENSUAL ================");
                        System.out.println("Cada # representa aproximadamente una fraccion de la utilidad del mes.");

                        double maxUtilidad = 0.0;
                        for (int mes = 0; mes < TOTAL_MESES; mes++) {
                            if (utilidadMensual[mes] > maxUtilidad) {
                                maxUtilidad = utilidadMensual[mes];
                            }
                        }

                        for (int mes = 0; mes < TOTAL_MESES; mes++) {
                            int cantidadBarras = 0;
                            if (maxUtilidad > 0) {
                                cantidadBarras = (int) ((utilidadMensual[mes] / maxUtilidad) * 40);
                            }
                            System.out.printf("%-12s | ", nombresMeses[mes]);
                            for (int barra = 0; barra < cantidadBarras; barra++) {
                                System.out.print("#");
                            }
                            System.out.printf(" $%,.0f%n", utilidadMensual[mes]);
                        }
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Utilidad acumulada anual: $" + String.format("%,.0f", utilidadAnual) + " COP");
                        break;
                    }

                    case 9: {
                        int erroresAuditoria = 0;
                        int idsDuplicados = 0;
                        int clientesSinNombre = 0;
                        int clientesConConsumoInvalido = 0;
                        int clientesConTarifaInvalida = 0;
                        int categoriasInvalidas = 0;
                        double diferenciaFacturacion = 0.0;
                        double diferenciaCartera = 0.0;

                        for (int i = 0; i < TOTAL_CLIENTES; i++) {
                            if (idCliente[i] < 100001 || idCliente[i] > 100000 + TOTAL_CLIENTES) {
                                erroresAuditoria++;
                            }
                            if (nombreCliente[i] == null || nombreCliente[i].length() == 0) {
                                clientesSinNombre++;
                            }
                            if (consumoBase[i] <= 0) {
                                clientesConConsumoInvalido++;
                            }
                            if (tarifaCliente[i] <= 0) {
                                clientesConTarifaInvalida++;
                            }
                            if (!tipoCliente[i].equals("LOCAL") && !tipoCliente[i].equals("TIENDA")) {
                                categoriasInvalidas++;
                            }
                            for (int j = i + 1; j < TOTAL_CLIENTES; j++) {
                                if (idCliente[i] == idCliente[j]) {
                                    idsDuplicados++;
                                }
                            }
                        }

                        double sumaFacturas = 0.0;
                        double sumaRecaudos = 0.0;
                        double sumaCarteras = 0.0;
                        double sumaUtilidades = 0.0;

                        for (int mes = 0; mes < TOTAL_MESES; mes++) {
                            sumaFacturas += facturacionMensual[mes];
                            sumaRecaudos += recaudoMensual[mes];
                            sumaCarteras += carteraMensual[mes];
                            sumaUtilidades += utilidadMensual[mes];
                        }

                        diferenciaFacturacion = Math.abs(sumaFacturas - facturacionAnual);
                        diferenciaCartera = Math.abs(sumaCarteras - carteraAnual);

                        System.out.println();
                        System.out.println("================ AUDITORIA INTERNA ================");
                        System.out.println("Registros revisados                 : " + TOTAL_CLIENTES);
                        System.out.println("IDs fuera de rango                  : " + erroresAuditoria);
                        System.out.println("IDs duplicados                      : " + idsDuplicados);
                        System.out.println("Clientes sin nombre                 : " + clientesSinNombre);
                        System.out.println("Consumos invalidos                  : " + clientesConConsumoInvalido);
                        System.out.println("Tarifas invalidas                   : " + clientesConTarifaInvalida);
                        System.out.println("Categorias invalidas                : " + categoriasInvalidas);
                        System.out.printf("Diferencia facturacion mensual/anual: $%,.4f%n", diferenciaFacturacion);
                        System.out.printf("Diferencia cartera mensual/anual    : $%,.4f%n", diferenciaCartera);
                        System.out.printf("Recaudo anual comprobado            : $%,.0f%n", sumaRecaudos);
                        System.out.printf("Utilidad anual comprobada           : $%,.0f%n", sumaUtilidades);

                        if (erroresAuditoria == 0 && idsDuplicados == 0
                                && clientesSinNombre == 0
                                && clientesConConsumoInvalido == 0
                                && clientesConTarifaInvalida == 0
                                && categoriasInvalidas == 0
                                && diferenciaFacturacion < 0.01
                                && diferenciaCartera < 0.01) {
                            System.out.println("RESULTADO: no se detectaron errores en las comprobaciones programadas.");
                        } else {
                            System.out.println("RESULTADO: revisar las validaciones que presenten valores distintos de cero.");
                        }
                        System.out.println("Esta auditoria verifica la consistencia del simulador, no estados contables reales.");
                        break;
                    }

                    case 10: {
                        System.out.println();
                        System.out.println("================ DICCIONARIO Y SUPUESTOS ================");
                        System.out.println("FACTURACION : valor simulado de energia consumida mas cargo fijo.");
                        System.out.println("RECAUDO     : porcentaje de factura que el modelo supone cobrado.");
                        System.out.println("CARTERA     : facturacion menos recaudo estimado.");
                        System.out.println("COSTO ENERG.: consumo en kWh multiplicado por costo supuesto por kWh.");
                        System.out.println("COSTO OPER. : costo fijo por cliente mas 3.5% de su factura.");
                        System.out.println("UTILIDAD EST.: recaudo menos costo de energia menos costo operativo.");
                        System.out.println();
                        System.out.println("SUPUESTOS DEL MODELO");
                        System.out.printf("Tarifa local comercial: $%,.0f COP/kWh (ficticia)%n", TARIFA_LOCAL);
                        System.out.printf("Tarifa tienda         : $%,.0f COP/kWh (ficticia)%n", TARIFA_TIENDA);
                        System.out.printf("Cargo fijo             : $%,.0f COP/mes (ficticio)%n", CARGO_FIJO);
                        System.out.printf("Costo energia          : $%,.0f COP/kWh (ficticio)%n", COSTO_ENERGIA_POR_KWH);
                        System.out.println("Clientes generados con una semilla aleatoria fija para reproducir resultados.");
                        System.out.println("El ejercicio no incluye impuestos reales, deuda, depreciacion, inversiones,");
                        System.out.println("regulacion tarifaria, subsidios, contribuciones ni estados financieros oficiales.");
                        System.out.println("No usar estas cifras para tomar decisiones comerciales reales.");
                        break;
                    }

                    case 0:
                        sistemaActivo = false;
                        System.out.println();
                        System.out.println("Cerrando EDEQ FINANZAS...");
                        System.out.printf("Clientes procesados: %d%n", TOTAL_CLIENTES);
                        System.out.printf("Facturacion anual simulada: $%,.0f COP%n", facturacionAnual);
                        System.out.printf("Utilidad operativa simulada: $%,.0f COP%n", utilidadAnual);
                        System.out.println("Gracias por utilizar el simulador educativo.");
                        break;

                    default:
                        System.out.println("Opcion invalida. Seleccione un numero del 0 al 10.");
                        break;
                }

            } else {
                System.out.println("Entrada invalida: debe escribir un numero entero.");
                scanner.nextLine();
            }

        } while (sistemaActivo);

        scanner.close();
    }
}
