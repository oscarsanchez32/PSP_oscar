package actividadSincronizada;

/**
 *
 * @author oscar
 */
public class Productor implements Runnable{
    private ColaSincronizada colaSincronizada;
    
    public Productor(ColaSincronizada colaSincronizada){
        this.colaSincronizada = colaSincronizada;
    }
    
    @Override
    public void run (){
        int i = 1;
        while(true){
            colaSincronizada.put(i++);
        }
    }
}
