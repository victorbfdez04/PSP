/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tema1;

/**
 *
 * @author b15-01m
 */
public class Singleton {
    //crear referencia como estatica
    private static Singleton instance = null;

    private static int numInstancias = 0;

    // Poner el constructor privado para que no se puedan crear mas instancias
    private Singleton(){
    	numInstancias++;
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // garantizar que solo habra una unica instancia
    private synchronized static void createInstance() {
        if (instance == null) { 
            instance = new Singleton();
        }
    }
    // crear metodo publico y estatico que me permita obtener la referencia a la clase
    public static Singleton getInstance() {
        if (instance == null) createInstance();
        return instance;
    }

    public static int getInstaciasConcurrentes(){
        return numInstancias;
    } 
}
