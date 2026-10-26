package hilos;

public class UsarCrearHilos {
	public static void main(String[] args) throws Exception{
		Thread.currentThread().setName("UsarCrearHilos");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		for(int i=0; i<3; i++) {
			CrearHilos h =new CrearHilos("CrearHilos "+i); //crear hilo
			h.setName("HILO"+i);  //damos nombre al hilo
			h.setPriority(i + 1); //damos prioridad
			h.start();  //iniciar hilo, se llama al start que llama al run
			
			//System.out.println("Informaci�n del "+h.getName()+" : "+h.toString());
		}			
		
		System.out.println("3 HILOS CREADOS .... ");
		System.out.println("Hilos activos: "+ Thread.activeCount());
		
	}
}
