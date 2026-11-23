package com.mycompany.casa;

import java.util.ArrayList;
import java.util.List;

public class Casa {
    //crear referencia como est�tica
    private static Casa instance = null;
    
    private List<String> habitantes;

    // Poner el constructor privado para que no se puedan crear m�s instancias
    private Casa(){
    	habitantes = new ArrayList<String>();
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // garantizar que solo habr� una �nica instancia
    private synchronized static void createInstance() {
        if (instance == null) { 
            instance = new Casa();
        }
    }
    // crear m�todo p�blico y est�tico que me permita obtener la referencia a la clase
    public static Casa getInstance() {
        if (instance == null) createInstance();
        return instance;
    }
    
    public synchronized void addHabitante(String nombre) {
    	habitantes.add(nombre);
    }
    
    public synchronized void verHabitantes() {
    	System.out.println(habitantes.toString());
    }
    
}

