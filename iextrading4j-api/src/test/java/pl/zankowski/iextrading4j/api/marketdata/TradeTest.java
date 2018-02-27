package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal price = fixture.create(BigDecimal.class);
        final BigDecimal size = fixture.create(BigDecimal.class);
        final Long tradeId = fixture.create(Long.class);
        final Boolean isISO = fixture.create(Boolean.class);
        final Boolean isOddLot = fixture.create(Boolean.class);
        final Boolean isOutsideRegularHours = fixture.create(Boolean.class);
        final Boolean isSinglePriceCross = fixture.create(Boolean.class);
        final Boolean isTradeThroughExample = fixture.create(Boolean.class);
        final Long timestamp = fixture.create(Long.class);

        final Trade trade = new Trade(price, size, tradeId, isISO, isOddLot, isOutsideRegularHours,
                isSinglePriceCross, isTradeThroughExample, timestamp);

        assertThat(trade.getPrice()).isEqualTo(price);
        assertThat(trade.getSize()).isEqualTo(size);
        assertThat(trade.getTradeId()).isEqualTo(tradeId);
        assertThat(trade.isISO()).isEqualTo(isISO);
        assertThat(trade.isOddLot()).isEqualTo(isOddLot);
        assertThat(trade.isOutsideRegularHours()).isEqualTo(isOutsideRegularHours);
        assertThat(trade.isSinglePriceCross()).isEqualTo(isSinglePriceCross);
        assertThat(trade.isTradeThroughExempt()).isEqualTo(isTradeThroughExample);
        assertThat(trade.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Trade.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Trade.class))
                .verify();
    }

}
