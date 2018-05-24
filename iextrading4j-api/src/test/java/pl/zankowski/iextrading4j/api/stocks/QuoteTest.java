package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class QuoteTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final String primaryExchange = fixture.create(String.class);
        final String sector = fixture.create(String.class);
        final String calculationPrice = fixture.create(String.class);
        final BigDecimal open = fixture.create(BigDecimal.class);
        final Long openTime = fixture.create(Long.class);
        final BigDecimal close = fixture.create(BigDecimal.class);
        final Long closeTime = fixture.create(Long.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final BigDecimal latestPrice = fixture.create(BigDecimal.class);
        final String latestSource = fixture.create(String.class);
        final String latestTime = fixture.create(String.class);
        final Long latestUpdate = fixture.create(Long.class);
        final BigDecimal latestVolume = fixture.create(BigDecimal.class);
        final BigDecimal iexRealtimePrice = fixture.create(BigDecimal.class);
        final BigDecimal iexRealtimeSize = fixture.create(BigDecimal.class);
        final Long iexLastUpdated = fixture.create(Long.class);
        final BigDecimal delayedPrice = fixture.create(BigDecimal.class);
        final Long delayedPriceTime = fixture.create(Long.class);
        final BigDecimal extendedPrice = fixture.create(BigDecimal.class);
        final BigDecimal extendedChange = fixture.create(BigDecimal.class);
        final BigDecimal extendedChangePercent = fixture.create(BigDecimal.class);
        final Long extendedPriceTime = fixture.create(Long.class);
        final BigDecimal previousClose = fixture.create(BigDecimal.class);
        final BigDecimal change = fixture.create(BigDecimal.class);
        final BigDecimal changePercent = fixture.create(BigDecimal.class);
        final BigDecimal iexMarketPercent = fixture.create(BigDecimal.class);
        final BigDecimal iexVolume = fixture.create(BigDecimal.class);
        final BigDecimal avgTotalVolume = fixture.create(BigDecimal.class);
        final BigDecimal iexBidPrice = fixture.create(BigDecimal.class);
        final BigDecimal iexBidSize = fixture.create(BigDecimal.class);
        final BigDecimal iexAskPrice = fixture.create(BigDecimal.class);
        final BigDecimal iexAskSize = fixture.create(BigDecimal.class);
        final BigDecimal marketCap = fixture.create(BigDecimal.class);
        final BigDecimal peRatio = fixture.create(BigDecimal.class);
        final BigDecimal week52High = fixture.create(BigDecimal.class);
        final BigDecimal week52Low = fixture.create(BigDecimal.class);
        final BigDecimal ytdChange = fixture.create(BigDecimal.class);

        final Quote quote = new Quote(symbol, companyName, primaryExchange, sector, calculationPrice, open,
                openTime, close, closeTime, high, low, latestPrice, latestSource, latestTime, latestUpdate,
                latestVolume, iexRealtimePrice, iexRealtimeSize, iexLastUpdated, delayedPrice, delayedPriceTime,
                extendedPrice, extendedChange, extendedChangePercent, extendedPriceTime, previousClose, change,
                changePercent, iexMarketPercent, iexVolume, avgTotalVolume, iexBidPrice, iexBidSize, iexAskPrice,
                iexAskSize, marketCap, peRatio, week52High, week52Low, ytdChange);

        assertThat(quote.getSymbol()).isEqualTo(symbol);
        assertThat(quote.getCompanyName()).isEqualTo(companyName);
        assertThat(quote.getPrimaryExchange()).isEqualTo(primaryExchange);
        assertThat(quote.getSector()).isEqualTo(sector);
        assertThat(quote.getCalculationPrice()).isEqualTo(calculationPrice);
        assertThat(quote.getOpen()).isEqualTo(open);
        assertThat(quote.getOpenTime()).isEqualTo(openTime);
        assertThat(quote.getClose()).isEqualTo(close);
        assertThat(quote.getCloseTime()).isEqualTo(closeTime);
        assertThat(quote.getHigh()).isEqualTo(high);
        assertThat(quote.getLow()).isEqualTo(low);
        assertThat(quote.getLatestPrice()).isEqualTo(latestPrice);
        assertThat(quote.getLatestSource()).isEqualTo(latestSource);
        assertThat(quote.getLatestTime()).isEqualTo(latestTime);
        assertThat(quote.getLatestUpdate()).isEqualTo(latestUpdate);
        assertThat(quote.getLatestVolume()).isEqualTo(latestVolume);
        assertThat(quote.getIexRealtimePrice()).isEqualTo(iexRealtimePrice);
        assertThat(quote.getIexRealtimeSize()).isEqualTo(iexRealtimeSize);
        assertThat(quote.getIexLastUpdated()).isEqualTo(iexLastUpdated);
        assertThat(quote.getDelayedPrice()).isEqualTo(delayedPrice);
        assertThat(quote.getDelayedPriceTime()).isEqualTo(delayedPriceTime);
        assertThat(quote.getExtendedPrice()).isEqualTo(extendedPrice);
        assertThat(quote.getExtendedChange()).isEqualTo(extendedChange);
        assertThat(quote.getExtendedChangePercent()).isEqualTo(extendedChangePercent);
        assertThat(quote.getExtendedPriceTime()).isEqualTo(extendedPriceTime);
        assertThat(quote.getPreviousClose()).isEqualTo(previousClose);
        assertThat(quote.getChange()).isEqualTo(change);
        assertThat(quote.getChangePercent()).isEqualTo(changePercent);
        assertThat(quote.getIexMarketPercent()).isEqualTo(iexMarketPercent);
        assertThat(quote.getIexVolume()).isEqualTo(iexVolume);
        assertThat(quote.getAvgTotalVolume()).isEqualTo(avgTotalVolume);
        assertThat(quote.getIexBidPrice()).isEqualTo(iexBidPrice);
        assertThat(quote.getIexBidSize()).isEqualTo(iexBidSize);
        assertThat(quote.getIexAskPrice()).isEqualTo(iexAskPrice);
        assertThat(quote.getIexAskSize()).isEqualTo(iexAskSize);
        assertThat(quote.getMarketCap()).isEqualTo(marketCap);
        assertThat(quote.getPeRatio()).isEqualTo(peRatio);
        assertThat(quote.getWeek52High()).isEqualTo(week52High);
        assertThat(quote.getWeek52Low()).isEqualTo(week52Low);
        assertThat(quote.getYtdChange()).isEqualTo(ytdChange);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Quote.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Quote.class))
                .verify();
    }

}
