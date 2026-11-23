/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ejercicios;

/**
 *
 * @author b15-01m
 */
public class Ej1Multiplicador {
    public static int Multiplicador(int n1, int n2){
        return n1*n2;
    }
    
    public static void main(String[] args){
        System.out.println("sumador main");
	int n1=Integer.parseInt(args[0]);
        int n2=Integer.parseInt(args[1]);

	int mult = Ej1Multiplicador.Multiplicador(n1, n2);		
	System.out.println(mult);
    }
}
