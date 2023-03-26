
package iaaspiradora;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author alain
 */
public class CargarAspiradora extends JPanel{
    
     private Image imagen;
    private int ancho, largo;   
    private boolean habilitar = true;
    private int x, y;

    public CargarAspiradora(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        imagen = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        g.drawImage(imagen, x, y, ancho, largo, null);
    }

    public void setActivar(boolean b) {
        habilitar = b;
    }
    
}
