/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modulos;

import Logica.LogicaCompleta;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Album extends javax.swing.JFrame {
    
    private LogicaCompleta L;
    private Funcionalidades F;

    
    LogicaCompleta.NodoMatriz seleccion1 = null;
    LogicaCompleta.NodoMatriz seleccion2 = null;
    
    public Album(LogicaCompleta L, Funcionalidades F) {
        
        initComponents();
        this.L = L;
        this.F = F;

        setLocationRelativeTo(null);

        if (this.L.inicio == null) {
            this.L.crearMatriz(4, 6);
        }

        this.L.cargarAlbum("album.txt");
        mostrarAlbum();
    
    }
    
    public void mostrarAlbum() {
        panelAlbum.removeAll();
        panelAlbum.setLayout(new GridLayout(4, 6, 5, 5));

        LogicaCompleta.NodoMatriz fila = L.inicio;

        while (fila != null) {
            LogicaCompleta.NodoMatriz col = fila;

            while (col != null) {
                JPanel celda = new JPanel();
                celda.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                LogicaCompleta.NodoMatriz nodoActual = col;

                if (col == seleccion1 || col == seleccion2) {
                    celda.setBackground(Color.YELLOW);

                    if (col.dato == null) {
                        celda.add(new JLabel("Vacía"));
                    } else {
                        celda.setLayout(new GridLayout(3, 1));
                        celda.add(new JLabel(col.dato.nombre));
                        celda.add(new JLabel(col.dato.tipo));
                        celda.add(new JLabel(col.dato.rareza));
                    }

                } else if (col.dato == null) {
                    celda.setBackground(Color.LIGHT_GRAY);
                    celda.add(new JLabel("Vacía"));

                } else {
                    celda.setLayout(new GridLayout(3, 1));
                    celda.add(new JLabel(col.dato.nombre));
                    celda.add(new JLabel(col.dato.tipo));
                    celda.add(new JLabel(col.dato.rareza));
                }

                celda.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {

                        if (seleccion1 == null) {
                            seleccion1 = nodoActual;
                        } else if (seleccion2 == null) {
                            seleccion2 = nodoActual;
                        }

                        String s1 = (seleccion1 != null && seleccion1.dato != null)
                                ? seleccion1.dato.nombre : "Vacía";
                        String s2 = (seleccion2 != null && seleccion2.dato != null)
                                ? seleccion2.dato.nombre : "Vacía";

                        lblSeleccion.setText("1: " + s1 + " | 2: " + s2);

                        mostrarAlbum();
                    }
                });

                panelAlbum.add(celda);
                col = col.derecha;
            }

            fila = fila.abajo;
        }

        panelAlbum.revalidate();
        panelAlbum.repaint();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        lblSeleccion = new javax.swing.JLabel();
        btnIntercambiar = new javax.swing.JButton();
        panelAlbum = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarCarta = new javax.swing.JButton();
        txtVida = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtRareza = new javax.swing.JTextField();
        txtAtaque = new javax.swing.JTextField();
        txtDefensa = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        lblSeleccion.setText("Selección: ninguna");

        btnIntercambiar.setText("Intercambiar");
        btnIntercambiar.addActionListener(this::btnIntercambiarActionPerformed);

        panelAlbum.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelAlbumLayout = new javax.swing.GroupLayout(panelAlbum);
        panelAlbum.setLayout(panelAlbumLayout);
        panelAlbumLayout.setHorizontalGroup(
            panelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        panelAlbumLayout.setVerticalGroup(
            panelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Tipo");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Rareza");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Ataquer");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Defensa");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Vida");

        btnAgregarCarta.setText("Agregar Carta");
        btnAgregarCarta.addActionListener(this::btnAgregarCartaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRareza, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                            .addComponent(txtAtaque)
                                            .addComponent(txtDefensa)
                                            .addComponent(txtVida))
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                        .addComponent(txtNombre))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregarCarta))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(67, 67, 67)
                                    .addComponent(btnIntercambiar))))))
                .addGap(32, 56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtRareza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCarta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccion)
                    .addComponent(btnIntercambiar))
                .addGap(18, 18, 18)
                .addComponent(panelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        L.guardarAlbum("album.txt");
        F.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnIntercambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntercambiarActionPerformed
        
        if (seleccion1 != null && seleccion2 != null) {

        L.intercambiar(seleccion1, seleccion2);

        seleccion1 = null;
        seleccion2 = null;

        lblSeleccion.setText("Selección: ninguna");

        mostrarAlbum();
        
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona 2 celdas");
        }
        
    }//GEN-LAST:event_btnIntercambiarActionPerformed

    private void btnAgregarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCartaActionPerformed
        
        try {
            LogicaCompleta.Carta nueva = L.new Carta(
                txtCodigo.getText(),
                txtNombre.getText(),
                txtTipo.getText(),
            txtRareza.getText(),
            Integer.parseInt(txtAtaque.getText()),
            Integer.parseInt(txtDefensa.getText()),
            Integer.parseInt(txtVida.getText())
        );

            L.agregarCarta(nueva);
            mostrarAlbum();

            txtCodigo.setText("");
            txtNombre.setText("");
            txtTipo.setText("");
            txtRareza.setText("");
            txtAtaque.setText("");
            txtDefensa.setText("");
            txtVida.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos");
        }
        
    }//GEN-LAST:event_btnAgregarCartaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarta;
    private javax.swing.JButton btnIntercambiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JPanel panelAlbum;
    private javax.swing.JTextField txtAtaque;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDefensa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRareza;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtVida;
    // End of variables declaration//GEN-END:variables
}
