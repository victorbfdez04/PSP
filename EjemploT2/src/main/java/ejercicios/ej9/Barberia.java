package ejercicios.ej9;

public class Barberia {

    // Constantes para cambiar fácilmente entre ejecuciones
    private static final int NUM_BARBEROS = 5;
    private static final int NUM_SILLAS = 10;
    private static final int NUM_CLIENTES = 50;

    private final Sillas sillas = new Sillas(NUM_SILLAS);
    private final Barbero[] barberos = new Barbero[NUM_BARBEROS];
    private final Cliente[] clientes = new Cliente[NUM_CLIENTES];

    public Barberia() {
        for (int i = 0; i < NUM_BARBEROS; i++) {
            barberos[i] = new Barbero("Barbero" + (i + 1), sillas);
        }
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes[i] = new Cliente("Cliente" + (i + 1), sillas);
        }
    }

    public void simular() throws InterruptedException {
        abrir();
        esperarClientes();
        cerrar();
    }

    private void abrir() {
        for (Barbero b : barberos) {
            b.start();
        }
        for (Cliente c : clientes) {
            c.start();
        }
    }

    private void esperarClientes() throws InterruptedException {
        for (Cliente c : clientes) {
            c.join();
        }
        System.out.println("Se han ido todos los clientes.");
    }

    // Interrumpe a los barberos para que terminen su trabajo
    private void cerrar() throws InterruptedException {
        for (Barbero b : barberos) {
            b.interrupt();
        }
        for (Barbero b : barberos) {
            b.join();
        }
        System.out.println("Barberia cerrada.");
    }
}