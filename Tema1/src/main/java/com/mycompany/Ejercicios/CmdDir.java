/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ejercicios;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author b15-01m
 */
public class CmdDir {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb;
        InputStream is = null;

        try{
            pb = new ProcessBuilder("CMD", "/C", "DIR");
            Process p = pb.start();
            
            int exitVal = p.waitFor();
            //Lee un carácter/byte del flujo. Lo guarda en c. 
            //Mientras no sea -1 (fin del flujo), lo convierte a char.
            //Lo imprime en la consola.
            if(exitVal==0){
                is = p.getInputStream();
                int c;
                while((c = is.read()) != -1){
                    System.out.print((char) c);
                }
            } else {
                is = p.getErrorStream();
                int c;
                while((c = is.read()) != -1){
                    System.out.print((char) c);
                }
            }
            
            System.out.println("");
            System.out.println("Valor de salida: "+exitVal);
            
        }catch(IOException e){
            throw e;
        } finally {
            if (null != is) {
                is.close();
            }
        }
        
    }
}
