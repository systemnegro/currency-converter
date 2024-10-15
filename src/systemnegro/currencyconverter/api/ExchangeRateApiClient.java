package systemnegro.currencyconverter.api;

import com.google.gson.Gson;
import systemnegro.currencyconverter.exception.ApiException;
import systemnegro.currencyconverter.model.dto.ExchangeRateDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ExchangeRateApiClient {

    public ExchangeRateDTO fetchExchangeRates(String baseCurrency, String targetCurrency, String value) throws IOException, InterruptedException {

        String apiKey = System.getenv("API_KEY");


        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s",
                apiKey,
                baseCurrency,
                targetCurrency,
                value);


        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), ExchangeRateDTO.class);
            } else {
                throw new ApiException("Failed to fetch exchange rates. HTTP Status: " + response.statusCode());
            }
        }

    }

}
