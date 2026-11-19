package ejercicios.ej8;

public class Main {

    //Main: Punto de entrada
    //Cena: Orquestador (crea y arranca los hilos)
    //Cubierto: Recurso compartido (con ReentrantLock justo)
    //Filosofo: Hilo concurrente (compite por dos recursos y alterna comer/pensar)
    public static void main(String[] args) {
        new Cena().iniciar();
    }
}