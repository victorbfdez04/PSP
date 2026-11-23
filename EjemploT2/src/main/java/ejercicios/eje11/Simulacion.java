package ejercicios.eje11;

public class Simulacion {

    // Constantes para cambiar fácilmente entre ejecuciones
    private static final int NUM_CLIENTES = 300;
    private static final int NUM_PRODUCTOS = 100;

    private final Puerta puerta = new Puerta();
    private final Almacen almacen = new Almacen(NUM_PRODUCTOS);
    private final Cliente[] clientes = new Cliente[NUM_CLIENTES];

    public Simulacion() {
        // Todos los clientes comparten la misma puerta y el mismo almacén
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes[i] = new Cliente("Cliente" + (i + 1), puerta, almacen);
        }
    }

    public void simular() throws InterruptedException {
        abrir();
        esperarClientes();
        cerrar();
    }

    private void abrir() {
        for (Cliente c : clientes) {
            c.start();
        }
    }

    // Los clientes terminan solos (compran, no hay productos o se cansan)
    private void esperarClientes() throws InterruptedException {
        for (Cliente c : clientes) {
            c.join();
        }
    }

    private void cerrar() {
        System.out.println("Se han ido todos los clientes. Productos sin vender: "
                + almacen.getUnidades());
    }
}