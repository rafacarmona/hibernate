/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlInsertarClienteYTrabajador;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Rafa
 */
public class VistaInsertar extends javax.swing.JDialog {
    
    //le decimos cual es su controlador
    private CtrlInsertarClienteYTrabajador controller;
    /**
     * Creates new form VistaInsertar
     */
    public VistaInsertar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneInsertar = new javax.swing.JTabbedPane();
        jPanelClientes = new javax.swing.JPanel();
        jLabelInsertarClientes = new javax.swing.JLabel();
        jLabelNombreCliente = new javax.swing.JLabel();
        jLabelDNICliente = new javax.swing.JLabel();
        jLabelNhabitacion = new javax.swing.JLabel();
        jLabelNnoche = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDNICliente = new javax.swing.JTextField();
        jTextFieldNhabitacion = new javax.swing.JTextField();
        jTextFieldNnoches = new javax.swing.JTextField();
        jButtonInsertarCliente = new javax.swing.JButton();
        jPanelTrabajadores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombreTrabajador = new javax.swing.JTextField();
        jTextFieldDNITrabajador = new javax.swing.JTextField();
        jTextFieldOcupacion = new javax.swing.JTextField();
        jButtonInsertarTrabajadores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVerClientesParaInsertar = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVerClientesInsertados = new javax.swing.JTable();
        jButtonPasarAInsertados = new javax.swing.JButton();
        jButtonPasarAParaInsertar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelInsertarClientes.setFont(new java.awt.Font("Microsoft Himalaya", 1, 48)); // NOI18N
        jLabelInsertarClientes.setText("Insertar Clientes");

        jLabelNombreCliente.setText("Nombre:");

        jLabelDNICliente.setText("DNI:");

        jLabelNhabitacion.setText("Nº Habitación:");

