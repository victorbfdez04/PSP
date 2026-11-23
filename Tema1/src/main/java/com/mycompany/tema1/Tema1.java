/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema1;

/**
 *
 * @author b15-01m
 */
public class Tema1 {
    public static void main(String[] args) throws InterruptedException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("Mismo objeto? " + (s1 == s2));
        System.out.println("Instancias creadas: " + Singleton.getInstaciasConcurrentes());
    }
}
