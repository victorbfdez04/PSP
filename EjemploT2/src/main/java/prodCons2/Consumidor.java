package prodCons2;

public class Consumidor extends Thread {
	
	private Contador contador;
	public Consumidor(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		while(true) { //se ejecuta infinitamente
			try {
				contador.decrementar();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
