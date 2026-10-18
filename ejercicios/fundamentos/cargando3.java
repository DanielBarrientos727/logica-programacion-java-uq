public class cargando3 {

    static void esperar(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Iniciando HP ProDesk 600 G4...");
        esperar(3000);

        System.out.println("Cargando firmware UEFI...");
        esperar(2000);

        System.out.println("Cargando GRUB...");
        esperar(2000);

        System.out.println("Cargando kernel Linux...");
        esperar(3000);

        System.out.println("Iniciando systemd...");
        esperar(2000);

        System.out.println("[  OK  ] Started NetworkManager.service");
        esperar(1500);

        System.out.println("[  OK  ] Started firewalld.service");
        esperar(1500);

        System.out.println("[  OK  ] Started sddm.service");
        esperar(2000);

        System.out.println("Iniciando KDE Plasma...");
        esperar(3000);

        try {
            new ProcessBuilder("fastfetch")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (java.io.IOException e) {
            System.out.println("No se pudo ejecutar fastfetch.");
            System.out.println("Comprueba que esté instalado.");
        }
    }
}