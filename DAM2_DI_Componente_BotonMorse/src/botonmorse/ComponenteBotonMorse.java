/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonmorse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Alexis
 */
public class ComponenteBotonMorse extends JButton implements Serializable {

    private BotonMorse botonMorse;
    private LetraListener letraListener;

    /**
     * Constructor, obligatorio que esté vacio
     */
    public ComponenteBotonMorse() {

        // Creamos un Listener para controlar cuando se pulsa el botón
        this.addMouseListener(new MouseListener() {

            long inicioPulsacion;
            long finPulsacion;
            String codigo;

            @Override
            public void mouseClicked(MouseEvent e) {

                // Al hacer clic, calculamos la diferencia entre
                // el momento de presionar y el momento de soltar
                // y añadimos si es un . o un - al código
                long duracion = finPulsacion - inicioPulsacion;

                // SI es un .
                if (duracion < botonMorse.getDuracionPulsacionLarga()) {

                    codigo = codigo + "1";

                } // SI es una -
                else if (duracion <= botonMorse.getDuracionPulsacionLarga()) {

                    codigo = codigo + "0";

                } // Si la tiene una pulsación mayor, reseteamos el código
                else {

                    codigo = "";

                }

                // Buscamos coincidencias con el código actual
                if (!buscarLetra(codigo).equals("")) {
                    // Si ha retornado un caracter, lo retornamos por consola
                    System.out.println(buscarLetra(codigo));

                    // Y llamaos al Listener, por si el usuarioProgramador
                    // Quiere hacer algo con este evento
                    if (letraListener != null) {
                        letraListener.letraDetectada();
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

                // Al pulsar tomamos la fecha actual
                inicioPulsacion = System.currentTimeMillis();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                // Al soltar tomamos la fecha actual
                finPulsacion = System.currentTimeMillis();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

    }

    /**
     * Retorna una letra a partir de un código morse los códigos morse están
     * basados en 1 y 0 1 es un . 0 una -
     *
     * @param codigo
     */
    public String buscarLetra(String codigo) {

        if (codigo.equals("10")) {
            return "A";
        }
        if (codigo.equals("01")) {
            return "N";
        }
        if (codigo.equals("11")) {
            return "I";
        }
        if (codigo.equals("00")) {
            return "M";
        }

        return "";

    }

    /**
     * Getter para que un usuarioProgramador añada un Listener
     *
     * @return
     */
    public LetraListener getLetraListener() {
        return letraListener;
    }

    /**
     * Método para que un usuarioProgramador pueda eliminar el listener
     *
     * @return
     */
    public LetraListener removeLetraListener() {
        return null;
    }

}
