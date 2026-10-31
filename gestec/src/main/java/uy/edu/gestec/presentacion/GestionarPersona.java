/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.edu.gestec.presentacion;

import uy.edu.gestec.negocio.GestionPersonaHabilitada;
import javax.swing.JOptionPane;
import uy.edu.gestec.negocio.PersonaHabilitada;

/**
 *
 * @author Agustín y Sebastian
 */
public class GestionarPersona extends javax.swing.JFrame {

    private PersonaHabilitada personaSeleccionada;

    /**
     * Constructor GestionarPersona
     */
    public GestionarPersona() {
        initComponents();

        restringirCampo(txtNombre, "[\\p{L} ]*");
        restringirCampo(txtApellido, "[\\p{L} ]*");
        restringirCampo(txtTelefono, "[0-9]*");
        restringirCampo(txtDocumento, "[0-9]*");

        setTitle("GESTEC - Gestionar personas");
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );

        ((javax.swing.text.AbstractDocument) txtTipoPersona.getDocument()).setDocumentFilter(
                new javax.swing.text.DocumentFilter() {

            @Override
            public void insertString(FilterBypass fb, int offset,
                    String texto, javax.swing.text.AttributeSet attrs)
                    throws javax.swing.text.BadLocationException {

                if (texto != null && texto.matches("[\\p{L} ]*")) {
                    super.insertString(fb, offset, texto, attrs);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset,
                    int length, String texto,
                    javax.swing.text.AttributeSet attrs)
                    throws javax.swing.text.BadLocationException {

                if (texto == null || texto.matches("[\\p{L} ]*")) {
                    super.replace(fb, offset, length, texto, attrs);
                }
            }
        }
        );

    }

    private void restringirCampo(
            javax.swing.JTextField campo, String patron) {

        javax.swing.text.AbstractDocument documento
                = (javax.swing.text.AbstractDocument) campo.getDocument();

        documento.setDocumentFilter(
                new javax.swing.text.DocumentFilter() {

            @Override
            public void insertString(
                    FilterBypass fb,
                    int offset,
                    String texto,
                    javax.swing.text.AttributeSet attrs)
                    throws javax.swing.text.BadLocationException {

                replace(fb, offset, 0, texto, attrs);
            }

            @Override
            public void replace(
                    FilterBypass fb,
                    int offset,
                    int length,
                    String texto,
                    javax.swing.text.AttributeSet attrs)
                    throws javax.swing.text.BadLocationException {

                String actual = fb.getDocument().getText(
                        0, fb.getDocument().getLength());

                String nuevoTexto = texto == null ? "" : texto;

                String resultado
                        = actual.substring(0, offset)
                        + nuevoTexto
                        + actual.substring(offset + length);

                if (resultado.matches(patron)) {
                    super.replace(fb, offset, length, nuevoTexto, attrs);
                }
            }
        }
        );
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTipoPersona = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDarBaja = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtTipoPersona = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarPoites = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 247, 250));

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 55, 96));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestionar Personas");

        lblDocumento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDocumento.setForeground(new java.awt.Color(12, 55, 96));
        lblDocumento.setText("Documento");

        lblNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(12, 55, 96));
        lblNombre.setText("Nombre");

        lblApellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(12, 55, 96));
        lblApellido.setText("Apellido");

        lblTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(12, 55, 96));
        lblTelefono.setText("Teléfono");

        lblTipoPersona.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTipoPersona.setForeground(new java.awt.Color(12, 55, 96));
        lblTipoPersona.setText("Tipo Persona");

        btnBuscar.setBackground(new java.awt.Color(15, 126, 190));
        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(15, 126, 190));
        btnRegistrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(15, 126, 190));
        btnModificar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDarBaja.setBackground(new java.awt.Color(15, 126, 190));
        btnDarBaja.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnDarBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnDarBaja.setText("Dar de baja");
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(15, 126, 190));
        btnVolver.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2026-09-23 081438.png"))); // NOI18N

        btnRegistrarPoites.setBackground(new java.awt.Color(15, 126, 190));
        btnRegistrarPoites.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrarPoites.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPoites.setText("Registrar POITES");
        btnRegistrarPoites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPoitesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitulo)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDarBaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                .addComponent(lblTipoPersona)
                                                .addComponent(txtTipoPersona, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRegistrarPoites, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblApellido))))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoPersona)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarPoites, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(btnVolver)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        


    if (personaSeleccionada == null) {
        JOptionPane.showMessageDialog(
                this,
                "Primero debe buscar una persona."
        );
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Desea dar de baja a la persona "
            + personaSeleccionada.getNombre() + " "
            + personaSeleccionada.getApellido() + "?",
            "Confirmar baja",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (confirmacion != JOptionPane.YES_OPTION) {
        return;
    }

    GestionPersonaHabilitada gestion =
            new GestionPersonaHabilitada();

    String resultado = gestion.darDeBajaPersona(
            personaSeleccionada,
            txtDocumento.getText()
    );

    if ("OK".equals(resultado)) {

        String mensaje =
                "Persona encontrada correctamente y dada de baja.\n\n"
                + "DATOS DE LA PERSONA\n"
                + "Documento: " + personaSeleccionada.getDocumento() + "\n"
                + "Nombre: " + personaSeleccionada.getNombre() + "\n"
                + "Apellido: " + personaSeleccionada.getApellido() + "\n"
                + "Teléfono: " + personaSeleccionada.getTelefono() + "\n"
                + "Tipo de persona: " + personaSeleccionada.getTipoPersona();

        limpiarFormulario();

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Baja realizada correctamente",
                JOptionPane.INFORMATION_MESSAGE
        );

    } else {

        JOptionPane.showMessageDialog(
                this,
                resultado,
                "Baja no realizada",
                JOptionPane.WARNING_MESSAGE
        );
    }

    }//GEN-LAST:event_btnDarBajaActionPerformed

    
