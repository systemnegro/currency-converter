package systemnegro.currencyconverter.model.dto;

public record ExchangeRateDTO(double conversion_rate, double conversion_result, String base_code, String target_code) {
}
