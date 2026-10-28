package com.mycompany.Ejercicio2;

/**
 * Clase principal del ejercicio: el banco abre, deja entrar a los dos
 * clientes (hilos) y no cierra hasta que ambos se han marchado
 */
public class Banco {

    /**
     * Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("El banco abre");

        // Se crean los clientes, ambos obtienen la misma Cuenta compartida
        Ingresa ingresa = new Ingresa();
        Cobra cobra = new Cobra();

        // start() lanza cada cliente en su propio hilo, de forma concurrente
        ingresa.start();
        cobra.start();

        // El banco no cierra hasta que sus clientes se marchen:
        // join() bloquea el hilo principal hasta que el hilo indicado termina
        try {
            ingresa.join();
            cobra.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El banco cierra, saldo final: "
                + Cuenta.getInstance().getSaldo() + " €");
    }
}