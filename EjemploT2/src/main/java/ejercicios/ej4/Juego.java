
package ejercicios.ej4;

public class Juego {

    public static void main(String[] args) {

        int numJugadores = 3;

        // Creamos el árbitro
        Arbitro arbitro = new Arbitro(numJugadores);

        // Creamos e iniciamos los jugadores
        for (int i = 1; i <= numJugadores; i++) {

            Jugador jugador = new Jugador(i, arbitro);

            jugador.start();
        }
    }
}
