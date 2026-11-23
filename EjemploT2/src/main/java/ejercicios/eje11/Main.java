package ejercicios.eje11;

public class Main {
    // Main: Punto de entrada
    // Simulacion: Orquestador (abre, espera a los clientes y cierra)
    // Puerta: Recurso compartido (controla si está ocupada)
    // Almacen: Recurso compartido (controla las unidades que quedan)
    // Cliente: Hilo
    public static void main(String[] args) throws InterruptedException {
        new Simulacion().simular();
    }
}