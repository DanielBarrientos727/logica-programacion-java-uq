
public class TestVocacional {
    public static void main(String[] args) {

        // ==========================================
        // TEST VOCACIONAL: UNIVERSIDAD DEL QUINDÍO
        // ==========================================


        var carrera = 1;

        switch (carrera) {

            case 1:
                System.out.println("Ingeniería de Sistemas y Computación");
                System.out.println("Perfil: programación, algoritmos, IA y software.");
                break;

            case 2:
                System.out.println("Ingeniería Electrónica");
                System.out.println("Perfil: circuitos, hardware, robótica y sistemas embebidos.");
                break;

            case 3:
                System.out.println("Física");
                System.out.println("Perfil: matemáticas, experimentación y leyes del universo.");
                break;

            case 4:
                System.out.println("Ingeniería Civil");
                System.out.println("Perfil: estructuras, infraestructura y diseño.");
                break;

            case 5:
                System.out.println("Biología");
                System.out.println("Perfil: organismos, ecosistemas e investigación científica.");
                break;

            case 6:
                System.out.println("Medicina");
                System.out.println("Perfil: salud humana, diagnóstico e investigación médica.");
                break;

            case 7:
                System.out.println("Administración de Negocios");
                System.out.println("Perfil: empresas, estrategia y gestión de proyectos.");
                break;

            case 8:
                System.out.println("Ingeniería de Alimentos");
                System.out.println("Perfil: procesos alimentarios, calidad y tecnología.");
                break;

            default:
                System.out.println("Opción no válida. Selecciona un número del 1 al 8.");
        }
    }
}
