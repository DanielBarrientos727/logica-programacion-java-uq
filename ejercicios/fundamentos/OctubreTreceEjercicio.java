public class OctubreTreceEjercicio {
    public static final double INTERESES = 0.10;
    public static final double DEPOSITOMINIMO = 1.0;
    public static void main(String[] args) {
        System.out.println("Bienvenid@, te voy a ayudar a calcular tus ahorros");
        double cantidadInicial = notas.Reutilizacion.ingresarRealMayorQue("Necesito saber cuanto dinero ingresaste: ", DEPOSITOMINIMO);
        double metaAhorro = notas.Reutilizacion.ingresarRealMayorQue("Cual es tu meta de ahorro teniendo en cuenta el dinero ingresado: ", cantidadInicial);
        int mesesAhorro = calcularMesesAhorro (cantidadInicial, metaAhorro, INTERESES, DEPOSITOMINIMO);
        generarMensaje (mesesAhorro);
    }
    public static int calcularMesesAhorro(double cantidadInicial, double metaAhorro, double INTERESES, double DEPOSITOMINIMO){
        int meses = 1;
        double calculoIntereses;
        while (cantidadInicial < metaAhorro){
            calculoIntereses = cantidadInicial * INTERESES;
            cantidadInicial = cantidadInicial + calculoIntereses;
            meses = meses + 1;
        }
        return meses;
    }
    public static void generarMensaje (int mesesAhorro){
        System.out.println("La cantidad de meses para llegar a su meta establecida es de: " + mesesAhorro);
    }
}