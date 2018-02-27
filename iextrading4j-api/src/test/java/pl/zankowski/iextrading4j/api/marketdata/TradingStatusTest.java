package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class TradingStatusTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void construct() {
        final TradingStatusType tradingStatusType = fixture.create(TradingStatusType.class);
        final TradingStatusReasonType reasonType = fixture.create(TradingStatusReasonType.class);
        final Long timestamp = fixture.create(Long.class);

        final TradingStatus tradingStatus = new TradingStatus(tradingStatusType, reasonType, timestamp);

        assertThat(tradingStatus.getStatus()).isEqualTo(tradingStatusType);
        assertThat(tradingStatus.getReason()).isEqualTo(reasonType);
        assertThat(tradingStatus.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(TradingStatus.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TradingStatus.class))
                .verify();
    }

}
