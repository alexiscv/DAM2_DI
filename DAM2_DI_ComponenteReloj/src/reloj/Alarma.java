/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Alarma implements Serializable {

    private Date fechaAlarma;
    boolean estado;

    public Alarma(Date fechaAlarma, boolean estado) {
        this.fechaAlarma = fechaAlarma;
        this.estado = estado;
    }

    public Date getFechaAlarma() {
        return fechaAlarma;
    }

    public void setFechaAlarma(Date fechaAlarma) {
        this.fechaAlarma = fechaAlarma;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
