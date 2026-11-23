package com.psp.tres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;

public class LanzarProcesos {

    public void contarVocales(String fichero) throws Exception {
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String clase = "com.psp.tres.ContarVocal";
        String[] vocales = {"a", "e", "i", "o", "u"};
        ArrayList<Process> procesos = new ArrayList<Process>();

        Files.createDirectories(new File("files").toPath());

        // FASE 1: lanzar los 5 hijos SIN esperar a ninguno
        for (String vocal : vocales) {
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", classPath, clase, fichero, vocal);
            pb.redirectOutput(new File("files" + File.separator + "resultado_" + vocal + ".txt"));
            pb.redirectError(new File("files" + File.separator + "error_" + vocal + ".log"));
            procesos.add(pb.start());
        }

        // FASE 2: esperar a que terminen los 5
        int[] exitValues = new int[vocales.length];
        for (int i = 0; i < vocales.length; i++) {
            exitValues[i] = procesos.get(i).waitFor();
        }

        // FASE 3: recoger resultados y sumar
        int total = 0;
        boolean todoCorrecto = true;
        for (int i = 0; i < vocales.length; i++) {
            if (exitValues[i] == 0) {
                int subtotal = leerNumero("files" + File.separator + "resultado_" + vocales[i] + ".txt");
                System.out.println("Vocal " + vocales[i] + ": " + subtotal);
                total = total + subtotal;
            } else {
                todoCorrecto = false;
                System.out.println("La vocal " + vocales[i] + " ha terminado con errores. Exit Value: " + exitValues[i]
                        + " (mira files" + File.separator + "error_" + vocales[i] + ".log)");
            }
        }
        if (todoCorrecto) {
            System.out.println("Total de vocales: " + total);
        } else {
            System.out.println("Total de vocales INCOMPLETO: " + total + " (algun proceso ha fallado)");
        }
    }

    private int leerNumero(String ruta) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            if (linea == null) {
                throw new Exception("El fichero " + ruta + " esta vacio");
            }
            return Integer.parseInt(linea.trim());
        }
    }

    public static void main(String[] args) throws Exception {
        LanzarProcesos lp = new LanzarProcesos();
        lp.contarVocales("text.txt");
    }
}
