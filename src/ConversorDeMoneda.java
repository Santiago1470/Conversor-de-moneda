import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConversorDeMoneda {
    private Scanner scanner = new Scanner(System.in);
    private ConsultaApi consultaApi = new ConsultaApi();
    private List<Conversion> historial = new ArrayList<>();

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
                *****************************************************
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
        String monedaBase;
        String monedaDestino;

        switch (opcion) {
            case 1:
                monedaBase = "USD";
                monedaDestino = "ARS";
                realizarConversion(monedaBase, monedaDestino);

                break;

            case 2:
                monedaBase = "ARS";
                monedaDestino = "USD";
                realizarConversion(monedaBase, monedaDestino);

                break;

            case 3:
                monedaBase = "USD";
                monedaDestino = "BRL";
                realizarConversion(monedaBase, monedaDestino);

                break;

            case 4:
                monedaBase = "BRL";
                monedaDestino = "USD";
                realizarConversion(monedaBase, monedaDestino);

                break;

            case 5:
                monedaBase = "USD";
                monedaDestino = "COP";
                realizarConversion(monedaBase, monedaDestino);

                break;

            case 6:
                monedaBase = "COP";
                monedaDestino = "USD";
                realizarConversion(monedaBase, monedaDestino);

                break;

            case 7:


                break;

            case 8:


                break;

            case 9:
                System.out.println("Gracias por utilizar nuestros servicos.");

                break;

            default:
                System.out.println("La opción ingresada no existe.");
        }
    }

    public void realizarConversion(String monedaBase, String monedaDestino){
        System.out.println("Ingrese el valor que desea convertir:");
        float valor = Float.parseFloat(scanner.nextLine());
        ConversionApi conversionResultado = consultaApi.realizarConversion(monedaBase, monedaDestino, valor);
        float resultado = (float) Math.round(conversionResultado.conversion_result() * 100) / 100;
        System.out.printf("El valor %s [%s] corresponde al valor final de ==> %s [%s]%n",
                String.valueOf(valor), monedaBase, String.valueOf(resultado), monedaDestino);
        System.out.println();
        Conversion conversion = new Conversion(new Date(), monedaBase, monedaDestino,
                conversionResultado.conversion_rate(), valor, resultado);
        this.historial.add(conversion);
    }
}