private void limpiarFormulario() {

    txtDocumento.setText("");
    txtNombre.setText("");
    txtApellido.setText("");
    txtTelefono.setText("");
    txtTipoPersona.setText("");

    personaSeleccionada = null;

    txtDocumento.requestFocusInWindow();
}

    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        
    GestionPersonaHabilitada gestion =
            new GestionPersonaHabilitada();

    String resultado = gestion.registrarPersona(
            txtDocumento.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtTelefono.getText(),
            txtTipoPersona.getText()
    );

    if ("OK".equals(resultado)) {

        JOptionPane.showMessageDialog(
                this,
                "Persona registrada correctamente.",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );

        limpiarFormulario();

    } else {

        JOptionPane.showMessageDialog(
                this,
                resultado,
                "Registro no realizado",
                JOptionPane.WARNING_MESSAGE
        );
    }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        personaSeleccionada = null;
        String documento = txtDocumento.getText().trim();

// Validar que se haya ingresado un documento
        if (documento.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar un número de documento.",
                    "Dato requerido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

// Limpiar los datos de una búsqueda anterior
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtTipoPersona.setText("");

// Buscar la persona en MySQL
GestionPersonaHabilitada gestionPersona
        = new GestionPersonaHabilitada();

PersonaHabilitada persona
        = gestionPersona.buscarPorDocumento(documento);

// Verificar si existe
        if (persona == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró una persona con ese documento.",
                    "Persona no encontrada",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        
personaSeleccionada = persona;


// Mostrar los datos de la persona
        txtNombre.setText(persona.getNombre());
        txtApellido.setText(persona.getApellido());
        txtTelefono.setText(persona.getTelefono());
        txtTipoPersona.setText(persona.getTipoPersona());

// Comprobar si la persona está dada de baja
        if (persona.getBajaLogica()) {

            // Preparar el mensaje con los datos de la persona
    String mensaje = "La persona fue encontrada, pero está dada de baja.\n\n"
            + "DATOS DE LA PERSONA\n"
            + "Documento: " + persona.getDocumento() + "\n"
            + "Nombre: " + persona.getNombre() + "\n"
            + "Apellido: " + persona.getApellido() + "\n"
            + "Teléfono: " + persona.getTelefono() + "\n"
            + "Tipo de persona: " + persona.getTipoPersona();

    // Limpiar todos los campos
    txtDocumento.setText("");
    txtNombre.setText("");
    txtApellido.setText("");
    txtTelefono.setText("");
    txtTipoPersona.setText("");

    // Quitar la persona seleccionada
    personaSeleccionada = null;

    // Mostrar el mensaje con los datos
    JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Persona inhabilitada",
            JOptionPane.WARNING_MESSAGE
    );

    txtDocumento.requestFocusInWindow();
        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Persona encontrada correctamente.",
                    "Consulta exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       


    if (personaSeleccionada == null) {
        JOptionPane.showMessageDialog(
                this,
                "Primero debe buscar una persona."
        );
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Desea guardar los cambios de esta persona?",
            "Confirmar modificación",
            JOptionPane.YES_NO_OPTION
    );

    if (confirmacion != JOptionPane.YES_OPTION) {
        return;
    }

    GestionPersonaHabilitada gestion =
            new GestionPersonaHabilitada();

    String resultado = gestion.modificarPersona(
            personaSeleccionada,
            txtDocumento.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtTelefono.getText(),
            txtTipoPersona.getText()
    );

    if ("OK".equals(resultado)) {

        JOptionPane.showMessageDialog(
                this,
                "Persona modificada correctamente.",
                "Operación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        limpiarFormulario();

    } else {

        JOptionPane.showMessageDialog(
                this,
                resultado,
                "Modificación no realizada",
                JOptionPane.WARNING_MESSAGE
        );
    }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarPoitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPoitesActionPerformed
        RegistrarUsuario ventana = new RegistrarUsuario();
        ventana.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarPoitesActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarPoites;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoPersona;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoPersona;
    // End of variables declaration//GEN-END:variables
}
