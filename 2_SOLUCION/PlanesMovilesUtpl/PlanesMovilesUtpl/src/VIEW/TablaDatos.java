package VIEW;

import CONTROLER.ProcesarClientes;
import MODEL.Clientes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TablaDatos extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Clientes> clientesOriginales;

    public TablaDatos() {
        initComponents();
        this.setLocationRelativeTo(null);

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Numero");
        modelo.addColumn("Correo");
        modelo.addColumn("Plan");
        modelo.addColumn("PagoMensual");
        Tabla.setModel(modelo);
        clientesOriginales = new ArrayList<>();
    }

    private void guardarCambiosEnCSV() {
        String rutaArchivo = "Tabla.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write("Nombre,Apellido,Cedula,Ciudad,Marca,Modelo,Numero,Correo,Plan,PagoMensual");
            bw.newLine();

            for (Clientes cliente : clientesOriginales) {
                bw.write(cliente.getNombre() + ","
                        + cliente.getApellido() + ","
                        + cliente.getCedula() + ","
                        + cliente.getCiudad() + ","
                        + cliente.getMarca() + ","
                        + cliente.getModelo() + ","
                        + cliente.getNumero() + ","
                        + cliente.getCorreo() + ","
                        + cliente.getPlan() + ","
                        + cliente.getPagoMensual());
                bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios en el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Seleccionar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Base.setBackground(new java.awt.Color(255, 255, 255));

        Tabla.setBackground(new java.awt.Color(255, 255, 255));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Cedula", "Ciudad", "Marca", "Modelo", "Numero", "Correo", "Plan", "PagoMensual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        Seleccionar.setBackground(new java.awt.Color(0, 102, 255));
        Seleccionar.setForeground(new java.awt.Color(255, 255, 255));
        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(0, 102, 255));
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(0, 102, 255));
        Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Regresar.setBackground(new java.awt.Color(0, 102, 255));
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/utpl_blanco.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BaseLayout = new javax.swing.GroupLayout(Base);
        Base.setLayout(BaseLayout);
        BaseLayout.setHorizontalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
            .addGroup(BaseLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BaseLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Seleccionar)
                        .addGap(35, 35, 35)
                        .addComponent(Eliminar)
                        .addGap(27, 27, 27)
                        .addComponent(Actualizar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(398, Short.MAX_VALUE))
            .addGroup(BaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BaseLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seleccionar)
                    .addComponent(Eliminar)
                    .addComponent(Actualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Regresar)
                    .addComponent(jButton1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        ProcesarClientes procesador = new ProcesarClientes();
        String rutaArchivo = "Tabla.csv";
        ArrayList<Clientes> clientes = procesador.leerClientesDesdeCSV(rutaArchivo);
        modelo = (DefaultTableModel) Tabla.getModel();
        modelo.setRowCount(0);
        for (Clientes cliente : clientes) {
            Object[] rowData = {
                cliente.getNombre(),
                cliente.getApellido(),
                String.valueOf(cliente.getCedula()),
                cliente.getCiudad(),
                cliente.getMarca(),
                cliente.getModelo(),
                String.valueOf(cliente.getNumero()),
                cliente.getCorreo(),
                cliente.getPlan(),
                String.format("%.2f", cliente.getPagoMensual())
            };
            modelo.addRow(rowData);
        }
        clientesOriginales.clear();
        for (Clientes cliente : clientes) {
            clientesOriginales.add(cliente);
        }
    }//GEN-LAST:event_SeleccionarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        PlanesMoviles pm = new PlanesMoviles();
        pm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        if (clientesOriginales.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione los datos primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numFilas = modelo.getRowCount();
        clientesOriginales.clear();

        for (int i = 0; i < numFilas; i++) {
            String nombre = String.valueOf(Tabla.getValueAt(i, 0));
            String apellido = String.valueOf(Tabla.getValueAt(i, 1));
            int cedula = Integer.parseInt(String.valueOf(Tabla.getValueAt(i, 2)));
            String ciudad = String.valueOf(Tabla.getValueAt(i, 3));
            String marca = String.valueOf(Tabla.getValueAt(i, 4));
            String modelo = String.valueOf(Tabla.getValueAt(i, 5));
            int numero = Integer.parseInt(String.valueOf(Tabla.getValueAt(i, 6)));
            String correo = String.valueOf(Tabla.getValueAt(i, 7));
            String plan = String.valueOf(Tabla.getValueAt(i, 8));
            String pagoMensualStr = String.valueOf(Tabla.getValueAt(i, 9));
            double pagoMensual = Double.parseDouble(pagoMensualStr.replace(",", ".")); // Reemplazar la coma por punto
            Clientes cliente = new Clientes(nombre, apellido, cedula, ciudad, marca, modelo, numero, correo, plan, pagoMensual);
            clientesOriginales.add(cliente);
        }
        guardarCambiosEnCSV();
        ((DefaultTableModel) Tabla.getModel()).fireTableDataChanged();
        modelo.fireTableDataChanged();
        JOptionPane.showMessageDialog(this, "Los cambios han sido actualizados correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int filaSeleccionada = Tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el registro?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JPanel Base;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton Seleccionar;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
