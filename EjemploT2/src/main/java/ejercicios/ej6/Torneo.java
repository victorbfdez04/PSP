package ejercicios.ej6;

public class Torneo {

    private Ring ring = new Ring();
    private Boxeador[] boxeadores = new Boxeador[4];

    public void celebrar() {

        for (int i = 0; i < boxeadores.length; i++) {
            boxeadores[i] = new Boxeador(ring, "Boxeador " + (i + 1));
        }

        // Rival aleatorio (puede ser él mismo) antes de empezar el combate
        for (Boxeador b : boxeadores) {
            int pos = (int) (boxeadores.length * Math.random());
            b.setRival(boxeadores[pos]);
            System.out.printf("El rival de %s es %s%n", b.getName(), b.getRival().getName());
        }

        for (Boxeador b : boxeadores) {
            b.start();
        }

        try {
            for (Boxeador b : boxeadores) {
                b.join();
            }
        } catch (InterruptedException e) {
        }

        System.out.println();
        for (Boxeador b : boxeadores) {
            System.out.println(b);
        }
    }
}