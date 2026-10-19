
public class Condicionales {
    public static void main(String[] args) {

        // ==========================================
        // 1. CONDICIONALES IF, ELSE IF Y ELSE
        // ==========================================

        // Permiten tomar decisiones según se cumplan
        // o no determinadas condiciones.

        var age = 10;

        // Las condiciones se evalúan de arriba hacia abajo.
        // Cuando una condición es verdadera, se ejecuta
        // su bloque y se omiten los bloques siguientes.

        /*
         if
          |
          v
         else if
          |
          v
         else if (podemos agregar más condiciones)
          |
          v
         else (opcional)
         */

        // Para comprobar condiciones booleanas:
        // las expresiones como age == 18 devuelven true o false.

        if (age == 18) { // Primera condición.

            System.out.println(
                    "El usuario acaba de cumplir 18 años"
            );

        } else if (age > 18) { // Se evalúa si la primera es falsa.

            System.out.println(
                    "El usuario es mayor de edad"
            );

        } else { // Se ejecuta si las condiciones anteriores son falsas.

            System.out.println(
                    "El usuario es menor de edad"
            );
        }


        // ==========================================
        // 2. SWITCH: SELECCIÓN ENTRE VARIOS CASOS
        // ==========================================

        // switch compara el valor de una expresión
        // con diferentes casos (case).
        //
        // Cuando encuentra una coincidencia, ejecuta
        // las instrucciones de ese caso.
        //
        // break evita continuar ejecutando los casos siguientes.
        // default se ejecuta si ningún caso coincide.

        var pc = 8;

        switch (pc) {

            case 1:
                System.out.println("HP");
                break;

            case 2:
                System.out.println("Lenovo");
                break;

            case 3:
                System.out.println("Canaima");
                break;

            case 4:
                System.out.println("Asus");
                break;

            case 5:
                System.out.println("Dell");
                break;

            default:
                System.out.println(
                        "No es ningún computador registrado"
                );
        }
    }
}
