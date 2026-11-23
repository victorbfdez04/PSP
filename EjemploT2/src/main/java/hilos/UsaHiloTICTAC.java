package hilos;

/**
 * Main hace uso de los hilos TIC TAC
 * ¿Se visualizan los texto TIC TAC de forma ordenada?
 * @author santa
 */
public class UsaHiloTICTAC {

    private static final long TIEMPO_MAX = 5000; //5 segundos en milisegundos

    public static void main(String[] args) {
        // Creo los hilos
        HiloTIC hTIC = new HiloTIC();
        HiloTAC hTAC = new HiloTAC();

        long tiempoInicio = System.currentTimeMillis();

        // Los arranco
        hTIC.start();
        hTAC.start();

        while (System.currentTimeMillis() < tiempoInicio + TIEMPO_MAX) {
            // Espera activa hasta que pasen los 5 segundos
        }

        System.out.println("Fin del programa");
    }
}