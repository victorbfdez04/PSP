package ejercicios.ej6;

public class Main {

    public static void main(String[] args) {
        new Torneo().celebrar();
    }
}

//package ejercicios.ej6;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Ring ring = new Ring();
//
//        Boxeador[] boxeadores = new Boxeador[4];
//
//        boxeadores[0] = new Boxeador(ring, "Boxeador 1");
//        boxeadores[1] = new Boxeador(ring, "Boxeador 2");
//        boxeadores[2] = new Boxeador(ring, "Boxeador 3");
//        boxeadores[3] = new Boxeador(ring, "Boxeador 4");
//
//        //Rival aleatorio (puede ser él mismo) antes de empezar el combate
//        for (Boxeador b : boxeadores) {
//            int pos = (int) (boxeadores.length * Math.random());
//            b.setRival(boxeadores[pos]);
//            System.out.printf("El rival de %s es %s%n", b.getName(), b.getRival().getName());
//        }
//
//        for (Boxeador b : boxeadores) {
//            b.start();
//        }
//        
//        try {
//            for (Boxeador b : boxeadores) {
//                b.join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//        for (Boxeador b : boxeadores) {
//            System.out.println(b);
//        }
//    }
//}