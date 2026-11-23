import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Ejemplo2 {

	public static void main(String[] args) throws Exception {

		ProcessBuilder pb;
		InputStream is = null;
		try {
			// Ejecutamos el proceso dir
			pb = new ProcessBuilder("CMD", "/C", "DIR");
			Process p = pb.start();
			
			int exitVal = p.waitFor(); //espera hasta que el proceso actual termine y devuelve 0 si se ha ejecutado bien    
			if (exitVal == 0) {			
				// Mostramos caracter a caracter la salida generada por DIR
				is = p.getInputStream();
				int c;
				while( (c = is.read()) != -1) {
					System.out.print((char) c);
				}
			}
			else {
				//Mostrar error por el canal de error
				is = p.getErrorStream();
				int c;
				while( (c = is.read()) != -1) {
					System.out.print((char) c);
				}
			}
			
			
			System.out.println("");
			System.out.println("Valor de salida: "+ exitVal);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != is) {
				is.close();
			}
		}
	}

}
