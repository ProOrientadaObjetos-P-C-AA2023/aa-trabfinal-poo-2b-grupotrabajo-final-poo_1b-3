package ProyectoFinal.CONTROLER;


import java.util.ArrayList;
import java.util.List;

public class Usuario {
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
