package com.psp.singleton;

public class Main {

    public static void main(String[] args) {
        PersonManager pm1 = PersonManager.getInstance();
        PersonManager pm2 = PersonManager.getInstance();
        System.out.println("Es la misma instancia? " + (pm1 == pm2));

        Persona ana = new Persona("Ana", "Moreno");
        Persona luis = new Persona("Luis", "Enrique");
        Persona marta = new Persona("Marta", "Campos");

        pm1.entrar(ana);
        pm2.entrar(luis);
        pm1.entrar(marta);
        pm1.entrar(ana);
        System.out.println("Ahora hay " + pm2.getNumeroPersonas() + " personas: " + pm2.getPersonas());

        pm2.salir(luis);
        pm1.salir(luis);
        System.out.println("Ahora hay " + pm1.getNumeroPersonas() + " personas: " + pm1.getPersonas());
    }
}