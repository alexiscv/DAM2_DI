/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alexis
 */
public class JPanelImagen extends JPanel implements Serializable {

    // Propiedades que serán editables desde las opciones de netbeans
    private ImagenFondo imagenFondo;
    private boolean ratonPresionado = false;
    private Point puntoPresion;
    private ArrastreListener arrastreListener;

    // Contructor sin parametros, obligatorio
    public JPanelImagen() {

        // Creamos un Listener para intentar detectar cuando 
        // Se pulsa dentro de la imagen y se arrastra
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (ratonPresionado) {
                    // Recogemos la posicióna ctual del ratón
                    Point posicionActual = e.getPoint();
                    // Si la diferencia de coordenadas es mayor de 50
                    // Se ha arrastrado
                    if (Math.abs(puntoPresion.x - posicionActual.x) > 50) {

                        // Comprobamos que el arrastreListener esté definido
                        // porque si lo intentamos ejecutar sin que esté definido nos dará un
                        // nullPointerException
                        if ( arrastreListener != null ) {
                            arrastreListener.arrastre();
                        }

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ratonPresionado = true;
                puntoPresion = e.getPoint();

            }

        });
    }

    /**
     *
     * Añadimos un método para que quien use nuestro componente pueda definir el
     * arrastreListener
     *
     * @param arrastreListener
     */
    public void addArrastreListener(ArrastreListener arrastreListener) {
        this.arrastreListener = arrastreListener;
    }

    /**
     * También añadimos un método para cargarnos el arrastreListener
     */
    public void removeArrastreListener() {
        this.arrastreListener = null;
    }

    // Métodos
    public ImagenFondo getImagenfondo() {
        return imagenFondo;
    }

    public void setImagenfondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
        repaint(); // Para repintar la imagen
    }

    /**
     * Método para pintar la imagen en el fondo del panel
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Controlamos que el código solo se ejecute si 
        // imagenFondo no es null, sino nos devolvería un nullPointerException
        if (imagenFondo != null) {
            // Comprobamos que la propiedad rutaImagen no es nula y que el fichero
            // al que apunta existas
            if (imagenFondo.getRutaImagen() != null && imagenFondo.getRutaImagen().exists()) {
                // Recoger la imagen
                ImageIcon imageIcon = new ImageIcon(imagenFondo.getRutaImagen().getAbsolutePath());

                // Opacidad
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imagenFondo.getOpacidad()));

                // Printarla
                g.drawImage(imageIcon.getImage(), 0, 0, null);

                // Devolvemos la opacidad original despues de imprimir la imagen en pantalla
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
        }
    }

}
