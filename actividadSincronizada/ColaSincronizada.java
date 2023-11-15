package actividadSincronizada;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author oscar
 */
public class ColaSincronizada {
    private ArrayList<Integer> contenedor = new ArrayList<>();
    
    public synchronized void put(int value){
        contenedor.add(value);
        System.out.println("El productor produce: " + value);
        //Despertamos al consumidor si está esperando
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public synchronized int get(){
        while(contenedor.isEmpty()){
            try{
                wait(); //Esperará si el contenedor está vacío
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        int value = contenedor.remove(0);
        System.out.println("El consumidor consume: " + value);
        try {
            Thread.sleep(new Random().nextInt(500)); //Tiempo de espera aleatorio para el consumidor, que será menor
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        return value;
    }
}
