package ejercicios.eje10;

import java.util.LinkedList;

// Recurso compartido
public class Cola {

    private final int capacidad;
    private final LinkedList<Integer> numeros = new LinkedList<>();

    public Cola(int capacidad) {
        this.capacidad = capacidad;
    }

    // Pone el número en la última posición
    // Devuelve false si la cola está llena
    public synchronized boolean poner(int numero, String productor) {
        boolean puesto = false;
        if (numeros.size() < capacidad) {
            numeros.addLast(numero);
            puesto = true;
            System.out.println(productor + " introduce el " + numero
                    + " (en cola: " + numeros.size() + "/" + capacidad + ")");
        }
        return puesto;
    }

    // Lee el primer número
    // Devuelve false si la cola está vacía
    public synchronized boolean sacar(String consumidor) {
        boolean leido = false;
        if (!numeros.isEmpty()) {
            int numero = numeros.removeFirst();
            leido = true;
            System.out.println("    " + consumidor + " saca el " + numero
                    + " (en cola: " + numeros.size() + "/" + capacidad + ")");
        }
        return leido;
    }
}