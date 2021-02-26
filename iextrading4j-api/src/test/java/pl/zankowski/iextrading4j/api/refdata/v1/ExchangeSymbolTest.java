package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeSymbolTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final String exchangeSuffix = fixture.create(String.class);
        final String exchangeName = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final SymbolType type = fixture.create(SymbolType.class);
        final String iexId = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String currency = fixture.create(String.class);
        final Boolean isEnabled = fixture.create(Boolean.class);
        final String figi = fixture.create(String.class);
        final String cik = fixture.create(String.class);
        final String lei = fixture.create(String.class);

        final ExchangeSymbol exchangeSymbol = new ExchangeSymbol(symbol, exchange, exchangeSuffix, exchangeName, name,
                date, type, iexId, region, currency, isEnabled, figi, cik, lei);

        assertThat(exchangeSymbol.getSymbol()).isEqualTo(symbol);
        assertThat(exchangeSymbol.getExchange()).isEqualTo(exchange);
        assertThat(exchangeSymbol.getExchangeSuffix()).isEqualTo(exchangeSuffix);
        assertThat(exchangeSymbol.getExchangeName()).isEqualTo(exchangeName);
        assertThat(exchangeSymbol.getName()).isEqualTo(name);
        assertThat(exchangeSymbol.getDate()).isEqualTo(date);
        assertThat(exchangeSymbol.getType()).isEqualTo(type);
        assertThat(exchangeSymbol.getIexId()).isEqualTo(iexId);
        assertThat(exchangeSymbol.getRegion()).isEqualTo(region);
        assertThat(exchangeSymbol.getCurrency()).isEqualTo(currency);
        assertThat(exchangeSymbol.getEnabled()).isEqualTo(isEnabled);
        assertThat(exchangeSymbol.getFigi()).isEqualTo(figi);
        assertThat(exchangeSymbol.getCik()).isEqualTo(cik);
        assertThat(exchangeSymbol.getLei()).isEqualTo(lei);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ExchangeSymbol.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(ExchangeSymbol.class))
                .verify();
    }

}
