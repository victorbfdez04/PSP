package ejercicios.eje11;

// Recurso compartido (monitor): solo controla si la puerta está ocupada
public class Puerta {

    private boolean ocupada = false;

    // Si está libre la ocupa y devuelve true. Si no, devuelve false (no espera aquí)
    public synchronized boolean intentarEntrar() {
        boolean entra = false;
        if (!ocupada) {
            ocupada = true;
            entra = true;
        }
        return entra;
    }

    // El cliente ya ha cruzado: la puerta queda libre
    public synchronized void salir() {
        ocupada = false;
    }
}