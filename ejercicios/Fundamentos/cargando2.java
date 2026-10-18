
public class cargando2 {

    static void esperar(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    static void cargar(String[] mensajes) throws InterruptedException {
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
            esperar(1000);
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        // 1. Firmware y pantalla HP
        System.out.println("""
                
                ========================================
                
                       _   _ ____  
                      | | | |  _ \\
                      | |_| | |_) |
                      |  _  |  __/
                      |_| |_|_|
                
                       HP PRODESK 600 G4
                
                ========================================
                
                """);

        esperar(5000);

        // 2. Firmware UEFI
        cargar(new String[]{
                "[UEFI] Inicializando hardware...",
                "[UEFI] Detectando memoria RAM...",
                "[UEFI] Detectando almacenamiento SSD...",
                "[UEFI] Hardware inicializado."
        });

        // 3. GRUB
        cargar(new String[]{
                "[GRUB] GNU GRUB iniciado.",
                "[GRUB] Cargando configuracion...",
                "[GRUB] Seleccionando Fedora Linux...",
                "[GRUB] Cargando kernel e initramfs..."
        });

        // 4. Kernel Linux
        cargar(new String[]{
                "[    0.000000] Linux kernel initializing...",
                "[    0.120000] CPU: Intel Core i5-8500",
                "[    0.250000] Memory: RAM detected",
                "[    0.410000] PCI: Enumerating devices",
                "[    0.580000] ACPI: Initializing",
                "[    0.720000] EXT4-fs: Filesystem support ready",
                "[    1.000000] Kernel initialization complete"
        });

        // 5. systemd
        cargar(new String[]{
                "[  OK  ] Started systemd-udevd.service",
                "[  OK  ] Reached target Local File Systems",
                "[  OK  ] Started dracut-initqueue.service",
                "[  OK  ] Reached target Initrd Root File System",
                "[  OK  ] Started systemd-journald.service",
                "[  OK  ] Mounted Kernel Configuration File System",
                "[  OK  ] Started NetworkManager.service",
                "[  OK  ] Started systemd-logind.service",
                "[  OK  ] Started firewalld.service",
                "[  OK  ] Started bluetooth.service",
                "[  OK  ] Started chronyd.service",
                "[  OK  ] Reached target Network",
                "[  OK  ] Started accounts-daemon.service",
                "[  OK  ] Started power-profiles-daemon.service",
                "[  OK  ] Started udisks2.service",
                "[  OK  ] Started cups.service",
                "[  OK  ] Started avahi-daemon.service",
                "[  OK  ] Started systemd-resolved.service",
                "[  OK  ] Reached target Sound Card",
                "[  OK  ] Started dbus-broker.service",
                "[  OK  ] Started switcheroo-control.service",
                "[  OK  ] Started systemd-userdbd.service",
                "[  OK  ] Reached target Basic System",
                "[  OK  ] Started systemd-tmpfiles-setup.service",
                "[  OK  ] Reached target Multi-User System",
                "[  OK  ] Started sddm.service",
                "[  OK  ] Reached target Graphical Interface",
                "[  OK  ] Started systemd-update-utmp.service",
                "[  OK  ] Startup finished in 60s (simulated).",
                "[  OK  ] Fedora Linux system initialization complete."
        });

        // 6. KDE Plasma
        cargar(new String[]{
                "[KDE] Starting Plasma Workspace...",
                "[KDE] Initializing Qt libraries...",
                "[KDE] Loading KDE Frameworks...",
                "[KDE] Initializing KWin compositor...",
                "[KDE] Loading desktop configuration...",
                "[KDE] Initializing system tray...",
                "[KDE] Loading desktop widgets...",
                "[KDE] Starting Plasma Shell...",
                "[KDE] Desktop environment ready.",
                "[KDE] Welcome to Fedora Linux + KDE Plasma!"
        });

        System.out.println("""
                
                ========================================
                     SISTEMA INICIADO CORRECTAMENTE
                ========================================
                
                       HP ProDesk 600 G4
                       Fedora Linux
                       KDE Plasma
                
                       Bienvenido, Daniel.
                
                ========================================
                """);
    }
}
