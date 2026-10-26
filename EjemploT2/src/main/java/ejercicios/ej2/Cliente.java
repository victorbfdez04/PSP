/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.ej2;

/**
 *
 * @author b15-01m
 */
public class Cliente extends Thread{
    
    private final Cuenta cuenta;
    private final int INGRESO = 500;
    
    public Cliente(){
        this.cuenta = Cuenta.getInstance();
    }
    
    @Override
    public void run(){
        
        while()
    }
}
