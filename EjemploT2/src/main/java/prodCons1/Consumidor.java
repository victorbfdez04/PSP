package prodCons1;

public class Consumidor extends Thread {
	
	private Contador contador;
	public Consumidor() {
		this.contador = Contador.getInstance();
	}

	@Override
	public void run() {
		while(true) {
			try {
				contador.decrementar();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
