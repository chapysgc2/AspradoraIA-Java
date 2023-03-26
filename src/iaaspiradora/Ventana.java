
package iaaspiradora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author alain
 */
public class Ventana extends javax.swing.JFrame implements ChangeListener{
    
    private Dimension dimension;
    private Toolkit toolkit;
    private int widthScreen, heightScreen, width, height;
    public CargarAspiradora cargaraspiradora;
    public ControlValidacion controlValidacion;
    private Ambt ambt;
     public final String[] listWidth = {"20" , "30"};
    
    public Ventana() {
        initComponents();
        ambt = new Ambt(this);
        
        controlValidacion = new ControlValidacion(this);
        panelCuadricula.setLayout(new BorderLayout());
        panelCuadricula.add(ambt, "Center");
        cargaraspiradora = new CargarAspiradora(2, 2);
        botonInicio.add(cargaraspiradora, "Center");        
        listadedimensiones.addActionListener( controlValidacion);
        botonInicio.addActionListener( controlValidacion);       
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        widthScreen = dimension.width;
        heightScreen = dimension.height;
        width = getWidth();
        height = getHeight();
        setMinimumSize(new Dimension(width, height));
        setLocation((widthScreen - width) / 2, (heightScreen - height) / 2);
        setDefaultCloseOperation(3);
        setTitle("Agente Aspiradora");
        
        
    }
    public void setEvmSize(int width, int height){     
        ambt.crearMatriz(width, height);
    }
 
    
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listadedimensiones = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        contadordebasura = new javax.swing.JLabel();
        botonInicio = new javax.swing.JButton();
        panelCuadricula = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dimensiones");

        listadedimensiones.setFont(new java.awt.Font("Times New Roman", 0, 12));
        listadedimensiones.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"20", "30" }));
        listadedimensiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadedimensionesActionPerformed(evt);
            }
        });

        jLabel2.setText("Basura Restante");

        contadordebasura.setText("00");

        botonInicio.setText("Iniciar");
        botonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                botonInicioActionPerformed(evt);
                 //VentanaCronometro ventanaCronometro = new VentanaCronometro();
                
                 //VentanaCronometro.setVisible(true);
            }
        });

        panelCuadricula.setBackground(new java.awt.Color(255, 255, 255));
        panelCuadricula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuadricula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        javax.swing.GroupLayout panelCuadriculaLayout = new javax.swing.GroupLayout(panelCuadricula);
        panelCuadricula.setLayout(panelCuadriculaLayout);
        panelCuadriculaLayout.setHorizontalGroup(
            panelCuadriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        panelCuadriculaLayout.setVerticalGroup(
            panelCuadriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(listadedimensiones, 0, 120, Short.MAX_VALUE)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contadordebasura, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(panelCuadricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(99, 99, 99)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listadedimensiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(contadordebasura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonInicio)
                .addContainerGap(586, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(panelCuadricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }

    private void listadedimensionesActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void botonInicioActionPerformed(java.awt.event.ActionEvent evt) {
        //aqui va el cronometro cuando le da al boton iniciar.
        VentanaCronometro ventanaCronometro = new VentanaCronometro();
        ventanaCronometro.setVisible(true);
        ventanaCronometro.iniciarCronometro();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    
    public javax.swing.JButton botonInicio;
    public javax.swing.JLabel contadordebasura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JComboBox listadedimensiones;
    private javax.swing.JPanel panelCuadricula;
    

    public JComboBox getlistadedimensiones() {
        return listadedimensiones;
    }

    public JButton getbotonInicio() {
        return botonInicio;
    }

    public void estadoCambiado(ChangeEvent e) {
        Ambt.setSpeed(5);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   


}
