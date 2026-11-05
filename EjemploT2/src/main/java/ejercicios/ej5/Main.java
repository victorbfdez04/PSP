package ejercicios.ej5;

public class Main {

    public static void main(String[] args) {

        Tarifa tarifa = new Tarifa();

        Empleado empleado1 = new Empleado(tarifa, "Empleado 1");
        Empleado empleado2 = new Empleado(tarifa, "Empleado 2");
        Empleado empleado3 = new Empleado(tarifa, "Empleado 3");

        empleado1.start();
        empleado2.start();
        empleado3.start();

        try {

            empleado1.join();
            empleado2.join();
            empleado3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}