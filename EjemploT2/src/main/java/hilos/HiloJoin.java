package hilos;

public class HiloJoin extends Thread {
	
	@Override
	public void run() {
		System.out.println("En el HiloJoin ...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
