package ejercicios.ej6;

//Recurso compartido
public class Ring {

    public static final int MAX_COMBATES = 100;
    private int contadorCombates = 0;
    
    public Ring() {
    }

    public synchronized int getContadorCombates() {
        return contadorCombates;
    }

    public synchronized boolean combatir(Boxeador atacante, Boxeador rival) {
        
        boolean rondasMaxSuperada = false;
        if (contadorCombates <= MAX_COMBATES) {
            contadorCombates++;
            System.out.printf("%s pega a %s%n", atacante.getName(), rival.getName());

            atacante.golpear();
            rival.recibirGolpe();

            rondasMaxSuperada = true;
        }
        return rondasMaxSuperada;
    }
}

//Segunda version con variable de finalizado
//public class Ring {
//
//    private static final int MAX_COMBATES = 100;
//
//    private int numCombates = 0;
//    private boolean finalizado = false;
//
//    public Ring() {
//    }
//
//    public synchronized boolean isFinalizado() {
//        return finalizado;
//    }
//
//    public synchronized void combatir(Boxeador golpea, Boxeador recibe) {
//
//        if (numCombates < MAX_COMBATES) {
//
//            System.out.println(golpea.getName() + " pega a " + recibe.getName());
//            golpea.golpea();
//            recibe.recibe();
//
//            numCombates++;
//
//            if (numCombates >= MAX_COMBATES) {
//                finalizado = true;
//            }
//        }
//    }
//}