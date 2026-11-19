package ejercicios.ej9;

public class Cliente extends Thread {

    private final Sillas sillas;

    public Cliente(String nombre, Sillas sillas) {
        super(nombre);
        this.sillas = sillas;
    }

    @Override
    public void run() {
        try {
            if (sillas.sentarseYEsperar(getName())) {
                System.out.println(getName() + " ya he sido atendido, me marcho");
            } else {
                System.out.println(getName() + " no había sillas libres, me marcho");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}