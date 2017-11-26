/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Alexis
 */
public class ImagenFondo implements Serializable {

    // Atributos
    private File rutaImagen;
    private float opacidad;

    // Constructor
    public ImagenFondo(File rutaImagen, float opacidad) {
        this.rutaImagen = rutaImagen;
        this.opacidad = opacidad;
    }

    // Métodos
    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(float opacidad) {
        this.opacidad = opacidad;
    }

}
