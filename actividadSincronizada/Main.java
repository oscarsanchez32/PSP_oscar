/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadSincronizada;

/**
 *
 * @author oscar
 */
public class Main {
    public static void main (String [] args){
        ColaSincronizada colaSincronizada = new ColaSincronizada();
        
        //Creamos hilos, uno para el productor y otro para el consumidor
        Thread productorThread = new Thread(new Productor(colaSincronizada));
        Thread consumidorThread = new Thread(new Consumidor(colaSincronizada));
        
        //Iniciamos los hilos
        productorThread.start();
        consumidorThread.start();
    }
}
