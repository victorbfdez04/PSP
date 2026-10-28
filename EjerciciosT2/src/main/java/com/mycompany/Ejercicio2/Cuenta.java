package com.mycompany.Ejercicio2;

/**
 * Cuenta bancaria compartida por los dos clientes (Ingresa y Cobra)
 *
 * Es un singleton: solo existe una instancia, de modo que ambos hilos
 * trabajan sobre el mismo saldo. Los métodos que leen o modifican el
 * saldo son synchronized: bloquean la propia instancia, así que solo un
 * hilo a la vez puede ejecutarlos y se evitan condiciones de carrera
 */
public class Cuenta {

    /** Dinero máximo que puede tener la cuenta (5000 €) */
    private static final int MAXIMO = 5000;

    /** Saldo actual de la cuenta, empieza en 0 € */
    private int saldo = 0;

    /** Única instancia de la cuenta (patrón singleton) */
    private static Cuenta instance = null;

    /**
     * Constructor privado: impide crear cuentas con "new" desde fuera
     * La única forma de obtener la cuenta es getInstance()
     */
    private Cuenta() {
    }

    /**
     * Crea la instancia si todavía no existe, es synchronized para que
     * solo se cree una cuenta aunque dos hilos lleguen a la vez
     */
    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Cuenta();
        }
    }

    /**
     * Devuelve la única instancia de Cuenta, creándola si es necesario
     */
    public static synchronized Cuenta getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    /**
     * Devuelve el saldo actual, está sincronizado para leer un valor
     * coherente mientras otro hilo podría estar modificándolo
     */
    public synchronized int getSaldo() {
        return saldo;
    }

    /**
     * Intenta ingresar dinero en la cuenta, solo lo hace si, tras el
     * ingreso, el saldo no supera el máximo permitido
     *
     * Al ser el método synchronized, la comprobación y la modificación
     * son una operación indivisible
     */
    public synchronized boolean ingresar(int importe) {
        if (saldo + importe <= MAXIMO) {
            saldo = saldo + importe;
            System.out.println("Ingresa: +" + importe + " € -> saldo: " + saldo + " €");
            return true;
        }

        System.out.println("Ingresa: no puede ingresar " + importe
                + " € (máximo " + MAXIMO + " €), saldo: " + saldo + " €");
        return false;
    }

    /**
     * Intenta retirar dinero de la cuenta, solo lo hace si hay saldo
     * suficiente para el importe pedido
     */
    public synchronized boolean retirar(int importe) {
        if (saldo >= importe) {
            saldo = saldo - importe;
            System.out.println("Cobra: -" + importe + " € -> saldo: " + saldo + " €");
            return true;
        }

        System.out.println("Cobra: saldo insuficiente para retirar "
                + importe + " €, saldo: " + saldo + " €");
        return false;
    }
}