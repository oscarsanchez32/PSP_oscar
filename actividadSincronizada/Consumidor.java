package actividadSincronizada;

/**
 *
 * @author oscar
 */
public class Consumidor implements Runnable{
    private ColaSincronizada colaSincronizada;
    
    public Consumidor(ColaSincronizada colaSincronizada) {
        this.colaSincronizada = colaSincronizada;
    }
 
    @Override
    public void run() {
        while (true) {
            colaSincronizada.get();
        }
    }
}
