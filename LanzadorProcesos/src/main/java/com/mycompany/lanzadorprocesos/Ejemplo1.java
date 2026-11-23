/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lanzadorprocesos;

/**
 *
 * @author b15-01m
 */
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {
    public void ejecutar(String ruta){ 
            ProcessBuilder pb;
            try {
                    pb = new ProcessBuilder(ruta);
                    Process p = pb.start();
                    //matamos si en 5 segundos no se completa el proceso
        			if (!p.waitFor(6, TimeUnit.SECONDS)) 
                    {
                        p.destroy();
                    }
            } catch (Exception e) {
                    e.printStackTrace();
            }
    } 
    
 	public static void main(String[] args) {
            //String ruta= "C:\\Program Files\\Notepad++\\notepad++.exe";
 		String ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            Ejemplo1 lp=new Ejemplo1();
            lp.ejecutar(ruta);
            System.out.println("Finalizado");
    }
}


