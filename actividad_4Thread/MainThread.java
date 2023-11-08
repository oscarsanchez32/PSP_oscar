/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_4Thread;

/**
 *
 * @author oscar
 */
public class MainThread {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Pedro", new int[] { 1, 3, 5, 1, 1 });

        long initialTime = System.currentTimeMillis();

        TenderaThread tendera1 = new TenderaThread("Charo", cliente1, initialTime);
        TenderaThread tendera2 = new TenderaThread("Patricia", cliente2, initialTime);

        // Iniciar los hilos para procesar a los clientes de forma paralela
        tendera1.start();
        tendera2.start();

        // Esperar a que ambos hilos terminen
        try {
            tendera1.join();
            tendera2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ambas Tenderas han terminado de procesar los clientes en: " +
                (System.currentTimeMillis() - initialTime) / 1000 + "seg");
    }
}


