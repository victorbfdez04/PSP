package com.mycompany.Ejercicio2;

/**
 * Cliente que se dedica a retirar dinero de la cuenta
 *
 * Es un hilo (extiende Thread) y retira 300 € cada vez, siempre que la
 * cuenta tenga saldo suficiente, y espera 3 segundos después de cada
 * intento, pueda retirar o no, no puede cobrar más de 6000 € en total
 */
public class Cobra extends Thread {

    /** Importe que intenta retirar en cada operación */
    private static final int IMPORTE = 300;

    /** Tiempo de espera tras cada intento: 3 segundos en milisegundos */
    private static final long ESPERA = 3000;

    /** Máximo total que puede cobrar este cliente (6000 €) */
    private static final int MAX_COBRO = 6000;

    /** Cuenta compartida sobre la que opera */
    private Cuenta cuenta;

    /** Total cobrado hasta el momento (solo cuenta las retiradas realizadas) */
    private int totalCobrado = 0;

    /**
     * Constructor: obtiene la instancia única de la cuenta, la misma
     * que usa el cliente Ingresa
     */
    public Cobra() {
        this.cuenta = Cuenta.getInstance();
    }

    /**
     * Cuerpo del hilo, se ejecuta cuando se llama a start()
     */
    @Override
    public void run() {
        // Sigue mientras la próxima retirada no supere el límite de 6000 €
        while (totalCobrado + IMPORTE <= MAX_COBRO) {
            try {
                // Solo suma al total si la retirada se ha realizado de verdad
                if (cuenta.retirar(IMPORTE)) {
                    totalCobrado += IMPORTE;
                }

                // Espera 3 segundos, haya podido cobrar o no
                Thread.sleep(ESPERA);
            } catch (InterruptedException e) {
                // Salta si otro hilo interrumpe a este mientras duerme
                e.printStackTrace();
            }
        }

        System.out.println("Cobra se marcha del banco (total cobrado: "
                + totalCobrado + " €)");
    }
}