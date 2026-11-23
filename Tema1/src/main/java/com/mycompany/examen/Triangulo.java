package com.mycompany.examen;

public class Triangulo {

    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("Debe proporcionar 2 argumentos: base y altura.");
        }

        int base = Integer.parseInt(args[0]);
        int altura = Integer.parseInt(args[1]);

        CalcularArea ca = new CalcularArea();
        double area = ca.calcularArea(base, altura);

        System.out.println("El área del triángulo es: " + area);
    }

    public static class CalcularArea {
        public double calcularArea(double base, double altura) {
            return (base * altura) / 2.0;
        }
    }
}