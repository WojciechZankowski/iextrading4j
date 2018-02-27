package pl.zankowski.iextrading4j.api.refdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeSymbolTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final Boolean isEnabled = fixture.create(Boolean.class);
        final SymbolType type = fixture.create(SymbolType.class);
        final Long iexId = fixture.create(Long.class);

        final ExchangeSymbol exchangeSymbol = new ExchangeSymbol(symbol, name, date, isEnabled, type, iexId);

        assertThat(exchangeSymbol.getSymbol()).isEqualTo(symbol);
        assertThat(exchangeSymbol.getName()).isEqualTo(name);
        assertThat(exchangeSymbol.getDate()).isEqualTo(date);
        assertThat(exchangeSymbol.getEnabled()).isEqualTo(isEnabled);
        assertThat(exchangeSymbol.getType()).isEqualTo(type);
        assertThat(exchangeSymbol.getIexId()).isEqualTo(iexId);
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
