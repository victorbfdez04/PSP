package ejercicios.eje10;

import java.util.Random;

public class Productor extends Thread {

    private static final int ESPERA_LLENA = 1000;     //ms
    private static final int TIEMPO_PRODUCCION = 500;
    private static final int MAX_NUMERO = 100;

    private final Cola cola;
    private final Random random = new Random();

    public Productor(String nombre, Cola cola) {
        super(nombre);
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                int numero = random.nextInt(MAX_NUMERO);
                
                // Reintenta con el MISMO numero hasta conseguirlo
                while (!cola.poner(numero, getName())) {
                    System.out.println(getName() + " cola llena, espera 1s con el " + numero);
                    Thread.sleep(ESPERA_LLENA);
                }
                Thread.sleep(TIEMPO_PRODUCCION);
            }
        } catch (InterruptedException e) {
            // El productor termina
        }
    }
}