/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonmorse;

/**
 *
 * @author angel
 */
public class BotonMorsePanel extends javax.swing.JPanel {

    /**
     * Creates new form BotonMorsePanel
     */
    public BotonMorsePanel() {
        initComponents();
    }

    /**
     * Método para devolver los valores recogidos en el panel y poder contruir
     * el obj. BotonMorse
     *
     * @return
     */
    public BotonMorse getValoresPanel() {

        // Para evitar un NullPointerException
        int duracionPulsacionCorta = 0;
        int duracionPulsacionLarga = 0;

        if (!pulsacionCorta.getText().equals("")) {
            duracionPulsacionCorta = Integer.decode(pulsacionCorta.getText());
        }
        if (!pulsacionLarga.getText().equals("")) {
            duracionPulsacionLarga = Integer.decode(pulsacionLarga.getText());
        }

        if (duracionPulsacionCorta > 0 && duracionPulsacionLarga > duracionPulsacionCorta) {
            System.out.println("Creamos el obj.");
            return new BotonMorse(duracionPulsacionCorta, duracionPulsacionLarga);

        } else {
            System.out.println("ERROR: Los datos introducidos no son válidos.");
            return new BotonMorse(0, 0);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDuracionCorta = new javax.swing.JLabel();
        jLabelDuracionLarga = new javax.swing.JLabel();
        pulsacionCorta = new javax.swing.JTextField();
        pulsacionLarga = new javax.swing.JTextField();

        jLabelDuracionCorta.setText("Duración pulsación corta:");

        jLabelDuracionLarga.setText("Duración pulsación larga:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDuracionLarga)
                    .addComponent(jLabelDuracionCorta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pulsacionCorta)
                    .addComponent(pulsacionLarga, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracionCorta)
                    .addComponent(pulsacionCorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracionLarga)
                    .addComponent(pulsacionLarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDuracionCorta;
    private javax.swing.JLabel jLabelDuracionLarga;
    private javax.swing.JTextField pulsacionCorta;
    private javax.swing.JTextField pulsacionLarga;
    // End of variables declaration//GEN-END:variables
}
