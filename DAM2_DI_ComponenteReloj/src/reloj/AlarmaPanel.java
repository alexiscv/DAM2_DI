/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.util.Date;

/**
 *
 * @author Alexis
 */
public class AlarmaPanel extends javax.swing.JPanel {

    /**
     * Creates new form AlarmaPanel
     */
    public AlarmaPanel() {
        initComponents();
    }

    /**
     * Retorna los valores introducidos en el panel
     *
     * @return
     */
    public Alarma getValoresPanel() {

        // Recogemos los valores y los cargamos en variables de facil uso
        Date fecha;
        Boolean estado;

        // Cargamos los valores del formulario en las variables
        fecha = (Date) jSpinnerAlarma.getValue();
        estado = jCheckBox1.isSelected();

        return new Alarma(fecha, estado);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinnerAlarma = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();

        jSpinnerAlarma.setModel(new javax.swing.SpinnerDateModel());

        jCheckBox1.setText("Activa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jSpinnerAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(188, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JSpinner jSpinnerAlarma;
    // End of variables declaration//GEN-END:variables
}
