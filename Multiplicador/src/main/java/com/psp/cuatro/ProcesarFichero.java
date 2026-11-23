package com.psp.cuatro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Proceso hijo: suma los numeros (uno por linea) del fichero files/<fichero>.
 * Uso: ProcesarFichero <fichero>
 */
public class ProcesarFichero {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Falta el nombre del fichero. Uso: ProcesarFichero <fichero>");
            System.exit(1);
        }
        long total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("files" + File.separator + args[0]))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    total = total + Long.parseLong(linea.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero '" + args[0] + "': " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("El fichero '" + args[0] + "' contiene una linea que no es un numero: " + e.getMessage());
            System.exit(1);
        }
        System.out.println(total);
    }
}
