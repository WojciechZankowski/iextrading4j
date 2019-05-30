package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String exchange = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final String mic = fixture.create(String.class);
        final String exchangeSuffix = fixture.create(String.class);

        final Exchange exchangeObject = new Exchange(exchange, region, description, mic, exchangeSuffix);

        assertThat(exchangeObject.getExchange()).isEqualTo(exchange);
        assertThat(exchangeObject.getRegion()).isEqualTo(region);
        assertThat(exchangeObject.getDescription()).isEqualTo(description);
        assertThat(exchangeObject.getMic()).isEqualTo(mic);
        assertThat(exchangeObject.getExchangeSuffix()).isEqualTo(exchangeSuffix);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Exchange.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Exchange.class))
                .verify();
    }

}