        jLabelNnoche.setText("Nº Noches:");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldDNICliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIClienteActionPerformed(evt);
            }
        });

        jButtonInsertarCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonInsertarCliente.setText("Insertar");
        jButtonInsertarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelNombreCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDNICliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNnoche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNhabitacion, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonInsertarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldDNICliente)
                            .addComponent(jTextFieldNhabitacion)
                            .addComponent(jTextFieldNnoches, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelInsertarClientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInsertarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreCliente)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDNICliente))
                .addGap(10, 10, 10)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNhabitacion)
                    .addComponent(jTextFieldNhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNnoche)
                    .addComponent(jTextFieldNnoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonInsertarCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneInsertar.addTab("Clientes", jPanelClientes);

        jLabel1.setFont(new java.awt.Font("Microsoft Himalaya", 1, 48)); // NOI18N
        jLabel1.setText("Insertar Trabajadores:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("DNI:");

        jLabel4.setText("Ocupación:");

        jButtonInsertarTrabajadores.setText("Insertar");
        jButtonInsertarTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarTrabajadoresActionPerformed(evt);
            }
        });

        jTableVerClientesParaInsertar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "NombreCliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVerClientesParaInsertar);
        if (jTableVerClientesParaInsertar.getColumnModel().getColumnCount() > 0) {
            jTableVerClientesParaInsertar.getColumnModel().getColumn(0).setResizable(false);
        }

        jTableVerClientesInsertados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Clientes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableVerClientesInsertados);
        if (jTableVerClientesInsertados.getColumnModel().getColumnCount() > 0) {
            jTableVerClientesInsertados.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonPasarAInsertados.setText(">>");
        jButtonPasarAInsertados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasarAInsertadosActionPerformed(evt);
            }
        });

        jButtonPasarAParaInsertar.setText("<<");
        jButtonPasarAParaInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasarAParaInsertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTrabajadoresLayout = new javax.swing.GroupLayout(jPanelTrabajadores);
        jPanelTrabajadores.setLayout(jPanelTrabajadoresLayout);
        jPanelTrabajadoresLayout.setHorizontalGroup(
            jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                        .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDNITrabajador)
                                    .addComponent(jTextFieldNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonInsertarTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPasarAInsertados, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonPasarAParaInsertar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanelTrabajadoresLayout.setVerticalGroup(
            jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                                    .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextFieldNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextFieldDNITrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextFieldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonInsertarTrabajadores))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButtonPasarAInsertados)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPasarAParaInsertar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPaneInsertar.addTab("Trabajadores", jPanelTrabajadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneInsertar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneInsertar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldDNIClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIClienteActionPerformed

    private void jButtonInsertarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarClienteActionPerformed
        controller.insertarClientes();
    }//GEN-LAST:event_jButtonInsertarClienteActionPerformed

    private void jButtonPasarAInsertadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasarAInsertadosActionPerformed
        controller.pasarDeVerClienteAEscribir();
    }//GEN-LAST:event_jButtonPasarAInsertadosActionPerformed

    private void jButtonPasarAParaInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasarAParaInsertarActionPerformed
        controller.pasarDeEscribirClienteAVer();
    }//GEN-LAST:event_jButtonPasarAParaInsertarActionPerformed

    private void jButtonInsertarTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarTrabajadoresActionPerformed
        controller.InsertarTrabajador();
    }//GEN-LAST:event_jButtonInsertarTrabajadoresActionPerformed

    public JButton getjButtonInsertarTrabajadores() {
        return jButtonInsertarTrabajadores;
    }

    public void setjButtonInsertarTrabajadores(JButton jButtonInsertarTrabajadores) {
        this.jButtonInsertarTrabajadores = jButtonInsertarTrabajadores;
    }

    public JButton getjButtonPasarAInsertados() {
        return jButtonPasarAInsertados;
    }

    public void setjButtonPasarAInsertados(JButton jButtonPasarAInsertados) {
        this.jButtonPasarAInsertados = jButtonPasarAInsertados;
    }

    public JButton getjButtonPasarAParaInsertar() {
        return jButtonPasarAParaInsertar;
    }

    public void setjButtonPasarAParaInsertar(JButton jButtonPasarAParaInsertar) {
        this.jButtonPasarAParaInsertar = jButtonPasarAParaInsertar;
    }

    public JTable getjTableVerClientesInsertados() {
        return jTableVerClientesInsertados;
    }

    public void setjTableVerClientesInsertados(JTable jTableVerClientesInsertados) {
        this.jTableVerClientesInsertados = jTableVerClientesInsertados;
    }

    public JTextField getjTextFieldDNITrabajador() {
        return jTextFieldDNITrabajador;
    }

    public void setjTextFieldDNITrabajador(JTextField jTextFieldDNITrabajador) {
        this.jTextFieldDNITrabajador = jTextFieldDNITrabajador;
    }

    public JTextField getjTextFieldNombreTrabajador() {
        return jTextFieldNombreTrabajador;
    }

    public void setjTextFieldNombreTrabajador(JTextField jTextFieldNombreTrabajador) {
        this.jTextFieldNombreTrabajador = jTextFieldNombreTrabajador;
    }

    public JTextField getjTextFieldOcupacion() {
        return jTextFieldOcupacion;
    }

    public void setjTextFieldOcupacion(JTextField jTextFieldOcupacion) {
        this.jTextFieldOcupacion = jTextFieldOcupacion;
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VistaInsertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInsertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInsertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInsertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaInsertar dialog = new VistaInsertar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertarCliente;
    private javax.swing.JButton jButtonInsertarTrabajadores;
    private javax.swing.JButton jButtonPasarAInsertados;
    private javax.swing.JButton jButtonPasarAParaInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDNICliente;
    private javax.swing.JLabel jLabelInsertarClientes;
    private javax.swing.JLabel jLabelNhabitacion;
    private javax.swing.JLabel jLabelNnoche;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelTrabajadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneInsertar;
    private javax.swing.JTable jTableVerClientesInsertados;
    private javax.swing.JTable jTableVerClientesParaInsertar;
    private javax.swing.JTextField jTextFieldDNICliente;
    private javax.swing.JTextField jTextFieldDNITrabajador;
    private javax.swing.JTextField jTextFieldNhabitacion;
    private javax.swing.JTextField jTextFieldNnoches;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreTrabajador;
    private javax.swing.JTextField jTextFieldOcupacion;
    // End of variables declaration//GEN-END:variables

    public CtrlInsertarClienteYTrabajador getController() {
        return controller;
    }

    public void setController(CtrlInsertarClienteYTrabajador controller) {
        this.controller = controller;
    }

    public javax.swing.JButton getjButtonInsertarCliente() {
        return jButtonInsertarCliente;
    }

    public void setjButtonInsertarCliente(javax.swing.JButton jButtonInsertarCliente) {
        this.jButtonInsertarCliente = jButtonInsertarCliente;
    }

    public javax.swing.JTextField getjTextFieldDNINombe() {
        return jTextFieldDNICliente;
    }

    public JTable getjTableVerClientesParaInsertar() {
        return jTableVerClientesParaInsertar;
    }

    public void setjTableVerClientesParaInsertar(JTable jTableVerClientesParaInsertar) {
        this.jTableVerClientesParaInsertar = jTableVerClientesParaInsertar;
    }

    public void setjTextFieldDNI(javax.swing.JTextField jTextFieldDNI) {
        this.jTextFieldDNICliente = jTextFieldDNI;
    }

    public javax.swing.JTextField getjTextFieldNhabitacion() {
        return jTextFieldNhabitacion;
    }

    public void setjTextFieldNhabitacion(javax.swing.JTextField jTextFieldNhabitacion) {
        this.jTextFieldNhabitacion = jTextFieldNhabitacion;
    }

    public javax.swing.JTextField getjTextFieldNnoches() {
        return jTextFieldNnoches;
    }

    public void setjTextFieldNnoches(javax.swing.JTextField jTextFieldNnoches) {
        this.jTextFieldNnoches = jTextFieldNnoches;
    }

    public javax.swing.JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    public void setjTextFieldNombre(javax.swing.JTextField jTextFieldNombre) {
        this.jTextFieldNombre = jTextFieldNombre;
    }
}
