package ejercicios.ej8;

public class Cena {

    private static final int NUM_FILOSOFOS = 5;

    private final Cubierto[] cubiertos = new Cubierto[NUM_FILOSOFOS];
    private final Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];

    public Cena() {
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            cubiertos[i] = new Cubierto(i);
        }
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Cubierto izquierdo = cubiertos[i];
            Cubierto derecho = cubiertos[(i + 1) % NUM_FILOSOFOS];
            filosofos[i] = new Filosofo(i + 1, izquierdo, derecho);
        }
    }

    public void iniciar() {
        for (Filosofo f : filosofos) {
            f.start();
        }
    }
}