package ejercicios.ej8;

import java.util.Random;

public class Filosofo extends Thread {

    private final int numero;
    private final Cubierto primero;  // el de menor id: siempre se coge antes
    private final Cubierto segundo;
    private final Random random = new Random();

    public Filosofo(int numero, Cubierto izquierdo, Cubierto derecho) {
        super("Filosofo " + numero);
        this.numero = numero;
        // Orden global de adquisición: evita interbloqueo (deadlock)
        if (izquierdo.getId() < derecho.getId()) {
            this.primero = izquierdo;
            this.segundo = derecho;
        } else {
            this.primero = derecho;
            this.segundo = izquierdo;
        }
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                comer();
                pensar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void comer() throws InterruptedException {
        primero.coger();
        try {
            segundo.coger();
            try {
                System.out.println("Filosofo " + numero + " está comiendo");
                Thread.sleep(1000 + random.nextInt(2000)); // come entre 1 y 3 s
            } finally {
                segundo.soltar();
            }
        } finally {
            primero.soltar();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("El filósofo " + numero + " está pensando");
        Thread.sleep(1000 + random.nextInt(4001)); // entre 1 y 5 s
    }
}