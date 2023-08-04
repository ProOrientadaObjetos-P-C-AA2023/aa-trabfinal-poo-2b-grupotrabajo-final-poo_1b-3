package ProyectoFinal.CONTROLER;


public class PlanPostPagoMinutosMegas extends PlanMovil {
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