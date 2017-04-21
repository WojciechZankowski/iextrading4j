package pl.zankowski.iextrading4j.api.refdata.builder;

import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class ExchangeSymbolDataBuilder {

    private String symbol = "MDYG";
    private String name = "SPDR S&P 400 MID CAPGROWTH E";
    private LocalDate date = LocalDate.of(2017, 04, 21);
    private boolean isEnabled = true;

    public static ExchangeSymbol defaultExchangeSymbol() {
        return anExchangeSymbolDataBuilder().build();
    }

    public static ExchangeSymbolDataBuilder anExchangeSymbolDataBuilder() {
        return new ExchangeSymbolDataBuilder();
    }

    public ExchangeSymbolDataBuilder withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public ExchangeSymbolDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ExchangeSymbolDataBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public ExchangeSymbolDataBuilder withIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    public ExchangeSymbol build() {
        return new ExchangeSymbol(this.symbol, this.name, this.date, this.isEnabled);
    }

}
