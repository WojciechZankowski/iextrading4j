package pl.zankowski.iextrading.samples;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;
import pl.zankowski.iextrading.client.IEXTradingClient;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class TOPSExample {

    public static void main(String[] args) {
        IEXTradingClient iexTradingClient = IEXTradingClient.create();

        requestAllTOPS(iexTradingClient);
        requestColumnFilteredAllTOPS(iexTradingClient);

        requestSymbolFilteredTOPS(iexTradingClient);
        requestSymbolAndColumnFilteredTOPS(iexTradingClient);

        requestAllLastTrades(iexTradingClient);
        requestColumnFilteredAllLastTrades(iexTradingClient);

        requestSymbolFilteredLastTrades(iexTradingClient);
        requestSymbolAndColumnFilteredLastTrades(iexTradingClient);
    }

    private static void requestAllTOPS(IEXTradingClient iexTradingClient) {
        TOPS[] allTOPS = iexTradingClient.getTopsEndpoint().requestTOPS();
        Arrays.stream(allTOPS).forEach(System.out::println);
    }

    private static void requestColumnFilteredAllTOPS(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("marketPercent")
                .with("lastSaleSize")
                .build();
        TOPS[] allTOPS = iexTradingClient.getTopsEndpoint().requestTOPS(requestFilter);
        Arrays.stream(allTOPS).forEach(System.out::println);
    }

    private static void requestSymbolFilteredTOPS(IEXTradingClient iexTradingClient) {
        TOPS[] filteredTOPS = iexTradingClient.getTopsEndpoint().requestTOPS("BCM", "IBM");
        Arrays.stream(filteredTOPS).forEach(System.out::println);
    }

    private static void requestSymbolAndColumnFilteredTOPS(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("marketPercent")
                .with("lastSaleSize")
                .build();
        TOPS[] filteredTOPS = iexTradingClient.getTopsEndpoint().requestTOPS(requestFilter,"BCM", "IBM");
        Arrays.stream(filteredTOPS).forEach(System.out::println);
    }

    private static void requestAllLastTrades(IEXTradingClient iexTradingClient) {
        LastTrade[] allLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades();
        Arrays.stream(allLastTrades).forEach(System.out::println);
    }

    private static void requestColumnFilteredAllLastTrades(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("price")
                .build();
        LastTrade[] allLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades(requestFilter);
        Arrays.stream(allLastTrades).forEach(System.out::println);
    }

    private static void requestSymbolFilteredLastTrades(IEXTradingClient iexTradingClient) {
        LastTrade[] filteredLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades("BCM", "IBM");
        Arrays.stream(filteredLastTrades).forEach(System.out::println);
    }

    private static void requestSymbolAndColumnFilteredLastTrades(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("price")
                .build();
        LastTrade[] filteredLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades(requestFilter,"BCM", "IBM");
        Arrays.stream(filteredLastTrades).forEach(System.out::println);
    }

}
