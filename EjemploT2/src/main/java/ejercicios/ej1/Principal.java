package ejercicios.ej1;

import ejercicios.ej1.Coche;
import ejercicios.ej1.Carrera;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        String[] marcas = {"Opel", "Ford", "Seat"};
        Carrera carrera = new Carrera();
        List<Coche> coches = new ArrayList<>();

        System.out.println("Distancia carrera: " + carrera.getDistancia());

        for (String marca : marcas) {
            Coche coche = new Coche(marca, carrera);
            coches.add(coche);
            coche.start();
        }

        
        for (Coche c : coches) {
            c.join();
        }

        coches.sort(Comparator.comparingInt(Coche::getDistanciaRecorrida).reversed());

        System.out.println(" --- PODIUM --- ");
        System.out.println("Oro: " + coches.get(0).getName());
        System.out.println("Plata: " + coches.get(1).getName());
        System.out.println("Bronce: " + coches.get(2).getName());
    }
}