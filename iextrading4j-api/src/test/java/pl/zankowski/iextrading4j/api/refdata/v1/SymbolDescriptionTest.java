package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolDescriptionTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String cik = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final SymbolType securityType = fixture.create(SymbolType.class);
        final String region = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final String sector = fixture.create(String.class);
        final String currency = fixture.create(String.class);

        final SymbolDescription symbolDescription = new SymbolDescription(symbol, cik, securityName,
                securityType, region, exchange, sector, currency);

        assertThat(symbolDescription.getSymbol()).isEqualTo(symbol);
        assertThat(symbolDescription.getCik()).isEqualTo(cik);
        assertThat(symbolDescription.getSecurityName()).isEqualTo(securityName);
        assertThat(symbolDescription.getSecurityType()).isEqualTo(securityType);
        assertThat(symbolDescription.getRegion()).isEqualTo(region);
        assertThat(symbolDescription.getExchange()).isEqualTo(exchange);
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
