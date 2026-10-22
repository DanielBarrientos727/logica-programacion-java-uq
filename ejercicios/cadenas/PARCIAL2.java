public class PARCIAL2 {

    public static final int META = 500000; //-->>>> CONSTANTES
    public static final double PORCENTAJE = 0.10; //-->>>> CONSTANTES

    static void main(String[] args) {


        int cantidadPedidos = Reutilizacion.ingresarEnteroMayorQue(
                "Por favor ingrese estimado usuario la cantidad de pedidos que se pudieron realizar en la correspodiente jornada: ", 0
        );

        // Paso 1: Nos toca calcular el total de las ventas


        int totalVentas = sumatoriaPrecio(cantidadPedidos);

        System.out.println("-----------------------------------------------------------");

        // Paso 2: Tenemos dizque calcular el promedio por pedido.
        double promedioVenta = promedioVentas(totalVentas);

        System.out.println("-----------------------------------------------------------");

        // Paso 3: Ya luego de esto, colocamos el cumplimiento de la meta en cuestión.
        double porcentajeMeta = verificarMeta(META, promedioVenta);

        System.out.println("-----------------------------------------------------------");

        // Paso 4: Calcular el incremento del 10 %
        double aumentoVentas = verificadorValor(INCREMENTO, totalVentas);

        System.out.println("-----------------------------------------------------------");

        // Paso 5: Ya pues nos toca verificar el resultado de la jornada del usuario
        String mensajeResultado = verificarPromedio(
                totalVentas, promedioVenta
        );

        System.out.println("-----------------------------------------------------------");

        // Paso 6: Por último mostrarmos en Konsole mostramos la mierda esa

        generarMensaje(cantidadPedidos, totalVentas, promedioVenta,porcentajeMeta, aumentoVentas, mensajeResultado);
    }


    // Sumar los precios de todos los pedidos.
    public static int sumatoriaPrecio(int cantidadPedidos) {
        int totalVentas = 0;
        int valorPedido = 0;

        for (int pedido = 1; pedido <= cantidadPedidos; pedido++) {
            valorPedido = Reutilizacion.ingresarEnteroMayorQue(
                    "Ingrese el precio de la venta " + pedido + ": ", 0
            );

            totalVentas += valorPedido;
        }

        return totalVentas;
    }
    public static double promedioVentas (double )
}
