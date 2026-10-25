/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.edu.gestec.presentacion;

import uy.edu.gestec.persistencia.PersonaHabilitadaDAO;
import uy.edu.gestec.negocio.PersonaHabilitada;
import uy.edu.gestec.negocio.Persona;
import uy.edu.gestec.persistencia.RecursoTecnologicoDAO;
import uy.edu.gestec.negocio.RecursoTecnologico;
import uy.edu.gestec.persistencia.PrestamoDAO;
import uy.edu.gestec.negocio.Prestamo;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import uy.edu.gestec.negocio.PersonaHabilitada;
import uy.edu.gestec.negocio.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Sebastian Seijas
 * @author Agustin Morales
 */
public class ConsultarPrestamos extends javax.swing.JFrame {

    private RecursoTecnologico recursoSeleccionado;
    private List<RecursoTecnologico> recursosSeleccionados = new ArrayList<>();
    private RecursoTecnologico recursoNuevo;

    /**
     * Creates new form RegistrarPrestamo
     */
    public ConsultarPrestamos() {
        initComponents();
        jTable1.setDefaultRenderer(
    Object.class,
    new javax.swing.table.DefaultTableCellRenderer() {

        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            java.awt.Component componente =
                    super.getTableCellRendererComponent(
                            table, value, isSelected,
                            hasFocus, row, column
                    );

            int filaModelo = table.convertRowIndexToModel(row);

            Object fechaObj = table.getModel()
                    .getValueAt(filaModelo, 3);

            Object estadoObj = table.getModel()
                    .getValueAt(filaModelo, 4);

            String fechaTexto = fechaObj == null
                    ? "" : fechaObj.toString();

            String estado = estadoObj == null
                    ? "" : estadoObj.toString();

            boolean vencido = false;

            try {
                java.time.LocalDate fechaPrevista =
                        java.time.LocalDateTime.parse(
                                fechaTexto,
                                java.time.format.DateTimeFormatter
                                        .ofPattern("dd/MM/yyyy HH:mm")
                        ).toLocalDate();

                vencido = fechaPrevista.isBefore(
                        java.time.LocalDate.now()
                ) && !estado.equalsIgnoreCase("Devuelto");

            } catch (Exception e) {
                // Si no hay fecha válida, no se marca.
            }

            if (!isSelected) {
                if (vencido) {
                    componente.setBackground(
                            new java.awt.Color(255, 220, 220)
                    );
                    componente.setForeground(
                            new java.awt.Color(150, 0, 0)
                    );
                } else {
                    componente.setBackground(java.awt.Color.WHITE);
                    componente.setForeground(java.awt.Color.BLACK);
                }
            }

            return componente;
        }
    }
);
        



        
        jPanel1.setFocusable(true);
        jTextField3.setText(
                "Ingrese número de préstamo, nombre o documento"
        );
        jTextField3.setForeground(new java.awt.Color(153, 153, 153));

        jTable1.setRowSelectionAllowed(true);
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("GESTEC - Consultar prestamos");

        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );

        ((javax.swing.table.DefaultTableModel) jTable1.getModel()).setRowCount(0);
        javax.swing.SwingUtilities.invokeLater(() -> {
            jPanel1.requestFocusInWindow();
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 247, 250));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(12, 55, 96));
        jLabel1.setText("Consultar Prestamos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2026-09-23 081438.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jTextField3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 160, 170)));
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(15, 126, 190));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(12, 55, 96));
        jLabel8.setText("Buscar prestamos");

        jButton5.setBackground(new java.awt.Color(15, 126, 190));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(15, 126, 190));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Registrar devolución");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(12, 55, 96));
        jLabel9.setText("Estado");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendientes", "Devueltos" }));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° de préstamo", "Persona", "Fecha entrega", "Fecha Prev. devolución", "Estado"
            }
        ));
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(242, 242, 242)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String busqueda = jTextField3.getText().trim();

        String filtroEstado = jComboBox4.getSelectedItem().toString();

// Si todavía aparece el texto de ejemplo, buscar todos
        if (busqueda.equalsIgnoreCase(
                "Ingrese número de préstamo, nombre o documento")) {
            busqueda = "";
        }

// Consultar los préstamos en la base de datos
        PrestamoDAO prestamoDAO = new PrestamoDAO();

        List<Prestamo> prestamos
                = prestamoDAO.consultarPrestamos(busqueda, filtroEstado);

// Obtener el modelo de la tabla
        javax.swing.table.DefaultTableModel modelo
                = (javax.swing.table.DefaultTableModel) jTable1.getModel();

// Eliminar los resultados anteriores
        modelo.setRowCount(0);

// Formato de las fechas
        DateTimeFormatter formato
                = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Recorrer los préstamos encontrados
        for (Prestamo prestamo : prestamos) {

            String persona
                    = prestamo.getPersona().getNombre() + " "
                    + prestamo.getPersona().getApellido();

            String fechaEntrega = prestamo.getFechaEntrega() != null
                    ? prestamo.getFechaEntrega().format(formato)
                    : "-";

            String fechaPrevista = prestamo.getFechaPrevDev() != null
                    ? prestamo.getFechaPrevDev().format(formato)
                    : "-";

            String estado = prestamo.getEstadoPrestamo();

            // Agregar una fila a la tabla
            modelo.addRow(new Object[]{
                prestamo.getIdPrestamo(),
                persona,
                fechaEntrega,
                fechaPrevista,
                estado
            });
        }

// Informar si no se encontraron resultados
        if (prestamos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron préstamos con esos criterios."
            );
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un préstamo de la tabla."
            );
            return;
        }

// Obtener el número del préstamo seleccionado
        int filaModelo = jTable1.convertRowIndexToModel(fila);

        int idPrestamo = Integer.parseInt(
                jTable1.getModel().getValueAt(filaModelo, 0).toString()
        );

        RegistrarDevolucion ventana = new RegistrarDevolucion(idPrestamo);

        ventana.setVisible(true);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        if (jTextField3.getText().trim().equals(
                "Ingrese número de préstamo, nombre o documento")) {

            jTextField3.setText("");
            jTextField3.setForeground(java.awt.Color.BLACK);
        }      // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        if (jTextField3.getText().trim().isEmpty()) {
            jTextField3.setText(
                    "Ingrese número de préstamo, nombre o documento"
            );
            jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
