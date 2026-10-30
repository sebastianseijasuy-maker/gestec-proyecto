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
import uy.edu.gestec.persistencia.RecursoTecnologicoDAO;
import uy.edu.gestec.persistencia.IncidenciaDAO;
/**
 *
 * @author jjaam
 */
public class RegistrarIncidencia extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarIncidencia
     */
    public RegistrarIncidencia() {
        initComponents();

        setTitle("GESTEC - Registrar incidencia");
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );
        tablaRecursos.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION
);

tablaRecursos.setDefaultEditor(Object.class, null);
    }
private final List<RecursoTecnologico> recursosEncontrados
        = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecursos = new javax.swing.JTable();
        btnRegistrarIncidencia = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoIncidencia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Registrar Incidencia");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

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
                "Código", "Recurso", "Condición"
            }
        ));
        jScrollPane1.setViewportView(tablaRecursos);

        btnRegistrarIncidencia.setText("Registrar Incidencia");
        btnRegistrarIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIncidenciaActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel1.setText("Buscar Recurso");

        jLabel2.setText("Descripción de la incidencia");

        cmbTipoIncidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Software", "Hardware", "Conectividad", "Otro" }));

        jLabel3.setText("Tipo de Incidencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(lblTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnRegistrarIncidencia)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver))
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarIncidencia)
                    .addComponent(btnVolver)
                    .addComponent(cmbTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
String busqueda = txtBuscar.getText().trim();

// Validar que se haya ingresado una búsqueda
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

DefaultTableModel modelo =
        (DefaultTableModel) tablaRecursos.getModel();

modelo.setRowCount(0);

// Buscar recursos en MySQL
RecursoTecnologicoDAO dao =
        new RecursoTecnologicoDAO();

try {
    List<RecursoTecnologico> recursos =
            dao.buscarParaMantenimiento(busqueda);

    recursosEncontrados.addAll(recursos);

    // Mostrar los recursos encontrados
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

    private void btnRegistrarIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIncidenciaActionPerformed
        
int filaSeleccionada = tablaRecursos.getSelectedRow();

// Verificar que haya un recurso seleccionado
if (filaSeleccionada == -1) {
    JOptionPane.showMessageDialog(
            this,
            "Debe seleccionar un recurso de la tabla.",
            "Dato requerido",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Obtener la fila correspondiente del modelo
int filaModelo = tablaRecursos.convertRowIndexToModel(
        filaSeleccionada
);

// Obtener el recurso seleccionado
RecursoTecnologico recurso =
        recursosEncontrados.get(filaModelo);
 // Obtener el tipo de incidencia
String tipoIncidencia =
        (String) cmbTipoIncidencia.getSelectedItem();

if (tipoIncidencia == null
        || tipoIncidencia.trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Debe seleccionar el tipo de incidencia.",
            "Dato requerido",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Obtener la descripción
String descripcion = txtDescripcion.getText().trim();

if (descripcion.isEmpty()) {
    JOptionPane.showMessageDialog(
            this,
            "Debe escribir la descripción de la incidencia.",
            "Dato requerido",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Confirmar el registro
int confirmacion = JOptionPane.showConfirmDialog(
        this,
        "¿Desea registrar la incidencia del recurso:\n"
                + recurso.getNombre()
                + "\nCódigo: " + recurso.getCodigoInv()
                + "\nTipo: " + tipoIncidencia + "?",
        "Confirmar incidencia",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
);

if (confirmacion != JOptionPane.YES_OPTION) {
    return;
}

// Guardar en MySQL
IncidenciaDAO dao = new IncidenciaDAO();

boolean registrado = dao.registrarIncidencia(
        recurso.getIdRecurso(),
        tipoIncidencia,
        descripcion
);

if (registrado) {

    JOptionPane.showMessageDialog(
            this,
            "Incidencia registrada correctamente.",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE
    );

    // Limpiar el formulario
    txtBuscar.setText("");
    txtDescripcion.setText("");
    tablaRecursos.clearSelection();

    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel)
            tablaRecursos.getModel();

    modelo.setRowCount(0);
    recursosEncontrados.clear();

    cmbTipoIncidencia.setSelectedIndex(0);

} else {

    JOptionPane.showMessageDialog(
            this,
            "No se pudo registrar la incidencia.",
            "Error",
            JOptionPane.ERROR_MESSAGE
    );
}

    }//GEN-LAST:event_btnRegistrarIncidenciaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
          
    this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarIncidencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrarIncidencia;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbTipoIncidencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
