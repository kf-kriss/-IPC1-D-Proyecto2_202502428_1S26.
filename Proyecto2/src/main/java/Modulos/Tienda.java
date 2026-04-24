/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modulos;

import Logica.LogicaCompleta;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tienda extends javax.swing.JFrame {
    
    private LogicaCompleta L;
    private Funcionalidades F;


    public Tienda(LogicaCompleta L, Funcionalidades F) {
        initComponents();
        this.L = L;
        this.F = F;

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        L.cargarCatalogo("catalogo.txt");
        actualizarAreas();

        jTextCatalogo.setEditable(false);
        jTextCarrito.setEditable(false);
        jTextHistorial.setEditable(false);
        
    }
    
    private void actualizarAreas() {
        jTextCatalogo.setText(L.mostrarCatalogo());
        jTextCarrito.setText(L.mostrarCarrito() + "\n\nTOTAL: Q" + L.totalCarrito());
        jTextHistorial.setText(L.mostrarHistorial());
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabelCatalogo = new javax.swing.JLabel();
        jLabelCarrito = new javax.swing.JLabel();
        jLabelHistorial = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCatalogo = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextCarrito = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextHistorial = new javax.swing.JTextArea();
        jTextCodigo = new javax.swing.JTextField();
        jTextCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabelCatalogo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        JLabelCatalogo.setText("Catálogo");

        jLabelCarrito.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelCarrito.setText("Carrito");

        jLabelHistorial.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelHistorial.setText("Historial");

        jLabelCantidad.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelCantidad.setText("Cantidad");

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelCodigo.setText("Código");

        jTextCatalogo.setColumns(20);
        jTextCatalogo.setRows(5);
        jScrollPane1.setViewportView(jTextCatalogo);

        jScrollPane4.setViewportView(jScrollPane1);

        jTextCarrito.setColumns(20);
        jTextCarrito.setRows(5);
        jScrollPane2.setViewportView(jTextCarrito);

        jScrollPane5.setViewportView(jScrollPane2);

        jTextHistorial.setColumns(20);
        jTextHistorial.setRows(5);
        jScrollPane3.setViewportView(jTextHistorial);

        jScrollPane6.setViewportView(jScrollPane3);

        btnAgregar.setText("Agregar al Carrito");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnComprar.setText("Confirmar Compra");
        btnComprar.addActionListener(this::btnComprarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelCatalogo)
                    .addComponent(jLabelCarrito)
                    .addComponent(jLabelHistorial)
                    .addComponent(jLabelCantidad)
                    .addComponent(jLabelCodigo)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnComprar)
                            .addComponent(btnAgregar))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabelCatalogo))
                .addGap(19, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCarrito)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelHistorial)
                        .addGap(49, 49, 49)
                        .addComponent(jLabelCodigo)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCantidad)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnComprar)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver)
                        .addGap(52, 52, 52))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        try {
            String codigo = jTextCodigo.getText().trim();
            int cantidad = Integer.parseInt(jTextCantidad.getText().trim());

            boolean agregado = L.agregarAlCarrito(codigo, cantidad);

            if (agregado) {
                JOptionPane.showMessageDialog(this, "Agregado al carrito");
                actualizarAreas();
                jTextCodigo.setText("");
                jTextCantidad.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Código no encontrado o cantidad inválida");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos");
        }
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
    
        boolean compra = L.confirmarCompra();

        if (compra) {
            JOptionPane.showMessageDialog(this, "Compra realizada");
            actualizarAreas();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo comprar. Verifique stock o carrito");
        }
    
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    
        F.setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelCatalogo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCarrito;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelHistorial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextArea jTextCarrito;
    private javax.swing.JTextArea jTextCatalogo;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextArea jTextHistorial;
    // End of variables declaration//GEN-END:variables
}
