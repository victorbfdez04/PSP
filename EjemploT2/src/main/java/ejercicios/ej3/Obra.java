package ejercicios.ej3;

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

    private static final long MAX_TIME = 2 * 60 * 1000;
    private String nombre;
    private int lote;
    private long descanso;
    private long initTime;
    private Almacen almacen;

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