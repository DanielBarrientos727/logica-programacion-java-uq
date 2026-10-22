public class MercadonaDescuentos {
    public static void main(String[] args) {
        int cantidadProductos = notas.Reutilizacion.ingresarEntero("Ingrese la cantidad de productos comprados: ");
        double totalCompra = notas.Reutilizacion.ingresarRealD("Ingrese el valor total de la compra: ");
        double descuento = 0.0;
        
        if (cantidadProductos >= 5 && totalCompra > 50000) {
            descuento = totalCompra * 0.10;
        } else if (cantidadProductos >= 3 && totalCompra > 30000) {
            descuento = totalCompra * 0.05;
        }
        
        double totalFinal = totalCompra - descuento;
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Total a pagar con descuento: " + totalFinal);
    }
}