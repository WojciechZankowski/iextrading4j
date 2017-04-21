package pl.zankowski.iextrading4j.api.refdata;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.refdata.builder.ExchangeSymbolDataBuilder.defaultExchangeSymbol;

/**
 * @author Wojciech Zankowski
 */
public class ExchangeSymbolTest {

    @Test
    public void shouldSuccessfullyCreateEmptyExchangeSymbol() {
        ExchangeSymbol exchangeSymbol = new ExchangeSymbol();

        assertThat(exchangeSymbol.getSymbol()).isNull();
        assertThat(exchangeSymbol.getName()).isNull();
        assertThat(exchangeSymbol.getDate()).isNull();
        assertThat(exchangeSymbol.isEnabled()).isFalse();
    }

    @Test
    public void shouldSuccessfullyCreateExchangeSymbol() {
        final String symbol = "MEIP";
        final String name = "MEI PHARMA INC";
        final LocalDate date = LocalDate.of(2017, 04, 21);
        final boolean isEnabled = true;

        ExchangeSymbol exchangeSymbol = new ExchangeSymbol(symbol, name, date, isEnabled);
        assertExchangeSymbol(exchangeSymbol, symbol, name, date, isEnabled);
    }

    @Test
    public void shouldSuccessfullySetValuesIntoEmptyObject() {
        final String symbol = "MEIP";
        final String name = "MEI PHARMA INC";
        final LocalDate date = LocalDate.of(2017, 04, 21);
        final boolean isEnabled = true;

        ExchangeSymbol exchangeSymbol = new ExchangeSymbol();
        exchangeSymbol.setSymbol(symbol);
        exchangeSymbol.setName(name);
        exchangeSymbol.setDate(date);
        exchangeSymbol.setIsEnabled(isEnabled);

        assertExchangeSymbol(exchangeSymbol, symbol, name, date, isEnabled);
    }

    @Test
    public void shouldSuccessfullyCompareExchangeSymbols() {
        ExchangeSymbol exchangeSymbol_1 = defaultExchangeSymbol();
        ExchangeSymbol exchangeSymbol_2 = defaultExchangeSymbol();

        assertThat(exchangeSymbol_1.equals(exchangeSymbol_2)).isTrue();
        assertThat(exchangeSymbol_1.hashCode()).isEqualTo(exchangeSymbol_2.hashCode());
    }

    private void assertExchangeSymbol(ExchangeSymbol exchangeSymbol, String symbol, String name, LocalDate date, boolean isEnabled) {
        assertThat(exchangeSymbol.getSymbol()).isEqualTo(symbol);
        assertThat(exchangeSymbol.getName()).isEqualTo(name);
        assertThat(exchangeSymbol.getDate()).isEqualTo(date);
        assertThat(exchangeSymbol.isEnabled()).isEqualTo(isEnabled);
    }

}
