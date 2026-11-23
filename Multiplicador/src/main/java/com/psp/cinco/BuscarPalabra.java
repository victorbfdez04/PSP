package com.psp.cinco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Proceso hijo: cuenta las veces que aparece una palabra en files/<fichero>.
 * Uso: BuscarPalabra <fichero> <palabra>
 */
public class BuscarPalabra {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Faltan parametros. Uso: BuscarPalabra <fichero> <palabra>");
        }
        String fichero = args[0];
        String palabra = args[1].toLowerCase();
        if (palabra.isEmpty()) {
            //con una palabra vacia indexOf nunca devuelve -1 y el bucle seria infinito
            throw new Exception("La palabra a buscar no puede estar vacia");
        }
        int veces = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("files" + File.separator + fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase();
                int pos = linea.indexOf(palabra);
                while (pos != -1) {
                    veces++;
                    pos = linea.indexOf(palabra, pos + palabra.length());
                }
            }
        }
        System.out.println("En el fichero " + fichero + " se ha encontrado la palabra " + args[1] + " " + veces + " veces.");
    }
}