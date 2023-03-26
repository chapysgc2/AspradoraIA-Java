
package iaaspiradora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mundo.Ambiente;
import mundo.Aspiradora;

/**
 *
 * @author alain
 */
public class ControlValidacion implements ActionListener{
    private Ventana ventana;
    private Ambiente ambiente;
    private Aspiradora robot;
    
    
    public ControlValidacion(Ventana ventana) {
        this.ventana = ventana;
        ambiente = Ambiente.getInstance();
        robot = Aspiradora.getIntance();
        //dar tama�o inicial de la cuadricula
        ambiente.crearAmbiente(20, 20);
        ventana.setEvmSize(20, 20);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventana.getlistadedimensiones())) {
            String opcion = (String) ventana.getlistadedimensiones().getSelectedItem();
            if (opcion.equals(ventana.listWidth[0])){
                ambiente.crearAmbiente(5 , 5);
                ventana.setEvmSize(5 , 5);
        }
            if (opcion.equals(ventana.listWidth[0])) {
                ambiente.crearAmbiente(20, 20);
                ventana.setEvmSize(20, 20);
            }
            if (opcion.equals(ventana.listWidth[1])) {
                ambiente.crearAmbiente(30, 30);
                ventana.setEvmSize(30, 30);
            }            
        }                   
        if (e.getSource().equals(ventana.getbotonInicio())) {    
            new Thread() {

                @Override
                public void run() {
                    ventana.listadedimensiones.setEnabled(false);
                    ventana.cargaraspiradora.setActivar(false);
                    ventana.botonInicio.setEnabled(false);
                    robot.start();
                    ventana.listadedimensiones.setEnabled(true);
                    ventana.cargaraspiradora.setActivar(true);
                    ventana.botonInicio.setEnabled(true);
                }
            }.start();
        }
    }
    
    
}
