package ejercicios.ej3;

/**
 * Almacén de ladrillos compartido por la fábrica y las obras
 * RECURSO COMPARTIDO
 * Es un singleton: solo existe una instancia, de modo que la fábrica y
 * las dos obras trabajan sobre el mismo stock, los métodos que leen o
 * modifican los ladrillos son synchronized: bloquean la propia instancia,
 * así que solo un hilo a la vez puede ejecutarlos
 */
public class Almacen {

    private static final int MAXIMO = 6000;
    private int ladrillos = 0;

    private static Almacen instance = null;

    private Almacen() {
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Almacen();
        }
    }

    public static synchronized Almacen getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    public synchronized int getLadrillos() {
        return ladrillos;
    }

    /**
     * Intenta guardar un lote completo, si no hay hueco para el lote
     * entero, no se guarda nada (no se admiten lotes parciales)
     */
    public synchronized boolean guardar(int lote) {
        if (ladrillos + lote <= MAXIMO) {
            ladrillos = ladrillos + lote;
            System.out.println("Fábrica: +" + lote
                    + " ladrillos -> almacén: " + ladrillos);
            return true;
        }

        System.out.println("Fábrica: no hay hueco para " + lote
                + " ladrillos, almacén: " + ladrillos);
        return false;
    }

    /**
     * Intenta retirar material para una obra, solo lo hace si hay
     * ladrillos suficientes para el lote pedido
     */
    public synchronized boolean retirar(String obra, int lote) {
        
        boolean exito = false;
        if (ladrillos >= lote) {
            ladrillos = ladrillos - lote;
            System.out.println(obra + ": retira " + lote
                    + " ladrillos -> almacén: " + ladrillos);            
            exito = true;
        } else {
            System.out.println(obra + ": material insuficiente para "
                + lote + " ladrillos, almacén: " + ladrillos);        
        }
        return exito;
    }
}