/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informecoche;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class TestDataSource {
    
    public static List<Coche> listCoches(){
        
        List<Coche> listaCoches = new ArrayList<>();
        listaCoches.add(new Coche("Peugeot", "206 xrd 1.9", "5413BNT"));
        listaCoches.add(new Coche("Peugeot", "307 sw", "2565CXK"));
        listaCoches.add(new Coche("Keeway", "Superlight", "5443BNT"));
        listaCoches.add(new Coche("Suzuki", "GS500 Naked", "2345KJH"));
        
        return listaCoches;
        
    }
    
}
