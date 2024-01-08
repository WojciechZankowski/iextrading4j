package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class ExchangeTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String exchange = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final String mic = fixture.create(String.class);
        final String segment = fixture.create(String.class);
        final String segmentDescription = fixture.create(String.class);
        final String suffix = fixture.create(String.class);
        final String exchangeSuffix = fixture.create(String.class);

        final Exchange exchangeObject = new Exchange(exchange, region, description, mic, segment, segmentDescription,
                suffix, exchangeSuffix);

        assertThat(exchangeObject.getExchange()).isEqualTo(exchange);
        assertThat(exchangeObject.getRegion()).isEqualTo(region);
        assertThat(exchangeObject.getDescription()).isEqualTo(description);
        assertThat(exchangeObject.getMic()).isEqualTo(mic);
        assertThat(exchangeObject.getSegment()).isEqualTo(segment);
        assertThat(exchangeObject.getSegmentDescription()).isEqualTo(segmentDescription);
        assertThat(exchangeObject.getSuffix()).isEqualTo(suffix);
        assertThat(exchangeObject.getExchangeSuffix()).isEqualTo(exchangeSuffix);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Exchange.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Exchange.class))
                .verify();
    }

}
