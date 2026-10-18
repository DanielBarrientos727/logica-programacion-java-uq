
public class cargando4 {

    static void esperar(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    static void escribir(String texto, long pausa)
            throws InterruptedException {
        System.out.println(texto);
        esperar(pausa);
    }

    public static void main(String[] args)
            throws InterruptedException {

        // Simulación del arranque
        escribir("HP ProDesk 600 G4 SFF", 4000);
        escribir("Iniciando firmware UEFI...", 2000);
        escribir("Cargando GRUB...", 2000);
        escribir("Cargando kernel Linux...", 3000);
        escribir("Inicializando systemd...", 2000);

        String[] servicios = {
                "[  OK  ] Started systemd-journald.service",
                "[  OK  ] Started systemd-udevd.service",
                "[  OK  ] Reached target Local File Systems",
                "[  OK  ] Started NetworkManager.service",
                "[  OK  ] Started firewalld.service",
                "[  OK  ] Started dbus-broker.service",
                "[  OK  ] Started systemd-logind.service",
                "[  OK  ] Started sddm.service",
                "[  OK  ] Reached target Graphical Interface"
        };

        for (String servicio : servicios) {
            escribir(servicio, 1200);
        }

        escribir("Iniciando KDE Plasma 6.7.5...", 2000);
        escribir("Iniciando sesión: Orisono", 2000);

        // Limpiar pantalla de la terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Fastfetch simulado
        System.out.println("""
        Orisono@orisono:~$ fastfetch

                     .',;::::;,'.                 Orisono@orisono
                 .';:cccccccccccc:;,.             ---------------
               .;cccccccccccccccccccccc;.         OS: Fedora Linux 44 (KDE Plasma Desktop Edition) x86_64
             .:cccccccccccccccccccccccccc:.       Host: HP ProDesk 600 G4 SFF
           .;ccccccccccccc;.:dddl:.;ccccccc;.     Kernel: Linux 7.2.10-200.fc44.x86_64
          .:ccccccccccccc;OWMKOOXMWd;ccccccc:.    Uptime: 8 hours, 39 mins
          .:ccccccccccccc;KMMc;cc;xMMc;ccccccc:.  Packages: 26 (flatpak-system), 1 (flatpak-user), 2791 (rpm)
        ,cccccccccccccc;MMM.;cc;;WW:;cccccccc,    Shell: bash 5.3.9
        :cccccccccccccc;MMM.;cccccccccccccccc:    Display (HP E233): 1920x1080 in 23", 60 Hz
        :ccccccc;oxOOOo;MMM000k.;cccccccccccc:    Desktop Environment: KDE Plasma 6.7.5
        cccccc;0MMKxdd:;MMMkddc.;cccccccccccc;    Window Manager: KWin (Wayland)
        ccccc;XMO';cccc;MMM.;cccccccccccccccc'    WM Theme: Breeze
        ccccc;MMo;ccccc;MMW.;ccccccccccccccc;     Theme: Breeze (Dark)
        ccccc;0MNc.ccc.xMMd;ccccccccccccccc;     Icons: breeze-dark
        cccccc;dNMWXXXWM0:;cccccccccccccc:,       Font: Noto Sans (10pt)
        cccccccc;.:odl:.;cccccccccccccc:,.         Cursor: breeze (24px)
        ccccccccccccccccccccccccccccc:'.           Terminal: konsole 26.8.1
        :ccccccccccccccccccccccc:;,..               CPU: Intel Core i5-8500 (6) @ 4.10 GHz
         ':cccccccccccccccc::;,.                    GPU: Intel UHD Graphics 630
                                                      Memory: 6.97 GiB / 7.53 GiB (93%)
                                                      Swap: 3.47 GiB / 7.53 GiB (46%)
                                                      Disk (/): 67.78 GiB / 116.66 GiB (58%) - btrfs
                                                      Local IP (eno1): 192.168.20.60/24
                                                      Locale: es_ES.UTF-8

        Orisono@orisono:~$
        """);
    }
}
