package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TOPSTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal marketPercent = fixture.create(BigDecimal.class);
        final BigDecimal bidSize = fixture.create(BigDecimal.class);
        final BigDecimal bidPrice = fixture.create(BigDecimal.class);
        final BigDecimal askSize = fixture.create(BigDecimal.class);
        final BigDecimal askPrice = fixture.create(BigDecimal.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal lastSalePrice = fixture.create(BigDecimal.class);
        final BigDecimal lastSaleSize = fixture.create(BigDecimal.class);
        final Long lastSaleTime = fixture.create(Long.class);
        final Long lastUpdated = fixture.create(Long.class);
        final String sector = fixture.create(String.class);
        final String securityType = fixture.create(String.class);

        final TOPS tops = new TOPS(symbol, marketPercent, bidSize, bidPrice, askSize, askPrice, volume,
                lastSalePrice, lastSaleSize, lastSaleTime, lastUpdated, sector, securityType);

        assertThat(tops.getSymbol()).isEqualTo(symbol);
        assertThat(tops.getMarketPercent()).isEqualTo(marketPercent);
        assertThat(tops.getBidSize()).isEqualTo(bidSize);
        assertThat(tops.getBidPrice()).isEqualTo(bidPrice);
        assertThat(tops.getAskSize()).isEqualTo(askSize);
        assertThat(tops.getAskPrice()).isEqualTo(askPrice);
        assertThat(tops.getVolume()).isEqualTo(volume);
        assertThat(tops.getLastSalePrice()).isEqualTo(lastSalePrice);
        assertThat(tops.getLastSaleSize()).isEqualTo(lastSaleSize);
        assertThat(tops.getLastSaleTime()).isEqualTo(lastSaleTime);
        assertThat(tops.getLastUpdated()).isEqualTo(lastUpdated);
        assertThat(tops.getSector()).isEqualTo(sector);
        assertThat(tops.getSecurityType()).isEqualTo(securityType);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(TOPS.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TOPS.class))
                .verify();
    }

}
