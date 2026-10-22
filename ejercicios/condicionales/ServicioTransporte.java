public class ServicioTransporte{
    public static void main (String[]args){
        int menuOpciones = notas.Reutilizacion.ingresarEntero("Ingrese el servicio de transporte 1.Bus urbano 2.Bus intermunicipal 3.Servicio especial 4.Taxi compartido: ");
        double kilometrosRecorrido = notas.Reutilizacion.ingresarRealD("Ingrese los kilometros del recorrido: ");
        double valorKilometro = calcularValorKilometro (menuOpciones);
        double valorTotal = calcularValorTotal (valorKilometro, kilometrosRecorrido);
        generarMensaje (valorKilometro, valorTotal);
    }
    public static double calcularValorKilometro (int menuOpciones){
        double valorKilometro = 0;
        switch (menuOpciones){
            case 1:
                valorKilometro = 1200;
                break;
            case 2:
                valorKilometro = 1800;
                break;
            case 3:
                valorKilometro = 2500;
                break;
            case 4:
                valorKilometro = 3000;
                break;
            default:
                System.out.println("La opción ingresada no es valida");
        }
        return valorKilometro;
    }
    public static double calcularValorTotal (double kilometrosRecorrido, double valorKilometro){
        double valorTotal = 0;
        valorTotal = kilometrosRecorrido * valorKilometro;
        return valorTotal;
    }
    public static void generarMensaje (double valorKilometro, double valorTotal){
        String generarMensaje = ("Valor por kilometro: $" + valorKilometro + ", Valor total a pagar: $" + valorTotal);
        System.out.println(generarMensaje);
    }

}