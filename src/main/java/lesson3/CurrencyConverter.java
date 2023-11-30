package lesson3;

class CurrencyConverter {
    private final double commission;
    private final double exchangeRate;

    public double getCommission() {
        return this.commission;
    }

    public double getExchangeRate() {
        return this.exchangeRate;
    }

    public CurrencyConverter(double commission, double exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    public double convertUsdToUah(double usd) {
        return this.exchangeRate * usd;
    }

    private double calculateCommission(double usd) {
        return this.convertUsdToUah(usd) * this.commission;
    }

    public double calculateTotalAmount(double usd) {
        return this.convertUsdToUah(usd) - this.calculateCommission(usd);
    }
}
