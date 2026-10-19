
public class EjercicioFor {

    public static void main(String[] args) throws InterruptedException {

        String[] inicio = {
                "[POWER] Encendiendo el equipo...",
                "[UEFI] Inicializando firmware y hardware...",
                "[UEFI] Comprobando memoria RAM y dispositivos...",
                "[UEFI] Buscando dispositivo de arranque...",
                "[GRUB] Cargando el gestor de arranque...",
                "[GRUB] Seleccionando Fedora Linux...",
                "[KERNEL] Cargando el kernel de Linux...",
                "[KERNEL] Inicializando procesadores y memoria...",
                "[KERNEL] Detectando dispositivos y controladores...",
                "[KERNEL] Montando el sistema de archivos inicial...",
                "[INITRAMFS] Preparando el sistema para arrancar...",
                "[SYSTEMD] Iniciando el sistema de servicios...",
                "[SYSTEMD] Montando sistemas de archivos...",
                "[SYSTEMD] Iniciando servicios del sistema...",
                "[SYSTEMD] Configurando la red...",
                "[DRM] Inicializando el sistema gráfico...",
                "[SDDM] Iniciando el gestor de inicio de sesión...",
                "[PLASMA] Cargando KDE Plasma...",
                "[KDE] Iniciando panel, escritorio y servicios...",
                "[FEDORA] ¡Escritorio listo!"
        };

        String[] apagado = {
                "[SESSION] Cerrando la sesión del usuario...",
                "[PLASMA] Cerrando el entorno gráfico...",
                "[SYSTEMD] Deteniendo servicios del usuario...",
                "[SYSTEMD] Cerrando servicios del sistema...",
                "[NETWORK] Desactivando conexiones de red...",
                "[FILESYSTEM] Sincronizando datos pendientes...",
                "[FILESYSTEM] Desmontando sistemas de archivos...",
                "[KERNEL] Finalizando procesos restantes...",
                "[KERNEL] Apagando los procesadores...",
                "[POWER] El equipo se está apagando..."
        };

        System.out.println("========================================");
        System.out.println("       FEDORA LINUX - BOOT SEQUENCE");
        System.out.println("========================================");
        System.out.println();

        // Simular el inicio durante aproximadamente 20 segundos.
        for (String mensaje : inicio) {
            System.out.println(mensaje);
            Thread.sleep(1000);
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("     SISTEMA OPERATIVO EN EJECUCION");
        System.out.println("========================================");

// Simular el uso normal del escritorio durante 3 segundos.
        for (int i = 3; i > 0; i--) {
            System.out.print("\r[FEDORA] Apagando en " + i + "...   ");
            Thread.sleep(1000);
        }

        System.out.println();

        System.out.println();
        System.out.println("========================================");
        System.out.println("          APAGANDO FEDORA");
        System.out.println("========================================");

        // Simular el apagado durante aproximadamente 10 segundos.
        for (String mensaje : apagado) {
            System.out.println(mensaje);
            Thread.sleep(1000);
        }

        System.out.println();
        System.out.println("[POWER] Simulación finalizada.");
    }
}
