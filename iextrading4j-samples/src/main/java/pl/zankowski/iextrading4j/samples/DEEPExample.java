package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.deep.*;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.deep.request.DEEPRequest;

import java.util.Map;

/**
 * @author Wojciech Zankowski
 */
public class DEEPExample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        DEEPExample deepExample = new DEEPExample();
        deepExample.testDEEPRequest();
        deepExample.testBookRequest();
        deepExample.testTradesRequest();
        deepExample.testSystemEventRequest();
        deepExample.testTradingStatusRequest();
        deepExample.testOpHaltStatusRequest();
        deepExample.testSsrStatusRequest();
        deepExample.testSecurityEventRequest();
        deepExample.testTradeBreaksRequest();
    }

    private void testDEEPRequest() {
        DEEP deep = iexTradingClient.getDeepEndpoint().requestDEEP(DEEPRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(deep);
    }

    private void testBookRequest() {
        Map<String, Book> books = iexTradingClient.getDeepEndpoint().requestBook(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(books);
    }

    private void testTradesRequest() {
        Map<String, Trade[]> trades = iexTradingClient.getDeepEndpoint().requestTrades(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(trades);
    }

    private void testSystemEventRequest() {
        SystemEvent systemEvent = iexTradingClient.getDeepEndpoint().requestSystemEvent(DEEPRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(systemEvent);
    }

    private void testTradingStatusRequest() {
        Map<String, TradingStatus> tradingStatusMap = iexTradingClient.getDeepEndpoint().requestTradingStatus(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(tradingStatusMap);
    }

    private void testOpHaltStatusRequest() {
        Map<String, OpHaltStatus> opHaltStatusMap = iexTradingClient.getDeepEndpoint().requestOpHaltStatus(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(opHaltStatusMap);
    }

    private void testSsrStatusRequest() {
        Map<String, SsrStatus> ssrStatusMap = iexTradingClient.getDeepEndpoint().requestSsrStatus(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(ssrStatusMap);
    }

    private void testSecurityEventRequest() {
        Map<String, SecurityEvent> securityEventMap = iexTradingClient.getDeepEndpoint().requestSecurityEvent(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(securityEventMap);
    }

    private void testTradeBreaksRequest() {
        Map<String, Trade[]> tradeBreaksMap = iexTradingClient.getDeepEndpoint().requestTradeBreaks(DEEPRequest.builder()
                .withSymbol("AAPL")
                .withSymbol("snap")
                .build());
        System.out.println(tradeBreaksMap);
    }

}
