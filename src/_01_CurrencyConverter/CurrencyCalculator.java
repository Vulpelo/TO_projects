package _01_CurrencyConverter;

public class CurrencyCalculator {
    private CurrencyCollection currencyCollection;

    CurrencyCalculator() throws Exception {
        currencyCollection = new CurrencyCollection();
        currencyCollection.updateCurrencies();
    }

    private float getResult(Currency fromCurrCode, Currency toCurrCode, float amount){
        return (Float.valueOf(fromCurrCode.getCourse()) / Float.valueOf(fromCurrCode.getConversionRate()) * amount) /
                Float.valueOf( toCurrCode.getCourse() ) * Float.valueOf( toCurrCode.getConversionRate());
    }

    public float getResult(String fromCurrCode, String toCurrCode, float amount){
        Currency cur1 = currencyCollection.getCurrencyByCode(fromCurrCode);
        Currency cur2 = currencyCollection.getCurrencyByCode(toCurrCode);

        return getResult(cur1, cur2, amount);
    }

    public CurrencyCollection getCurrencyCollection() {
        return currencyCollection;
    }
}
