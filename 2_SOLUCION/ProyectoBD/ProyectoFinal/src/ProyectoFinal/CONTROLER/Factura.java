package ProyectoFinal.CONTROLER;

public class Factura {
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
