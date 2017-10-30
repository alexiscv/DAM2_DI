/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionclientes.logica;

import gestionclientes.dto.Cliente;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class LogicaNegocio {
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    public static void addCliente( Cliente cliente ){
        
        listaClientes.add(cliente);
        
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    
    
}
