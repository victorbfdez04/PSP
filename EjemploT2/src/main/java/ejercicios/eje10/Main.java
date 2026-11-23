package ejercicios.eje10;

public class Main {
    // Main: Punto de entrada
    // Simulacion: Orquestador (arranca los hilos y los espera)
    // Cola: Recurso compartido (monitor)
    // Productor: Hilo que genera números
    // Consumidor: Hilo que lee números
    public static void main(String[] args) throws InterruptedException {
        new Simulacion().simular();
    }
}