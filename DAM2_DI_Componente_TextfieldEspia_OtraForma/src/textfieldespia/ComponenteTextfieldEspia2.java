/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfieldespia;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Alexis
 */
public class ComponenteTextfieldEspia2 extends JTextArea implements Serializable {

    private String ficheroLog;
    private ArrayList<String> listadoPalabras = new ArrayList<>();

    /**
     * Constructor Obligatorio que esté vacio.
     */
    public ComponenteTextfieldEspia2() {

        this.getDocument().addDocumentListener(new DocumentListener() {

            String palabra = "";

            @Override
            public void insertUpdate(DocumentEvent e) {
                espiar(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                espiar(e);
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

            if (palabra.contains(listadoPalabra)) {

                // Añadimos al Log
                grabarRegistro(listadoPalabra);

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

    /**
     * Método para rastrear lo que se escribe
     */
    private void espiar(DocumentEvent e) {

        int ini = e.getDocument().getStartPosition().getOffset();    // Donde comienza el texto
        int fin = e.getDocument().getEndPosition().getOffset();      // Donde termina

        // Declaramos la variable donde recogemos el texto del componente
        String contenido;

        System.out.println("inicio: " + ini + " fin:" + fin);

        try {
            contenido = getText(ini, fin);
            System.out.println(contenido);

        } catch (BadLocationException ex) {
            Logger.getLogger(ComponenteTextfieldEspia2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
