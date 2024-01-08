package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoSymbolsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final String type = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String currency = fixture.create(String.class);
        final Boolean isEnabled = fixture.create(Boolean.class);

        final CryptoSymbols cryptoSymbols = new CryptoSymbols(symbol, name, exchange, date, type, region, currency,
                isEnabled);

        assertThat(cryptoSymbols.getSymbol()).isEqualTo(symbol);
        assertThat(cryptoSymbols.getName()).isEqualTo(name);
        assertThat(cryptoSymbols.getExchange()).isEqualTo(exchange);
        assertThat(cryptoSymbols.getDate()).isEqualTo(date);
        assertThat(cryptoSymbols.getType()).isEqualTo(type);
        assertThat(cryptoSymbols.getRegion()).isEqualTo(region);
        assertThat(cryptoSymbols.getCurrency()).isEqualTo(currency);
        assertThat(cryptoSymbols.getEnabled()).isEqualTo(isEnabled);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(CryptoSymbols.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoSymbols.class))
                .verify();
    }

}
