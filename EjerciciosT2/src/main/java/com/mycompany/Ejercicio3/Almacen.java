package com.mycompany.Ejercicio3;

/**
 * Almacén de ladrillos compartido por la fábrica y las obras
 *
 * Es un singleton: solo existe una instancia, de modo que la fábrica y
 * las dos obras trabajan sobre el mismo stock, los métodos que leen o
 * modifican los ladrillos son synchronized: bloquean la propia instancia,
 * así que solo un hilo a la vez puede ejecutarlos
 */
public class Almacen {

    /** Ocupación máxima del almacén: 6000 ladrillos */
    private static final int MAXIMO = 6000;

    /** Ladrillos almacenados actualmente, empieza vacío */
    private int ladrillos = 0;

    /** Única instancia del almacén (patrón singleton) */
    private static Almacen instance = null;

    /**
     * Constructor privado: impide crear almacenes con "new" desde fuera
     */
    private Almacen() {
    }

    /**
     * Crea la instancia si todavía no existe, es synchronized para que
     * solo se cree un almacén aunque dos hilos lleguen a la vez
     */
    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Almacen();
        }
    }

    /**
     * Devuelve la única instancia del almacén, creándola si es necesario
     */
    public static synchronized Almacen getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    /**
     * Devuelve los ladrillos almacenados en este momento
     */
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
        if (ladrillos >= lote) {
            ladrillos = ladrillos - lote;
            System.out.println(obra + ": -" + lote
                    + " ladrillos -> almacén: " + ladrillos);
            return true;
        }

        System.out.println(obra + ": material insuficiente para "
                + lote + " ladrillos, almacén: " + ladrillos);
        return false;
    }
}