/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.edu.gestec.presentacion;

/**
 *
 * @author Agustin y Sebastian
 */
public class MenuPrestamo extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrestamo
     */
    public MenuPrestamo() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 247, 250));

        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("GESTEC - Préstamos");

        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );
    }

    /**
     *
     *
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnRealizarPrestamo = new javax.swing.JButton();
        btnConsultarPrestamos = new javax.swing.JButton();
        btnRegistrarDevolucion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 247, 250));

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 55, 96));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestionar Préstamo");

        btnRealizarPrestamo.setBackground(new java.awt.Color(15, 126, 190));
        btnRealizarPrestamo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRealizarPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarPrestamo.setText("Realizar Préstamo");
        btnRealizarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPrestamoActionPerformed(evt);
            }
        });

        btnConsultarPrestamos.setBackground(new java.awt.Color(15, 126, 190));
        btnConsultarPrestamos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConsultarPrestamos.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarPrestamos.setText("Consultar Préstamos");
        btnConsultarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPrestamosActionPerformed(evt);
            }
        });

        btnRegistrarDevolucion.setBackground(new java.awt.Color(15, 126, 190));
        btnRegistrarDevolucion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrarDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarDevolucion.setText("Registrar Devolución");
        btnRegistrarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDevolucionActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(15, 126, 190));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2026-09-23 081438.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnRegistrarDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultarPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizarPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnRealizarPrestamo)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarPrestamos)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarDevolucion)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRealizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPrestamoActionPerformed

        RegistrarPrestamo ventana = new RegistrarPrestamo();
        ventana.setVisible(true);


    }//GEN-LAST:event_btnRealizarPrestamoActionPerformed

    private void btnConsultarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPrestamosActionPerformed

        ConsultarPrestamos ventana = new ConsultarPrestamos();
        ventana.setVisible(true);

    }//GEN-LAST:event_btnConsultarPrestamosActionPerformed

    private void btnRegistrarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDevolucionActionPerformed

        RegistrarDevolucion ventana = new RegistrarDevolucion();
        ventana.setVisible(true);

    }//GEN-LAST:event_btnRegistrarDevolucionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarPrestamos;
    private javax.swing.JButton btnRealizarPrestamo;
    private javax.swing.JButton btnRegistrarDevolucion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
