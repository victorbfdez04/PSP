package ejercicios.ej2;

/**
 * RECURSO COMPARTIDO
 *
 * Es un singleton: solo existe una instancia, de modo que ambos hilos trabajan sobre el mismo saldo
 */
public class Cuenta {

    private static final int MAXIMO = 5000;
    private int saldo = 0;

    private static Cuenta instance = null;

    /**
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
        
        boolean exito = false;
        
        if (saldo + importe <= MAXIMO) {
            saldo = saldo + importe;
            System.out.println("Ingresa: +" + importe + " € -> saldo: " + saldo + " €");
            exito = true;
        } else{
            System.out.println("Ingresa: no puede ingresar " + importe
                + " € (máximo " + MAXIMO + " €), saldo: " + saldo + " €");
        }
        
        return exito;

    }

    /**
     * Intenta retirar dinero de la cuenta, solo lo hace si hay saldo
     * suficiente para el importe pedido
     */
    public synchronized boolean retirar(int importe) {
        
        boolean exito = false;
        
        if (saldo >= importe) {
            saldo = saldo - importe;
            System.out.println("Cobra: -" + importe + " € -> saldo: " + saldo + " €");
            exito = true;
        } else {
            System.out.println("Cobra: saldo insuficiente para retirar "
                + importe + " €, saldo: " + saldo + " €");        
        }

        return exito;
    }
}