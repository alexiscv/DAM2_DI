/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_di_ejrepaso2;

import java.util.Objects;

/**
 *
 * @author angel
 */
class Planeta {

    private String nombre;
    private double eje;
    private double excentricidad;
    private double periodo;

    public Planeta(String nombre, double eje, double periodo, double excentricidad) {
        this.nombre = nombre;
        this.eje = eje;
        this.excentricidad = excentricidad;
        this.periodo = periodo;
    }

    public Planeta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Planeta{" + "nombre=" + nombre + ", eje=" + eje + ", excentricidad=" + excentricidad + ", periodo=" + periodo + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public double getEje() {
        return eje;
    }

    public double getExcentricidad() {
        return excentricidad;
    }

    public double getPeriodo() {
        return periodo;
    }

}
