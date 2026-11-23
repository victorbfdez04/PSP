import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo3 {

	public static void main(String[] args) throws Exception {

		Process p;
		InputStream er = null;
		BufferedReader bReader=null;
		try {
			// Ejecutamos el proceso dir de forma erronea
			p = new ProcessBuilder("CMD", "/C", "DIRR").start();
						
			int exitValue = p.waitFor();
			if (exitValue != 0) {			
				// Mostramos linea a linea la salida genrada por DIR
				er = p.getErrorStream();
				bReader = new BufferedReader(new InputStreamReader(er));
				String linea=null;
				while( (linea = bReader.readLine()) != null) {
					System.out.println("ERROR >"+linea);
				}
			}
			System.out.println(exitValue);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != bReader) {
				bReader.close();
			}
			if (null != er) {
				er.close();
			}
		}
	}

}
