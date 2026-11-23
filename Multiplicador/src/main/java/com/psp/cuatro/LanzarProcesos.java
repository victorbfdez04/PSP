package com.psp.cuatro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class LanzarProcesos {

    public void sumarContabilidades(String[] ficheros) throws Exception {
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String clase = "com.psp.cuatro.ProcesarFichero";
        ArrayList<Process> procesos = new ArrayList<Process>();

        Files.createDirectories(new File("files").toPath());

        //lanzar un hijo por fichero, sin esperar
        for (String fichero : ficheros) {
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", classPath, clase, fichero);
            pb.redirectOutput(new File("files" + File.separator + fichero + ".res"));
            pb.redirectError(new File("files" + File.separator + fichero + ".err"));
            procesos.add(pb.start());
        }

        //esperar a todos, como es en paralelo no se hace un wait for
        int[] exitValues = new int[ficheros.length];
        for (int i = 0; i < ficheros.length; i++) {
            exitValues[i] = procesos.get(i).waitFor();
        }

        //sumar los .res de los que han terminado bien
        long total = 0;
        boolean todoCorrecto = true;
        for (int i = 0; i < ficheros.length; i++) {
            if (exitValues[i] == 0) {
                long subtotal = leerNumero("files" + File.separator + ficheros[i] + ".res");
                System.out.println(ficheros[i] + ": " + subtotal);
                total = total + subtotal;
            } else {
                todoCorrecto = false;
                System.out.println(ficheros[i] + " ha terminado con errores. Exit Value: " + exitValues[i]
                        + " (mira files" + File.separator + ficheros[i] + ".err)");
            }
        }

        //guardar el total en resultado_final.txt
        try (FileWriter fw = new FileWriter("files" + File.separator + "resultado_final.txt")) {
            fw.write(String.valueOf(total));
        }
        if (todoCorrecto) {
            System.out.println("Total: " + total + " (guardado en files" + File.separator + "resultado_final.txt)");
        } else {
            System.out.println("Total INCOMPLETO: " + total + " (algun fichero ha fallado)");
        }
    }

    private long leerNumero(String ruta) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            if (linea == null) {
                throw new Exception("El fichero " + ruta + " esta vacio");
            }
            return Long.parseLong(linea.trim());
        }
    }

    public static void main(String[] args) throws Exception {
        String[] ficheros = {"informatica.txt", "comercio.txt", "administracion.txt", "eso.txt", "bachillerato.txt"};
        LanzarProcesos lp = new LanzarProcesos();
        lp.sumarContabilidades(ficheros);
    }
}
