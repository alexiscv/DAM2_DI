/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfieldespia;

import java.util.ArrayList;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Alexis
 */
public class ComponenteTextfieldEspia extends JTextArea implements Serializable {

    private String ficheroLog;
    private ArrayList<String> listadoPalabras = new ArrayList<>();

    /**
     * Constructor Obligatorio que esté vacio.
     */
    public ComponenteTextfieldEspia() {

        this.addKeyListener(new KeyListener() {

            String palabra = "";

            /**
             * Al pulsar y soltar una tecla Lo vamos a usar para recorrer el
             * texto cada vez que escribamos algo.
             *
             * @param e
             */
            @Override
            public void keyTyped(KeyEvent e) {

            }

            /**
             * Al pulsar una tecla
             *
             * @param e
             */
            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             * Al soltar la tecla presionada
             *
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {

                // Intro = 8, Borrar = 10, Espacio = 32
                if (e.getKeyCode() != 10 && e.getKeyCode() != 8 && e.getKeyCode() != 32) {

                    // Añadimos el caracter al String de Palabra
                    palabra = palabra + e.getKeyChar();

                }

                // Si pulsamos espacio o intro, comparamos la palabra construida hasta el momento
                // Con el ArrayList y reseteamos la palabra guardada
                if (e.getKeyCode() == 8 || e.getKeyCode() == 32) {
                    buscar(palabra);
                    palabra = "";
                }

            }

        });

    }

    /**
     * Getter para retornar el valor de ficheroLog
     *
     * @return
     */
    public String getFicheroLog() {
        return ficheroLog;
    }

    /**
     * Setter para asignar un valor a ficheroLog
     *
     * @param ficheroLog
     */
    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
    }

    /**
     * addPalabra nos permite añadir una palabra al arrayList de palabras que
     * tenemos que guardar en el fichero Log.
     *
     * @param Palabra
     */
    public void addPalabra(String Palabra) {

        listadoPalabras.add(Palabra);

    }

    /**
     * Nos permite buscar una palabra en nuestro ArrayList De encontrarse una
     * coincidencia, la almacenaremos en el Log
     *
     * @param palabra
     */
    private void buscar(String palabra) {

        for (String listadoPalabra : listadoPalabras) {

            if (listadoPalabra.equals(palabra)) {

                // Añadimos al Log
                grabarRegistro(palabra);

            }

        }

    }

    /**
     * Nos permite grabar un registro en el Log de palabras
     *
     * @param palabra
     */
    private void grabarRegistro(String palabra) {

        Date fecha = new Date();
        File f = new File(getFicheroLog());

        // Comprobamos si existe un fichero para leer y guardar información
        // si no existe, lo creamos
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero.");

            }

        }

        // Grabar en fichero
        try {
            FileWriter fr = new FileWriter(f, true); // con true al final, evitamos que se sobreescriba el contenido del ficheros
            fr.write(fecha + " -- " + palabra + "\r\n");
            fr.close();

        } catch (IOException ex) {
            System.out.println("Error al escribir en el Log.");
        }

    }

}
