package com.mycompany.Ejercicio2;

/**
 * Cliente que se dedica a ingresar dinero en la cuenta
 *
 * Es un hilo (extiende Thread): su trabajo se ejecuta en el método run()
 * Ingresa 500 € cada vez (si no se supera el máximo de la cuenta) y
 * espera 2 segundos después de cada intento, pueda ingresar o no
 * Termina cuando ha dormido como mínimo 90 segundos
 */
public class Ingresa extends Thread {

    /** Importe que intenta ingresar en cada operación */
    private static final int IMPORTE = 500;

    /** Tiempo de espera tras cada intento: 2 segundos en milisegundos */
    private static final long ESPERA = 2000;

    /** Tiempo mínimo que debe haber dormido para marcharse: 90 segundos en milisegundos */
    private static final long MIN_DORMIDO = 90 * 1000;

    /** Cuenta compartida sobre la que opera */
    private Cuenta cuenta;

    /**
     * Constructor: obtiene la instancia única de la cuenta, la misma
     * que usará el cliente Cobra
     */
    public Ingresa() {
        this.cuenta = Cuenta.getInstance();
    }

    /**
     * Cuerpo del hilo, se ejecuta cuando se llama a start()
     */
    @Override
    public void run() {
        // Acumulador del tiempo total que lleva durmiendo
        long tiempoDormido = 0;

        // Ingresa hasta que haya dormido como mínimo 90 segundos (45 vueltas de 2 s)
        while (tiempoDormido < MIN_DORMIDO) {
            try {
                // Intenta ingresar, pueda o no, no importa el resultado aquí
                cuenta.ingresar(IMPORTE);

                // Espera 2 segundos y los suma al tiempo dormido
                Thread.sleep(ESPERA);
                tiempoDormido += ESPERA;
            } catch (InterruptedException e) {
                // Salta si otro hilo interrumpe a este mientras duerme
                e.printStackTrace();
            }
        }

        System.out.println("Ingresa se marcha del banco (ha dormido "
                + (tiempoDormido / 1000) + " s)");
    }
}