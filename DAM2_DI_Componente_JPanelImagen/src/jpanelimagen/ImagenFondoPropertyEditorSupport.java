/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Alexis
 */
public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport {

    private ImagenFondoPanel imagenFondoPanel = new ImagenFondoPanel();
    
    /**
     * Este método lo llama netBeans para saber si hay un editor personalizado
     * Simplemente lo ponemos a true para indicar que tenemos un editor personalizado
     * por defecto, devolvería un false.
     * @return 
     */
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    /**
     * Con este método devolvemos nuestro panel personalizado
     * para eso lo definimos como un atributo al inicio de esta clase
     * y simplemente la devolvemos cuando se llame a este método.
     * @return 
     */
    @Override
    public Component getCustomEditor() {
        return imagenFondoPanel;
    }

    /**
     * Sirve para indicar a netbeans como debe inicializar nuestro componente
     * sin este método la aplicación no compilaría
     * @return 
     */
    @Override
    public String getJavaInitializationString() {
        ImagenFondo imagenFondo = imagenFondoPanel.getSelectedValue();
        String ruta = imagenFondo.getRutaImagen().getAbsolutePath();
        ruta=ruta.replace("\\", "\\\\");
        return "new jpanelimagen.ImagenFondo(new java.io.File(\""+ruta+"\"),"+imagenFondo.getOpacidad()+"f)";
    }

    /**
     * Una vez que se muestra el panel y el usuario ha cargado su configuración y pulsa aceptar
     * este método devolvería los valores que el usuario ha introducido.
     * @return 
     */
    @Override
    public Object getValue() {
        return imagenFondoPanel.getSelectedValue();
    }

}
