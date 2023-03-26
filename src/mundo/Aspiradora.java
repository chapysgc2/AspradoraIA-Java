package mundo;

import mundo.Ambiente;

import iaaspiradora.Ambt;
import iaaspiradora.IAmbt;
import iaaspiradora.IAspiradora;
import iaaspiradora.NuevoAmbt;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Castillo
 */
public class Aspiradora implements IAspiradora{
    
    
  
    private static Aspiradora aspiradora;
    private Ambiente ambiente;
    Ambt ambt;
    private int i, j;
    public int pasos;
    public int radio, contador;

    private Aspiradora() {
    }

    public static Aspiradora getIntance() {
        if (aspiradora == null) {
            aspiradora = new Aspiradora();
        }
        return aspiradora;
    }

    public void update(Ambiente nuevoambiente, int valueI, int valueJ) {
        this.ambiente = nuevoambiente;
        i = valueI;
        j = valueJ;
    }

    public void start() {
       
        System.out.println("POSICION INICIAL DE LA ASPIRADORA: " + i + ", " + j);
        contador = ambiente.getContarBasura(); 
        System.out.println("CANTIDAD DE BASURA: " + ambiente.getContarBasura());

        
        if (ambiente.getMatriz()[i][j] == 1) {
            contador--;
            LimpiarBasura();
            System.out.println("BASURA RECOGIDA: " + contador);
            
        }

        
        Point point = null;
        while (contador != 0) {
            point = buscarBasura(); //la funcion retornó la posicion de la basura 
            mover(point.x, point.y); //el robot se mueve a la posición de basura
            contador--;
            LimpiarBasura(); // en la matriz se cambia de 1 a 0
            System.out.println("TOTAL DE BASURA: " + contador);
            System.out.println("PASOS: " + pasos);
        }
        terminado();
    }

  
    private Point buscarBasura() {
        ArrayList<Point> listado = new ArrayList<Point>(); // matriz con las distancias de cada basura
        radio = 0; // radio de barrido del robot

        // El radio crece de 1, 2, 3 hasta que encuentra basura
        while (true) {
            radio++;
            
            for (int d = 0; d <= radio; d++) {
                if (condicionExiste(i + d, j - radio) && ambiente.getMatriz()[i + d][j - radio] == 1) {
                    listado.add(new Point(d, -radio));
                }
                if (condicionExiste(i - d, j + radio) && ambiente.getMatriz()[i - d][j + radio] == 1) {
                    listado.add(new Point(-d, radio));
                }
                if (condicionExiste(i - radio, j - d) && ambiente.getMatriz()[i - radio][j - d] == 1) {
                    listado.add(new Point(-radio, -d));
                }
                if (condicionExiste(i + radio, j + d) && ambiente.getMatriz()[i + radio][j + d] == 1) {
                    listado.add(new Point(radio, d));
                }
                if (d != 0 || d != radio) {
                    if (condicionExiste(i - d, j - radio) && ambiente.getMatriz()[i - d][j - radio] == 1) {
                        listado.add(new Point(-d, -radio));
                    }
                    if (condicionExiste(i + d, j + radio) && ambiente.getMatriz()[i + d][j + radio] == 1) {
                        listado.add(new Point(d, radio));
                    }
                    if (condicionExiste(i - radio, j + d) && ambiente.getMatriz()[i - radio][j + d] == 1) {
                        listado.add(new Point(-radio, d));
                    }
                    if (condicionExiste(i + radio, j - d) && ambiente.getMatriz()[i + radio][j - d] == 1) {
                        listado.add(new Point(radio, -d));
                    }
                }               
                // Cuando vea basura, el agente devolverá la distancia entre el robot y la basura
                if (!listado.isEmpty()) {
                    Random random = new Random();
                    return listado.get(random.nextInt(listado.size()));
                }
            }
        }
    }

    // método para que el agente se mueva a la posición de basura
    private void mover(int fila, int columna) {
        if (fila != 0 && columna != 0) {
            moverFila(fila);
            moverColumna(columna);
            return;
        }

        if (fila == 0) {
            moverColumna(columna);
            return;
        }

        if (columna == 0) {
            moverFila(fila);
            return;
        }
    }


    // método para que el robot siga la columna
    private void moverColumna(int columna) {
        if (columna > 0) {
            while (columna-- != 0) {
                moverDerecha();
            }
        } else {
            while (columna++ != 0) {
                moverIzquierda();
            }
        }
    }

    // método para que el robot siga la fila
    private void moverFila(int fila) {
        if (fila > 0) {
            while (fila-- != 0) {
                moverAbajo();
            }
        } else {
            if (fila < 0) {
                while (fila++ != 0) {
                    moverArriba();
                }
            }
        }
    }

    // comprobar si la posición existe en la matriz
    private boolean condicionExiste(int x, int y){
        if(0 <= x && x < ambiente.getFila() &&
                0 <= y && y < ambiente.getColumna()){
            return true;
        }else{
            return false;
        }
    }

    private void moverArriba() {
        pasos++;
        i = i - 1;
        System.out.println("MOVER ASPIRADORA HACIA ARRIBA:  " + i + ", "+ j);
        arriba();
        return;
    }

    private void moverAbajo() {
        pasos++;
        i = i + 1;
        System.out.println("MOVER ASPIRADORA HACIA ABAJO: " + i + ", "+ j);
        abajo();
        return;
    }

    private void moverIzquierda() {
        pasos++;
        j = j - 1;
        System.out.println("MOVER ASPIRADORA HACIA LA IZQUIERDA: " + i + ", "+ j);
        izquierda();
        return;
    }

    private void moverDerecha() {
        pasos++;
        j = j + 1;
        System.out.println("MOVER ASPIRADORA HACIA LA DERECHA: " + i + ", "+ j);
        derecha();
        return;
    }

    private void LimpiarBasura() {
        ambiente.getMatriz()[i][j] = 0;
        System.out.println("ESCANEAR EN LA UBICACIÓN: " + i + ", " + j);
        System.out.println("ESTADO DE LA MATRIZ:");
        ambiente.imprimirMatriz();
        pintarAspirado();
        return;
    }

    public void registry(Ambt iEvm) {
        this.ambt = iEvm;
    }

    public void arriba() {
        ambt.pintarMoverArriba();
    }

    public void abajo() {
        ambt.pintarMoverAbajo();
    }

    public void izquierda() {
       ambt.pintarMoverIzquierda();
    }

    public void derecha() {
       ambt.pintarMoverDerecha();
    }

    public void terminado() {
         ambt.limpiezaTerminada();
    }

    public void pintarAspirado() {
        ambt.pintarAspirado();
    }

    /*public void commitRadar() {
        ambt.updateRadar();
    }*/

    public boolean isReady(){
        return ambiente != null;
    }

   public int getPasos(){
   return pasos;
   }
   

    
    
}
