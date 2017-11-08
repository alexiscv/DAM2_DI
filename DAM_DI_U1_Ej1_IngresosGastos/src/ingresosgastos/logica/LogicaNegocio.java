/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresosgastos.logica;

import ingresosgastos.dto.Operacion;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class LogicaNegocio {

    // Array para almacenar operaciones
    static ArrayList<Operacion> operaciones = new ArrayList<>();

    // Acciones
    public static void addOperacion(Operacion o) {

        operaciones.add(o);

    }

    public static ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public static float calcularBalance() {
        
        System.out.println("calcularndo balance");

        float totalGastos = 0;
        float totalIngresos = 0;

        for (Operacion operacion : operaciones) {

            // Si es una operación de ingreso, la sumamos al total ingresos
            if (operacion.getTipoOperacion() == 1) {
                totalIngresos += operacion.getImporte();

            } else {
                totalGastos += operacion.getImporte();

            }

        }

        // Calculamos el balance y lo retornamos
        return totalIngresos - totalGastos;

    }

}
