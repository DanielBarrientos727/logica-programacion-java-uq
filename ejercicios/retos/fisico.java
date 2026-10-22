public class fisico {
    static void main(String[] args) {
        String nombre = notas.Reutilizacion.ingresarTexto("ingrese su nombre: ");
        int edad = notas.Reutilizacion.ingresarEntero("ingrese su edad: ");
        double tiempoCarrera = notas.Reutilizacion.ingresarRealD("ingrese el tiempo en segundos de la carrera de 100mts: ");
        int numAbdominales = notas.Reutilizacion.ingresarEntero("ingrese numero de abdominales hechas en un minuto: ");
        int numFlexPecho = notas.Reutilizacion.ingresarEntero("ingrese la cantidad de flexiones de pecho: ");
        double decisionCarrera = decision(tiempoCarrera);
        double decisionAbdominales = decision2(numAbdominales);
        double decisionFlexiones = decision3(numFlexPecho);
        double suma = sumaTotal(decisionCarrera, decisionAbdominales, decisionFlexiones);
        String desicionFinal = ultimaDecision(suma,edad);
        generarMensaje(nombre, edad, suma, desicionFinal);
    }
    public static double decision(double tiempoCarrera){
        double valor;
        if (tiempoCarrera <= 12){
            valor = 50;
        }else if (tiempoCarrera >=13 && tiempoCarrera <= 15){
            valor = 30;
        }else {
            valor = 10;
        }
        return valor;
    }
    public static double decision2(double numAbdominales){
        double valor;
        if (numAbdominales >= 40){
            valor = 30;
        }else if (numAbdominales >=20 && numAbdominales <= 39){
            valor = 20;
        }else {
            valor = 10;
        }
        return valor;
    }
    public static double decision3(double numFlexiones){
        double valor;
        if (numFlexiones >= 30){
            valor = 20;
        }else if (numFlexiones >=15 && numFlexiones <= 29){
            valor = 10;
        }else {
            valor = 5;
        }
        return valor;
    }
    public static double sumaTotal(double decisionCarrera, double numAbdominales, double numFlexiones) {
        double valor = decisionCarrera + numAbdominales + numFlexiones;
        return valor;
    }
    public static String ultimaDecision(double suma, int edad) {
        String mensaje;
        if (suma >=80 && edad >= 15){
            mensaje ="nivel alto";
        }else if (suma >=50 && suma <=79){
            mensaje ="nivel medio";
        }else{
            mensaje ="nivel bajo";
        }
        return mensaje;
    }
    public static void generarMensaje(String nombre, int edad, double suma, String decisionFinal){
        String mensaje = "Felicidades, " + nombre + "!!" +
                "\nLograste un puntaje total de " + suma +
                " llegando asi a un " + decisionFinal +
                " con " + edad + " aÃ±os";
        System.out.println(mensaje);
    }
}