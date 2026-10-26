package prodCons1;

public class Productor extends Thread {
	
	private static final long MAX_TIME = 2 * 60 * 1000; //2 minutos en ms
        
	private long initTime;
	
	private Contador contador=null;
	public Productor() {
		this.contador = Contador.getInstance();
	}

	@Override
	public void run() {
                //guarda el instante exacto previo a entrar al bucle
		initTime = System.currentTimeMillis();
		
		while ((System.currentTimeMillis() - initTime) <= MAX_TIME) { //mientras que la resta entre la hora actual y la de inicio sea <= a 2 minutos
			
			try {
				contador.incrementar();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	
}
