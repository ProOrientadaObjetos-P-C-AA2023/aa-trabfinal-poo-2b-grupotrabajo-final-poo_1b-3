package ProyectoFinal.CONTROLER;

public class PlanPostPagoMegas extends PlanMovil {
    private double megabytes;
    private double costoPorGiga;
    private double tarifaBase;

    public PlanPostPagoMegas(Usuario usuario, String marcaCelular, String modeloCelular, int numeroCelular) {
        super( usuario, marcaCelular, modeloCelular, numeroCelular);
    }
    @Override
    public double calcularCostoTotal() {
        megabytes=1000;
        costoPorGiga =0.1;
        tarifaBase = 10.10;
        double totalPagoMegas;

        double costoMegasTotal = PlanMovil.megabytesToGigabytes(megabytes) * costoPorGiga;
        totalPagoMegas = (costoMegasTotal + tarifaBase)+super.getIva();
        System.out.println(totalPagoMegas);
        return totalPagoMegas;
    }
}