package ejercicios.ej9;

import java.util.LinkedList;
import java.util.Queue;

// Recurso compartido (monitor): gestiona las sillas y la cola de clientes pendientes
public class Sillas {

    private final boolean[] ocupada;
    private final int[] servicios;                    // veces que se ha atendido cada silla
    private final Queue<Integer> pendientes = new LinkedList<>(); // FIFO: evita inanición

    public Sillas(int numSillas) {
        ocupada = new boolean[numSillas];
        servicios = new int[numSillas];
    }

    // El cliente busca silla. Si no hay, devuelve false. Si hay, espera a ser atendido.
    public synchronized boolean sentarseYEsperar(String cliente) throws InterruptedException {
        int silla = buscarLibre();
        if (silla == -1) {
            return false;
        }
        ocupada[silla] = true;
        pendientes.add(silla);
        int ticket = servicios[silla];
        System.out.println("El cliente " + cliente + " se ha sentado en la silla:" + silla);
        System.out.println(cliente + " estoy sentado en la silla:" + silla);
        notifyAll(); // avisa a los barberos

        while (servicios[silla] == ticket) {
            wait();
        }
        return true;
    }

    // El barbero espera hasta que haya una silla ocupada y coge la más antigua
    public synchronized int siguienteSilla() throws InterruptedException {
        while (pendientes.isEmpty()) {
            wait();
        }
        return pendientes.poll();
    }

    // El barbero termina: la silla se desocupa y se avisa al cliente
    public synchronized void liberar(int silla, String barbero) {
        ocupada[silla] = false;
        servicios[silla]++;
        System.out.println("-- Silla " + silla + " liberada por " + barbero);
        notifyAll();
    }

    private int buscarLibre() {
        for (int i = 0; i < ocupada.length; i++) {
            if (!ocupada[i]) {
                return i;
            }
        }
        return -1;
    }
}