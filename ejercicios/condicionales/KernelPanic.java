
public class KernelPanic {

    public static void main(String[] args) throws InterruptedException {

        String rojo = "\u001B[31m";
        String gris = "\u001B[90m";
        String blanco = "\u001B[97m";
        String amarillo = "\u001B[33m";
        String reset = "\u001B[0m";

        // Limpiar la terminal y ocultar el cursor.
        System.out.print("\033[2J\033[H\033[?25l");
        System.out.flush();

        Thread.sleep(1000);

        System.out.println(rojo + blanco);
        System.out.println("  KERNEL PANIC!");
        System.out.println();
        System.out.println("  /\\_/\\\\");
        System.out.println(" ( X.X )");
        System.out.println("  > ^ <");
        System.out.println();
        System.out.println("  A fatal exception has occurred.");
        System.out.println("  The system has been halted.");
        System.out.println(reset);

        Thread.sleep(1500);

        System.out.println(rojo
                + "====================================================");
        System.out.println("  [KERNEL PANIC] Not syncing: Fatal exception");
        System.out.println("===================================================="
                + reset);

        System.out.println();
        System.out.println(amarillo + "[CRITICAL] CPU: 0 PID: 1337"
                + reset);
        System.out.println("[CRITICAL] Process: java (Java Virtual Machine)");
        System.out.println("[ERROR] Unable to recover kernel state");
        System.out.println("[ERROR] Memory access violation detected");
        System.out.println("[ERROR] Stack trace corrupted");
        System.out.println();

        System.out.println(gris
                + "Call Trace:");
        System.out.println("  dump_stack+0x64/0x80");
        System.out.println("  panic+0x120/0x350");
        System.out.println("  java_virtual_kernel+0xDEAD");
        System.out.println("  memory_manager+0xBAD0");
        System.out.println("  main+0x1337");
        System.out.println(reset);

        System.out.println();
        System.out.println(rojo + "Registers:" + reset);
        System.out.println("  RIP: 0xDEADBEEF");
        System.out.println("  RSP: 0x00000000");
        System.out.println("  RAX: 0xFFFFFFFF");
        System.out.println("  RBX: 0x0000DEAD");
        System.out.println("  CR2: 0xBADCAFE0");
        System.out.println();

        System.out.println(rojo
                + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("  SYSTEM HALTED");
        System.out.println("  REBOOT REQUIRED");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
                + reset);

        System.out.println();
        System.out.println(gris
                + "[This is a Java simulation. Fedora is safe.]"
                + reset);

        // Restaurar el cursor antes de finalizar.
        System.out.print("\033[?25h");
        System.out.flush();
    }
}
