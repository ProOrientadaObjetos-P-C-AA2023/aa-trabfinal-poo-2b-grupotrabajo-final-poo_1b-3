package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Usuario {
    public String nombre;
    public String apellido;
    public int cedulaPasaporte;
    public String ciudad;
    public String correo;
    public List<Factura> facturas;

    public Usuario(String nombre, String apellido, int cedulaPasaporte, String ciudad,String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedulaPasaporte = cedulaPasaporte;
        this.ciudad = ciudad;
        this.correo = correo;
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedulaPasaporte=" + cedulaPasaporte +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
class Factura {
    public Usuario usuario;
    public PlanMovil plan;
    public double total;

    public Factura(Usuario usuario, PlanMovil plan) {
        this.usuario = usuario;
        this.plan = plan;
        this.total = plan.calcularCostoTotal();
    }

    @Override
    public String toString() {
        return "Factura" +
                "\nUsuario: " + usuario.nombre + " " + usuario.apellido +
                "\nCédula/Pasaporte: " + usuario.cedulaPasaporte +
                "\nCiudad: " + usuario.ciudad +
                "\nMarca Celular: " + plan.marcaCelular +
                "\nModelo Celular: " + plan.modeloCelular +
                "\nNúmero Celular: " + plan.numeroCelular +
                "\nTotal: $" + String.format("%.2f", total) +
                "\n-------------------------";
    }
}


abstract class PlanMovil {
    public Usuario usuario;
    public String marcaCelular;
    public String modeloCelular;
    public int numeroCelular;
    public double iva;

    public PlanMovil(Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular) {
        this.usuario = usuario;
        this.marcaCelular = marcaCelular;
        this.modeloCelular = modeloCelular;
        this.numeroCelular = numeroCelular;
    }

    public double getIva() {
        return iva = 0.12;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public abstract double calcularCostoTotal();
    public static double megabytesToGigabytes(double megabytes) {
        double gigabytes = megabytes / 1024;
        return gigabytes;
    }

    @Override
    public String toString() {
        return "PlanPostPago{" +
                "usuario=" + usuario +
                ", marcaCelular='" + marcaCelular + '\'' +
                ", modeloCelular='" + modeloCelular + '\'' +
                ", numeroCelular=" + numeroCelular +
                ", iva=" + iva +
                ", pagoMensual=" + calcularCostoTotal() +
                '}';
    }
}

class PlanPostPagoMinutosMegasEconomico extends PlanMovil {
    public double minutos;
    public double costoMinutos;
    public double megabytes;
    public double costoPorGiga;
    public double porcentajeDescuento;

    public PlanPostPagoMinutosMegasEconomico(Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular){
        super(usuario, marcaCelular, modeloCelular, numeroCelular);
    }

    @Override
    public double calcularCostoTotal() {
        this.minutos = 30;
        this.costoMinutos =0.1;
        this.megabytes = 100 ;
        this.costoPorGiga= 0.1;
        this.porcentajeDescuento=10;
        double total;

        double costoMinutosTotal = minutos * costoMinutos;
        double costoMegasTotal = PlanMovil.megabytesToGigabytes(megabytes) * costoPorGiga;
        double descuento =  porcentajeDescuento / 100.0;
        total = costoMinutosTotal + costoMegasTotal - descuento + super.getIva();
        return total;
    }

}
class PlanPostPagoMinutos extends PlanMovil {
    public double minutosNacionales;
    public double costoMinutoNacional;
    public double minutosInternacionales;
    public double costoMinutoInternacional;

    public PlanPostPagoMinutos( Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular) {
        super( usuario, marcaCelular, modeloCelular, numeroCelular);
    }

    @Override
    public double calcularCostoTotal() {
        this.minutosNacionales =50;
        this.minutosInternacionales=45;
        this.costoMinutoNacional=0.1;
        this.costoMinutoInternacional=0.2;

        double total;
        double costoMinutosNacionales = minutosNacionales * costoMinutoNacional;
        double costoMinutosInternacionales = minutosInternacionales * costoMinutoInternacional;
        total = costoMinutosNacionales + costoMinutosInternacionales + super.getIva();
        return total;
    }
}
class PlanPostPagoMegas extends PlanMovil {
    private double megabytes;
    private double costoPorGiga;
    private double tarifaBase;

    public PlanPostPagoMegas(Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular) {
        super( usuario, marcaCelular, modeloCelular, numeroCelular);
    }
    @Override
    public double calcularCostoTotal() {
        megabytes=100;
        costoPorGiga =0.1;
        tarifaBase = 0.15;
        double totalPagoMegas;
        double costoMegasTotal = PlanMovil.megabytesToGigabytes(megabytes) * costoPorGiga;
        totalPagoMegas = costoMegasTotal + tarifaBase;
        return totalPagoMegas;
    }
}
class PlanPostPagoMinutosMegas extends PlanMovil {
    private double minutos;
    private double costoMinutos;
    private double megabytes;
    private double costoPorGiga;

    public PlanPostPagoMinutosMegas(Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular) {
        super(usuario, marcaCelular, modeloCelular, numeroCelular);
    }

    @Override
    public double calcularCostoTotal() {
        this.minutos = 80;
        this.costoMinutos =0.2 ;
        this.megabytes = 250;
        this.costoPorGiga = 0.5;
        double total;
        double costoMinutosTotal = minutos * costoMinutos;
        double costoMegasTotal = PlanMovil.megabytesToGigabytes(megabytes) * costoPorGiga;
        total=(costoMinutosTotal+costoMegasTotal)+ super.getIva();
        return total;
    }
}
class Ejecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();

        System.out.println("Ingrese el apellido del cliente:");
        String apellidoCliente = scanner.nextLine();

        System.out.println("Ingrese el número de cédula o pasaporte del cliente:");
        int cedulaPasaporteCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la ciudad del cliente:");
        String ciudadCliente = scanner.nextLine();

        System.out.println("Ingrese el correo");
        String correoCliente = scanner.nextLine();

        Usuario usuario = new Usuario(nombreCliente, apellidoCliente, cedulaPasaporteCliente, ciudadCliente,correoCliente);

        System.out.println("Elija el tipo de plan:");
        System.out.println("1. Plan PostPago Minutos Megas Económico");
        System.out.println("2. Plan PostPago Minutos");
        System.out.println("3. Plan PostPago Megas");
        System.out.println("4. Plan PostPago Minutos Megas");

        int opcionPlan = scanner.nextInt();
        scanner.nextLine();

        PlanMovil plan;
        switch (opcionPlan) {
            case 1:
                plan = crearPlanPostPagoMinutosMegasEconomico(scanner, usuario);
                break;
            case 2:
                plan = crearPlanPostPagoMinutos(scanner, usuario);
                break;
            case 3:
                plan = crearPlanPostPagoMegas(scanner, usuario);
                break;
            case 4:
                plan = crearPlanPostPagoMinutosMegas(scanner, usuario);
                break;
            default:
                System.out.println("Opción inválida. Seleccionando Plan PostPago Minutos Megas Económico por defecto.");
                plan = crearPlanPostPagoMinutosMegasEconomico(scanner, usuario);
                break;
        }

        Factura factura = new Factura(usuario, plan);
        usuario.agregarFactura(factura);

        System.out.println("Factura generada:");
        System.out.println(factura);
    }
    private static PlanPostPagoMinutosMegasEconomico crearPlanPostPagoMinutosMegasEconomico(Scanner scanner, Usuario usuario) {
        System.out.println("Ingrese la marca del celular:");
        String marcaCelular = scanner.nextLine();

        System.out.println("Ingrese el modelo del celular:");
        String modeloCelular = scanner.nextLine();

        System.out.println("Ingrese el número de celular:");
        int numeroCelular = scanner.nextInt();

        return new PlanPostPagoMinutosMegasEconomico(usuario, marcaCelular, modeloCelular, numeroCelular);
    }

    private static PlanPostPagoMinutos crearPlanPostPagoMinutos(Scanner scanner, Usuario usuario) {
        System.out.println("Ingrese la marca del celular:");
        String marcaCelular = scanner.nextLine();

        System.out.println("Ingrese el modelo del celular:");
        String modeloCelular = scanner.nextLine();

        System.out.println("Ingrese el número de celular:");
        int numeroCelular = scanner.nextInt();

        return new PlanPostPagoMinutos(usuario, marcaCelular, modeloCelular, numeroCelular);
    }

    private static PlanPostPagoMegas crearPlanPostPagoMegas(Scanner scanner, Usuario usuario) {
        System.out.println("Ingrese la marca del celular:");
        String marcaCelular = scanner.nextLine();

        System.out.println("Ingrese el modelo del celular:");
        String modeloCelular = scanner.nextLine();

        System.out.println("Ingrese el número de celular:");
        int numeroCelular = scanner.nextInt();
        return new PlanPostPagoMegas(usuario, marcaCelular, modeloCelular, numeroCelular);
    }
    private static PlanPostPagoMinutosMegas crearPlanPostPagoMinutosMegas(Scanner scanner, Usuario usuario) {
        System.out.println("Ingrese la marca del celular:");
        String marcaCelular = scanner.nextLine();
        System.out.println("Ingrese el modelo del celular:");
        String modeloCelular = scanner.nextLine();
        System.out.println("Ingrese el número de celular:");
        int numeroCelular = scanner.nextInt();
        return new PlanPostPagoMinutosMegas(usuario, marcaCelular, modeloCelular, numeroCelular);
    }
}