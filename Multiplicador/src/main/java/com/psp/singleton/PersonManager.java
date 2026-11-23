package com.psp.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton: solo existe una instancia de PersonManager en todo el programa.
 * Gestiona las personas que están dentro de la oficina.
 */
public class PersonManager {

    // La única instancia
    private static PersonManager instancia;

    // Lista de personas en la oficina
    private List<Persona> personas;

    // Constructor privado: inicializa la lista correctamente
    private PersonManager() {
        this.personas = new ArrayList<Persona>();
    }
    
    // Método auxiliar sincronizado para garantizar la creación segura
    private synchronized static void createInstance() {
        if (instancia == null) {
            instancia = new PersonManager();
        }
    }
    
    // Único punto de acceso. Comprueba si no existe antes de devolverla
    public static PersonManager getInstance() {
        if (instancia == null) {
            createInstance();
        }
        return instancia;
    }

    // Una persona entra en la oficina
    public synchronized boolean entrar(Persona persona) {
        personas.add(persona);
        return true;
    }

    // Una persona sale de la oficina
    public synchronized boolean salir(Persona persona) {
        boolean estaba = personas.remove(persona);
        return estaba;
    }

    // Cuántas personas hay en este momento
    public synchronized int getNumeroPersonas() {
        return personas.size();
    }

    // Copia de la lista, para que desde fuera no se pueda modificar la original
    public synchronized List<Persona> getPersonas() {
        return new ArrayList<Persona>(personas);
    }
}