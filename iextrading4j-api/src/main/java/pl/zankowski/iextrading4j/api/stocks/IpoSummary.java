package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"Company", "Symbol", "Price", "Shares", "Amount", "Float",
        "Percent", "Market", "Expected"})
public class IpoSummary implements Serializable {

    private final String company;
    private final String symbol;
    private final String price;
    private final String shares;
    private final String amount;
    private final String floatValue;
    private final String percent;
    private final String market;
    private final String expected;

    @JsonCreator
    public IpoSummary(
            @JsonProperty("Company") final String company,
            @JsonProperty("Symbol") final String symbol,
            @JsonProperty("Price") final String price,
            @JsonProperty("Shares") final String shares,
            @JsonProperty("Amount") final String amount,
            @JsonProperty("Float") final String floatValue,
            @JsonProperty("Percent") final String percent,
            @JsonProperty("Market") final String market,
            @JsonProperty("Expected") final String expected) {
        this.company = company;
        this.symbol = symbol;
        this.price = price;
        this.shares = shares;
        this.amount = amount;
        this.floatValue = floatValue;
        this.percent = percent;
        this.market = market;
        this.expected = expected;
    }

    public String getCompany() {
        return company;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPrice() {
        return price;
    }

    public String getShares() {
        return shares;
    }

    public String getAmount() {
        return amount;
    }

    public String getFloat() {
        return floatValue;
    }

    public String getPercent() {
        return percent;
    }

    public String getMarket() {
        return market;
    }

    public String getExpected() {
        return expected;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IpoSummary that = (IpoSummary) o;
        return Objects.equal(company, that.company) &&
                Objects.equal(symbol, that.symbol) &&
                Objects.equal(price, that.price) &&
                Objects.equal(shares, that.shares) &&
                Objects.equal(amount, that.amount) &&
                Objects.equal(floatValue, that.floatValue) &&
                Objects.equal(percent, that.percent) &&
                Objects.equal(market, that.market) &&
                Objects.equal(expected, that.expected);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(company, symbol, price, shares, amount, floatValue, percent, market, expected);
    }

    @Override
    public String toString() {
        return "IpoSummary{" +
                "company='" + company + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                ", shares='" + shares + '\'' +
                ", amount='" + amount + '\'' +
                ", floatValue='" + floatValue + '\'' +
                ", percent='" + percent + '\'' +
                ", market='" + market + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

}
