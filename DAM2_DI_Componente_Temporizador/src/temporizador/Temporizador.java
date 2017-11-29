/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Alexis
 */
public class Temporizador implements Serializable {

    private double inicio;           // Aquí almacenamos el numero donde iniciamos la cuenta atrás
    private double tiempoRestante;   // Aquí almacenamos el tiempo según se va descontando
    private String textoFinal;
    private Color colorFinal;
    private Boolean mostrarDecimales;
    private File imagenFinal;

    public Temporizador(double inicio, String textoFinal, Color colorFinal, Boolean mostrarDecimales, File imagenFinal) {
        this.inicio = inicio;
        this.textoFinal = textoFinal;
        this.colorFinal = colorFinal;
        this.mostrarDecimales = mostrarDecimales;
        this.imagenFinal = imagenFinal;
        this.tiempoRestante = inicio;
    }

    public double getInicio() {
        return inicio;
    }

    public void setInicio(double inicio) {
        this.inicio = inicio;
    }

    public double getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(double tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public String getTextoFinal() {
        return textoFinal;
    }

    public void setTextoFinal(String textoFinal) {
        this.textoFinal = textoFinal;
    }

    public Color getColorFinal() {
        return colorFinal;
    }

    public void setColorFinal(Color colorFinal) {
        this.colorFinal = colorFinal;
    }

    public Boolean getMostrarDecimales() {
        return mostrarDecimales;
    }

    public void setMostrarDecimales(Boolean mostrarDecimales) {
        this.mostrarDecimales = mostrarDecimales;
    }

    public File getImagenFinal() {
        return imagenFinal;
    }

    public void setImagenFinal(File imagenFinal) {
        this.imagenFinal = imagenFinal;
    }

}
