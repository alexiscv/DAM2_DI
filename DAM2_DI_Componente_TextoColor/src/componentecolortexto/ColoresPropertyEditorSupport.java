/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentecolortexto;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Alexis
 */
public class ColoresPropertyEditorSupport extends PropertyEditorSupport {

    private ColoresPanel coloresPanel = new ColoresPanel();

    /**
     * supportsCustomEditor. Este método será llamado por Netbeans para
     * preguntar si existe o no un editor de propiedades personalizado. Debemos
     * devolver true en el caso de que lo tengamos.
     *
     * @return
     */
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    /**
     * getCustomEditor. Este método devolverá el panel que hemos creado para
     * editar la propiedad. Es decir, Netbeans preguntará al método
     * supportsCustomEditor si hay un editor personalizado, y en caso de que lo
     * haya, llamará a este método para obtener el panel que tendrá que
     * mostrarle al usuario. Como se puede ver en la implementación, devolvemos
     * una instancia del panel.
     *
     * @return
     */
    @Override
    public Component getCustomEditor() {
        return coloresPanel;
    }

    /**
     * getJavaInitializationString(). Este es el método más complicado de todos.
     * Sirve para ayudar al Netbeans en la generación de código necesaria para
     * inicializar la propiedad en tiempo de ejecución. Cuando se arrastra un
     * componente a un formulario, Netbeans genera un trozo de código dentro del
     * método initComponents. Si únicamente arrastramos el componente y lo
     * incluimos en un formulario, generararía una llamada al constructor del
     * componente. El método getJavaInicializationString devuelve un String con
     * el código que habría que meter entre los paréntesis de la llamada al
     * setter.
     *
     * @return
     */
    @Override
    public String getJavaInitializationString() {
        Colores colores = coloresPanel.getValoresSeleccionados();
        Color colorFondo = colores.getColorFondo();
        Color colorTexto = colores.getColorTexto();
        
        String cadena = "new componentecolortexto.Colores(new java.awt.Color("+colorFondo.getRGB()+"), new java.awt.Color("+colorTexto.getRGB()+"))";
        return cadena;
    }

    /**
     * getValue(). Una vez que NetBeans muestra el panel para permitir al
     * usuario programador la edición de la propiedad y se pulsa el botón
     * Aceptar, se llamará este método para obtener el valor de la propiedad del
     * panel. Es muy importante que este método devuelva un objeto del tipo de
     * la propiedad (Colores en este caso).
     *
     * @return
     */
    @Override
    public Object getValue() {
        return coloresPanel.getValoresSeleccionados();
    }

}