package ejercicios.eje11;

// Recurso compartido (monitor): unidades del producto
public class Almacen {

    private int unidades;

    public Almacen(int unidades) {
        this.unidades = unidades;
    }

    // Devuelve true si quedaba alguna unidad y la descuenta
    public synchronized boolean coger() {
        boolean cogido = false;
        if (unidades > 0) {
            unidades--;
            cogido = true;
        }
        return cogido;
    }

    public synchronized int getUnidades() {
        return unidades;
    }
}