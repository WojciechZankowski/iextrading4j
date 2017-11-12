package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

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
        assertThat(trade.getISO()).isEqualTo(isISO);
        assertThat(trade.getOddLot()).isEqualTo(isOddLot);
        assertThat(trade.getOutsideRegularHours()).isEqualTo(isOutsideRegularHours);
        assertThat(trade.getSinglePriceCross()).isEqualTo(isSinglePriceCross);
        assertThat(trade.getTradeThroughExempt()).isEqualTo(isTradeThroughExample);
        assertThat(trade.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Trade.class)
                .usingGetClass()
                .verify();
    }

}
