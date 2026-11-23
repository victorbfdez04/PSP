package ejercicios.eje11;

public class Cliente extends Thread {

    private static final int MAX_INTENTOS = 10;
    private static final int ESPERA_PUERTA = 500;  // ms
    private static final int TIEMPO_DENTRO = 20;   // ms que tarda en cruzar la puerta

    private final Puerta puerta;
    private final Almacen almacen;

    public Cliente(String nombre, Puerta puerta, Almacen almacen) {
        super(nombre);
        this.puerta = puerta;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            if (intentarEntrar()) {
                cruzar();
            } else {
                System.out.println(getName() + ": lo intenté muchas veces y no pude");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Máximo 10 intentos; si falla, espera medio segundo fuera de la puerta
    private boolean intentarEntrar() throws InterruptedException {
        boolean dentro = false;
        int intentos = 0;
        while (!dentro && intentos < MAX_INTENTOS) {
            dentro = puerta.intentarEntrar();
            intentos++;
            if (!dentro) {
                Thread.sleep(ESPERA_PUERTA);
            }
        }
        return dentro;
    }

    // Cruza la puerta, intenta coger un producto y libera la puerta
    private void cruzar() throws InterruptedException {
        Thread.sleep(TIEMPO_DENTRO);
        boolean cogido = almacen.coger();
        puerta.salir();
        if (cogido) {
            System.out.println(getName() + ": cogí un producto!");
        } else {
            System.out.println(getName() + ": ops, crucé pero no cogí nada");
        }
    }
}