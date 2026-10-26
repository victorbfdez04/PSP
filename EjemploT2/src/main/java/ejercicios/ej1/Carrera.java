package ejercicios.ej1;

import java.util.Random;

public class Carrera {
    private Random rd = new Random();
    private int distancia;
    private boolean terminada;

    public Carrera() {
        this.distancia = rd.nextInt(200, 300);
        this.terminada = false;
    }

    public synchronized void comprobarCarrera(String marca, int distancia) {
        if (!terminada) {
            if (distancia >= this.distancia) {
                terminada = true;
                System.out.println("El coche " + marca + " ha ganado la carrera !!! ");
            } else {
                int porcentaje = (distancia * 100) / this.distancia;
                System.out.println("El coche " + marca + " lleva recorrido el " + porcentaje + "% de la carrera");
            }
        }
    }

    public synchronized boolean isTerminada() {
        return terminada;
    }

    public synchronized int getDistancia() {
        return distancia;
    }
}