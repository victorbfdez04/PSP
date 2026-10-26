package compartido;

public class Tarea extends Thread {

    Contador contador;
    
    public Tarea(Contador contador) {
        this.contador = contador;
    }
        
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // Número aleatorio entre 1 y 100
            int num = (int) (Math.random() * 100) + 1;
    
            // Si el número es par, incrementa; si es impar, decrementa
            if (num % 2 == 0) {
                contador.incrementar();
                System.out.println(getName() + " - Número generado: " + num + " (Par -> Incrementa)");
            } else {
                contador.decrementar();
                System.out.println(getName() + " - Número generado: " + num + " (Impar -> Decrementa)");
            }
        }
    }
}