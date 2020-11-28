package github.com.cryptocurrencyapplication.markets;

public class MarketDTO {

    private String cryptoCurrencyName;
    private String currencyName;
    private String rate;

    public MarketDTO(String cryptoCurrencyName, String currencyName, String rate) {
        this.cryptoCurrencyName = cryptoCurrencyName;
        this.currencyName = currencyName;
        this.rate = rate;
    }

    public String getCryptoCurrencyName() {
        return cryptoCurrencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "MarketDTO{" +
                "cryptoCurrencyName='" + cryptoCurrencyName + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", rate=" + rate +
                '}';
    }
}
