package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.api.marketdata.DEEP;
import pl.zankowski.iextrading4j.api.marketdata.OfficialPrice;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEventType;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.DeepRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class DeepServiceTest extends BaseRestServiceTest {

    @Test
    public void deepServiceTest() {
        stubFor(get(urlEqualTo("/deep?symbols=SNAP"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/DeepResponse.json")));

        final DEEP deep = iexTradingClient.executeRequest(new DeepRequestBuilder()
                .withSymbol("SNAP")
                .build());

        assertThat(deep.getSymbol()).isEqualTo("SNAP");
        assertThat(deep.getMarketPercent()).isEqualTo(BigDecimal.valueOf(0.00833));
        assertThat(deep.getVolume()).isEqualTo(BigDecimal.valueOf(81454));
        assertThat(deep.getLastSalePrice()).isEqualTo(BigDecimal.valueOf(12.835));
        assertThat(deep.getLastSaleSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(deep.getLastSaleTime()).isEqualTo(1510943576182L);
        assertThat(deep.getLastUpdated()).isEqualTo(1510943602639L);

        final List<BookEntry> bidList = deep.getBids();
        final BookEntry firstBid = bidList.get(0);
        assertThat(firstBid.getPrice()).isEqualTo(BigDecimal.valueOf(12.84));
        assertThat(firstBid.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(firstBid.getTimestamp()).isEqualTo(1510961602639L);

        final List<BookEntry> askList = deep.getAsks();
        final BookEntry firstAsk = askList.get(0);
        assertThat(firstAsk.getPrice()).isEqualTo(BigDecimal.valueOf(13.22));
        assertThat(firstAsk.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(firstAsk.getTimestamp()).isEqualTo(1510961308975L);

        final SystemEvent systemEvent = deep.getSystemEvent();
        assertThat(systemEvent.getSystemEvent()).isEqualTo(SystemEventType.REGULAR_MARKET_HOURS_START);
        assertThat(systemEvent.getTimestamp()).isEqualTo(1510947000001L);

        final TradingStatus tradingStatus = deep.getTradingStatus();
        assertThat(tradingStatus.getStatus()).isEqualTo(TradingStatusType.TRADING_ON_IEX);
        assertThat(tradingStatus.getReason()).isEqualTo(TradingStatusReasonType.UNKNOWN);
        assertThat(tradingStatus.getTimestamp()).isEqualTo(1510939321339L);

        final OpHaltStatus opHaltStatus = deep.getOpHaltStatus();
        assertThat(opHaltStatus.isHalted()).isFalse();
        assertThat(opHaltStatus.getTimestamp()).isEqualTo(1510939321339L);

        final SsrStatus ssrStatus = deep.getSsrStatus();
        assertThat(ssrStatus.isSSR()).isFalse();
        assertThat(ssrStatus.getDetail()).isEqualTo(" ");
        assertThat(ssrStatus.getTimestamp()).isEqualTo(1510939321339L);

        final SecurityEvent securityEvent = deep.getSecurityEvent();
        assertThat(securityEvent.getSecurityEvent()).isEqualTo(SecurityEventType.MarketOpen);
        assertThat(securityEvent.getTimestamp()).isEqualTo(1510947000001L);

        final List<Trade> tradeList = deep.getTrades();
        final Trade trade = tradeList.get(0);
        assertThat(trade.getPrice()).isEqualTo(BigDecimal.valueOf(12.835));
        assertThat(trade.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(trade.getTradeId()).isEqualTo(364415895L);
        assertThat(trade.isISO()).isFalse();
        assertThat(trade.isOddLot()).isFalse();
        assertThat(trade.isOutsideRegularHours()).isFalse();
        assertThat(trade.isSinglePriceCross()).isFalse();
        assertThat(trade.isTradeThroughExempt()).isFalse();
        assertThat(trade.getTimestamp()).isEqualTo(1510961576182L);

        final List<Trade> tradeBreaks = deep.getTradeBreaks();
        assertThat(tradeBreaks).isEmpty();

        final Auction auction = deep.getAuction();
        assertThat(auction.getAuctionType()).isNull();
        assertThat(auction.getPairedShares()).isNull();
        assertThat(auction.getImbalanceShares()).isNull();
        assertThat(auction.getReferencePrice()).isNull();
        assertThat(auction.getIndicativePrice()).isNull();
        assertThat(auction.getAuctionBookPrice()).isNull();
        assertThat(auction.getCollarReferencePrice()).isNull();
        assertThat(auction.getLowerCollarPrice()).isNull();
        assertThat(auction.getUpperCollarPrice()).isNull();
        assertThat(auction.getExtensionNumber()).isNull();
        assertThat(auction.getStartTime()).isNull();
        assertThat(auction.getLastUpdate()).isNull();

        final OfficialPrice officialPrice = deep.getOfficialPrice();
        assertThat(officialPrice.getTimestamp()).isNull();
        assertThat(officialPrice.getPrice()).isNull();
        assertThat(officialPrice.getPriceType()).isNull();
    }

}
