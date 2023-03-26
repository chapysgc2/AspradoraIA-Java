
package iaaspiradora;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mundo.Ambiente;
import mundo.Aspiradora;
import iaaspiradora.IAmbt;
import java.awt.Color;
import static jdk.vm.ci.common.InitTimer.timer;


/**
 *
 * @author alain
 */
public class Ambt extends JPanel implements IAmbt{
    
    private int[][] matriz;
    private int anchoCuadro, largoCuadro;
    private int anchoAmbt, largoAmbt;
    private Image imgBasura, imgPiso, imgAspiradora, imgAspirado;
    
    private int xAgente=0, yAgente=0;
    private int xUbicacionAgente=0, yUbicacionAgente=0;
    private int xRadar = - 1, yRadar = -1;
    private boolean moverse=true;
   
    
    private Ambiente ambiente;
    private Aspiradora aspiradora;
    private static int velocidad = 5;
    private Ventana ventana;
    public Ambt(Ventana v) {
        this.ventana = v;
        imgBasura = new ImageIcon(getClass().getResource("/Imagenes/basura.png")).getImage();
        imgPiso = new ImageIcon(getClass().getResource("/Imagenes/piso.jpg")).getImage();
        imgAspiradora = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        imgAspirado = null;
        ambiente = Ambiente.getInstance();
        aspiradora = Aspiradora.getIntance();
        aspiradora.registry(Ambt.this);
        
       
    
    }

   public void crearMatriz(int widthEvm, int heightEvm) {
        this.anchoAmbt = widthEvm;
        this.largoAmbt = heightEvm;
        this.matriz = new int[widthEvm][heightEvm];
        anchoCuadro = getWidth() / widthEvm;
        largoCuadro = getHeight() / heightEvm;
        matriz = ambiente.getMatriz();
       
        ventana.contadordebasura.setText(String.valueOf(ambiente.getContarBasura()));
        //------
        repaint(); 
   }

    @Override
    protected void paintComponent(Graphics g) {
        if (anchoAmbt != 0) {
            anchoCuadro = getWidth() / anchoAmbt;
            largoCuadro = getHeight() / largoAmbt;
        }
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //Crear cuadricula la imagen del piso
        for (int i = 0; i < anchoAmbt; i++) {
            for (int j = 0; j < largoAmbt; j++) {
                Point point = new Point(j * anchoCuadro, i * largoCuadro);
                g2.drawImage(imgPiso, point.x, point.y, anchoCuadro, largoCuadro, this);
                if (matriz[i][j] == 1) {//Cuando es 1, poner imagen de basura
                    g2.drawImage(imgBasura, point.x, point.y, anchoCuadro, largoCuadro, this);
                }
            }
        }
             
       
        if (moverse) {
                g2.drawImage(imgAspiradora, xUbicacionAgente, yUbicacionAgente, anchoCuadro - anchoCuadro / 3, largoCuadro - largoCuadro / 3, this);
            } else {
                xUbicacionAgente = xAgente * anchoCuadro + anchoCuadro / 5;
                yUbicacionAgente = yAgente * largoCuadro;
                g2.drawImage(new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage(), xUbicacionAgente, yUbicacionAgente, anchoCuadro - anchoCuadro / 3, largoCuadro - largoCuadro / 3, this);
            
        }
       
        g2.drawImage(imgAspirado, xUbicacionAgente, yUbicacionAgente, anchoCuadro - anchoCuadro / 3, largoCuadro - largoCuadro / 3, this);
        aspiradora.update(ambiente, yAgente, xAgente);
        repaint();

    }
      

   

    public void pintarMoverArriba() {
        imgAspiradora = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        moverse = true;
       
        yAgente -= 1;
        final int yLocationRobotTemp = yAgente * largoCuadro;
        xUbicacionAgente = xAgente * anchoCuadro + anchoCuadro / 5;
        while (true) {
            yUbicacionAgente--;
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
            }
            if (yUbicacionAgente == yLocationRobotTemp) {
                break;
            }
        }
        moverse = false;
    }

    public void pintarMoverAbajo() {
        imgAspiradora = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        moverse = true; 
       
        yAgente += 1;
        final int yLocationRobotTemp = yAgente * largoCuadro;
        xUbicacionAgente = xAgente * anchoCuadro + anchoCuadro / 5;
        while (true) {
            yUbicacionAgente++;
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
            }
            if (yUbicacionAgente == yLocationRobotTemp) {
                break;
            }
        }
        moverse = false;
    }

    public void pintarMoverIzquierda() {
       imgAspiradora = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        moverse = true; 
        
        xAgente -= 1;
        final int xLocationRobotTemp = xAgente * anchoCuadro + anchoCuadro / 5;
        yUbicacionAgente = yAgente * largoCuadro;
        while (true) {
            xUbicacionAgente--;
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
            }
            if (xUbicacionAgente == xLocationRobotTemp) {
                break;
            }
        }
        moverse = false;
    }

    public void pintarMoverDerecha() {
        imgAspiradora = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        moverse = true;       
        
        xAgente += 1;
        final int xLocationRobotTemp = xAgente * anchoCuadro + anchoCuadro / 5;
        yUbicacionAgente = yAgente * largoCuadro;
        while (true) {
            xUbicacionAgente++;
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
            }
            if (xUbicacionAgente == xLocationRobotTemp) {
                break;
            }
        }
        moverse = false;
    }

    public void limpiezaTerminada() {
        repaint();
        //timer.stop()
        JOptionPane.showConfirmDialog(this, "La aspiradora limpió toda la basura. Recorrió " +aspiradora.getPasos() +" cuadros", "", -1);
    }

    public void pintarAspirado() {
        imgAspirado = new ImageIcon(getClass().getResource("/Imagenes/aspiradora.png")).getImage();
        ventana.contadordebasura.setText(String.valueOf(aspiradora.contador));
        repaint();
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }
        imgAspirado = null;
    }
    

    public static void setSpeed(int velocidad) {
        Ambt.velocidad = velocidad;
    }

    
}
