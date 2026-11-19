package ejercicios.ej6;

public class Boxeador extends Thread {

    private static final int GOLPES_PARA_NOQUEAR = 3;

    private Ring ring;
    private Boxeador rival;
    private int golpesDados;
    private int golpesRecibidos;
    private int golpesDesdeUltimoNoqueo;
    private boolean noqueado;

    public Boxeador(Ring ring, String id) {
        setName(id);
        this.ring = ring;
        this.golpesDados = 0;
        this.golpesRecibidos = 0;
        this.golpesDesdeUltimoNoqueo = 0;
        this.noqueado = false;
    }

    public void setRival(Boxeador rival) {
        this.rival = rival;
    }

    public Boxeador getRival() {
        return rival;
    }

    public synchronized void golpear() {
        golpesDados++;
    }

    public synchronized void recibirGolpe() {
        golpesRecibidos++;
        golpesDesdeUltimoNoqueo++;

        if (golpesDesdeUltimoNoqueo >= GOLPES_PARA_NOQUEAR) {
            noqueado = true;
            golpesDesdeUltimoNoqueo = 0;
        }
    }

    private synchronized boolean isNoqueado() {
        return noqueado;
    }

    private synchronized void recuperarse() {
        noqueado = false;
    }

    @Override
    public void run() {

        while (ring.getContadorCombates() < Ring.MAX_COMBATES) { //!ring.isFinalizado
            try {
                if (isNoqueado()) {
                    System.out.printf("-- %s está noqueado.%n", getName());
                    Thread.sleep(1000);
                    recuperarse();
                } else {
                    if (!ring.combatir(this, rival)) {
                        break;
                    }
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                
            }
        }
    }

    @Override
    public synchronized String toString() {
        return getName() + " [golpesDados=" + golpesDados
                + ", golpesRecibidos=" + golpesRecibidos + "]";
    }
}