package hilos;

public class HiloIsAlive extends Thread {
	
	@Override
	public void run() {
		System.out.println("En el HiloIsAlive ...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
