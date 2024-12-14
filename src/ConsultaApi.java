import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaApi {

    private final String URL_API;

    public ConsultaApi(){
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo de configuración", e);
        }
        this.URL_API = "https://v6.exchangerate-api.com/v6/" + props.getProperty("api.key");
    }

    public ConversionApi listarConversiones(){
        String direccion = this.URL_API + "/codes";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), ConversionApi.class);
    }

    public ConversionApi realizarConversion(String monedaBase, String monedaDestino, double valor) {
        String direccion = this.URL_API + "/pair/%s/%s/%s"
                .formatted(monedaBase, monedaDestino, String.valueOf(valor));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), ConversionApi.class);
    }
}
