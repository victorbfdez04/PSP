package ejercicios.ej2;

/**
 * Cliente que se dedica a retirar dinero de la cuenta
 *
 * Retira 300 € cada vez, siempre que haya saldo suficiente, y espera
 * 3 segundos después de cada intento, pueda retirar o no.
 * Termina al haber cobrado 6000 € en total.
 */
public class Cobra extends Thread {

    private static final int COBRO = 300;
    private static final int MAX_TOTAL = 6000;
    private static final long ESPERA = 3000;

    private final Cuenta cuenta;

    public Cobra() {
        this.cuenta = Cuenta.getInstance();
    }

    @Override
    public void run() {
        int cobrosTotales = 0;

        while (cobrosTotales < MAX_TOTAL) {
            // Solo se suma si la retirada se ha hecho
            if (cuenta.retirar(COBRO)) {
                cobrosTotales += COBRO;
            }

            try {
                Thread.sleep(ESPERA);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Cobra se marcha del banco (ha cobrado "
                + cobrosTotales + " €)");
    }
}