package ejercicios.ej8;

public class Cubierto {

    private final int id;
    private boolean ocupado = false;

    public Cubierto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized void coger() throws InterruptedException {
        while (ocupado) {
            wait();
        }
        ocupado = true;
    }

    public synchronized void soltar() {
        ocupado = false;
        notifyAll();
    }
}