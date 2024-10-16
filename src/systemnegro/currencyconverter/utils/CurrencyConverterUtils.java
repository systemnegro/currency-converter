package systemnegro.currencyconverter.utils;

import systemnegro.currencyconverter.api.ExchangeRateApiClient;
import systemnegro.currencyconverter.model.ExchangeRate;
import systemnegro.currencyconverter.model.dto.ExchangeRateDTO;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverterUtils {
    private static final ExchangeRateApiClient client = new ExchangeRateApiClient();

    private CurrencyConverterUtils() {
    }

    public static void showMenu() {
        String menu = """
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real
                4) Real =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                Escolha uma opção válida:
                """;
        System.out.println(menu);
    }

    public static void handleMenuOption(int option, Scanner scanner) throws InterruptedException {
        try {
            switch (option) {
                case 1 -> convertCurrency("USD", "ARS", scanner);
                case 2 -> convertCurrency("ARS", "USD", scanner);
                case 3 -> convertCurrency("USD", "BRL", scanner);
                case 4 -> convertCurrency("BRL", "USD", scanner);
                case 5 -> convertCurrency("USD", "COP", scanner);
                case 6 -> convertCurrency("COP", "USD", scanner);
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao buscar taxas de câmbio: " + e.getMessage());
        }
    }

    private static void convertCurrency(String baseCurrency, String targetCurrency, Scanner scanner) throws IOException, InterruptedException {
        System.out.println("Digite o valor que deseja converter: ");
        String value = scanner.next();

        ExchangeRateDTO exchangeRateDTO = client.fetchExchangeRates(baseCurrency, targetCurrency, value);
        ExchangeRate exchangeRate = new ExchangeRate(exchangeRateDTO);

        System.out.printf("""
                        Valor em %s com a taxa de câmbio de %f conresponde ao valor final %f em %s
                        """,
                exchangeRate.getBaseCurrency(),
                exchangeRate.getRate(),
                exchangeRate.getConvertedAmount(),
                exchangeRate.getTargetCurrency());
    }
}
