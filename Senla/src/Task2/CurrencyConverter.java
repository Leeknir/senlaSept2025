package Task2;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private final Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        this.exchangeRates = new HashMap<>();
        initializeExchangeRates();
    }

    private void initializeExchangeRates() {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.93);
        exchangeRates.put("GBP", 0.80);
        exchangeRates.put("JPY", 149.35);
        exchangeRates.put("CAD", 1.37);
        exchangeRates.put("RUB", 93.45);
    }

    public Map<String, Double> convertCurrency(double amount, String baseCurrency) {
        if (!exchangeRates.containsKey(baseCurrency)) {
            System.out.println("Ошибка: валюта " + baseCurrency + " не поддерживается");
            return null;
        }

        double baseRate = exchangeRates.get(baseCurrency);
        Map<String, Double> convertedAmounts = new HashMap<>();

        for (String currency : exchangeRates.keySet()) {
            if (!currency.equals(baseCurrency)) {
                double targetRate = exchangeRates.get(currency);
                double convertedAmount = (amount / baseRate) * targetRate;
                convertedAmounts.put(currency, convertedAmount);
            }
        }

        return convertedAmounts;
    }

    public void displaySupportedCurrencies() {
        System.out.println("Поддерживаемые валюты:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println("- " + currency);
        }
    }

    public boolean isCurrencySupported(String currency) {
        return exchangeRates.containsKey(currency);
    }
}