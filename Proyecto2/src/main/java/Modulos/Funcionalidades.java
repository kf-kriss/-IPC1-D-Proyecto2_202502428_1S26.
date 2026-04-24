/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modulos;

import Logica.LogicaCompleta;

public class Funcionalidades extends javax.swing.JFrame {
    
    private LogicaCompleta L;

    public Funcionalidades(LogicaCompleta L) {
        initComponents();
        this.L = L;
        
        setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jTienda = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jTiendaDescripcion = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jAlbum = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jAlbumDescripcion = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jEventos = new javax.swing.JMenu();
        jEventosDescripcion = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jRecompensas = new javax.swing.JMenu();
        jRecompensasDescripcion = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jReportes = new javax.swing.JMenu();
        jReportesDescripcion = new javax.swing.JMenuItem();
        jDatos = new javax.swing.JMenu();
        jDatosDescripcion = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jSalir = new javax.swing.JMenu();
        JSalirDescripcion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTienda.setText("Tienda");
        jTienda.add(jSeparator5);

        jTiendaDescripcion.setText(" Tienda de Videojuegos");
        jTiendaDescripcion.addActionListener(this::jTiendaDescripcionActionPerformed);
        jTienda.add(jTiendaDescripcion);
        jTienda.add(jSeparator7);

        jMenuBar1.add(jTienda);

        jAlbum.setText("Álbum");
        jAlbum.add(jSeparator4);

        jAlbumDescripcion.setText("Álbum de Cartas Coleccionables");
        jAlbumDescripcion.addActionListener(this::jAlbumDescripcionActionPerformed);
        jAlbum.add(jAlbumDescripcion);
        jAlbum.add(jSeparator8);

        jMenuBar1.add(jAlbum);

        jEventos.setText("Eventos");

        jEventosDescripcion.setText("Eventos Especiales (Torneos)");
        jEventosDescripcion.addActionListener(this::jEventosDescripcionActionPerformed);
        jEventos.add(jEventosDescripcion);
        jEventos.add(jSeparator3);

        jMenuBar1.add(jEventos);

        jRecompensas.setText("Recompensas");

        jRecompensasDescripcion.setText("Programa de recompensas y Tablero de Líderes");
        jRecompensasDescripcion.addActionListener(this::jRecompensasDescripcionActionPerformed);
        jRecompensas.add(jRecompensasDescripcion);
        jRecompensas.add(jSeparator2);

        jMenuBar1.add(jRecompensas);

        jReportes.setText("Reportes");

        jReportesDescripcion.setText("Reportes");
        jReportesDescripcion.addActionListener(this::jReportesDescripcionActionPerformed);
        jReportes.add(jReportesDescripcion);

        jMenuBar1.add(jReportes);

        jDatos.setText("Datos");

        jDatosDescripcion.setText("Ver Datos del Estudiante");
        jDatosDescripcion.addActionListener(this::jDatosDescripcionActionPerformed);
        jDatos.add(jDatosDescripcion);
        jDatos.add(jSeparator6);

        jMenuBar1.add(jDatos);

        jSalir.setText("Salir");

        JSalirDescripcion.setText("Salir del Programa");
        JSalirDescripcion.addActionListener(this::JSalirDescripcionActionPerformed);
        jSalir.add(JSalirDescripcion);
        jSalir.add(jSeparator1);

        jMenuBar1.add(jSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTiendaDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTiendaDescripcionActionPerformed
        Tienda T = new Tienda(L, this);
        T.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jTiendaDescripcionActionPerformed

    private void jAlbumDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlbumDescripcionActionPerformed
        Album A = new Album(L, this);
        A.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jAlbumDescripcionActionPerformed

    private void jEventosDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEventosDescripcionActionPerformed
        Eventos E = new Eventos(L, this);
        E.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jEventosDescripcionActionPerformed

    private void jRecompensasDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecompensasDescripcionActionPerformed
        Recompensas R = new Recompensas(L);
        R.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jRecompensasDescripcionActionPerformed

    private void jReportesDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReportesDescripcionActionPerformed
        Reportes R = new Reportes(L);
        R.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jReportesDescripcionActionPerformed

    private void jDatosDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatosDescripcionActionPerformed
        Datos D = new Datos(L);
        D.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_jDatosDescripcionActionPerformed

    private void JSalirDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSalirDescripcionActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_JSalirDescripcionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JSalirDescripcion;
    private javax.swing.JMenu jAlbum;
    private javax.swing.JMenuItem jAlbumDescripcion;
    private javax.swing.JMenu jDatos;
    private javax.swing.JMenuItem jDatosDescripcion;
    private javax.swing.JMenu jEventos;
    private javax.swing.JMenuItem jEventosDescripcion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jRecompensas;
    private javax.swing.JMenuItem jRecompensasDescripcion;
    private javax.swing.JMenu jReportes;
    private javax.swing.JMenuItem jReportesDescripcion;
    private javax.swing.JMenu jSalir;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JMenu jTienda;
    private javax.swing.JMenuItem jTiendaDescripcion;
    // End of variables declaration//GEN-END:variables
}
