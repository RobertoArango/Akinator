/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akinatoranimales.interfaz;

import akinatoranimales.Archivos;
import akinatoranimales.Partida;
import akinatoranimales.estructuras.ArbolDecision;
import akinatoranimales.estructuras.Decision;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dayan
 */
public class Inicio extends javax.swing.JFrame {
    private ArbolDecision baseConocimientos;
    private Partida partida;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
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

        btnAdivinar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextPane();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        btnVaciarBase = new javax.swing.JButton();
        btnCargarBase = new javax.swing.JButton();
        btnGuardarBase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdivinar.setText("Adivinar Animal");
        btnAdivinar.setEnabled(false);
        btnAdivinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdivinarActionPerformed(evt);
            }
        });

        output.setEditable(false);
        output.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(output);

        btnSi.setText("SI");
        btnSi.setEnabled(false);
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        btnNo.setText("NO");
        btnNo.setEnabled(false);
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        btnVaciarBase.setText("Inicializar Base de Conocimientos");
        btnVaciarBase.setEnabled(false);

        btnCargarBase.setText("Cargar Base de Conocimientos");
        btnCargarBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarBaseActionPerformed(evt);
            }
        });

        btnGuardarBase.setText("Guardar Base de Conocimiento");
        btnGuardarBase.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdivinar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVaciarBase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCargarBase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarBase)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdivinar)
                    .addComponent(btnVaciarBase)
                    .addComponent(btnCargarBase)
                    .addComponent(btnGuardarBase))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSi)
                    .addComponent(btnNo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarBaseActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Archivos csv", "csv"));
            chooser.showOpenDialog(this);
            File selectedFile = chooser.getSelectedFile();
            if (selectedFile != null) {
                String contenido = Archivos.cargar(selectedFile.getAbsolutePath());
                setBaseConocimientos(ArbolDecision.desdeCsv(contenido));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error abriendo archivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCargarBaseActionPerformed

    private void btnAdivinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdivinarActionPerformed
        iniciarJuego();
    }//GEN-LAST:event_btnAdivinarActionPerformed

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        imprimirSi();
        emitirRespuesta(Decision.SI);
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        imprimirNo();
        emitirRespuesta(Decision.NO);
    }//GEN-LAST:event_btnNoActionPerformed
    
    private void iniciarJuego() {
        boolean finalizado = false;
        btnSi.setEnabled(true);
        btnNo.setEnabled(true);
        partida = new Partida(baseConocimientos);
        partida.iniciar();
        imprimirNeutro("Partida iniciada!");
        imprimirNeutro(partida.getSiguientePregunta());
    }
    
    private void imprimirSi() {
        imprimir("Si", Color.GREEN);
    }
    
    private void imprimirNo() {
        imprimir("No", Color.RED);
    }
    
    private void imprimirNeutro(String mensaje) {
        imprimir(mensaje, Color.BLACK);
    }
    
    private void imprimir(String mensaje, Color color) {
        String textoActual = output.getText();
        String toPrint = textoActual.replace("</p>", "<span style=\"color: #" + colorAHex(color) + "\">" + mensaje + "</span><br></p>");
        output.setText(toPrint);
    }
    
    public void setBaseConocimientos(ArbolDecision baseConocimientos) {
        this.baseConocimientos = baseConocimientos;
        btnAdivinar.setEnabled(this.baseConocimientos != null);
        btnVaciarBase.setEnabled(this.baseConocimientos != null);
        btnGuardarBase.setEnabled(this.baseConocimientos != null);
    }
    
    private String colorAHex(Color color) {
        return Integer.toHexString(color.getRGB()).substring(2);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdivinar;
    private javax.swing.JButton btnCargarBase;
    private javax.swing.JButton btnGuardarBase;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btnVaciarBase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane output;
    // End of variables declaration//GEN-END:variables

    private void emitirRespuesta(Decision decision) {
        partida.responder(decision);
        if (partida.getFinalizada()) {
            Color color = partida.getVictoria() 
                    ? Color.GREEN
                    : Color.RED;
            String mensajeFin = partida.getVictoria()
                    ? "He adivinado! Mis poderes son inigualables"
                    : "Vaya... parece que he fracasado...";
            imprimir(mensajeFin, color);
            if (!partida.getVictoria()) {
                // iniciarSecuenciaRetroalimentacion();
            }
        } else {
            String siguientePregunta = partida.getSiguientePregunta();
            imprimirNeutro(siguientePregunta);
        }
    }
}