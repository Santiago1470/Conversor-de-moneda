import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

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
                ConversionApi conversiones = this.consultaApi.listarConversiones();
                String listaMonedas = listarMonedas(conversiones);
                System.out.println("¿Qué moneda desea convertir?");
                System.out.println(listaMonedas);
                int numeroOpcion = 0;
                do{
                    System.out.println("Elija una opción de moneda base válida:");
                    numeroOpcion = Integer.parseInt(scanner.nextLine());
                    monedaBase = seleccionarMoneda(conversiones, numeroOpcion);
                    if(monedaBase != null){
                        break;
                    }
                } while(numeroOpcion != 1);
                if(numeroOpcion == 1){
                    System.out.println(monedaBase);
                    break;
                }
                System.out.println("¿Qué moneda de destino desea?");
                System.out.println(listaMonedas);
                do{
                    System.out.println("Elija una opción de moneda de destino válida:");
                    numeroOpcion = Integer.parseInt(scanner.nextLine());
                    monedaDestino = seleccionarMoneda(conversiones, numeroOpcion);
                    if(monedaDestino != null){
                        break;
                    }
                } while(numeroOpcion != 1);
                if (numeroOpcion == 1){
                    System.out.println(monedaDestino);
                    break;
                }
                realizarConversion(monedaBase, monedaDestino);

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
        double valor = Double.parseDouble(scanner.nextLine());
        ConversionApi conversionResultado = consultaApi.realizarConversion(monedaBase, monedaDestino, valor);

        double resultado = conversionResultado.conversion_result();

        System.out.printf(Locale.US, "El valor %.2f [%s] corresponde al valor final de ==> %.2f [%s]%n",
                valor, monedaBase, resultado, monedaDestino);
        System.out.println();
        Conversion conversion = new Conversion(new Date(), monedaBase, monedaDestino,
                conversionResultado.conversion_rate(), valor, resultado);
        this.historial.add(conversion);
    }

    public String listarMonedas(ConversionApi conversionApi){
        List<List<String>> conversiones = conversionApi.supported_codes();
        StringBuilder lista = new StringBuilder();
        lista.append("1) Cancelar operación.\n");
        for (int i = 0; i < conversiones.size(); i++) {
            lista.append(i + 2).append(") ");
            for (int j = 0; j < conversiones.get(i).size(); j++) {
                lista.append(conversiones.get(i).get(j));
                if (j % 2 == 0) {
                    lista.append(" - ");
                }
            }
            lista.append("\n");
        }
        // System.out.println(conversiones.get(3));
        return lista.toString();
    }

    public String seleccionarMoneda(ConversionApi conversiones, int opcion){
        List<List<String>> lista = conversiones.supported_codes();
        if(opcion == 1){
            return "Conversión cancelada.";
        } else {
            for (int i = 0; i < lista.size(); i++){
                if(opcion == (i + 2)){
                    return lista.get(i).getFirst();
                }
            }
            return null;
        }

    }
}
