package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolDescriptionTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final String exchangeSuffix = fixture.create(String.class);
        final String exchangeName = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final String type = fixture.create(String.class);
        final String iexId = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String currency = fixture.create(String.class);
        final String figi = fixture.create(String.class);
        final String cik = fixture.create(String.class);
        final String lei = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final SymbolType securityType = fixture.create(SymbolType.class);
        final String sector = fixture.create(String.class);

        final SymbolDescription symbolDescription = new SymbolDescription(symbol, exchange, exchangeSuffix,
                exchangeName, name, type, iexId, region, currency, figi, cik, lei, securityName, securityType,
                sector);

        assertThat(symbolDescription.getSymbol()).isEqualTo(symbol);
        assertThat(symbolDescription.getExchange()).isEqualTo(exchange);
        assertThat(symbolDescription.getExchangeSuffix()).isEqualTo(exchangeSuffix);
        assertThat(symbolDescription.getExchangeName()).isEqualTo(exchangeName);
        assertThat(symbolDescription.getName()).isEqualTo(name);
        assertThat(symbolDescription.getType()).isEqualTo(type);
        assertThat(symbolDescription.getIexId()).isEqualTo(iexId);
        assertThat(symbolDescription.getFigi()).isEqualTo(figi);
        assertThat(symbolDescription.getCik()).isEqualTo(cik);
        assertThat(symbolDescription.getLei()).isEqualTo(lei);
        assertThat(symbolDescription.getSecurityName()).isEqualTo(securityName);
        assertThat(symbolDescription.getSecurityType()).isEqualTo(securityType);
        assertThat(symbolDescription.getRegion()).isEqualTo(region);
        assertThat(symbolDescription.getSector()).isEqualTo(sector);
        assertThat(symbolDescription.getCurrency()).isEqualTo(currency);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SymbolDescription.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SymbolDescription.class))
                .verify();
    }

}
