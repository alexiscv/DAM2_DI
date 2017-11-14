/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversordivisas.logica;

import conversordivisas.beans.Divisa;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class LogicaNegocio {

    // Array de objetos
    private static ArrayList<Divisa> divisas = new ArrayList<>();

    /**
     * Método para revolver el ArrayList
     *
     * @return
     */
    public static ArrayList listadoDivisas() {
        return divisas;
    }

    /**
     * Método que permite agregar una nueva divisa
     *
     * @param nombre
     * @param valor
     */
    public static void addDivisa(String nombre, double valor) {

        Divisa d = new Divisa(nombre, valor);
        divisas.add(d);

    }
}
