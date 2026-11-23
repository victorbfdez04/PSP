package com.mycompany.examen;

public class Cubo {
    
    private static final int CAP_MAX = 5;
    private static Cubo instance = null;
    private int litrosCubo; // Atributo de instancia
    
    // Constructor privado para evitar la instanciación directa con 'new'
    private Cubo() {
        this.litrosCubo = 0;
    }
    
    // Devuelve la instancia única del Singleton (Thread-safe)
    public static synchronized Cubo getInstance() {
        if (instance == null) {
            instance = new Cubo();
        }
        return instance;
    }
    
    // Método de instancia para retirar litros del cubo
    public synchronized boolean retirarLitros(int cantidad) {
        if (cantidad > 0 && litrosCubo >= cantidad) {
            litrosCubo -= cantidad;
            return true;
        }
        return false;
    }

    // Método de instancia para añadir litros sin superar CAP_MAX
    public synchronized void agregarLitros(int cantidad) {
        if (cantidad > 0) {
            this.litrosCubo = Math.min(this.litrosCubo + cantidad, CAP_MAX);
        }
    }

    public int getLitrosCubo() {
        return litrosCubo;
    }
}