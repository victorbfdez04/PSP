package hilos;

/**
 * Usar este modo si necesitamos heredar de otra clase
 */
public class CrearHiloRunnable implements Runnable {
	
	private String nombre;
	public CrearHiloRunnable(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		//Acciones que lleva a cabo el hilo
		System.out.println("Hola soy "+nombre
				+"\n Prioridad: "+Thread.currentThread().getPriority()
				+"\n ID: "+Thread.currentThread().threadId()
				+"\n Hilos activos: "+Thread.activeCount());
		
	}

}
