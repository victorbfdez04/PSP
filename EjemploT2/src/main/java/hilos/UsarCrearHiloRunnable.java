package hilos;

public class UsarCrearHiloRunnable {

	public static void main(String[] args) {
		
		CrearHiloRunnable hilo = new CrearHiloRunnable("Victor");
		Thread t = new Thread(hilo); 
		t.start();

	}

}
