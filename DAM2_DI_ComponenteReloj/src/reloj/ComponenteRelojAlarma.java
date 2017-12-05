/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Alexis
 */
public class ComponenteRelojAlarma extends JLabel implements Serializable {

    private boolean muestraSegundos;
    private Alarma alarma;
    private AlarmaListener avisoAlarmaListener;

    /**
     * Contructor, obligatorio que esté vacio
     */
    public ComponenteRelojAlarma() {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Date fechaActual = new Date();

                setText(formatearFecha(fechaActual, isMuestraSegundos()));

                // Si hay una alarma activa...
                if (alarma.isEstado()) {

                    // Si la fecha actual es la misma que la de la alarma...
                    if (formatearFecha(alarma.getFechaAlarma(), true).equals(formatearFecha(fechaActual, true))) {

                        // Llamamos a nuestro Listener si este no es null
                        if (avisoAlarmaListener != null) {
                            avisoAlarmaListener.avisoAlarma();
                        }

                    }

                }

            }
        }, 0, 1000);

    }

    /*
      Los Getter y los Setter de las propiedades
      Son obligatorios
     */
    public boolean isMuestraSegundos() {
        return muestraSegundos;
    }

    public void setMuestraSegundos(boolean muestraSegundos) {
        this.muestraSegundos = muestraSegundos;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    /*
     Métodos personalizados
     Otros Métodos de nuestro componente a continuación
     */
    private String formatearFecha(Date fecha, Boolean formato) {

        // Formato por defecto
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm");

        // Si se desea mostrar segundos, cambiamos el formato
        if (formato) {
            formateador = new SimpleDateFormat("hh:mm:ss");
        }

        // Retornamos la fecha formateada
        return formateador.format(fecha);

    }

    /**
     *
     * Añadimos un método para que quien use nuestro componente pueda definir el
     * arrastreListener
     *
     * @param avisoAlarmaListener
     */
    public void addAlarmaListener(AlarmaListener avisoAlarmaListener) {
        this.avisoAlarmaListener = avisoAlarmaListener;
    }

    /**
     * También añadimos un método para cargarnos el arrastreListener
     */
    public void removeAlarmaListener() {
        this.avisoAlarmaListener = null;
    }

    public void addAlarmaListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
