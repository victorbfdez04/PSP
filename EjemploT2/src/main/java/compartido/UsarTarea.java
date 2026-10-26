package compartido;

public class UsarTarea {

	public static void main(String[] args) throws Exception {
		
		//recurso compartido
		Contador contador = new Contador();
				
		// Crear dos hilos que comparten contador y hacen lo mismo
		Tarea hilo1 = new Tarea(contador);
		Tarea hilo2 = new Tarea(contador);

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar a que ambos hilos terminen
        hilo1.join();
        hilo2.join();
        
        // Mostrar el valor final del contador
        System.out.println("Cuenta final: " + contador.getCuenta());

	}

}
