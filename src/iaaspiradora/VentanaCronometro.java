/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iaaspiradora;

/**
 *
 * @author alain
 */
import javax.swing.*;
import java.awt.event.*;

public class VentanaCronometro extends JFrame {
    private JLabel label;
    private Timer timer;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
  
    public VentanaCronometro() {
        super("Cronómetro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("00:00:00");
        add(label);
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                    if (minutos == 60) {
                        minutos = 0;
                        horas++;
                    }
                }
                String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
                label.setText(tiempo);
            }
        });
    }
    
    public void iniciarCronometro() {
        timer.start();
    }
    
    public void detener() {
        timer.stop();
    }
}
