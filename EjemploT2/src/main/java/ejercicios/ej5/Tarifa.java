package ejercicios.ej5;

public class Tarifa {

    final static private String PREFIJO = "FAC";

    private int contadorFacturas = 0;

    public Tarifa() {
    }

    public synchronized String crearFactura() {

        contadorFacturas++;

        String nombre = PREFIJO + contadorFacturas;

        return nombre;
    }

    public double calcularConsumo(int consumo) {

        double importe = 0;

        if (consumo < 15) {

            importe = consumo * 1.5;

        } else {

            if (consumo >= 15 && consumo < 30) {

                importe = consumo * 2.1;

            } else {

                if (consumo >= 30) {

                    importe = consumo * 3;
                }
            }
        }

        return importe;
    }
}
