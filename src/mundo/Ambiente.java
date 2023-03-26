package mundo;


import java.util.Random;

/**
 *
 * @author Castillo
 */
public class Ambiente {
    
    private static Ambiente ambiente;
    private int[][] matriz;
    private int fila, columna, contarBasura;
    
    private Ambiente() {
    }
    
    
    public void crearAmbiente(int x, int y) {
        contarBasura = 0;
        columna = y;
        fila = x;
        Random random = new Random();
        matriz = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] = random.nextInt(2);
                if(matriz[i][j] == 1){
                    contarBasura++;
                }
            }
        }
        imprimirMatriz();
    }
    
    public static Ambiente getInstance() {
        if (ambiente == null) {
            ambiente = new Ambiente();
        }
        return ambiente;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public int getContarBasura() {
        return contarBasura;
    }

    public void imprimirMatriz(){
        for (int[] array : matriz) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
}
