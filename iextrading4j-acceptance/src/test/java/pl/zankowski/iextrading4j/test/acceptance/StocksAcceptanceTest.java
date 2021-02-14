package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.api.stocks.ThresholdSecurities;
import pl.zankowski.iextrading4j.api.stocks.TimeSeries;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OhlcMarketRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OhlcRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ShortInterestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ThresholdSecuritiesRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TimeSeriesRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class StocksAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void bookRequestAcceptanceTest() {
        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(book).isNotNull();
    }

    @Test
    public void effectiveSpreadAcceptanceTest() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(effectiveSpreads).isNotNull();
    }

    @Test
    public void venueVolumeAcceptanceTest() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(venueVolumeList).isNotNull();
    }

    @Test
    public void ohlcAcceptanceTest() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());
        assertThat(ohlc).isNotNull();
    }

    @Test
    public void shortInterestAcceptanceTest() {
        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        assertThat(shortInterestList).isNotNull();
    }

    @Test
    public void timeSeriesAcceptanceTest() {
        final List<TimeSeries> timeSeriesList = iexTradingClient.executeRequest(new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build());
        assertThat(timeSeriesList).isNotNull();
    }

    @Test
    public void thresholdSecuritiesAcceptanceTest() {
        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        assertThat(thresholdSecuritiesList).isNotNull();
    }

    @Test
    public void ohlcMarketAcceptanceTest() {
        final Map<String, Ohlc> ohlcMap = iexTradingClient.executeRequest(new OhlcMarketRequestBuilder()
                .build());
        assertThat(ohlcMap).isNotNull();
    }

}
