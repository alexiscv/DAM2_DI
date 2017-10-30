/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaFechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class PruebaFechas {

    public static void main(String[] args) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date(); // Creamos una fecha con la fecha actual
        System.out.println("fecha: "+d);
        System.out.println("fecha: "+sdf.format(d));
        
        // Convertir un String a Date
        
        String fecha = "10-10-2010";
        try {
            
            d = sdf.parse(fecha);
             
        } catch (ParseException ex) {
            System.out.println("El formato de la fecha no es correcto dd-MM-YYYY");
        }
        
        System.out.println(d.toString());
        

    }
    
}
