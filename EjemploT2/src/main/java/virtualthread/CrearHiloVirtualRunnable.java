package virtualthread;

public class CrearHiloVirtualRunnable implements Runnable {
	
	private String nombre;
	public CrearHiloVirtualRunnable(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		//Acciones que lleva a cabo el hilo
		System.out.println("Hola soy "+nombre
				+"\n Soy virtual: "+Thread.currentThread().isVirtual()
				+"\n ID: "+Thread.currentThread().threadId());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
