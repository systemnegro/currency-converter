package systemnegro.currencyconverter.model;

import systemnegro.currencyconverter.model.dto.ExchangeRateDTO;

public class ExchangeRate {
    private double rate;
    private double convertedAmount;

    public ExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        this.rate = exchangeRateDTO.conversion_rate();
        this.convertedAmount = exchangeRateDTO.conversion_result();
    }

    public double getRate() {
        return rate;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "rate=" + rate +
                ", convertedAmount=" + convertedAmount +
                '}';
    }
}
