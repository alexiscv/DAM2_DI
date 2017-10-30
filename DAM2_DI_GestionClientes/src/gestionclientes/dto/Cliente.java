/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionclientes.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Cliente {

    private String nombre;
    private String apellidos;
    private Date fechaAlta;
    private String provincia;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

    public Cliente(String nombre, String apellidos, Date fechaAlta, String provincia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Método que devuelve un array de Strigs
     * @return 
     */
    public String[] toArrayString() {
        // Creamos el array
        String[] array = new String[4];

        // Cargamos los valores en el array
        array[0] = nombre;
        array[1] = apellidos;
        array[2] = sdf.format(fechaAlta);
        array[3] = provincia;

        return array;

    }
}
