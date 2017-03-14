package pl.zankowski.iextrading.samples;

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
        requestFilteredTOPS(iexTradingClient);
        requestAllLastTrades(iexTradingClient);
        requestFilteredLastTrades(iexTradingClient);
    }

    private static void requestAllTOPS(IEXTradingClient iexTradingClient) {
        TOPS[] allTOPS = iexTradingClient.getTopsEndpoint().requestTOPS();
        Arrays.stream(allTOPS).forEach(System.out::println);
    }

    private static void requestFilteredTOPS(IEXTradingClient iexTradingClient) {
        TOPS[] filteredTOPS = iexTradingClient.getTopsEndpoint().requestTOPS("BCM", "IBM");
        Arrays.stream(filteredTOPS).forEach(System.out::println);
    }

    private static void requestAllLastTrades(IEXTradingClient iexTradingClient) {
        LastTrade[] allLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades();
        Arrays.stream(allLastTrades).forEach(System.out::println);
    }

    private static void requestFilteredLastTrades(IEXTradingClient iexTradingClient) {
        LastTrade[] filteredLastTrades = iexTradingClient.getTopsEndpoint().requestLastTrades("BCM", "IBM");
        Arrays.stream(filteredLastTrades).forEach(System.out::println);
    }

}
