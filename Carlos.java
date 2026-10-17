
public class Carlos {
    public static void main(String[] args) {

        // ==========================================
        // SISTEMA ADMINISTRATIVO PERSONAL
        // Version 1.0 - Carlos Olaya Corporation
        // ==========================================

        String empresa = "Carlos Olaya Corporation";
        String nombre = "Carlos";
        String apellido = "Olaya";
        String apodo = "Papu";

        int edad = 26;
        int empleados = 47;
        int clientes = 1250;
        int diasTrabajados = 284;
        int horasTrabajadas = 1980;

        double deudaCashea = 1234.57;
        double dineroBanco = 5820.75;
        double salario = 2500.00;
        double gastosMensuales = 1875.35;
        double inversion = 15000.80;

        float notaParcial = 12.3f;
        float notaProgramacion = 4.5f;
        float notaMatematicas = 3.8f;

        String moneda = "USD";
        String estadoEmpresa = "OPERATIVA";
        String cargo = "Director ejecutivo";
        String departamento = "Tecnologia e innovacion";
        String proyecto = "Operación Papu";
        String ciudad = "Armenia";
        String pais = "Colombia";

        // ==========================================
        // ACTUALIZACION DE INFORMACION
        // ==========================================

        nombre = "Papu";
        deudaCashea = 1324.52;
        notaParcial = 4.2f;
        empleados = 52;
        clientes = 1800;
        salario = 3200.00;
        proyecto = "Operación Papu 2.0";
        estadoEmpresa = "EN EXPANSION";

        // ==========================================
        // PRESENTACION CORPORATIVA
        // ==========================================

        System.out.println("==================================================");
        System.out.println("       " + empresa);
        System.out.println("       SISTEMA DE GESTION INTEGRAL");
        System.out.println("==================================================");

        System.out.println("");
        System.out.println("------------- PERFIL DEL DIRECTOR ---------------");

        System.out.println("Nombre actual: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre completo original: Carlos " + apellido);
        System.out.println("Apodo corporativo: " + apodo);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Cargo: " + cargo);
        System.out.println("Departamento: " + departamento);
        System.out.println("Ubicacion: " + ciudad + ", " + pais);

        System.out.println("");
        System.out.println("------------- INFORMACION EMPRESARIAL ------------");

        System.out.println("Empresa: " + empresa);
        System.out.println("Estado: " + estadoEmpresa);
        System.out.println("Numero de empleados: " + empleados);
        System.out.println("Clientes registrados: " + clientes);
        System.out.println("Dias trabajados: " + diasTrabajados);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Proyecto principal: " + proyecto);

        System.out.println("");
        System.out.println("--------------- INFORME FINANCIERO ---------------");

        System.out.println("Moneda oficial: " + moneda);
        System.out.println("Saldo bancario: " + dineroBanco);
        System.out.println("Deuda con Cashea: " + deudaCashea);
        System.out.println("Salario mensual: " + salario);
        System.out.println("Gastos mensuales: " + gastosMensuales);
        System.out.println("Inversion empresarial: " + inversion);

        System.out.println("");
        System.out.println("--------------- INFORME ACADEMICO ----------------");

        System.out.println("Nota del parcial: " + notaParcial);
        System.out.println("Nota de programacion: " + notaProgramacion);
        System.out.println("Nota de matematicas: " + notaMatematicas);

        System.out.println("");
        System.out.println("--------------- REGISTRO DE ACTIVOS --------------");

        String activo1 = "Computador de escritorio";
        String activo2 = "Monitor profesional";
        String activo3 = "Teclado mecanico";
        String activo4 = "Servidor empresarial";
        String activo5 = "Licencia de software";

        double precioActivo1 = 850.50;
        double precioActivo2 = 320.75;
        double precioActivo3 = 95.99;
        double precioActivo4 = 4500.00;
        double precioActivo5 = 299.99;

        System.out.println("Activo 001: " + activo1);
        System.out.println("Valor: " + precioActivo1);

        System.out.println("Activo 002: " + activo2);
        System.out.println("Valor: " + precioActivo2);

        System.out.println("Activo 003: " + activo3);
        System.out.println("Valor: " + precioActivo3);

        System.out.println("Activo 004: " + activo4);
        System.out.println("Valor: " + precioActivo4);

        System.out.println("Activo 005: " + activo5);
        System.out.println("Valor: " + precioActivo5);

        System.out.println("");
        System.out.println("--------------- COMUNICADO OFICIAL ---------------");

        String comunicado = "La direccion informa que la empresa";
        String mensaje = "continuara invirtiendo en tecnologia";
        String objetivo = "para alcanzar sus objetivos estrategicos.";

        System.out.println(comunicado + " " + empresa);
        System.out.println("actualmente se encuentra " + estadoEmpresa + ".");
        System.out.println("El proyecto " + proyecto + " " + mensaje);
        System.out.println(objetivo);

        System.out.println("");
        System.out.println("==================================================");
        System.out.println("      FIN DEL INFORME ADMINISTRATIVO");
        System.out.println("      DOCUMENTO GENERADO POR " + nombre);
        System.out.println("==================================================");
    }
}
