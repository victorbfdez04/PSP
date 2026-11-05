package ejercicios.ej5;

public class Empleado extends Thread {

    private static final long MAX_TIME = 3 * 60 * 1000;
    private long initTime;

    private Tarifa tarifa;
    private int totalFacturas;

    public Empleado(Tarifa tarifa, String id) {
        setName(id);
        this.tarifa = tarifa;
        this.totalFacturas = 0;
    }

    public int getTotalFacturas() {
        return totalFacturas;
    }

    @Override
    public void run() {
        initTime = System.currentTimeMillis();
        
        while ((System.currentTimeMillis() - initTime) <= MAX_TIME) {
            int num = 1 + (int)(50 * Math.random());
            double importe = tarifa.calcularConsumo(num);
            String numeroFac = tarifa.crearFactura();
            totalFacturas++;
            System.out.printf("Factura %s con importe %.2f€ generada por el Empleado %s.%n",numeroFac, importe, getName());
        }
    }
}