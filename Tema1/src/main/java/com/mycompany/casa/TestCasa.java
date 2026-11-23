package com.mycompany.casa;

public class TestCasa {
	
	public void ejecuta() throws InterruptedException {
		
		String[] personas = {"Luis", "Ana", "Maria", "Ant�n", "Pepe", "Pedro", "Jesus", "Iv�n", "Sofia", "Mar"};
		
		for(String persona: personas) {
            new Thread(() -> Casa.getInstance().addHabitante(persona)).start();
        }
        
		//espero 2 segundos a que todos los hilos hayan terminado
		Thread.sleep(2000);
        Casa.getInstance().verHabitantes();
    }
    
    public static void main(String[] args) throws InterruptedException {
        new TestCasa().ejecuta();
    }
}