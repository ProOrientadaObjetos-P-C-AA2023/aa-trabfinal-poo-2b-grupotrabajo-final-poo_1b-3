package ProyectoFinal.CONTROLER;

import java.util.ArrayList;
import java.util.List;

public abstract class PlanMovil {
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
