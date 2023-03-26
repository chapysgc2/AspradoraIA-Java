
package iaaspiradora;

import javax.swing.UIManager;

/**
 *
 * @author alain
 */
public class Main {

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ventana().setVisible(true);     
            }
        }); 
    }
}