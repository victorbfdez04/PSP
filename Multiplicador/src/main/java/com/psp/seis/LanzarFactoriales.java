package com.psp.seis;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LanzarFactoriales {

    public void calcular(int[] numeros) throws Exception {
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String clase = "com.psp.seis.CalcularFactorial";
        ArrayList<Process> procesos = new ArrayList<Process>();

        // Se lanzan todos a la vez...
        for (int n : numeros) {
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", classPath, clase, String.valueOf(n));
            procesos.add(pb.start());
        }

        // ...y se recogen los resultados en orden
        for (int i = 0; i < procesos.size(); i++) {
            Process process = procesos.get(i);
            int exitValue = process.waitFor();
            if (exitValue == 0) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                }
            } else {
                System.out.println("El proceso del numero " + numeros[i] + " ha fallado. Exit Value: " + exitValue);
                try (BufferedReader er = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                    String linea;
                    while ((linea = er.readLine()) != null) {
                        System.out.println("ERROR > " + linea);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] numeros = {20, 25, 30, 2, 7, 13};
        new LanzarFactoriales().calcular(numeros);
    }
}
