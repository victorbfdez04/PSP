package com.psp.seis;

import java.math.BigInteger;

public class CalcularFactorial {

    // Ejemplo: el factorial de 7 es 5040 = 7 x 6 x 5 x 4 x 3 x 2 x 1
    public void calFactorial(int numeroFactorial) throws Exception {
        if (numeroFactorial < 0) {
            throw new Exception("No existe el factorial de un numero negativo: " + numeroFactorial);
        }

        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= numeroFactorial; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        //Fuera del bucle: se imprime una sola vez, con el resultado final
        System.out.println("Factorial de " + numeroFactorial + " = " + resultado);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Falta el numero. Uso: CalcularFactorial <numero>");
        }

        CalcularFactorial cf = new CalcularFactorial();
        cf.calFactorial(Integer.parseInt(args[0]));
    }
}