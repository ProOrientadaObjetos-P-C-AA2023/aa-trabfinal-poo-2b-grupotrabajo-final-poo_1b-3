package ProyectoFinal.CONTROLER;


public class PlanPostPagoMinutosMegasEconomico extends PlanMovil {
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