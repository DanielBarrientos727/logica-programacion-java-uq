public class ClasificacionNumero {
    public static void main(String[] args) {
        int numero = Reutilizacion.ingresarEntero("Ingrese un número entero: ");
        
        if (numero > 0) {
            if (numero > 100) {
                System.out.println("El número es positivo y mayor que 100.");
            } else {
                System.out.println("El número es positivo, pero no mayor que 100.");
            }
        } else if (numero < 0) {
            System.out.println("El número es negativo.");
        } else {
            System.out.println("El número es cero.");
        }
    }
}