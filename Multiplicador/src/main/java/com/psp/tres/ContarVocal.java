package com.psp.tres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Proceso hijo: cuenta cuantas veces aparece una vocal en un fichero.
 * Uso: ContarVocal <fichero> <vocal>
 * Por la salida estandar escribe SOLO el numero (el padre lo lee de ahi).
 * Si algo falla, escribe por la salida de error y termina con exit value 1.
 */
public class ContarVocal {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Faltan parametros. Uso: ContarVocal <fichero> <vocal>");
            System.exit(1);
        }

        String nombreFichero = args[0];
        String vocalBuscada = args[1].toLowerCase();

        if (vocalBuscada.length() != 1 || "aeiou".indexOf(vocalBuscada.charAt(0)) == -1) {
            System.err.println("El segundo parametro debe ser una vocal (a, e, i, o, u): " + args[1]);
            System.exit(1);
        }

        char objetivo = vocalBuscada.charAt(0);
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase();
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == objetivo) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero '" + nombreFichero + "': " + e.getMessage());
            System.exit(1);
        }

        System.out.println(contador);
    }
}
