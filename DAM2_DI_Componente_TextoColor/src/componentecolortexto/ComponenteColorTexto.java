/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentecolortexto;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Alexis Extendemos del componente de swing que mas se pareza a lo que
 * necesitamos e implementamos serializable
 */
public class ComponenteColorTexto extends JTextField implements Serializable {

    // Los atributos serán editables desde la interface de swing
    private Colores colores;
    private int numCaracteres;

    // Tiene que haber un constructor vacío.
    // Es obligatorio
    public ComponenteColorTexto() {

        // Recogemos el valor por defecto del componente
        Color colorPorDefecto = getBackground();
        Color colorTextoPorDefecto = getForeground();
        super.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizaContenido();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizaContenido();
            }

            /**
             * Método que cuenta el número de caracteres del componente y
             * devuelve un color de fondo.
             */
            private void analizaContenido() {
                if (getText().length() >= numCaracteres) {
                    setBackground(colores.getColorFondo());
                    setForeground(colores.getColorTexto());
                    
                } else {
                    setBackground(colorPorDefecto);
                    setForeground(colorTextoPorDefecto);
                }
            }

        });

    }

    // Métodos
    // Los métodos se deben nombrar siguiendo la nomenclatura
    // por defecto, como los generaría netbeans
    public Colores getColores() {
        return colores;
    }

    public void setColores(Colores colores) {
        this.colores = colores;
    }

    public int getNumCaracteres() {
        return numCaracteres;
    }

    public void setNumCaracteres(int numCaracteres) {
        this.numCaracteres = numCaracteres;
    }

}
