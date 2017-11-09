/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversordivisas.beans;

/**
 *
 * @author Alexis
 */
public class Divisa {
    
    String nombre;
    double valor; // respecto al €

    public Divisa(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    private String[] toArrayString(){
        
        String[] s = new String[2];
        
        s[0] = nombre;
        s[1] = Double.toString(valor);
        
        return s;
        
    }
    
}
