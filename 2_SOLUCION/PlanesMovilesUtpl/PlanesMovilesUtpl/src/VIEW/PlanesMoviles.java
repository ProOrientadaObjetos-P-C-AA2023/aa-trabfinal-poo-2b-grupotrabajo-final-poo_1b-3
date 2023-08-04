package VIEW;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlanesMoviles extends javax.swing.JFrame {

    private String correoUsuario;
    private boolean datosIngresados = false;
    private String planSeleccionado = "";
    private int pagoMensual = 0;
    private double megabytes;
    private double costoPorGiga;
    private double tarifaBase;
    public double minutosNacionales;
    public double costoMinutoNacional;
    public double minutosInternacionales;
    public double costoMinutoInternacional;
    private double minutos;
    private double costoMinutos;
    public double porcentajeDescuento;

    public PlanesMoviles() {
        initComponents();
        this.setLocationRelativeTo(null);
        deshabilitarCamposDatosPersonales();
    }

    public PlanesMoviles(String correo) {
        initComponents();
        this.setLocationRelativeTo(null);
        correoUsuario = correo;
    }

    private void deshabilitarCamposDatosPersonales() {
        Nombre.setEnabled(false);
        Apellido.setEnabled(false);
        Cedula.setEnabled(false);
        Ciudad.setEnabled(false);
        Marca.setEnabled(false);
        Modelo.setEnabled(false);
        Numero.setEnabled(false);
        contratar.setEnabled(false);
    }

    private void habilitarCamposDatosPersonales() {
        Nombre.setEnabled(true);
        Apellido.setEnabled(true);
        Cedula.setEnabled(true);
        Ciudad.setEnabled(true);
        Marca.setEnabled(true);
        Modelo.setEnabled(true);
        Numero.setEnabled(true);
        contratar.setEnabled(true);
    }

    private void bloquearBotonesPlanes() {

        plan1.setEnabled(false);
        plan2.setEnabled(false);
        plan3.setEnabled(false);
        plan4.setEnabled(false);
    }

    private double calcularPago(String plan) {
        double costo = 0;
        switch (plan) {
            case "PlanPostPagoMinutosMegasEconomico":
                this.minutos = 30;
                this.costoMinutos = 0.1;
                this.megabytes = 8000;
                this.costoPorGiga = 1;
                this.porcentajeDescuento = 10;

                double costoMinutosTotal = minutos * costoMinutos;
                double gigabytes = megabytes / 1024;
                double costoMegasTotal = gigabytes * costoPorGiga;
                double descuento = porcentajeDescuento * 0.10;
                costo = costoMinutosTotal + costoMegasTotal - descuento + 0.12;
                break;

            case "PlanPostPagoMinutos":
                this.minutosNacionales = 50;
                this.minutosInternacionales = 45;
                this.costoMinutoNacional = 0.1;
                this.costoMinutoInternacional = 0.2;
                double costoMinutosNacionales = minutosNacionales * costoMinutoNacional;
                double costoMinutosInternacionales = minutosInternacionales * costoMinutoInternacional;
                costo = costoMinutosNacionales + costoMinutosInternacionales + 0.12;
                break;
            case "PlanPostPagoMegas":
                this.megabytes = 20000;
                this.costoPorGiga = 1;
                this.tarifaBase = 1;
                double gigabyt = megabytes / 1024;
                double costoMegasTtal = gigabyt * costoPorGiga;
                costo = costoMegasTtal + tarifaBase;
                break;
            case "PlanPostPagoMinutosMegas":
                this.minutos = 80;
                this.costoMinutos = 0.3;
                this.megabytes = 40000;
                this.costoPorGiga = 1;
                double total;
                double costoMinutosTotl = minutos * costoMinutos;
                double gigabyts = megabytes / 1024;
                double costoMegasTotl = gigabyts * costoPorGiga;
                costo = (costoMinutosTotl + costoMegasTotl) + 0.12;
                break;
        }
        return costo;
    }

    private void mostrarFactura(double pagoMensual) {
        String nombre = Nombre.getText();
        String apellido = Apellido.getText();
        String cedula = Cedula.getText();
        String ciudad = Ciudad.getText();
        String marca = Marca.getText();
        String modelo = Modelo.getText();
        String numero = Numero.getText();

        double iva = pagoMensual * 0.12;
        double total = pagoMensual + iva;

        String factura = "**********************************\n";
        factura += "           FACTURA\n";
        factura += "**********************************\n";
        factura += "Nombre: " + nombre + " " + apellido + "\n";
        factura += "Cédula: " + cedula + "\n";
        factura += "Ciudad: " + ciudad + "\n";
        factura += "Marca: " + marca + "\n";
        factura += "Modelo: " + modelo + "\n";
        factura += "Número: " + numero + "\n";
        factura += "Correo: " + correoUsuario + "\n";
        factura += "Plan seleccionado: " + planSeleccionado + "\n";
        factura += "**********************************\n";
        factura += String.format("%-20s %10s\n", "Subtotal:", "$" + String.format("%.2f", pagoMensual));
        factura += String.format("%-20s %10s\n", "IVA (12%):", "$" + String.format("%.2f", iva));
        factura += String.format("%-20s %10s\n", "Total a pagar:", "$" + String.format("%.2f", total));
        factura += "**********************************\n";

        MostrarFactura.setText(factura);

        String csvFileName = "Tabla.csv";
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current Directory: " + currentDir);
        csvFileName = currentDir + "/" + csvFileName;
        try (FileWriter writer = new FileWriter(csvFileName, true)) {
            if (Files.size(Paths.get(csvFileName)) == 0) {
                writer.append("Nombre,Apellido,Cedula,Ciudad,Marca,Modelo,Numero,Correo,Plan,PagoMensual\n");
            }
            writer.append(nombre + "," + apellido + "," + cedula + "," + ciudad + "," + marca + "," + modelo + "," + numero + "," + correoUsuario + "," + planSeleccionado + "," + total + "\n");
            writer.flush();
            System.out.println("Factura guardada exitosamente en el archivo " + csvFileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar la factura en el archivo " + csvFileName);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        PanelPlanes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        plan1 = new javax.swing.JButton();
        plan2 = new javax.swing.JButton();
        plan3 = new javax.swing.JButton();
        plan4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Apellido = new javax.swing.JTextField();
        Cedula = new javax.swing.JTextField();
        Ciudad = new javax.swing.JTextField();
        Marca = new javax.swing.JTextField();
        Modelo = new javax.swing.JTextField();
        Numero = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MostrarFactura = new javax.swing.JTextArea();
        contratar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tabla = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPlanes.setBackground(new java.awt.Color(255, 255, 255));
        PanelPlanes.setForeground(new java.awt.Color(255, 255, 255));
        PanelPlanes.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Seleccione el Plan Móvil que sea de su preferencia");

        plan1.setBackground(new java.awt.Color(255, 255, 255));
        plan1.setForeground(new java.awt.Color(0, 0, 0));
        plan1.setText("PlanPostPagoMinutosMegasEconomico");
        plan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plan1ActionPerformed(evt);
            }
        });

        plan2.setBackground(new java.awt.Color(255, 255, 255));
        plan2.setForeground(new java.awt.Color(0, 0, 0));
        plan2.setText("PlanPostPagoMinutos");
        plan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plan2ActionPerformed(evt);
            }
        });

        plan3.setBackground(new java.awt.Color(255, 255, 255));
        plan3.setForeground(new java.awt.Color(0, 0, 0));
        plan3.setText("PlanPostPagoMegas ");
        plan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plan3ActionPerformed(evt);
            }
        });

        plan4.setBackground(new java.awt.Color(255, 255, 255));
        plan4.setForeground(new java.awt.Color(0, 0, 0));
        plan4.setText("PlanPostPagoMinutosMegas");
        plan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plan4ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("1.-");

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("2.-");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("3.-");

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("4.-");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jTextArea1.setText("1.-Plan Postpago Minutos Megas Económico:\n\n8Gigas - 30Minutos (Multidestino)\n10% de descuento en el primer pago!\nCosto con descuento: $10.08\n2.-Plan Postpago Minutos:\n\n50 Minutos (Nacionales)\n45Minutos (Internacionales)\nCosto: $15.68\n3.-Plan Postpago Megas:\n\n20Gigas\nTarifa base de $1\nCosto: $22.40\n4.-Plan Postpago Minutos Megas:\n\n40Gigas - 80Minutos\nCosto: $70.56");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("-----------------------------------------------------------------------------------------------------------------------------------------");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cedula:");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ciudad:");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Marca:");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Modelo:");

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Numero:");

        Nombre.setBackground(new java.awt.Color(255, 255, 255));
        Nombre.setForeground(new java.awt.Color(0, 0, 0));

        Apellido.setBackground(new java.awt.Color(255, 255, 255));
        Apellido.setForeground(new java.awt.Color(0, 0, 0));

        Cedula.setBackground(new java.awt.Color(255, 255, 255));
        Cedula.setForeground(new java.awt.Color(0, 0, 0));

        Ciudad.setBackground(new java.awt.Color(255, 255, 255));
        Ciudad.setForeground(new java.awt.Color(0, 0, 0));
        Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadActionPerformed(evt);
            }
        });

        Marca.setBackground(new java.awt.Color(255, 255, 255));
        Marca.setForeground(new java.awt.Color(0, 0, 0));
        Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaActionPerformed(evt);
            }
        });

        Modelo.setBackground(new java.awt.Color(255, 255, 255));
        Modelo.setForeground(new java.awt.Color(0, 0, 0));

        Numero.setBackground(new java.awt.Color(255, 255, 255));
        Numero.setForeground(new java.awt.Color(0, 0, 0));

        MostrarFactura.setEditable(false);
        MostrarFactura.setBackground(new java.awt.Color(255, 255, 255));
        MostrarFactura.setColumns(20);
        MostrarFactura.setForeground(new java.awt.Color(0, 0, 0));
        MostrarFactura.setRows(5);
        jScrollPane2.setViewportView(MostrarFactura);

        contratar.setBackground(new java.awt.Color(0, 102, 255));
        contratar.setForeground(new java.awt.Color(255, 255, 255));
        contratar.setText("Contratar");
        contratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/utpl_blanco.png"))); // NOI18N
        jLabel14.setText("jLabel14");

        tabla.setBackground(new java.awt.Color(0, 102, 255));
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setText("TablaD");
        tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPlanesLayout = new javax.swing.GroupLayout(PanelPlanes);
        PanelPlanes.setLayout(PanelPlanesLayout);
        PanelPlanesLayout.setHorizontalGroup(
            PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlanesLayout.createSequentialGroup()
                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPlanesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPlanesLayout.createSequentialGroup()
                                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(plan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(plan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(plan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(plan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPlanesLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addGroup(PanelPlanesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(PanelPlanesLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(30, 30, 30)
                                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Numero)
                                    .addComponent(Modelo)
                                    .addComponent(Marca)
                                    .addComponent(Apellido)
                                    .addComponent(Nombre)
                                    .addComponent(Cedula)
                                    .addComponent(Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(contratar)
                                    .addComponent(tabla))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPlanesLayout.setVerticalGroup(
            PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlanesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPlanesLayout.createSequentialGroup()
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plan1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plan2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plan3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plan4)
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPlanesLayout.createSequentialGroup()
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(PanelPlanesLayout.createSequentialGroup()
                        .addComponent(contratar)
                        .addGap(26, 26, 26)
                        .addComponent(tabla))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPlanes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPlanes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiudadActionPerformed

    private void MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaActionPerformed

    private void plan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plan1ActionPerformed
        planSeleccionado = "PlanPostPagoMinutosMegasEconomico";
        pagoMensual = (int) calcularPago(planSeleccionado);
        jLabel2.setVisible(false);
        jScrollPane2.setVisible(true);
        MostrarFactura.setVisible(true);
        habilitarCamposDatosPersonales();
        bloquearBotonesPlanes();
    }//GEN-LAST:event_plan1ActionPerformed

    private void plan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plan2ActionPerformed
        planSeleccionado = "PlanPostPagoMinutos";
        pagoMensual = (int) calcularPago(planSeleccionado);
        jLabel2.setVisible(false);
        jScrollPane2.setVisible(true);
        MostrarFactura.setVisible(true);
        habilitarCamposDatosPersonales();
        bloquearBotonesPlanes();
    }//GEN-LAST:event_plan2ActionPerformed

    private void plan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plan3ActionPerformed
        planSeleccionado = "PlanPostPagoMegas";
        pagoMensual = (int) calcularPago(planSeleccionado);
        jLabel2.setVisible(false);
        jScrollPane2.setVisible(true);
        MostrarFactura.setVisible(true);
        habilitarCamposDatosPersonales();
        bloquearBotonesPlanes();
    }//GEN-LAST:event_plan3ActionPerformed

    private void plan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plan4ActionPerformed
        planSeleccionado = "PlanPostPagoMinutosMegas";
        pagoMensual = (int) calcularPago(planSeleccionado);
        jLabel2.setVisible(false);
        jScrollPane2.setVisible(true);
        MostrarFactura.setVisible(true);
        habilitarCamposDatosPersonales();
        bloquearBotonesPlanes();
    }//GEN-LAST:event_plan4ActionPerformed

    private void contratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratarActionPerformed
        String nombre = Nombre.getText();
        String apellido = Apellido.getText();
        String cedula = Cedula.getText();
        String ciudad = Ciudad.getText();
        String marca = Marca.getText();
        String modelo = Modelo.getText();
        String numero = Numero.getText();
        String correo = correoUsuario;
        String plan = planSeleccionado;

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty()
                || ciudad.isEmpty() || marca.isEmpty() || modelo.isEmpty() || numero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los datos personales.");
            return;
        }

        mostrarFactura(pagoMensual);
        contratar.setEnabled(false);
        datosIngresados = true;
    }//GEN-LAST:event_contratarActionPerformed

    private void tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablaActionPerformed
        TablaDatos td = new TablaDatos();
        td.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tablaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlanesMoviles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanesMoviles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanesMoviles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanesMoviles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanesMoviles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Ciudad;
    private javax.swing.JTextField Marca;
    private javax.swing.JTextField Modelo;
    private javax.swing.JTextArea MostrarFactura;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Numero;
    private javax.swing.JPanel PanelPlanes;
    private javax.swing.JButton contratar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton plan1;
    private javax.swing.JButton plan2;
    private javax.swing.JButton plan3;
    private javax.swing.JButton plan4;
    private javax.swing.JButton tabla;
    // End of variables declaration//GEN-END:variables
}
