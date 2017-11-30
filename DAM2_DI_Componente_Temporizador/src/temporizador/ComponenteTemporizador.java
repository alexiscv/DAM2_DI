/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Alexis
 */
public class ComponenteTemporizador extends JLabel implements Serializable {

    private Temporizador temporizador;
    boolean detener = false;
    double tiempo;
    private FinalListener finalListener;

    // Constructor vacío
    // Dentro del constructor programamos la lógica de nuestro componente
    public ComponenteTemporizador() {

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

        if (temporizador.getMostrarDecimales()) {
            tiempo = tiempo - 0.1;

        } else {
            tiempo = tiempo - 1;

        }

    }

    public void iniciarTemporizador() {

        // Cargamos desde el que comenzamos
        tiempo = temporizador.getInicio();
        
        setOpaque(true); // Hacemos que sea OPACO para que se vea el BackgroundColor

        // Frecuencia de refresco
        int frecuencia = 1000;

        if (temporizador.getMostrarDecimales()) {
            frecuencia = 100;
        }

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (temporizador != null) {

                    if (tiempo > 0) {
                        // Imprimimos el valor por pantalla
                        // Imprimimos el valor por pantalla
                        if (temporizador.getMostrarDecimales()) {
                            setText(String.format("%.1f", tiempo));
                        } else {
                            setText(String.format("%.0f", tiempo));
                        }

                        // Llamamos al método que hace la cuenta atrás cada 1 segundo
                        disminuirTiempo();

                    } else {
                        // Si la cuenta atras ha terminado
                        // 1.- Imprimimos el texto de finalización en el JLabel
                        // 2.- Añadimos la imagen de finalización
                        // 3.- Ponemos el color de fondo de finalización
                        setText(temporizador.getTextoFinal());

                        if (temporizador.getColorFinal() != null) {
                            setBackground(temporizador.getColorFinal());
                        }

                        if (temporizador.getImagenFinal() != null) {
                            setIcon(new javax.swing.ImageIcon(temporizador.getImagenFinal().getAbsolutePath()));
                        }

                        // Llamamos a nuestro Listener si este no es null
                        if (finalListener != null) {
                            finalListener.fin();
                        }

                        // Paramos el Timer
                        cancel();

                    }

                } else {
                    System.out.println("ATENCIÓN: EL OBJ. TEMPORIZADOR ES NULL");
                }

            }
        }, 0, frecuencia);

    }

    /**
     *
     * Añadimos un método para que quien use nuestro componente pueda definir el
     * arrastreListener
     *
     * @param arrastreListener
     */
    public void addFinalListener(FinalListener finalListener) {
        this.finalListener = finalListener;
    }

    /**
     * También añadimos un método para cargarnos el arrastreListener
     */
    public void removeFinalListener() {
        this.finalListener = null;
    }
}
