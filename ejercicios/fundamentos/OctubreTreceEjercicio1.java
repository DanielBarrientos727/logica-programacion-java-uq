public class OctubreTreceEjercicio1 {
    public static final double INTERESES = 0.10;
    public static final double DEPOSITOMINIMO = 1.0;

    public static void main(String[] args) {
        double cantidadInicial = Reutilizacion.ingresarRealMayorQue(
                "Bienvenid@, te voy a ayudar a calcular tus ahorros" +
                        "\nNecesito saber cuanto dinero ingresaste: ",
                DEPOSITOMINIMO
        );

        double metaAhorro = Reutilizacion.ingresarRealMayorQue(
                "Cual es tu meta de ahorro teniendo en cuenta el dinero ingresado: ",
                cantidadInicial
        );

        int mesesAhorro = calcularMesesAhorro(cantidadInicial, metaAhorro, INTERESES);
        generarMensaje(mesesAhorro);
    }

    public static int calcularMesesAhorro(double cantidadInicial, double metaAhorro, double INTERESES) {
        int meses = 1;
        double calculoIntereses;

        while (cantidadInicial <= metaAhorro) {
            calculoIntereses = cantidadInicial * INTERESES;
            cantidadInicial = cantidadInicial + calculoIntereses;
            meses = meses + 1;
        }
        return meses;
    }

    public static void generarMensaje(int mesesAhorro) {
        String mensaje = "La cantidad de meses para llegar a su meta establecida es de: " + mesesAhorro;
        System.out.println(mensaje);
    }
}