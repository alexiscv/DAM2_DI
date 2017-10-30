/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.tablemodels;

import beans.Alumno;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author angel
 */
public class AlumnosTableModel extends AbstractTableModel{
    
    private ArrayList<Alumno> listaAlumno;
    private String[] columnas = {"Nombre","Curso"};

    /**
     * Contructor
     * @param listaAlumno
     */
    public AlumnosTableModel(ArrayList<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
    
    

    @Override
    public int getRowCount() {
        // Devolvemos el número de filas de la tabla
        // que son el número de items de la lista
        return listaAlumno.size();
    }

    @Override
    public int getColumnCount() {
        // Devolvemos el número de columnas de la tabla
        // Tomamos el valor de nuestro array de columnas
        return columnas.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Devolvemos el valor de una celda concreta
        // Hacemos un switch con el que buscamos el valor de
        // columnIndex, que es la columna de la tabla solicita
        // en este casos olo puede tener 2 valores, nombre o curso
        // Despues, en los CASE devolvemos el nombre o el curso
        // usando rowIndex para saber la posición dentro del array 
        // del elemento a buscar, [0],[1],[2]...
        switch(columnIndex){
            case 0:
                return listaAlumno.get(rowIndex).getNombre();
                
            case 1:
                return listaAlumno.get(rowIndex).getCurso();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        // Devolvemos los nombres de las columnas
        // Cargamos los valores de nuestro array de nombres de columa
        return columnas[column];
    }
    
    
    
}
