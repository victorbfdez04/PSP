/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.ej2;

/**
 *
 * @author b15-01m
 */
public class Ingresa extends Thread{
    
    private final Cuenta cuenta;
    private final int INGRESO = 500;
    private long initTime;
    
    public Ingresa(){
        this.cuenta = Cuenta.getInstance();
    }
    
    @Override
    public void run(){
        initTime = System.currentTimeMillis();
        
        while(System.currentTimeMillis()-initTime<90000){
            cuenta.ingresar(INGRESO);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }        

    
}
