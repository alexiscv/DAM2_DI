/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_di_ejrepaso1;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author angel
 */
public class DAM2_DI_EjRepaso1 {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParseException, IOException {
        
        Logica app = new Logica();
        app.init(); // Llamamos a las tareas de inicialización
        
        // Iniciamos la aplicación
        while (app.isRun()) {   
            app.mostrarMenu();
            
        }
        
    }
    
}
