package com.psp.cinco;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class LanzarProcesos {

    public void buscarPalabra(String palabra) throws Exception {
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String clase = "com.psp.cinco.BuscarPalabra";
        ArrayList<Process> procesos = new ArrayList<Process>();
        ArrayList<String> nombres = new ArrayList<String>();

        File carpeta = new File("files");
        File[] contenido = carpeta.listFiles();
        if (contenido == null) {
            System.out.println("No existe la carpeta 'files' en " + new File(".").getAbsolutePath());
            return;
        }
        Arrays.sort(contenido);

        // Los resultados van a files/busqueda para no pisar los .res del ejercicio 4
        File salida = new File(carpeta, "busqueda");
        Files.createDirectories(salida.toPath());

        for (File f : contenido) {
            String nombre = f.getName();
            // Solo se buscan los ficheros de texto (.txt)
            if (f.isFile() && nombre.endsWith(".txt")) {
                ProcessBuilder pb = new ProcessBuilder(java, "-cp", classPath, clase, nombre, palabra);
                pb.redirectOutput(new File(salida, nombre + ".res"));
                pb.redirectError(new File(salida, nombre + ".err"));
                procesos.add(pb.start());
                nombres.add(nombre);
            }
        }
        for (int i = 0; i < procesos.size(); i++) {
            int exitValue = procesos.get(i).waitFor();
            if (exitValue == 0) {
                System.out.println(nombres.get(i) + " -> OK (resultado en files/busqueda/" + nombres.get(i) + ".res)");
            } else {
                System.out.println(nombres.get(i) + " -> ERROR. Exit Value: " + exitValue
                        + " (mira files/busqueda/" + nombres.get(i) + ".err)");
            }
        }
        System.out.println("Todos los procesos han terminado.");
    }

    public static void main(String[] args) throws Exception {
        String palabra = args.length > 0 ? args[0] : "permission";
        new LanzarProcesos().buscarPalabra(palabra);
    }
}
