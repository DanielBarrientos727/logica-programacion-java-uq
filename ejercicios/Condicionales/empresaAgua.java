public class empresaAgua {
    static void main(String[] args) {
        double consumo = Reutilizacion.ingresarRealD("Por favor, ingrese el consumo mensual de agua en metros cubicos:");
        double valor = Reutilizacion.ingresarRealD("Por favor, ingrese cuanto vale el metro cubico de agua:");
        double valorFactura = sumaTotal(consumo, valor);
        double valorFinal = desicion(consumo, valorFactura);
        generarMensaje(valorFactura, valorFinal);
    }
    public static double sumaTotal(double consumo, double valor) {
        double suma = valor * consumo;
        return suma;
    }

    public static double desicion(double consumo, double valorFactura) {
        double valor = 0.0;
        if (consumo >= 1 && consumo <= 9) {
            valor = valorFactura + (valorFactura * 0.15);
        } else if (consumo >= 13 && consumo <= 15) {
            valor = valorFactura + (valorFactura * 0.15);
        } else if (consumo >= 20 && consumo <= 28) {
            valor = valorFactura + (valorFactura * 0.25);
        } else {
            valor = valorFactura;
        }
        return valor;
    }

    public static void generarMensaje(double valorFactura, double valorFinal) {
        String mensaje = "querido usuario, el valor de su factura inicialmente era: " + valorFactura +
                "\nSin embargo, debido a su consumo su nuevo valor a pagar es: " + valorFinal;
        System.out.println(mensaje);

    }
}