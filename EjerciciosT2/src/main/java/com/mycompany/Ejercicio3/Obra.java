package com.mycompany.Ejercicio3;

/**
 * Obra de la constructora que gasta ladrillos del almacén
 *
 * Es un hilo (extiende Thread), la misma clase sirve para las dos obras,
 * cada una se diferencia por su nombre, el lote que gasta y el descanso
 * de sus albañiles:
 *  - Obra1: lotes de 200 ladrillos, descanso de 4 segundos
 *  - Obra2: lotes de 400 ladrillos, descanso de 2 segundos
 *
 * Por el convenio especial, las obras solo trabajan durante 2 minutos
 */
public class Obra extends Thread {

    /** Duración del funcionamiento de la obra: 2 minutos en milisegundos */
    private static final long MAX_TIME = 2 * 60 * 1000;

    /** Nombre de la obra (para los mensajes) */
    private String nombre;

    /** Ladrillos que intenta retirar en cada ocasión */
    private int lote;

    /** Descanso de los albañiles tras cada intento, en milisegundos */
    private long descanso;

    /** Instante en que la obra empieza a funcionar */
    private long initTime;

    /** Almacén compartido del que retira material */
    private Almacen almacen;

    /**
     * Constructor
     */
    public Obra(String nombre, int lote, long descanso) {
        this.nombre = nombre;
        this.lote = lote;
        this.descanso = descanso;
        this.almacen = Almacen.getInstance();
    }

    /**
     * Cuerpo del hilo, se ejecuta cuando se llama a start()
     */
    @Override
    public void run() {
        // La obra solo está en funcionamiento durante 2 minutos
        initTime = System.currentTimeMillis();

        while ((System.currentTimeMillis() - initTime) <= MAX_TIME) {
            try {
                // Intenta retirar el material, pueda o no, los albañiles descansan
                almacen.retirar(nombre, lote);
                Thread.sleep(descanso);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(nombre + " cierra (han pasado 2 minutos)");
    }
}