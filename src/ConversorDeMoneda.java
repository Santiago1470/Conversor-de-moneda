import java.util.List;
import java.util.Scanner;

public class ConversorDeMoneda {
    private Scanner scanner = new Scanner(System.in);
    private ConsultaApi consultaApi = new ConsultaApi();

    public static void main(String[] args) {
        ConversorDeMoneda conversorDeMoneda = new ConversorDeMoneda();

        byte opcion = 0;
        do{
            System.out.println(conversorDeMoneda.mostrarMenu());
            opcion = Byte.parseByte(conversorDeMoneda.scanner.nextLine());
            conversorDeMoneda.seleccionarOpcion(opcion);
        } while (opcion != 9);
    }

    public String mostrarMenu(){
        return """
                Sea bienvenido/a al Conversor de Monedas =)
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Elegir una conversión diferente
                8) Historial de conversiones
                9) Salir
                Elija una opción válida:
                *****************************************************
                """;
    }

    public void seleccionarOpcion(byte opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el valor que desea convertir:");
                float valor = Float.parseFloat(scanner.nextLine());
                float resultado = consultaApi.realizarConversion("USD", "ARS", valor);
                System.out.printf("El valor %.2f [USD] corresponde al valor final de ==> %.2f [ARS]%n", valor, resultado);
                System.out.println("El valor " + valor + " [USD] corresponde al valor final de ==> " + resultado + "[ARS]");

                break;
        }
    }
}
