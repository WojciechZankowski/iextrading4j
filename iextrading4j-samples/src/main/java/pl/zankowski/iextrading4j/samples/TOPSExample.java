package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.request.TOPSRequest;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class TOPSExample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        TOPSExample topsExample = new TOPSExample();

        topsExample.requestAllTOPS();
        topsExample.requestColumnFilteredAllTOPS();

        topsExample.requestSymbolFilteredTOPS();
        topsExample.requestSymbolAndColumnFilteredTOPS();

        topsExample.requestAllLastTrades();
        topsExample.requestColumnFilteredAllLastTrades();

        topsExample.requestSymbolFilteredLastTrades();
        topsExample.requestSymbolAndColumnFilteredLastTrades();
    }

    private void requestAllTOPS() {
        TOPS[] allTOPS = iexTradingClient.getTopsEndpoint().requestTOPS(TOPSRequest.builder()
                .withAllSymbols()
                .build());
        Arrays.stream(allTOPS).forEach(System.out::println);
    }

    private void requestColumnFilteredAllTOPS() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("marketPercent")
                .with("lastSaleSize")
                .build();
        TOPS[] allTOPS = iexTradingClient.getTopsEndpoint().requestTOPS(TOPSRequest.builder()
                .withRequestFilter(requestFilter)
                .withAllSymbols()
                .build());
        Arrays.stream(allTOPS).forEach(System.out::println);
    }

    private void requestSymbolFilteredTOPS() {
        TOPS[] filteredTOPS = iexTradingClient.getTopsEndpoint().requestTOPS(TOPSRequest.builder()
                .withSymbols("BCM", "IBM")
                .build());
        Arrays.stream(filteredTOPS).forEach(System.out::println);
    }

    private void requestSymbolAndColumnFilteredTOPS() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("marketPercent")
                .with("lastSaleSize")
                .build();
        TOPS[] filteredTOPS = iexTradingClient.getTopsEndpoint().requestTOPS(TOPSRequest.builder()
                .withRequestFilter(requestFilter)
                .withSymbols("BCM", "IBM")
                .build());
        Arrays.stream(filteredTOPS).forEach(System.out::println);
    }

    private void requestAllLastTrades() {
        LastTrade[] allLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades(TOPSRequest.builder()
                .withAllSymbols()
                .build());
        Arrays.stream(allLastTrades).forEach(System.out::println);
    }

    private void requestColumnFilteredAllLastTrades() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("price")
                .build();
        LastTrade[] allLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades(TOPSRequest.builder()
                .withRequestFilter(requestFilter)
                .withAllSymbols()
                .build());
        Arrays.stream(allLastTrades).forEach(System.out::println);
    }

    private void requestSymbolFilteredLastTrades() {
        LastTrade[] filteredLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades(TOPSRequest.builder()
                .withSymbols("BCM", "IBM")
                .build());
        Arrays.stream(filteredLastTrades).forEach(System.out::println);
    }

    private void requestSymbolAndColumnFilteredLastTrades() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("price")
                .build();
        LastTrade[] filteredLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades(TOPSRequest.builder()
                .withRequestFilter(requestFilter)
                .withSymbols("BCM", "IBM")
                .build());
        Arrays.stream(filteredLastTrades).forEach(System.out::println);
    }

}
