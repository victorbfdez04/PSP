package ejercicios.eje10;

public class Consumidor extends Thread {

    private static final int ESPERA_VACIA = 2000; // ms

    private final Cola cola;

    public Consumidor(String nombre, Cola cola) {
        super(nombre);
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                // sacar() devuelve false si la cola está vacía
                if (!cola.sacar(getName())) {
                    System.out.println("    " + getName() + " cola vacía, espera 2s");
                    // La espera es fuera del monitor: no bloquea a los demás hilos
                    Thread.sleep(ESPERA_VACIA);
                }
                // Si ha leído vuelve a intentarlo
            }
        } catch (InterruptedException e) {
            // El consumidor termina
        }
    }
}