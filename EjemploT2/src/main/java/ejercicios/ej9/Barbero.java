package ejercicios.ej9;

public class Barbero extends Thread {

    private static final int TIEMPO_ATENCION = 250; // milisegundos

    private final Sillas sillas;

    public Barbero(String nombre, Sillas sillas) {
        super(nombre);
        this.sillas = sillas;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                int silla = sillas.siguienteSilla();
                System.out.println(getName() + " atendiendo silla: " + silla);
                Thread.sleep(TIEMPO_ATENCION);
                sillas.liberar(silla, getName());
            }
        } catch (InterruptedException e) {
            // La barbería cierra: el barbero termina
        }
    }
}