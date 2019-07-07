package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolDescriptionTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final SymbolType securityType = fixture.create(SymbolType.class);
        final String region = fixture.create(String.class);
        final String exchange = fixture.create(String.class);

        final SymbolDescription symbolDescription = new SymbolDescription(symbol, securityName,
                securityType, region, exchange);

        assertThat(symbolDescription.getSymbol()).isEqualTo(symbol);
        assertThat(symbolDescription.getSecurityName()).isEqualTo(securityName);
        assertThat(symbolDescription.getSecurityType()).isEqualTo(securityType);
        assertThat(symbolDescription.getRegion()).isEqualTo(region);
        assertThat(symbolDescription.getExchange()).isEqualTo(exchange);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SymbolDescription.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SymbolDescription.class))
                .verify();
    }

}
