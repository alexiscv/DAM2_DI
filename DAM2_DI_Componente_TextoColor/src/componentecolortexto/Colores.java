/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentecolortexto;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Alexis
 */
public class Colores implements Serializable {

    private Color colorFondo;
    private Color colorTexto;

    // Contructor
    public Colores(Color colorFondo, Color colorTexto) {
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }

    // Getter & Setter
    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

}
