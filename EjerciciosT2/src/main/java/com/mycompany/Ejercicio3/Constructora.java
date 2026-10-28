package com.mycompany.Ejercicio3;

/**
 * Clase principal del ejercicio: la constructora abre la fábrica y las dos
 * obras, que comparten el almacén, y no cierra hasta que todas terminen
 */
public class Constructora {

    /**
     * Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("La constructora abre");

        // Todos obtienen el mismo Almacén compartido
        Fabrica fabrica = new Fabrica();
        Obra obra1 = new Obra("Obra1", 200, 4000);
        Obra obra2 = new Obra("Obra2", 400, 2000);

        // start() lanza cada uno en su propio hilo, de forma concurrente
        fabrica.start();
        obra1.start();
        obra2.start();

        // La constructora no cierra hasta que las obras y la fábrica cierren
        try {
            fabrica.join();
            obra1.join();
            obra2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La constructora cierra, ladrillos en el almacén: "
                + Almacen.getInstance().getLadrillos());
    }
}