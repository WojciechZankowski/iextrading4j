package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DEEPTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal marketPercent = fixture.create(BigDecimal.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal lastSalePrice = fixture.create(BigDecimal.class);
        final BigDecimal lastSaleSize = fixture.create(BigDecimal.class);
        final Long lastSaleTime = fixture.create(Long.class);
        final Long lastUpdated = fixture.create(Long.class);
        final List<BookEntry> bids = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class, 2));
        final List<BookEntry> asks = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class, 2));
        final SystemEvent systemEvent = fixture.create(SystemEvent.class);
        final TradingStatus tradingStatus = fixture.create(TradingStatus.class);
        final OpHaltStatus opHaltStatus = fixture.create(OpHaltStatus.class);
        final SsrStatus ssrStatus = fixture.create(SsrStatus.class);
        final SecurityEvent securityEvent = fixture.create(SecurityEvent.class);
        final List<Trade> trades = Lists.newArrayList(fixture.collections()
                .createCollection(Trade.class, 2));
        final List<Trade> tradeBreaks = Lists.newArrayList(fixture.collections()
                .createCollection(Trade.class, 2));
        final Auction auction = fixture.create(Auction.class);
        final OfficialPrice officialPrice = fixture.create(OfficialPrice.class);

        final DEEP deep = new DEEP(symbol, marketPercent, volume, lastSalePrice, lastSaleSize, lastSaleTime,
                lastUpdated, bids, asks, systemEvent, tradingStatus, opHaltStatus, ssrStatus,
                securityEvent, trades, tradeBreaks, auction, officialPrice);

        assertThat(deep.getSymbol()).isEqualTo(symbol);
        assertThat(deep.getMarketPercent()).isEqualTo(marketPercent);
        assertThat(deep.getVolume()).isEqualTo(volume);
        assertThat(deep.getLastSalePrice()).isEqualTo(lastSalePrice);
        assertThat(deep.getLastSaleSize()).isEqualTo(lastSaleSize);
        assertThat(deep.getLastSaleTime()).isEqualTo(lastSaleTime);
        assertThat(deep.getLastUpdated()).isEqualTo(lastUpdated);
        assertThat(deep.getBids()).isEqualTo(bids);
        assertThat(deep.getAsks()).isEqualTo(asks);
        assertThat(deep.getSystemEvent()).isEqualTo(systemEvent);
        assertThat(deep.getTradingStatus()).isEqualTo(tradingStatus);
        assertThat(deep.getOpHaltStatus()).isEqualTo(opHaltStatus);
        assertThat(deep.getSsrStatus()).isEqualTo(ssrStatus);
        assertThat(deep.getSecurityEvent()).isEqualTo(securityEvent);
        assertThat(deep.getTrades()).isEqualTo(trades);
        assertThat(deep.getTradeBreaks()).isEqualTo(tradeBreaks);
        assertThat(deep.getAuction()).isEqualTo(auction);
        assertThat(deep.getOfficialPrice()).isEqualTo(officialPrice);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DEEP.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DEEP.class))
                .verify();
    }

}
