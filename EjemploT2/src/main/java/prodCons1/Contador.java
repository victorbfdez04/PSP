package prodCons1;

public class Contador {
	private int cont = 100;
	private static Object object = new Object();
	private static Contador instance = null;

	private Contador() {
		
	}
	
	private synchronized static void createInstance() {
		if (null == instance) {
			instance = new Contador();
		}
	}
	
	public static Contador getInstance() {
		if(null == instance) {
			createInstance();
		}
		return instance;
	}
	
        
        //se sincroniza por objeto debido a que no todo el metodo puede ser necesario que se sincronice, asi que solo se sincroniza en el bloque deseado
        //se sincroniza la condicion debido a que pueden entrar dos a la vez y romper dicha condicion
	public void incrementar() {
		synchronized (object) {
			if (cont < 150) {
				cont = cont + 100;
				System.out.println("Contador incrementado: "+this.cont);
			}
		}		
	}
	
	public void decrementar() {
		synchronized (object) {
			if ( cont >= 50) {
				cont = cont - 50;
				System.out.println("Contador decrementado: "+this.cont);
			}
		}		
	}
}
