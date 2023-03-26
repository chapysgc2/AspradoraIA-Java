package mundo;



/**
 *
 * @author Castillo
 */
public class AgenteAspiradora {
    
    public static void main(String[] args) {
        Ambiente ambiente = Ambiente.getInstance();
        ambiente.crearAmbiente(20, 20);
        
        Aspiradora robot = Aspiradora.getIntance();

        robot.update(ambiente, 0, 0);
        robot.start();
        System.out.println("Terminado");
        ambiente.imprimirMatriz();
    }
    
}
