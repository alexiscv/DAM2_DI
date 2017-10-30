/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import beans.Alumno;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class LogicaNegocio {

    public ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public LogicaNegocio() {
        //istaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("Pablo", "DAM2"));
        listaAlumnos.add(new Alumno("Alexis", "DAM2"));
        listaAlumnos.add(new Alumno("Sergio", "DAM1"));
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

}
