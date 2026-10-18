public static int calcularDias(double limite) {
    double suma = 0;
    int dias = 0;

    for (int dia = 1; suma < limite; dia++) {
        suma = suma + (dia * dia);
        dias++;
    }

    return dias;
}

void main() {
    System.out.println(calcularDias(30));
}