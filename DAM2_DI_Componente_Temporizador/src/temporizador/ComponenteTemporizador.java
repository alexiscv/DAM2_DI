/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Alexis
 */
public class ComponenteTemporizador extends JLabel implements Serializable {

    private Temporizador temporizador;
    boolean detener = false;

    // Constructor vacío
    // Dentro del constructor programamos la lógica de nuestro componente
    public ComponenteTemporizador() {

        setText("-- GO! --");
        setOpaque(true); // Hacemos que sea OPACO para que se vea el BackgroundColor

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (temporizador != null) {

                    if (temporizador.getInicio() > 0) {
                        // Imprimimos el valor por pantalla
                        if (temporizador.getMostrarDecimales()) {
                            float num = temporizador.getInicio();
                            setText(Float.toString(num));
                        } else {
                            setText(Integer.toString(temporizador.getInicio()));

                        }
                        // Llamamos al método que hace la cuenta atrás cada 1 segundo
                        disminuirTiempo();

                    } else {
                        // Si la cuenta atras ha terminado
                        // 1.- Imprimimos el texto de finalización en el JLabel
                        // 2.- Añadimos la imagen de finalización
                        // 3.- Ponemos el color de fondo de finalización
                        setText(temporizador.getTextoFinal());
                        setBackground(temporizador.getColorFinal());
                        setIcon(new javax.swing.ImageIcon((Image) (Icon) temporizador.getImagenFinal()));

                        // Paramos el Listener Timer
                        Thread.currentThread().stop();

                    }

                } else {
                    System.out.println("----->>>> TEMPORIZADOR ES NULL");
                }

            }

        });

        timer.start();

    }

    // Getter & Setter, obligatorios
    public Temporizador getTemporizador() {
        return temporizador;
    }

    public void setTemporizador(Temporizador temporizador) {
        this.temporizador = temporizador;
    }

    // Métodos
    private void disminuirTiempo() {

        temporizador.setInicio(temporizador.getInicio() - 1);

    }
}
