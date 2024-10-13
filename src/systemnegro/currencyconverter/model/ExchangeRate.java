package systemnegro.currencyconverter.model;

public class ExchangeRate {
    private double rate;
    private double convertedAmount;

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
