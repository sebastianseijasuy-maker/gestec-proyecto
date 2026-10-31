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
import uy.edu.gestec.negocio.Mantenimiento;
import uy.edu.gestec.persistencia.MantenimientoDAO;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTitulo.setText("Historial de mantenimiento");

        lblBuscar.setText("\tBuscar recurso");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar Historial");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

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

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Selleccione recurso");

        jLabel2.setText("Mantenimientos realizados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBuscar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 128, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnConsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

// Obtener la fila correspondiente del modelo
int filaModelo = tablaRecursos.convertRowIndexToModel(
        filaSeleccionada
);

// Obtener el recurso seleccionado
RecursoTecnologico recurso =
        recursosEncontrados.get(filaModelo);

// Consultar sus mantenimientos
MantenimientoDAO dao = new MantenimientoDAO();

List<Mantenimiento> mantenimientos =
        dao.consultarPorRecurso(recurso.getIdRecurso());

// Limpiar la tabla del historial
DefaultTableModel modelo =
        (DefaultTableModel) tablaHistorial.getModel();

modelo.setRowCount(0);

// Formato de fecha y hora
DateTimeFormatter formatoFecha =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Mostrar los mantenimientos encontrados
for (Mantenimiento mantenimiento : mantenimientos) {

    modelo.addRow(new Object[]{
        mantenimiento.getIdMantenimiento(),
        mantenimiento.getFechaInicio().format(formatoFecha),
        mantenimiento.getDetalletecnico()
    });
}

// Informar si no existen mantenimientos
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

DefaultTableModel modelo =
        (DefaultTableModel) tablaRecursos.getModel();

modelo.setRowCount(0);

// Limpiar también el historial anterior
DefaultTableModel modeloHistorial =
        (DefaultTableModel) tablaHistorial.getModel();

modeloHistorial.setRowCount(0);

// Consultar los recursos en MySQL
RecursoTecnologicoDAO dao =
        new RecursoTecnologicoDAO();

try {

    List<RecursoTecnologico> recursos =
            dao.buscarParaMantenimiento(busqueda);

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
