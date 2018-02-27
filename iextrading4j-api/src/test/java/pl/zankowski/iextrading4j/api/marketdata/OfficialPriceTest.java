package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class OfficialPriceTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final PriceType priceType = fixture.create(PriceType.class);
        final BigDecimal price = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);

        final OfficialPrice officialPrice = new OfficialPrice(priceType, price, timestamp);

        assertThat(officialPrice.getPriceType()).isEqualTo(priceType);
        assertThat(officialPrice.getPrice()).isEqualTo(price);
        assertThat(officialPrice.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(OfficialPrice.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(OfficialPrice.class))
                .verify();
    }

}
