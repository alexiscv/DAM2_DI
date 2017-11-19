/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversordivisas.logica;

import conversordivisas.beans.Divisa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alexis
 */
public class LogicaNegocio {

    // Fichero que usaremos para guardar los datos
    private static File f = new File("divisas.dat");

    // Array de objetos
    private static LinkedList<Divisa> divisas = new LinkedList<>();

    /**
     * Método para revolver el ArrayList
     *
     * @return
     */
    public static LinkedList listadoDivisas() {
        return divisas;
    }

    /**
     * Método que permite agregar una nueva divisa
     *
     * @param d
     */
    public static void addDivisa(Divisa d) {

        // Añadimos la divisa a la colección
        divisas.add(d);

        // Grabamos la divisa en el fichero para tener persistencia
        guardar();
    }

    /**
     * Función para cargar las divisas ya existentes
     */
    public static void cargarFichero() {

        // Comprobamos si existe un fichero para leer y guardar información
        // si no existe, lo creamos
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero.");

            }

        }

        // Cargamos el contenido del fichero en memoria
        if (f.exists()) {

            try {

                // Lo primero es indicar que fichero queremos leer
                FileInputStream fichero = new FileInputStream(f);

                // Ahora cargamos el contenido del fichero en un flujo de datos
                ObjectInputStream contenidoFichero = new ObjectInputStream(fichero);

                // Como el contenido del fichero es un LinkedList de Divisas,
                // Creamos un objeto de ese tipo para guardar el contenido y poder leerlo
                // de la misma forma en la que fue guardado
                // Hay que destacar que ObjectInputStream devuelve un objeto de tipo Object
                // Por eso, hay que usar un cast para pasarlo a una LinkedList de Divisas
                divisas = (LinkedList<Divisa>) contenidoFichero.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    /**
     * Guardar
     *
     * @return
     */
    public static boolean guardar() {

        try {

            // Volcamos el contenido de la memoria en el fichero
            // Lo primero es indicar donde se almacenará la información
            FileOutputStream fSalida = new FileOutputStream("divisas.dat");

            // Ahora creamos un flujo de datos donde almacenaremos la información
            // Una vez almacenada, con el método ObjectWrite, escribiremos en el fichero
            ObjectOutputStream oos = new ObjectOutputStream(fSalida);

            // Volcamos el contenido del flujo de datos en el fichero
            oos.writeObject(divisas);

            return true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    /**
     * Mostrar Divisas
     */
    public static void mostrarDivisas() {

        int contador = 0;

        for (Divisa divisa : divisas) {

            System.out.print("Divisa #" + contador + " - ");
            System.out.println(divisa);
            contador++;

        }

    }

    /**
     * Convertir Divisa
     *
     * @return
     */
    public static String convertirDivisa(String divisa1, String divisa2, String importe) {

        LinkedList<Divisa> divisas = LogicaNegocio.listadoDivisas();

        // Valores de las divisas
        double valor1 = 0, valor2 = 0, resultado;

        // Recorremos las posibles divisas y recogemos el valor de las divisas 
        // seleccionadas por el usuario en los jComboBox
        for (Divisa divisa : divisas) {

            if (divisa.getNombre().equals(divisa1)) {
                valor1 = divisa.getValor();

            }
            if (divisa.getNombre().equals(divisa2)) {
                valor2 = divisa.getValor();

            }

        }

        // Realizamos la conversión y cargamos el valor resultado
        resultado = Double.parseDouble(importe) * valor2 / valor1;

        return String.valueOf(resultado);

    }

}
