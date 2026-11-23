package com.mycompany.Ejercicios;

import java.io.File;

public class LanzadorMultiplicador {

    public void lanzarMultiplicador(int n1, int n2, String ficheroSalida) {

        String clase = "com.mycompany.Ejercicios.Multiplicador";
        ProcessBuilder pb;

        try {

            File directorio = new File("files");

            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            File salida = new File(directorio, ficheroSalida);

            File error = new File(directorio,
                    "error" + System.currentTimeMillis() + ".log");

            File classpath = new File("target/classes");

            pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath.getAbsolutePath(),
                    clase,
                    String.valueOf(n1),
                    String.valueOf(n2)
            );

            pb.redirectOutput(salida);
            pb.redirectError(error);

            Process p = pb.start();

            int exitVal = p.waitFor();

            if (exitVal == 0) {
                System.out.println("El proceso ha terminado correctamente.");
            } else {
                System.out.println("El proceso ha terminado con errores.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        LanzadorMultiplicador l = new LanzadorMultiplicador();

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        l.lanzarMultiplicador(n1, n2, "resultado.txt");
    }
}
