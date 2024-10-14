package systemnegro.currencyconverter.api;

import com.google.gson.Gson;
import systemnegro.currencyconverter.model.dto.ExchangeRateDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient {

    public ExchangeRateDTO fetchExchangeRates() throws IOException, InterruptedException {

        String apiKey = System.getenv("API_KEY");


        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/USD/BRL/100"))
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), ExchangeRateDTO.class);
            } else {
                return null;
            }
        }


    }


}
