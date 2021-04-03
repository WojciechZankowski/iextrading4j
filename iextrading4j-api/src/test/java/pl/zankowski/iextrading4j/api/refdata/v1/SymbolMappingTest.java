package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolMappingTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String iexId = fixture.create(String.class);

        final SymbolMapping symbolMapping = new SymbolMapping(symbol, exchange, region, iexId);

        assertThat(symbolMapping.getSymbol()).isEqualTo(symbol);
        assertThat(symbolMapping.getExchange()).isEqualTo(exchange);
        assertThat(symbolMapping.getRegion()).isEqualTo(region);
        assertThat(symbolMapping.getIexId()).isEqualTo(iexId);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SymbolMapping.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SymbolMapping.class))
                .verify();
    }

}
