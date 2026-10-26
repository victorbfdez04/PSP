package virtualthread;

import java.util.ArrayList;
import java.util.List;

public class UsarCrearHiloVirtualRunnable {

	public static void crearHiloVirtual() throws Exception {
		
		CrearHiloVirtualRunnable hilo = new CrearHiloVirtualRunnable("Santa virtual");
		Thread vt = Thread.startVirtualThread(hilo);
		//hago join, pq sino el main termina inmediatamente.
		//La JVM puede finalizar antes de que el Virtual Thread complete su trabajo.
		//me espero a que termine
		vt.join();
		
	}
	
	public static void crearMuchosHilosVirtuales() throws Exception {
		//esto seria muy costoso con hilos tradicionales 
		//con hilos virtuales funcionará sin problemas 
		//porque durante el sleep() los carrier threads se reutilizan continuamente
		
		List<Thread> lista = new ArrayList();
		for (int i = 0; i < 1000; i++) {
			CrearHiloVirtualRunnable hilo = new CrearHiloVirtualRunnable("VT-"+i);
			Thread vt =Thread.startVirtualThread(hilo);
			lista.add(vt);
		}
		
		for(Thread vt: lista) {
			vt.join();
		}
				
	}
	
	public static void main(String[] args) throws Exception {
		
		//comprobar la version de Java
		System.out.println(Runtime.version());
		
		//crearHiloVirtual();
		
		crearMuchosHilosVirtuales();
		
		
		
	}

}
