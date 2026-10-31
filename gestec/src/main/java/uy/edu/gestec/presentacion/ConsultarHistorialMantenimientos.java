/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.edu.gestec.presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import uy.edu.gestec.negocio.RecursoTecnologico;
import uy.edu.gestec.negocio.ServicioRecursoTecnologico;
import uy.edu.gestec.negocio.Mantenimiento;
import uy.edu.gestec.negocio.ServicioMantenimiento;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jjaam
 */
public class ConsultarHistorialMantenimientos extends javax.swing.JFrame {

    /**
     * Método constructor
     */
    public ConsultarHistorialMantenimientos() {
        initComponents();

        tablaRecursos.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        tablaRecursos.setDefaultEditor(Object.class, null);
        tablaHistorial.setDefaultEditor(Object.class, null);

        setTitle("GESTEC - Historial de mantenimientos");
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );
    }

    private final List<RecursoTecnologico> recursosEncontrados
            = new ArrayList<>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRecursos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 55, 96));
        lblTitulo.setText("Historial de mantenimiento");

        lblBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(12, 55, 96));
        lblBuscar.setText("\tBuscar recurso");

        btnBuscar.setBackground(new java.awt.Color(15, 126, 190));
        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(15, 126, 190));
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar Historial");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tablaHistorial.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Fecha", "Detalle técnico"
            }
        ));
        jScrollPane1.setViewportView(tablaHistorial);

        tablaRecursos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Recurso", "Condición"
            }
        ));
        jScrollPane2.setViewportView(tablaRecursos);

        btnVolver.setBackground(new java.awt.Color(15, 126, 190));
        btnVolver.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(12, 55, 96));
        jLabel1.setText("Selleccione recurso");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(12, 55, 96));
        jLabel2.setText("Mantenimientos realizados");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2026-09-23 081438.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(btnVolver))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnConsultar))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitulo)
                                .addGap(0, 110, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        int filaSeleccionada = tablaRecursos.getSelectedRow();

// Verificar que se haya seleccionado un recurso
        if (filaSeleccionada == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un recurso de la tabla.",
                    "Dato requerido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int filaModelo = tablaRecursos.convertRowIndexToModel(
                filaSeleccionada
        );

        RecursoTecnologico recurso
                = recursosEncontrados.get(filaModelo);

        ServicioMantenimiento gestion = new ServicioMantenimiento();

        List<Mantenimiento> mantenimientos
                = gestion.consultarPorRecurso(recurso.getIdRecurso());

        DefaultTableModel modelo
                = (DefaultTableModel) tablaHistorial.getModel();

        modelo.setRowCount(0);

        DateTimeFormatter formatoFecha
                = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Mantenimiento mantenimiento : mantenimientos) {

            modelo.addRow(new Object[]{
                mantenimiento.getIdMantenimiento(),
                mantenimiento.getFechaInicio().format(formatoFecha),
                mantenimiento.getDetalletecnico()
            });
        }

        if (mantenimientos.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron mantenimientos registrados "
                    + "para el recurso seleccionado.",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String busqueda = txtBuscar.getText().trim();

// Validar que se ingrese un dato
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el nombre o código del recurso.",
                    "Dato requerido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

// Limpiar resultados anteriores
        recursosEncontrados.clear();

        DefaultTableModel modelo
                = (DefaultTableModel) tablaRecursos.getModel();

        modelo.setRowCount(0);

// Limpiar también el historial anterior
        DefaultTableModel modeloHistorial
                = (DefaultTableModel) tablaHistorial.getModel();

        modeloHistorial.setRowCount(0);

// Consultar los recursos en MySQL
ServicioRecursoTecnologico servicio
        = new ServicioRecursoTecnologico();

        try {

            List<RecursoTecnologico> recursos
                    = servicio.buscarParaMantenimiento(busqueda);

            recursosEncontrados.addAll(recursos);

            for (RecursoTecnologico recurso : recursos) {

                modelo.addRow(new Object[]{
                    recurso.getCodigoInv(),
                    recurso.getNombre(),
                    recurso.getCondicion()
                });
            }

            if (recursos.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontraron recursos.",
                        "Sin resultados",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (IllegalStateException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo realizar la búsqueda de recursos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GestionMantenimiento ventana = new GestionMantenimiento();
        ventana.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarHistorialMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarHistorialMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarHistorialMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarHistorialMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarHistorialMantenimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
