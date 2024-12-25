import java.util.Scanner;

public class ConvertirMoneda {
    public static void convertir(String  monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura) {
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMoneda(monedaBase,monedaTarget);
        System.out.println("La tasa de conversion para hoy\n" + monedaBase + " = " + monedas.conversion_rate() + " " + monedaTarget);
        System.out.println("Ingrese la cantidad de " + monedaBase);
        String entrada = lectura.nextLine();
        try {
            cantidad = Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad + " " + monedaBase+" = " + cantidadConvertida + " " + monedas.target_code());
    }

    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura) {
        System.out.println("Ingrese el código de la moneda base");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda Objetivo");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, lectura);

    }
}
