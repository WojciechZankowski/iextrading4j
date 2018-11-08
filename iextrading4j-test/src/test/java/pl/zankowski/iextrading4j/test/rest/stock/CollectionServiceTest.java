package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CollectionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CollectionType;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectionServiceTest extends BaseRestServiceTest {

    @Test
    public void sectorCollectionServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/collection/sector?collectionName=Financials"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/CollectionResponse.json")));


        final List<Quote> quoteList = iexTradingClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.SECTOR)
                .withCollectionName("Financials")
                .build());

        assertThat(quoteList).hasSize(1);
        assertQuote(quoteList.get(0));
    }

    @Test
    public void tagCollectionServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/collection/tag?collectionName=Technology"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/CollectionResponse.json")));


        final List<Quote> quoteList = iexTradingClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.TAG)
                .withCollectionName("Technology")
                .build());

        assertThat(quoteList).hasSize(1);
        assertQuote(quoteList.get(0));
    }

    @Test
    public void listCollectionServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/collection/list?collectionName=iexvolume"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/CollectionResponse.json")));


        final List<Quote> quoteList = iexTradingClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.LIST)
                .withCollectionName("iexvolume")
                .build());

        assertThat(quoteList).hasSize(1);
        assertQuote(quoteList.get(0));
    }


    private void assertQuote(final Quote quote) {
        assertThat(quote.getSymbol()).isEqualTo("INTC");
        assertThat(quote.getCompanyName()).isEqualTo("Intel Corporation");
        assertThat(quote.getPrimaryExchange()).isEqualTo("Nasdaq Global Select");
        assertThat(quote.getSector()).isEqualTo("Technology");
        assertThat(quote.getCalculationPrice()).isEqualTo("tops");
        assertThat(quote.getOpen()).isEqualTo(BigDecimal.valueOf(45.56));
        assertThat(quote.getOpenTime()).isEqualTo(1510929000505L);
        assertThat(quote.getClose()).isEqualTo(BigDecimal.valueOf(45.65));
        assertThat(quote.getCloseTime()).isEqualTo(1510866000405L);
        assertThat(quote.getLatestPrice()).isEqualTo(BigDecimal.valueOf(44.88));
        assertThat(quote.getLatestSource()).isEqualTo("IEX real time price");
        assertThat(quote.getLatestTime()).isEqualTo("1:27:00 PM");
        assertThat(quote.getLatestUpdate()).isEqualTo(1510943220257L);
        assertThat(quote.getLatestVolume()).isEqualTo(BigDecimal.valueOf(42417913));
        assertThat(quote.getIexRealtimePrice()).isEqualTo(BigDecimal.valueOf(44.88));
        assertThat(quote.getIexRealtimeSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(quote.getIexLastUpdated()).isEqualTo(1510943220257L);
        assertThat(quote.getDelayedPrice()).isEqualTo(BigDecimal.valueOf(44.915));
        assertThat(quote.getDelayedPriceTime()).isEqualTo(1510942387434L);
        assertThat(quote.getExtendedPrice()).isEqualTo(BigDecimal.valueOf(187.64));
        assertThat(quote.getExtendedChange()).isEqualTo(BigDecimal.valueOf(-0.08));
        assertThat(quote.getExtendedChangePercent()).isEqualTo(BigDecimal.valueOf(-0.00042));
        assertThat(quote.getExtendedPriceTime()).isEqualTo(1526936340405L);
        assertThat(quote.getPreviousClose()).isEqualTo(BigDecimal.valueOf(45.65));
        assertThat(quote.getChange()).isEqualTo(BigDecimal.valueOf(-0.77));
        assertThat(quote.getChangePercent()).isEqualTo(BigDecimal.valueOf(-0.01687));
        assertThat(quote.getIexMarketPercent()).isEqualTo(BigDecimal.valueOf(0.01284));
        assertThat(quote.getIexVolume()).isEqualTo(BigDecimal.valueOf(544646));
        assertThat(quote.getAvgTotalVolume()).isEqualTo(BigDecimal.valueOf(28593541));
        assertThat(quote.getIexBidPrice()).isEqualTo(BigDecimal.valueOf(44.88));
        assertThat(quote.getIexBidSize()).isEqualTo(BigDecimal.valueOf(300));
        assertThat(quote.getIexAskPrice()).isEqualTo(BigDecimal.valueOf(44.91));
        assertThat(quote.getIexAskSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(quote.getMarketCap()).isEqualTo(BigDecimal.valueOf(210038400000L));
        assertThat(quote.getPeRatio()).isEqualTo(BigDecimal.valueOf(14.11));
        assertThat(quote.getWeek52High()).isEqualTo(BigDecimal.valueOf(47.3));
        assertThat(quote.getWeek52Low()).isEqualTo(BigDecimal.valueOf(33.23));
        assertThat(quote.getYtdChange()).isEqualTo(BigDecimal.valueOf(0.24726775956284144));
    }

}
