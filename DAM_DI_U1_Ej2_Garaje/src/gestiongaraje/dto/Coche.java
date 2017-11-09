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
public class Coche extends Vehiculo {

    private String tipo;

    public Coche(String nombre, String apellidos, int telefono, Date fechaEntrada, String dni, String modelo, String matricula) {
        super(nombre, apellidos, telefono, fechaEntrada, dni, modelo, matricula);
        this.tipo = "COCHE";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String[] toArrayString() {

        String[] s = new String[4];

        s[0] = super.getMatricula();
        s[1] = super.getModelo();
        s[2] = super.sdf.format(super.getFechaEntrada());
        s[3] = tipo;

        return s;

    }
}
