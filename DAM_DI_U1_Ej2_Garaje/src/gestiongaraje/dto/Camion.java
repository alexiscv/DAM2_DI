/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiongaraje.dto;

import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Camion extends Vehiculo {

    private String tipo;
    private String longitud;
    private boolean isMercanciaPeligrosa;

    public Camion(String nombre, String apellidos, int telefono, Date fechaEntrada, String dni, String modelo, String matricula, String longitud, boolean isMercanciaPeligrosa) {
        super(nombre, apellidos, telefono, fechaEntrada, dni, modelo, matricula);
        this.tipo = "CAMIÓN";
        this.longitud = longitud;
        this.isMercanciaPeligrosa = isMercanciaPeligrosa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public boolean isIsMercanciaPeligrosa() {
        return isMercanciaPeligrosa;
    }

    public void setIsMercanciaPeligrosa(boolean isMercanciaPeligrosa) {
        this.isMercanciaPeligrosa = isMercanciaPeligrosa;
    }

    @Override
    public String[] toArrayString() {

        String mp = "";
        if (isMercanciaPeligrosa) {
            mp = "SI";
        }

        String[] s = new String[6];

        s[0] = super.getMatricula();
        s[1] = super.getModelo();
        s[2] = super.sdf.format(super.getFechaEntrada());
        s[3] = tipo;
        s[4] = longitud;
        s[5] = mp;

        return s;

    }

}
