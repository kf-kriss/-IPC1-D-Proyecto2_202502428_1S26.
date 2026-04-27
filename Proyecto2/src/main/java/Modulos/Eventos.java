/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modulos;

import Logica.LogicaCompleta;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Eventos extends javax.swing.JFrame {
    
    private LogicaCompleta L;
    private Funcionalidades F;

    public Eventos(LogicaCompleta L, Funcionalidades F) {
        initComponents();
        this.L = L;
        this.F = F;

        setLocationRelativeTo(null);
    }
    
    public void procesarTicket(String taquilla) {
        while (!L.colaTickets.estaVacia()) {
            LogicaCompleta.ClienteTicket cliente = L.colaTickets.desencolar();

            if (cliente != null) {
                if (cliente.torneo.tickets > 0) {
                
                    SwingUtilities.invokeLater(() -> {
                    txtLog.append(taquilla + " atendiendo a " + cliente.nombre + "\n");
                    });

                try {
                    Thread.sleep(800);
                } catch (Exception e) { }

                cliente.torneo.tickets--;
                
                L.aplicarRecompensa(L.new RecompensaEvento());

                L.guardarTicketVendido("tickets_vendidos.txt", cliente, taquilla);
                                                    
                String mensaje = taquilla + " vendió ticket a " + cliente.nombre +
                        " para " + cliente.torneo.nombre + "\n";

                SwingUtilities.invokeLater(() -> {
                    txtLog.append(mensaje);
                    txtCola.setText(L.colaTickets.mostrar());
                    txtTorneos.setText(L.mostrarTorneos());
                });

                } else {
                    SwingUtilities.invokeLater(() -> {
                        txtLog.append("No hay tickets para " + cliente.torneo.nombre + "\n");
                    });
                }
            }
        }

    SwingUtilities.invokeLater(() -> {
        txtLog.append(taquilla + " terminó.\n");

        if (L.colaTickets.estaVacia()) {
            txtLog.append("TODOS LOS TICKETS FUERON PROCESADOS\n");
        }
    });

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtIdTorneo = new javax.swing.JTextField();
        btnCargarTorneos = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTorneos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCola = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCargarTorneos.setText("Cargar Torneos");
        btnCargarTorneos.addActionListener(this::btnCargarTorneosActionPerformed);

        btnInscribir.setText("Inscribirse");
        btnInscribir.addActionListener(this::btnInscribirActionPerformed);

        btnProcesar.setText("Procesar Cola");
        btnProcesar.addActionListener(this::btnProcesarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        txtTorneos.setColumns(20);
        txtTorneos.setRows(5);
        jScrollPane2.setViewportView(txtTorneos);

        txtCola.setColumns(20);
        txtCola.setRows(5);
        jScrollPane3.setViewportView(txtCola);

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        jLabel1.setText("Nombre");

        jLabel2.setText("Id Torneo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdTorneo))
                    .addComponent(btnCargarTorneos)
                    .addComponent(btnInscribir)
                    .addComponent(btnProcesar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txtIdTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btnCargarTorneos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcesar)
                        .addGap(43, 43, 43)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        F.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCargarTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTorneosActionPerformed
       
        L.cargarTorneos("torneos.txt");
        txtTorneos.setText(L.mostrarTorneos());
        
    }//GEN-LAST:event_btnCargarTorneosActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed

        String nombre = txtNombre.getText();
        String id = txtIdTorneo.getText();

        boolean ok = L.inscribirCliente(nombre, id);

        if (ok) {
            txtCola.setText(L.colaTickets.mostrar() + "\nTotal en cola: " + L.colaTickets.size());
            txtNombre.setText("");
            txtIdTorneo.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Datos inválidos o torneo no encontrado");
        }

    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        
        Thread taquilla1 = new Thread(() -> procesarTicket("Taquilla 1"));
        Thread taquilla2 = new Thread(() -> procesarTicket("Taquilla 2"));

        taquilla1.start();
        taquilla2.start();
    
        
    }//GEN-LAST:event_btnProcesarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarTorneos;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtCola;
    private javax.swing.JTextField txtIdTorneo;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtTorneos;
    // End of variables declaration//GEN-END:variables
}
