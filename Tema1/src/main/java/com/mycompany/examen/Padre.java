package com.mycompany.examen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Padre {

    public static void main(String[] args) {
        // Crear los triángulos uno a uno y meterlos en la lista
        List<Triangulo> listaTriangulos = new ArrayList<>();

        Triangulo t1 = new Triangulo(10, 5);
        listaTriangulos.add(t1);

        Triangulo t2 = new Triangulo(8, 12);
        listaTriangulos.add(t2);

        Triangulo t3 = new Triangulo(3, 7);
        listaTriangulos.add(t3);

        Triangulo t4 = new Triangulo(15, 20);
        listaTriangulos.add(t4);

        String classpath = ".;./target/classes";
        String clase = "com.mycompany.examen.Triangulo";

        List<Process> listaProcesos = new ArrayList<>();

        // 1. Lanzar un proceso hijo por cada triángulo
        for (int i = 0; i < listaTriangulos.size(); i++) {
            Triangulo t = listaTriangulos.get(i);
            ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                classpath,
                clase,
                String.valueOf(t.getBase()),
                String.valueOf(t.getAltura())
            );

            try {
                listaProcesos.add(pb.start());
            } catch (Exception e) {
                System.err.println("Error al lanzar el proceso " + (i + 1) + ": " + e.getMessage());
            }
        }

        // 2. Leer la salida de cada hijo
        for (int i = 0; i < listaProcesos.size(); i++) {
            Process proceso = listaProcesos.get(i);

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()))) {

                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Salida Triángulo " + (i + 1) + ": " + linea);
                }

                proceso.waitFor();

            } catch (Exception e) {
                System.err.println("Error al leer el proceso " + (i + 1) + ": " + e.getMessage());
            }
        }
    }
}