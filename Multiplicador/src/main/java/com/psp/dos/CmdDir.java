package com.psp.dos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Lanza el comando "dir" (en Windows) y muestra por consola lo que escribe.
 * En Linux/Mac usa "ls -l" para que tambien funcione.
 */
public class CmdDir {

    public void ejecutarDir() throws IOException, InterruptedException {
        boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
        ProcessBuilder pb;
        Charset charset = Charset.defaultCharset();
        if (windows) {
            // cmd = interprete de comandos, /C = "ejecuta esto y termina", dir = el comando
            pb = new ProcessBuilder("cmd", "/C", "dir");
            // La consola de Windows usa la pagina de codigos 850 (acentos y enes)
            if (Charset.isSupported("Cp850")) {
                charset = Charset.forName("Cp850");
            }
        } else {
            pb = new ProcessBuilder("ls", "-l");
        }
        pb.redirectErrorStream(true); // mezcla error y salida en un solo flujo

        Process process = pb.start();

        // IMPORTANTE: primero se lee la salida y despues se espera al proceso.
        // Si se hace al reves y la salida es grande, el hijo se bloquea (buffer lleno).
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), charset))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            System.out.println("El comando ha terminado con errores. Exit Value: " + exitValue);
        }
    }

    public static void main(String[] args) throws Exception {
        new CmdDir().ejecutarDir();
    }
}
