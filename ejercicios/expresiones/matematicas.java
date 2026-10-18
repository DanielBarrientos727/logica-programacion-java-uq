public class matematicas {
    static void main(String[] args) {
        int numero = Reutilizacion.ingresarEntero("Por favor ingresar el numero:");
        String desicion = calcularNum(numero);
        generarMensaje(desicion);
    }
    public static String calcularNum(int numero){
        String num = "";
        if (numero > 0 && numero > 100) {
            num = " positivo y mayor a 100";
        } else if (numero > 0 && numero < 100) {
            num = " positivo y no es mayor que 100";
        } else if (numero < 0) {
            num = " negativo";
        }else {
            num = " igual a 0";
        }
        return num;
    }
    public static void generarMensaje(String desicion){
        String mensaje = "Querido estudiente el numero es:" + desicion;
        System.out.println(mensaje);
    }
}