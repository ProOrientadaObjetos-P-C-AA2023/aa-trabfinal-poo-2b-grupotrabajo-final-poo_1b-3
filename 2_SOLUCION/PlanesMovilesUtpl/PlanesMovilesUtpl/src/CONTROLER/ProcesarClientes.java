package CONTROLER;

import MODEL.Clientes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesarClientes {

    public ArrayList<Clientes> leerClientesDesdeCSV(String rutaArchivo) {
        ArrayList<Clientes> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            boolean primeraLinea = true;
            while ((line = br.readLine()) != null) {
                System.out.println("Línea leída: " + line);
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 10) {
                    Clientes cliente = new Clientes();
                    cliente.setNombre(data[0]);
                    cliente.setApellido(data[1]);

                    if (data[2].matches("\\d+")) {
                        cliente.setCedula(Integer.parseInt(data[2]));
                    } else {
                        cliente.setCedula(0);
                    }

                    cliente.setCiudad(data[3]);
                    cliente.setMarca(data[4]);
                    cliente.setModelo(data[5]);
                    if (data[6].matches("\\d+")) {
                        cliente.setNumero(Integer.parseInt(data[6]));
                    } else {
                        cliente.setNumero(0);
                    }
                    cliente.setCorreo(data[7]);
                    cliente.setPlan(data[8]);

                    if (data[9].matches("\\d+(\\.\\d+)?")) {
                        cliente.setPagoMensual(Double.parseDouble(data[9]));
                    } else {
                        cliente.setPagoMensual(0);
                    }

                    clientes.add(cliente);
                } else {
                    System.out.println("Línea inválida: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
