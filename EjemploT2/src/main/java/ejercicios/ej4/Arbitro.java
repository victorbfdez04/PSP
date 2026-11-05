package ejercicios.ej4;

public class Arbitro {

    private int numeroAdivinar;
    private int turno;
    private int numJugadores;
    private boolean juegoTerminado;

    public Arbitro(int numJugadores) {

        this.numJugadores = numJugadores;
        this.numeroAdivinar = 1 + (int)(10 * Math.random());

        this.turno = 1 + (int)(numJugadores * Math.random()); //empieza al azar
        this.juegoTerminado = false;

        System.out.println("NUMERO A ADIVINAR: " + numeroAdivinar);
    }

    
    //mejor hacer mientras no haya terminado
    public synchronized boolean esperarTurno(int id) {

        try {
            while (!juegoTerminado && turno != id) {
                wait();
            }

            return !juegoTerminado;

        } catch (InterruptedException e) {
            System.out.println("Error en esperar turno: " + e);
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public synchronized void comprobarJugada(int id, int jugada) {

        System.out.println("JUGADOR " + id + " dice: " + jugada);

        if (jugada == numeroAdivinar) {

            juegoTerminado = true;

            System.out.println("El jugador " + id
                    + " ha adivinado el numero " + numeroAdivinar);

            notifyAll();

        } else {

            turno = 1 + (int)(numJugadores * Math.random());

            System.out.println("Le toca jugar al jugador " + turno);

            notifyAll();
        }
    }

    public synchronized boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}
