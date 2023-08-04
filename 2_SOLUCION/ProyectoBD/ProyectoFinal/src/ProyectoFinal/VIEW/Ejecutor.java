package ProyectoFinal.VIEW;


import ProyectoFinal.CONTROLER.*;

import java.util.Scanner;

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

        Usuario usuario = new Usuario(nombreCliente, apellidoCliente, cedulaPasaporteCliente, ciudadCliente,ciudadCliente);

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
                plan = Model.crearPlanPostPagoMinutosMegasEconomico(scanner, usuario);
                break;
            case 2:
                plan = Model.crearPlanPostPagoMinutos(scanner, usuario);
                break;
            case 3:
                plan = Model.crearPlanPostPagoMegas(scanner, usuario);
                break;
            case 4:
                plan = Model.crearPlanPostPagoMinutosMegas(scanner, usuario);
                break;
            default:
                System.out.println("Opción inválida. Seleccionando Plan PostPago Minutos Megas Económico por defecto.");
                plan = Model.crearPlanPostPagoMinutosMegasEconomico(scanner, usuario);
                break;
        }

        Factura factura = new Factura(usuario, plan);
        usuario.agregarFactura(factura);

        System.out.println("Factura generada:");
        System.out.println(factura);
    }
    public class Model {

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


}