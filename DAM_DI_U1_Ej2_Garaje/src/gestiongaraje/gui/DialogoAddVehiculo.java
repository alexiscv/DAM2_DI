/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiongaraje.gui;

import gestiongaraje.dto.Camion;
import gestiongaraje.dto.Coche;
import gestiongaraje.dto.Furgoneta;
import gestiongaraje.dto.Vehiculo;
import gestiongaraje.logica.LogicaNegocio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Alexis
 */
public class DialogoAddVehiculo extends javax.swing.JDialog {

    // Creamos un atributo para poder acceder a la pantalla principal
    // desde los métodos de este dialogo
    PantallaPrincipal pantallaPrincipal;

    /**
     * Creates new form AddVehiculo
     */
    public DialogoAddVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanelDetallesCamion.setVisible(false);
        this.pantallaPrincipal = (PantallaPrincipal) parent;

        // Creamos un escuchador para el comboBox
        jComboBoxTipoVehiculo.addActionListener(new ListenerTipoVehiculo());

        // Para la validación
        ValidationGroup grupo = validationPanel.getValidationGroup();
        grupo.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        grupo.add(jTextFieldApellidos, StringValidators.REQUIRE_NON_EMPTY_STRING);
        grupo.add(jTextFieldTlf, StringValidators.REQUIRE_NON_EMPTY_STRING);
        grupo.add(jTextFieldTlf, StringValidators.REQUIRE_VALID_INTEGER);
        grupo.add(jTextFieldTlf, StringValidators.minLength(9));
        grupo.add(jTextFieldTlf, StringValidators.maxLength(9));
        grupo.add(jTextFieldDNI, StringValidators.REQUIRE_NON_EMPTY_STRING);
        grupo.add(jTextFieldDNI, StringValidators.minLength(9));
        grupo.add(jTextFieldDNI, StringValidators.maxLength(9));
        grupo.add(jTextFieldModelo, StringValidators.REQUIRE_NON_EMPTY_STRING);
        grupo.add(jTextFieldMatricula, StringValidators.REQUIRE_NON_EMPTY_STRING);

    }

    /**
     * Listener para detectar cambios en el combobox
     */
    public class ListenerTipoVehiculo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String valor = jComboBoxTipoVehiculo.getSelectedItem().toString();
            if (valor.equals("CAMION")) {
                jPanelDetallesCamion.setVisible(true);
                // Para la validación
                ValidationGroup grupo = validationPanel.getValidationGroup();
                grupo.add(jTextFieldLongitud, StringValidators.REQUIRE_NON_EMPTY_STRING);
            } else {
                jPanelDetallesCamion.setVisible(false);
            }

        }

    }

    /**
     * Para añadir vehiculos
     */
    private void addVehiculo() {
        String nombre = jTextFieldApellidos.getText();
        String apellidos = jTextFieldApellidos.getText();
        String telefono = jTextFieldTlf.getText();
        Date fechaEntrada = (Date) jSpinnerFechaEntrada.getValue();
        String DNI = jTextFieldDNI.getText();
        String modelo = jTextFieldModelo.getText();
        String matricula = jTextFieldMatricula.getText();
        String tipoVehiculo = jComboBoxTipoVehiculo.getSelectedItem().toString();
        String longitud = jTextFieldLongitud.getText();
        boolean mercanciaPeligrosa = jCheckBoxMercanciaP.isSelected();

        // Añadimos y destruimos el dialogo
        Vehiculo v = null;

        switch (tipoVehiculo) {
            case "COCHE": {
                v = new Coche(nombre, apellidos, Integer.parseInt(telefono), fechaEntrada, DNI, modelo, matricula);
                break;
            }
            case "FURGONETA": {
                v = new Furgoneta(nombre, apellidos, Integer.parseInt(telefono), fechaEntrada, DNI, modelo, matricula);
                break;
            }
            case "CAMION": {
                v = new Camion(nombre, apellidos, Integer.parseInt(telefono), fechaEntrada, DNI, modelo, matricula, longitud, mercanciaPeligrosa);
                break;
            }
            default:
                break;
        }

        LogicaNegocio.addVehiculo(v);
        pantallaPrincipal.refrescarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxTipoVehiculo = new javax.swing.JComboBox<>();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldMatricula = new javax.swing.JTextField();
        jTextFieldTlf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonAddClose = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSpinnerFechaEntrada = new javax.swing.JSpinner();
        jPanelDetallesCamion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jTextFieldLongitud = new javax.swing.JTextField();
        jCheckBoxMercanciaP = new javax.swing.JCheckBox();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("PROPIETARIO");

        jTextFieldNombre.setText("Nombre");
        jTextFieldNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldApellidos.setText("Apellidos");

        jTextFieldDNI.setText("00000000Z");

        jLabel2.setText("VEHICULO");

        jComboBoxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COCHE", "FURGONETA", "CAMION" }));
        jComboBoxTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoVehiculoActionPerformed(evt);
            }
        });

        jTextFieldModelo.setText("Modelo");

        jTextFieldMatricula.setText("Matricula");

        jTextFieldTlf.setText("666999666");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTipoVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jTextFieldTlf))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextFieldNombre.getAccessibleContext().setAccessibleName("Nombre");
        jTextFieldApellidos.getAccessibleContext().setAccessibleName("Apellidos");
        jTextFieldDNI.getAccessibleContext().setAccessibleName("DNI");
        jTextFieldModelo.getAccessibleContext().setAccessibleName("Modelo");
        jTextFieldMatricula.getAccessibleContext().setAccessibleName("Matricula");
        jTextFieldTlf.getAccessibleContext().setAccessibleName("Teléfono");

        jButtonAddClose.setText("Añadir y cerrar");
        jButtonAddClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCloseActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Añadir");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddClose))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddClose)
                    .addComponent(jButtonAdd)))
        );

        jLabel3.setText("FECHA ENTRADA");

        jSpinnerFechaEntrada.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerFechaEntrada.setToolTipText("Fecha de entrada del vehiculo al garaje");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSpinnerFechaEntrada)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel4.setText("DETALLES DEL CAMIÓN");

        jTextFieldLongitud.setText("Longitud en metros");
        jTextFieldLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLongitudActionPerformed(evt);
            }
        });

        jCheckBoxMercanciaP.setText("Este camión transporta mercancías peligrosas");

        javax.swing.GroupLayout jPanelDetallesCamionLayout = new javax.swing.GroupLayout(jPanelDetallesCamion);
        jPanelDetallesCamion.setLayout(jPanelDetallesCamionLayout);
        jPanelDetallesCamionLayout.setHorizontalGroup(
            jPanelDetallesCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldLongitud)
            .addGroup(jPanelDetallesCamionLayout.createSequentialGroup()
                .addGroup(jPanelDetallesCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxMercanciaP))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDetallesCamionLayout.setVerticalGroup(
            jPanelDetallesCamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetallesCamionLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxMercanciaP)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextFieldLongitud.getAccessibleContext().setAccessibleName("Longitud");
        jTextFieldLongitud.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDetallesCamion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(validationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelDetallesCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCloseActionPerformed
        this.addVehiculo();
        dispose();

    }//GEN-LAST:event_jButtonAddCloseActionPerformed

    private void jTextFieldLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLongitudActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // Añadimos pero no cerramos el dialogo
        // Porque se espera que se añadan más vehículos
        this.addVehiculo();

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddClose;
    private javax.swing.JCheckBox jCheckBoxMercanciaP;
    private javax.swing.JComboBox<String> jComboBoxTipoVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDetallesCamion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSpinner jSpinnerFechaEntrada;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldLongitud;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTlf;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}