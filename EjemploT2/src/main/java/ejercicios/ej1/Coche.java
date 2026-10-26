package ejercicios.ej1;

import ejercicios.ej1.Carrera;
import java.util.Random;

public class Coche extends Thread {
    private Random rd = new Random();
    private int distancia;
    private int distanciaRecorrida;
    private Carrera carrera;

    public Coche(String marca, Carrera carrera) {
        setName(marca);
        this.distanciaRecorrida = 0;
        this.distancia = rd.nextInt(1, 51);
        this.carrera = carrera;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    @Override
    public void run() {
        while (!carrera.isTerminada()) {
            try {
                distanciaRecorrida += distancia;
                carrera.comprobarCarrera(getName(), distanciaRecorrida);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}