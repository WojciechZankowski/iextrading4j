package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class LargestTradeTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
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
    public void equalsContract() {
        EqualsVerifier.forClass(LargestTrade.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(LargestTrade.class))
                .verify();
    }

}
