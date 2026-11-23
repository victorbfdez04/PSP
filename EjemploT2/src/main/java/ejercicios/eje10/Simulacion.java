package ejercicios.eje10;

public class Simulacion {

    // Inicializamos 3 productores y 2 consumidores, se puede cambiar
    private static final int NUM_PRODUCTORES = 3;
    private static final int NUM_CONSUMIDORES = 2;
    private static final int TAMANO_COLA = 5;

    // Una única cola compartida por todos los hilos
    private final Cola cola = new Cola(TAMANO_COLA);
    private final Productor[] productores = new Productor[NUM_PRODUCTORES];
    private final Consumidor[] consumidores = new Consumidor[NUM_CONSUMIDORES];

    public Simulacion() {
        // Todos reciben la misma cola
        for (int i = 0; i < NUM_PRODUCTORES; i++) {
            productores[i] = new Productor("Productor" + (i + 1), cola);
        }
        for (int i = 0; i < NUM_CONSUMIDORES; i++) {
            consumidores[i] = new Consumidor("Consumidor" + (i + 1), cola);
        }
    }

    public void simular() throws InterruptedException {
        arrancar();
        esperar();
    }

    // Lanzar los hilos
    private void arrancar() {
        for (Productor p : productores) {
            p.start();
        }
        for (Consumidor c : consumidores) {
            c.start();
        }
    }

    // Los hilos trabajan indefinidamente
    private void esperar() throws InterruptedException {
        for (Productor p : productores) {
            p.join();
        }
        for (Consumidor c : consumidores) {
            c.join();
        }
    }
}