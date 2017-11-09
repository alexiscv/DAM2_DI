/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiongaraje.logica;

import gestiongaraje.dto.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class LogicaNegocio {

    // Para almacenar los listados de vehiculos
    private static ArrayList<Vehiculo> listadoVehiculos = new ArrayList<>();

    /**
     * Nos permite añadir un vehículo al listado
     *
     * @param v
     */
    public static void addVehiculo(Vehiculo v) {

        listadoVehiculos.add(v);

    }

    public static ArrayList<Vehiculo> getVehiculos() {

        return listadoVehiculos;

    }

}
