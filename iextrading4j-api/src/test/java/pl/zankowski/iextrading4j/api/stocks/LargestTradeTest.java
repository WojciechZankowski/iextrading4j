package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class LargestTradeTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final BigDecimal price = fixture.create(BigDecimal.class);
        final BigDecimal size = fixture.create(BigDecimal.class);
        final Long time = fixture.create(Long.class);
        final LocalTime timeLabel = fixture.create(LocalTime.class);
        final String venue = fixture.create(String.class);
        final String venueName = fixture.create(String.class);

        final LargestTrade largestTrade = new LargestTrade(price, size, time, timeLabel, venue, venueName);

        assertThat(largestTrade.getPrice()).isEqualTo(price);
        assertThat(largestTrade.getSize()).isEqualTo(size);
        assertThat(largestTrade.getTime()).isEqualTo(time);
        assertThat(largestTrade.getTimeLabel()).isEqualTo(timeLabel);
        assertThat(largestTrade.getVenue()).isEqualTo(venue);
        assertThat(largestTrade.getVenueName()).isEqualTo(venueName);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(LargestTrade.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(LargestTrade.class))
                .verify();
    }

}
