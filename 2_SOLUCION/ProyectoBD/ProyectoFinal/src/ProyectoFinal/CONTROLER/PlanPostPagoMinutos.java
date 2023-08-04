package ProyectoFinal.CONTROLER;

public class PlanPostPagoMinutos extends PlanMovil {
    public double minutosNacionales;
    public double costoMinutoNacional;
    public double minutosInternacionales;
    public double costoMinutoInternacional;

    public PlanPostPagoMinutos(Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular) {
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
