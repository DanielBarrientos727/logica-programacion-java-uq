public class clima {
    static void main(String[] args) {
        double temperatura = notas.Reutilizacion.ingresarRealD("Por favor ingrese la temperatura actual en Grados Celcius ");
        String estadoCielo = notas.Reutilizacion.ingresarTexto("Por favor ingresar el estado del cielo: (soleado, nublado, lluvioso) ");
        String condicion = desicion(temperatura, estadoCielo);
        generarMensaje(condicion);
    }
    public static String desicion(double temperatura, String estadoCileo) {
        String mensaje = "";
        if (temperatura > 30 && estadoCileo.equalsIgnoreCase("soleado")) {
            mensaje = " caluroso y soleado";
        } else if ((temperatura < 10 && estadoCileo.equalsIgnoreCase("nublado")) || (temperatura < 10 && estadoCileo.equalsIgnoreCase("lluvioso"))){
            mensaje = " frio y nublado/lluvioso";

        } else if (temperatura >= 10 && temperatura <= 30 && estadoCileo.equalsIgnoreCase("soleado")) {
            mensaje = " agradable y soleado";
        } else {
            mensaje = " clima variable";
        }
        return mensaje;
    }
    public static void generarMensaje(String condicion){
        String mensaje = "Querido usuario, el clima actual es:" + condicion;
        System.out.println(mensaje);
    }
}