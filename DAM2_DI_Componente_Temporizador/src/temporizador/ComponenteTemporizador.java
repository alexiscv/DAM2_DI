/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Alexis
 */
public class ComponenteTemporizador extends JLabel implements Serializable {

    private Temporizador temporizador;

    // Constructor vacío
    // Dentro del constructor programamos la lógica de nuestro componente
    public ComponenteTemporizador() {

        // Pruebas, veo valores actuales
        System.out.println("Inicio = " + temporizador.getInicio());

        this.setText(String.valueOf(temporizador.getInicio()));

        // Vamos disminuyendo el número con un for
        // e imprimiendolo por pantalla
        for (int i = 0; i < 100; i++) {

            try {
                sleep(1000);
                temporizador.setInicio(temporizador.getInicio() - 1);
                super.setText(String.valueOf(temporizador.getInicio()));
                System.out.println("valor de inicio: " + temporizador.getInicio());

            } catch (InterruptedException ex) {
                Logger.getLogger(ComponenteTemporizador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Si la cuenta atras ha terminado
        // 1.- Imprimimos el texto de fi nalización en el JLabel
        // 2.- Añadimos la imagen de finalización
        // 3.- Ponemos el color de fondo de finalización
        if (temporizador.getInicio() == 0) {
            System.out.println("Imprimo texto final: " + temporizador.getTextoFinal());
            super.setText(temporizador.getTextoFinal());
            super.setBackground(temporizador.getColorFinal());
        }

    }

    // Getter & Setter, obligatorios
    public Temporizador getTemporizador() {
        return temporizador;
    }

    public void setTemporizador(Temporizador temporizador) {
        this.temporizador = temporizador;
    }

}
