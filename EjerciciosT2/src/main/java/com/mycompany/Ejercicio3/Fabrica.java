package com.mycompany.Ejercicio3;

/**
 * Fábrica que crea lotes de ladrillos para la constructora y los guarda
 * en el almacén
 *
 * Es un hilo (extiende Thread), crea lotes de 450 ladrillos y, después de
 * cada lote, los trabajadores esperan 3 segundos, cuando ha producido
 * 13500 ladrillos en total, la fábrica cierra
 */
public class Fabrica extends Thread {

    /** Tamaño de cada lote fabricado */
    private static final int LOTE = 450;

    /** Producción máxima total: 13500 ladrillos (30 lotes) */
    private static final int MAX_PRODUCCION = 13500;

    /** Espera tras cada lote: 3 segundos en milisegundos */
    private static final long ESPERA = 3000;

    /** Almacén compartido donde deposita los lotes */
    private Almacen almacen;

    /** Total de ladrillos ya producidos y guardados (solo cuenta lotes almacenados) */
    private int totalProducido = 0;

    /**
     * Constructor: obtiene la instancia única del almacén, la misma que
     * usan las obras
     */
    public Fabrica() {
        this.almacen = Almacen.getInstance();
    }

    /**
     * Cuerpo del hilo, se ejecuta cuando se llama a start()
     */
    @Override
    public void run() {
        // Produce mientras el siguiente lote no supere el tope de 13500
        while (totalProducido + LOTE <= MAX_PRODUCCION) {
            try {
                // Solo cuenta el lote si el almacén ha podido guardarlo entero
                if (almacen.guardar(LOTE)) {
                    totalProducido += LOTE;
                }

                // Los trabajadores esperan 3 segundos antes de continuar
                Thread.sleep(ESPERA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La fábrica cierra (total producido: "
                + totalProducido + " ladrillos)");
    }
}