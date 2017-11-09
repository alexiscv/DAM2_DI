/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiongaraje.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Vehiculo {

    private String nombre;
    private String apellidos;
    private int telefono;
    private Date fechaEntrada;
    private String dni;
    private String modelo;
    private String matricula;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Vehiculo(String nombre, String apellidos, int telefono, Date fechaEntrada, String dni, String modelo, String matricula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaEntrada = fechaEntrada;
        this.dni = dni;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public Vehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String[] toArrayString(){
        
        String[] s = new String[3];
        
        s[0] = matricula;
        s[1] = modelo;
        s[2] = sdf.format(fechaEntrada);
        
        return s;        
        
    }

}
