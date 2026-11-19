package ejercicios.ej9;

public class Main {
    //Main: Punto de entrada
    //Barberia: Orquestador (abre, espera a los clientes y cierra)
    //Sillas: Recurso compartido (monitor)
    //Barbero: Hilo consumidor
    //Cliente: Hilo productor
    public static void main(String[] args) throws InterruptedException {
        new Barberia().simular();
    }
}