import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConsultaApi {

    public ConsultaApi(){

    }

    public Conversion listarConversiones(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/60888da80372f5b1cd40b07d/codes");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), Conversion.class);
    }

    public float realizarConversion(String monedaBase, String monedaDestino, float valor) {
        String url = "https://v6.exchangerate-api.com/v6/60888da80372f5b1cd40b07d/pair/%s/%s/%s"
                .formatted(monedaBase, monedaDestino, String.valueOf(valor));
        URI direccion = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        Conversion conversion = new Gson().fromJson(response.body(), Conversion.class);
        return conversion.conversion_result();
    }
}
