/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonmorse;

import java.io.Serializable;

/**
 *
 * @author Alexis
 */
public class BotonMorse implements Serializable {

    private int duracionPulsacionCorta;
    private int duracionPulsacionLarga;

    /**
     * Constructor
     *
     * @param duracionPulsacionCorta
     * @param duracionPulsacionLarga
     */
    public BotonMorse(int duracionPulsacionCorta, int duracionPulsacionLarga) {
        this.duracionPulsacionCorta = duracionPulsacionCorta;
        this.duracionPulsacionLarga = duracionPulsacionLarga;
    }

    /**
     * Getter Pulsación corta
     *
     * @return
     */
    public int getDuracionPulsacionCorta() {
        return duracionPulsacionCorta;
    }

    /**
     * Setter Pulsación corta
     *
     */
    public void setDuracionPulsacionCorta(int duracionPulsacionCorta) {
        this.duracionPulsacionCorta = duracionPulsacionCorta;
    }

    /**
     * Getter Pulsación larga
     *
     * @return
     */
    public int getDuracionPulsacionLarga() {
        return duracionPulsacionLarga;
    }

    /**
     * Setter Pulsación larga
     *
     */
    public void setDuracionPulsacionLarga(int duracionPulsacionLarga) {
        this.duracionPulsacionLarga = duracionPulsacionLarga;
    }

}
