/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.edu.gestec.presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import uy.edu.gestec.negocio.RecursoTecnologico;
import uy.edu.gestec.persistencia.RecursoTecnologicoDAO;
import java.util.ArrayList;
import java.util.List;
import uy.edu.gestec.persistencia.MantenimientoDAO;

/**
 *
 * @author sseba
 */
public class RegistrarMantenimiento extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarMantenimiento
     */
    public RegistrarMantenimiento() {
        initComponents();
                setTitle("GESTEC - Registrar Mantenimiento");

        tablaRecursos.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        tablaRecursos.setDefaultEditor(Object.class, null);
        
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecursos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cmbCondicionFinal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 247, 250));

        jLabel1.setBackground(new java.awt.Color(245, 247, 250));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(12, 55, 96));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Mantenimiento");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2026-09-23 081438.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(15, 55, 96));
        jLabel3.setText("Buscar un recurso");

        btnBuscar.setBackground(new java.awt.Color(15, 126, 190));
        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Recurso", "Condición"
            }
        ));
        jScrollPane1.setViewportView(tablaRecursos);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(15, 55, 96));
        jLabel4.setText("Detalle de mantenimiento");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane2.setViewportView(txtDetalle);

        jButton2.setBackground(new java.awt.Color(15, 126, 190));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");

        jButton3.setBackground(new java.awt.Color(15, 126, 190));
        jButton3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Registrar mantenimiento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 55, 96));
        jLabel5.setText("Condición después del mantenimiento");

        cmbCondicionFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "operativo", "en reparacion" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCondicionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)))
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cmbCondicionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List<RecursoTecnologico> recursosEncontrados = new ArrayList<>();

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String busqueda = txtBuscar.getText().trim();

        DefaultTableModel modelo
                = (DefaultTableModel) tablaRecursos.getModel();

        modelo.setRowCount(0);
        recursosEncontrados.clear();

        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un nombre o código de recurso.");
            return;
        }

        RecursoTecnologicoDAO dao = new RecursoTecnologicoDAO();

        try {
            List<RecursoTecnologico> recursos
                    = dao.buscarParaMantenimiento(busqueda);
            recursosEncontrados.addAll(recursos);

            for (RecursoTecnologico recurso : recursos) {

                modelo.addRow(new Object[]{
                    recurso.getCodigoInv(),
                    recurso.getNombre(),
                    recurso.getCondicion()
                });
            }

            if (recursos.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No se encontraron recursos.");
            }

        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo realizar la búsqueda de recursos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int filaSeleccionada = tablaRecursos.getSelectedRow();

        // Verificar que se haya seleccionado un recurso
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un recurso de la tabla.");
            return;
        }

        String detalle = txtDetalle.getText().trim();

        // Verificar que se haya escrito el detalle
        if (detalle.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar el detalle del mantenimiento.");
            return;
        }

        // Obtener la posición real dentro del modelo
        int filaModelo = tablaRecursos.convertRowIndexToModel(
                filaSeleccionada);

        RecursoTecnologico recurso
                = recursosEncontrados.get(filaModelo);

        // Confirmar el registro
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea registrar el mantenimiento del recurso:\n"
                + recurso.getNombre() + "?",
                "Confirmar mantenimiento",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        // Guardar en la base de datos
        MantenimientoDAO dao = new MantenimientoDAO();


String condicionFinal =
        cmbCondicionFinal.getSelectedItem().toString();

boolean registrado = dao.registrarMantenimiento(
        recurso.getIdRecurso(),
        detalle,
        condicionFinal
);

        if (registrado) {

            JOptionPane.showMessageDialog(this,
                    "Mantenimiento registrado correctamente.");

            txtDetalle.setText("");
            tablaRecursos.clearSelection();

        } else {

            JOptionPane.showMessageDialog(this,
                    "No se pudo registrar el mantenimiento.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbCondicionFinal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}
