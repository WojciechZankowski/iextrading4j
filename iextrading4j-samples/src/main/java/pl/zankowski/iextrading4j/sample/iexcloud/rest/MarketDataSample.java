package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.marketdata.*;
import pl.zankowski.iextrading4j.client.*;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MarketDataSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final MarketDataSample sampleSuite = new MarketDataSample();

        sampleSuite.bookRequestSample();
        // sampleSuite.deepRequestSample();
        sampleSuite.lastTradeRequestSample();
        sampleSuite.opHaltStatusRequestSample();
        sampleSuite.officialPriceRequestSample();
        // sampleSuite.securityEventRequestSample();
        sampleSuite.ssrStatusRequestSample();
        sampleSuite.systemEventRequestSample();
        sampleSuite.topsRequestSample();
        sampleSuite.tradeBreakRequestSample();
        sampleSuite.tradeRequestSample();
        sampleSuite.tradingStatusRequestSample();
        sampleSuite.auctionRequestSample();
    }

    private void bookRequestSample() {
        final Map<String, Book> books = cloudClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .withSymbol("SNAP")
                .build());
        System.out.println(books);
    }

    private void deepRequestSample() {
        final DEEP deep = cloudClient.executeRequest(new DeepRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(deep);
    }

    private void histRequestSample() {
        final Map<String, List<HIST>> histMap = cloudClient.executeRequest(new HistRequestBuilder()
                .build());
        System.out.println(histMap);
    }

    private void histParameterizedRequestSample() {
        final List<HIST> histList = cloudClient.executeRequest(new HistRequestBuilder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());
        System.out.println(histList);
    }

    private void lastTradeRequestSample() {
        final List<LastTrade> lastTradeList = cloudClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(lastTradeList);
    }

    private void opHaltStatusRequestSample() {
        final Map<String, OpHaltStatus> opHaltStatuses = cloudClient.executeRequest(new OpHaltStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(opHaltStatuses);
    }

    private void officialPriceRequestSample() {
        final Map<String, OfficialPrice> officialPriceMap = cloudClient.executeRequest(new OfficialPriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(officialPriceMap);
    }

    private void securityEventRequestSample() {
        final Map<String, SecurityEvent> securityEvent = cloudClient.executeRequest(new SecurityEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(securityEvent);
    }

    private void ssrStatusRequestSample() {
        final Map<String, SsrStatus> ssrStatus = cloudClient.executeRequest(new SsrStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ssrStatus);
    }

    private void systemEventRequestSample() {
        final SystemEvent systemEvent = cloudClient.executeRequest(new SystemEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(systemEvent);
    }

    private void topsRequestSample() {
        final List<TOPS> tops = cloudClient.executeRequest(new TopsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(tops);
    }

    private void tradeBreakRequestSample() {
        final Map<String, List<Trade>> tradeBreak = cloudClient.executeRequest(new TradeBreakRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(tradeBreak);
    }

    private void tradeRequestSample() {
        final Map<String, List<Trade>> trade = cloudClient.executeRequest(new TradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(trade);
    }

    private void tradingStatusRequestSample() {
        final Map<String, TradingStatus> tradingStatus = cloudClient.executeRequest(new TradingStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(tradingStatus);
    }

    private void auctionRequestSample() {
        final Map<String, Auction> auction = cloudClient.executeRequest(new AuctionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(auction);
    }

}
