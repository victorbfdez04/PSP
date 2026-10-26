package ejercicios.ej2;

public class Cuenta {

    private int saldo = 0;
    private final int MAX_SALDO = 5000;
    private static Cuenta instance = null;

    private Cuenta(){
        
    }
    
    private synchronized static void createInstance() {
	if (null == instance) {
            instance = new Cuenta();
	}
    }
	
	public static Cuenta getInstance() {
		if(null == instance) {
			createInstance();
		}
		return instance;
	}
    
    // Método de ingreso sincronizado
    public synchronized boolean ingresar(int cantidad) {
        if (saldo + cantidad <= MAX_SALDO) {
            saldo += cantidad;
            System.out.println("Has ingresado + " + cantidad + " €. Saldo actual: " + saldo + " €");
            return true;
        } else {
            System.out.println("Supera el máximo€. Saldo actual: " + saldo + " €");
            return false;
        }
    }
    
    public synchronized boolean retirar(int cantidad){
        if(saldo -cantidad >= 0){
            saldo-=cantidad;            
            System.out.println("Has retirado + " + cantidad + " €. Saldo actual: " + saldo + " €");
            return true;
        } else {
            System.out.println("Saldo insuficiente. Saldo actual: " + saldo + " €");
            return false;
        }
    }
}
