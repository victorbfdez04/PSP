package com.psp.uno;

/**
 * Proceso hijo: multiplica dos numeros y escribe SOLO el resultado por la salida estandar.
 * Uso: Multiplicador <n1> <n2>
 */
public class Multiplicador {

    public static int multiplicar(int n1, int n2) {
        return n1 * n2;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Faltan parametros. Uso: Multiplicador <n1> <n2>");
            System.exit(1);
        }
        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println(multiplicar(n1, n2));
            System.out.flush();
        } catch (NumberFormatException e) {
            System.err.println("Los parametros deben ser numeros enteros: " + e.getMessage());
            System.exit(1);
        }
    }
}
