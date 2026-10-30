/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.edu.gestec.presentacion;

import uy.edu.gestec.persistencia.PersonaHabilitadaDAO;
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
            "Primero debe buscar una persona.",
            "Persona no seleccionada",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Verificar si la persona ya fue dada de baja
if (personaSeleccionada.getBajaLogica()) {
    JOptionPane.showMessageDialog(
            this,
            "Esta persona ya se encuentra dada de baja.",
            "Persona inhabilitada",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Verificar que el documento no haya cambiado
if (!txtDocumento.getText().trim().equals(
        personaSeleccionada.getDocumento())) {

    JOptionPane.showMessageDialog(
            this,
            "El documento fue modificado. Debe buscar nuevamente a la persona.",
            "Documento incorrecto",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// Solicitar confirmación antes de dar de baja
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

// Realizar la baja lógica en MySQL
PersonaHabilitadaDAO personaDAO =
        new PersonaHabilitadaDAO();

boolean bajaRealizada = personaDAO.darDeBajaPersona(
        personaSeleccionada.getIdPersonaHab()
);

if (bajaRealizada) {

    
if (bajaRealizada) {

    // Preparar el mensaje con los datos de la persona
    String mensaje = "Persona encontrada correctamente y dada de baja.\n\n"
            + "DATOS DE LA PERSONA\n"
            + "Documento: " + personaSeleccionada.getDocumento() + "\n"
            + "Nombre: " + personaSeleccionada.getNombre() + "\n"
            + "Apellido: " + personaSeleccionada.getApellido() + "\n"
            + "Teléfono: " + personaSeleccionada.getTelefono() + "\n"
            + "Tipo de persona: " + personaSeleccionada.getTipoPersona();

    // Limpiar todos los campos antes de mostrar el mensaje
    txtDocumento.setText("");
    txtNombre.setText("");
    txtApellido.setText("");
    txtTelefono.setText("");
    txtTipoPersona.setText("");

    // Quitar la persona seleccionada
    personaSeleccionada = null;

    // Mostrar la confirmación y los datos
    JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Baja realizada correctamente",
            JOptionPane.INFORMATION_MESSAGE
    );

    // Colocar el cursor en documento
    txtDocumento.requestFocusInWindow();

}

} else {

    JOptionPane.showMessageDialog(
            this,
            "No se pudo dar de baja a la persona.\n"
            + "Puede tener préstamos pendientes de devolución "
            + "o haber ocurrido un error en la base de datos.",
            "Baja no realizada",
            JOptionPane.WARNING_MESSAGE
    );
}

    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        String documento = txtDocumento.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String tipoPersona = txtTipoPersona.getText().trim();

// Verificar que todos los campos estén completos
        if (documento.isEmpty() || nombre.isEmpty()
                || apellido.isEmpty() || telefono.isEmpty()
                || tipoPersona.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

// Validar que el documento contenga solo números
        if (!documento.matches("\\d+")) {

            JOptionPane.showMessageDialog(
                    this,
                    "El documento debe contener solamente números.",
                    "Documento inválido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

// Validar el tipo de persona: solo letras y espacios
        if (!tipoPersona.matches("[\\p{L} ]+")) {

            JOptionPane.showMessageDialog(
                    this,
                    "El tipo de persona debe contener solamente letras.",
                    "Dato inválido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

// Crear el objeto de persistencia
        PersonaHabilitadaDAO personaDAO
                = new PersonaHabilitadaDAO();

// Verificar si la persona ya existe
        if (personaDAO.buscarPorDocumento(documento) != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ya existe una persona habilitada con ese documento.",
                    "Documento duplicado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

// Registrar en MySQL
        boolean registrado = personaDAO.registrarPersona(
                documento,
                nombre,
                apellido,
                telefono,
                tipoPersona
        );

// Comprobar el resultado
        if (registrado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Persona registrada correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Limpiar el formulario
            txtDocumento.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            txtTelefono.setText("");
            txtTipoPersona.setText("");

            txtDocumento.requestFocus();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo registrar la persona. "
                    + "Verifique los datos o la conexión a MySQL.",
                    "Error de registro",
                    JOptionPane.ERROR_MESSAGE
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
        PersonaHabilitadaDAO personaDAO
                = new PersonaHabilitadaDAO();

        PersonaHabilitada persona
                = personaDAO.buscarPorDocumento(documento);

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
            "Primero debe buscar una persona.",
            "Persona no seleccionada",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// No permitir modificar personas dadas de baja
if (personaSeleccionada.getBajaLogica()) {
    JOptionPane.showMessageDialog(
            this,
            "No se puede modificar una persona dada de baja."
    );
    return;
}

// Obtener los datos del formulario
String documento = txtDocumento.getText().trim();
String nombre = txtNombre.getText().trim();
String apellido = txtApellido.getText().trim();
String telefono = txtTelefono.getText().trim();
String tipoPersona = txtTipoPersona.getText().trim();

// Comprobar que el documento no haya cambiado
if (!documento.equals(personaSeleccionada.getDocumento())) {
    JOptionPane.showMessageDialog(
            this,
            "No se puede cambiar el documento durante la modificación."
    );
    return;
}

// Comprobar campos obligatorios
if (nombre.isEmpty() || apellido.isEmpty()
        || telefono.isEmpty() || tipoPersona.isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Debe completar todos los campos."
    );
    return;
}

// Validar los caracteres ingresados
if (!nombre.matches("[\\p{L} ]+")
        || !apellido.matches("[\\p{L} ]+")
        || !tipoPersona.matches("[\\p{L} ]+")
        || !telefono.matches("[0-9]+")) {

    JOptionPane.showMessageDialog(
            this,
            "Verifique los datos ingresados."
    );
    return;
}

// Solicitar confirmación
int confirmacion = JOptionPane.showConfirmDialog(
        this,
        "¿Desea guardar los cambios de esta persona?",
        "Confirmar modificación",
        JOptionPane.YES_NO_OPTION
);

if (confirmacion != JOptionPane.YES_OPTION) {
    return;
}

// Guardar los cambios en MySQL
PersonaHabilitadaDAO personaDAO =
        new PersonaHabilitadaDAO();

boolean modificado = personaDAO.modificarPersona(
        personaSeleccionada.getIdPersona(),
        nombre,
        apellido,
        telefono,
        tipoPersona
);

if (modificado) {

    JOptionPane.showMessageDialog(
            this,
            "Persona modificada correctamente.",
            "Operación exitosa",
            JOptionPane.INFORMATION_MESSAGE
    );
 // Limpiar todos los campos
    txtDocumento.setText("");
    txtNombre.setText("");
    txtApellido.setText("");
    txtTelefono.setText("");
    txtTipoPersona.setText("");

    // Quitar la persona seleccionada
    personaSeleccionada = null;

    // Ubicar el cursor en documento
    txtDocumento.requestFocus();
    // Actualizar la persona seleccionada
    personaSeleccionada =
            personaDAO.buscarPorDocumento(documento);

} else {

    JOptionPane.showMessageDialog(
            this,
            "No se pudo modificar la persona.",
            "Error",
            JOptionPane.ERROR_MESSAGE
    );
}

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        PantallaPrincipal ventana = new PantallaPrincipal();
        ventana.setVisible(true);
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
