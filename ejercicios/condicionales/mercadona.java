public class mercadona {
    static void main(String[] args) {
        double producto = notas.Reutilizacion.ingresarRealD("Cliente, por favor ingresar la cantidad de productos comprados: ");
        double valorCompra = notas.Reutilizacion.ingresarRealD("Cliente, por favor ingresar el valor total de su compra: ");
        double valorDescuento = calcularDescuento (producto, valorCompra);
        generarMensaje(valorDescuento);
    }
    public static double calcularDescuento(double producto, double valorCompra){
        double valorfinal = 0.0;
        if (producto >= 5 && valorCompra > 50000){
            valorfinal = valorCompra - (valorCompra * 0.10);
        } else if (producto >= 3 && valorCompra > 30000) {
            valorfinal = valorCompra - (valorCompra * 0.05);
        }else {
            valorfinal = valorCompra;
        }
        return valorfinal;
    }
    public static void generarMensaje(double valorDescuento) {
        String mensaje = "Querido cliente, el valor final de su factura es: " + valorDescuento;
        System.out.println(mensaje);
    }
}