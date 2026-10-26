package ejercicios.ej2;

public class Principal {

	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.start();
		
		Cuenta cuenta = new Cuenta();
		cuenta.start();

	}

}
