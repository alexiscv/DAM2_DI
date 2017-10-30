/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_di_ejrepaso1;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author angel
 */
public class Partido implements Comparable<Partido>, Serializable{
    
    private String equipoLocal;
    private String equipoVisitante;
    private int division;
    private String resultado;
    private Date fecha;

    /**
     * Constructor
     */
    public Partido() {
    }
    
    /**
     * Contructor
     * @param equipoLocal
     * @param equipoVisitante
     * @param division
     * @param resultado
     * @param fecha 
     */
    public Partido(String equipoLocal, String equipoVisitante, int division, String resultado, Date fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.division = division;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    /*
    Getter & Setter
    */
    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * toString
     * @return 
     */
    @Override
    public String toString() {
        return "Partido{" + "equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", division=" + division + ", resultado=" + resultado + ", fecha=" + fecha + '}';
    }   

    /*
    Comparadores
    */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Partido p) {
        return this.fecha.compareTo(p.fecha); // devuelve 1,-1 o 0
    }    
    
}
