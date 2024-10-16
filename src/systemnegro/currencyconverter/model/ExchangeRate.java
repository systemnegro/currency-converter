package systemnegro.currencyconverter.model;

import systemnegro.currencyconverter.model.dto.ExchangeRateDTO;

public class ExchangeRate {
    private final double rate;
    private final double convertedAmount;
    private final String baseCurrency;
    private final String targetCurrency;

    public ExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        this.rate = exchangeRateDTO.conversion_rate();
        this.convertedAmount = exchangeRateDTO.conversion_result();
        this.baseCurrency = exchangeRateDTO.base_code();
        this.targetCurrency = exchangeRateDTO.target_code();
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getRate() {
        return rate;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

}
