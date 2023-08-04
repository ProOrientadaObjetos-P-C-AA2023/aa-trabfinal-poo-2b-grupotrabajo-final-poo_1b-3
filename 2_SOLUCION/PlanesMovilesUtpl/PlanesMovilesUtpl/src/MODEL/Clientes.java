package MODEL;

public class Clientes {

    public String Nombre;
    public String Apellido;
    public int Cedula;
    public String Ciudad;
    public String Marca;
    public String Modelo;
    public int Numero;
    public String Correo;
    public String Plan;
    public double PagoMensual;

    public Clientes() {
        this.Apellido = "";
        this.Nombre = "";
        this.Apellido = "";
        this.Cedula = 0;
        this.Ciudad = "";
        this.Marca = "";
        this.Modelo = "";
        this.Numero = 0;
        this.Correo = "";
        this.Plan = "";
        this.PagoMensual = 0.0;
    }

    public Clientes(String Nombre, String Apellido, int Cedula, String Ciudad, String Marca, String Modelo, int Numero, String Correo, String Plan, double PagoMensual) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Ciudad = Ciudad;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Numero = Numero;
        this.Correo = Correo;
        this.Plan = Plan;
        this.PagoMensual = PagoMensual;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Cedula=" + Cedula + ", Ciudad=" + Ciudad + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Numero=" + Numero + ", Correo=" + Correo + ", Plan=" + Plan + ", PagoMensual=" + PagoMensual + '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getCedula() {
        return Cedula;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getNumero() {
        return Numero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public void setPlan(String Plan) {
        this.Plan = Plan;
    }

    public void setPagoMensual(double PagoMensual) {
        this.PagoMensual = PagoMensual;
    }

    public String getPlan() {
        return Plan;
    }

    public double getPagoMensual() {
        return PagoMensual;
    }

}
