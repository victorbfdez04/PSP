package hilos;

public class CrearHilos extends Thread {
	
	
	public CrearHilos(String nombre) {
		this.setName(nombre);
	}
	
	@Override
	public void run() {
		
		//Acciones que lleva a cabo el hilo
		System.out.println("Hola soy "+Thread.currentThread().getName()
				+"\n Prioridad: "+Thread.currentThread().getPriority()
				+"\n ID: "+Thread.currentThread().threadId()
				+"\n Hilos activos: "+Thread.activeCount());
				
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
