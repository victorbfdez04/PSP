package com.psp.uno;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Lanza el proceso Multiplicador y guarda su salida en files/<fNombreSalida>.
 */
public class LanzadorMultiplicador {

    public void lanzarMultiplicador(int n1, int n2, String fNombreSalida) throws IOException, InterruptedException {
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String clase = "com.psp.uno.Multiplicador";

        Files.createDirectories(new File("files").toPath());

        ProcessBuilder pb = new ProcessBuilder(java, "-cp", classPath, clase,
                String.valueOf(n1), String.valueOf(n2));
        pb.redirectOutput(new File("files" + File.separator + fNombreSalida));
        pb.redirectError(new File("files" + File.separator + "error_" + fNombreSalida));

        Process process = pb.start();
        int exitValue = process.waitFor();

        // Exit value 0 = todo correcto
        if (exitValue == 0) {
            System.out.println("El proceso ha terminado correctamente. Exit Value: " + exitValue);
        } else {
            System.out.println("El proceso ha terminado con errores. Exit Value: " + exitValue
                    + " (mira files" + File.separator + "error_" + fNombreSalida + ")");
        }
    }

    public static void main(String[] args) throws Exception {
        LanzadorMultiplicador l = new LanzadorMultiplicador();
        l.lanzarMultiplicador(6, 7, "salida1.log");
        l.lanzarMultiplicador(8, 9, "salida2.log");
    }
}
