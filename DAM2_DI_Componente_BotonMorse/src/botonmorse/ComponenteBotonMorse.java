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
            String codigo = "";

            @Override
            public void mouseClicked(MouseEvent e) {

                // Al hacer clic, calculamos la diferencia entre
                // el momento de presionar y el momento de soltar
                // y añadimos el . o la -
                long duracion = finPulsacion - inicioPulsacion;

                // SI es un .
                if (duracion < botonMorse.getDuracionPulsacionCorta()) {

                    codigo = codigo + ".";

                }
                // SI es una -
                if (duracion > botonMorse.getDuracionPulsacionLarga()) {

                    codigo = codigo + "-";

                }
                
                System.out.print(codigo);
                
                // Buscamos coincidencias con el código actual
                // Siempre que este no sea vacio
                if (!codigo.equals("")) {
                    if (!buscarLetra(codigo).equals("")) {
                        // Si ha retornado un caracter, lo retornamos por consola
                        System.out.println(buscarLetra(codigo));
                        
                        // Reseteamos el código
                        codigo = "";

                        // Y llamaos al Listener, por si el usuarioProgramador
                        // Quiere hacer algo con este evento
                        if (letraListener != null) {
                            letraListener.letraDetectada();
                        }
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
     * Retorna una letra a partir de un código morse
     *
     * @param codigo
     */
    public String buscarLetra(String codigo) {

        if (codigo.equals(".-")) {
            return "A";
        }
        if (codigo.equals("-.")) {
            return "N";
        }
        if (codigo.equals("..")) {
            return "I";
        }
        if (codigo.equals("--")) {
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

    /**
     * Getter para la propiedad botonMorse
     *
     * @return
     */
    public BotonMorse getBotonMorse() {
        return botonMorse;
    }

    /**
     * Setter para la propiedad botonMorse
     *
     * @return
     */
    public void setBotonMorse(BotonMorse botonMorse) {
        this.botonMorse = botonMorse;
    }

}
